package com.orange.timber;

import android.annotation.SuppressLint;
import android.os.Environment;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import timber.log.Timber;

/**
 * @Description:
 * @Author: orange
 * @Date: 2020/10/15 11:17 AM
 */
public final class CrashReportingTree extends Timber.Tree {

    /**
     * 自己处理对应的日志信息
     *
     * @param priority 级别
     * @param tag      tag
     * @param message  message
     * @param t        错误信息
     */
    @Override
    protected void log(int priority, @Nullable final String tag, @NotNull final String message, @Nullable final Throwable t) {
        try {
            saveLogcat(tag, message, t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 保存日志
     */
    @SuppressLint("LogNotTimber")
    private void saveLogcat(@Nullable String tag, @NotNull String message, @Nullable Throwable t) throws Exception {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        sb.append(sdf.format(new Date())).append("  日志：");
        sb.append("[").append(tag).append("] {").append(message).append("}\n\n\n\n");

        // 目录
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + TimberApp.context.getPackageName() + File.separator + "log");
        if (dir.exists() || dir.mkdirs()) {
            SimpleDateFormat fileFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            FileOutputStream fos = new FileOutputStream(new File(dir, fileFormat.format(new Date())), true);
            fos.write(sb.toString().getBytes());
            fos.flush();
            fos.close();
        }
    }
}

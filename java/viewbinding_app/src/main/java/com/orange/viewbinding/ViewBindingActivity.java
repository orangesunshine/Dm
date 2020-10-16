package com.orange.viewbinding;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.orange.viewbinding.databinding.ActivityMainBinding;


/**
 * @Description:
 * @Author: orange
 * @Date: 2020/9/30 3:08 PM
 */
public class ViewBindingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(inflate.getRoot());
        inflate.btnSave.setOnClickListener(v -> Toast.makeText(ViewBindingActivity.this,"保存",Toast.LENGTH_LONG).show());
    }
}

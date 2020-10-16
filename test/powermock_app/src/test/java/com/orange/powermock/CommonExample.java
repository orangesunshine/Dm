package com.orange.powermock;

import java.io.File;

/**
 * @Description:
 * @Author: orange
 * @Date: 2020/10/16 5:05 PM
 */
public class CommonExample {
    public boolean callArgumentInstance(File file) {
        return file.exists();
    }
}

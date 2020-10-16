package com.orange.databinding;

/**
 * @Description:
 * @Author: orange
 * @Date: 2020/10/8 2:53 PM
 */
public class JavaPoint {
    public int x;
    public int y;

    public JavaPoint(int x ,int y){
        this.x = x;
        this.y = y;
    }

    public JavaPoint plus(JavaPoint p){
        return  new JavaPoint(x + p.x, y + p.y);
    }

    public JavaPoint plus(int p){
        return  new JavaPoint(x + p, y + p);
    }

    @Override
    public String toString() {
        return "x = " + x + " , y = " + y;
    }
}

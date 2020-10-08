package com.orange.databinding;

import org.jetbrains.annotations.NotNull;

public interface Java extends Language{
    //提供具体访问器的属性
    @NotNull
    String getField();

    public static final class DefaultImpls {
        @NotNull
        public static String getField(Java $this) {
            return "";
        }
    }
}

class JavaImpl implements Java{

    @NotNull
    @Override
    public String getField() {
        return null;
    }

    @Override
    public void use() {

    }
}

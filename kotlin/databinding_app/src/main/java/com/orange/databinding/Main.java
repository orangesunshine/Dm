package com.orange.databinding;

import java.util.ArrayList;
//import com.orange.databinding.JoinStringKt;
import com.orange.databinding.JoinString4JavaKt;

class Main {
    public static void main(String[] args) {
        new JoinString().joinToString(new ArrayList<>());
        new JoinString().joinToString(new ArrayList<>(), "");
        ///JoinStringKt.joinToString()
        JoinString4JavaKt.firstChar("haha");
    }
}

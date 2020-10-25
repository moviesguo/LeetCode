package com.moviesguo.leetcode;

public class Single {

    private Single() { }

    public static Single getInstance() {
        return Holder.instance;
    }

    private static class Holder{
        public static Single instance = new Single();
    }

}



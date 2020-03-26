package com.moviesguo.leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 For example, given n = 3, a solution set is:
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "", 0, 0, n);
        return list;
    }

    /*
    递归的思路，每一次都是要先加上'(',这种思路要记住，代码的执行顺序很重要，可以在一定的范围内控制结果，
    l代表左括号的个数，r代表右括号的个数，判断：左括号的个数不大于n，那么就可以递归执行，可以想到的一个运行结果就是
    对称的一个括号，当这个结果出来之后，又跳回上一次递归的执行，此时的l=n-1，那么就会出现不同的情况，所以结果的顺序
    会是最后一个结果为()-------，这样的结果
     */

    public void generate(List<String> list, String str, int l, int r,int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (l<max) generate(list, str + "(", l + 1, r, max);
        if (l>r) generate(list,str+")",l,r+1,max);

    }

}

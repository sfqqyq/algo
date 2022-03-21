package com.itsqq.recursion;

/**
 * @author sfqqyq
 * @date 2022年03月21日 1:39 下午
 * @desc 递归的应用
 * 有n个台阶，每次只能走1个或者2个台阶，一共有多少个走法。
 */
public class RecursionApp {
    // n=1 > 1 > 1
    // n=2 > 1+1,2 > 2
    // n=3 > 1+1+1,1+2,2+1 >3
    // f(n) = f(n-1) + f(n-2);

    /**
     * @desc 方法n
     * @author sfqqyq
     * @date 2022/3/21 1:40 下午
     * @param n n个台阶
     * @return int
     */
    public int f(int n){
        if(n==1) return 1;
        if(n==2) return 2;

        return f(n-1)+f(n-2);
    }

    public static void main(String[] args) {
        RecursionApp recursionApp = new RecursionApp();
        // 递归深度不能太深，否则会出现堆栈溢出风险
        int f = recursionApp.f(1000);
        System.out.println(f);
    }
}

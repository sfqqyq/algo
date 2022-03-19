package com.itsqq.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sfqqyq
 * @date 2022年03月17日 2:59 下午
 * @desc 栈的应用
 * - 表达式求值的应用
 * - 校验括号是否匹配
 */
public class StackApplication {

    // 算式计算
    public int formulaCalculation(/*算式字符串*/String formula){

        new Thread();

        LinkedListStack<String> numberStack = new LinkedListStack<>();
        LinkedListStack<String> symbolStack = new LinkedListStack<>();

        List<String> list = splitFormula(formula);

        for (String s : list) {
            if (isNumber(s)){ // 如果是数字那么就放在数字栈中
                numberStack.push(s);
            }else { // 如果是符号需要进行比较
                symbolCompareOrCalculate(numberStack,symbolStack,s);
            }
        }
        String data1 = numberStack.pop();
        String data2 = numberStack.pop();
        numberStack.push(calculate(data2,data1,symbolStack.pop()));

        return Integer.parseInt(numberStack.pop());
    }
    /**
     * @desc 符号比较或计算数据
     * @author sfqqyq
     * @date 2022/3/18 10:23 上午
     * @param numberStack 数字栈
     * @param symbolStack 符号栈
     * @param symbol 符号
     */
    public void symbolCompareOrCalculate(LinkedListStack<String> numberStack,LinkedListStack<String> symbolStack,String symbol){
        // 获取 符号栈 顶 符号元素
        String stackTopSymbol = symbolStack.pop();// 符号栈顶符号
        // 比较优先级
        int priority = comparePriority(symbol,stackTopSymbol);
        if(priority == 0){// 优先级相同或者低
            // 从操作数栈中取出两个数，然后用符号栈顶的符号进行计算，将结果压入数据栈顶
            String data1 = numberStack.pop();
            String data2 = numberStack.pop();
            String data=calculate(data2,data1,stackTopSymbol); // 计算数据
            numberStack.push(data);// 将计算后的数据压入数据栈顶
            // 然后再用当前符号和符号栈顶符号进行比较，在进行判断
            symbolCompareOrCalculate(numberStack,symbolStack,symbol);
        }else if(priority == 1 || priority == -1){ // 优先级比栈顶高 ,将当前符号放入栈顶
            if(stackTopSymbol!=null){
                symbolStack.push(stackTopSymbol);
            }
            symbolStack.push(symbol);
        }
    }

    /**
     * @desc 计算数据
     * @author sfqqyq
     * @date 2022/3/18 10:31 上午
     * @param data1 数据1
     * @param data2 数据2
     * @param stackTopSymbol 需要进行计算的数据符号
     * @return java.lang.String
     */
    private String calculate(String data1, String data2, String stackTopSymbol) {
        int data1int = Integer.parseInt(data1);
        int data2int = Integer.parseInt(data2);
        if(stackTopSymbol.equals("+"))return String.valueOf(data1int+data2int);
        if(stackTopSymbol.equals("-"))return String.valueOf(data1int-data2int);
        if(stackTopSymbol.equals("x"))return String.valueOf(data1int*data2int);
        if(stackTopSymbol.equals("/"))return String.valueOf(data1int/data2int);
        return null;
    }

    public List<String> splitFormula(String formula){
        String str= "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < formula.length() ; i++) {
            char c = formula.charAt(i);
            if((c >= '0' && c <= '9') ||"\\.".equals(c+"")){
                str+=c;
            }else {
                list.add(str);
                list.add(String.valueOf(c));
                str="";
            }
            if(i==formula.length()-1){
                list.add(str);
            }
        }
        return list;
    }

    // 比较运算符优先级
    public int comparePriority(String symbol1,String symbol2){
        if(symbol1==null || symbol2==null) return -1;
        List<String> list1= Arrays.asList("+","-");
        List<String> list2= Arrays.asList("x","/");
        if(list1.contains(symbol1)&&list1.contains(symbol2))return 0;
        if(list2.contains(symbol1)&&list2.contains(symbol2))return 0;
        if(list1.contains(symbol1)&&list2.contains(symbol2))return 0;
        if(list2.contains(symbol1)&&list1.contains(symbol2))return 1;
        return -1;
    }

    // 判断是不是数字
    public boolean isNumber(String str){
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        StackApplication stackApplication = new StackApplication();
//        List<String> list = stackApplication.splitFormula("31+51x8-6");
//        for (String str:list){
//            System.out.print(str+",");
//        }
//        System.out.println(list);
        int value = stackApplication.formulaCalculation("12/3+8x2+3");
        System.out.println(value);
    }
}

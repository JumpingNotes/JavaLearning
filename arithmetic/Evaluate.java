package arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 简单的运算表达式解释器
 * Dijikstra双栈算术表达式求值算法
 * @author 鱼唇的人类
 * @date 2017/5/21
 * @time 11:58
 */
public class Evaluate {
    public static void  main(String[]args){
        String expr="(1+((2+3)*(4*5)))";
        //先在运算符前后添加空格，然后按空格来拆分为数组
        List<String> exprList=Arrays.asList(expr.replaceAll("([/\\+\\-\\*\\(\\)])", " $1 ").trim().split("\\s+"));
        Stack<String> ops=new Stack<>();
        Stack<Double> val=new Stack<>();
        exprList.stream().forEach((e)->{
            switch (e){
                case "(":break;
                case "+":ops.push(e);break;
                case "-":ops.push(e);break;
                case "*":ops.push(e);break;
                case "/":ops.push(e);break;
                case ")":
                    double value=val.pop();
                    switch (ops.pop()){
                        case "+":value=val.pop()+value;break;
                        case "-":value=val.pop()-value;break;
                        case "*":value=val.pop()*value;break;
                        case "/":value=val.pop()/value;break;
                    }
                    val.push(value);
                    break;
                default:
                    val.push(Double.parseDouble(e));
            }
        });
        System.out.println(val.pop());
    }
}

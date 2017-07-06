package arithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO 正则表达式
 * @author 鱼唇的人类
 * @date 2017/5/22
 * @time 18:49
 */
public class RegularExpression {
    public static void main(String[] args) {
        String str="abccdabdc";
        str="1+2*sqrt(9.83)";
        String regex="([0-9]+\\.[0-9]+)|[0-9]+|sqrt|\\+|\\*|\\/|\\-|\\(|\\)";
        print(str,regex);
        str="233er444lee@qq.com23312";
        regex="[a-z]+@([a-z]+\\.)+(com|cn|edu)";
        print(str,regex);
        regex="[$_A-Za-z][$_A-Za-z0-9]*";
        str="_$As_ss";
        print(str,regex);

    }

    public static void print(String str,String regex){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}

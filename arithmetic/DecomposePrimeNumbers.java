package arithmetic;

import java.util.Scanner;

/**
 * 分解素数
 * @author 鱼唇的人类
 * @date 2017/4/10
 * @time 14:00
 */
public class DecomposePrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result=decompose(n);
        System.out.println(result);
    }

    /**
     * 分解素数
     * num从2(k，最大到num/2)开始取余数，如果余数为0，则将数赋值为num/k,并重新从2开始取余数；
     * 最后不可分解的num为最后一个素数。
     * @param num
     * @return
     */
    public static String decompose(int num){
        StringBuffer result=new StringBuffer();
        for (int k = 2; k <= num / 2; k++) {
            if (num % k == 0) {
                result.append(k+"*");
                num =num / k;
                k = 1;
            }
        }
        result.append(num);
        return result.toString();
    }
}

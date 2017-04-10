package arithmetic.sort;

import java.util.Arrays;

/**
 * @author 鱼唇的人类
 * @date 2017/4/10
 * @time 14:04
 */
public class Sort {
    public static int arr[]={9,4,2,5,7,1,0,3,7,4,2};
    private static int correct[]={0,1,2,2,3,4,4,5,7,7,9};

    public static void main(String []args){
        //1.冒泡排序
        int array[]=arr.clone();
        bubbleSort(array);
        System.out.println("冒泡排序-"+ Arrays.toString(array)+":"+compareAsc(array));
        //2.快速排序
        array=arr.clone();
        quickSort(array,0,array.length-1);
        System.out.println("快速排序-"+ Arrays.toString(array)+":"+compareAsc(array));
        //3.插入排序
        array=arr.clone();
        insertSort(array);
        System.out.println("插入排序-"+ Arrays.toString(array)+":"+compareAsc(array));
    }

    /**
     * TODO 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort(int numbers[]){
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++) {
//            System.out.println(numbers[i]);
            for(int j = 0 ;j < size-1-i ; j++) {
//                System.out.println(j+"|"+numbers[j]+"|"+numbers[j+1]+"|"+Arrays.toString(numbers));
                if(numbers[j] > numbers[j+1]){  //交换两数位置 控制正逆序
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] numbers,int low,int high){
        int start = low;
        int end = high;
        int key = numbers[low];
        while(end>start){
            //从后往前比较
            while(end>start&&numbers[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(numbers[end]<=key){
                int temp = numbers[end];
                numbers[end] = numbers[start];
                numbers[start] = temp;
            }
            //从前往后比较
            while(end>start&&numbers[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if(numbers[start]>=key){
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。
            //左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) quickSort(numbers,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) quickSort(numbers,end+1,high);//右边序列。从关键值索引+1到最后一个
    }

    /**
     * 1.找到第一个基值大的和第一个比基值小的，这两个互相交换
     * @param numbers
     * @param start
     * @param end
     */
    public static void quickSort2(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            System.out.println("---");
            System.out.println(base);
            do {
                System.out.println(i+"|"+j+"|"+Arrays.toString(numbers));
                while ((numbers[i] < base) && (i < end))
                    i++;
                System.out.println(i+"|"+numbers[i]);
                while ((numbers[j] > base) && (j > start))
                    j--;
                System.out.println(j+"|"+numbers[j]);
                if (i <= j) {
                    System.out.println("|交换|");
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort2(numbers, start, j);
            if (end > i)
                quickSort2(numbers, i, end);
        }
    }

    public static void insertSort(int[] numbers) {
        int size = numbers.length, temp, j;
        for(int i=1; i<size; i++) {
            temp = numbers[i];
            for(j = i; j > 0 && temp < numbers[j-1]; j--){
                numbers[j] = numbers[j-1];
            }
            numbers[j] = temp;
        }
    }


    public static boolean compareAsc(int a[]){
        if (correct.length!=a.length)
            return false;
        for (int i=0;i<correct.length;i++){
            if (correct[i]!=a[i])
                return false;
        }
        return true;
    }

    public static boolean compareDesc(int a[]){
        if (correct.length!=a.length)
            return false;
        for (int i=0;i<correct.length;i++){
            if (correct[(correct.length-1-i)]!=a[i])
                return false;
        }
        return true;
    }
}

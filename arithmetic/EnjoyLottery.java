package arithmetic;

/**
 * @author 鱼唇的人类
 * @date 2017/7/4
 * @time 14:42
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class EnjoyLottery {
    private static final String[] FRONT_AREA_POOL =
            {"1","2","3","4","5","6","7","8","9",
                    "10","11","12","13","14","15","16","17","18","19",
                    "20","21","22","23","24","25","26","27","28","29",
                    "30","31","32","33","34","35"};
    private static final String[] BACK_AREA_POOL =
            {"1","2","3","4","5","6","7","8","9",
                    "10","11","12"};

    public static void main(String []argc) {

        for (int i = 0; i < 10; i++) {
            System.out.print("--->");
            EnjoyLottery daletouLottery = new EnjoyLottery();
            Lottery injectLottery = daletouLottery.injectLottery();
            System.out.println(injectLottery.getNumber());
            System.out.println();
        }
    }

    public Lottery injectLottery(){
        Lottery lottery = new Lottery();
        return lottery;
    }

    private class Lottery{

        private static final int FRONT_LENTH = 5;
        private static final int BACK_LENTH = 2;
        private List<String> frontArea = new ArrayList<String>();

        private List<String> backArea = new ArrayList<String>();

        private Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {

                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        };

        public String getNumber(){
            for (; frontArea.size()<FRONT_LENTH;) {
                String pullUp = randomPullNumber("FRONT");
                if(frontArea.contains(pullUp)){
                    continue;
                }
                frontArea.add(pullUp);

            }

            for (; backArea.size() < BACK_LENTH; ) {
                String pullUp = randomPullNumber("BACK");
                if(backArea.contains(pullUp)){
                    continue;
                }
                this.backArea.add(pullUp);

            }
            Collections.sort(frontArea,comparator);
            Collections.sort(backArea,comparator);
            return frontArea + " : " + backArea;
        }

        private String randomPullNumber(String area){
            if("FRONT".equals(area)){
                int index =  0 + (new Random()).nextInt(FRONT_AREA_POOL.length - 0);
                return FRONT_AREA_POOL[index];
            }else if("BACK".equals(area)){
                int index =  0 + (new Random()).nextInt(BACK_AREA_POOL.length - 0);
                return BACK_AREA_POOL[index];
            }else{
                throw new RuntimeException("pull number fail. area is " + area);
            }
        }
    }
}
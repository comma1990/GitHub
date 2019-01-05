package commaTools.utils.common;

public class RandomDataUtils {
    /**
     * 获取指定范围内的随机数，范围为：start-end
     * Math.random()的范围是[0.0,1.0),10与之相乘结果范围就是[0,10)
     */
    public static int getRandomIntNumber(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    public static long getRandomLongNumber(int start, int end) {
        return (long) (Math.random() * (end - start + 1) + start);
    }

    /**
     * 定义手机号起始位置，调用split方法切割(括号里正则表达式，指定匹配规则)
     */
    public static String[] mobileFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public static String getRandomMobile() {
        int index = getRandomIntNumber(0, mobileFirst.length - 1);//获取索引随机值
        String first = mobileFirst[index];
        String second = String.valueOf(getRandomIntNumber(1, 888) + 10000).substring(1);//定义中间四位数字的范围
        String third = String.valueOf(getRandomIntNumber(1, 9100) + 10000).substring(1);//定义后四位数字的范围
        return first + second + third;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getRandomIntNumber(10, 20));
            System.out.println(getRandomMobile());
        }
    }
}

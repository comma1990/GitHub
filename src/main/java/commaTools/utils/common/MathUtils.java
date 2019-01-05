package commaTools.utils.common;

public class MathUtils {
    /**
     * int类型数据的求和
     *
     * @param x
     * @return
     */
    public static int sum(int... x) {
        int sum = 0;
        for (int a : x) {
            sum += a;
        }
        return sum;
    }

    /**
     * Float类型数据的求和
     *
     * @param x
     * @return
     */
    public static float sum(float... x) {
        float sum = 0;
        for (float a : x) {
            sum += a;
        }
        return sum;
    }

    /**
     * double类型数据的求和
     *
     * @param x
     * @return
     */
    public static double sum(double... x) {
        double sum = 0;
        for (double a : x) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5, 6));
    }
}

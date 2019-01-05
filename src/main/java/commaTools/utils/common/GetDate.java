package commaTools.utils.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * 获取时间工具类
 */
public class GetDate {
    /**
     * 获取当前日期，格式为yyyy=MM=dd
     *
     * @return
     */
    public static String getNowDate() {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = simpleDateFormat.format(rightNow.getTime());
        return dateNow;
    }

    public static void main(String[] args) {
        System.out.println(getNowDate());
    }
}

package commaTools.utils.common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public static String regex(String regex, String content, int i, int j) {
        Pattern pattern = Pattern.compile(regex);//regex 正则表达式
        Matcher matcher = pattern.matcher(content);//content 被匹配的内容
        List<String> list = new ArrayList<>();
        /**
         * matcher.group(x),x值得是第几次的匹配结果，如下：
         * System.out.println(RegexUtils.regex("(:=)(.*)", "P33326:=4****************8", 0,0));
         *x=0时，取的值是(:=)(.*)匹配出来的结果【:=4****************8】
         * x=1，取的值是(:=)匹配出来的结果【:=】
         * x=2,取的值是(.*)匹配出来的结果【4****************8】
         */
        while (matcher.find()) {
            list.add(matcher.group(j));//如果有匹配的字符串，拿出来放到list里面
        }
        if (list.size() >= 1)
            return list.get(i);//取出list数组中第i个元素
        return null;
    }

    /**
     * 给定一个字符串s，以及正则表达式regex，能匹配出结果返回true，否则返回false
     *
     * @param s
     * @param regex
     * @return
     */

    public static boolean stringMatches(String s, String regex) {
        return s.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(regex("(\\d+@)(\\d+@)", "98163@8035@qq.com", 0, 0));

        System.out.println(RegexUtils.regex("(:=)(.*)", "P33326:=4****************8", 0, 2));

        System.out.println(stringMatches("xiaohonghua", ".*hong.*"));//.任意字符串  * 匹配零次或多次
    }
}

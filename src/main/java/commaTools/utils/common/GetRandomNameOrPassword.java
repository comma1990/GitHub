package commaTools.utils.common;

/**
 * 将文本文件存入到集合中，随机获取一个值
 * 用途：将来做批量登录时，可以将用户名存储到TXT文件中，每行只存储一个数据，密码存储到另一个TXT文件中，顺序需和前面保持一致，通过同一个索引index获取，即可登录
 * 数据源：直接从数据库搜索出来即可
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GetRandomNameOrPassword {
    public static String getRandomNameOrPassword(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> arrayList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            arrayList.add(line);
        }
        bufferedReader.close();
        //遍历数组集合
        for (String s : arrayList) {
            System.out.println(s);
        }
        System.out.println("--------");
        /**
         * 以下是随机获取文本文件中一个人的姓名
         */
        //随机产生一个索引
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        //根据索引获取一个值
        String name = arrayList.get(index);
        return name;

    }

    public static void main(String[] args) throws IOException {
        String name = getRandomNameOrPassword("F:\\迅雷下载\\InputStreamReader.txt");
        System.out.println(name);
    }
}

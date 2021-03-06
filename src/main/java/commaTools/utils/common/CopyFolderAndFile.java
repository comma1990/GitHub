package commaTools.utils.common;

import java.io.*;

/**
 * @author comma
 * @version v1.0
 * @date 2019.01.06
 * 复制文件分析：
 *    1、获取被复制文件的路径名称
 *    2、在目的地创建一个相同名称的文件
 *    3、复制数据
 */
public class CopyFolderAndFile {
    /**
     * 复制文件及文件夹下面的数据
     * @param srcFile 被复制的文件或文件夹路径
     * @param destFile 目的地路径
     * @throws IOException
     */
    public static void copyFolder(File srcFile,File destFile) throws IOException {
        //判断是否是文件夹
        if (srcFile.isDirectory()){
            File newFolder=new File(destFile,srcFile.getName());
            newFolder.mkdir();

            //获取该File对象下所有的文件或者文件夹File对象
            File[] fileArray=srcFile.listFiles();
            for (File file:fileArray){
                copyFolder(file,newFolder);//递归调用本身的方法
            }
        }else {
            //如果是文件
            File newFile=new File(destFile,srcFile.getName());//定义一个新的名称，目的地目录+被复制文件的名称
            copyFile(srcFile,newFile);
        }
    }

    /**
     * 复制文件
     * @param srcFile 初始文件，被复制的对象
     * @param newFile 新文件，复制后的对象
     * @throws IOException
     */
    public static void copyFile(File srcFile,File newFile) throws IOException{
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(newFile));
        byte[] bytes=new byte[1024];
        int len;
        while ((len=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    public static void main(String[] args) {
        File srcFile=new File("F:\\GitHub");
        File destFile=new File("F:\\Gittest");
        try {
            copyFolder(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

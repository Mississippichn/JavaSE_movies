package edu.liu.util;

import java.util.Scanner;

public class ScannerUtill {

     private static Scanner scanner=new Scanner(System.in);

    //封装底层 返回String类型的line 为正确输入的字符
    public  static String readKeyboard(int limit,boolean blankReturn){
        String line="";
        while (scanner.hasNextLine()){
            line = scanner.nextLine();//读到的这一行
            line=line.trim();//防止空格影响对输入字符个数的判断

            // 1.判断当输入为空的情况是否敲回车返回
            if (line.length()==0){
                //如果允许输入为空的情况下返回空
                if (blankReturn){
                    return line;
                }else {
                    continue;
                }
            }
            //2.判断输入的长度是否满足要求
            if (line.length()>limit){
                System.out.println("输入的长度(应不大于"+limit+")有误，请重新输入");
                continue;
            }else{
                break;
            }
        }
        return line ;//不管咋样先return一个null，最后再去替换成真的要返回的值
    }
    
}

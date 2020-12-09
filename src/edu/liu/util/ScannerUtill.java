package edu.liu.util;

import edu.liu.service.MovieService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class ScannerUtill {

     private static Scanner scanner=new Scanner(System.in);

    /**
     * 读取指定长度的整数
     * @return
     */
     public static int readInt(){
         String str_int = readKeyboard(2, false);
         int i=0;
         while (true){
             try{
                 i = Integer.parseInt(str_int);
             }catch (Exception e){
                 System.out.println("序号类型输入有误，请重新输入");
                 continue;
             }
            break;
         }
         return i;
     }

    /**
     * 读上映日期（一个指定格式的类型）的方法
     * @param pattern 指定的日期类型
     * @return date
     */
     public static Date readDate(String pattern){
         Date date;
         while (true){
             String date_str = readKeyboard(pattern.length(),false);//从键盘返回的日期
             SimpleDateFormat sdf = new SimpleDateFormat(pattern);//格式就是我们在提示中给用户固定的格式
             try {
                date=sdf.parse(date_str);//解析输入的pattern格式的日期
             } catch (ParseException e) {//这个异常来自于输入的日期格式不对
                 System.out.println("时间格式输入有误，请重新输入");
                 continue;
             }
             break;
         }
         return date;
     }

    /**
     * 读上映日期（一个指定格式的类型）的方法
     * @param pattern 指定的日期类型
     * @return date
     */
    public static Date readDate(String pattern, Date defalutValue){
        Date date;
        while (true){
            String date_str = readKeyboard(pattern.length(),true);//从键盘返回的日期
            if (date_str.equals("")){
                return defalutValue;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);//格式就是我们在提示中给用户固定的格式
            try {
                date=sdf.parse(date_str);//解析输入的pattern格式的日期
            } catch (ParseException e) {//这个异常来自于输入的日期格式不对
                System.out.println("时间格式输入有误，请重新输入");
                continue;
            }
            break;
        }
        return date;
    }





    /**
     *从控制台读入一个字符串
     * @param limit 指定最大长度
     * @return
     */
     public static String readString(int limit){
         return readKeyboard(limit,false);
     }

    /**
     * 从控制台读入一个字符串，为空则返回默认值
     * @param limit
     * @param defaultValue 直接敲回车返回的默认值
     * @return String
     */

    public static String readString(int limit,String defaultValue){
        String s1 = readKeyboard(limit, true);
        return s1.equals("")?defaultValue:s1;
    }




    /**
     * 从控制台输入选择的值
     * param 菜单最大序号
     * @return char
     */

    //主菜单只需要输入一个字符 1 2 3
    public static char readSelectMenu(int size){
         char ch;//这里的ch可以不赋值（按理说局部变量必须赋值），因为在14行被赋值了
         while (true){
             //判断这一个str是否等于1、2、3
             String str = readKeyboard(1, false);
             ch = str.charAt(0);

             boolean flag=true;
             for (int i=1;i<=size;i++){
                 flag=flag&&(ch!=(i+'0'));
                 if (!flag){
                     break;
                 }
             }
             if (flag){
                 System.out.println("输入不符合规定，请重新输入");
             }else {
                 break;
             }

         }
         return ch;
     }


    /**
     * 从控制台获得返回输入的满足条件的一行数据
     * @param limit 可以输入的最大字符数
     * @param blankReturn 在输入为空，是否可以敲回车直接返回空
     * @return String line 返回输入的满足条件的一行数据
     */

    //所有的东西都要从键盘中输入一行
    //封装底层 返回String类型的line 为正确输入的字符
    private static String readKeyboard(int limit,boolean blankReturn){
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

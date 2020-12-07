package edu.liu.view;

import java.util.Scanner;

public class MovieView {

    public void mainMenu() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("===========欢迎来到您的专属家庭影院系统===========");
            System.out.println("1.影片管理\t 2.查看所有影片\t 3.退出系统");
            System.out.println("===========请选择服务功能所对应的序号===========");
            int num = scanner.nextInt();
            if (num != 1 && num != 2 && num != 3) {
                System.out.println("您的输入不符合要求，请重新输入1-3的数字");
                continue;
            }
            chooseFirst(num);
            break;
        }
    }

    /**
     * 这是一级选择部分
     * @param choose
     */

    public static void chooseFirst(int choose) {
        switch (choose) {
            case 1:
                System.out.println("--------影片管理--------");
                break;
            case 2:
                System.out.println("--------查看所有影片--------");
                break;
            default:
                System.out.println("--------您正在退出系统--------");
                System.exit(0);//退出系统
        }
    }

}

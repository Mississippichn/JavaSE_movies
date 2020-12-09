package edu.liu.view;

import edu.liu.model.Movie;
import edu.liu.service.MovieService;
import edu.liu.util.ScannerUtill;

import java.util.Date;


public class MovieView {

    private static MovieService ms=new MovieService();

    public void mainMenu() {

        while (true) {
            System.out.println("===========欢迎来到您的专属家庭影院系统===========");
            System.out.println("1.影片管理\t 2.查看所有影片\t 3.退出系统");
            System.out.println("           请选择服务功能所对应的序号             ");
            char c = ScannerUtill.readSelectMenu(3);
            chooseFirst(c);
            break;
        }
    }

    /**
     * 这是一级选择部分
     * @param  choose
     */

    public  void chooseFirst(char choose) {
        switch (choose) {
            case '1':
                System.out.println("------------------影片管理-----------------------");
                System.out.println("1.上传影片\t 2.删除影片\t 3.修改影片\t 4.返回上一级");
                System.out.println("           请选择服务功能所对应的序号             ");
                char c = ScannerUtill.readSelectMenu(4);
                chooseFirst_upload(c);
                break;
            case '2':
                System.out.println("--------查看所有影片--------");
                break;
            default:
                System.out.println("--------您正在退出系统--------");
                System.exit(0);//退出系统
        }
    }

    /**
     * 影片管理
     * @param choose
     */

    public  void chooseFirst_upload(char choose) {
        switch (choose) {
            case '1':
                System.out.println("------------------上传影片-----------------------");
                System.out.println("------------------亲爱的，请输入影片相关信息-----------------------");
                Movie movie = addMovie();
                ms.addMovie(movie);
                break;
            case '2':
                System.out.println("------------------删除影片-----------------------");
                break;
            case '3':
                System.out.println("------------------修改影片-----------------------");
                break;
            default:
                break;
        }
    }

    /**
     * 控制台获取对象输入的电影的属性去构建电影对象
     * @return
     */

    public Movie addMovie(){

        System.out.println("------------------亲爱的，请输入影片名称-----------------------");
        String name = ScannerUtill.readString(5);//电影的名字5个字符以内

        System.out.println("------------------亲爱的，请输入影片类型-----------------------");
        String type = ScannerUtill.readString(4);//电影的类型4个字符以内

        System.out.println("------------------亲爱的，请输入影片主演-----------------------");
        String actor = ScannerUtill.readString(5);//电影的主演5个字符以内

        System.out.println("------------------亲爱的，请输入影片导演-----------------------");
        String director = ScannerUtill.readString(5);//电影的导演5个字符以内

        System.out.println("------------------亲爱的，请输入影片上映日期(yyyy-MM-dd)-----------------------");
        Date  date= ScannerUtill.readDate("yyyy-MM-dd");//电影的上映日期格式为yyyy-MM-dd

        //封装成Movie对象
        Movie movie = new Movie(0,name,type,actor,date,director,0,0);
        return movie;
    }


}

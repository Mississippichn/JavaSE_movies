package edu.liu.view;

import edu.liu.model.Movie;
import edu.liu.service.MovieService;
import edu.liu.util.RandomUtill;
import edu.liu.util.ScannerUtill;

import java.util.Date;
import java.util.List;


public class MovieView {

    private static MovieService ms = new MovieService();

    public void mainMenu() {

        System.out.println("===========欢迎来到您的专属家庭影院系统===========");
        while (true) {
            System.out.println("1.影片管理\t 2.查看所有影片\t 3.退出系统");
            System.out.println("              请选择功能所对应的序号             ");
            char c = ScannerUtill.readSelectMenu(3);
            chooseFirst(c);
//            break;
        }
    }

    /**
     * 这是一级选择部分
     *
     * @param choose
     */

    public void chooseFirst(char choose) {
        switch (choose) {
            case '1':
                System.out.println("--------------------影片管理---------------------");
                System.out.println("1.上传影片\t 2.删除影片\t 3.修改影片\t 4.返回上一级");
                System.out.println("              请选择功能所对应的序号             ");
                char c = ScannerUtill.readSelectMenu(4);
                chooseFirst_upload(c);
                break;
            case '2':
                System.out.println("--------查看所有影片--------");
                printMovies(ms.getMovies());
                //如果没有影片则返回
                if (ms.getMovies().size() == 0) {
                    return;
                }
                System.out.println();
                System.out.println();
                System.out.println("1.按条件搜索影片\t 2.影片排序\t 3.返回上一级");
                System.out.println("请选择序号：");
                char c1 = ScannerUtill.readSelectMenu(3);
                chooseFirst_search1(c1);

                break;
            default:
                System.out.println("--------您正在退出系统--------");
                System.exit(0);//退出系统
        }
    }

    /**
     * 电影查询
     *
     * @param choose
     */


    public void chooseFirst_search1(char choose) {
        switch (choose) {
            case '1':
                //按条件搜索影片
                 List<Movie> list=chooseFirst_search2();
                System.out.println("1.影片排序\t2.观看影片\t3.推荐影片\t4.返回上一级\t5.退出系统");
                char c = ScannerUtill.readSelectMenu(5);
                choose121(c);




                break;
            case '2':
                //影片排序


                break;

            default:
                System.exit(0);
                break;
        }
    }

    /**
     * 影片排序
     * @param c
     */

    public void choose121(char c){
        switch (c){
            case '1':
                //影片排序
                System.out.println("请选择排序类别");
                System.out.println("1.按名称\t2.按上映时间\t3.按类型\t4.按点击率\t5.按推荐率\t6.返回上一级");
                char c1 = ScannerUtill.readSelectMenu(6);
                ms.sort(c1,List);



                break;
            case '2':
                //观看影片

                break;
            case '3':
                //推荐影片

                break;
            case '4':
                break;
            default:
                break;

        }


    }






    /**
     *
     * 多条件查询影片,返回排序后的list集合
     */

    public List<Movie> chooseFirst_search2() {
        //按条件搜索影片
        System.out.println("输入查询条件值");

        System.out.println("              |Step1，请输入影片名称|");
        String name = ScannerUtill.readString(5, null);//电影的名字5个字符以内

        System.out.println("              |Step2，请输入影片类型|");
        String type = ScannerUtill.readString(4, null);//电影的类型4个字符以内

        System.out.println("              |Step3，请输入影片主演|");
        String actor = ScannerUtill.readString(5, null);//电影的主演5个字符以内

        System.out.println("输入的搜索条件为：");
        if (name != null) {
            System.out.println("\t影片名称：" + name);
        }
        if (type != null) {
            System.out.println("\t影片类型：" + type);
        }
        if (actor != null) {
            System.out.println("\t影片主演：" + actor);
        }
        if (name == null && type == null && actor == null) {
            System.out.println("          您没有输入条件");
        }
        System.out.println("1.搜索\t2.返回上一级");
        char c = ScannerUtill.readSelectMenu(2);
        List<Movie> list=null;
        if (c == '1') {
            list=ms.searchMovie(name,type,actor);
            printMovies(list);
        }
        return list;
    }


    /**
     * 影片管理
     *
     * @param choose
     */

    public void chooseFirst_upload(char choose) {
        switch (choose) {
            case '1':
                System.out.println("               -----上传影片-----");
                Movie movie = addMovie();
                ms.addMovie(movie);
                System.out.println("------------------影片上传成功-----------------------");
                break;
            case '2':
                System.out.println("               -----删除影片-----");
                printMovies(ms.getMovies());
                //如果没有影片则返回
                if (ms.getMovies().size() == 0) {
                    return;
                }
                System.out.println("              请选择要删除影片的序号             ");
                //判断输入的index是否存在
                Movie m = readIndex();
                boolean b = ms.removeMovie(m.getIndex());
                if (b) {
                    System.out.println("------------------影片删除成功-----------------------");
                }
                System.out.println();
                break;
            case '3':
                System.out.println("------------------修改影片-----------------------");
                printMovies(ms.getMovies());
                System.out.println("              请选择要修改影片的序号             ");
                Movie m1 = readIndex();

                Movie movie_update = updateMovie(m1);
                boolean r1 = ms.updateMovieByIndex_Obj(m1.getIndex(), movie_update);
                if (r1) {
                    System.out.println("------------------影片修改成功-----------------------");
                    System.out.println();
                }
                break;
            default:
                break;
        }
    }

    private Movie updateMovie(Movie movie) {//回写数据

        System.out.println("              |Step1，请输入影片名称|" + movie.getName());
        String name = ScannerUtill.readString(5, movie.getName());//电影的名字5个字符以内

        System.out.println("              |Step2，请输入影片类型|" + movie.getType());
        String type = ScannerUtill.readString(4, movie.getType());//电影的类型4个字符以内

        System.out.println("              |Step3，请输入影片主演|" + movie.getActor());
        String actor = ScannerUtill.readString(5, movie.getActor());//电影的主演5个字符以内

        System.out.println("              |Step4，请输入影片导演|" + movie.getDirector());
        String director = ScannerUtill.readString(5, movie.getDirector());//电影的导演5个字符以内

        System.out.println("              |Step5，请输入影片上映日期(yyyy-MM-dd)|" + movie.getDateStr());
        Date date = ScannerUtill.readDate("yyyy-MM-dd", movie.getDate());//电影的上映日期格式为yyyy-MM-dd

        //封装成Movie对象
        movie = new Movie(movie.getMid(), name, type, actor, date, director, movie.getClickRate(), movie.getRecoRate());
        return movie;
    }


    /**
     * 控制台获取对象输入的电影的属性去构建电影对象
     *
     * @return 新添加的movie对象
     */

    private Movie addMovie() {

        System.out.println("              |Step1，请输入影片名称|");
        String name = ScannerUtill.readString(5);//电影的名字5个字符以内

        System.out.println("              |Step2，请输入影片类型|");
        String type = ScannerUtill.readString(4);//电影的类型4个字符以内

        System.out.println("              |Step3，请输入影片主演|");
        String actor = ScannerUtill.readString(5);//电影的主演5个字符以内

        System.out.println("              |Step4，请输入影片导演|");
        String director = ScannerUtill.readString(5);//电影的导演5个字符以内

        System.out.println("              |Step5，请输入影片上映日期(yyyy-MM-dd)|");
        Date date = ScannerUtill.readDate("yyyy-MM-dd");//电影的上映日期格式为yyyy-MM-dd

        System.out.println("              |Step6，请输入影片的编号|");
        int mid = RandomUtill.randomId();
        //封装成Movie对象
        Movie movie = new Movie(mid, name, type, actor, date, director, 0, 0);
        return movie;
    }

    /**
     * 通过下标获取电影
     *
     * @return
     */
    private Movie readIndex() {
        Movie movieById;
        while (true) {
            int index = ScannerUtill.readInt();
            movieById = ms.getMovieById(index - 1);
            if (movieById == null) {
                System.out.println("电影序号不存在，请重新输入");
                continue;
            }
            movieById.setIndex(index);
            break;
        }
        return movieById;
    }


    /**
     * 查看所有影片，就是去遍历movies
     */
    private void printMovies(List<Movie> movies) {
        System.out.println("序号\t编号\t名称\t\t类型\t主演\t日期\t\t导演\t点击率\t推荐率");//表头

        if (movies.size() == 0) {
            System.out.println("                     暂无影片");
            return;
        }

        int i = 1;//加序号的操作，为了好删除
        for (Movie movie : movies) {
            System.out.println(i + "\t\t" + movie);
            i++;
        }
    }


}

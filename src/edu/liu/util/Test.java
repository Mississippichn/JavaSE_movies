package edu.liu.util;

import edu.liu.model.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

     private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws ParseException {
        Date date = ScannerUtill.readDate("2020/01/09");
        System.out.println(date);


    }
}

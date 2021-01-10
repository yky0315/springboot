package com.oracle.pojo;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        String[] strings = new String[]{"{","}","(",")","[","]"};
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <strings.length ; i++) {
            if(scanner.next().equals(strings[i])){

            }
        }
    }
}

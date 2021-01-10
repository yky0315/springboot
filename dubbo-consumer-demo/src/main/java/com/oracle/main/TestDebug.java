package com.oracle.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestDebug {
    public static void main(String[] args) {
        filter();
    }
    public static void filter(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        List collect =(List) arrayList.stream().collect(Collectors.toList());
        for (Object o : collect) {
            System.out.println(o);
        }
    }
}

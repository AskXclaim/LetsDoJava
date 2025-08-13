package com.advancetopics;

import static java.lang.System.*;

public  class Main {
    public static void main(String[] args) {
        var sample= new GenericList<String>(5);
        sample.add("A");
        sample.add("B");
        for(var item:sample){
            out.println(item);
        }
    }
}

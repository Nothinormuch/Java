package com.nothin;

import java.util.Scanner;
//import java.awt.*;
import java.text.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        if (args.length > 0) {
                System.out.print("The args you gave are: ");
            for(String arg : args) {
                System.out.print(arg+", ");
            }
                System.out.print("nothin else!");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.countingvowelsmaven;

/**
 *
 * @author Rafael Penczkoski
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here

        String inputFileName = "test.txt";
        String outputFileName = "output.txt";

        if (args.length > 0 && args[0] != null) {
            inputFileName = args[0];
        }
        if (args.length > 1 && args[1] != null) {
            outputFileName = args[1];
        }
        CountingVowels.readFile( inputFileName, outputFileName);
    }

}

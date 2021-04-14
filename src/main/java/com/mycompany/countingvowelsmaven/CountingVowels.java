/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.countingvowelsmaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Penczkoski
 */
public class CountingVowels {

    static void readFile(String inputFileName, String outputFileName) {
        try {
            // check if file exists
            File inputFile = new File(inputFileName);
            if (!inputFile.exists() || inputFile.isDirectory()) {
                throw new FileNotFoundException("Input file not found.");
            }

            // reads the content
            BufferedReader br;
            br = new BufferedReader(new FileReader(inputFile));
            String st;
            StringBuilder inputText = new StringBuilder();
            while ((st = br.readLine()) != null) {
                inputText.append(st);
            }

            // count the vowels
            String outputText = countVowels(inputText.toString());

            // write the result
            File outputFile = new File(outputFileName);
            outputFile.createNewFile();
            FileWriter writer = new FileWriter(outputFile);
            writer.write(outputText);
            writer.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(CountingVowels.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(CountingVowels.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String countVowels(String inputText) {
        // clean special characters
        String[] cleanText = stringClean(inputText).split(" ");
        List<String> words = Arrays.asList(cleanText);

        // create the dictionary
        HashMap<Integer, List<String>> dictionary = new HashMap<>();
        words.forEach((word) -> {
            Integer index = word.length();
            if (dictionary.get(index) == null) {
                dictionary.put(index, new ArrayList<>());
            }
            dictionary.get(index).add(word);
        });

        // count the occurrences and build the output result
        StringBuilder outputText = new StringBuilder();
        dictionary.entrySet().forEach((entry) -> {
            ArrayList<Character> vowels = new ArrayList<>();
            entry.getValue().forEach((word) -> {
                for (int i = 0; i < word.length(); i++) {
                    Character c = word.charAt(i);
                    if (isVowel(c)) {
                        vowels.add(c);
                    }
                }
            });
            Double average = (double) vowels.size() / (double) entry.getValue().size();
            Set<Character> vowelsSet = new HashSet<>(vowels);
            outputText.append(String.format("(%s, %d) -> %.1f\n", vowelsSet.toString(), entry.getKey(), average));
        });

        return outputText.toString();
    }

    public static boolean isVowel(Character c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static String stringClean(String s) {
        return s.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }
}

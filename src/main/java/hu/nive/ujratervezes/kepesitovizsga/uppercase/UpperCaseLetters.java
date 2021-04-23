package hu.nive.ujratervezes.kepesitovizsga.uppercase;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UpperCaseLetters {

    public int getNumberOfUpperCase(String s) {
        String access = "src/main/resources/" + s;
        Path path = Path.of(access);
        int counter = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)){
            String line;
            while ((line = bufferedReader.readLine())  != null) {
                counter = getUppercaseInOneLine(counter, line);
            }
        return counter;
        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read file!", e);
        }
    }

    private int getUppercaseInOneLine(int counter, String line) {
        for (char c: line.toCharArray()) {
            for (char ch = 'A'; ch <= 'Z'; ch++){
               if (c == ch){
                   counter =  counter + 1;
               }
            }
        }
        return counter;
    }
}

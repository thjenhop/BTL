package com.company;

import java.util.Scanner;
import java.util.Vector;
import java.io.*;

public class DictionaryManagement {


    private Scanner scan = new Scanner(System.in);
    public  void insertFromCommandLine(Vector<Word> words){

        System.out.print("Enter number of Disctionary: ");
        int num = scan.nextInt();

        Word temp = new Word();

        for(int i = 0; i < num; i++){
            System.out.println("Word:" + i + 1);
            System.out.print("Enter English word: ");

            temp.setWord_target(scan.nextLine());

            System.out.print("Enter Vietnamese mean: ");
            temp.setWord_explain(scan.nextLine());

            words.add(temp);

        }


    }
    public void insertFromFile(Vector<Word> words){
        // The name of the file to open.
        String fileName = "dictionaries.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);


            while((line = bufferedReader.readLine()) != null) {
                for(int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == ' ') {
                        String word = line.substring(i);
                        String mean = line.substring(i + 1, line.length());
                        i = line.length();
                        Word word1 = new Word(word, mean);
                        words.add(word1);
                    }
                }

               // System.out.println(line);
            }
            DictionaryCommandLine show = new DictionaryCommandLine();
            show.showAllWords(words);


            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}


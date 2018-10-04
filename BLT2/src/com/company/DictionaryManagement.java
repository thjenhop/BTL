package com.company;


import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.util.Scanner;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryManagement {


    String fileName = "dictionaries.txt";

    private Scanner scan = new Scanner(System.in);
    public  void insertFromCommandLine(ArrayList<Word> words){

        System.out.print("Enter number of Disctionary: ");
        int num = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i < num; i++){

            Word temp = new Word();

            System.out.println("Word:" + (i + 1));
            System.out.print("Enter English word: ");

            temp.setWord_target(scan.nextLine());

            System.out.print("Enter Vietnamese mean: ");
            temp.setWord_explain(scan.nextLine());

            words.add(temp);

        }
        DictionaryCommandLine option = new DictionaryCommandLine();
        option.showAllWords(words);



    }
    public void insertFromFile(ArrayList<Word> words){
        // The name of the file to open.



        // This will reference one line at a time
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null){
//                String wordLine[] = line.split(" ");
//                String target = wordLine[0];
//                String explain = wordLine[1];
//                if(wordLine.length<= 10) System.out.println(line);
//                String target;
//                String explain;
//                int i = 0;
//                while(line.charAt(i) != ' '){
//                    i++;
//                }
//                target = line.substring(0, i );
//                explain = line.substring(i + 3, line.length());

//                if(space(line)){
//                    Word w = convertStringToWord(line);
//                    words.add(w);
//                }
                //String wordLine[] = line.split(" ");
//                String target = wordLine[0];
//                String explain = wordLine[2];
//                if(wordLine.length<=3) System.out.println(line);
                Word w = convertStringToWord(line);
                words.add(w);

            }
            DictionaryCommandLine option = new DictionaryCommandLine();
            option.showAllWords(words);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return;
    }


    public Word dictionaryLookUp(List<Word> words){

        System.out.println("Please enter the English Word you want Lookup: ");
        String word = scan.nextLine();

       for(int i = 0; i < words.size(); i++){
           //System.out.println(words.get(i).getWord_target());
           if(words.get(i).getWord_target().equals(word)){

               return words.get(i);
           }
       }

        return new Word(word, "Not found in Dictionary");

    }



    public void addWord(List<Word> words){
        System.out.println("Adding new word in Dictinary\n");
        System.out.println("Enter word you want add: ");
        String word = scan.nextLine();
        System.out.println("Enter mean of word add: ");
        String mean = scan.nextLine();
        Word addWord = new Word(word, mean);
        words.add(addWord);
    }

    public void editWord(List<Word> words){

        System.out.println("Editing new word in Dictinary\n");
        System.out.println("Enter word you want edit: ");
        String word = scan.nextLine();

        System.out.println("Enter word after edit: ");
        String newWord = scan.nextLine();
        System.out.println("Enter mean of word after edit: ");
        String mean = scan.nextLine();
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).word_target.equals(word)){
                Word editWord = new Word(newWord, mean);
                words.set(i, editWord);
                System.out.println("Success edited");
                return;
            }
        }
        System.out.println("Error:" + word + " not in Dictionary");
        return;
    }


    public void deleteWord(ArrayList<Word> words){

        System.out.println("Enter word you want delete: ");
        String word = scan.nextLine();


        for(int i = 0; i < words.size(); i++){
            if(words.get(i).getWord_target().equals(word)){
                words.remove(i);
                System.out.println("Success Deleteed word in Dictionary: " + word);
                return;
            }

        }
        System.out.println("Error. Word " + word + " not in Dictionary" );
        return;
    }
    public Word convertStringToWord(String s){
        int i = 0;
        int first = 0;

        while(s.charAt(i) != ' ' && i < s.length()){
            i++;
        }
        String word = s.substring(first, i);



        while(s.charAt(i) == ' ' && i < s.length()){
            i++;
        }
        first = i;
        String mean = s.substring(first, s.length());

        return new Word(word, mean);
    }

    public boolean space(String s){
        int i = 0;
        int count = 0;
        while (s.charAt(i) == ' '){
            i++;
        }
        while (i < s.length()){
            if(s.charAt(i) == ' '){
                count++;
            }
            i++;
            if(count >= 3)
            {
                break;
            }
        }
        if(count < 3){
            return false;
        }
        return true;
    }



}

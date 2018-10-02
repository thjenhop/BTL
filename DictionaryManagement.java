package com.company;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.util.List;
import java.io.*;

public class DictionaryManagement {


    private Scanner scan = new Scanner(System.in);
    public  void insertFromCommandLine(List<Word> words){

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
    public void insertFromFile(List<Word> words){
        // The name of the file to open.
        String fileName = "C:\\Users\\Admin\\IdeaProjects\\BLT\\src\\com\\company\\dictionaries.txt";

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
                        String word = line.substring(0, i);
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
    public Word dictionaryLookUp(List<Word> words, String word){
       for(int i = 0; i < words.size(); i++){
           //System.out.println(words.get(i).getWord_target());
           if(words.get(i).getWord_target().equals(word)){

               return words.get(i);
           }
       }

        return new Word("", "");

    }
    public void  dictionaryAdvanced(List<Word> words){
        DictionaryManagement option = new DictionaryManagement();
        option.insertFromFile(words);

        DictionaryCommandLine options = new DictionaryCommandLine();

        System.out.println("Please enter the English Word you want Lookup: ");// chien binh lam
        String wordLookUp = scan.nextLine();

        Word word = option.dictionaryLookUp(words, wordLookUp);
        System.out.println(word.getWord_target() + "       | " +
                word.getWord_explain());



    }
    public void addWord(List<Word> words, Word addWord){


        words.add(addWord);
    }

    public void editWord(List<Word> words, String word, Word editWord){
        for(int i = 0; i < words.size(); i++){
            if(word == words.get(i).word_target){
                words.set(i, editWord);
                return;
            }
        }
        return;
    }

    public void deleteWord(List<Word> words){
        String word = wordInput("Delete");
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).getWord_target().equals(word)){
               words.remove(i);
               return;
            }

        }
    }

    public String wordInput(String option){
        System.out.println("Please enter the word you want " + option + ": ");
        String wordInput = scan.nextLine();
        return wordInput;
    }
//    public void sortWord(List<Word> words){
//        Word word = new Word();
//        Collections.sort(words);
//    }
}


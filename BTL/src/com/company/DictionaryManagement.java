package com.company;

import com.company.Word;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.Comparator;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public ArrayList<Word> insertFromFile(){
        // The name of the file to open.
        ArrayList<Word> words = new ArrayList<Word>();
        String fileName = "Libraries.txt";

        // This will reference one line at a time
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null){
                String wordLine[] = line.split(" ");
                String target = wordLine[0];
                String explain = wordLine[1];
                if(wordLine.length<=3) System.out.println(line);
                Word w = new Word(target, explain);
                words.add(w);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return words;
    }
    public boolean dictionaryLookUp(Dictionary library){
        List<Word> words = library.words; 
        int len = words.size();
        ArrayList<String> target = new ArrayList<String>();
        ArrayList<String> explain = new ArrayList<String>();
        for(int i = 0 ; i < len ; i++){
            target.add(words.get(i).word_target);
            explain.add(words.get(i).word_explain);
        }
        String word = null;
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter word to translate: ");
        word = inp.nextLine();
        int index = target.indexOf(word);
        if(index != -1){
            System.out.println("The mean of word is: " + explain.get(index));
            return true;
        }
        else{
            System.out.println("The word is not exist in dictionary");
            return false;
        }
        
    }
    
    
}


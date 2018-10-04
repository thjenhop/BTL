package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
//import java.util.
import java.util.Scanner;

public class DictionaryCommandLine {

    private Scanner scan = new Scanner(System.in);

    String fileName = "dictionaries.txt";

    public void showAllWords(ArrayList<Word> words){

        System.out.println("No     | English        | Vietnamese");
        for(int i = 0; i < words.size(); i++){
            System.out.println(i + 1 + "    | " + words.get(i).getWord_target() + "       | " +
                    words.get(i).getWord_explain() + " "  + words.get(i).getTypeWord() + " " +
                    words.get(i).getPronunciation());
        }

    }
    public void dictionaryBasic(ArrayList<Word> words){
        DictionaryManagement temp = new DictionaryManagement();
        temp.insertFromCommandLine(words);
        showAllWords(words);

    }

    public Word dictionarySearch(List<Word> words, String word){
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).getWord_target().equals(words)){
                return words.get(i);
            }
        }
        return new Word();

    }
    public void  dictionaryAdvanced(ArrayList<Word> words) {
        DictionaryManagement option = new DictionaryManagement();
        option.insertFromFile(words);

        DictionaryCommandLine options = new DictionaryCommandLine();

        Word word = option.dictionaryLookUp(words);
        System.out.println(word.getWord_target() + "       | " +
                word.getWord_explain());

    }

    public ArrayList<Word> dictionarySearch(ArrayList<Word> words){
        ArrayList<Word> ans = new ArrayList<Word>();
        System.out.println("Enter word you want search: ");

        String s = scan.nextLine();

        for(int i = 0; i < words.size(); i++){
            String subString = words.get(i).getWord_target().substring(0, s.length());
            if(subString.equals(s)){
                ans.add(words.get(i));
            }
        }

        showAllWords(ans);

        return ans;
    }

    public void dictionaryExportToFile(ArrayList<Word> words) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i = 0; i < words.size(); i++){

                printWriter.printf(words.get(i).getWord_target() + "    " + words.get(i).getWord_explain() + "\n");
            }
            //printWriter.print("Some String");

            printWriter.close();
            return;
        } catch (IOException e) {
            System.out.println("Can't ExporToFile .txt\n " + e.getMessage());
            return;
        }
    }
}

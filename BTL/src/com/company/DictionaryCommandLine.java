package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DictionaryCommandLine {
    private Dictionary dictionary;
    private DictionaryManagement dicManager;
    public DictionaryCommandLine(){
        dicManager = new DictionaryManagement();
        dictionary = new Dictionary();
        dictionary.words = dicManager.insertFromFile();
    }
    public void showAllWords(){
        ArrayList<Word> words = dictionary.words;
        System.out.println("No     | English        | Vietnamese");
        for(int i = 0; i < words.size(); i++){
            System.out.println(i + 1 + "    | " + words.get(i).getWord_target() + "       | " +
                    words.get(i).getWord_explain());
        }

    }
    public void dictionaryAdvanced(){
//        showAllWords();
        dicManager.dictionaryLookUp(dictionary);
    }
//    public void dictionaryBasic(List<Word> words){
//        showAllWords(words);
//        DictionaryManagement temp = new DictionaryManagement();
//        temp.insertFromCommandLine(words);
//    }
//
//    public Word dictionarySearch(List<Word> words, String word){
//        for(int i = 0; i < words.size(); i++){
//            if(words.get(i).getWord_target().equals(words)){
//                return words.get(i);
//            }
//        }
//        return new Word();
//
//    }

}

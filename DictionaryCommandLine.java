package com.company;
import java.util.List;
import java.util.Vector;

public class DictionaryCommandLine {

    public void showAllWords(List<Word> words){

        System.out.println("No     | English        | Vietnamese");
        for(int i = 0; i < words.size(); i++){
            System.out.println(i + 1 + "    | " + words.get(i).getWord_target() + "       | " +
                    words.get(i).getWord_explain());
        }

    }
    public void dictionaryBasic(List<Word> words){
        showAllWords(words);
        DictionaryManagement temp = new DictionaryManagement();
        temp.insertFromCommandLine(words);
    }

    public Word dictionarySearch(List<Word> words, String word){
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).getWord_target().equals(words)){
                return words.get(i);
            }
        }
        return new Word();

    }

}

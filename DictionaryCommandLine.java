package com.company.BTL;

import java.util.Vector;

public class DictionaryCommandLine {

    public void showAllWords(Vector<Word> words){

        System.out.println("No     | English        | Vietnamese");
        for(int i = 0; i < words.size(); i++){
            System.out.println(i + 1 + "    | " + words.get(i).getWord_target() + "       | " +
                    words.get(i).getWord_explain());
        }

    }
    public void dictionaryBasic(Vector<Word> words){
        showAllWords(words);
        DictionaryManagement temp = new DictionaryManagement();
        temp.insertFromCommandLine(words);
    }
}

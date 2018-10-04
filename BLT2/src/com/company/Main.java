package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DictionaryManagement option = new DictionaryManagement();
        DictionaryCommandLine dic = new DictionaryCommandLine();

        ArrayList<Word> words = new ArrayList<Word>();

        //dic.dictionaryBasic(words);
        //option.dictionaryAdvanced(words);
        option.insertFromFile(words);
        dic.dictionarySearch(words);

        //option.addWord(words);
        //option.editWord(words);
        dic.dictionaryExportToFile(words);
//        dic.showAllWords(words);
//

        //dic.showAllWords(words);
        //option.insertFromFile(dic.words);
//        Word addWord = new Word("Computer", "may tinh");
//        option.addWord(dic.words, addWord);
//        DictionaryCommandLine option2 = new DictionaryCommandLine();
    }
}

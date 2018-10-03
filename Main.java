package com.company;

public class Main {

    public static void main(String[] args) {

        DictionaryManagement option = new DictionaryManagement();
        Dictionary dic = new Dictionary();
        option.insertFromFile(dic.words);
//        Word addWord = new Word("Computer", "may tinh");
//        option.addWord(dic.words, addWord);
//        DictionaryCommandLine option2 = new DictionaryCommandLine();
    }
}

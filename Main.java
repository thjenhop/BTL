package com.company;

public class Main {

    public static void main(String[] args) {

        DictionaryManagement option = new DictionaryManagement();
        Dictionary dic = new Dictionary();
        option.insertFromFile(dic.words);
    }
}

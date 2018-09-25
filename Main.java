package com.company.BTL;
import com.company.BTL.Word;
import com.company.BTL.Dictionary;
import com.company.BTL.DictionaryManagement;
import com.company.BTL.DictionaryCommandLine;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DictionaryCommandLine temp = new DictionaryCommandLine();
        temp.dictionaryBasic(Dictionary.words);
    }
}

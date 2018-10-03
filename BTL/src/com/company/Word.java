package com.company;

import java.util.List;
public class Word {

    String word_target;
    /* new word */

    String word_explain;
    /* mean of word */
    String word_type;
    String word_pronun;
    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public Word(){

    }
    public Word(String word, String mean){
        this.setWord_target(word);
        this.setWord_explain(mean);
    }

}


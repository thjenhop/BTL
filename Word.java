package com.company;

import java.util.List;
public class Word {

    String word_target;
    /* new word */

    String word_explain;
    /* mean of word */

    String typeWord;
    /* type of word*/

    String pronunciation;
    /* pronuciation of word*/

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

    public String getTypeWord() {
        return typeWord;
    }

    public void setTypeWord(String typeWord) {
        this.typeWord = typeWord;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public Word(){

    }

    public Word(String word, String mean){
        this.setWord_target(word);
        this.setWord_explain(mean);
    }

    public Word(String word, String mean, String typeWord, String pronunciation){
        this(word, mean);
        setTypeWord(typeWord);
        setPronunciation(pronunciation);
    }

}


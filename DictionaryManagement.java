package com.company.BTL;
import java.util.Scanner;
import java.util.Vector;

public class DictionaryManagement {


    private Scanner scan = new Scanner(System.in);
    public  void insertFromCommandLine(Vector<Word> words){

        System.out.print("Enter number of Disctionary: ");
        int num = scan.nextInt();

        Word temp = new Word();

        for(int i = 0; i < num; i++){
            System.out.println("Word:" + i + 1);
            System.out.print("Enter English word: ");

            temp.setWord_target(scan.nextLine());

            System.out.print("Enter Vietnamese mean: ");
            temp.setWord_explain(scan.nextLine());

            words.add(temp);

        }


    }

}

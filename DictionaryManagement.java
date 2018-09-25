package com.company.BTL;
import java.util.Scanner;
import java.util.Vector;
//import com.company.BTL.Word.*;
//import com.company.BTL.

public class DictionaryManagement {


    private Scanner scan = new Scanner(System.in);
    public  void insertFromCommandLine(Vector<Word> words){

        System.out.print("Enter number of Disctionary: ");
        int num = scan.nextInt();
        scan.nextLine();



        for(int i = 0; i < num; i++){
            Word temp = new Word();
            System.out.println("Word:" + (i + 1));
            {
                System.out.print("Enter English word: ");
                String s = scan.nextLine();
                temp.setWord_target(s);
                s = "";

                System.out.print("Enter Vietnamese mean: ");
                String s2 = scan.nextLine();
                temp.setWord_explain(s2);
                s2 = "";
            }

            words.add(temp);
        }
    }
    public int setNum(){
        return scan.nextInt();
    }
    //public
    public void insertFromFile(String linkFile){

    }


}
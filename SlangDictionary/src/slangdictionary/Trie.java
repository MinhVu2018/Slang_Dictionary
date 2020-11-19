/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangdictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author MinhVu
 */
public class Trie{
    private TrieNode root;
    
    public void insert(String word){
        TrieNode curNode = root;
        
        
    }
};


//public class TestArray 
//{
//    Vector<String> list = new Vector();
//    String datapath = new String("Data/slang.txt");
//    
//    public Trie()
//    {
//        SetUp();
//    }
//    
//    public void SetUp()
//    {
//        try {
//            File myObj = new File(datapath);
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                list.add(data);
//        }
//        myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//    
//    public String Search(String s, int type)
//    {
//        String[] temp;
//        
//        for (int i=0; i<list.size(); i++)
//        {
//            temp = list.get(i).split("'");
//            if (s.equals(temp[0]) && type == 0)
//                return new String(temp[1]);
//            else if (s.equals(temp[1]) && type == 1)
//                return new String(temp[0]);
//        }
//        return new String("Cannotfound");
//    }
//    
//    public int getSize(){
//        return list.size();
//    }
//    
//    public String getData(int i){
//        return list.get(i);
//    }
//    
//    public void Display(){
//        for (int i=0; i<list.size(); i++)
//        {
//            System.out.println("here");
//            System.out.println(list.get(i));
//        }
//    }
//}

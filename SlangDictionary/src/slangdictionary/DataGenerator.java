/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangdictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author MinhVu
 */
public class DataGenerator {
    HashMap<String, String> SlangWordList = new HashMap<String, String>();
    HashMap<String, HashSet<String>> MeaningList = new HashMap<String, HashSet<String>>();
    
    void Create(String file_path){
        try {
            File myObj = new File(file_path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] temp = myReader.nextLine().split("`");
                
                SlangWordList.put(temp[0], temp[1]);
                CreateMeaningList(temp[0], temp[1].toLowerCase());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }    
    
    void CreateMeaningList(String word, String meaning){
        meaning = meaning.replace('|', ' ');
        String[] temp = meaning.split(" ");
        
        for(int i=0; i<temp.length; i++)
            if(temp[i].length() > 0)
            {
                if (!MeaningList.containsKey(temp[i]))
                    MeaningList.put(temp[i], new HashSet<String>());
                
                MeaningList.get(temp[i]).add(word);     
            }
    }
    
    String Search(String s, int type){
        if (type == 0)//Search for meaning
        {
            String ans = SlangWordList.get(s);
            if (ans == null)
                return "Cannot find";
            return ans;
        }
        
        if (s.isEmpty())
            return "Cannot find";
        
        
        s = s.toLowerCase();
        String[] temp = s.split(" ");

        HashSet<String> intersectionSet = new HashSet<>();
        intersectionSet.addAll(MeaningList.get(temp[0]));
        for(int i=1; i<temp.length; i++)
            intersectionSet.retainAll(MeaningList.get(temp[i])); 

        String t = intersectionSet.toString();
        temp = t.split(" ");
        String ans = new String();
        for(int i=0; i<temp.length; i++)
            ans += temp[i];
        return ans;
    }
    
    void Remove(String word){
        if (SlangWordList.get(word) == null)
            return;
        String meaning = SlangWordList.get(word).toLowerCase();
        meaning = meaning.replace('|', ' ');
        String[] temp = meaning.split(" ");
        
        for (int i=0; i<temp.length; i++)
            if (!temp[i].isBlank())
                MeaningList.get(temp[i]).remove(word);
        
        SlangWordList.remove(word);
    }
    
    void Add(String word, String meaning){
        SlangWordList.put(word.toLowerCase(), meaning);
    }
    
    void Edit(String word, String meaning){
        word = word.toLowerCase();
        if (Search(word, 0) == "Cannot find")
            return;
       
        Remove(word);
        Add(word, meaning);
    }
    
    void CreateQuiz(){
    }
    
    String[] DisplayRandom(){
        Random generator = new Random();
        List<String> keys = new ArrayList<String>(SlangWordList.keySet());
        String randomKey = keys.get(generator.nextInt(keys.size()) );
        String value = SlangWordList.get(randomKey);
        return new String[] {randomKey, value};
    }
    
}

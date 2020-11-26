/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangdictionary;

/**
 *
 * @author MinhVu
 */
public class SlangDictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        DataGenerator data = new DataGenerator();
//        data.readfile("Data/slang.txt");
        
        // call SlangFrame
        SlangFrame frame = new SlangFrame();
        
        // show frame
        frame.show();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
references:
https://stackoverflow.com/questions/9093448/how-to-capture-a-jframes-close-button-click-event
https://www.sanfoundry.com/java-program-create-frames-switch-frames-using-buttons/
*/

package slangdictionary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author MinhVu
 */
public class SlangDictionary implements ActionListener {

    /**
     * @param args the command line arguments
     */
    static SlangFrame frame1;
    static DuplicateAddFrame frame2;
    static DataGenerator data = new DataGenerator();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        data.Build();

        SlangDictionary obj = new SlangDictionary();
        
        frame1 = new SlangFrame(data);
        frame1.BtnAdd.addActionListener(obj);
        // show frame
        frame1.setVisible(true);
        
        frame1.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                data.SaveMeaningList();
                data.SaveSlangWordList();
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        String Word_Input = frame1.WordInput.getText().toUpperCase();
        String Def_Input = frame1.DefInput.getText();//.toLowerCase();
        String temp[] = data.Add(Word_Input, Def_Input);
        String button = e.getActionCommand();
        
        if (button.equals("Add"))
        {
            if (!Word_Input.trim().isEmpty() && !Def_Input.trim().isEmpty()){    
                
                if (temp.length == 2) // add new word
                    frame1.ResultOutput.setText("Add new word");
                else // override or dupplicate
                    create_frame2(temp);
                
                frame1.ResultOutput.setText("Add successful");
            }
            else
                frame1.ResultOutput.setText("Incorrect syntax"); 
        }
        if (button.equals("Duplicate")){
            data.AddSelection(temp[0], temp[2], "Duplicate");
            frame1.setVisible(true);
            frame2.dispose();
        }
        if (button.equals("Override")){
            data.AddSelection(temp[0], temp[2], "Override");
            frame1.setVisible(true);
            frame2.dispose();
        }
    }
    
    public static void create_frame2(String[] info){
        SlangDictionary obj = new SlangDictionary();
        frame2 = new DuplicateAddFrame();
        frame2.BtnOverride.addActionListener(obj);
        frame2.BtnDuplicate.addActionListener(obj);
        
        frame2.setInfo(info);
        frame2.showInfo();
        frame2.setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gralog.firstorderlogic.algorithm;

import gralog.firstorderlogic.logic.firstorder.formula.FirstOrderFormula;
import gralog.firstorderlogic.logic.firstorder.parser.FirstOrderParser;
import gralog.gralogfx.views.*;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author Hv
 */
@ViewDescription(forClass=FirstOrderProverParameters.class)
public class FirstOrderProverParametersView extends GridPaneView{

    public Set<String> getUniqueSearches(File f) throws Exception{
        Set<String> result=new HashSet<>();
        
        if(f.exists()){
            BufferedReader input = new BufferedReader(new FileReader(f));
            String tmp;
            while((tmp=input.readLine())!=null){
                result.add(tmp);
            }
            
        }
        return result;
    }
    
    public Set<String> getUsedVariables(String text){
        Set<String> usedVariables=new HashSet<>();
        String[] split = text.split("\\s+");
        for(String token : split){
            if( (token.length() == 1 )  &&  Character.isLetter(token.charAt(0) ) ) {
                 usedVariables.add(token);
            }  
        }
        return usedVariables;
    }
    
    @Override
    public void Update() {
        this.getChildren().clear();
        if(displayObject != null){
            FirstOrderProverParameters p =(FirstOrderProverParameters)displayObject;
            this.setVgap(8);
            this.setHgap(10);
            this.add(new Label("Formulae"), 0, 0);
            File file=new File("PreviousSearch.txt");
            String str="";
           
            if (file.exists()){
            
            try {
                
                BufferedReader input = new BufferedReader(new FileReader(file));
                str=input.readLine();
            } catch (Exception ex) {
                    str= "ERROR" + ex.toString();
                }
            
            }
            else str="";
            TextField tf=new TextField(str);
            this.add(tf, 1,0);
            TextArea textArea = new TextArea();
            textArea.clear();
           
            Set<String> uniqueSearches=null;
            try {
                uniqueSearches = getUniqueSearches(new File("CorrectSearches.txt") );
            } catch (Exception ex) {
                uniqueSearches.add(ex.toString());
            }
            
            for(String s : uniqueSearches){
                textArea.appendText(s);
                textArea.appendText("\n");
            }
            
                p.formulae=tf.getText();
            tf.textProperty().addListener((observable, oldValue, newValue) -> {
                  p.formulae=tf.getText();
                  
            });
        
           
           
            
            textArea.setEditable(false);
            textArea.setWrapText(false);

           textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            
            this.add(textArea,1,2);
            Button load=new Button("load");
            Button save=new Button("save");
            Button delete =new Button("delete");
            Button clear=new Button("clear");
            Button substitute = new Button("Substitute");
            this.add(load, 0, 4);
            this.add(save, 1, 4);
            this.add(delete,2,4);
            this.add(clear, 3, 4);
            this.add(substitute,4,4);
            
          
           substitute.setOnAction(e->{
              if( (textArea.getSelectedText())!=null ){
                        String text=textArea.getSelectedText();
                        String tfText=tf.getText();
                        
                        FirstOrderParser parser = new FirstOrderParser();
                       
                        
                        Set<String> usedInFormula=new HashSet<>();
                            FirstOrderFormula phi=null;
                        try {
                            phi = parser.parseString(text);
                            usedInFormula=phi.Variables();
                          Set<String> usedInField= new HashSet<>();
                        try{
                             FirstOrderFormula phi2 = parser.parseString(tfText);
                             usedInField=phi2.Variables();
                        }
                        catch(Exception ex){
                            usedInField=getUsedVariables(tfText);
                        }
                        HashMap<String,String> replace=new HashMap<String,String>();
                        for(String s: usedInField ){
                            if(usedInFormula.contains(s)){
                                replace.put(s, s+"1");
                            }
                        }
                        String subformula=phi.Substitute(replace);
                        tf.setText(tfText+ "( " + subformula + ")");

                        } catch (Exception ex) {
                             Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("Please select a valid formula to substitute");

                            alert.showAndWait();
                        }
                        
                    }
                    
                 
           });
            
            
            
            load.setOnAction(e->{
                  FileChooser fileChooser = new FileChooser();
                  fileChooser.setTitle("Open Resource File");
                  fileChooser.getExtensionFilters().addAll(
                    new ExtensionFilter("Text Files", "*.txt") );
                  Stage stage=new Stage();
                  File f= fileChooser.showOpenDialog(stage);  
                  if(f!=null){
                      textArea.clear();
                      Set<String> uniqueSearch;
                      try {
                          uniqueSearch = getUniqueSearches(f);
                          for(String s : uniqueSearch){
                              textArea.appendText(s);
                              textArea.appendText("\n");
                          }
                      } catch (Exception ex) {
                          Logger.getLogger(FirstOrderProverParametersView.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                  }
            
            
            });
            
              save.setOnAction(e-> {
                  String text=textArea.getText();
                  String fileName="Formulae"+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".txt";
                  PrintWriter out;    
                 try {    
                     out = new PrintWriter(new BufferedWriter(
                             new FileWriter( fileName ,true)));
                     out.println(text);  
                     out.close();
                 } catch (IOException ex) {
                     Logger.getLogger(FirstOrderProverParametersView.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Information Dialog");
                 alert.setHeaderText(null);
                 alert.setContentText("File saved successfully as " + fileName);

                 alert.showAndWait();
                 
            
              });
            
      
            
             
              
              
           delete.setOnAction(new EventHandler<ActionEvent>() {
             @Override
              public void handle(ActionEvent e) {
                  textArea.replaceSelection("");
              
              }
            
            });
             clear.setOnAction(new EventHandler<ActionEvent>() {
             @Override
              public void handle(ActionEvent e) {
                  textArea.clear();
              }
            
            });
              
              
        }
    }
}

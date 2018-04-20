
/* This file is part of Gralog, Copyright (c) 2016-2017 LaS group, TU Berlin.
 * License: https://www.gnu.org/licenses/gpl.html GPL version 3 or later. */
/**
 *
 * @author meike
 * @also felix
 */
package gralog.gralogfx;
import java.util.concurrent.ThreadLocalRandom;
import gralog.events.*;
import gralog.rendering.*;

import gralog.structure.*;
import gralog.algorithm.*;
import gralog.progresshandler.*;
import gralog.gralogfx.*;

// import java.Arrays.*;



import java.util.Set;

import java.io.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
// import javafx.scene.control.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
// import gralog.gralog-core.src.main.java.gralog.rendering.*;

// @AlgorithmDescription(
//     name = "Felix Piping",
//     text = "text",
//     url = "https://url.com"
// )

public class Piping2 implements SpaceEvent{

    private Process external;
    private BufferedReader in;
    private PrintStream out;
    private Structure structure;
    private StructurePane pane;

    // @Override
    public AlgorithmParameters getParameters(Structure s) {
        return null;
    }

    public void spacePressed(){
        this.spacePressed = true;
    }

    // this.spacePressed = false;
    Boolean spacePressed = false;

    private <T> Boolean arrayContains(T[] array, T element){

        for (int i = 0; i < array.length; i ++){
            if (array[i].equals(element)){
                return true;
            }
        }
        return false;

    }

    public String externalProcessInit(String fileName,String initMessage){

        try{

            // Platform.runLater(
            //     () -> {
            //         Alert alert = new Alert(AlertType.INFORMATION);
            //         alert.setTitle("Information Dialog");
            //         alert.setHeaderText(null);
            //         alert.setContentText("executing:" + execStr[0]);
            //         alert.showAndWait();
            //     }
            // );
            System.out.println("external yo");
            String line;
            String[] execStr = {fileName,initMessage};
            this.external = Runtime.getRuntime().exec(execStr); //e.g. formatRequest
            this.in = new BufferedReader(new InputStreamReader(external.getInputStream()));
            this.out = new PrintStream(external.getOutputStream(),true);
            System.out.println("execd and shit");
            // return "error smorgesbord";

            if ((line = this.in.readLine()) != null){//assuming there is a valid line to be had
                // System.out.println("in while");
                // System.out.println("churnin");
                // return "error smorgesbord";
                if (line.length() > 0){ // if not a bogus line
                    //handleLine()
                    
                    if (line.equals("useCurrentGraph")){ //user input simulation
                        System.out.println("wants to use graph that is open");
                        out.println("ack");
                        return "useCurrentGraph";

                    }
                    System.out.println("before the grpahtypes");
                    String[] graphTypes = {"automaton","buechi","directed","kripke","undirected"};
                    if (arrayContains(graphTypes,line)){
                        out.println("ack");
                        return line;
                    }
                    in.close();
                    out.close();
                    return "error invalidType";
                    // System.out.println("just heard: " + line);

                }

            }
            System.out.println("returnin");
            return "error empty program";


            ///make first python call, get params :
            //new graph : Boolean
            //Automaton, Buechi, Directed, Kripke, Undirected
            //
            // exec(this.external,this.in,this.out,false);


        }catch(Exception e){
            e.printStackTrace();
        }
        return "error";

    }

    public Object run(Structure structure, StructurePane pane) throws
        Exception {
        // String[] commands
            // = {fileName, structure.xmlToString()};
        System.out.println("Gralog says: starting.");
        this.structure = structure;
        this.pane = pane;
        // String output = this.init(commands);
        this.exec(false);
        System.out.println("Finished exec.");

        
        // Platform.runLater(
        //     () ->{
        //         Label label2 = new Label("Name Runlater:");
        //         TextField textField2 = new TextField ();
        //         HBox hb2 = new HBox();
        //         hb2.getChildren().addAll(label2, textField2);
        //         hb2.setSpacing(10);
        //         // hb2.show();
        //     }
        // );

        // Label label1 = new Label("Name Reg:");
        // TextField textField = new TextField ();
        // HBox hb = new HBox();
        // hb.getChildren().addAll(label1, textField);
        // hb.setSpacing(10);

       


      
        return null;
    }



    // private String init(String[] execStr){

    //     // String result;
    //     try{

    //         Platform.runLater(
    //             () -> {
    //                 Alert alert = new Alert(AlertType.INFORMATION);
    //                 alert.setTitle("Information Dialog");
    //                 alert.setHeaderText(null);
    //                 alert.setContentText("executing:" + execStr[0]);
    //                 alert.showAndWait();
    //             }
    //         );
    //         this.external = Runtime.getRuntime().exec(execStr);
    //         this.in = new BufferedReader(new InputStreamReader(external.getInputStream()));
    //         this.out = new PrintStream(external.getOutputStream(),true);
    //         exec(this.external,this.in,this.out,false);


    //     }catch(Exception e){
    //         e.printStackTrace();
    //     }

    //     return "hello";

    // }

    public String execWithAck(){
        return exec(true);
    }



    private String exec(Boolean sendAck) {
        
        System.out.println("140");
        String result = "";


        try{

            String line;

            if (sendAck){
                //send ack
                out.println("ack");

            }

            
            // System.out.println("110");
            while ((line = this.in.readLine()) != null){//while python has not yet terminated
                // System.out.println("in while");
                if (line.length() > 0){ // if not a bogus line
                    //handleLine()
                    String[] externalCommandSegments = line.split(" ");
                    if (externalCommandSegments[0].equals("addVertex")){ //user input simulation
                        System.out.println("received message to add vertex " + externalCommandSegments[1]);
                        this.out.println("ack");


                        Vertex v = this.structure.createVertex();
                        v.coordinates = new Vector2D(
                            ThreadLocalRandom.current().nextInt(0, 10+1),
                            ThreadLocalRandom.current().nextInt(0, 10+1)
                        );
                        v.fillColor = new GralogColor(204, 136, 153);
                

                        this.structure.addVertex(v);

                    }else if (externalCommandSegments[0].equals("deleteVertex")){ //user input simulation
                        System.out.println("received message to delete vertex " + externalCommandSegments[1]);

                        
                        
                
                        List<Vertex> vertexList = new ArrayList<Vertex>(this.structure.getVertices());
                        this.structure.removeVertex(vertexList.get(Integer.parseInt(externalCommandSegments[1])));

                        this.out.println("ack");


                    }else if (externalCommandSegments[0].equals("pauseUntilKeyClick")){
                        
                        System.out.println("hello");
                        this.pane.requestRedraw();
                        break;

                    }else{
                        out.println(this.structure.xmlToString());
                        
                        this.out.println("ack");
                        this.spacePressed= false;

                        // wait(event){}

                    }
                    // System.out.println("just heard: " + line);
                    result = result + line;

                }

            }
            // System.out.println("done with while");
            this.pane.requestRedraw();
            return result;

            


        }catch (Exception e){
            e.printStackTrace();
        }
        return "hooray";
    //     try {
    //         String line;
    //         Process p = Runtime.getRuntime().exec(execStr);
    //         BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
    //         BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
    //         PrintStream out = new PrintStream(p.getOutputStream());
    //         out.println("Hello!\n");
    //         System.out.println("102");
    //         out.flush();
    //         result = bri.readLine();
    //         System.out.println("104" + result);
    //         out.println("ack\n");
            

    //         System.out.println("108");
    //         out.flush();
    //         while ((line = bri.readLine()) != null) {
    //             result = result + line;
    //             System.out.println("reading up tha pythonzzz" + line);
    //         }
    //         bri.close();
    //         while ((line = bre.readLine()) != null) {
    //             // System.out.println(line);
    //             System.out.println("wubadubdub");
    //         }
    //         bre.close();
    //         p.waitFor();
    //         System.out.println("Done.");
    //     } catch (Exception err) {
    //         System.out.println("nooo");
    //         err.printStackTrace();
    //     }
    //     System.out.println("returing result = : " + result);
    //     return result;
    // }
    }
}
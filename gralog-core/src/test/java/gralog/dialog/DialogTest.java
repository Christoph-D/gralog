package gralog.dialog;

import gralog.algorithm.StringAlgorithmParameter;
import gralog.generator.Cycle;
import gralog.rendering.GralogColor;
import gralog.structure.Edge;
import gralog.structure.Highlights;
import gralog.structure.Structure;
import gralog.structure.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DialogTest {

    private Dialog dialog = new Dialog();
    ArrayList<String> parameters = new ArrayList<String>();
    Structure c20 = (new Cycle()).generate(new StringAlgorithmParameter("", "20"));
    Highlights highlights = new Highlights();

    public DialogTest(){
        ArrayList<Vertex> initialList = new ArrayList<Vertex>();
        for (int i = 0; i < 10; i++)
            initialList.add(c20.getVertexById(i));
        highlights.selectAll(initialList);
        assertEquals(20,c20.getVertices().size());
        assertEquals(20,c20.getEdges().size());

        initLists();
        }

    @Test
    public void initLists(){
        // create lists via filter
        parameters.add("ALL");
        parameters.add("VERTICES");
        parameters.add("ID");
        parameters.add("<");
        parameters.add("5");
        parameters.add("P5");
        dialog.filter(parameters,c20,highlights);
        parameters.clear();

        parameters.add("ALL");
        parameters.add("VERTICES");
        parameters.add("ID");
        parameters.add(">");
        parameters.add("4");
        parameters.add("Q5");
        dialog.filter(parameters,c20,highlights);
        parameters.clear();
    }

    @Test
    public void testSort(){

        initLists();

        parameters.add("Q5");
        parameters.add("RIGHTLEFT");
        dialog.sort(parameters);
        parameters.clear();

        parameters.add("Q5");
        dialog.printLists(parameters);
        parameters.clear();


        // filter all vertices ID < 15 LESS15
        parameters.add("ALL");
        parameters.add("VERTICES");
        parameters.add("ID");
        parameters.add("<");
        parameters.add("15");
        parameters.add("LESS15");
        dialog.filter(parameters, c20, highlights);
        assertEquals(15, dialog.getVertexListS().get("LESS15").size());
        parameters.clear();


        // sort LESS15 ID ASC
        parameters.add("LESS15");
        parameters.add("ID");
        parameters.add("ASC");
        dialog.sort(parameters);
        assertEquals(0, dialog.getVertexListS().get("LESS15").get(0).id);
        assertEquals(15, dialog.getVertexListS().get("LESS15").size());
        parameters.clear();

        // sort LESS15 ID DESC
        parameters.add("LESS15");
        parameters.add("ID");
        parameters.add("DESC");
        dialog.sort(parameters);
        assertEquals(14, dialog.getVertexListS().get("LESS15").get(0).id);
        assertEquals(15, dialog.getVertexListS().get("LESS15").size());
        parameters.clear();

        // sort P1 LEFTTORIGHT
        parameters.add("LESS15");
        parameters.add("ID");
        parameters.add("DESC");


    }

    @Test
    public void testFilter(){

        // filter all vertices fill white WHITELIST
        parameters.add("ALL");
        parameters.add("VERTICES");
        parameters.add("FILL");
        parameters.add("WHITE");
        parameters.add("WHITELIST");
        dialog.filter(parameters, c20, highlights);
        assertEquals(GralogColor.WHITE, dialog.getVertexListS().get("WHITELIST").get(0).fillColor);
        assertEquals(20, dialog.getVertexListS().get("WHITELIST").size());
        parameters.clear();

        // filter all vertices ID < 15 LESS15
        parameters.add("ALL");
        parameters.add("VERTICES");
        parameters.add("ID");
        parameters.add("<");
        parameters.add("15");
        parameters.add("LESS15");
        dialog.filter(parameters, c20, highlights);
        assertEquals(15, dialog.getVertexListS().get("LESS15").size());
        parameters.clear();


        // filter all vertices ID < 2 ID > 1 LESS15
        parameters.add("ALL");
        parameters.add("VERTICES");
        parameters.add("ID");
        parameters.add("<");
        parameters.add("2");
        parameters.add("ID");
        parameters.add(">");
        parameters.add("0");
        parameters.add("VL1");
        dialog.filter(parameters, c20, highlights);
        assertEquals(1, dialog.getVertexListS().get("VL1").get(0).id);
        assertEquals(1, dialog.getVertexListS().get("VL1").size());
        parameters.clear();


    }

    @Test
    public void testFilterNoEdges(){
        highlights.clearSelection();
        parameters.add("SELECTED");
        parameters.add("EDGES");
        parameters.add("LISTEMPTY");
        dialog.filter(parameters,c20,highlights);

    }

    @Test
    public void testConnect(){
        parameters.add("P5");
        parameters.add("Q5");
        parameters.add("i+1");
        dialog.connectFormula(parameters,c20);
    }

}

/*
 * This file is part of GrALoG FX, Copyright (c) 2016 LaS group, TU Berlin.
 * License: https://www.gnu.org/licenses/gpl.html GPL version 3 or later.
 */
package gralog.generator;

import gralog.structure.DirectedGraph;
import gralog.structure.Structure;
import gralog.structure.UndirectedGraph;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests that the generators generate the expected structure type and the
 * expected number of vertices/edges.
 */
public class GeneratorTest {

    @Test
    public void testCycle() throws Exception {
        Structure result = (new Cycle()).generate(new StringGeneratorParameter("5"));
        assertTrue(result instanceof DirectedGraph);
        assertSame(result.getVertices().size(), 5);
        assertSame(result.getEdges().size(), 5);
    }

    @Test
    public void testCylindricalGrid() throws Exception {
        Structure result = (new CylindricalGrid()).generate(new StringGeneratorParameter("5"));
        assertTrue(result instanceof DirectedGraph);
        assertSame(result.getVertices().size(), 25);
        assertSame(result.getEdges().size(), 45);
    }

    @Test
    public void testGrid() throws Exception {
        Structure result = (new Grid()).generate(new StringGeneratorParameter("5"));
        assertTrue(result instanceof UndirectedGraph);
        assertSame(result.getVertices().size(), 25);
        assertSame(result.getEdges().size(), 40);
    }

    @Test
    public void testWheel() throws Exception {
        Structure result = (new Wheel()).generate(new StringGeneratorParameter("5"));
        assertTrue(result instanceof UndirectedGraph);
        assertSame(result.getVertices().size(), 6);
        assertSame(result.getEdges().size(), 10);
    }
}

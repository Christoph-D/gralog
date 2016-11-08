/*
 * This file is part of GrALoG FX, Copyright (c) 2016 LaS group, TU Berlin.
 * License: https://www.gnu.org/licenses/gpl.html GPL version 3 or later.
 */
package gralog.generator;

import gralog.algorithm.AlgorithmParameters;
import gralog.algorithm.IntSyntaxChecker;
import gralog.algorithm.StringAlgorithmParameter;
import gralog.properties.Properties;
import gralog.rendering.Vector2D;
import gralog.structure.*;
import java.util.ArrayList;

/**
 *
 */
@GeneratorDescription(
        name = "Cylindrical Grid",
        text = "Generates a Cylindrical Grid (the directed equivalent of an undirected grid)",
        url = ""
)
public class CylindricalGrid extends Generator {

    // null means it has no parameters
    @Override
    public AlgorithmParameters getParameters() {
        return new StringAlgorithmParameter(
                "Size",
                Properties.getInteger(this.getClass(), "size", 5).toString(),
                new IntSyntaxChecker(1, Integer.MAX_VALUE),
                "");
    }

    @Override
    public Structure generate(AlgorithmParameters p) {
        int n = Integer.parseInt(((StringAlgorithmParameter) p).parameter);
        Properties.setInteger(this.getClass(), "size", n);

        DirectedGraph result = new DirectedGraph();

        ArrayList<Vertex> first = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            Vertex temp = result.createVertex();
            first.add(temp);
            temp.coordinates = new Vector2D(
                    Math.sin(0 * 2 * Math.PI / n) * 2 * (j + 2),
                    Math.cos(0 * 2 * Math.PI / n) * 2 * (j + 2)
            );
            if (j > 0)
                result.addEdge(result.createEdge(first.get(j - 1), temp));
            result.addVertex(temp);
        }

        ArrayList<Vertex> last = first;
        for (int i = 1; i < n; i++) {
            ArrayList<Vertex> next = new ArrayList<>();
            Vertex lasttemp = null;
            for (int j = 0; j < n; j++) {
                Vertex temp = result.createVertex();
                next.add(temp);
                temp.coordinates = new Vector2D(
                        Math.sin(i * 2 * Math.PI / n) * 2 * (j + 2),
                        Math.cos(i * 2 * Math.PI / n) * 2 * (j + 2)
                );
                if (lasttemp != null)
                    if (i % 2 == 0)
                        result.addEdge(result.createEdge(lasttemp, temp));
                    else
                        result.addEdge(result.createEdge(temp, lasttemp));

                result.addEdge(result.createEdge(last.get(j), temp));

                result.addVertex(temp);
                lasttemp = temp;
            }

            last = next;
        }

        for (int i = 0; i < n; i++)
            result.addEdge(result.createEdge(last.get(i), first.get(i)));

        return result;
    }
}

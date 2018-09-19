/* This file is part of Gralog, Copyright (c) 2016-2017 LaS group, TU Berlin.
 * License: https://www.gnu.org/licenses/gpl.html GPL version 3 or later. */
package gralog.modallogic.formula;

import gralog.modallogic.KripkeStructure;
import gralog.modallogic.World;
import gralog.structure.*;
import java.util.HashSet;

public class ModalLogicProposition extends ModalLogicFormula {

    String proposition;

    public ModalLogicProposition(String proposition) {
        this.proposition = proposition;
    }

    @Override
    public HashSet<World> interpretation(KripkeStructure structure) {
        HashSet<World> result = new HashSet<>();
        for (Vertex v : structure.getVertices())
            if (v instanceof World) {
                World w = (World) v;
                if (w.satisfiesProposition(this.proposition))
                    result.add(w);
            }
        return result;
    }

    @Override
    public String toString(FormulaPosition pos) {
        return proposition;
    }
}

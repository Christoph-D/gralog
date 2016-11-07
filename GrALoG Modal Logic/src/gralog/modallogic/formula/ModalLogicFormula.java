/*
 * This file is part of GrALoG FX, Copyright (c) 2016 LaS group, TU Berlin.
 * License: https://www.gnu.org/licenses/gpl.html GPL version 3 or later.
 */
package gralog.modallogic.formula;

import gralog.modallogic.*;
import java.util.HashSet;

/**
 * Base class for all formulas.
 *
 *
 */
public abstract class ModalLogicFormula {

    public ModalLogicFormula() {
    }

    abstract public HashSet<World> interpretation(KripkeStructure structure);

    @Override
    public String toString() {
        return toString(FormulaPosition.Or);
    }

    abstract public String toString(FormulaPosition pos);

    // For the toString method, we track the position in the formula in order
    // to produce a string with a minimum number of parentheses.
    public enum FormulaPosition {
        Or, And, BoxDiamondNot
    }
}

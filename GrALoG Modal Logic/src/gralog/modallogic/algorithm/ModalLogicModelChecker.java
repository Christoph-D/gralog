/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gralog.modallogic.algorithm;

import gralog.modallogic.*;
import gralog.modallogic.formula.*;
import gralog.modallogic.parser.*;

import gralog.algorithm.*;
import gralog.structure.*;

import java.util.HashSet;


/**
 *
 * @author viktor
 */
@AlgorithmDescription(
  name="Modal Logic Model-Checking",
  text="",
  url="https://en.wikipedia.org/wiki/Modal_logic"
)
public class ModalLogicModelChecker extends Algorithm {
    
    @Override
    public AlgorithmParameters GetParameters(Structure s) {
        return new GenericAlgorithmParameter<String>("[](P \\wedge Q)");
    }
    
    public Object Run(KripkeStructure s, AlgorithmParameters p) throws Exception {
        
        GenericAlgorithmParameter<String> sp = (GenericAlgorithmParameter<String>)(p);
        
        ModalLogicParser parser = new ModalLogicParser();
        ModalLogicFormula phi = parser.parseString(sp.parameter);
        HashSet<World> result = phi.Interpretation(s);
        
        return "" + result.size() + " worlds";
    }
    
    
}
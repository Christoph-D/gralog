/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gralog.automaton.generator;

import gralog.generator.*;
import gralog.automaton.*;
import gralog.automaton.regularexpression.*;
import gralog.automaton.regularexpression.parser.*;
import gralog.structure.Structure;

/**
 *
 * @author viktor
 */
@GeneratorDescription(
  name="Thompson's Construction",
  text="",
  url="https://en.wikipedia.org/wiki/Thompson%27s_construction"
)
public class GeneratorRegularExpression extends Generator {
    
    @Override
    public GeneratorParameters GetParameters() {
        return new GenericGeneratorParameter<String>("");
    }
    
    @Override
    public Structure Generate(GeneratorParameters p) throws Exception {
        GenericGeneratorParameter<String> sp = (GenericGeneratorParameter<String>)(p);
        
        RegularExpressionParser parser = new RegularExpressionParser();
        RegularExpression regexp = parser.parseString(sp.parameter);
        Automaton result = regexp.ThompsonConstruction();
        
        return result;
    }
    
}
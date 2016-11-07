
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Nov 07 18:08:24 CET 2016
//----------------------------------------------------

package gralog.modalmucalculus.parser;

import java_cup.runtime.*;
import gralog.algorithm.ParseError;
import gralog.modalmucalculus.formula.*;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Mon Nov 07 18:08:24 CET 2016
  */
public class ModalMuCalculusParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public ModalMuCalculusParser() {super();}

  /** Constructor which sets the default scanner. */
  public ModalMuCalculusParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ModalMuCalculusParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\034\000\002\002\003\000\002\002\004\000\002\002" +
    "\005\000\002\002\005\000\002\002\007\000\002\002\003" +
    "\000\002\004\005\000\002\004\003\000\002\005\005\000" +
    "\002\005\003\000\002\006\003\000\002\006\003\000\002" +
    "\006\004\000\002\006\004\000\002\006\006\000\002\006" +
    "\004\000\002\006\006\000\002\006\005\000\002\006\003" +
    "\000\002\003\004\000\002\003\004\000\002\003\006\000" +
    "\002\003\004\000\002\003\006\000\002\003\006\000\002" +
    "\003\005\000\002\003\006\000\002\003\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\030\004\022\006\005\011\014\012\007\013" +
    "\017\014\004\015\010\016\011\021\020\022\023\024\013" +
    "\001\002\000\030\004\022\006\005\011\014\012\007\013" +
    "\017\014\004\015\010\016\011\021\020\022\023\024\013" +
    "\001\002\000\004\024\057\001\002\000\012\002\ufffa\017" +
    "\055\020\ufffa\023\ufffa\001\002\000\004\024\051\001\002" +
    "\000\012\002\ufff7\017\ufff7\020\ufff7\023\ufff7\001\002\000" +
    "\012\002\ufff6\017\ufff6\020\ufff6\023\ufff6\001\002\000\010" +
    "\002\ufffc\020\043\023\ufffc\001\002\000\012\002\uffef\017" +
    "\uffef\020\uffef\023\uffef\001\002\000\004\024\037\001\002" +
    "\000\004\002\036\001\002\000\006\002\001\023\001\001" +
    "\002\000\030\004\022\006\005\011\014\012\007\013\017" +
    "\014\004\015\010\016\011\021\020\022\023\024\013\001" +
    "\002\000\030\004\022\006\005\011\014\012\007\013\017" +
    "\014\004\015\010\016\011\021\020\022\023\024\013\001" +
    "\002\000\012\002\ufff8\017\ufff8\020\ufff8\023\ufff8\001\002" +
    "\000\004\024\026\001\002\000\030\004\022\006\005\011" +
    "\014\012\007\013\017\014\004\015\010\016\011\021\020" +
    "\022\023\024\013\001\002\000\004\023\025\001\002\000" +
    "\012\002\ufff0\017\ufff0\020\ufff0\023\ufff0\001\002\000\004" +
    "\005\027\001\002\000\030\004\022\006\005\011\014\012" +
    "\007\013\017\014\004\015\010\016\011\021\020\022\023" +
    "\024\013\001\002\000\006\002\uffec\023\uffec\001\002\000" +
    "\012\002\ufff3\017\ufff3\020\ufff3\023\ufff3\001\002\000\006" +
    "\002\uffee\023\uffee\001\002\000\012\002\ufff5\017\ufff5\020" +
    "\ufff5\023\ufff5\001\002\000\006\002\uffed\023\uffed\001\002" +
    "\000\012\002\ufff4\017\ufff4\020\ufff4\023\ufff4\001\002\000" +
    "\004\002\000\001\002\000\032\004\022\006\005\010\040" +
    "\011\014\012\007\013\017\014\004\015\010\016\011\021" +
    "\020\022\023\024\013\001\002\000\030\004\022\006\005" +
    "\011\014\012\007\013\017\014\004\015\010\016\011\021" +
    "\020\022\023\024\013\001\002\000\006\002\uffe8\023\uffe8" +
    "\001\002\000\006\002\uffe9\023\uffe9\001\002\000\030\004" +
    "\022\006\005\011\014\012\007\013\017\014\004\015\010" +
    "\016\011\021\020\022\023\024\013\001\002\000\012\002" +
    "\ufffb\017\046\020\ufffb\023\ufffb\001\002\000\006\002\uffff" +
    "\023\uffff\001\002\000\030\004\022\006\005\011\014\012" +
    "\007\013\017\014\004\015\010\016\011\021\020\022\023" +
    "\024\013\001\002\000\006\002\ufffd\023\ufffd\001\002\000" +
    "\012\002\ufff9\017\ufff9\020\ufff9\023\ufff9\001\002\000\032" +
    "\004\022\006\005\010\053\011\014\012\007\013\017\014" +
    "\004\015\010\016\011\021\020\022\023\024\013\001\002" +
    "\000\006\002\uffe6\023\uffe6\001\002\000\030\004\022\006" +
    "\005\011\014\012\007\013\017\014\004\015\010\016\011" +
    "\021\020\022\023\024\013\001\002\000\006\002\uffe7\023" +
    "\uffe7\001\002\000\030\004\022\006\005\011\014\012\007" +
    "\013\017\014\004\015\010\016\011\021\020\022\023\024" +
    "\013\001\002\000\006\002\ufffe\023\ufffe\001\002\000\004" +
    "\007\060\001\002\000\030\004\022\006\005\011\014\012" +
    "\007\013\017\014\004\015\010\016\011\021\020\022\023" +
    "\024\013\001\002\000\006\002\uffea\023\uffea\001\002\000" +
    "\012\002\ufff1\017\ufff1\020\ufff1\023\ufff1\001\002\000\006" +
    "\002\uffeb\023\uffeb\001\002\000\012\002\ufff2\017\ufff2\020" +
    "\ufff2\023\ufff2\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\014\002\014\003\015\004\011\005\005\006" +
    "\020\001\001\000\006\003\062\006\063\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\003\033\006\034\001\001\000\006\003\031\006\032" +
    "\001\001\000\002\001\001\000\002\001\001\000\014\002" +
    "\023\003\015\004\011\005\005\006\020\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\003" +
    "\027\006\030\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\014\002\040\003\015" +
    "\004\011\005\005\006\020\001\001\000\014\002\041\003" +
    "\015\004\011\005\005\006\020\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\003\044\005\043\006\020\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\003\046" +
    "\006\047\001\001\000\002\001\001\000\002\001\001\000" +
    "\014\002\051\003\015\004\011\005\005\006\020\001\001" +
    "\000\002\001\001\000\014\002\053\003\015\004\011\005" +
    "\005\006\020\001\001\000\002\001\001\000\006\003\055" +
    "\006\047\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\003\060\006\061\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ModalMuCalculusParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ModalMuCalculusParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ModalMuCalculusParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    String errorMsg = null;
    private String inputString;

    public Boolean hasError()
    {
        return errorMsg == null;
    }
    
    public String getErrorMsg()
    {
        if(errorMsg == null)
            return "no error";
        else
            return errorMsg;
    }

    @Override
    public void report_error(String message, Object info) {
    }

    @Override
    public void syntax_error(Symbol cur_token)
    {
        if(errorMsg == null)
            errorMsg = "Syntax Error: " + cur_token.toString();
    }

    @Override
    public void report_fatal_error(String message, Object info) throws ParseError
    {
        java_cup.runtime.ComplexSymbolFactory.ComplexSymbol symbol = (java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)info;
        throw new ParseError("Unexpected " + symbol.getName(), inputString, symbol.xleft.getColumn());
    }

    public ModalMuCalculusFormula parseString(String str) throws Exception
    {
        String charset = "UTF8";
        byte[] bytes = str.getBytes(charset);
        ByteArrayInputStream stringstream = new ByteArrayInputStream(bytes);

        inputString = str;
        ModalMuCalculusScanner scanner = new ModalMuCalculusScanner(stringstream);
        this.setScanner(scanner);

        Symbol parserresult = this.parse();
        return (ModalMuCalculusFormula) parserresult.value;
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$ModalMuCalculusParser$actions {
  private final ModalMuCalculusParser parser;

  /** Constructor */
  CUP$ModalMuCalculusParser$actions(ModalMuCalculusParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$ModalMuCalculusParser$do_action(
    int                        CUP$ModalMuCalculusParser$act_num,
    java_cup.runtime.lr_parser CUP$ModalMuCalculusParser$parser,
    java.util.Stack            CUP$ModalMuCalculusParser$stack,
    int                        CUP$ModalMuCalculusParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ModalMuCalculusParser$result;

      /* select the action based on the action number */
      switch (CUP$ModalMuCalculusParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // quantifiedformula ::= NU STRING formula 
            {
              ModalMuCalculusFormula RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusGreatestFixedPoint(var, f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // quantifiedformula ::= NU STRING DOT formula 
            {
              ModalMuCalculusFormula RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusGreatestFixedPoint(var, f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-3)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // quantifiedformula ::= MU STRING formula 
            {
              ModalMuCalculusFormula RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusLeastFixedPoint(var, f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // quantifiedformula ::= MU STRING DOT formula 
            {
              ModalMuCalculusFormula RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusLeastFixedPoint(var, f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-3)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // quantifiedformula ::= BRACKETLEFT STRING BRACKETRIGHT quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusBox(s, f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-3)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // quantifiedformula ::= BOX quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusBox(f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // quantifiedformula ::= LT STRING GT quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusDiamond(s, f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-3)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // quantifiedformula ::= DIAMOND quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusDiamond(f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // quantifiedformula ::= NEG quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusNot(f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("quantifiedformula",1, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // basicformula ::= STRING 
            {
              ModalMuCalculusFormula RESULT =null;
		int propleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int propright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		String prop = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusProposition(prop); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // basicformula ::= PARENTHESISLEFT formula PARENTHESISRIGHT 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).value;
		 RESULT = f; 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // basicformula ::= BRACKETLEFT STRING BRACKETRIGHT basicformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusBox(s, f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-3)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // basicformula ::= BOX basicformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusBox(f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // basicformula ::= LT STRING GT basicformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusDiamond(s, f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-3)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // basicformula ::= DIAMOND basicformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusDiamond(f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // basicformula ::= NEG basicformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusNot(f); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // basicformula ::= TOP 
            {
              ModalMuCalculusFormula RESULT =null;
		 RESULT = new ModalMuCalculusTop(); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // basicformula ::= BOT 
            {
              ModalMuCalculusFormula RESULT =null;
		 RESULT = new ModalMuCalculusBottom(); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("basicformula",4, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // conjunction ::= basicformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = f; 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("conjunction",3, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // conjunction ::= conjunction AND basicformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int leftleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int leftright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		ModalMuCalculusFormula left = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int rightleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int rightright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula right = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusAnd(left, right); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("conjunction",3, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // disjunction ::= conjunction 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = f; 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("disjunction",2, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // disjunction ::= disjunction OR conjunction 
            {
              ModalMuCalculusFormula RESULT =null;
		int leftleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int leftright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		ModalMuCalculusFormula left = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int rightleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int rightright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula right = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusOr(left, right); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("disjunction",2, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // formula ::= disjunction 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = f; 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // formula ::= disjunction OR conjunction AND quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int leftleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-4)).left;
		int leftright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-4)).right;
		ModalMuCalculusFormula left = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-4)).value;
		int middleleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int middleright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		ModalMuCalculusFormula middle = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int rightleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int rightright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula right = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusOr(left, new ModalMuCalculusAnd(middle, right)); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-4)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // formula ::= conjunction AND quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int leftleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int leftright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		ModalMuCalculusFormula left = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int rightleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int rightright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula right = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusAnd(left, right); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // formula ::= disjunction OR quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int leftleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).left;
		int leftright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).right;
		ModalMuCalculusFormula left = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)).value;
		int rightleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int rightright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula right = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = new ModalMuCalculusOr(left, right); 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-2)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= formula EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).right;
		ModalMuCalculusFormula start_val = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)).value;
		RESULT = start_val;
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.elementAt(CUP$ModalMuCalculusParser$top-1)), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ModalMuCalculusParser$parser.done_parsing();
          return CUP$ModalMuCalculusParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // formula ::= quantifiedformula 
            {
              ModalMuCalculusFormula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()).right;
		ModalMuCalculusFormula f = (ModalMuCalculusFormula)((java_cup.runtime.Symbol) CUP$ModalMuCalculusParser$stack.peek()).value;
		 RESULT = f; 
              CUP$ModalMuCalculusParser$result = parser.getSymbolFactory().newSymbol("formula",0, ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ModalMuCalculusParser$stack.peek()), RESULT);
            }
          return CUP$ModalMuCalculusParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}


package algebragenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * EquationGenerator
 * 
 * Object used to generate simple algebra equations
 * 
 * @author samuelfrench
 */
public class EquationGenerator
{
    Random rm;
    public EquationGenerator()
    {
        rm = new Random();
    }
    public ArrayList<Integer> makeEq(){
        ArrayList<Integer> eqTerms = new ArrayList();
        eqTerms.add((rm.nextInt(2)+1));
        eqTerms.add((rm.nextInt(41)-20));
        eqTerms.add((rm.nextInt(41)-20));
        
        //determine answer
        double rExp = eqTerms.get(2) - eqTerms.get(1);
        double answer = rExp/((double)eqTerms.get(0));
        eqTerms.add((int)answer);
        
        return eqTerms;
    }
}

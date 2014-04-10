package algebragenerator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author samuelfrench
 */
public class AlgebraGenerator
{
    /**
     * main
     * 
     * Generates simple algebra equations and quizzes the user
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        EquationGenerator eg = new EquationGenerator();
        ArrayList<ArrayList<Integer>> eqList = eqCreation(eg,10);
        eqListPrompt(eqList);
    }
    
    /**
     * eqListPrompt
     * 
     * Take in a list of equations and quiz the user
     * 
     * @param eqList ArrayList List of equations
     * @return int Number of answers correct
     */
    public static int eqListPrompt(ArrayList<ArrayList<Integer>> eqList)
    {
        int numberCorrect = 0;
        int totalQuestions = eqList.size();
        
        Scanner sc = new Scanner(System.in);
        for(int x = 0; x < totalQuestions; x++)
        {
            if(eqPrompt(sc, eqList.get(x))){
                numberCorrect++;
            }
        }
        printResults(numberCorrect, totalQuestions);
        return numberCorrect;
    }
    
    /**
     * printResults
     * 
     * Print a summary.
     * 
     * @param numberCorrect int
     * @param totalQuestions int
     */
    public static void printResults(int numberCorrect, int totalQuestions)
    {
        double percentage = (double)totalQuestions/(double)numberCorrect;
        System.out.println("You got " + numberCorrect + " correct answers out of " + totalQuestions + ".");
        System.out.println("Score: " + percentage + "%");
    }
    
    public static boolean eqPrompt(Scanner sc, ArrayList<Integer> eq)
    {
        System.out.println(eq.get(0).toString() + "x + " + eq.get(1).toString() + " = " + eq.get(2).toString());
        System.out.println("Solve for x: ");
        
        if(eq.get(3).toString().equals(sc.nextLine()))
        {
            System.out.println("Correct!");
            return true;
        } //else
        System.out.println("Sorry, you're a dumbass.");
        return false;
    }
    
    /**
     * eqCreation
     * 
     * Performs same functionality of eqCreation(EquationGenerator,int)
     * but generates an equation generator within the method.
     * 
     * @param quantity int number of equations to generate
     * @return 
     */
    public static ArrayList<ArrayList<Integer>> eqCreation(int quantity)
    {
        EquationGenerator eg = new EquationGenerator();
        return eqCreation(eg,quantity);
    }
    /**
     * eqCreation
     * 
     * Take an EquationGenerator object and create an ArrayList containing the 
     * specified quantity of equations
     * 
     * @param eg EquationGenerator
     * @param quantity int The number of equations to generate
     * @return ArrayList<ArrayList<Integer>>
     */
    public static ArrayList<ArrayList<Integer>> eqCreation(EquationGenerator eg, int quantity)
    {
        ArrayList<ArrayList<Integer>> eqBuff = new ArrayList();
        for (int x = 0; x < quantity; x++)
        {
            eqBuff.add(eg.makeEq());
        }
        return eqBuff;
    }
}

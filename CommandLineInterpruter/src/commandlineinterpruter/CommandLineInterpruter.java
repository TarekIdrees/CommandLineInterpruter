/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandlineinterpruter;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Thesnak
 */
public class CommandLineInterpruter {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Parser[] Start=new Parser[1000];
        int i=0;
        while(true){
            Start[i]=new Parser();
            String Command="";
            Scanner input=new Scanner(System.in);
            System.out.print("MTM>> ");
            Command=input.nextLine();
            if(Command.contains("exit")){
                break;
            }
            else{
            Start[i].parse(Command);
            i++;
            }
        }
    
    }
    
}

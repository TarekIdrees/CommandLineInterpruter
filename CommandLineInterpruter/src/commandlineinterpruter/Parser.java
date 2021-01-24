/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandlineinterpruter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thesnak
 */
public class Parser extends Terminal {

    String[] args = null;
    String cmd;

    List<String> FinalCommand = new ArrayList<>();

    public boolean parse(String input) throws IOException {
        String[] commandAndPrameter = input.split(" ");
        args = new String[commandAndPrameter.length];
        args[0] = commandAndPrameter[0];
        args[0] = args[0].toLowerCase();
        cmd = args[0];
        int j = 1;
        //for loop to avoid ending at space in name of file or folder
        for (int i = 1; i < commandAndPrameter.length; i++) {
            args[j] = commandAndPrameter[i];
             if((args[1].contains(".")&&!args[1].contains(":"))||"mkdir".equals(cmd)||"rmdir".equals(cmd)){
                 args[1]=pwd()+"\\"+args[1];
            }
             else if (args[j].contains(":")) {
                j++;
            }
            else {
                args[j - 1] += " " + args[j];
                args[j] = null;
            }

        }

        for (String data : args) {
            if (data != null) {
                FinalCommand.add(data);
            }
        }
        //list contains only Command and parametars with no nulls
        if (FinalCommand.get(0).equals("cp") && FinalCommand.size() == 3) {
            cp(FinalCommand.get(1), FinalCommand.get(2));
            return true;
        } else if (FinalCommand.get(0).equals("mv") && FinalCommand.size() == 3) {
            mv(FinalCommand.get(1), FinalCommand.get(2));

            return true;
        }
        //cd for the cd that take parametar
        else if (FinalCommand.get(0).equals("cd") && FinalCommand.size() == 2) {
            cd(FinalCommand.get(1));
            if (cd(FinalCommand.get(1))) {
                System.out.println("File directory changed successfully to:");
                System.out.println(pwd());
            } else {
                System.out.println("Error");
            }
            return true;
        } 
        //cd for the cd that dosen't take parametar

        if (FinalCommand.get(0).equals("cd") && FinalCommand.size() == 1) {
            setToCurrentDirectory(pwd());
            if (setToCurrentDirectory(pwd())) {
                System.out.println("File directory changed successfully to:");
                System.out.println(pwd());
            } else {
                System.out.println("Error");
            }
            return true;
        } else if (FinalCommand.get(0).equals("cat") && FinalCommand.size() == 2) {
            cat(FinalCommand.get(1));
            return true;
        } else if (FinalCommand.get(0).equals("mkdir") && FinalCommand.size() == 2) {
            mkdir(FinalCommand.get(1));
            return true;
        } else if (FinalCommand.get(0).equals("rmdir") && FinalCommand.size() == 2) {
            rmdir(FinalCommand.get(1));
            return true;
        } else if (FinalCommand.get(0).equals("pwd") && FinalCommand.size() == 1) {
            System.out.println(pwd());
            return true;
        } else if (FinalCommand.get(0).equals("ls") && FinalCommand.size() == 1) {
            ls();
            return true;
        } else if (FinalCommand.get(0).equals("rm") && FinalCommand.size() == 2) {
            rm(FinalCommand.get(1));
            return true;
        } else {
            switch (FinalCommand.get(0)) {
                case "cp":
                    System.out.println("cp takes two parameters  1: File location \t 2: Destination path ");
                    break;
                case "mv":
                    System.out.println("mv takes two parameters  1: File location \t 2: Destination path");
                    break;
                case "mkdir":
                    System.out.println("mkdir takes one parameters  1: Folder location ");
                    break;
                case "rmdir":
                    System.out.println("rmdir takes one parameters  1: Folder location ");
                    break;
                case "cat":
                    System.out.println("cat takes two parameters  1: File location \t 2: Destination path");
                    break;
                case "rm":
                    System.out.println("rm takes one parameters  1: File location ");
                    break;
                default:
                    System.out.println("Please Enter A valid Command");
                    break;
            }
        }

        FinalCommand.clear();
        return false;

    }

    public String getCmd() {

        return cmd;

    }

    public List<String> getArguments() {

        return FinalCommand;

    }

}

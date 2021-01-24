/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandlineinterpruter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author Thesnak
 */
public class Terminal {
//cp copy contiant of file to another but it should be exsist 

    public static void cp(String sourcePath, String destinationPath) throws IOException {

        try {
            FileReader reader = new FileReader(sourcePath);
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                FileWriter bufferedWriter = new FileWriter(destinationPath, false);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line);
                    bufferedWriter.write("\n");
                }
                bufferedWriter.close();
            }
            //  Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied");
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        } catch (IOException ex) {
            System.out.println("cp takes two parameters \n 1: File location \t  2: Destination path ");
        }

    }
//mv move file to another but it should be exsist 

    public static void mv(String sourcePath, String destinationPath) throws IOException {
        File source = new File(sourcePath);
        File destination = new File(destinationPath);
        if (source.exists() && destination.exists()) {
            FileReader reader = new FileReader(sourcePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            FileWriter bufferedWriter = new FileWriter(destinationPath, false);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            reader.close();
           File FileScourse = new File(sourcePath);
        if (FileScourse.exists()) {
            Files.delete(FileScourse.toPath());}
            System.out.println("File Moved");
        } else if (sourcePath.isEmpty() || destinationPath.isEmpty()) {
            System.out.println("mv takes two parameters  1: File location \t 2: Destination path ");
        } else {
            System.out.println("File not Exist");
        }
    }
//rm reomve file if exist 

    public static void rm(String sourcePath) throws IOException {
        File FileScourse = new File(sourcePath);
        if (FileScourse.exists()) {
            Files.delete(FileScourse.toPath());
            System.out.println("File Removed Succesfully");
        } else if (sourcePath.length() == 0) {
            System.out.println("rm takes one parameter the file directory");
        } else {
            System.out.println("File not Exist");
        }
    }
//pwd print the current director

    public static String pwd() {
        String pwd = System.getProperty("user.dir");
        return pwd;
    }
//cat print the file  on the screen

    public static void cat(String path) throws FileNotFoundException {

        try {
            try (FileReader fileReader = new FileReader(path)) {
                BufferedReader in = new BufferedReader(fileReader);
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(path + ", 404 Your File is Not Found");
        } catch (IOException e) {
            System.out.println(path + ", I/O Error.");
        }

    }
// ls print current location  files and folders Names

    public static void ls() {
        File dir = new File(System.getProperty("user.dir"));
        String contents[] = dir.list();
        for (String content : contents) {
            System.out.println(content);
        }
    }
//cd   1-cd : print the Direction 2-cd Direction : change the cuurent Direction
    //for cd with path 

    public static boolean cd(String directoryName) {
        boolean result = false;
        File directory;
        directory = new File(directoryName).getAbsoluteFile();
        //getAbsoluteFile() The method returns array of files and directories in the directory denoted by this abstract pathname.
        //mkdirs() The method returns true if the directories was created, with all necessary parent directories; else false.
        if (directory.exists() || directory.mkdirs()) {
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }
        return result;
    }
//cd without path

    public static boolean setToCurrentDirectory(String write) throws IOException {
        boolean result = false;
        File directory;
        String current = new java.io.File(".").getCanonicalPath();
        directory = new File(current).getAbsoluteFile();
        if (directory.exists() || directory.mkdirs()) {
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }
        return result;
    }
//rmdir remove 

    public static void rmdir(String sourse) {
        File file = new File(sourse);
        if (sourse.length() == 0) {
            System.out.println("rmdir takes a directory as a parameter");
        } else {
            if (file.exists()) {
                file.delete();
                if (!file.exists()) {
                    System.out.println("Folder has been deleted successfully");
                }
            } else {
                System.out.println("404 Folder is not exist");
            }
        }

    }
//mkdir make folder

    public static void mkdir(String source) {
        if (source.length() == 0) {
            System.out.println("mkdir takes a directory as a parameter");
        } else {
            File newDirectory = new File(source);
            if (!newDirectory.exists()) {
                System.out.println("creating new directory: " + newDirectory.getName());
                boolean result = false;
                try {
                    newDirectory.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    System.out.println("Not secured!");
                }
                if (result) {
                    System.out.println("Directory created");
                }
            } else {
                System.out.println("The directory already exists");
            }
        }

    }

}

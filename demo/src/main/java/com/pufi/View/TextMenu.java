package com.pufi.View;

import java.util.Map;
import java.util.Scanner;

import com.pufi.Controller.Controller;

public class TextMenu {
    private Map<String,Command>commands;
    //print the menu
    public TextMenu(){
        commands = new java.util.HashMap<String,Command>();

    }

    public void addCommand(Command c){
        commands.put(c.getKey(),c);
    }

    public void printMenu(){
        for (Command com: commands.values()){
            String line = String.format("%4s: %s", com.getKey(), com.getDesc());
            System.out.println(line);
        }
    }

    public void show(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            printMenu();
            System.out.println("Input the option: ");
            String key = scanner.nextLine();
            Command com = commands.get(key);
            if (com == null){
                System.out.println("Invalid Option");
                continue;
            }
            com.execute();
        }
    }
}

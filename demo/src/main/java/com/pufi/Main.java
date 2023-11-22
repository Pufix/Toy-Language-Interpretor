package com.pufi;

import java.io.BufferedReader;

import com.pufi.Controller.Controller;
import com.pufi.Model.ProgramState;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceList;
import com.pufi.Model.ADT.InterfaceStack;
import com.pufi.Model.ADT.myDictionary;
import com.pufi.Model.ADT.myList;
import com.pufi.Model.ADT.myStack;
import com.pufi.Model.Expressions.ComparationExpression;
import com.pufi.Model.Expressions.ValueExpression;
import com.pufi.Model.Expressions.VariableExpression;
import com.pufi.Model.Statements.AssignStatement;
import com.pufi.Model.Statements.CloseFileStatement;
import com.pufi.Model.Statements.CompoundStatement;
import com.pufi.Model.Statements.IfElseStatement;
import com.pufi.Model.Statements.IfStatement;
import com.pufi.Model.Statements.InterfaceStatement;
import com.pufi.Model.Statements.OpenFileStatement;
import com.pufi.Model.Statements.PrintStatement;
import com.pufi.Model.Statements.ReadFileStatement;
import com.pufi.Model.Statements.VariableDeclarationStatement;
import com.pufi.Model.Types.IntType;
import com.pufi.Model.Types.StringType;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.StringValue;
import com.pufi.Repository.Repo;
import com.pufi.View.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        string varf;
        varf = "test.in";
        openRFile(varf);
        int varc;
        readFile(varf, varc);
        print(varc);
        readFile(varf, varc);
        print(varc);
        closeRFile(varf);
        */
        InterfaceStatement ex1 =  
            new CompoundStatement(new VariableDeclarationStatement("varf", new StringType()),
            new CompoundStatement(new AssignStatement("varf", new ValueExpression(new StringValue("test.in"))),
            new CompoundStatement(new OpenFileStatement(new VariableExpression("varf")),
            new CompoundStatement(new VariableDeclarationStatement("varc", new IntType()),
            new CompoundStatement(new ReadFileStatement(new VariableExpression("varf"), "varc"),
            new CompoundStatement(new PrintStatement(new VariableExpression("varc")),
            new CompoundStatement(new ReadFileStatement(new VariableExpression("varf"), "varc"),
            new CompoundStatement(new PrintStatement(new VariableExpression("varc")),
            new CloseFileStatement(new VariableExpression("varf"))))))))));
        InterfaceStack<InterfaceStatement> stack1 = new myStack<InterfaceStatement>();
        InterfaceList<InterfaceValue> out1 = new myList<InterfaceValue>();
        InterfaceDictionary<String, InterfaceValue> symTable1 = new myDictionary<String, InterfaceValue>();
        InterfaceDictionary<String, BufferedReader> fileTable1 = new myDictionary<String, BufferedReader>();
        ProgramState pr1 = new ProgramState(stack1, symTable1, out1,ex1, fileTable1);
        Repo repo1 = new Repo(pr1, "log1.txt");

        /*
        int filename;
        filename = "test.in";
        openRFile(filename);
        int a;
        readFile(filename, a);
        int b;
        readFile(filename, b);
        if (a < b) then
            print("a<b");
        else
            if (b < a) then
                print("b<a");
            else
                if (a == b) then
                    print("a=b");
        */
        InterfaceStatement ex2 = 
            new CompoundStatement(new VariableDeclarationStatement("filename", new StringType()),
            new CompoundStatement(new AssignStatement("filename", new ValueExpression(new StringValue("test.in"))),
            new CompoundStatement(new OpenFileStatement(new VariableExpression("filename")),
            new CompoundStatement(new VariableDeclarationStatement("a", new IntType()),
            new CompoundStatement(new ReadFileStatement(new VariableExpression("filename"), "a"),
            new CompoundStatement(new VariableDeclarationStatement("b", new IntType()),
            new CompoundStatement(new ReadFileStatement(new VariableExpression("filename"), "b"),
            new IfElseStatement(new ComparationExpression("<", new VariableExpression("a"), new VariableExpression("b")),
            new PrintStatement(new ValueExpression(new StringValue("a<b"))),
            new IfElseStatement(new ComparationExpression("<", new VariableExpression("b"), new VariableExpression("a")),
            new PrintStatement(new ValueExpression(new StringValue("b<a"))),
            new IfStatement(new ComparationExpression("==", new VariableExpression("a"), new VariableExpression("b")),
            new PrintStatement(new ValueExpression(new StringValue("a=b")))))))))))));
        InterfaceStack<InterfaceStatement> stack2 = new myStack<InterfaceStatement>();
        InterfaceList<InterfaceValue> out2 = new myList<InterfaceValue>();
        InterfaceDictionary<String, InterfaceValue> symTable2 = new myDictionary<String, InterfaceValue>();
        InterfaceDictionary<String, BufferedReader> fileTable2 = new myDictionary<String, BufferedReader>();

        ProgramState pr2 = new ProgramState(stack2, symTable2, out2, ex2, fileTable2);
        Repo repo2 = new Repo(pr2, "log2.txt");
        


        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), new Controller(repo1)));
        menu.addCommand(new RunExample("2", ex2.toString(), new Controller(repo2)));
        menu.show();
    }
}
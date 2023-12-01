package com.pufi;

import java.io.BufferedReader;
import com.pufi.Controller.Controller;
import com.pufi.Model.ProgramState;
import com.pufi.Model.ADT.InterfaceDictionary;
import com.pufi.Model.ADT.InterfaceHeap;
import com.pufi.Model.ADT.InterfaceList;
import com.pufi.Model.ADT.InterfaceStack;
import com.pufi.Model.ADT.myDictionary;
import com.pufi.Model.ADT.myHeap;
import com.pufi.Model.ADT.myList;
import com.pufi.Model.ADT.myStack;
import com.pufi.Model.Expressions.ArithmeticExpression;
import com.pufi.Model.Expressions.ComparationExpression;
import com.pufi.Model.Expressions.HeapReadingExpression;
import com.pufi.Model.Expressions.ValueExpression;
import com.pufi.Model.Expressions.VariableExpression;
import com.pufi.Model.Statements.AssignStatement;
import com.pufi.Model.Statements.CloseFileStatement;
import com.pufi.Model.Statements.CompoundStatement;
import com.pufi.Model.Statements.HeapWriteStatement;
import com.pufi.Model.Statements.IfElseStatement;
import com.pufi.Model.Statements.IfStatement;
import com.pufi.Model.Statements.InterfaceStatement;
import com.pufi.Model.Statements.NewHeapStatement;
import com.pufi.Model.Statements.OpenFileStatement;
import com.pufi.Model.Statements.PrintStatement;
import com.pufi.Model.Statements.ReadFileStatement;
import com.pufi.Model.Statements.VariableDeclarationStatement;
import com.pufi.Model.Statements.WhileStatement;
import com.pufi.Model.Types.IntType;
import com.pufi.Model.Types.ReferenceType;
import com.pufi.Model.Types.StringType;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.Values.StringValue;
import com.pufi.Repository.Repo;
import com.pufi.View.*;
import com.pufi.Model.Values.IntValue;

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
        InterfaceHeap<InterfaceValue> heapTable1 = new myHeap<InterfaceValue>();
        ProgramState pr1 = new ProgramState(stack1, symTable1, out1,ex1, fileTable1, heapTable1);
        Repo repo1 = new Repo(pr1, "log1.txt");

        /*
        Ref int v;
        new(v,20);
        Ref Ref int a;
        new(a,v);
        print(v);
        print(a);
        */
        InterfaceStatement ex2 =
            new CompoundStatement(new VariableDeclarationStatement("v",new ReferenceType(new IntType())),
            new CompoundStatement(new NewHeapStatement("v",new ValueExpression(new IntValue(20))),
            new CompoundStatement(new VariableDeclarationStatement("a",new ReferenceType(new ReferenceType(new IntType()))),
            new CompoundStatement(new NewHeapStatement("a",new VariableExpression("v")),
            new CompoundStatement(new PrintStatement(new VariableExpression("v")),
            new PrintStatement(new VariableExpression("a")))))));


        InterfaceStack<InterfaceStatement> stack2 = new myStack<InterfaceStatement>();
        InterfaceList<InterfaceValue> out2 = new myList<InterfaceValue>();
        InterfaceDictionary<String, InterfaceValue> symTable2 = new myDictionary<String, InterfaceValue>();
        InterfaceDictionary<String, BufferedReader> fileTable2 = new myDictionary<String, BufferedReader>();
        InterfaceHeap<InterfaceValue> heapTable2 = new myHeap<InterfaceValue>();

        ProgramState pr2 = new ProgramState(stack2, symTable2, out2, ex2, fileTable2, heapTable2);
        Repo repo2 = new Repo(pr2, "log2.txt");

        /*
        Ref int v;
        new(v,20);
        Ref Ref int a;
        new(a,v);
        print(rH(v));
        print(rH(rH(a)) + 5);
         */

        InterfaceStatement ex3 =
            new CompoundStatement(new VariableDeclarationStatement("v",new ReferenceType(new IntType())),
            new CompoundStatement(new NewHeapStatement("v",new ValueExpression(new IntValue(20))),
            new CompoundStatement(new VariableDeclarationStatement("a",new ReferenceType(new ReferenceType(new IntType()))),
            new CompoundStatement(new NewHeapStatement("a",new VariableExpression("v")),
            new CompoundStatement(new PrintStatement(new HeapReadingExpression(new VariableExpression("v"))),
            new PrintStatement(new ArithmeticExpression('+',new HeapReadingExpression(new HeapReadingExpression(new VariableExpression("a"))),new ValueExpression(new IntValue(5)))))))));
        
        InterfaceStack<InterfaceStatement> stack3 = new myStack<InterfaceStatement>();
        InterfaceList<InterfaceValue> out3 = new myList<InterfaceValue>();
        InterfaceDictionary<String, InterfaceValue> symTable3 = new myDictionary<String, InterfaceValue>();
        InterfaceDictionary<String, BufferedReader> fileTable3 = new myDictionary<String, BufferedReader>();
        InterfaceHeap<InterfaceValue> heapTable3 = new myHeap<InterfaceValue>();

        ProgramState pr3 = new ProgramState(stack3, symTable3, out3, ex3, fileTable3, heapTable3);
        Repo repo3 = new Repo(pr3, "log3.txt");


        /*  
        Ref int v;
        new(v,20);
        print(rH(v));
        wH(v,30);
        print(rH(v)+5);
         */

        InterfaceStatement ex4 =
            new CompoundStatement(new VariableDeclarationStatement("v",new ReferenceType(new IntType())),
            new CompoundStatement(new NewHeapStatement("v",new ValueExpression(new IntValue(20))),
            new CompoundStatement(new PrintStatement(new HeapReadingExpression(new VariableExpression("v"))),
            new CompoundStatement(new HeapWriteStatement("v",new ValueExpression(new IntValue(30))),
            new PrintStatement(new ArithmeticExpression('+',new HeapReadingExpression(new VariableExpression("v")),new ValueExpression(new IntValue(5))))))));

        InterfaceStack<InterfaceStatement> stack4 = new myStack<InterfaceStatement>();
        InterfaceList<InterfaceValue> out4 = new myList<InterfaceValue>();
        InterfaceDictionary<String, InterfaceValue> symTable4 = new myDictionary<String, InterfaceValue>();
        InterfaceDictionary<String, BufferedReader> fileTable4 = new myDictionary<String, BufferedReader>();
        InterfaceHeap<InterfaceValue> heapTable4 = new myHeap<InterfaceValue>();

        ProgramState pr4 = new ProgramState(stack4, symTable4, out4, ex4, fileTable4, heapTable4);
        Repo repo4 = new Repo(pr4, "log4.txt");


        /*
        Ref int v;
        new(v,20);
        Ref Ref int a;
        new(a,v);
        new(v,30);
        print(rH(rH(a)));
         */

        InterfaceStatement ex5 =
            new CompoundStatement(new VariableDeclarationStatement("v",new ReferenceType(new IntType())),
            new CompoundStatement(new NewHeapStatement("v",new ValueExpression(new IntValue(20))),
            new CompoundStatement(new VariableDeclarationStatement("a",new ReferenceType(new ReferenceType(new IntType()))),
            new CompoundStatement(new NewHeapStatement("a",new VariableExpression("v")),
            new CompoundStatement(new NewHeapStatement("v",new ValueExpression(new IntValue(30))),
            new PrintStatement(new HeapReadingExpression(new HeapReadingExpression(new VariableExpression("a")))))))));

        InterfaceStack<InterfaceStatement> stack5 = new myStack<InterfaceStatement>();
        InterfaceList<InterfaceValue> out5 = new myList<InterfaceValue>();
        InterfaceDictionary<String, InterfaceValue> symTable5 = new myDictionary<String, InterfaceValue>();
        InterfaceDictionary<String, BufferedReader> fileTable5 = new myDictionary<String, BufferedReader>();
        InterfaceHeap<InterfaceValue> heapTable5 = new myHeap<InterfaceValue>();

        ProgramState pr5 = new ProgramState(stack5, symTable5, out5, ex5, fileTable5, heapTable5);
        Repo repo5 = new Repo(pr5, "log5.txt");

        /* 
        int v;
        v=4;
        while (v>0) {
            print(v);
            v=v-1;
        }
        print(v);
         */

        InterfaceStatement ex6 =
            new CompoundStatement(new VariableDeclarationStatement("v",new IntType()),
            new CompoundStatement(new AssignStatement("v",new ValueExpression(new IntValue(4))),
            new WhileStatement(new ComparationExpression(">",new VariableExpression("v"),new ValueExpression(new IntValue(0))),
            new CompoundStatement(new PrintStatement(new VariableExpression("v")),
            new AssignStatement("v",new ArithmeticExpression('-',new VariableExpression("v"),new ValueExpression(new IntValue(1))))))));

        InterfaceStack<InterfaceStatement> stack6 = new myStack<InterfaceStatement>();
        InterfaceList<InterfaceValue> out6 = new myList<InterfaceValue>();
        InterfaceDictionary<String, InterfaceValue> symTable6 = new myDictionary<String, InterfaceValue>();
        InterfaceDictionary<String, BufferedReader> fileTable6 = new myDictionary<String, BufferedReader>();
        InterfaceHeap<InterfaceValue> heapTable6 = new myHeap<InterfaceValue>();

        ProgramState pr6 = new ProgramState(stack6, symTable6, out6, ex6, fileTable6, heapTable6);
        Repo repo6 = new Repo(pr6, "log6.txt");



        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), new Controller(repo1)));
        menu.addCommand(new RunExample("2", ex2.toString(), new Controller(repo2)));
        menu.addCommand(new RunExample("3", ex3.toString(), new Controller(repo3)));
        menu.addCommand(new RunExample("4", ex4.toString(), new Controller(repo4)));
        menu.addCommand(new RunExample("5", ex5.toString(), new Controller(repo5)));
        menu.addCommand(new RunExample("6", ex6.toString(), new Controller(repo6)));
        menu.show();
    }
}
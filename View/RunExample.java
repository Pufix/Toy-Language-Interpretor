package com.pufi.View;

import com.pufi.Controller.Controller;

public class RunExample extends Command{
    private Controller ctr;
    public RunExample(String key,String descritopn,Controller ctr){
        super(key, descritopn);
        this.ctr=ctr;
    }
    @Override
    public void execute(){
        try{
            ctr.executeAll();
            System.out.println(ctr.getRepoOutput());
        }catch (Exception e){
            System.out.print(e.getMessage());}
    }
}

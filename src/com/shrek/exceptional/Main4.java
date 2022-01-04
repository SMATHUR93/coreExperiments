package com.shrek.exceptional;

import java.io.FileNotFoundException;

public class Main4 {

    int polo = 0;

    public static void main(String[] args) {
        /*Main4 main4  = new Main4();
        System.out.println( main4.meth1(0) );*/
        /*Foo foo = new Foo(5);
        try{
            System.out.println(foo.poo());
        } catch(Exception e){
            e.printStackTrace();
        }*/
        Main4 main4  = new Main4(69);
        System.out.println( ++main4.polo );
    }

    Main4(){

    }

    private Main4(int a){
        this.polo = a;
        System.out.println("My private constructor");
    }

    int meth1(int a){
        int val = 0;
        try{
            val = 10/a;
            System.out.println("TRY I VAL " + val);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            val-=3;
            System.out.println("Finally I " + val);
            return val;
        }
        /*try{
            val = 10*a;
            System.out.println("TRY II VAL " + val);
        } finally{
            val-=1;
            System.out.println("Finally II " + val);
        }*/
        /*val+=10;
        System.out.println("VAL INC " + val);
        return val;*/
    }

}

class Foo{
    int bar;
    Foo(int bar){
        this.bar = bar;
    }
    int poo() throws FileNotFoundException{
        //return bar;
        try{
            throw new FileNotFoundException();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return bar;
        }
    }
}
package org.example;

public class ImposibleValue extends Exception{
    static String text = "Impossible value. Try again";

    public ImposibleValue(){
        super(text);
    }
}

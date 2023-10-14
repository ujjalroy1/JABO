/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jabo;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.toLowerCase;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Characterinjava
{
    public static void main(String[] args) 
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter any character : ");
        char ch;
        String s;
        s=input.next();
        ch=s.charAt(0);
      
        if(isDigit(ch))
        {
            System.out.println("digit");
        }
        else if(isLetter(ch))
        {
            System.out.println("Letter");
        }
        ch=toLowerCase(ch);
        System.out.println(ch);
    }
}
//isDigit(ch) Returns true if the specified character is a digit.
//isLetter(ch) Returns true if the specified character is a letter.
//isLetterOrDigit(ch) Returns true if the specified character is a letter or digit.
//isLowerCase(ch) Returns true if the specified character is a lowercase letter.
//isUpperCase(ch) Returns true if the specified character is an uppercase letter.
//toLowerCase(ch) Returns the lowercase of the specified character.
//toUpperCase(ch) Returns the uppercase of the specified character.
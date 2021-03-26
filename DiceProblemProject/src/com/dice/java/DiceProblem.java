package com.dice.java;


import java.util.Scanner;

public class DiceProblem {

	public static void main(String[] args) 
	{
		DiceProblem obj=new DiceProblem();
		
		int sum=0;
		System.out.println("you are rolling 5 dices simultaneously........");
		
		sum=obj.getDiceValue(6,1)+obj.getDiceValue(6,1)+obj.getDiceValue(6,1)+obj.getDiceValue(6,1)+obj.getDiceValue(6,1);
		System.out.println("sum total of the rolls result= "+sum);
		
		

	}

	public int getDiceValue(int max,int min)
	{
		return (int)(Math.random()*(max-min))+min;
	}
}

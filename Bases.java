package com.battingstats;

public class Bases {

	int bases = 0;
	
	public Bases(int bases)
	{
		this.bases = bases;
	}
	
	public static boolean validRecord(int bases)
	{
		switch (bases)
		{
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return true;
		default:
			System.out.println("Invalid entry. Please enter a valid number of bases (0-4).");
			return false;
		}
	}
}

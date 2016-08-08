package com.battingstats;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateBattingStats {
	
	public static void main(String[] args) {

		CalculateBattingStats battingStats = new CalculateBattingStats();
		battingStats.calculateStats();
	}

	private float numAtBats = 0.0f;
	private float battingAvg = 0.0f;
	private float sluggingPercent = 0.0f;
	private static Scanner bb = new Scanner(System.in);
	private String nameBatter = getNameOfBatter();
	
	public CalculateBattingStats() {
		
	}
	
	public CalculateBattingStats(float numAtBats, float battingAvg, float sluggingPercent,
			String nameBatter) {
		this.numAtBats = numAtBats;
		this.battingAvg = battingAvg;
		this.sluggingPercent = sluggingPercent;
		this.nameBatter = nameBatter;
	}
	
	public void calculateStats() {
		ArrayList<Bases> bases = new ArrayList<>();
	//	ArrayList<Batter> batter = new ArrayList<>(9);
		float numAtBats = getNumAtBats();
		float numHits = 0.0f;
		float numBases = 0.0f;
		float battingAvg = 0.0f;
		float sluggingPercent = 0.0f;
		
		
		for (int i = 0; i < numAtBats; i++) {
				
			Bases record = newRecord(i);
			
			if (record.bases > 0)
				numHits++;
			
			singleDouble(record);
			
			numBases += record.bases;
		
			bases.add(record);
		}
		
		battingAvg = numHits / numAtBats;
		sluggingPercent = numBases / numAtBats;
		
		System.out.format(nameBatter + "'s batting average is %.3f \n", battingAvg);
		System.out.format(nameBatter + "'s slugging percent is %.3f \n", sluggingPercent);
		
		
	}

	private void singleDouble(Bases record) {
		
		String noBase = nameBatter + " did not get a hit.\n";
		String oneBase = nameBatter + " hit a single!\n";
		String twoBase = nameBatter + " hit a double!\n";
		String threeBase = nameBatter + " hit a triple!\n";
		String fourBase = nameBatter + " hit a homerun!\n";
		
		switch (record.bases)
		{
		case 1:
			System.out.println(oneBase);
			break;
		case 2:
			System.out.println(twoBase);
			break;
		case 3:
			System.out.println(threeBase);
			break;
		case 4:
			System.out.println(fourBase);
			break;
		default:
			System.out.println(noBase);
		}
	}

	public float getBattingAvg() {
		return battingAvg;
	}

	public float getSluggingPercent() {
		return sluggingPercent;
	}
	
	public static String getNameOfBatter() {
		
		System.out.println("What is the name of the batter?");
		String nameBatter = bb.nextLine();
		return nameBatter;
	}
	
	public int getNumAtBats() {

		int numAtBatInput = 0;
		
		do {
			System.out.println("How many at-bats did " + nameBatter + " have for the game?");
			
			try {
				numAtBatInput = Integer.parseInt(bb.next());
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, please re-enter your input");
			}
		} while (numAtBatInput <= 0);
			
			return numAtBatInput;
	}
	
	public Bases newRecord(int numAtBats) {
		
		int basesInput = -1;
		
		do {
			System.out.format("How many bases did " + nameBatter + " take for at-bat number %d ?\n",
					numAtBats + 1);
			try {
				basesInput = Integer.parseInt(bb.next());
				
			} catch (NumberFormatException e) {
				
			}
		} while (!Bases.validRecord(basesInput));
		
		return new Bases(basesInput);
	}
}

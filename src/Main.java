/****************************************************************
 * file: Main.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 2
 * date last modified: 2018-01-21
 * 
 * purpose: This program builds a max-heap twice: once using s series of
 * insertions, and again using the optimal method. The program then
 * prints the number of swaps and the heap after 10 removals
 * 
 ****************************************************************/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);
	static Random rand = new Random();
	static ArrayList<HashSet<Integer>> randoms = new ArrayList<HashSet<Integer>>(); 
	
	static void printCommandMenu() {
		System.out.println("Please select how to test the program:");
		System.out.println("(1) 20 sets of 100 randomly generated integers");
		System.out.println("(2) Fixed integer values 1-100");
	}
	
	static void handleRandom() {
		for(int i=0; i<20; i++) {
			HashSet<Integer> pete = new HashSet<Integer>();
			while(pete.size() < 100) {
				pete.add(rand.nextInt(1000));
			}
			randoms.add(pete);
		}
	}
	
	static void handleFixed() {
		
	}
	
	public static void main(String[] args) {
		while(true) {
			printCommandMenu();
			
			switch(in.nextInt()) {
			case 1:
				handleRandom();
				break;
			case 2:
				handleFixed();
				break;
			default:
				System.out.println("Invalid command, try again");
				break;
			}
			
		}

	}

}

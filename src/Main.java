/****************************************************************
 * file: Main.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 2
 * date last modified: 2018-01-21
 * 
 * purpose: This program builds a max-heap twice: once using a series of
 * insertions, and again using the optimal method. The user is given 2
 * different ways to test the program, each giving a unique output:
 * Option (1) displays the average number of swaps
 * Option (2) displays the number of swaps and the heap after 10 removals
 * 
 ****************************************************************/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import TreePackage.MaxHeap;

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
		randoms.clear();
		for(int i=0; i<20; i++) {
			HashSet<Integer> pete = new HashSet<Integer>();
			while(pete.size() < 100) {
				pete.add(rand.nextInt(1000));
			}
			randoms.add(pete);
		}
		
		MaxHeap<Integer> optimum;
		int optimumSwaps = 0;
		for(int i=0; i<randoms.size(); i++) {
			optimum = new MaxHeap<Integer>(randoms.get(i).toArray());
			optimumSwaps += optimum.getSwaps();
		}
		
		MaxHeap<Integer> inserts = new MaxHeap<Integer>(100);
		int insertSwaps = 0;
		for(int j=0; j<randoms.size(); j++) {
			for(int i=0 ; i< randoms.get(j).toArray().length; i++) {
				inserts.add((Integer) randoms.get(j).toArray()[i]);
			}
			insertSwaps += inserts.getSwaps();
			inserts.clear();
		}

		System.out.println("Average swaps for series of insertions: "+insertSwaps/100);
		System.out.println("Average swaps for optimal method: " + optimumSwaps/100);
	}
	
	static void handleFixed() {
		System.out.println("Heap built using series of insertions:");
		System.out.println("Number of swaps:");
		System.out.println("Heap after 10 removals:");
		System.out.println("Heap built using optimal method: ");
		System.out.println("Number of swaps:");
		System.out.println("Heap after 10 removals:");
	}
	
	public static void main(String[] args) {
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

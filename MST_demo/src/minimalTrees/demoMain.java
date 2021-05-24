package minimalTrees;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class demoMain {
	public static void main(String[] args ) throws IOException{
		InputStream demoInput = new FileInputStream("C:\\Users\\User\\Desktop\\School Files\\Freshman Quarter 3\\CSC 301 Data Structures II\\Java\\MinimumSpanningTrees\\demoinput.txt");
		// TODO Auto-generated method stub
		System.out.println("Welcome to MST Demo");
		EdgeWeightedGraph graphDemo = new EdgeWeightedGraph(demoInput);
		System.out.println(graphDemo.toString());

		///Implement Prim's Algorithm -
		//In another class/interface, create a class called Prim's tree that generates an MST from prim's algorithm
		//Include a Printing function to display what's in the class. 
		System.out.println("Prim's algorithm");
		PrimsAlgorithm prims = new PrimsAlgorithm(graphDemo);
		System.out.println(prims.toString());
		///Implement Kurskal's Algorithm -
		//same as 1. but with Kruskal.
		System.out.println("Kruskal's algorithm");
		KruskalsAlgorithm kruskals = new KruskalsAlgorithm(graphDemo);
		System.out.println(kruskals.toString());
		///Generate a CTA edge wieghted graph-
		//Weights are the total time spent sitting in the train. 
		
		
		
	}

}

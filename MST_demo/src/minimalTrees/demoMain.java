package minimalTrees;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class demoMain {
	public static void main(String[] args ) throws IOException{
		InputStream demoInput = new FileInputStream("demoinput.txt");
		InputStream ctaInput = new FileInputStream("cta.txt");
		// TODO Auto-generated method stub
		System.out.println("Welcome to MST Demo");
		EdgeWeightedGraph graphDemo = new EdgeWeightedGraph(demoInput);		
		System.out.print(graphDemo.toString());
		System.out.println("Weight of Edge Weighted Graph: " + graphDemo.getWeight() + "\n");


		///Implement Prim's Algorithm -
		//In another class/interface, create a class called Prim's tree that generates an MST from prim's algorithm
		//Include a Printing function to display what's in the class. 
		System.out.println("Prim's algorithm");
		PrimsAlgorithm prims = new PrimsAlgorithm(graphDemo);
		System.out.print(prims.toString());
		System.out.println("Weight of Prim's MST: " + prims.weight() + "\n");
		
		///Implement Kurskal's Algorithm -
		//same as 1. but with Kruskal.
		System.out.println("Kruskal's algorithm");
		KruskalsAlgorithm kruskals = new KruskalsAlgorithm(graphDemo);
		System.out.print(kruskals.toString());
		System.out.println("Weight of Edge Weighted Graph: " + kruskals.weight() + "\n"); 
		
		///Generate a CTA edge wieghted graph-
		//Weights are the total time spent sitting in the train. 
		EdgeWeightedGraph ctaMap = new EdgeWeightedGraph(ctaInput);
		System.out.print(ctaMap.toString());
		System.out.println("CTA Map weight: " + ctaMap.getWeight() + "\n");
		PrimsAlgorithm CTAprims = new PrimsAlgorithm(ctaMap);
		System.out.print(CTAprims.toString());
		System.out.println("Weight of Prim's CTA MST: " + CTAprims.weight() + "\n");
		KruskalsAlgorithm CTAkruskals = new KruskalsAlgorithm(ctaMap);
		System.out.print(CTAkruskals.toString());
		System.out.println("Weight of Kruskal's CTA MST:" + CTAkruskals.weight());
		
		
		
		//graph tests: 
		//the graph demo weight is 1.84, see attached image DemoInput.png
		MSTTest demoTest = new MSTTest(); 
		demoTest.testKruskal(graphDemo, 1.84);
		demoTest.testPrimms(graphDemo, 1.84);
		
		MSTTest CTATest = new MSTTest();
		CTATest.testKruskal(ctaMap, 52.9f);
		CTATest.testPrimms(ctaMap, 52.9f);
	}

}

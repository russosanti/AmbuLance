package Threads;

public class Main_Threads {

	public static void mainth(String[] args) {
		Exclusion_Mutua m = new Exclusion_Mutua();
		
		Thread_1 p1 = new Thread_1("P1",m);
		Thread_1 p2 = new Thread_1("P2",m);
		Thread_1 p3 = new Thread_1("P3",m);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}

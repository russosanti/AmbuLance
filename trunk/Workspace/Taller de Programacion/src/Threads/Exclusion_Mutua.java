package Threads;

public class Exclusion_Mutua {
	
	Exclusion_Mutua(){
		
	}
	
	public void mos(String s){
		try {
			Thread.sleep(1000);
			System.out.println(s+": Antes exlucion mutua");
			Thread.sleep(1000);
			System.out.println(s+": Inicio exclusion mutua");
			this.met();
			System.out.println(s+": Fin exclusion");
			Thread.sleep(1000);
			System.out.println(s+": Salida exclusion exclusion");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public synchronized void met(){
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

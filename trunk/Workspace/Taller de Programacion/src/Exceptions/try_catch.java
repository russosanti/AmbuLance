package Exceptions;


public class try_catch {
	public static void main(String[] args) {
		try{
			System.out.print("Mira: ");
			System.out.println(mi_divide(9,0));
		}catch(Divide_Exception e){
			System.out.println(e.getMessage());
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
		finally{
			System.out.println("Chauu");
		}
	}
	
	public static int divide(int a, int b) throws ArithmeticException{
		return a/b;
	}
	
	public static int mi_divide(int a, int b) throws Divide_Exception{
		if(b==0){
			throw new Divide_Exception("Bestia no se divide por 0 da infinito");
		}else{
			return a/b;
		}
	}
}

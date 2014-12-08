package Interfaz;

import java.util.ArrayList;

import Sistema.Sistema;

public class IU implements IUser{
	private Sistema nucleo;
	private ConsoleWriter printer;
	private ConsoleReader reader;
	private boolean exit = false;
	
	// Constructor
	public IU(){
		printer = new ConsoleWriter();
		reader = new ConsoleReader();
	}
	
	public void load(){
		this.menu_ppal();
	}
	
	public void setS(Sistema s){
		if(s==null){
			this.error("No se pudo inicializar el Sistema");
			System.exit(1);
		}else{
			nucleo = s;
		}
	}
	
	public void error(String s){
		this.printer.error(s);
	}
	
	public void informar(String s){
		this.printer.printer(s);
	}
	
	public void informe_torre(String s){
		this.printer.printer(s);
	}
	
	public void menu_ppal(){
		/*
		this.printer.printer(Interfaz.Menu_Utils.generar());
		Interfaz.Menu_Utils.menu_dispatch(this.nucleo,Integer.parseInt(this.ingreso("Ingrese la opcion elejida: ")),this);
		*/
		this.informar("Bienvenido al simulador de ambulancias!\nEscriba " +
					  "help para ver las opciones disponibles");
		this.ingreso("");
	}


	public void ingreso(String s) {
		ArrayList<String> as;
	
		while(!this.exit){
			try {
				as = this.reader.getInput();
				traductor.traducir(as, this, this.nucleo);
			} catch (IndexOutOfBoundsException e) {
				traductor.traducir(null, this, this.nucleo);
			}

		}	
	}
	
	public String pedido(String s){
		ArrayList<String> ar;
		this.printer.printer(s);
		ar = this.reader.getInput();
		return ar.get(0);
	}
	
	public void salir() {
		this.exit = true;
	}
	
	public void borrar_pantalla(){
		this.printer.borrar();
	}
}



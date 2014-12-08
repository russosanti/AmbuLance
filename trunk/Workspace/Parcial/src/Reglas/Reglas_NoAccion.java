package Reglas;

import java.util.ArrayList;
import Piedra_Papel_Tijera.Eleccion;

public interface Reglas_NoAccion {
	public ArrayList<Eleccion> eleccion(ArrayList<Eleccion> jugant_1,ArrayList<Eleccion> jugant_2);
}
package Parciales.Biblioteca;

public class Libro implements Objeto_Biblio{
	
	private Biblioteca biblio;
	private int pos_actual;
	private long codLib;
	private String nomLib;
	private String autLib;
	private String editLib;
	
	public Libro(long cod,String nom,String aut,String edit){
		this.pos_actual = -1;
		this.codLib = cod;
		this.nomLib = nom;
		this.autLib = aut;
		this.editLib = edit;
	}
	
	public void set_Biblioteca(Biblioteca b) {
		this.biblio = b;		
	}

	public Biblioteca get_Biblioteca() {
		return this.biblio;
	}

	public Class<? extends Objeto_Biblio> tipo() {
		return this.getClass();
	}

	public int get_pos_absoluta() {
		return this.pos_actual;
	}
	public void set_pos_actual(int x){
		this.pos_actual = x;
	}

	public void setCodLib(long codLib) {
		this.codLib = codLib;
	}
	public long getCodLib() {
		return codLib;
	}

	public void setNomLib(String nomLib) {
		this.nomLib = nomLib;
	}
	public String getNomLib() {
		return nomLib;
	}

	public void setAutLib(String autLib) {
		this.autLib = autLib;
	}
	public String getAutLib() {
		return autLib;
	}

	public void setEditLib(String editLib) {
		this.editLib = editLib;
	}
	public String getEditLib() {
		return editLib;
	}
}

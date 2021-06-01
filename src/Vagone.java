
public class Vagone {
	private int numPostiOccupati;
	private int numPostiMax;
	private String matricola;
	private int tipoClasse;
	//modifica fatta online
	public Vagone(int nPostiO, int nPostiM, String mat, int tipoC) {
		numPostiOccupati=nPostiO;
		numPostiMax=nPostiM;
		matricola=mat;
		tipoClasse=tipoC;
	}

	public int getNumPostiOccupati() {
		return numPostiOccupati;
	}

	public void setNumPostiOccupati(int numPostiOccupati) {
		this.numPostiOccupati = numPostiOccupati;
	}

	public int getNumPostiMax() {
		return numPostiMax;
	}

	public void setNumPostiMax(int numPostiMax) {
		this.numPostiMax = numPostiMax;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public int getTipoClasse() {
		return tipoClasse;
	}

	public void setTipoClasse(int tipoClasse) {
		this.tipoClasse = tipoClasse;
	}

	@Override
	public String toString() {
		return "Vagone [numPostiOccupati=" + numPostiOccupati + ", numPostiMax=" + numPostiMax + ", matricola="
				+ matricola + ", tipoClasse=" + tipoClasse + "]";
	}
	
	public static void main(String[] args) {
		Vagone v1=new Vagone(5, 10, "1234", 2);
		Vagone v2=new Vagone(8, 15, "9876", 1);
		System.out.println(v1.toString());
		System.out.println(v2.toString());
	}
	
}

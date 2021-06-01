import java.util.Arrays;
/**
 * 
 * @author Luca
 * versione 1 online
 */
//modificato online
public class Treno {
	private int numVagoniPresenti,numVagoniMax;
	private String nomeTreno;
	private Vagone[] listaVagoni;
	
	public Treno(String nomeTr, int nVagMax) {
		numVagoniPresenti=0;
		nomeTreno=nomeTr;
		listaVagoni=new Vagone[nVagMax];
	}

	public int getNumVagoniPresenti() {
		return numVagoniPresenti;
	}

	public void setNumVagoniPresenti(int numVagoniPresenti) {
		this.numVagoniPresenti = numVagoniPresenti;
	}

	public String getNomeTreno() {
		return nomeTreno;
	}

	public void setNomeTreno(String nomeTreno) {
		this.nomeTreno = nomeTreno;
	}

	@Override
	public String toString() {
		return "Treno [numVagoniPresenti=" + numVagoniPresenti + ", nomeTreno=" + nomeTreno + ", listaVagoni="
				+ Arrays.toString(listaVagoni) + "]";
	}
	
	//aggiungi vagone con parametri
	public boolean addVagone(int nPostiO,int nPostiM, String mat, int tipoC) {
		listaVagoni[numVagoniPresenti]=new Vagone(nPostiO, nPostiM, mat, tipoC);
		this.numVagoniPresenti++;
		if(numVagoniPresenti>numVagoniMax) {
			return false;
		}
		return true;
	}
	
	//aggiungi vagone passando l'oggetto
	public boolean addVagone(Vagone v) {
		
		listaVagoni[numVagoniPresenti]=v;
		numVagoniPresenti++;
		
		if(numVagoniPresenti>numVagoniMax) {
			return false;
		}
		return true;
				
	}
	
	//eliminazione vagone
	public boolean eliminaVagone(String matricola) {
		for(int i=0;i<this.numVagoniPresenti;i++) {
			
			if(listaVagoni[i].getMatricola().compareToIgnoreCase(matricola)==0) {
				for(int k=i;k<numVagoniPresenti;k++) {
					listaVagoni[k]=listaVagoni[k+1];
				}
				numVagoniPresenti--;
				return true;
			}			
		}
		return false;
	}
	
	//Passeggeri totali
	public void visualizza() {
		for(int i=0; i<numVagoniPresenti;i++) {
			System.out.println(listaVagoni[i].getNumPostiOccupati());
		}
	}
	
	//Cerca vagone per matricola
	public Vagone ricercaVag(String matricola) {
		Vagone vag;
		vag=null;
		for(int i=0;i<numVagoniPresenti;i++) {
			if(listaVagoni[i].getMatricola().equals(matricola)) {
				vag=listaVagoni[i];
			}
		}
		return vag;
	}
	
	//ricerca vagoni con posti disponibili
	public Vagone[] ricercaVagDisp() {
		Vagone[] vagDisp=new Vagone[numVagoniPresenti];
		int a=0;  //contatore
		for(int i=0;i<numVagoniPresenti;i++) {
			if(listaVagoni[i].getNumPostiOccupati()<listaVagoni[i].getNumPostiMax()) {
				vagDisp[a]=listaVagoni[i];
				a++;
			}
		}
		return vagDisp;
	}
	
	//main
	public static void main(String[] args) {
		//creazione oggetti
		Vagone v1=new Vagone(5, 10, "1234", 1);
		Vagone v2=new Vagone(8, 15, "9876", 1);
		Treno t1=new Treno("milano-roma", 10);
		
		//aggiungi vagone
		t1.addVagone(v1);
		t1.addVagone(v2);
		t1.addVagone(20, 21, "ab12", 1);
		System.out.println(t1);
		
		//elimina vagone
		System.out.println("Eliminazione vagone:");
		t1.eliminaVagone("ab12");
		System.out.println(t1);
		
		
		//ricerca per matricola
		System.out.println("Ricerca vagone tramite matricola:(matricola cercata: 1234)");
		System.out.println(t1.ricercaVag("1234"));
		
		//ricerca vagone con posti disponibili
		System.out.println("Ricerca vagone con posti disponibili:");
		Vagone[] vagDisp=t1.ricercaVagDisp();
		for(int i=0; i<vagDisp.length; i++) {
			if(vagDisp[i]!=null) {
				System.out.println(vagDisp[i].toString());
			}
		}
	}

}

package tp21;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient{

	private String nom ;
	private Set <String > ordonnance ;
	
	public Set<String> getOrdonnance() {
		return ordonnance;
	}

	public Patient ( String n){
	nom = n ;
	ordonnance = new HashSet <String>();
	}
	
	public String getNom () { 
		return nom ;
	}
	
	public boolean ordonnanceVide() {
		/*if(this.ordonnance != null)
			return false;
		else
			return true;*/
		return this.ordonnance.isEmpty();
	}
	
	public void ajoutMedicament ( String m) {
		this.ordonnance.add(m);
	}
	
	public void affiche(){
		System.out.println("le nom de patient : "+this.nom+" l'ordonnance : "+this.ordonnance);
	}
	
	public boolean contientMedicament (String m) {
		return this.ordonnance.contains(m);
	}
	
	public void trieOrdonnace() {
		TreeSet<String> s = new TreeSet<>(this.ordonnance);
		this.ordonnance = s;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}

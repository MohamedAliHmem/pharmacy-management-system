package tp21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DossierPharmacie {

	private String nom ;
	private HashMap <String , Patient > patients ;
	
	public DossierPharmacie ( String n){
		nom =n;
		patients = new HashMap <String , Patient >();
	}
	
	void nouveauPatient ( String nom , String [] ord ){
		Patient p = new Patient(nom);
		for(String s : ord) {
			if(p.ordonnanceVide()) {
				p.ajoutMedicament(s);
			}else {
				if(p.contientMedicament(s)) {
					continue;
				}else {
					p.ajoutMedicament(s);
				}
			}
		}
		
		this.patients.put(nom.toLowerCase(), p);
	}
	
	
	public boolean ajoutMedicament (String nom, String m){
		if(!this.patients.containsKey(nom.toLowerCase())) {
			return false;
		}else {
			Patient p = this.patients.get(nom.toLowerCase());
			p.ajoutMedicament(m);
			return true;
		}
	}
	
	public void affichePatient (String nom){
		Patient patient = patients.get(nom.toLowerCase());
        patient.affiche();
	}
	
	public void affiche (){
		System.out.println("nom : " + nom);
        for (Patient patient : patients.values()) {
            patient.affiche();
        }
	}
	
	public Collection <String > affichePatientAvecMedicament (String m){
		List<String> patientsAvecMedicament = new ArrayList<>();
        for (Patient patient : patients.values()) {
            if (patient.contientMedicament(m)) {
                patientsAvecMedicament.add(patient.getNom());
            }
        }
        return patientsAvecMedicament;
	}
	
	
	
	public static void main(String[] args) {
		DossierPharmacie pharmacie = new DossierPharmacie("Ma Pharmacie");

        pharmacie.nouveauPatient("Alice", new String[]{"Paracetamol", "Aspirine"});
        pharmacie.nouveauPatient("Bob", new String[]{"Ibuprofene", "Aspirine", "Paracetamol"});
        pharmacie.nouveauPatient("Charlie", new String[]{"Aspirine", "Vitamine C"});

        pharmacie.ajoutMedicament("Alice", "Vitamine D");
        pharmacie.ajoutMedicament("Bob", "Vitamine C");

        System.out.println("Informations sur le patient Alice :");
        pharmacie.affichePatient("Alice");

        System.out.println("\nListe de tous les patients de la pharmacie :");
        pharmacie.affiche();

        String medicament = "Aspirine";
        System.out.println("\nPatients ayant pris le médicament " + medicament + " :");
        Collection<String> patientsAvecMedicament = pharmacie.affichePatientAvecMedicament(medicament);
        for (String nomPatient : patientsAvecMedicament) {
            System.out.println("- " + nomPatient);
        }

	}

}

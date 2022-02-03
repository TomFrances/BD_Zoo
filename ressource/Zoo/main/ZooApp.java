package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import dao.CageDAO;
import dao.GardienDAO;
import dao.AnimalDAO;
import modele.Cage;
import modele.Gardien;
import modele.Animal;
import modele.Specialite;
import oracle.sql.ARRAY;
import utils.LectureClavier;
import utils.TheConnection;

public class ZooApp {

	public static void main(String args[]) {

		try {

			/* Menu utilisateur */
			System.out.println("Bienvenue sur l'application de gestion du Zoo ! :D");
			Scanner sc = new Scanner(System.in);
			int choix;
			do {
				System.out.println("Que souhaitez-vous faire ?");
				System.out.println("[1] Affichage Animaux");
				System.out.println("[2] Ajouter un animal dans une cage");
				System.out.println("[3] Ajouter une cage à un gardien");
				System.out.println("[0] Quitter l'application.");
				choix = sc.nextInt();
				switch (choix) {
					case 1:
						System.out.flush();
						affichageAnimaux();
						break;
					case 2:
						System.out.flush();
						ajouterAnimal();
						break;
					case 3:
						System.out.flush();
						ajouterCageGardien();
						break;
					default:
						System.out.flush();
						break;
				}
			} while (choix != 0);
			sc.close(); // fermeture du scanner
			TheConnection.close();
			System.out.println("bye.");

			// traitement d'exception
		} catch (SQLException e) {
			TheConnection.close();
			System.err.println("failed");
			System.out.println("Affichage de la pile d'erreur");
			e.printStackTrace(System.err);
			System.out.println("Affichage du message d'erreur");
			System.out.println(e.getMessage());
			System.out.println("Affichage du code d'erreur");
			System.out.println(e.getErrorCode());
		}
	}

	/**
	 * Afficher la liste des animaux avec leur numéro de cage.
	 * 
	 * @throws SQLException
	 */
	private static void affichageAnimaux() throws SQLException {

		Connection conn = TheConnection.getInstance();
		AnimalDAO aDao = new AnimalDAO(conn);
		Set<Animal> listeAnimaux = new HashSet<>();
		listeAnimaux = aDao.readAll();
		listeAnimaux.forEach(x -> System.out.println(x));
		conn.rollback();
	}

	/**
	 * Ajouter un animal en choisissant sa cage de destination
	 */
	private static void ajouterAnimal() throws SQLException {
		Connection conn = TheConnection.getInstance();
		CageDAO cageDao = new CageDAO(conn);

		Scanner sc = new Scanner(System.in);
		System.out.println("Saisie d'un nouvel animal");

		System.out.print("Nom : ");
		String nom = sc.nextLine();

		System.out.print("Sexe : ");
		String sexe = sc.nextLine();

		System.out.print("Type : ");
		String type = sc.nextLine();

		System.out.print("Fonction de la cage : ");
		String fonction = sc.nextLine();

		System.out.print("Pays d'origine : ");
		String pays = sc.nextLine();

		System.out.print("Année de naissance : ");
		int anNaiss = sc.nextInt();

		System.out.print("Numéro de la cage de l'animal : ");
		Set<Cage> listeCagesFonction = cageDao.readByFonction(fonction);
		ArrayList<Integer> listeNumCages = new ArrayList<>();
		listeCagesFonction.forEach(cage -> listeNumCages.add(cage.getNoCage()));

		int noCageTemp = -1;
		do {
			System.out.print("Cage(s) disponible(s) : ");
			listeNumCages.forEach(no -> System.out.print(no + "; "));
			noCageTemp = sc.nextInt();
		} while (!listeNumCages.contains(noCageTemp));

		final int noCage = noCageTemp;
		Cage cage = listeCagesFonction
				.stream()
				.reduce(null, (cageCorr, cageCourante) -> cageCourante.getNoCage() == noCage ? cageCourante : cageCorr);

		Set<String> maladies = new HashSet<>();
		String maladie = "";
		sc.nextLine();
		
		do {
			System.out.print("Saisir une maladie : (saisir 0 pour terminer)  : ");
			maladie = sc.nextLine();
			if (!maladie.equals("0")) {
				maladies.add(maladie);
			}

		} while (!maladie.equals("0"));

		Animal animal = new Animal();
		animal.setAnNais(anNaiss);
		animal.setFonctionCage(fonction);
		animal.setLaCage(cage);
		animal.setMaladies(maladies);
		animal.setNomA(nom);
		animal.setPays(pays);
		animal.setSexe(sexe);
		animal.setType(type);

		AnimalDAO animalDao = new AnimalDAO(conn);
		animalDao.create(animal);

		conn.commit();
	}

	/**
	 * Ajouter une cage à la liste de cages gardés par un gardien
	 */
	private static void ajouterCageGardien() throws SQLException {
		Connection conn = TheConnection.getInstance();

		Scanner sc = new Scanner(System.in);
		System.out.print("Nom du gardien : ");

		String nomG = sc.nextLine();

		

		conn.commit();
	}

}
package fr.fms.entities;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Resto {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Bonjour, combien voulez-vous de menus ?");
		int menus = getInput(scan, "Veuillez saisir un numéro valide !");
		ArrayList<String> resumeOrder = new ArrayList<String>();
		// System.out.println(sideDishes());
		for(int i = 0; i < menus; i++) {
			resumeOrder.add(entrees());
			resumeOrder.add(plates());
			resumeOrder.add(sideDishes());
			resumeOrder.add(drinks());
			resumeOrder.add(desserts());
			
			for(int j = 0; j < resumeOrder.size(); j++) {
				if(resumeOrder.get(j) == "Aucun" || resumeOrder.get(j) == "Aucune") {
					resumeOrder.remove(j);
				}
			}
			try {
				BufferedWriter order = new BufferedWriter(new FileWriter("order.txt", true));
				order.write("-----------------------------------Résumé de la commande " + (i+1) 
														+ "-----------------------------------\n");
				for(int k = 0; k < resumeOrder.size(); k++) {
					
					order.write(resumeOrder.get(k) + "\n");
				}
				order.close();
			}catch(IOException e) {
				System.out.println("Problème d'écriture");
				e.printStackTrace();
			}
			System.out.println("Résumé de la commande N°" + (i+1));
			System.out.println(resumeOrder);
			resumeOrder.clear();
		}

	}
	
	public static int getInput(Scanner scan, String errorMessage) {
		int input = 0;
		boolean validInput = false;
		
		while(!validInput) {
			if(scan.hasNextInt()) {
				input = scan.nextInt();
				validInput = true;
			}else {
				System.out.println(errorMessage);
				scan.next();
			}
		}
		
		return input;
	}

	public static String entrees() {
		String entrees = "";
		Scanner scan = new Scanner(System.in);

		System.out.println("choix des entrées :");
		HashMap<Integer, String> listEntrance = new HashMap<Integer, String>();
		listEntrance.put(1, "Salade");
		listEntrance.put(2, "Soupe");
		listEntrance.put(3, "Quiche");
		listEntrance.put(4, "Aucune");

		for (int i : listEntrance.keySet()) {
			System.out.print("[" + i + " - " + listEntrance.get(i) + "]");
		}
		System.out.println();
		
		System.out.println("Quel entrée voulez-vous ?");
				
		boolean ok = false;
		while(!ok) {
			int entrance = getInput(scan, "Veuillez saisir un numéro valide !");
			if(listEntrance.containsKey(entrance)) {
				entrees = listEntrance.get(entrance);
				ok = true;
			}else {
				System.out.println("Veuillez entrer un numéro dans la liste des entrées");
				
			}
		}

		return entrees;

	}

	public static String plates() {
		String plate = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("choix des plats :");
		HashMap<Integer, String> listPlates = new HashMap<Integer, String>();
		listPlates.put(1, "Poulet mariné");
		listPlates.put(2, "Boeuf bourgignon");
		listPlates.put(3, "Poisson");
		listPlates.put(4, "Steack soja");
		listPlates.put(5, "Hamburger Vegan");
		listPlates.put(6, "Aucun");

		for (int i : listPlates.keySet()) {
			System.out.print("[" + i + " - " + listPlates.get(i) + "]");
		}
		System.out.println();
	
		System.out.println("Quel plat souhaitez-vous ?");
		boolean ok = false;
		while(!ok) {
			int plates = getInput(scan, "Veuillez saisir un numéro valide !");
			if(listPlates.containsKey(plates)) {
				plate = listPlates.get(plates);
				ok = true;
			}else {
				System.out.println("Veuillez entrer un numéro dans la liste des entrées");
				
			}
		}
		
		return plate;
	}

	public static String sideDishes() {
		String sideDish = "";
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, String> listSideDishes = new HashMap<Integer, String>();
		listSideDishes.put(1, "Haricots verts");
		listSideDishes.put(2, "Frites");
		listSideDishes.put(3, "Pâtes");
		listSideDishes.put(4, "Carottes");
		listSideDishes.put(5, "Aucun");

		for (int i : listSideDishes.keySet()) {
			System.out.print("[" + i + " - " + listSideDishes.get(i) + "]");
		}
		System.out.println();

		System.out.println("Quel accompagnement voulez-vous ?");		
		boolean ok = false;
		while(!ok) {
			int sideDishes = getInput(scan, "Veuillez saisir un numéro valide !");
			if(listSideDishes.containsKey(sideDishes)) {
				sideDish = listSideDishes.get(sideDishes);
				ok = true;
			}else {
				System.out.println("Veuillez entrer un numéro dans la liste des entrées");
				
			}
		}

		return sideDish;
	}

	public static String drinks() {
		String drink = "";
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, String> listDrinks = new HashMap<Integer, String>();
		listDrinks.put(1, "Coca cola");
		listDrinks.put(2, "Orangina");
		listDrinks.put(3, "Eau gazeuse");
		listDrinks.put(4, "Eau plate");
		listDrinks.put(5, "Thé à la menthe");
		listDrinks.put(6, "Aucune");

		for (int i : listDrinks.keySet()) {
			System.out.print("[" + i + " - " + listDrinks.get(i) + "]");
		}
		System.out.println();
			
		System.out.println("Quel boisson désirez-vous ?");
		boolean ok = false;
		while(!ok) {
			int drinks = getInput(scan, "Veuillez saisir un numéro valide !");
			if(listDrinks.containsKey(drinks)) {
				drink = listDrinks.get(drinks);
				ok = true;
			}else {
				System.out.println("Veuillez entrer un numéro dans la liste des entrées");
				
			}
		}

		return drink;
	}

	public static String desserts() {
		String dessert = "";
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, String> listDesserts = new HashMap<Integer, String>();
		listDesserts.put(1, "Moelleux au chocolat");
		listDesserts.put(2, "Tarte au citron");
		listDesserts.put(3, "Flan");
		listDesserts.put(4, "Muffin myrtille");
		listDesserts.put(5, "Aucun");

		for (int i : listDesserts.keySet()) {
			System.out.print("[" + i + " - " + listDesserts.get(i) + "]");
		}
		System.out.println();
		
		
			
		System.out.println("Quel dessert avez-vous envie ?");
		boolean ok = false;
		while(!ok) {
			int desserts = getInput(scan, "Veuillez saisir un numéro valide !");
			if(listDesserts.containsKey(desserts)) {
				dessert = listDesserts.get(desserts);
				ok = true;
			}else {
				System.out.println("Veuillez entrer un numéro dans la liste des entrées");
				
			}
		}

		return dessert;
	}

}

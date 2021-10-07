package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.GuitarDao;
import entity.Guitar;


public class Menu {

	private GuitarDao guitarDao = new GuitarDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Guitars", 
			"Create Guitar", 
			"Update Guitar",
			"Delete Guitar",
			"Exit");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayGuitars();
				} else if (selection.equals("2")) {
					createGuitar();
				} else if (selection.equals("3")) {
					updateGuitar();
				} else if (selection.equals("4")) {
					deleteGuitar();
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
			System.out.println("Press enter to continue.....");
			scanner.nextLine();
		} while (!selection.equals("5"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-----------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));	
		}	
	}
	
	private void displayGuitars() throws SQLException {
		List<Guitar> guitars = guitarDao.getGuitars();
		for (Guitar guitar : guitars) {
			System.out.println("Guitar ID: " + guitar.getId() + ", Guitar Make: " + guitar.getMake() + ", Guitar Model: " + guitar.getModel());
		}
	}
	
	private void createGuitar() throws SQLException {
		System.out.print("Enter new Guitar make:");
		String guitarMake = scanner.nextLine();
		System.out.print("Enter new Guitar model:");
		String guitarModel = scanner.nextLine();
		guitarDao.createNewGuitar(guitarMake, guitarModel);
	}
	
	private void updateGuitar() throws SQLException {
		System.out.print("Enter Guitar id:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new Guitar make:");
		String make = scanner.nextLine();
		System.out.print("Enter new Guitar model:");
		String model = scanner.nextLine();
		guitarDao.updateGuitar(id, make, model);
	}
	
	private void deleteGuitar() throws SQLException {
		System.out.print("Enter Guitar id:");
		int id = Integer.parseInt(scanner.nextLine());
		guitarDao.deleteGuitarById(id);
	}
}

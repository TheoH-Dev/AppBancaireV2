package application;

import java.io.Serializable;
import java.util.Scanner;

import bank.CdaBank;
import util.Util;

public class Application implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8271931228350969L;

	public static void demarrerApp() {
		boolean quitter;
		Util.readSave();
		Scanner in = new Scanner(System.in);
		do {
			quitter = Menu.mainMenuChoice(in);
		} while (!quitter);
		Util.save(CdaBank.getListAgences());
		in.close();
	}
}

package view;

import controller.OrdenaController;

public class Principal {

	public static void main(String[] args) {
		OrdenaController oc = new OrdenaController();
		
		oc.carregaHash();
		
		oc.ordenaHash();

	}

}

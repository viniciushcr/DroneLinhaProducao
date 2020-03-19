package model;

import java.util.ArrayList;

public class MontadoraDrone implements Runnable{
	
	private ArrayList<DroneCompleto> estoqueDrone;
	
	private ArrayList<ParteDrone> estoqueHelices;
	private ArrayList<ParteDrone> estoqueBaterias;
	private ArrayList<ParteDrone> estoquePlacasControladoras;
	private ArrayList<ParteDrone> estoqueMotores;
	private ArrayList<ParteDrone> estoqueFrames;
	
	public MontadoraDrone(ArrayList<ParteDrone> estoqueHelices, ArrayList<ParteDrone> estoqueBaterias,
			ArrayList<ParteDrone> estoquePlacasControladoras, ArrayList<ParteDrone> estoqueMotores,
			ArrayList<ParteDrone> estoqueFrames) {
	
		this.estoqueDrone = new ArrayList<DroneCompleto>();
		
		this.estoqueHelices = estoqueHelices;
		this.estoqueBaterias = estoqueBaterias;
		this.estoquePlacasControladoras = estoquePlacasControladoras;
		this.estoqueMotores = estoqueMotores;
		this.estoqueFrames = estoqueFrames;
		new Thread(this).start();
	}
	
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					wait(); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				estoqueHelices.remove(0);
				estoqueHelices.remove(0);
				estoqueHelices.remove(0);
				estoqueHelices.remove(0);
				
				estoqueBaterias.remove(0);
				estoqueBaterias.remove(0);
				
				estoqueFrames.remove(0);
				
				estoqueMotores.remove(0);
				estoqueMotores.remove(0);
				estoqueMotores.remove(0);
				estoqueMotores.remove(0);
				
				estoquePlacasControladoras.remove(0);
				
				estoqueDrone.add(new DroneCompleto());
				System.out.println("********** Consumiu -> (Mais 1 Drone feito) **********");
			}
		}
	}
}

package model;

import java.util.ArrayList;

public class FabricaDrone extends Thread{
	
	private ArrayList<ParteDrone> estoqueHelices;
	private ArrayList<ParteDrone> estoqueBaterias;
	private ArrayList<ParteDrone> estoquePlacasControladoras;
	private ArrayList<ParteDrone> estoqueMotores;
	private ArrayList<ParteDrone> estoqueFrames;
	
	private LinhaProducao linhaProducaoHelice;
	private LinhaProducao linhaProducaoBateria;
	private LinhaProducao linhaProducaoPlacaControladora;
	private LinhaProducao linhaProducaoMotor;
	private LinhaProducao linhaProducaoFrame;
	
	ArrayList<LinhaProducao> arrayLinhaProducao;
	
	private MontadoraDrone montadoraDrone;
	
	public FabricaDrone() {
		this.estoqueHelices = new ArrayList<ParteDrone>();
		this.estoqueBaterias = new ArrayList<ParteDrone>();
		this.estoquePlacasControladoras = new ArrayList<ParteDrone>();
		this.estoqueMotores = new ArrayList<ParteDrone>();
		this.estoqueFrames = new ArrayList<ParteDrone>();
		
		this.linhaProducaoHelice = new LinhaProducao("Helice", 80, this.estoqueHelices,2000);
		this.linhaProducaoBateria = new LinhaProducao("Bateria", 20, this.estoqueBaterias,3000);
		this.linhaProducaoPlacaControladora = new LinhaProducao("PlacaControladora", 8, this.estoquePlacasControladoras,7000);
		this.linhaProducaoMotor = new LinhaProducao("Motor", 16, this.estoqueMotores,3000);
		this.linhaProducaoFrame = new LinhaProducao("Frame", 10, this.estoqueFrames,9000);
		
		arrayLinhaProducao = new ArrayList<LinhaProducao>(); 
		arrayLinhaProducao.add(linhaProducaoHelice);
		arrayLinhaProducao.add(linhaProducaoBateria);
		arrayLinhaProducao.add(linhaProducaoPlacaControladora);
		arrayLinhaProducao.add(linhaProducaoMotor);
		arrayLinhaProducao.add(linhaProducaoFrame);
		
		this.montadoraDrone = new MontadoraDrone(estoqueHelices, estoqueBaterias, estoquePlacasControladoras, estoqueMotores, estoqueFrames);
	}
	
	public void run() {

		while (true) {
			
			for(LinhaProducao linhaProducao : arrayLinhaProducao ) {
				if (linhaProducao.getEstoqueParteDrone().size() == 0) {
					synchronized (linhaProducao) {
						System.out.println("************************* Incializa Produção *************************");
						linhaProducao.notify();
					}
				}
			}
			
			

			if (estoqueHelices.size()>=4 && estoqueBaterias.size()>=2 && estoquePlacasControladoras.size()>=1 && estoqueMotores.size()>=4 && estoqueFrames.size()>=1) {
				synchronized (montadoraDrone) {
					System.out.println("************************* Incializa Consumo *************************");
					montadoraDrone.notify();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		FabricaDrone dji = new FabricaDrone();
		dji.start();
	}

}

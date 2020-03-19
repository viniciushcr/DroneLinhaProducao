package model;

import java.util.ArrayList;

import view.LinhaProducaoWindow;

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

				while(estoqueHelices.size()>=4 && estoqueBaterias.size()>=2 && estoquePlacasControladoras.size()>=1 && estoqueMotores.size()>=4 && estoqueFrames.size()>=1) {
				
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

					LinhaProducaoWindow.getLinhaProducaoWindow().getTextHelice().setText(""+estoqueHelices.size());
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextBateria().setText(""+estoqueBaterias.size());
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextFrame().setText(""+estoqueFrames.size());
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextMotor().setText(""+estoqueMotores.size());
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextPlacaControladora().setText(""+estoquePlacasControladoras.size());

					estoqueDrone.add(new DroneCompleto());
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextDroneMontado().setText(""+estoqueDrone.size());

					System.out.println("********** Consumiu -> (Mais 1 Drone feito) **********");
				}
			}
		}
	}
}

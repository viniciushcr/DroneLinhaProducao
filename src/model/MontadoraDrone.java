package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

import view.LinhaProducaoWindow;

public class MontadoraDrone implements Runnable{
	
	private ArrayList<DroneCompleto> estoqueDrone;
	
	private ArrayList<ParteDrone> estoqueHelices;
	private ArrayList<ParteDrone> estoqueBaterias;
	private ArrayList<ParteDrone> estoquePlacasControladoras;
	private ArrayList<ParteDrone> estoqueMotores;
	private ArrayList<ParteDrone> estoqueFrames;
	
	private long inicio;
	private long fim;
	private double quantidadeDronesHora;
	
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
		// Começa a medir o tempo de produção de 1 drone
		inicio = System.currentTimeMillis();
		while (true) {
			synchronized (this) {

				while(estoqueHelices.size()>=4 && estoqueBaterias.size()>=2 && 
						estoquePlacasControladoras.size()>=1 && estoqueMotores.size()>=4 
						&& estoqueFrames.size()>=1) {
				
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
					//Finaliza a medição de tempo de produção de 1 drone
					fim  = System.currentTimeMillis();
					if((fim - inicio)/1000 > 0) {
						this.quantidadeDronesHora = (3600/((fim - inicio)/1000));
					}
					
					//conversão de casas decimais
					DecimalFormat df = new DecimalFormat("0");
					String valorDroneHorasConvertido = df.format(quantidadeDronesHora);
					System.out.println("8888888888888888--->>> "+valorDroneHorasConvertido+"<<<---888888888888888");
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextDronesHora().setText(valorDroneHorasConvertido);
					
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextDroneMontado().setText(""+estoqueDrone.size());
					System.out.println("********** Consumiu -> (Mais 1 Drone feito) **********");
					
					if (estoqueDrone.size()>=8) {
						synchronized (Embalador.getEmbalador(estoqueDrone)) {
							System.out.println("********** Mandanto 8 Drones para Embalar  **********");
							Embalador.getEmbalador(estoqueDrone).notify();
						}
					}
					inicio = System.currentTimeMillis();
				}
			}
		}
	}
}

package model;

import java.util.ArrayList;

import view.LinhaProducaoWindow;

public class Embalador extends Thread {

	private static Embalador embalador;
	private ArrayList<DroneCompleto> estoqueDrone;
	private ArrayList<Caixa> estoqueCaixa;

	private Embalador(ArrayList<DroneCompleto> estoqueDrone) {
		this.estoqueCaixa = new ArrayList<Caixa>();
		this.estoqueDrone = estoqueDrone;
		this.start();
	}
	
	public void run() {
		while(true) {
			synchronized (this) {
				
				
				if(estoqueDrone.size()>=8) {
					
					for(int i=0 ; i<8;i++) {
						this.estoqueDrone.remove(0);
					}
					estoqueCaixa.add(new Caixa());
					
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextDroneMontado().setText(""+estoqueDrone.size());
					for(int x = 700;x<800 ; x++) {
						LinhaProducaoWindow.getLinhaProducaoWindow().getLblCaixaIcon().setBounds(x, 578, 40, 40);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					LinhaProducaoWindow.getLinhaProducaoWindow().getLblCaixaIcon().setEnabled(false);
					LinhaProducaoWindow.getLinhaProducaoWindow().getLblCaixaIcon().setBounds(700, 578, 40, 40);
					LinhaProducaoWindow.getLinhaProducaoWindow().getLblCaixaIcon().setEnabled(true);
					
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextCaixa().setText("" + estoqueCaixa.size());
					System.out.println("********** Mais 1 caixa c/8 Embaladada **********");
				}
			}
		}
	}
	
	public static Embalador getEmbalador(ArrayList<DroneCompleto> estoqueDrone) { 
		if(embalador==null) embalador = new Embalador(estoqueDrone);
		
		return embalador;
	}
	
}

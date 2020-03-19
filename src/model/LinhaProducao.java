package model;

import java.awt.Color;
import java.util.ArrayList;

import view.LinhaProducaoWindow;

public class LinhaProducao implements Runnable{
	
	private String nomeParte;
	private ArrayList<ParteDrone> estoqueParteDrone;
	private int tamanhoEstoque;
	private long tempoPruducao;

	LinhaProducao(String nomeParte, int tamanhoEstoque, ArrayList<ParteDrone> estoqueParteDrone,long tempoProducao) {
		this.nomeParte = nomeParte;
		this.tamanhoEstoque = tamanhoEstoque;
		this.estoqueParteDrone = estoqueParteDrone;
		this.tempoPruducao = tempoProducao;
		new Thread(this).start();
	}

	public void run() {
		while (true) {
			synchronized (this) {
				
				LinhaProducaoWindow.getLinhaProducaoWindow().getTextPorNome(nomeParte).setBackground(Color.GREEN);
				while (estoqueParteDrone.size() <= (tamanhoEstoque-1)) {
					try {
						Thread.sleep(tempoPruducao);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					estoqueParteDrone.add(new ParteDrone(nomeParte));
					LinhaProducaoWindow.getLinhaProducaoWindow().getTextPorNome(nomeParte).setText(""+estoqueParteDrone.size());
					System.out.println("Produziu -> "+estoqueParteDrone.size()+" " + nomeParte);
				}
			}
		}
	}

	public ArrayList<ParteDrone> getEstoqueParteDrone() {
		return estoqueParteDrone;
	}
	
	public String getNome() {
		return nomeParte;
	}
		

}

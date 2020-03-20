package model;

import java.util.ArrayList;

public class LPFrames extends LinhaProducao{

	LPFrames(String nomeParte, int tamanhoEstoque, ArrayList<ParteDrone> estoqueParteDrone, long tempoProducao) {
		super(nomeParte, tamanhoEstoque, estoqueParteDrone, tempoProducao);
	}

}

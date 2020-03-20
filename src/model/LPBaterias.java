package model;

import java.util.ArrayList;

public class LPBaterias extends LinhaProducao{

	LPBaterias(String nomeParte, int tamanhoEstoque, ArrayList<ParteDrone> estoqueParteDrone, long tempoProducao) {
		super(nomeParte, tamanhoEstoque, estoqueParteDrone, tempoProducao);
		
	}

}

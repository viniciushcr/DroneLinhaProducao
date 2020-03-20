package model;

import java.util.ArrayList;

public class LPMotores extends LinhaProducao{

	LPMotores(String nomeParte, int tamanhoEstoque, ArrayList<ParteDrone> estoqueParteDrone, long tempoProducao) {
		super(nomeParte, tamanhoEstoque, estoqueParteDrone, tempoProducao);
	}

}

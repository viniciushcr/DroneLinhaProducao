package model;

import java.util.ArrayList;

public class LPPlacasControladoras extends LinhaProducao{

	LPPlacasControladoras(String nomeParte, int tamanhoEstoque, ArrayList<ParteDrone> estoqueParteDrone,
			long tempoProducao) {
		super(nomeParte, tamanhoEstoque, estoqueParteDrone, tempoProducao);

	}

}

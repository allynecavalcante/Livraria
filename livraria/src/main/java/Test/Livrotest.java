package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.Livraria.livraria.model.Livro;



public class Livrotest {

	  private Double maiorPreco = Double.NEGATIVE_INFINITY;
	  private Double menorPreco = Double.POSITIVE_INFINITY;
	  
	  private List<Livro> LivrosMaisCaros;
	  
	  public void getRelatorioPrecos (List<Livro> livros) {
		  for (Livro livro : livros) {
			  if (livro.getValor() > maiorPreco) {
				  maiorPreco = livro.getValor();
			  }
			  if(livro.getValor()< menorPreco) {
				  menorPreco = livro.getValor();
			  }
		  }
		  calcularProdutosMaisCaros(livros);
		  
	  }

	  public void calcularProdutosMaisCaros(List<Livro> livros) {
		  LivrosMaisCaros =new ArrayList<>(livros);
		  Collections.sort (LivrosMaisCaros, new Comparator<Livro>() {
				  public int compare (Livro p1, Livro p2) {
			  if (p1.getValor() < p2.getValor()) return 1;
			  if (p1.getValor() > p2.getValor()) return -1;
			  return 0;
		  }
			  
		  } );
		  LivrosMaisCaros = LivrosMaisCaros.subList(0,
				  LivrosMaisCaros.size() > 3 ? 3 : LivrosMaisCaros.size());
	  }
	   public List<Livro> getLivrosMaisCaros() {
		return LivrosMaisCaros;
	}

	public Double getMaiorPreco() {
		   return maiorPreco;
	   }

	public Double getMenorPreco() {
		return menorPreco;
	}

}

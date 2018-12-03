import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.Livraria.livraria.model.Livro;

public class Testes {

	Livro livro;
	List<Livro> livros;

	@Before
	public void EntidadesParaTestes() {
		livro = new Livro();
		Livro Romance = new Livro ("Box 50 tons de cinza" , 100.0);
		Livro Crônicas = new Livro("Box A seleção" , 120.0);
		Livro História= new Livro ("Código da Vinci" , 200.0);
		Livro Litérario= new Livro ("Mémorias Prostúmas de Brás Cuba" , 30.0);
		Livro Espírita= new Livro ("Corações em Fase Terminais" , 20.0);
	  
		livros= new ArrayList<>();
		livros.add(Romance);
		livros.add(Crônicas);
		livros.add(História);
		livros.add(Litérario);
		livros.add(Espírita);
		
	}

	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosEmOrdemCrescente() {

		Livro relatorio = new Livro();
		relatorio.getLivroPrecos(livro);

		Double maiorPrecoEsperado = 200.0;
		Double menorPrecoEsperado = 20.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());

	}

	@Test
	public void deveEncontrarOsTresProdutosMaisCaros() {

		Livro romance = new Livro("Como eu era antes de você", 29.99);
		Livro.add(romance);

		Livro relatorio = new Livro(null, 0);
		relatorio.getLivroPrecos(livro);

		List<Livro> top3LivrosMaisCaros = relatorio.getLivrosMaisCaros();

		assertEquals(3, top3LivrosMaisCaros.size());
		assertEquals(200.0, top3LivrosMaisCaros.get(0).getValor(), 000.1);
		assertEquals(120.0, top3LivrosMaisCaros.get(1).getValor(), 000.1);
		assertEquals(100.0, top3LivrosMaisCaros.get(2).getValor(), 000.1);
	}

}

package br.com.livraria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.livraria.model.Livro;
import br.com.livraria.model.Venda;
import br.com.livraria.service.ServiceConsultaLivro;

@Named
@ViewScoped
public class ControllerVenda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Venda> vendas;
	private List<Livro> livros;
	
	@Inject
	private ServiceConsultaLivro serviceConsultaLivro;
	
	public ControllerVenda() {
		this.vendas = new ArrayList<>();
		this.livros = new ArrayList<>();
	}
	
	public List<Venda> getVendas() {
		this.livros = serviceConsultaLivro.buscaPorTodosOsLivros();
		Random random = new Random(1234);

		for(Livro livro : this.livros) {
			Integer quantidade = random.nextInt(500);
			
			this.vendas.add(new Venda(quantidade, livro));
		}
		
		return vendas;
	}
	
	public BarChartModel getVendasModel() {
		BarChartModel model = new BarChartModel();
		model.setAnimate(true);
		
		ChartSeries vendaSeries = new ChartSeries();
		vendaSeries.setLabel("Vendas 2018");
		
		List<Venda> vendas = getVendas();
		for(Venda venda : vendas) {
			vendaSeries.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}
		model.addSeries(vendaSeries);
		
		return model;
	}
	
	
	public List<Livro> getLivros() {
		return livros;
	}
}

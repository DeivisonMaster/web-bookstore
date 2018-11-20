package br.com.livraria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.livraria.model.Livro;
import br.com.livraria.model.Venda;
import br.com.livraria.service.ServiceConsultaLivro;
import br.com.livraria.util.JPAUtil;

@Named
@ViewScoped
public class ControllerVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Venda> vendas;
	private List<Livro> livros;

	
	// refatorar
	private EntityManager entityManager;

	public ControllerVenda() {
		this.vendas = new ArrayList<>();
		this.livros = new ArrayList<>();
		this.entityManager = JPAUtil.getEntityManager();
	}

	public List<Venda> getVendas() {
		this.vendas = this.entityManager.createQuery("SELECT v FROM Venda v", Venda.class).getResultList();

		return vendas;
	}

	public BarChartModel getVendasModel() {
		BarChartModel model = new BarChartModel();
		model.setAnimate(true);

		ChartSeries vendaSeries2018 = new ChartSeries();
		vendaSeries2018.setLabel("Vendas 2018");

		List<Venda> vendas = getVendas();
		for (Venda venda : vendas) {
			vendaSeries2018.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}

		model.addSeries(vendaSeries2018);
		return model;
	}

	public List<Livro> getLivros() {
		return livros;
	}
}

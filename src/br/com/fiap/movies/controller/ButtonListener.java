package br.com.fiap.movies.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import br.com.fiap.movies.dao.FilmeDao;
import br.com.fiap.movies.model.Filme;
import br.com.fiap.movies.view.Frame;

public class ButtonListener implements ActionListener {
	
	private Frame view;
	private FilmeDao dao = new FilmeDao();
	
	private Long id;
	private String titulo;
	private String sinopse;
	private String genero;
	private String plataforma = "<vazio>";
	private boolean assistido = false;
	private int stars = 0;
	
	public ButtonListener(Frame view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Tratamento dos dados inseridos pelo usuário
//		
		titulo = view.getTxtTitulo().getText();
		sinopse = view.getTxtSinopse().getText();
		genero = (String) view.getGeneroEscolhido().getSelectedItem();

		if (view.getNetflix().isSelected()) {
			plataforma = "NETFLIX";
		} else if (view.getPrimeVideo().isSelected()) {
			plataforma = "PRIME VIDEO";
		} else if (view.getPirateBay().isSelected()) {
			plataforma = "PIRATE BAY";
		} 
		
		if (view.getAssistido().getSelectedObjects() != null) 
			assistido = !assistido;	
		
		stars = view.getStar().getSelection();

		Filme filme = new Filme();
		filme.setTitulo(titulo);
		filme.setSinopse(sinopse);
		filme.setGenero(genero);
		filme.setPlataforma(plataforma);
		filme.setAssistido(assistido);
		filme.setAvaliacao(stars);
		
		dao.inserir(filme);
		
		view.carregarLista();
		List<Filme> lista =  dao.listarTodos();
		lista.forEach(System.out::println);
	}

}

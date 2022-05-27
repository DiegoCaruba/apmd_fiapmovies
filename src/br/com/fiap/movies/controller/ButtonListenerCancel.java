package br.com.fiap.movies.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.fiap.movies.view.Frame;

public class ButtonListenerCancel implements ActionListener {
	
	private Frame view;
	
	public ButtonListenerCancel(Frame view) {
		super();
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Botao CANCELAR clicado");
		
	}

}

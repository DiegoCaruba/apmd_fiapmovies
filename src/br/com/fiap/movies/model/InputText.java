package br.com.fiap.movies.model;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

public class InputText extends JTextField {

	private static final long serialVersionUID = 1L;
	
	public InputText() {
		super(20);
		init();
	}
	
	public InputText(String innerText) {
		super(innerText, 20);
		init();
	}
	
	private void init() {
		this.setPreferredSize(new Dimension(150, 40));
		this.setBackground(Color.WHITE);
		this.setForeground(new Color(50, 50, 50));
	}

}

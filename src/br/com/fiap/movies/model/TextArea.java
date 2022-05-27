package br.com.fiap.movies.model;

import javax.swing.JTextArea;

public class TextArea extends JTextArea {

	private static final long serialVersionUID = 1L;
	private int columns;
	private int rows;
	
	JTextArea t = new JTextArea();
	
	public TextArea() {
		super(2, 20);
		init();
	}
	
	public TextArea(String innerText) {
		super(innerText, 2, 20);
		init();
	}
	
	private void init() {
		this.setColumns(30);
		this.setRows(20);
		this.setSize(150, 40);
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
}

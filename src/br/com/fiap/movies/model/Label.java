package br.com.fiap.movies.model;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel {

	private static final long serialVersionUID = 1L;
	private String text;
	private int fontSize = 14;
	
	public Label(String text) {
		super(text);
		this.setForeground(new Color(54, 54, 54));
		this.setFont(new Font(null, Font.BOLD, this.getFontSize()));
		this.setAlignmentX(LEFT_ALIGNMENT);
	}
	
	public Label(ImageIcon image) {
		super(image);
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
}

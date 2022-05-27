package br.com.fiap.movies.model;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String sinopse;
	private String genero;
	private String plataforma;
	private boolean assistido;
	private int avaliacao;
	
	
//	public Filme(String titulo, String sinopse, String genero, String plataforma, boolean assistido, int avaliacao) {
//		super();
//		this.titulo = titulo;
//		this.sinopse = sinopse;
//		this.genero = genero;
//		this.plataforma = plataforma;
//		this.assistido = assistido;
//		this.avaliacao = avaliacao;
//	}
	
	public Vector<String> getData() {
	
		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(titulo);
		data.add(sinopse);
		data.add(genero);
		data.add(plataforma);
		data.add(Boolean.toString(assistido));
		data.add(Integer.toString(avaliacao));
		
		return data;
	}

	
	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", sinopse=" + sinopse + ", genero=" + genero
				+ ", plataforma=" + plataforma + ", assistido=" + assistido + ", avaliacao=" + avaliacao + "]";
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public boolean isAssistido() {
		return assistido;
	}

	public void setAssistido(boolean assistido) {
		this.assistido = assistido;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}	

}

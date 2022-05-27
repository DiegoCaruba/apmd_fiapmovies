package br.com.fiap.movies.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.movies.controller.ButtonListener;
import br.com.fiap.movies.controller.ButtonListenerCancel;
import br.com.fiap.movies.controller.TableListener;
import br.com.fiap.movies.dao.FilmeDao;
import br.com.fiap.movies.model.CheckBox;
import br.com.fiap.movies.model.Filme;
import br.com.fiap.movies.model.InputText;
import br.com.fiap.movies.model.Label;
import br.com.fiap.movies.model.RadioButton;
import br.com.fiap.movies.model.StarRater;
import br.com.fiap.movies.model.TextArea;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JFrame frame = new JFrame("Fiap Movies");
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	
	String[] colunas = {"id", "titulo", "sinopse", "genero", "plataforma", "assistido", "avaliacao"};
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable tabela = new JTable(tableModel);
	DefaultTableModel tableModelOrdenacao = new DefaultTableModel(colunas, 0);
	JTable tabelaOrdenacao = new JTable(tableModelOrdenacao);

	private JPanel top = new JPanel();
	private JPanel left = new JPanel();	
	private JPanel center = new JPanel();
	private JPanel right = new JPanel();
	private JPanel bottom = new JPanel();
	
	private InputText txtTitulo = new InputText();
	TextArea txtSinopse = new TextArea();
	String[] genders = {"Masculino", "Feminino"};
	JComboBox<String> generoEscolhido = new JComboBox<String>(genders);

	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnCancelar = new JButton("Cancelar");

	private ButtonGroup plataforma = new ButtonGroup();
	private RadioButton netflix = new RadioButton("Netflix");
	private RadioButton primeVideo = new RadioButton("Prime Video");
	private RadioButton pirateBay = new RadioButton("Pirate Bay");	
	
	private CheckBox assistido = new CheckBox("Assistido");
	private StarRater star = new StarRater();
	
	public void init() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		top.setBorder(new EmptyBorder(0, 0, 0, 0));
		left.setBorder(new EmptyBorder(10, 10, 10, 10));
		center.setBorder(new EmptyBorder(10, 10, 10, 10));
		right.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		frame.add(tabbedPane, BorderLayout.PAGE_START);
		tabbedPane.add(top, "Cadastro");
		tabbedPane.add(new JScrollPane(tabela), "Lista");
		tabbedPane.add(new JScrollPane(tabelaOrdenacao), "Ordenação");
				
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		left.add(new Label(new ImageIcon("src/cartaz.png")));
		frame.add(left);
		
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(new Label("Titulo"));
		center.add(txtTitulo);		
		center.add(new Label("Sinopse"));
		center.add(txtSinopse);
		center.add(new Label("Genero"));
		center.add(generoEscolhido);
		
		bottom.setLayout(new FlowLayout());
		bottom.add(btnSalvar);
		bottom.add(btnCancelar);
		
		center.add(bottom);
		
		frame.add(center);
		
		plataforma.add(netflix);
		plataforma.add(primeVideo);
		plataforma.add(pirateBay);
		
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		right.add(new Label("Onde assistir"));		
		right.add(netflix);
		right.add(primeVideo);
		right.add(pirateBay);		
		right.add(assistido);		
		right.add(new Label("Avaliacao"));
		right.add(star);
		
		frame.add(right);
		
		top.setLayout(new FlowLayout());
		top.add(left, BorderLayout.LINE_START);
		top.add(center, BorderLayout.CENTER);
		top.add(right, BorderLayout.LINE_END);
		
		// CONFIGURAÃ‡Ã€O DA JANELA
		frame.setSize(800, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		// TRATAMENTO DE EVENTOS
		carregarLista();
		tabelaClicada();
		//listaOrdenada();
		botaoSalvarClicado();
		botaoCancelarClicado();
	}
	
	public void listaOrdenada() {
		//tableModelOrdenacao.setRowCount(0);
		//List<Filme> lista = new FilmeDao().listarTodos();
		//lista.forEach(filme -> tableModelOrdenacao.addRow(filme.getData()));
	}
	
	public void tabelaClicada() {
		TableListener tableListener = new TableListener();
		tabela.addMouseListener(tableListener);
		tabela.setDefaultEditor(Object.class, null);
	}
	
	public void carregarLista() {
		tableModel.setRowCount(0);
		tableModelOrdenacao.setRowCount(0);
		List<Filme> lista = new FilmeDao().listarTodos();
		List<Filme> listaOrdenada = new FilmeDao().listarOrdenacao();
		lista.forEach(filme -> tableModel.addRow(filme.getData()));
		listaOrdenada.forEach(filme -> tableModelOrdenacao.addRow(filme.getData()));
		System.out.println("\nCARREGAR LISTA");
	}

	private void botaoSalvarClicado() {
		ButtonListener listener = new ButtonListener(this);
		btnSalvar.addActionListener(listener);
	}
	
	
	private void botaoCancelarClicado() {
		ButtonListenerCancel listener = new ButtonListenerCancel(this);
		btnCancelar.addActionListener(listener);
	}
	

	public InputText getTxtTitulo() {
		return txtTitulo;
	}

	public TextArea getTxtSinopse() {
		return txtSinopse;
	}

	public JComboBox<String> getGeneroEscolhido() {
		return generoEscolhido;
	}

	public ButtonGroup getPlataforma() {
		return plataforma;
	}

	public RadioButton getNetflix() {
		return netflix;
	}

	public RadioButton getPrimeVideo() {
		return primeVideo;
	}

	public RadioButton getPirateBay() {
		return pirateBay;
	}

	public CheckBox getAssistido() {
		return assistido;
	}

	public StarRater getStar() {
		return star;
	}	
}

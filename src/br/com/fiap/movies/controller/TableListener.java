package br.com.fiap.movies.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.movies.dao.FilmeDao;
import br.com.fiap.movies.model.Filme;
import br.com.fiap.movies.view.Frame;

public class TableListener implements MouseListener {

	private Frame view;
	private FilmeDao dao = new FilmeDao();
	
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2) {
		
			int resp = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar?");
			if (resp == JOptionPane.YES_OPTION) {
				JTable table = (JTable) e.getSource();
				String id = (String) table.getValueAt(table.getSelectedRow(), 0);
				System.out.println("APAGAR id = " + id);
				Filme apagar = dao.selecionar(id);
				dao.apagar(apagar);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

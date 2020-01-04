package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.InfoModel.Disk;

public class OpenExplorerController implements MouseListener {

	private JLabel view;
	private Disk model;

	public OpenExplorerController(JLabel view, Disk model) {
		this.model = model;
		this.view = view;
		view.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("explorer " + model.getPath());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

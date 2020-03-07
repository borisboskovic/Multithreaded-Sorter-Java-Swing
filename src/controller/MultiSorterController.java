package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.MultiSorterModel;
import view.MultiSorterView;

public class MultiSorterController {

	private MultiSorterModel model;
	private MultiSorterView view;

	public MultiSorterController(MultiSorterModel model, MultiSorterView view) {
		this.model = model;
		this.view = view;
		view.getAddButton().addActionListener(addBtnListener);
	}

	private ActionListener addBtnListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setPreferredSize(new Dimension(800, 600));
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("TXT files", "txt");
			fileChooser.addChoosableFileFilter(fileFilter);
			fileChooser.setMultiSelectionEnabled(true);
			int returnValue = fileChooser.showOpenDialog(view);
			
			if(returnValue==JFileChooser.APPROVE_OPTION) {
				File[] selectedFiles = fileChooser.getSelectedFiles();
				for(File file : selectedFiles)
					System.out.println(file);
			}
		}
	};

}

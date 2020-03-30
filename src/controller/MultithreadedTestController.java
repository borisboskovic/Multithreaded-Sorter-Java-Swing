package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.MultithreadedTestModel;
import view.MultithreadedTestView;

public class MultithreadedTestController {
	private MultithreadedTestModel model;
	private MultithreadedTestView view;

	public MultithreadedTestController(MultithreadedTestModel model, MultithreadedTestView view) {
		this.model = model;
		this.view = view;
		this.view.getSortBtn().addActionListener(sortBtnListener);
		this.view.getBrowseBtn().addActionListener(browseBtnListener);
	}

	private Boolean validateNumOfFiles() {
		try {
			int num = Integer.parseInt(view.getMinFilesPerThread().getText());
			return (num >= 1 && num <= MultithreadedTestModel.FILES_LIMIT);
		} catch (Exception e) {
			return false;
		}
	}

	private ActionListener sortBtnListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String path = view.getPath().getText();

			String message1 = "Plesae enter file path.";
			String message2 = "Can't open file.";
			if (path.length() == 0)
				JOptionPane.showMessageDialog(view, message1, "Info", JOptionPane.INFORMATION_MESSAGE);
			else if (!Files.isRegularFile(Paths.get(path)))
				JOptionPane.showMessageDialog(view, message2, "Error", JOptionPane.ERROR_MESSAGE);
			else {
				if (!validateNumOfFiles()) {
					String message = "For minimum files per thread please choose a value between 1 and "
							+ model.FILES_LIMIT;
					JOptionPane.showMessageDialog(view, message, "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					view.setEnabled(false);
					model.sort(path);
					view.setEnabled(true);
				}
			}
		}
	};

	private ActionListener browseBtnListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("TXT files", "txt");
			fileChooser.addChoosableFileFilter(fileFilter);
			fileChooser.setPreferredSize(new Dimension(800, 600));

			int returnValue = fileChooser.showSaveDialog(view);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				String selectedFile = fileChooser.getSelectedFile().getPath().toString();
				view.getPath().setText(selectedFile);
			}
		}
	};
}

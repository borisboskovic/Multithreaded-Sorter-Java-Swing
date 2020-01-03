package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.GeneratorModel;
import model.GeneratorSectionModel;
import view.GeneratorView;

public class GeneratorController {

	private GeneratorModel model;
	private GeneratorView view;

	public GeneratorController(GeneratorModel model, GeneratorView view) {
		this.model = model;
		this.view = view;
		view.getPlus().addActionListener(addButtonListener);
	}

	private ActionListener addButtonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.updateModels();
			GeneratorSectionModel newSection = new GeneratorSectionModel();
			if (model.getGenerators().get(model.getGenerators().size() - 1).validate()) {
				GeneratorSectionModel previousSection=model.getGenerators().get(model.getGenerators().size() - 1);
				newSection.setPath(copyPath(previousSection.getPath()));
				newSection.setAmmount(previousSection.getAmmount());
				newSection.setFrom(previousSection.getFrom());
				newSection.setTo(previousSection.getTo());
			}
			model.addGenerator(newSection);
			model.notifyObservers();
		}

		private String copyPath(String oldPath) {
			Path path = Paths.get(oldPath);
			String oldFileName = path.getFileName().toString();
			Pattern pattern = Pattern.compile("([\\w\\ ]+)([\\(\\d\\)]*)(\\.[\\w\\d]+)");
			Matcher matcher = pattern.matcher(oldFileName);
			String newFilename="";
			while (matcher.find()) {
				String fileName = matcher.group(1);
				fileName = fileName.trim();
				String number = matcher.group(2);
				String extension = matcher.group(3);
				if (number.length() > 0) {
					number = number.substring(1, number.length() - 1);
					int num = Integer.valueOf(number);
					num++;
					number = String.valueOf(num);
					newFilename = fileName + " (" + number + ")" + extension;
				} else {
					newFilename = fileName + " (1)" + extension;
				}
			}
			return path.getParent()+File.separator+newFilename;
		}
		
	};

}

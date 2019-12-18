package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.GeneratorModel;
import model.GeneratorSectionModel;

@SuppressWarnings("serial")
public class GeneratorView extends JPanel {

	private GeneratorModel model;

	public GeneratorView(GeneratorModel model) {
		this.model = model;
		
		setBackground(Color.GREEN);
		BoxLayout bLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(bLayout);

		addSections();
		
//		GeneratorSectionView section = new GeneratorSectionView(new GeneratorSectionModel(1));
//		JPanel panel = new JPanel();
//		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//		panel.setMaximumSize(new Dimension(2000, 230));
//		panel.setLayout(new GridLayout(1, 1));
//		panel.setOpaque(false);
//		panel.add(section);
//		add(panel);

		setOpaque(false);
	}
	
	private void addSections(){
		for(GeneratorSectionModel generator : model.getGenerators()) {
			GeneratorSectionView section = new GeneratorSectionView(generator);
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			panel.setMaximumSize(new Dimension(2000, 230));
			panel.setLayout(new GridLayout(1, 1));
			panel.setOpaque(false);
			panel.add(section);
			add(panel);
		}
	}

}

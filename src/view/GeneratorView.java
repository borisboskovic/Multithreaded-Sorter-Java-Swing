package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import components.CustomScrollBar;
import components.VerticallyScrollablePanel;
import model.GeneratorModel;
import model.GeneratorSectionModel;

@SuppressWarnings("serial")
public class GeneratorView extends JPanel {

	private GeneratorModel model;
	private JPanel sectionsPanel;

	public GeneratorView(GeneratorModel model) {
		this.model = model;

		BoxLayout bLayout=new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(bLayout);

		setUpSections();
		
		JScrollPane scrollPane = new JScrollPane(sectionsPanel);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
		scrollPane.getVerticalScrollBar().setUnitIncrement(32);
		add(scrollPane);

		setOpaque(false);
	}

	private void setUpSections() {
		sectionsPanel = new VerticallyScrollablePanel();
		BoxLayout sectionsLayout = new BoxLayout(sectionsPanel, BoxLayout.PAGE_AXIS);
		sectionsPanel.setLayout(sectionsLayout);
		
		for (GeneratorSectionModel generator : model.getGenerators()) {
			GeneratorSectionView section = new GeneratorSectionView(generator);
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			panel.setMaximumSize(new Dimension(2000, 230));
			panel.setLayout(new GridLayout(1, 1));
			panel.setOpaque(false);
			panel.add(section);
			sectionsPanel.add(panel);
		}
		sectionsPanel.setOpaque(false);
	}

}

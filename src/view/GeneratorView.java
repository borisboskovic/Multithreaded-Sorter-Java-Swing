package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import components.CustomScrollBar;
import components.MaterialButton;
import components.VerticallyScrollablePanel;
import global.Themes;
import model.GeneratorModel;
import model.GeneratorSectionModel;

@SuppressWarnings("serial")
public class GeneratorView extends JPanel implements ObserverInterface {

	private GeneratorModel model;
	private JPanel sectionsPanel;
	private JButton plus;
	private JButton generate;

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
		setUpButtons();

		setOpaque(false);
	}

	private void setUpButtons() {
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 20, 0));
		
		Font fnt=Themes.getCurrentTheme().getFonts().getMainButtonFont();
		Font large=new Font(fnt.getName(), fnt.getStyle(), 32);
		this.plus = new MaterialButton(" + ");
		this.plus.setFont(large);
		this.generate = new MaterialButton("Generisi");
		this.generate.setFont(large);
		
		buttonPanel.add(plus);
		buttonPanel.add(Box.createHorizontalStrut(20));
		buttonPanel.add(generate);
		
		add(buttonPanel);
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

	public JButton getPlus() {
		return plus;
	}
	
	public JButton getGenerate() {
		return generate;
	}

	@Override
	public void update() {
		repaint();
	}
	
}

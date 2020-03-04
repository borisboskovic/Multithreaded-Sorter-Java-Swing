package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import components.CustomScrollBar;
import components.VerticallyScrollablePanel;
import model.MultiFileSorterModel;
import model.PathSectionModel;

public class MultiFileSorterView extends JPanel implements ObserverInterface {

	private MultiFileSorterModel model;
	private VerticallyScrollablePanel sectionsPanel;

	public MultiFileSorterView(MultiFileSorterModel model) {
		this.model = model;
		setLayout(new BorderLayout());

		setUpSections();

		JScrollPane scrollPane = new JScrollPane(sectionsPanel);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBar());
		scrollPane.getVerticalScrollBar().setUnitIncrement(32);

		add(scrollPane, BorderLayout.CENTER);

		setOpaque(false);
	}

	private void setUpSections() {
		sectionsPanel = new VerticallyScrollablePanel();
		BoxLayout sectionsLayout = new BoxLayout(sectionsPanel, BoxLayout.PAGE_AXIS);
		sectionsPanel.setLayout(sectionsLayout);
		sectionsPanel.setOpaque(false);

		for (int i = 0; i < model.getPaths().size(); i++) {
			PathSectionView pathSection = new PathSectionView(new PathSectionModel(i + 1, model.getPaths().get(i)));
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			panel.setMaximumSize(new Dimension(2000, 130));
			panel.setLayout(new GridLayout(1, 1));
			panel.setOpaque(false);
			panel.add(pathSection);
			
			sectionsPanel.add(panel);
		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}

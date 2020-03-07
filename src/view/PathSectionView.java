package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import components.MaterialButton;
import components.MaterialTextField;
import global.Themes;
import model.PathSectionModel;
import settings.ColorTheme;

@SuppressWarnings("serial")
public class PathSectionView extends JPanel {

	private PathSectionModel model;

	private JLabel number;
	private JButton remove;
	private ColorTheme theme;

	public PathSectionView(PathSectionModel model) {
		this.theme = Themes.getCurrentTheme();
		this.model = model;
		BoxLayout mainLayout = new BoxLayout(this, BoxLayout.LINE_AXIS);
		setLayout(mainLayout);

		setUpNumber(model.getNumber());
		add(Box.createHorizontalStrut(20));
		setUpMainSection();
		add(Box.createHorizontalStrut(20));
		setUpRemoveButton();
		remove.addActionListener(removeBtnListener);

		setOpaque(false);
	}

	private void setUpNumber(int num) {
		JPanel panel = new JPanel();
		number = new JLabel(String.valueOf(num));
		number.setFont(theme.getFonts().getImportantFont());
		panel.add(number);
		panel.setOpaque(false);
		this.add(panel);
	}

	private void setUpRemoveButton() {
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
		panel.setLayout(layout);
		remove = new MaterialButton("Ukloni"); // TODO: Lokalizacija
		remove.setFont(theme.getFonts().getMainButtonFont());
		panel.add(remove);
		panel.setOpaque(false);
		Border border = BorderFactory.createEmptyBorder(0, 0, 0, 20);
		panel.setBorder(border);
		this.add(panel);
	}

	private void setUpMainSection() {
		JPanel mainSection = new JPanel();
		BoxLayout layout = new BoxLayout(mainSection, BoxLayout.PAGE_AXIS);
		mainSection.setLayout(layout);

		JLabel pathLabel = new JLabel("Path:"); // TODO: Lokalizacija
		pathLabel.setFont(theme.getFonts().getLabelFont());
		MaterialTextField pathTxtField = new MaterialTextField(512);
		pathTxtField.setText(model.getPath());
		JLabel messageLabel = new JLabel(model.getMessage());
		messageLabel.setFont(theme.getFonts().getNoteFont());
		messageLabel.setForeground(theme.getAccentColor());

		JPanel upperRow = new JPanel();
		BoxLayout upperRowLayout = new BoxLayout(upperRow, BoxLayout.LINE_AXIS);
		upperRow.setLayout(upperRowLayout);
		upperRow.add(pathLabel);
		upperRow.add(Box.createHorizontalStrut(5));
		upperRow.add(pathTxtField);
		upperRow.setOpaque(false);

		JPanel lowerRow = new JPanel();
		lowerRow.setLayout(new FlowLayout(FlowLayout.LEFT));
		lowerRow.add(messageLabel);
		lowerRow.setOpaque(false);

//		mainSection.add(Box.createVerticalStrut(20));
		mainSection.add(upperRow);
		mainSection.add(Box.createVerticalStrut(10));
		mainSection.add(lowerRow);
		mainSection.setOpaque(false);

		Border mainSectionBorder = BorderFactory.createEmptyBorder(45, 0, 10, 0);
		mainSection.setBorder(mainSectionBorder);

		this.add(mainSection);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.setColor(theme.getSectionColor());
		graphics2d.fillRoundRect(0, 0, getSize().width, getSize().height, 50, 50);
		super.paint(g);
	}

	private ActionListener removeBtnListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			MultiSorterView parentView = (MultiSorterView) (getParent().getParent().getParent().getParent()
					.getParent());
			parentView.getModel().removeFile(model);
			parentView.getModel().notifyObservers();
		}
	};
}

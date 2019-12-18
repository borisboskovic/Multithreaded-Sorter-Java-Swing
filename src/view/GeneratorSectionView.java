package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import components.MaterialButton;
import components.MaterialTextField;
import global.Themes;
import model.GeneratorSectionModel;

@SuppressWarnings("serial")
public class GeneratorSectionView extends JPanel {

	private GeneratorSectionModel model;

	private JTextField location;
	private JTextField ammount;
	private JTextField from;
	private JTextField to;
	private JButton browse;
	private JButton delete;
	private JLabel number;

	public GeneratorSectionView(GeneratorSectionModel model) {
		this.model = model;

		BoxLayout mainLayout = new BoxLayout(this, BoxLayout.LINE_AXIS);
		setLayout(mainLayout);

		JPanel locationRow = new JPanel();
		BoxLayout locationLayout = new BoxLayout(locationRow, BoxLayout.LINE_AXIS);
		locationRow.setLayout(locationLayout);
		setUpLocationRow(locationRow);

		JPanel ammountRow = new JPanel();
		BoxLayout ammountLayout = new BoxLayout(ammountRow, BoxLayout.LINE_AXIS);
		ammountRow.setLayout(ammountLayout);
		setUpAmmountRow(ammountRow);

		JPanel messageRow = new JPanel(new GridLayout(1, 1));
		JLabel message = new JLabel(model.getMessage());
		message.setFont(Themes.getCurrentTheme().getFonts().getNoteFont());
		messageRow.setBackground(Themes.getCurrentTheme().getSectionColor());
		messageRow.add(message);

		JPanel inputPanel = new JPanel();
		BoxLayout inputLayout = new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS);
		inputPanel.setBackground(new Color(0, 0, 0, 0));
		inputPanel.setLayout(inputLayout);
		inputPanel.add(Box.createVerticalStrut(40));
		inputPanel.add(locationRow);
		inputPanel.add(Box.createVerticalStrut(20));
		inputPanel.add(ammountRow);

		inputPanel.add(Box.createVerticalStrut(20));
		inputPanel.add(messageRow);
		inputPanel.add(Box.createVerticalStrut(10));

		JPanel numberPanel = new JPanel();
		setUpNumberPanel(numberPanel);

		JPanel buttonPanel = new JPanel();
		setUpButtonPanel(buttonPanel);

		add(Box.createHorizontalStrut(20));
		add(numberPanel);
		add(inputPanel);
		add(buttonPanel);
		add(Box.createHorizontalStrut(20));
		setOpaque(false);
	}

	private void setUpButtonPanel(JPanel buttonPanel) {
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		delete = new MaterialButton("Ukloni");
		buttonPanel.add(Box.createVerticalStrut(40));
		buttonPanel.add(delete);
		buttonPanel.add(Box.createVerticalGlue());
	}

	private void setUpNumberPanel(JPanel numberPanel) {
		numberPanel.setBackground(new Color(0, 0, 0, 0));
		number = new JLabel(String.valueOf(model.getSectionNumber()));
		number.setFont(Themes.getCurrentTheme().getFonts().getImportantFont());
		number.setHorizontalAlignment(SwingConstants.RIGHT);
		numberPanel.add(number);

	}

	private void setUpLocationRow(JPanel locationRow) {
		locationRow.setBackground(new Color(0, 0, 0, 0));
		Font labelFont = Themes.getCurrentTheme().getFonts().getLabelFont();
		JLabel locationLbl = new JLabel("Lokacija:");
		locationLbl.setFont(labelFont);
		this.location = new MaterialTextField(512);
		this.browse = new MaterialButton("...");

		locationRow.add(Box.createHorizontalStrut(10));
		locationRow.add(locationLbl);
		locationRow.add(Box.createHorizontalStrut(10));
		locationRow.add(location);
		locationRow.add(Box.createHorizontalStrut(10));
		locationRow.add(browse);
		locationRow.add(Box.createHorizontalStrut(10));
	}

	private void setUpAmmountRow(JPanel ammountRow) {
		ammountRow.setBackground(new Color(0, 0, 0, 0));
		Font labelFont = Themes.getCurrentTheme().getFonts().getLabelFont();
		JLabel ammountLbl = new JLabel("Koli�ina:");
		JLabel fromLbl = new JLabel("Od:");
		JLabel toLbl = new JLabel("Do");
		ammountLbl.setFont(labelFont);
		fromLbl.setFont(labelFont);
		toLbl.setFont(labelFont);

		ammount = new MaterialTextField(64);
		from = new MaterialTextField(64);
		to = new MaterialTextField(64);

		ammountRow.add(Box.createHorizontalStrut(10));
		ammountRow.add(ammountLbl);
		ammountRow.add(Box.createHorizontalStrut(10));
		ammountRow.add(ammount);
		ammountRow.add(Box.createHorizontalStrut(20));
		ammountRow.add(fromLbl);
		ammountRow.add(Box.createHorizontalStrut(10));
		ammountRow.add(from);
		ammountRow.add(Box.createHorizontalStrut(20));
		ammountRow.add(toLbl);
		ammountRow.add(Box.createHorizontalStrut(10));
		ammountRow.add(to);
		ammountRow.add(Box.createHorizontalStrut(10));
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.setColor(Themes.getCurrentTheme().getSectionColor());
		graphics2d.fillRoundRect(0, 0, getSize().width, getSize().height, 50, 50);
		super.paint(g);
	}

}
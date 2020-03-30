package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicComboBoxUI;

import components.MaterialButton;
import components.MaterialComboBox;
import components.MaterialTextField;
import model.MultithreadedTestModel;
import settings.ColorTheme;
import settings.Themes;

@SuppressWarnings("serial")
public class MultithreadedTestView extends JPanel {
	private MultithreadedTestModel model;

	private JTextField path;
	private JButton browseBtn;
	private JComboBox<Integer> maxThreads;
	private JTextField minFilesPerThread;
	private JButton sortBtn;
	private JPanel mainPanel;

	public MultithreadedTestView(MultithreadedTestModel model) {
		this.model = model;

		BoxLayout containerLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(containerLayout);
		setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

		mainPanel = new JPanel();
		BoxLayout mainPanelLayout = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
		mainPanel.setLayout(mainPanelLayout);
		mainPanel.setOpaque(false);
		mainPanel.setMaximumSize(new Dimension(2000, 475));
		mainPanel.setPreferredSize(new Dimension(2000, 475));

		ColorTheme th = Themes.getCurrentTheme();
		mainPanel.add(createPathPanel(th));
		mainPanel.add(createAmmountPanel(th));
		mainPanel.add(createNoticePanel(th));
		mainPanel.add(createBtnPanel(th));
		
		this.browseBtn.addActionListener(browseBtnListener);

		add(Box.createVerticalGlue());
		add(mainPanel);
		add(Box.createVerticalGlue());

		setOpaque(false);
	}

	private JPanel createPathPanel(ColorTheme th) {
		Font lblFont = th.getFonts().getLabelFont();

		JPanel panel = new JPanel();
		BoxLayout ly = new BoxLayout(panel, BoxLayout.LINE_AXIS);
		panel.setLayout(ly);
		panel.setMaximumSize(new Dimension(2000, 46));
		panel.setOpaque(false);
		JLabel label = new JLabel("Path: "); // TODO: Lokalizacija
		label.setFont(lblFont);
		this.path = new MaterialTextField(20);
		this.browseBtn = new MaterialButton("...");

		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createEmptyBorder(50, 100, 25, 100));
		container.setLayout(new GridLayout(1, 1));
		container.setMaximumSize(new Dimension(2000, 118));
		container.setOpaque(false);

		panel.add(label);
		panel.add(path);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(browseBtn);
		container.add(panel);
		return container;
	}

	private JPanel createAmmountPanel(ColorTheme th) {
		JPanel panel = new JPanel();
		Font lblFont = th.getFonts().getLabelFont();

		BoxLayout ly = new BoxLayout(panel, BoxLayout.LINE_AXIS);
		panel.setLayout(ly);
		panel.setMaximumSize(new Dimension(2000, 46));
		panel.setOpaque(false);

		JLabel lbl1 = new JLabel("Max threads: ");
		lbl1.setFont(lblFont);

		JLabel lbl2 = new JLabel("Min files per thread: ");
		lbl2.setFont(lblFont);

		// Thread Count combo box
		Vector<Integer> count = new Vector<>();
		count.add(1);
		count.add(2);
		count.add(4);
		count.add(8);
		count.add(16);
		count.add(32);
		this.maxThreads = new MaterialComboBox<>(count);
		this.maxThreads.setFont(lblFont);
		this.maxThreads.setPreferredSize(new Dimension(90, 46));
		this.maxThreads.setMaximumSize(new Dimension(100, 100));
		this.maxThreads.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton b = super.createArrowButton();
				b = new JButton("\u02c5");
				b.setFont(lblFont);
				b.setBackground(th.getAccentColor());
				b.setForeground(th.getTextSecondaryColor());
				b.setBorderPainted(false);
				return b;

			}
		});
		ComboBoxEditor editor = this.maxThreads.getEditor();
		JPanel editorPanel = (JPanel) editor.getEditorComponent();
		editorPanel.setFont(lblFont);
		JLabel label = (JLabel) editorPanel.getComponent(0);
		label.setFont(lblFont);
		label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		editorPanel.setLayout(new GridLayout(1, 1));
		this.maxThreads.setEditor(editor);

		this.minFilesPerThread = new MaterialTextField(3);
		this.minFilesPerThread.setFont(lblFont);
		this.minFilesPerThread.setMaximumSize(new Dimension(100, 100));

		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createEmptyBorder(20, 100, 25, 100));
		container.setMaximumSize(new Dimension(2000, 91));
		container.setLayout(new GridLayout(1, 1));
		container.setOpaque(false);

		panel.add(Box.createHorizontalGlue());
		panel.add(lbl1);
		panel.add(maxThreads);
		panel.add(Box.createHorizontalGlue());
		panel.add(lbl2);
		panel.add(minFilesPerThread);
		panel.add(Box.createHorizontalGlue());
		container.add(panel);

		return container;
	}

	private JPanel createNoticePanel(ColorTheme th) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setLayout(new GridLayout(1, 1));
		panel.setMaximumSize(new Dimension(2000, 150));
		panel.setOpaque(false);

		JLabel label = new JLabel(
				"<html>* Ovaj tekst treba zamijeniti stvarnim tekstom. Ovaj tekst treba zamijeniti stvarnim tekstom.Ovaj tekst treba zamijeniti stvarnim tekstom.Ovaj tekst treba zamijeniti stvarnim tekstom.Ovaj tekst treba zamijeniti stvarnim tekstom.</html>");

		label.setFont(th.getFonts().getNoteFont());
		label.setForeground(th.getAccentColor());
		panel.add(label);

		JPanel container = new JPanel(new GridLayout(1, 1));
		container.setMaximumSize(new Dimension(2000, 175));
		container.setBorder(BorderFactory.createEmptyBorder(0, 50, 25, 50));
		container.setOpaque(false);
		container.add(panel);
		return container;
	}

	private JPanel createBtnPanel(ColorTheme th) {
		Font fontLg = new Font(th.getFonts().getMainButtonFont().getName(), Font.TRUETYPE_FONT, 32);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setMaximumSize(new Dimension(2000, 80));
		panel.setOpaque(false);
		this.sortBtn = new MaterialButton("   Sort   "); // TODO: Lokalizacija
		this.sortBtn.setFont(fontLg);

		panel.add(sortBtn);
		return panel;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Themes.getCurrentTheme().getSectionColor());
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.fillRoundRect(mainPanel.getLocation().x, mainPanel.getLocation().y, mainPanel.getSize().width,
				mainPanel.getSize().height, 50, 50);
		super.paint(g);
	}

	private ActionListener browseBtnListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("TXT files", "txt");
			fileChooser.addChoosableFileFilter(fileFilter);
			fileChooser.setPreferredSize(new Dimension(800, 600));

			int returnValue = fileChooser.showSaveDialog(MultithreadedTestView.this);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				String selectedFile = fileChooser.getSelectedFile().getPath().toString();
				MultithreadedTestView.this.path.setText(selectedFile);
			}
		}
	};
	
}

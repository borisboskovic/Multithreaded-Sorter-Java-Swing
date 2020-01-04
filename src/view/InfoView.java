package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import controller.OpenExplorerController;
import global.Themes;
import model.InfoModel;

public class InfoView extends JPanel {

	private InfoModel model;
	private int padd; // Border Thickness

	public InfoView(InfoModel model) {
		this.model = model;
		this.padd = 50;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentX(Component.CENTER_ALIGNMENT);

		addComponentsFromModel(this);

		setOpaque(false);
	}

	private void addComponentsFromModel(JComponent component) {

		JPanel basicLabels = new JPanel();
		basicLabels.setLayout(new GridLayout(6, 1));
		basicLabels.setOpaque(false);

		JLabel userName = new JLabel("User Name: " + model.getUserName());
		JLabel OS_name = new JLabel("Operating System: " + model.getOS_name());
		JLabel OS_version = new JLabel("OS version: " + model.getOS_version());
		JLabel architecture = new JLabel("Architecture: " + model.getOS_architecture());
		JLabel coresCount = new JLabel("Number of logical cores: " + model.getCoresCount());
		JLabel cpu = new JLabel("CPU: " + model.getProcessorName());

		Font labelFont = Themes.getCurrentTheme().getFonts().getLabelFont();
		userName.setFont(labelFont);
		OS_name.setFont(labelFont);
		OS_version.setFont(labelFont);
		architecture.setFont(labelFont);
		coresCount.setFont(labelFont);
		cpu.setFont(labelFont);

		userName.setHorizontalAlignment(JLabel.CENTER);
		OS_name.setHorizontalAlignment(JLabel.CENTER);
		OS_version.setHorizontalAlignment(JLabel.CENTER);
		architecture.setHorizontalAlignment(JLabel.CENTER);
		coresCount.setHorizontalAlignment(JLabel.CENTER);
		cpu.setHorizontalAlignment(JLabel.CENTER);

		Color labelColor = Themes.getCurrentTheme().getTextPrimaryColor();
		userName.setForeground(labelColor);
		OS_name.setForeground(labelColor);
		OS_version.setForeground(labelColor);
		architecture.setForeground(labelColor);
		coresCount.setForeground(labelColor);
		cpu.setForeground(labelColor);

		basicLabels.add(userName);
		basicLabels.add(OS_name);
		basicLabels.add(OS_version);
		basicLabels.add(architecture);
		basicLabels.add(coresCount);
		basicLabels.add(cpu);

		component.add(basicLabels);

		JLabel disksCaption = new JLabel("Disks:");
		disksCaption.setForeground(labelColor);
		disksCaption.setFont(labelFont);
		component.add(disksCaption);

		JPanel disksPanel = new JPanel();
		int rowsNumber = (model.getDisks().size() % 2 == 0) ? model.getDisks().size() / 2
				: model.getDisks().size() / 2 + 1;
		disksPanel.setLayout(new GridLayout(rowsNumber, 2));
		disksPanel.setMaximumSize(new Dimension(3000, 70 * rowsNumber));
		disksPanel.setOpaque(false);

		for (int i = 0; i < model.getDisks().size(); i++) {
			Image hddIcon = getToolkit().getImage("resources/images/hard-drive.png");
			hddIcon = hddIcon.getScaledInstance(64, 64, Image.SCALE_AREA_AVERAGING);
			JLabel iconLabel = new JLabel(new ImageIcon(hddIcon));
			new OpenExplorerController(iconLabel, model.getDisks().get(i));

			JLabel pathLabel = new JLabel(model.getDisks().get(i).getPath() + "  ");
			pathLabel.setFont(labelFont);
			pathLabel.setForeground(labelColor);

			long totalSpace = model.getDisks().get(i).getTotalBytes();
			long freeSpace = model.getDisks().get(i).getFreeBytes();
			double usageRatio = (double) freeSpace / (double) totalSpace;

			JPanel singleDiskPanel = new JPanel(new FlowLayout());
			singleDiskPanel.setOpaque(false);

			JProgressBar diskUsage = new JProgressBar();
			diskUsage.setValue((int) ((1 - usageRatio) * 100));
			diskUsage.setMaximum(100);
			diskUsage.setStringPainted(true);

			singleDiskPanel.add(iconLabel);
			singleDiskPanel.add(pathLabel);
			singleDiskPanel.add(diskUsage);
			disksPanel.add(singleDiskPanel);
		}

		component.add(disksPanel);
		component.setBorder(BorderFactory.createEmptyBorder(padd, padd, padd, padd));
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Themes.getCurrentTheme().getSectionColor());
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.fillRoundRect(padd, padd, getSize().width - 2 * padd, getSize().height - 2 * padd, 50, 50);

		super.paint(g);
	}

}

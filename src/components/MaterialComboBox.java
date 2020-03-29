package components;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxUI;

import settings.ColorTheme;
import settings.Themes;

@SuppressWarnings("serial")
public class MaterialComboBox<E> extends JComboBox<E> {

	public MaterialComboBox(Vector<E> items) {
		super(items);
		ColorTheme th = Themes.getCurrentTheme();
		Font fnt = th.getFonts().getMainButtonFont();
		Font large = new Font(fnt.getName(), fnt.getStyle(), 32);
		setFont(large);
		setBackground(th.getThemeColor());
		setForeground(th.getTextSecondaryColor());

		setEditor(new CustomComboBoxEditor());
		setEditable(true);
		setRenderer(new CustomCellRenderer(getRenderer()));

		setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton b = super.createArrowButton();
				b = new JButton("\u02c5");
				b.setFont(large);
				b.setBackground(th.getAccentColor());
				b.setForeground(th.getTextSecondaryColor());
				b.setBorderPainted(false);
				return b;
			}
		});

	}

}

class CustomCellRenderer extends DefaultListCellRenderer {

	private ListCellRenderer defaultRenderer;

	public CustomCellRenderer(ListCellRenderer defaultRenderer) {
		this.defaultRenderer = defaultRenderer;
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component c = defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		ColorTheme th = Themes.getCurrentTheme();
		if (c instanceof JLabel) {
			if (isSelected) {
				c.setBackground(th.getAccentColor());
				c.setForeground(th.getTextSecondaryColor());
				((JLabel) c).setBorder(null);
			} else {
			}
		} else {
			c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		}
		return c;
	}
}

class CustomComboBoxEditor extends BasicComboBoxEditor {
	private JLabel label = new JLabel();
	private JPanel panel = new JPanel();
	private Object selectedItem;

	public CustomComboBoxEditor() {

		ColorTheme th = Themes.getCurrentTheme();
		Font ft = th.getFonts().getMainButtonFont();
		Font large = new Font(ft.getName(), ft.getStyle(), 32);

		label.setOpaque(false);
		label.setFont(large);
		label.setForeground(th.getTextSecondaryColor());

		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(label);
		panel.setBackground(th.getThemeColor());
		panel.setBorder(null);
	}

	public Component getEditorComponent() {
		return this.panel;
	}

	public Object getItem() {
		return this.selectedItem.toString();
	}

	public void setItem(Object item) {
		this.selectedItem = item;
		label.setText(item.toString());
	}

}

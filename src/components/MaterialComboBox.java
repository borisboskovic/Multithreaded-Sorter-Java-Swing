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
import settings.Context;
import settings.FontTheme;

@SuppressWarnings("serial")
public class MaterialComboBox<E> extends JComboBox<E> {
	private ColorTheme theme;
	private FontTheme fonts;

	public MaterialComboBox(Vector<E> items) {
		super(items);
		this.theme = Context.getContext().getColorTheme();
		this.fonts = Context.getContext().getFonts();
		Font fnt = fonts.getMainButtonFont();
		Font large = new Font(fnt.getName(), fnt.getStyle(), 32);
		setFont(large);
		setBackground(theme.getThemeColor());
		setForeground(theme.getTextSecondaryColor());

		setEditor(new CustomComboBoxEditor());
		setEditable(true);
		setRenderer(new CustomCellRenderer(getRenderer()));

		setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton b = super.createArrowButton();
				b = new JButton("\u02c5");
				b.setFont(large);
				b.setBackground(theme.getAccentColor());
				b.setForeground(theme.getTextSecondaryColor());
				b.setBorderPainted(false);
				return b;
			}
		});

	}

}

@SuppressWarnings("serial")
class CustomCellRenderer extends DefaultListCellRenderer {
	private ColorTheme theme = Context.getContext().getColorTheme();
	private ListCellRenderer defaultRenderer;

	public CustomCellRenderer(ListCellRenderer defaultRenderer) {
		this.defaultRenderer = defaultRenderer;
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component c = defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (c instanceof JLabel) {
			if (isSelected) {
				c.setBackground(theme.getAccentColor());
				c.setForeground(theme.getTextSecondaryColor());
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

		ColorTheme th = Context.getContext().getColorTheme();
		Font ft = Context.getContext().getFonts().getMainButtonFont();
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

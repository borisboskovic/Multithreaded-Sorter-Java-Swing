package components;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextField;

public class MaterialTextField extends JTextField {

	public MaterialTextField(int length) {
		super(length);
		dohvatiFont();
		System.out.println(getFont().getFamily());
	}

	private void dohvatiFont() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.PLAIN, new FileInputStream("resources//fonts//Roboto-Condensed.ttf")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setFont(new Font("Roboto Cn", Font.PLAIN, 24));
	}

}

package lz77;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends JFrame {
	private JLabel label;
	private JButton compress;
	private JButton Decompress;
	String path;

	App() {
		super("LZ77");
		Panel f = new Panel();
		setLayout(null);
		setVisible(true);
		setBounds(400, 200, 400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		compress = new JButton("Compress");
		Decompress = new JButton("DeCompress");
		label = new JLabel("Hello to My first comprision App LZ77");

		label.setBounds(100, 20, 220, 30);
		f.add(label);
		add(label);
		label.setVisible(true);

		compress.setBounds(150, 120, 115, 50);
		f.add(compress);
		add(compress);

		/*Decompress.setBounds(50, 120, 115, 50);
		f.add(Decompress);
		add(Decompress);*/
		// chooser.showOpenDialog(this);

		compress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();

				// For Directory
				// fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				// For File
				// fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				fileChooser.setAcceptAllFileFilterUsed(false);

				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					path = (fileChooser.getSelectedFile().getAbsolutePath());
					Scanner read = null;
					String input = null;
					String data = "";

					try {
						read = new Scanner(new File(path));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					while (read.hasNext()) {
						input = read.nextLine();
						data += input + "\n";
					}
					ArrayList<Tage> k = main.compress(data);
					String n = main.deCom(k);
					System.out.println(data + n);

				}
			}
		});

		/*
		 * Scanner read = null; String input = null; String data = "";
		 * 
		 * try { read = new Scanner(new File(path)); } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } while (read.hasNext()) { input =
		 * read.nextLine(); data += input + "\n"; } ArrayList<Tage> k =
		 * main.compress(data); System.out.println(data);
		 */

	}
}
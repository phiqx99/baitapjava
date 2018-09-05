import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileFrame frame = new FileFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea tafile = new JTextArea();
		tafile.setBounds(12, 13, 638, 271);
		contentPane.add(tafile);
		
		JButton btopen = new JButton("Open");
		btopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("D:\\"));
				chooser.setDialogTitle("Save file as..");
			if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				String filename= chooser.getSelectedFile().getAbsolutePath();
				openFile(filename);
			}}

			private void openFile(String data) {
				// TODO Auto-generated method stub
				try {
					BufferedReader br = new BufferedReader(new FileReader(data));

		            while ((data = br.readLine()) != null) {
		                tafile.append(data+"\n");
		                data = br.readLine();
		            }
					br.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btopen.setBounds(173, 310, 117, 40);
		contentPane.add(btopen);
		
		JButton btsave = new JButton("Save");
		btsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("D:\\"));
				chooser.setDialogTitle("Save file as..");
			if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String filename= chooser.getSelectedFile().getAbsolutePath();
				saveFile(filename);
			}
			}
			public void saveFile(String filename) { 
				FileWriter fw =null;
				try {
					fw =new FileWriter(filename);
					String s = tafile.getText();
					fw.write(s);
					fw.flush();
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				finally {
					try {
						fw.close();
						JOptionPane.showMessageDialog(null, "File "+filename +" đã được lưu lại");
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			
			}
		});
		btsave.setBounds(385, 310, 117, 40);
		contentPane.add(btsave);
	}


}

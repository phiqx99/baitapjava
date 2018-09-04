import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class testjfilechooser {
	private JFrame frame;
	private JFileChooser file;
	private JButton btn;
	
	public testjfilechooser()
	{
		frame = new JFrame("JFileChooser Example");
		btn = new JButton("Click");
		file = new JFileChooser();
	}
	public void show()
	{
		frame.setLayout(null);
		frame.setBounds(45, 45, 300, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		btn.setBounds(15, 15, 100, 25);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn)
				{
					int i = file.showOpenDialog(frame);
					if(i==JFileChooser.APPROVE_OPTION)
					{
						File f=file.getSelectedFile();
						String path=f.getPath();
						try {
							BufferedReader reader = new BufferedReader(new FileReader(path));
							StringBuilder builder = new StringBuilder();
							String line="";
							while((line=reader.readLine())!=null)
									{
								builder.append(line).append("\n");
									}
							System.out.println(builder.toString());
						} catch (FileNotFoundException e2) {
							// TODO: handle exception
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
testjfilechooser t = new testjfilechooser();
t.show();
	}

}

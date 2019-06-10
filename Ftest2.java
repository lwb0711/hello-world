import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ftest2 extends JFrame {
	JScrollPane sp;
	JPanel jp;
	JTextArea ta;
	JButton btread;
	JButton btwrite;
	File file;
	
	public Ftest2(String title) {
		super(title);
		setSize(300,400);
		setLocation(400,400);
		ta = new JTextArea(5,20);
		sp = new JScrollPane(ta);
		jp = new JPanel();
		
		add(sp,BorderLayout.CENTER);
		add(jp,BorderLayout.SOUTH);
		btread=new JButton("读取文件");
		btwrite=new JButton("写入文件");
		jp.add(btread);
		jp.add(btwrite);
		btread.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				file =new File("d:/new.txt");
				try {
					FileReader in=new FileReader(file);
					char [] readchar=new char [1024];
					int len=in.read(readchar);
					ta.setText(new String(readchar,0,len));
					in.close();
				}catch(Exception e2){
					e2.printStackTrace();
				}
			}
		});

	btwrite.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			file=new File("d:/new.txt");
			try {
				FileWriter out=new FileWriter(file);
				out.write(ta.getText());
				out.close();
				JOptionPane.showMessageDialog
				(null,"文本区内容成功写入"+file.getAbsolutePath());
			}catch(Exception e2){
	
			}
		}
	});
	setVisible(true);
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ftest2 test2=new Ftest2("读取文件测试");
	}
}

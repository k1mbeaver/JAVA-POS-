import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SalesManagement_TotalSales extends JFrame 
{
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[2];
	String[] Str = {"���λ���","�ڷΰ���"};
	String [] ColName = {"��ȣ","�������","����"};
	String [] ColName2 = {"��ǰ", "����"};
	String [][] Data;
	String [][] Data2;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	DefaultTableModel model2 = new DefaultTableModel(Data2,ColName2);
	JTable table2 = new JTable(model2);
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("�������", Font.BOLD, 15));
			add(new JScrollPane(table));
		}
	}
	
	class SubScreen extends JPanel
	{
		SubScreen()
		{
				DefaultTableModel m2 = (DefaultTableModel)table2.getModel();
				table2.setRowHeight(50);
				table2.getTableHeader().setFont(new Font("�������", Font.BOLD, 15));
				add(new JScrollPane(table2));		
		}
	}
	
	class SelectButton extends JPanel{
		SelectButton(){
			setLayout(new GridLayout(1, 2));
			
			for(int i = 0; i < 2; i++) {
				SBtn[i]= new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public SalesManagement_TotalSales() {
		setTitle("���� ����");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SubScreen sbtn = new SubScreen();
		SelectButton sc = new SelectButton();
		
		//�ݾ׶�
		tf.setSize(450, 70);
		tf.setLocation(50, 480);
		add(tf);
		
		sbtn.setSize(500, 450);
		sbtn.setLocation(500, 0);
		add(sbtn);
		
		mbtn.setSize(500, 450);
		mbtn.setLocation(15, 0);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(530, 480);
		add(sc);
		//���λ���
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new POS_MainMenu();
			}
		});
		
			//�ڷΰ���
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new POS_MainMenu();
			}
		});
	}
}
// 1. �� �Ǹűݾ�, 2. �μ��ΰ�
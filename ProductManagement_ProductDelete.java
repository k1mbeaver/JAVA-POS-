import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ProductManagement_ProductDelete extends JFrame 
{
	JButton[] SBtn = new JButton[3];
	String[] Str = {"�����ϱ�", "�ڷΰ���"};
	String [] ColName = {"�̸�","��ȣ","����", "���"};
	String [][] Data;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
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
			setLayout(new GridLayout(3,1));
			JPanel ProductName = new JPanel();
			JPanel ProductNumber = new JPanel();
			JPanel ProductSearch = new JPanel();

			ProductName.add(new JLabel("�̸�"));
			ProductName.add(new JTextField(20));
			ProductNumber.add(new JLabel("��ȣ"));
			ProductNumber.add(new JTextField(20));
			ProductSearch.add(new JButton("�˻�"));
			
			add(ProductName);
			add(ProductNumber);
			add(ProductSearch);
		}
	}
	
	class SelectButton extends JPanel
	{
		SelectButton(){
			setLayout(new GridLayout(1, 2));
			
			for(int i = 0; i < 2; i++) 
			{
				SBtn[i]= new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public ProductManagement_ProductDelete()
	{
		setTitle("��� ����");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SubScreen sbtn = new SubScreen();
		SelectButton sc = new SelectButton();
		
		sbtn.setSize(500, 450);
		sbtn.setLocation(500, 30);
		add(sbtn);
		
		mbtn.setSize(500, 450);
		mbtn.setLocation(15, 0);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(300, 480);
		add(sc);
		// �����ϱ�
		SBtn[0].addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				new POS_MainMenu();
			}
		});
		
			//�ڷΰ���
		SBtn[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new POS_ProductManagement();
			}
		});
	}
}
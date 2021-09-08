import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ProductManagement_ProductRegister extends JFrame 
{
	JButton[] SBtn = new JButton[2];
	String[] Str = {"����","�ڷΰ���"};
	int count =1;
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			setLayout(new GridLayout(4,1));
			JPanel ProductName = new JPanel();
			JPanel ProductPrice = new JPanel();
			JPanel ProductIndex = new JPanel();
			JPanel ProductNumber = new JPanel();
			ProductName.add(new JLabel("�̸�"));
			ProductName.add(new JTextField(20));
			ProductNumber.add(new JLabel("��ȣ"));
			ProductNumber.add(new JTextField(20));
			ProductPrice.add(new JLabel("����"));
			ProductPrice.add(new JTextField(20));
			ProductIndex.add(new JLabel("���"));
			ProductIndex.add(new JTextField(20));
			
			add(ProductName);
			add(ProductNumber);
			add(ProductPrice);
			add(ProductIndex);
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
	
	public ProductManagement_ProductRegister()
	{
		setTitle("��� ����");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SelectButton sc = new SelectButton();

		// �Է�â
		mbtn.setSize(700, 450);
		mbtn.setLocation(150, 20);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(300, 480);
		add(sc);
		// ����
		SBtn[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new POS_MainMenu();
			}
		});
		
		// �ڷΰ���
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
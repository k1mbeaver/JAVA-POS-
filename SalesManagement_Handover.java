import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SalesManagement_Handover extends JFrame 
{
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[2];
	String[] Str = {"����","�ڷΰ���"};
	int count =1;
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			setLayout(new GridLayout(8,1));
			JPanel FiftyThousandPanel = new JPanel();
			JPanel TenThousandPanel = new JPanel();
			JPanel FiveThousandPanel = new JPanel();
			JPanel OneThousandPanel = new JPanel();
			JPanel FiveHundredPanel = new JPanel();
			JPanel OneHundredPanel = new JPanel();
			JPanel FiftyPanel = new JPanel();
			JPanel tenPanel = new JPanel();
			FiftyThousandPanel.add(new JLabel("50000��"));
			FiftyThousandPanel.add(new JTextField(20));
			TenThousandPanel.add(new JLabel("10000��"));
			TenThousandPanel.add(new JTextField(20));
			FiveThousandPanel.add(new JLabel("5000��"));
			FiveThousandPanel.add(new JTextField(20));
			OneThousandPanel.add(new JLabel("1000��"));
			OneThousandPanel.add(new JTextField(20));
			FiveHundredPanel.add(new JLabel("500��"));
			FiveHundredPanel.add(new JTextField(20));
			OneHundredPanel.add(new JLabel("100��"));
			OneHundredPanel.add(new JTextField(20));
			FiftyPanel.add(new JLabel("50��"));
			FiftyPanel.add(new JTextField(20));
			tenPanel.add(new JLabel("10��"));
			tenPanel.add(new JTextField(20));
			
			add(FiftyThousandPanel);
			add(TenThousandPanel);
			add(FiveThousandPanel);
			add(OneThousandPanel);
			add(FiveHundredPanel);
			add(OneHundredPanel);
			add(FiftyPanel);
			add(tenPanel);
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
	
	public SalesManagement_Handover()
	{
		setTitle("���� ����");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SelectButton sc = new SelectButton();
		
		//�ݾ׶�
		tf.setSize(450, 70);
		tf.setLocation(50, 480);
		add(tf);
		
		// �Է�â
		mbtn.setSize(700, 450);
		mbtn.setLocation(150, 20);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(530, 480);
		add(sc);
		//����
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
				new POS_SalesManagement();
			}
		});
	}
}
// 1. �� �Ǹűݾ�, 2. �μ��ΰ�
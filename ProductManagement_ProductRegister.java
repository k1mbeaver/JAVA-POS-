import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProductManagement_ProductRegister extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[2];
	String str_list[] = {"�ڷ� ����", "���"};
	JPanel ButtonPanel = new JPanel();
	JPanel RegisterPanel = new JPanel();
	
	public ProductManagement_ProductRegister() 
	{
		setTitle("��� ����");
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		mycontainer = getContentPane();
		mycontainer.setLayout(new GridLayout(2, 1));
		setButton();
		setRegisterPanel();
		mycontainer.add(RegisterPanel);
		mycontainer.add(ButtonPanel);
		setVisible(true);
	}

	void setButton()
	{
		ButtonPanel.setLayout(new FlowLayout());
		for (int nIndex = 0; nIndex < 2; nIndex++)
		{
			button_lise[nIndex] = new JButton(str_list[nIndex]);
			
			if(nIndex == 0) // �ڷ� ����
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new POS_ProductManagement();
					}
				});
			}
			/*
			else if(nIndex == 1) // ���
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new POS_SellProcess();
					}
				});
			}
			*/
			ButtonPanel.add(button_lise[nIndex]);
		}
	}

	void setRegisterPanel()
	{
		RegisterPanel.setLayout(new GridLayout(4,1));
		JPanel NamePanel = new JPanel();
		JPanel NumberPanel = new JPanel();
		JPanel PricePanel = new JPanel();
		JPanel ProductPanel = new JPanel();
		NamePanel.add(new JLabel("�̸� "));
		NamePanel.add(new JTextField(20));
		NumberPanel.add(new JLabel("��ȣ "));
		NumberPanel.add(new JTextField(20));
		PricePanel.add(new JLabel("���� "));
		PricePanel.add(new JTextField(20));
		ProductPanel.add(new JLabel("��� "));
		ProductPanel.add(new JTextField(20));
		RegisterPanel.add(NamePanel);
		RegisterPanel.add(NumberPanel);
		RegisterPanel.add(PricePanel);
		RegisterPanel.add(ProductPanel);
	}
	

}
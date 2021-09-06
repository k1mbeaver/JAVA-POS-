import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProductManagement_ProductDelete extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[2];
	String str_list[] = {"�ڷ� ����", "�˻�"};
	JPanel IndexPanel = new JPanel();
	JPanel ButtonPanel = new JPanel();
	JPanel SearchPanel = new JPanel();
	
	public ProductManagement_ProductDelete() 
	{
		setTitle("��� ����");
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		mycontainer = getContentPane();
		mycontainer.setLayout(new GridLayout(3, 1));
		setButton();
		setSearchPanel();
		setIndexPanel();
		mycontainer.add(SearchPanel);
		mycontainer.add(IndexPanel);
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
			else if(nIndex == 1) // �˻�
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

	void setSearchPanel()
	{
		SearchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		SearchPanel.add(new JTextField(".... �̸� Ȥ�� ��ȣ", 20));
	}
	
	void setIndexPanel()
	{
		IndexPanel.setLayout(new FlowLayout());
		IndexPanel.add(new JTextArea(20, 100));
	}

}
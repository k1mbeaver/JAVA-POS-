import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class POS_SalesManagement extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[2];
	String str_list[] = {"�� �Ǹűݾ�", "�μ��ΰ�"};

	public POS_SalesManagement() 
	{
		setTitle("���� ����");
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		mycontainer = getContentPane();
		mycontainer.setLayout(new GridLayout(2, 1));
		setButton();
		setVisible(true);
	}

	void setButton()
	{
		mycontainer = getContentPane();
		mycontainer.setLayout(new GridLayout());
		for (int nIndex = 0; nIndex < 2; nIndex++)
		{
			button_lise[nIndex] = new JButton(str_list[nIndex]);
			
			if(nIndex == 0)
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new SalesManagement_TotalSales();
					}
				});
			}
			
			else if(nIndex == 1)
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new SalesManagement_Handover();
					}
				});
			}
			mycontainer.add(button_lise[nIndex]);
		}
	}
}
// 1. �� �Ǹűݾ�, 2. �μ��ΰ�
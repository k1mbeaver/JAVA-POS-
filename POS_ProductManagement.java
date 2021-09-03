import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class POS_ProductManagement extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[4];
	String str_list[] = {"��ǰ ��ȸ", "��ǰ ���", "��ǰ ����", "�ڷΰ���"};

	public POS_ProductManagement() 
	{
		setTitle("��� ����");
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
		for (int nIndex = 0; nIndex < 4; nIndex++)
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
						new ProductManagement_ProductCheck();
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
						new ProductManagement_ProductRegister();
					}
				});
			}
			
			else if(nIndex == 2)
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new ProductManagement_ProductDelete();
					}
				});
			}
			
			else if(nIndex == 3)
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new POS_MainMenu();
					}
				});
			}
			mycontainer.add(button_lise[nIndex]);
		}
	}
}
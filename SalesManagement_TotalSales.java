import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SalesManagement_TotalSales extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[4];
	String str_list[] = {"총 판매금액", "인수인계"};

	public SalesManagement_TotalSales() 
	{
		setButton();
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
// 1. 총 판매금액, 2. 인수인계
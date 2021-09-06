import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProductManagement_ProductDelete extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[2];
	String str_list[] = {"뒤로 가기", "검색"};
	JPanel IndexPanel = new JPanel();
	JPanel ButtonPanel = new JPanel();
	JPanel SearchPanel = new JPanel();
	
	public ProductManagement_ProductDelete() 
	{
		setTitle("재고 관리");
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
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
			
			if(nIndex == 0) // 뒤로 가기
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
			else if(nIndex == 1) // 검색
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
		SearchPanel.add(new JTextField(".... 이름 혹은 번호", 20));
	}
	
	void setIndexPanel()
	{
		IndexPanel.setLayout(new FlowLayout());
		IndexPanel.add(new JTextArea(20, 100));
	}

}
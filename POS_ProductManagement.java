import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class POS_ProductManagement extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[4];
	String str_list[] = {"상품 조회", "상품 등록", "상품 삭제", "뒤로가기"};

	public POS_ProductManagement() 
	{
		setTitle("재고 관리");
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
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
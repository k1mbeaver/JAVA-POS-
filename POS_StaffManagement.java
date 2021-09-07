import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class POS_StaffManagement extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[2];
	String str_list[] = {"근무자 등록", "근무자 목록", "근무자 삭제", "뒤로 가기"};

	public POS_StaffManagement() 
	{
		setTitle("근무자 관리");
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
						new POS_MainMenu();
					}
				});
			}
			mycontainer.add(button_lise[nIndex]);
		}
	}
}
// 근무자 등록, 근무자 목록
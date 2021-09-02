import java.awt.*;
import javax.swing.*;

public class POS_MainMenu extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[6];
	String str_list[] = {"��� ����", "�Ǹ� ó��", "�԰� ó��", "���� ����", "�ٹ��ڰ���", "����"};

	public POS_MainMenu() 
	{
		setButton();
	}

	void setButton()
	{
		mycontainer = getContentPane();
		mycontainer.setLayout(new GridLayout());
		for (int nIndex = 0; nIndex < 6; nIndex++)
		{
			button_lise[nIndex] = new JButton(str_list[nIndex]);
			mycontainer.add(button_lise[nIndex]);
		}
	}
}

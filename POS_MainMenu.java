import java.awt.*;
import javax.swing.*;

public class POS_MainMenu extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[6];
	String str_list[] = {"犁绊 包府", "魄概 贸府", "涝绊 贸府", "概免 包府", "辟公磊包府", "辆丰"};

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

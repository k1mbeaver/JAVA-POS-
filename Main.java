import java.awt.*;
import javax.swing.*;

import com.ibm.icu.util.Calendar;

public class Main extends JFrame
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					new POS_MainMenu();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}

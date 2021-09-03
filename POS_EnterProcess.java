import java.awt.*;
import javax.swing.*;

public class POS_EnterProcess extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[4];
	String str_list[] = {"상품 조회", "상품 등록", "상품 삭제", "뒤로가기"};

	public POS_EnterProcess() 
	{
		setTitle("입고 처리");
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
			mycontainer.add(button_lise[nIndex]);
		}
	}
}
// 1. 현재 재고 상황 ->(한 상품 더블 클릭 시) -> 해당 상품 입고 처리 안내문
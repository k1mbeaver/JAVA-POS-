import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.*;

public class ProductManagement_ProductRegister extends JFrame 
{
	// Connection은 데이터베이스와 연결하는 객체이다.
	Connection conn = null;
	// ResultSet : 실행한 쿼리문의 값을 받는 객체
	ResultSet rs = null;
	Statement st = null; // 그냥 가져오는거
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement ps = null; // ?넣어서 집어넣는거
	String usePos;
	String showProducts;
	JTextField MyName;
	JTextField MyNumber;
	JTextField MyPrice;
	JTextField MyStock;
	JButton[] SBtn = new JButton[2];
	String[] Str = {"저장","뒤로가기"};
	int count =1;
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			try {
				String user = "root";
				String pw = "rlatmddnr48!";
				String url = "jdbc:mysql://127.0.0.1/?useSSL=false&user=root&password=rlatmddnr48!";

				// jdbc drive를 등록하는 과정
				// class.forName을 호출하면 Driver가 자기자신을 초기화하여 DriverManager에 등록한다.
				// 즉, 개발자가 따로 관리하지 않는 static 객체들이 알아서 DriverManager에 등록되는 것이다.
				// 그래서 Class.forName()을 호출하고 나서 어떤 인자로도 전달하지 않고 바로 getConnection()을 호출해도 드라이버가 찾아진다.
				
				// Driver Class를 로딩하면 객체가 생성되고, DriverManager에 등록된다.
				Class.forName("com.mysql.cj.jdbc.Driver");
				// connection으로 db와 연결 (객체 생성)
				conn = DriverManager.getConnection(url, user, pw);
				st = conn.createStatement();
				usePos = "use POS";
				st.executeUpdate(usePos);
				
				showProducts = "select * from products";
				rs = st.executeQuery(showProducts);

			} catch (ClassNotFoundException cnfe) {
				System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
			} catch (SQLException sqle) {
				System.out.println("DB 접속실패 : " + sqle.toString());
			} catch (Exception e) {
				System.out.println("Unkonwn error");
				e.printStackTrace();
			}
			
			setLayout(new GridLayout(4,1));
			JPanel ProductName = new JPanel();
			JPanel ProductPrice = new JPanel();
			JPanel ProductIndex = new JPanel();
			JPanel ProductNumber = new JPanel();
			MyName = new JTextField(20);
			MyNumber = new JTextField(20);
			MyPrice = new JTextField(20);
			MyStock = new JTextField(20);
			ProductName.add(new JLabel("이름"));
			ProductName.add(MyName);
			ProductNumber.add(new JLabel("번호"));
			ProductNumber.add(MyNumber);
			ProductPrice.add(new JLabel("가격"));
			ProductPrice.add(MyPrice);
			ProductIndex.add(new JLabel("재고"));
			ProductIndex.add(MyStock);
			
			add(ProductName);
			add(ProductNumber);
			add(ProductPrice);
			add(ProductIndex);
		}
	}
	
	
	class SelectButton extends JPanel
	{
		SelectButton(){
			setLayout(new GridLayout(1, 2));
			
			for(int i = 0; i < 2; i++) 
			{
				SBtn[i]= new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public ProductManagement_ProductRegister()
	{
		setTitle("재고 관리");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SelectButton sc = new SelectButton();

		// 입력창
		mbtn.setSize(700, 450);
		mbtn.setLocation(150, 20);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(300, 480);
		add(sc);
		// 저장
		SBtn[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				insertData(MyName.getText(), MyNumber.getText(), MyPrice.getText(), MyStock.getText());
				new POS_MainMenu();
			}
		});
		
		// 뒤로가기
		SBtn[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				new POS_ProductManagement();
			}
		});
	}
	
	public void insertData(String strName, String strNumber, String nPrice, String nStock) {
		try {
			String sql = "INSERT INTO products(strName, strNumber, nPrice, nStock) values(?, ?, ?, ?)";
			// PrparedStatment객체 생성, 인자로 sql문이 주어짐
			ps = conn.prepareStatement(sql);
			ps.setString(1, strName);
			ps.setString(2, strNumber);
			ps.setInt(3, Integer.parseInt(nPrice));
			ps.setInt(4, Integer.parseInt(nStock));
			// executeUpdate : insert, delete, update와 같이 값을 받아오지 않는 쿼리문 실행
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
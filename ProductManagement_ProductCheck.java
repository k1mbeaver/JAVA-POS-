import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class ProductManagement_ProductCheck extends JFrame 
{
	// Connection�� �����ͺ��̽��� �����ϴ� ��ü�̴�.
	Connection conn = null;
	// ResultSet : ������ �������� ���� �޴� ��ü
	ResultSet rs = null;
	Statement st = null; // �׳� �������°�
	// PreparedStatement�� �������� ?�� ����ؼ� �߰��� ?�� ������ �Ҵ��� �ټ� �ֵ��� �ϴ� ��ü
	PreparedStatement ps = null; // ?�־ ����ִ°�
	String usePos;
	String showProducts;
	JButton[] SBtn = new JButton[1];
	String[] Str = {"�ڷΰ���"};
	String [] ColName = {"�̸�","��ȣ","����", "���"};
	String [][] Data;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			try {
				String user = "root";
				String pw = "rlatmddnr48!";
				String url = "jdbc:mysql://127.0.0.1/?useSSL=false&user=root&password=rlatmddnr48!";

				// jdbc drive�� ����ϴ� ����
				// class.forName�� ȣ���ϸ� Driver�� �ڱ��ڽ��� �ʱ�ȭ�Ͽ� DriverManager�� ����Ѵ�.
				// ��, �����ڰ� ���� �������� �ʴ� static ��ü���� �˾Ƽ� DriverManager�� ��ϵǴ� ���̴�.
				// �׷��� Class.forName()�� ȣ���ϰ� ���� � ���ڷε� �������� �ʰ� �ٷ� getConnection()�� ȣ���ص� ����̹��� ã������.
				
				// Driver Class�� �ε��ϸ� ��ü�� �����ǰ�, DriverManager�� ��ϵȴ�.
				Class.forName("com.mysql.cj.jdbc.Driver");
				// connection���� db�� ���� (��ü ����)
				conn = DriverManager.getConnection(url, user, pw);
				st = conn.createStatement();
				usePos = "use POS";
				st.executeUpdate(usePos);
				
				showProducts = "select * from products";
				rs = st.executeQuery(showProducts);
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				table.setRowHeight(50);
				table.getTableHeader().setFont(new Font("�������", Font.BOLD, 15));
				add(new JScrollPane(table));
				while(rs.next())
				{
					m.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)});
				}

			} catch (ClassNotFoundException cnfe) {
				System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
			} catch (SQLException sqle) {
				System.out.println("DB ���ӽ��� : " + sqle.toString());
			} catch (Exception e) {
				System.out.println("Unkonwn error");
				e.printStackTrace();
			}
		}
	}
	
	class SubScreen extends JPanel
	{
		SubScreen()
		{
			setLayout(new GridLayout(3,1));
			JPanel ProductName = new JPanel();
			JPanel ProductNumber = new JPanel();
			JPanel ProductSearch = new JPanel();

			ProductName.add(new JLabel("�̸�"));
			ProductName.add(new JTextField(20));
			ProductNumber.add(new JLabel("��ȣ"));
			ProductNumber.add(new JTextField(20));
			ProductSearch.add(new JButton("�˻�"));
			
			add(ProductName);
			add(ProductNumber);
			add(ProductSearch);
		}
	}
	
	class SelectButton extends JPanel{
		SelectButton(){
			setLayout(new GridLayout());

			SBtn[0]= new JButton(Str[0]);
			add(SBtn[0]);

		}
	}
	
	public ProductManagement_ProductCheck() {
		setTitle("��� ����");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SubScreen sbtn = new SubScreen();
		SelectButton sc = new SelectButton();
		
		sbtn.setSize(500, 450);
		sbtn.setLocation(500, 30);
		add(sbtn);
		
		mbtn.setSize(500, 450);
		mbtn.setLocation(15, 0);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(300, 480);
		add(sc);
		// �ڷ� ����
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new POS_ProductManagement();
			}
		});

	}
}
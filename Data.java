public class Data {
	String strName; // 이름
	String strNumber; // 시리얼넘버
	int nPrice; // 가격
	int nStock; // 재고

	public Data()
	{
	}
    
	public Data(String strName, String strNumber, int nPrice, int nStock) 
	{
		this.strName = strName;
		this.strNumber = strNumber;
		this.nPrice = nPrice;
		this.nStock = nStock;
	}

	public String getstrName() 
	{
		return strName;
	}

	public void setstrName(String strName)
	{
		this.strName = strName;
	}

	public String getstrNumber()
	{
		return strNumber;
	}

	public void setstrNumber(String strNumber)
	{
		this.strNumber = strNumber;
	}
	
	public int getnPrice() 
	{
		return nPrice;
	}
	
	public void setnPrice(int nPrice)
	{
		this.nPrice = nPrice;
	}
	
	public int getnStock() 
	{
		return nStock;
	}
	
	public void setnStock(int nStock)
	{
		this.nStock = nStock;
	}
	
}
package lz77;

public class Tage {
	public int Pointer;
	public int Length;
	public char NextChar;
	
	
	Tage()
	{
		Pointer = 0;
		Length = 0;
		//NextChar = (Character) null;
	}
	public void CreateTage (int P,int L,char x)
	{
		Pointer = P;
		Length = L;
		NextChar = x;
	}
	public void ShowTages()
	{
		System.out.println("<" +Pointer + "," + Length + "," + NextChar + ">" );
	}

}

package lz77;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

public class main {
	public static ArrayList<Tage> compress(String d) {

		String tmp = "";
		ArrayList<Tage> TagesArray = new ArrayList<Tage>();
		@SuppressWarnings("unused")
		HashMap<String, Integer> DataAtMap = new HashMap<String, Integer>();
		for (int i = 0; i < d.length(); i++) {
			tmp += d.charAt(i);

			if (!DataAtMap.containsKey(tmp)) {
				String work = tmp.substring(0, tmp.length() - 1);
				// System.out.println("work " + work);
				int value = (DataAtMap.containsKey(work) ? DataAtMap.get(work)
						: -1);
				if (value == -1)

				{// - (tmp.length() - 1)
					// if (i>0)
					value = d.substring(0, i).lastIndexOf(work);

					if (value == -1)
						value = i;
				}

				 //System.out .println(i + " " + value + " " + tmp + " " +
				 //work + " =");

				Tage tag = new Tage();
				if (work.length() == 0)
					tag.CreateTage(0, 0, tmp.charAt(tmp.length() - 1));
				else
					tag.CreateTage(i  - value- work.length() , work.length(),
							tmp.charAt(tmp.length() - 1));

				DataAtMap.put(tmp, i - work.length());

				TagesArray.add(tag);

				tag.ShowTages();

				tmp = "";

			}

		}

		// for (int i = 0; i < TagesArray.size(); i++) {
		// TagesArray.get(i).ShowTages();
		//
		// }

		return TagesArray;

	}

	static String deCom(ArrayList<Tage> t) {
		String s = "";
		int num = 0;

		for (int i = 0; i < t.size(); i++) {
			num =s.length()-t.get(i).Pointer ;
			// System.out.println(s + " " + num+ " " +s.substring(num, num +
			// t.get(i).Length ) + t.get(i).NextChar);
			  System.out.println(i + " " +t.get(i).Pointer);
			 
				s += (s.substring(num,num+t.get(i).Length) + t.get(i).NextChar);

			 
			
			//System.out.println(s);

		}

		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App();
		/*Scanner read = null;
		String input = null;
		String data = "";

		try {
			read = new Scanner(new File("myfile.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (read.hasNext()) {
			input = read.nextLine();
			data += input + "\n";
		}
		ArrayList<Tage> k = compress(data);
		String n = deCom(k);

		System.out.println(data + n);*/

	}

}

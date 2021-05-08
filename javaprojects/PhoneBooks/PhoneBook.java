package PhoneBooks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
	private Map<String,Contacts> m;
	private String fileName ;

	public PhoneBook()
	{
		this.m=new TreeMap<String,Contacts>();
	}
	public PhoneBook(String fn)
	{
		this.m=new TreeMap<String,Contacts>();
		this.fileName=fn;

		try {
			BufferedReader br=new BufferedReader(new FileReader(fn));
			String got;
			try {
				while((got=br.readLine())!=null)
				{
					String sa[]=got.split(",");
					Contacts get=new Contacts(sa[0],sa[1],sa[2],sa[3]);
					this.m.put(sa[0], get);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return;
		}	
	}
	public void addContacts(Contacts person)
	{
		m.put(person.getName(), person);
	}
	public Contacts getContact(String s)
	{
		return m.get(s);
	}
	public void deleteContact(String s)
	{
		m.remove(s);
	}
	public String toString()
	{
		return m.toString();
	}
	public void save()
	{
		try 
		{
			BufferedWriter bw=new BufferedWriter(new FileWriter(this.fileName));
			Set<String>got=this.m.keySet();
			for(String name:got)
			{
				Contacts have=this.m.get(name);
				bw.write(have.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}

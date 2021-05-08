package Banking;

import java.util.HashMap;

public class Bank 
{
	private HashMap<String,Account>hm;
	
	public Bank()
	{
		hm=new HashMap<>();
	}
	
	public Account addAccount(Account ac)
	{
		Account got=this.hm.get(ac.getkey());
		if(got ==null)
		{
			System.out.println("account added");
			return this.hm.put(ac.getkey(), ac);
			
		}
		else
		{
			System.out.println("Already account exists");
			return null;
		}
	}
	public Account login(String id)
	{
		return this.hm.get(id);
	}
//	public void updatedata(String id,Account ac )
//	{
//		this.hm.replace(id, ac);
//	}

}

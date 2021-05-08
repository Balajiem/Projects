package Banking;

public class Account {
	private PersonalAc pc;
	private BusinessAc bc;
	
	public Account ( PersonalAc pcc,BusinessAc bcc)
	{
		if(!(pcc == null && bcc == null))
		{
			this.pc=pcc;
			this.bc=bcc;
		}
		else
		{
			System.out.println("null account cannot be created");
		}
		
	}
	public String getkey()
	{
		if(this.pc!= null)
		{
			return this.pc.getUsername();
		}
		else
		{
			return this.bc.getUsername();
		}
	}
	public AC getAC(String pass) 
	{
		if(this.pc != null && this.pc.getPassword().equals(pass))
		{
			return this.pc;
		}
		else if(this.bc.getPassword().equals(pass))
		{
			return this.bc;
		}
		return null;
	}
	public void updateAccount(String s,int amount)
	{
		
		if(this.pc != null && this.pc.getPassword().equals(s))
		{
			this.pc.updateAmount(amount);
		}
		else
		{
			this.bc.updateAmount(amount);
		}
	}

	public AC chooseAc(int n)
	{
		if(n==1)
		{
			return this.pc;
		}
		else if(n==2)
		{
			return this.bc;
		}
		else
		{
			return null;
		}
	}
	
}

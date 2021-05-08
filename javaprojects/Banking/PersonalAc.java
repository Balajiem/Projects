package Banking;

public class PersonalAc implements AC{

	private String username ;
	private String password ;
	private int Amount;

	public PersonalAc (String id,String ps,int rs)
	{
		this.username=id;
		this.password=ps;
		this.Amount=rs;
	}

	public String getUsername()
	{	
		return this.username;
	}

	public String getPassword()
	{	
		return this.password;
	}

	public int getAmount()
	{
		return this.Amount;
	}
	public String toString()
	{
		return this.username+" ,balance= "+this.Amount;
	}
	public  void welcomeUser()
	{
		System.out.println("welcome "+this.username+",");
	}
	public void updateAmount(int val)
	{
		this.Amount=this.Amount-val;
	}
	public void addMoney(int amount)
	{
		this.Amount+=amount;
	}
	public boolean isOverDraftEnabled()
	{
		return false;
	}
	public int dueAmount(int n)
	{
		return 0;
	}

}

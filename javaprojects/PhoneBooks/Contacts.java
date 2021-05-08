package PhoneBooks;

public class Contacts {
	private String name;
	private String number;
	private String mail;
	private String address;


	public  Contacts (String na,String nu,String m,String a)
	{
		this.name=na;
//		if(this.name==null)
//		{
//			throws null exceptions;
//		}
		this.number=nu;
		this.mail=m;
		this.address=a;
	}

	public String getName()
	{
		return this.name;
	}

	@Override
	public String toString()
	{
		return this.name+","+this.number+","+this.mail+","+this.address;
	}


}

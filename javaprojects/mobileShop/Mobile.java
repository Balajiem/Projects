package mobilehop;

public class Mobile implements Comparable<Mobile>
{
private String name;
private int price;
private int ram;

public Mobile(String n,int p,int sp)
{
	this.name=n;
	this.price=p;
	this.ram=sp;
}
@Override
public String toString()
{
	return this.name+","+this.price+","+this.ram+"gb";
}

@Override
public int compareTo(Mobile o) 
{
	// TODO Auto-generated method stub
	return this.name.compareTo(o.name);
}
@Override
public boolean equals(Object o)
{
	if(o==null)
	{
		return false;
	}
	if(!(o instanceof Mobile))
	{
		return false;
	}
	Mobile got=(Mobile)o;
	System.out.println("my function ");
	
	return this.name==got.name && this.price==got.price && this.ram==got.ram;
	
}
public int getPrice()
{
	return this.price;
}
public String getName()
{
	return this.name;
}
public int getRam()
{
	return this.ram;
}


}

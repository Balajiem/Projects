package mobilehop;

import java.util.Comparator;

public class PriceComp implements Comparator<Mobile>
{

	public int compare (Mobile o,Mobile o2) {
		// TODO Auto-generated method stub
		
		int res= o.getName().compareTo(o2.getName());
		if(res!=0)
		{
			return res;
		}
		return o.getPrice()-o2.getPrice();
	}

	

}

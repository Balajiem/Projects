package mobilehop;

import java.util.Comparator;

public class RamComp  implements Comparator<Mobile>
{

	@Override
	public int compare(Mobile o1, Mobile o2) {
		// TODO Auto-generated method stub
		int name=o1.getName().compareTo(o2.getName());


		if(name==0)
		{
			int price=o1.getPrice()-o2.getPrice();
			if(price==0)
			{
				return o1.getRam()-o2.getRam();
			}
			return price;
		}
		return name;

	}


}

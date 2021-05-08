package Banking;

public class AtmMachine {
	int n2000 ;
	int n500;
	int n200;
	int n100;

	public AtmMachine(int twothu,int fivehun,int twohun,int hun)
	{
		this.n2000=twothu;
		this.n500=fivehun;
		this.n200=twohun;
		this.n100=hun;
	}
	public int[] cashCalculation(int amount)
	{
		int _2ks = 0,_5hs=0,_2hs=0,huns=0,temp=amount;

		if(temp > 0)
		{
			_2ks=temp / 2000;
			temp=temp - _2ks * 2000;
			if(temp > 0)
			{
				_5hs=temp / 500;
				temp=temp -  _5hs * 500;
				if(temp > 0)
				{
					_2hs=temp / 200;
					temp=temp -  _2hs * 200;
					if(temp > 0)
					{
						huns=temp / 100;
						temp=temp -  huns * 100;
					}
				}
			}
		}
		int value=this.cashDispense(temp, _2ks, _5hs, _2hs, huns);
		int a[]=new int[2];
		if(value==1)
		{
			a[0]=amount;
			a[1]=1;
			return a;
		}
		else
		{
			a[0]=0;
			a[1]=-1;
			return a;
		}


	}

	public int cashDispense(int amount,int twok,int fivehun,int twohun,int hun)
	{

		if(this.n2000 >= twok && this.n500 >= fivehun && this.n200 >= twohun && this.n100 >= hun)
		{
			this.n2000=this.n2000 - twok ;
			this.n500=this.n500 - fivehun;
			this.n200=this.n200 - twohun ;
			this.n100=this.n100 - hun;
			System.out.println(twok+", two thousand rupees ,"+fivehun +",fivehundreed rupees ,"+twohun+",two hundread rupees ,"+hun+", hundread rupees");
			return 1;

		}
		else
		{
			System.out.println("unsufficient cash in machine");
			return -1;
		}
	}
}

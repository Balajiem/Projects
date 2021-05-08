package mobilehop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CellShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mobile m1=new Mobile("oneplus",28000,6);
		Mobile m2=new Mobile("pixel",38000,4);
		Mobile m3=new Mobile("iphone",68000,4);	
		Mobile m4=new Mobile("samsung",88000,12);	
		Mobile m5=new Mobile("mi",40000,8);
		Mobile m6=new Mobile("rog",48000,12);	
		Mobile m7=new Mobile("pixel",18000,6);
		Mobile[] mb= {m1,m2,m3,m4,m5,m6,m7};
		Arrays.sort(mb);
		for(Mobile a:mb)
		{
			System.out.println(a);
		}
		Mobile m8=new Mobile("samsung",16000,3);
		Mobile m9=new Mobile("mi",20000,4);
		Set<Mobile> s=new TreeSet<>();
		s.add(m1);
		s.add(m2);
		s.add(m3);
		s.add(m4);
		s.add(m5);
		s.add(m6);
		s.add(m7);
		s.add(m8);
		s.add(m9);
		System.out.println(s);
		System.out.println("price compare");
		PriceComp pc= new PriceComp();
		Mobile[] mb2= {m1,m2,m3,m4,m5,m6,m7,m8,m9};
		Arrays.sort(mb2,pc);
		for(Mobile a:mb2)
		{
			System.out.println(a);
		}

		RamComp rc=new RamComp();
		Mobile m10=new Mobile("oneplus",28000,8);
		Mobile m11=new Mobile("samsung",16000,6);
		Mobile m12=new Mobile("mi",20000,3);
		Mobile[] mb3= {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12};
		Arrays.sort(mb3,rc);
		System.out.println("ramCompare");
		for(Mobile a:mb3)
		{
			System.out.println(a);
		}
		int arr[]= {6,9,0,-1,4,21,6,4,2,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println("generic");
		Mobile[] mb4= {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12};
		System.out.println(Arrays.toString(mb4));
		sort(mb4);
		System.out.println(Arrays.toString(mb4));
		
		Mobile[] mb5= {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12};
		System.out.println(Arrays.toString(mb5));
		
		sort(mb5,rc);//it will use compartor of ramclass
		System.out.println(Arrays.toString(mb5));
		
		Mobile[] mb6= {m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12};
		System.out.println(Arrays.toString(mb5));
		
		sort(mb6);//it will use compare of mobile class
		System.out.println(Arrays.toString(mb6));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public static void sort(int a[])
	{
		int i=0;
		
		while(i<=a.length-1)
		{
			int small=i;
			int j=i+1;
			while(j<a.length)
			{
				if(a[j]<a[small])
				{
					small=j;
				}
				j++;
			}
			int temp=a[i];
			a[i]=a[small];
			a[small]=temp;
			i++;
		}
	}
	public static void sort(double a[])
	{
		int i=0;
		
		while(i<=a.length-1)
		{
			int small=i;
			int j=i+1;
			while(j<a.length)
			{
				if(a[j]<a[small])
				{
					small=j;
				}
				j++;
			}
			double temp=a[i];
			a[i]=a[small];
			a[small]=temp;
			i++;
		}
	}
	public static <T> void sort(T a[])
	{
		int i=0;
		
		while(i<=a.length-1)
		{
			int small=i;
			int j=i+1;
			while(j<a.length)
			{
				//if(a[j]<a[small])
				@SuppressWarnings("unchecked")
				Comparable<T> got=(Comparable<T>) a[j];
				if(got.compareTo(a[small])<0)
				{
					small=j;
				}
				j++;
			}
			T temp=a[i];
			a[i]=a[small];
			a[small]=temp;
			i++;
		}
	}
	public static <T> void sort(T a[],Comparator<T> comp)
	{
		int i=0;
		
		while(i<=a.length-1)
		{
			int small=i;
			int j=i+1;
			while(j<a.length)
			{
				//if(a[j]<a[small])
				if(comp.compare(a[j], a[small])<0)
				{
					small=j;
				}
				j++;
			}
			T temp=a[i];
			a[i]=a[small];
			a[small]=temp;
			i++;
		}
	}

}

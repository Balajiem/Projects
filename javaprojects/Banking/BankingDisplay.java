package Banking;

import java.util.Scanner;

public class BankingDisplay {
	static Scanner sc =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtmMachine atm= new AtmMachine(8000,4000,4000,4000);
		PersonalAc pc1= new PersonalAc("balaji","1196",10000);
		BusinessAc bc1= new BusinessAc(pc1.getUsername(),"1197",200000);
		Account ac1= new Account(pc1,bc1);
		Bank bnk=new Bank();
		bnk.addAccount(ac1);


		BusinessAc bc2= new BusinessAc("arjun","2190",30000);
		boolean j=bc2.enableOverDraft();
		System.out.println(j);
		Account ac2= new Account(null,bc2);
		bnk.addAccount(ac2);

		PersonalAc pc2= new PersonalAc("vivek","3356",40000);
		Account ac3= new Account(pc2,null);
		bnk.addAccount(ac3);

		PersonalAc pc3= new PersonalAc("muthu","1010",400000);
		Account ac4= new Account(pc3,null);
		bnk.addAccount(ac4);



		while(true)
		{
			System.out.println("please enter username");
			String usr=sc.next();
			System.out.println("enter 4 digit pin");
			String pass= sc.next();

			if(pass != null)
			{
				Account got=bnk.login(usr);
				if(got == null)
				{
					System.out.println("incorrect id or password");
					
				}
				else
				{
					AC have=got.getAC(pass);
					if(have == null)
					{
						System.out.println("incorrect id or password");
						
					}
					else
					{
						have.welcomeUser();
						boolean ans=have.isOverDraftEnabled();
						if(ans==true)
						{
							System.out.println("OverDraft enabled customer");

						}

						System.out.println("press 1. for balance.\npress 2.for withdrawl.\npress 3.for money transfer\n press 4 for logout ");
						int choice=sc.nextInt();
						switch(choice)
						{
						case 1:
							System.out.println(have.getAmount()+"rs,");
							break;
						case 2:
							System.out.println("enter the amount.amount must be mutiple of 100");
							int amount=sc.nextInt();
							int val=0;
							caseTwo(amount,ans,have,val,got,atm,pass);
							break;
						case 3:
							System.out.println("enter the recipient id");
							String secusr=sc.next();
							Account got1=bnk.login(secusr);
							BankingDisplay.caseThree(got1, have, got,pass);
							break;
						case 4 :
							System.out.println("account closed");
							break;
						default:
							System.out.println("invalid input");
							break;
						}
					}
				}
			}
		}
	}
	public static void caseTwo(int amount,Boolean ans,AC have,int val,Account got,AtmMachine atm,String pass)
	{
		if(amount%100==0) 
		{
			if(have.getAmount() >= amount || ans)
			{
				if(have.getAmount() >= amount || (ans && amount - have.getAmount() <= 50000))
				{
					if(have.getAmount()> amount)
					{
						val=1;
					}
					else if(have.getAmount() == amount)
					{
						System.out.println("your account balance will be is zero after this transaction\n"
								+"press 'yes' for transcation\n or press 'no' for cancel transaction");
						String chance=sc.next();
						val=1;

						if(chance.equals("yes")!=true)
						{
							System.out.println("transaction is cancelled");
						}
					}
					else if(ans && amount - have.getAmount() <= 50000)
					{
						System.out.println("your are overdraft enabled customer\nafter this transcation\n. Your account amoney will be neagative and additional charges for due amount ");
						val=1;
					}
				}
				else 
				{
					System.out.println("Limit excess overdraft allowance");
					return;
				}
			}
			else
			{
				System.out.println("insufficient funds in your account");
				return;
			}
		}
		else
		{
			System.out.println("requesting amount must be in multiplesof 100 only.sorry ");
			return;
		}
		if(val==1 )
		{
			int due=0;
			if(ans==true)
			{
				due=have.dueAmount(amount);
			}
			int balance[]=atm.cashCalculation(amount);
			got.updateAccount(pass, balance[0]);
			if(ans != true && balance[1]==1)
			{
				System.out.println("balance"+have.getAmount());
			}
			else if(ans == true && balance[1] == -1)
			{
				System.out.println("cash unavailable");
				return;
			}
			else if(balance[1]==1 && ans == true )
			{						
				if (due >0)
				{
					System.out.println(due +" due amount with 5percent interest , your balance "+have.getAmount());
				}
				else
				{
					System.out.println("balance "+have.getAmount());
				}
			}
			else if(balance[1]==-1 && ans == true )
			{
				System.out.println("sorry Overdraft cannot br used \n.because of unavilable of cash");
				return;
			}
		}
	}
	public static void caseThree(Account got1,AC have,Account got,String user)
	{
		if(got1==null)
		{
			System.out.println("no Account found on this username");
			return;
		}
		else
		{
			System.out.println("personal Accoun press 1\n.current account press 2");
			int had=sc.nextInt();
			AC i=got1.chooseAc(had);
			if(i==null)
			{
				if(had==1)
				{
					System.out.println("no personal Account found on this username.try again,sorry");
					return;
				}
				else
				{
					System.out.println("no current Account found on this username.try again,sorry");
					return;
				}
			}
			System.out.println("money transfering to "+i.getUsername());
			System.out.println("enter the amount to be transfered");
			int trnsfrmny=sc.nextInt();
			if( have.getAmount() >= trnsfrmny)
			{
				got.updateAccount(user, trnsfrmny);
				System.out.println("balance"+have.getAmount());
				i.addMoney(trnsfrmny);
				return;
			}
			else
			{
				System.out.println("insufficient funds in your account to transfer");
				return;
			}
		}
	}
}
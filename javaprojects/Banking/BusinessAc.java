package Banking;

public class BusinessAc  extends PersonalAc
{
	private boolean overDrafEnable;
	
	
	public BusinessAc(String id, String ps, int rs) {
		super(id, ps, rs);
		 this.overDrafEnable=false;
		
		 
		
	}
	public boolean isOverDraftEnabled()
	{
		return this.overDrafEnable;
	}
	public boolean enableOverDraft()
	{
		 this.overDrafEnable=true;
		 return this.overDrafEnable;
	}
	public int dueAmount(int n)
	{
		int got=this.getAmount();
		n=n-got;
		n+=(n*5)/100;
		return n;
		
		
	}

}

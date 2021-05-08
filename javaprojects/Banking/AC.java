package Banking;

public interface AC {

	public String getUsername();
	public String getPassword();
	public int getAmount();
	 public String toString();
	 public  void welcomeUser();
	 public void updateAmount(int val);
	 public void addMoney(int amount);
	 public boolean isOverDraftEnabled();
	 public int dueAmount(int n);
}

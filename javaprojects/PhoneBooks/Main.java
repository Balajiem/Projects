package PhoneBooks;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacts c=new Contacts("bala","7358263311","smbalaji03","tamabaram");		
		Contacts c1=new Contacts("arun","984063311","arun999","guindy");		
		Contacts c2=new Contacts("mahesh","7358791011","mahidhoni22","vadapalani");		
		Contacts c3=new Contacts("akash","6358265541","akash000","camproad");
	
		PhoneBook pb=new PhoneBook();
		pb.addContacts(c);
		pb.addContacts(c1);
		pb.addContacts(c2);
		pb.addContacts(c3);
		System.out.println(pb);
		
		PhoneBook pb1=new PhoneBook("pb.txt");
		System.out.println(pb);
		Contacts c4=new Contacts("abc","3456789","abc@","chennai");
		pb.addContacts(c4);
		pb.addContacts(c1);
		pb.addContacts(c2);
		pb.addContacts(c3);
		pb.deleteContact("arun");
		pb.save();
		
		
		

	}

}


public class Data{
	private static double[] balance = new double[0];
	private static String[] names   = new String[0]; 
	private static Account[] accounts = new Account[0];	
	private static String[][] listWants = new String[0][];
//	String name = "CENTRAL";
	
//	public static int compareWants(Account n) {
//		Wants holdList[] = n.getWants();
//		int count = 0;
//		
//		if (holdList.length == 0)
//			return 0;
//		
//		for (int i = 0; i < holdList.length; i++) {
//			for (int j = 0; j < listWants.length; j++) {
////				if 
//			}
//		}
//				
//	}
	
	public static int getLen() {
		return names.length;
	}
	
	public static String yuh() {
		return names[0];
	}
	
	public static Account[] getAcc() {
		return accounts;
	}
	
	public static Account getAcc(int ind) {
		return accounts[ind];
	}
	
	
	public static void replaceAccount(Account n, int ind) {
		accounts[ind] = n;
		balance[ind] = n.getBudget();
		listWants[ind] = n.getWants();
	}
	
	public static void updateStatics(Account n) {
		Account[] holdacc = new Account[accounts.length + 1]; 
		for (int i = 0; i < accounts.length; i++) {
			holdacc[i] = accounts[i];
		}
		holdacc[accounts.length] = n;
		accounts = holdacc.clone();
		
		double[] holdbal = new double[balance.length + 1];
		for (int i = 0; i < balance.length; i++) {
			holdbal[i] = balance[i];
		}
		holdbal[balance.length] = n.getTotal();
		balance = holdbal.clone();
		
		String[][] holdwan = new String[listWants.length + 1][];
		for (int i = 0; i < listWants.length; i++) {
			holdwan[i] = listWants[i];
		}
		
		holdwan[listWants.length] = n.getWants();
		listWants = holdwan.clone();
		
		String[] holdname = new String[names.length + 1];
		for (int i = 0; i < names.length; i++) {
			holdname[i] = names[i];
		}
		
		holdname[names.length] = n.getName();
		names = holdname.clone();
		
	}
	
	
	public void addBalance(Account acc, int money) {
		if (acc.verif == true){
			if (balance.length == 0) {    // When making the first account 
				balance = new double[1];
				balance[0] = money;
				return;
			}
			double[] holder = new double[balance.length + 1]; 
			for (int i = 0; i < balance.length; i++) {
				holder[i] = balance[i];
			}
			holder[holder.length-1] = money;
			balance = holder.clone();
			return;
		}
	}
	
	public static boolean nameIsRegistered(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name))
				return true;
		}
		return false;
	}
	
	public static int getInd(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name))
				return i;
		}
		
		return 0;
	}
	
//	public static int compNumInterests(Account n, int ind) {
//		int hold = 0; 
//		for (int i = 0; i < )
//	}
	
	public static boolean verifInd(int ind, String password) {
		if (accounts[ind].checkPassword(password))
			return true;
		return false;
	}
}

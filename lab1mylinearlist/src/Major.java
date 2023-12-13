public class Major{
	private String majorCode;
	private String majorName;
	
	public Major() {
		majorCode = null;
		majorName = null;
	}
	public Major(String ss) {
		String [] strval;
		strval = ss.split("/");
		majorCode = strval [0];
		majorName = strval [1];
	}
	public Major(Major mj) {
		majorCode = mj.majorCode;
		majorName = mj.majorName;
	}
	public void setCode(String sC) {
		majorCode = sC;
	}
	public void setName(String sN) {
		majorCode = sN;
	}
	public String getCode() {
		return majorCode;
	}
	public String getName() {
		return majorName;
	}
	public static void displayHead() {
		System.out.println("******mergejliin jagsaalt******");
	    System.out.printf("%-15s%-15s%n", "Major Code", "Major Name");
	}

	public void display() {
		String titletemp = "%-15s %-45s\n";
		System.out.printf(titletemp, majorCode,majorName );
	}
}
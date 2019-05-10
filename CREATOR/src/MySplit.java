
public class MySplit {
	public static void main(String[] args) {
		String a = "/01/0.jpg";
		String[] s = a.split("/");
		
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]);
		}
		
		System.out.println(s[s.length-1]);
	}
}

package java0115;

public class ExampleMain {

	public static void main(String[] args) {
		String findStr = "GCCMGCCGCCGSHDNGCCGKDIJ";
		int g = findStr.indexOf("G");
		int c = findStr.indexOf("C");
		int gccg = findStr.indexOf("GCCG");
		int len = findStr.length();
		//System.out.println(g);
		//System.out.println(c);
		//System.out.println(gccg);
		
		/*int len = findStr.length();
		System.out.println(len);
		for(int i = 0; i < len; i = i + 1) {
			System.out.print(g);
			System.out.print(c);
			System.out.print(gccg);
		}*/
		
		while (findStr.length() != 0) {
			for(int i = 0; i < len; i = i + 1) {
				System.out.println(i);
				System.out.print(g);
				System.out.print(c);
				System.out.print(gccg);
			}
			break;
		}

	}

}

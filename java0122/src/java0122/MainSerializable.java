package java0122;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainSerializable {

	public static void main(String[] args) {
		Unit unit = new Unit(1, "탱크", 10, 10, 1);
		System.out.println(unit);
		unit.setLevel(1);
		System.out.println(unit);
		System.out.println("=============================");
		
		// byte 나 char(String)이 아닌 데이터를 읽고 쓸 때는
		// ObjectOutputStream, ObjectInputStream 이용
		// PrintStream 바로 쓰면 에러남
		try(ObjectOutputStream oos =
				new ObjectOutputStream(
						new FileOutputStream("./star.dat"));
				
			ObjectInputStream ois = 
					new ObjectInputStream(
							new FileInputStream("./star.dat"));
			)
		{
			// 데이터 기록 : unit의 클래스인 Unit이
			// Serializable 인터페이스를 구현하지 않았다면
			// ClassCastException 발생(형 변환 안됐다고 예외 발생)
			// + PrintWriter은 unit 사용 불가
			// + print로도 unit은 toStrint()의 결과가 저장되므로 안 됨
			/*
			oos.writeObject(unit);
			
			Unit unit1 = new Unit(2, "마린", 5, 5, 0);
			oos.writeObject(unit1);
			
			// 데이터 읽어오기
			Unit unit2 = (Unit)ois.readObject();
			System.out.println(unit2);
			Unit unit3 = (Unit)ois.readObject();
			System.out.println(unit3);
			*/
			
			// 리스트로 모아 저장하면 과정을 생략할 수 있어 시간 절약됨
			Unit unit1 = new Unit(2, "마린", 5, 5, 0);
			ArrayList<Unit> list = new ArrayList<Unit>();
			list.add(unit);
			list.add(unit1);
			oos.writeObject(list);
			
			// List로 저장한 데이터 읽어오기
			ArrayList<Unit> read = (ArrayList<Unit>)ois.readObject();
			for (Unit u : read) {
				System.out.println(u);
			}
			
		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
			//예외 : java0122.Unit
		}

	}

}

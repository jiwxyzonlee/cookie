package composite;

public class File implements Entry {

	// 파일 이름을 저장할 변수
	private String name;
	
	public File(String name) {
		this.name = name;
	}

	@Override
	public void add(Entry entry) {
		System.err.println("파일에는 파일이나 디렉토리를 추가할 수 없습니다!!");

	}

	@Override
	public void remove() {
		System.out.println(name + "가 삭제되었습니다.");

	}

	@Override
	public void rename(String name) {
		this.name = name;

	}

}

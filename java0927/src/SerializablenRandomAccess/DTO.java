package SerializablenRandomAccess;

import java.io.Serializable;

//DTO(data Transfer Object)
	// 여러 개의 속성을 묶어서 표현하기 위한 클래스 
	// 다른 말로는 VO(Variable Object)라고도 합니다. 

public class DTO implements Serializable{

	private int num; 
	private String id; 
	private String pw; 
	private String name;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "DTO [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
}

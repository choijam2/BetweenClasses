import java.util.ArrayList;

public class Student extends User{
	
	private ArrayList<String> lid;
	private String dept;
	private String college;
	Student(String sid) {
		super(sid);
		lid = new ArrayList<String>();
	}
	public ArrayList<String> getLid() {		
		return this.lid;
	}
	public void addLid(String lid) {
		this.lid.add(lid);
	}
	public void delLid(String lid) {
		this.lid.remove(lid);
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void allDelLid() {
		this.lid.clear();
	}
}

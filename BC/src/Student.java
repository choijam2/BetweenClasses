
public class Student extends User{
	private int lid[] = new int[10];
	private String dept;
	private String college;
	public int[] getLid() {
		return lid;
	}
	public void setLid(int[] lid) {
		this.lid = lid;
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
}

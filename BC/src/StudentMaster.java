
public class StudentMaster extends Student{
	StudentMaster(String sid) {
		super(sid);
	}

	private boolean isMaster;

	public boolean isMaster() {
		return isMaster;
	}

	public void setMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}
	
}

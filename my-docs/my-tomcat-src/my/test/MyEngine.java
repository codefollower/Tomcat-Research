package my.test;

public class MyEngine extends org.apache.catalina.core.StandardEngine {
	private String hostConfigClass;

	public String getHostConfigClass() {
		return hostConfigClass;
	}

	public void setHostConfigClass(String hostConfigClass) {
		this.hostConfigClass = hostConfigClass;
	}
}

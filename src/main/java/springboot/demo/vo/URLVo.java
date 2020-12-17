package springboot.demo.vo;

public class URLVo {
	private String infoplusUrlBase;
	private String infoplusApiBase;

	public String getInfoplusUrlBase() {
		return this.infoplusUrlBase;
	}

	public void setInfoplusUrlBase(String infoplusUrlBase) {
		this.infoplusUrlBase = infoplusUrlBase;
	}

	public String getInfoplusApiBase() {
		return this.infoplusApiBase;
	}

	public void setInfoplusApiBase(String infoplusApiBase) {
		this.infoplusApiBase = infoplusApiBase;
	}

	public URLVo(String infoplusUrlBase, String infoplusApiBase) {
		this.infoplusUrlBase = infoplusUrlBase;
		this.infoplusApiBase = infoplusApiBase;
	}
}
package io.github.jmgloria07.toktive.web.objects;

public class ToktiveCallWeb {
	public enum Status {
		SUCCESS,
		FAIL,
		PARTIAL
	}
	
	private Status status;
	
	private String link;
	
	private String errorMessage;
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}

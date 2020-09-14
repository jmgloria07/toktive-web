package io.github.jmgloria07.toktive.web.objects;

import java.util.List;

public class ToktiveWebResponse {
	public enum Status {
		FAIL,
		PARTIAL,
		SUCCESS
	}
	private String post;
	private Status status;
	private int count;
	private List<ToktiveCallWeb> calls;
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<ToktiveCallWeb> getCalls() {
		return calls;
	}
	public void setCalls(List<ToktiveCallWeb> calls) {
		this.calls = calls;
	}
}

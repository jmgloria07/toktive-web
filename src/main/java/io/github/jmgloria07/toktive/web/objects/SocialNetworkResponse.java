package io.github.jmgloria07.toktive.web.objects;

public class SocialNetworkResponse {
	private String value;
	private String displayName;
	private boolean deprecated;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public boolean isDeprecated() {
		return deprecated;
	}
	public void setDeprecated(boolean deprecated) {
		this.deprecated = deprecated;
	}
}

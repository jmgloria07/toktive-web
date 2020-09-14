package io.github.jmgloria07.toktive.web.objects;

import java.util.List;

public class SocialNetworkResponse {
	
	private int count;
	private int deprecatedCount;
	private List<SocialNetworkWeb> socialNetworks;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getDeprecatedCount() {
		return deprecatedCount;
	}
	public void setDeprecatedCount(int deprecatedCount) {
		this.deprecatedCount = deprecatedCount;
	}
	public List<SocialNetworkWeb> getSocialNetworks() {
		return socialNetworks;
	}
	public void setSocialNetworks(List<SocialNetworkWeb> socialNetworks) {
		this.socialNetworks = socialNetworks;
	}
}

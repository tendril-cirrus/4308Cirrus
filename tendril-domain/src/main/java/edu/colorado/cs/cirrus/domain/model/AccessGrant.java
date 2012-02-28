package edu.colorado.cs.cirrus.domain.model;

import org.joda.time.DateTime;

public class AccessGrant {

	private String access_token;
	private String token_type;
	private long expires_in;
	private String refresh_token;
	private String route;
	private DateTime expirationDateTime;

	public AccessGrant() {
	}

	public AccessGrant(String access_token, String token_type, long expires_in,
			String refresh_token, String route) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.route = route;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
	
	public DateTime getExpirationDateTime() {
		return expirationDateTime;
	}

	public void setExpirationDateTime(DateTime expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}

	@Override
	public String toString() {
		return "AccessGrant [access_token=" + access_token + ", token_type="
				+ token_type + ", expires_in=" + expires_in
				+ ", refresh_token=" + refresh_token + ", route=" + route + "]";
	}

	
}

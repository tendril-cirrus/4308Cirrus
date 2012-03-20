package edu.colorado.cs.cirrus.android;

import edu.colorado.cs.cirrus.domain.model.TendrilErrorResponse;

public class TendrilException extends Exception {

	private TendrilErrorResponse response;
	
	public TendrilException() {
		// TODO Auto-generated constructor stub
	}

	public TendrilException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public TendrilException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public TendrilException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public TendrilException(String arg0, Throwable arg1,TendrilErrorResponse res) {
		super(arg0, arg1);
		setTendrilResponse(res);
	}
	
	public TendrilException(String arg0,TendrilErrorResponse res) {
		super(arg0);
		setTendrilResponse(res);
	}
	
	public TendrilException(Throwable arg1,TendrilErrorResponse res) {
		super(arg1);
		setTendrilResponse(res);
	}
	
	public TendrilException(TendrilErrorResponse res) {
		super();
		setTendrilResponse(res);
	}

	public TendrilErrorResponse getTendrilResponse() {
		return response;
	}

	public void setTendrilResponse(TendrilErrorResponse response) {
		this.response = response;
	}

}

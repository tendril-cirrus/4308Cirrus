package edu.colorado.cs.cirrus.android;

import java.util.concurrent.ExecutionException;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.web.client.HttpClientErrorException;

import edu.colorado.cs.cirrus.domain.model.TendrilErrorResponse;

public class TendrilException extends Exception {

	private TendrilErrorResponse response=new TendrilErrorResponse("Not Given","Not Given");
	
	public TendrilException(String arg0){
		super(arg0);
	}

	public TendrilException(Throwable arg0) {
		super(arg0);
		setExtraInfo(arg0);
	}

	public TendrilException(String arg0, Throwable arg1) {
		super(arg0,arg1);
		setExtraInfo(arg1);
	}
	
	public TendrilException(String arg0, Throwable arg1,TendrilErrorResponse res) {
		super(arg0,arg1);
		setExtraInfo(arg1);
		setTendrilResponse(res);
	}
	
	public TendrilException(String arg0,TendrilErrorResponse res) {
		super(arg0);
		setTendrilResponse(res);
	}
	
	public TendrilException(Throwable arg1,TendrilErrorResponse res) {
		super(arg1);
		setExtraInfo(arg1);
		setTendrilResponse(res);
	}
	
	public TendrilException(TendrilErrorResponse res) {
		setTendrilResponse(res);
	}

	public TendrilErrorResponse getTendrilResponse() {
		return response;
	}

	public void setTendrilResponse(TendrilErrorResponse response) {
		this.response = response;
	}
	
	private void setExtraInfo(Throwable e){
		if (e instanceof HttpClientErrorException) {
            String xml = ((HttpClientErrorException) e).getResponseBodyAsString();
            Serializer serializer = new Persister();
            try {
				setTendrilResponse(serializer.read(TendrilErrorResponse.class, xml));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        }
	}
	
	/*private Exception transformException(Exception e) {
        Exception toThrow = e;
        if (e instanceof HttpClientErrorException) {
            String xml = ((HttpClientErrorException) e).getResponseBodyAsString();
            Serializer serializer = new Persister();
            try {
                TendrilErrorResponse res = serializer.read(TendrilErrorResponse.class, xml);
                toThrow = new TendrilException(e, res);
            }
            catch (Exception r) {
                toThrow = new TendrilException(e);
            }
        }
        else if (e instanceof RuntimeException) {
            Exception tmp = (Exception) e.getCause();
            toThrow = transformException(tmp);
        }
        else if (e instanceof ExecutionException) {
            Exception tmp = (Exception) e.getCause();
            toThrow = transformException(tmp);
        }
        else if (e instanceof NullPointerException) {
            toThrow = new TendrilException(e);
        }
        return toThrow;
    }*/
}

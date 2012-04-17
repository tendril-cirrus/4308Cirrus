package edu.colorado.cs.cirrus.android;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

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
			TendrilErrorResponse r=new TendrilErrorResponse("Unknown Client Error (4xx error code)","None given");
			try {
				r=serializer.read(TendrilErrorResponse.class, xml);
			} catch (Exception e1) {
				//System.err.println(xml);
				e1.printStackTrace();
				if(xml!=null){
					r.setDetails(xml);
					r.setReason(xml);
				}
			}
			
			/*if(r.getDetails()==null || r.getDetails().isEmpty()){
				r.setDetails("Unknown Client Error (4xx error code)");
			}
			if(r.getReason()==null || r.getReason().isEmpty()){
				r.setDetails("None given");
			}*/
			setTendrilResponse(r);
		}else if(e instanceof HttpServerErrorException){
			String xml = ((HttpServerErrorException) e).getResponseBodyAsString();
			Serializer serializer = new Persister();
			TendrilErrorResponse r=new TendrilErrorResponse("Unknown Server Error (5xx error code)","None given");
			try {
				r=serializer.read(TendrilErrorResponse.class, xml);
			} catch (Exception e1) {
				//System.err.println(xml);
				e1.printStackTrace();
				if(xml!=null){
					r.setDetails(xml);
					r.setReason(xml);
				}
			}
			
			/*if(r.getDetails()==null || r.getDetails().isEmpty()){
				r.setDetails("Unknown Server Error (5xx error code)");
			}
			if(r.getReason()==null || r.getReason().isEmpty()){
				r.setDetails("None given");
			}*/
			setTendrilResponse(r);
		}
	}

	@Override
	public String toString() {
		return super.toString()+" [response=" + response + "]";
	}
}

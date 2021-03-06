package edu.colorado.cs.cirrus.android;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import edu.colorado.cs.cirrus.domain.TendrilException;
import edu.colorado.cs.cirrus.domain.model.TendrilErrorResponse;

public class TendrilAndroidException extends TendrilException {

    private int code = -1;

    public TendrilAndroidException(String arg0) {
        super(arg0);
    }

    public TendrilAndroidException(Throwable arg0) {
        super(arg0);
        setExtraInfo(arg0);
    }

    public TendrilAndroidException(String arg0, Throwable arg1) {
        super(arg0, arg1);
        setExtraInfo(arg1);
    }

    public TendrilAndroidException(String arg0, Throwable arg1, TendrilErrorResponse res) {
        super(arg0, arg1);
        setExtraInfo(arg1);
        setTendrilResponse(res);
    }

    public TendrilAndroidException(String arg0, TendrilErrorResponse res) {
        super(arg0);
        setTendrilResponse(res);
    }

    public TendrilAndroidException(Throwable arg1, TendrilErrorResponse res) {
        super(arg1);
        setExtraInfo(arg1);
        setTendrilResponse(res);
    }

    public int getStatusCode() {
        return code;
    }

    private void setExtraInfo(Throwable e) {
        if (e instanceof HttpClientErrorException) {
            String xml = ((HttpClientErrorException) e).getResponseBodyAsString();
            Serializer serializer = new Persister();
            TendrilErrorResponse r = new TendrilErrorResponse("Unknown Client Error (4xx error code)", "None given");
            try {
                r = serializer.read(TendrilErrorResponse.class, xml);
            }
            catch (Exception e1) {
                // System.err.println(xml);
                e1.printStackTrace();
                if (xml != null) {
                    r.setDetails(xml);
                    r.setReason(xml);
                }
            }

            code = ((HttpClientErrorException) e).getStatusCode().value();

            setTendrilResponse(r);
        }
        else if (e instanceof HttpServerErrorException) {
            String xml = ((HttpServerErrorException) e).getResponseBodyAsString();
            Serializer serializer = new Persister();
            TendrilErrorResponse r = new TendrilErrorResponse("Unknown Server Error (5xx error code)", "None given");
            try {
                r = serializer.read(TendrilErrorResponse.class, xml);
            }
            catch (Exception e1) {
                // System.err.println(xml);
                e1.printStackTrace();
                if (xml != null) {
                    r.setDetails(xml);
                    r.setReason(xml);
                }
            }

            code = ((HttpServerErrorException) e).getStatusCode().value();
            setTendrilResponse(r);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [response=" + response + "]";
    }

    public String getComprehensiveString() {
        return "Tendril Exception: \nCause=\"" + this.getCause().getClass().getName() + "\" \nCode=" + code
                + " \nReason=\"" + response.getReason() + "\" \nDetails=\"" + response.getDetails() + "\"";
    }
}

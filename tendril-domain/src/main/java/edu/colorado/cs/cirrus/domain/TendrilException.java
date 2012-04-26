package edu.colorado.cs.cirrus.domain;

import edu.colorado.cs.cirrus.domain.model.TendrilErrorResponse;

public class TendrilException extends Exception {

    protected TendrilErrorResponse response = new TendrilErrorResponse("Not Given", "Not Given");

    public TendrilException(String arg0) {
        super(arg0);
    }

    public TendrilException(Throwable arg0) {
        super(arg0);
    }

    public TendrilException(String arg0, Throwable arg1) {
        super(arg0, arg1);
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

}

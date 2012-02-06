package org.springframework.android.showcase.tendril;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class TendrilErrorHandler implements ResponseErrorHandler {

	public boolean hasError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	public void handleError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

}

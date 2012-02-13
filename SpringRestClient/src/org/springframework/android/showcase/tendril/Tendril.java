package org.springframework.android.showcase.tendril;

import java.util.concurrent.ExecutionException;

import org.joda.time.DateTime;
import org.springframework.social.ApiBinding;

/**
 * interface for specifying a set of operations for interacting with Tendril
 * implemented by {@link TendrilTemplate}
 * @author drichelson
 *
 */
public interface Tendril extends ApiBinding{
	String fetchUserInfo() throws InterruptedException, ExecutionException;
	String fetchPricingSchedule(DateTime start, DateTime end);
	String fetchDeviceList();
	

}

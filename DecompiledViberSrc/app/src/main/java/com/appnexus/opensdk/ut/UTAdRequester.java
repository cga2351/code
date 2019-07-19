package com.appnexus.opensdk.ut;

import com.appnexus.opensdk.AdResponse;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import java.util.LinkedList;

public abstract interface UTAdRequester
{
  public abstract void cancel();

  public abstract void continueWaterfall(ResultCode paramResultCode);

  public abstract void execute();

  public abstract void failed(ResultCode paramResultCode);

  public abstract LinkedList<BaseAdResponse> getAdList();

  public abstract long getLatency(long paramLong);

  public abstract UTRequestParameters getRequestParams();

  public abstract boolean isHttpsEnabled();

  public abstract void markLatencyStart();

  public abstract void onReceiveAd(AdResponse paramAdResponse);

  public abstract void onReceiveUTResponse(UTAdResponse paramUTAdResponse);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.UTAdRequester
 * JD-Core Version:    0.6.2
 */
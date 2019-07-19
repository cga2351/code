package com.appnexus.opensdk;

import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;

public abstract interface AdResponse
{
  public abstract void destroy();

  public abstract i getDisplayable();

  public abstract MediaType getMediaType();

  public abstract NativeAdResponse getNativeAdResponse();

  public abstract BaseAdResponse getResponseData();

  public abstract boolean isMediated();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.AdResponse
 * JD-Core Version:    0.6.2
 */
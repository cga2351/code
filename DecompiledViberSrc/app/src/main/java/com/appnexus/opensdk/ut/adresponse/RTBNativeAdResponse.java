package com.appnexus.opensdk.ut.adresponse;

import com.appnexus.opensdk.ANNativeAdResponse;
import java.util.ArrayList;

public class RTBNativeAdResponse extends BaseAdResponse
{
  private ANNativeAdResponse a;

  public RTBNativeAdResponse(int paramInt1, int paramInt2, String paramString1, ANNativeAdResponse paramANNativeAdResponse, ArrayList<String> paramArrayList, String paramString2)
  {
    super(paramInt1, paramInt2, paramString1, paramArrayList, paramString2);
    this.a = paramANNativeAdResponse;
  }

  public ANNativeAdResponse getNativeAdResponse()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.adresponse.RTBNativeAdResponse
 * JD-Core Version:    0.6.2
 */
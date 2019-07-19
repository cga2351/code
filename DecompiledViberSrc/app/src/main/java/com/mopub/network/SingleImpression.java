package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class SingleImpression
{
  private final String a;
  private final ImpressionData b;

  public SingleImpression(String paramString, ImpressionData paramImpressionData)
  {
    this.a = paramString;
    this.b = paramImpressionData;
  }

  public void sendImpression()
  {
    if (this.a != null)
    {
      ImpressionsEmitter.a(this.a, this.b);
      return;
    }
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "SingleImpression ad unit id may not be null." });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.SingleImpression
 * JD-Core Version:    0.6.2
 */
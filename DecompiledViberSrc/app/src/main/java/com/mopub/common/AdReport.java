package com.mopub.common;

import android.os.Build.VERSION;
import com.mopub.common.privacy.AdvertisingId;
import com.mopub.common.privacy.MoPubIdentifier;
import com.mopub.network.AdResponse;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AdReport
  implements Serializable
{
  private final AdResponse a;
  private final String b;
  private final String c;
  private final String d;
  private final Locale e;
  private final AdvertisingId f;

  public AdReport(String paramString, ClientMetadata paramClientMetadata, AdResponse paramAdResponse)
  {
    this.b = paramString;
    this.c = paramClientMetadata.getSdkVersion();
    this.d = paramClientMetadata.getDeviceModel();
    this.e = paramClientMetadata.getDeviceLocale();
    this.f = paramClientMetadata.getMoPubIdentifier().getAdvertisingInfo();
    this.a = paramAdResponse;
  }

  private String a(long paramLong)
  {
    if (paramLong != -1L)
      return new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(new Date(paramLong));
    return null;
  }

  private void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" : ");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append("\n");
  }

  public String getDspCreativeId()
  {
    return this.a.getDspCreativeId();
  }

  public String getResponseString()
  {
    return this.a.getStringBody();
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    a(localStringBuilder1, "sdk_version", this.c);
    a(localStringBuilder1, "creative_id", this.a.getDspCreativeId());
    a(localStringBuilder1, "platform_version", Integer.toString(Build.VERSION.SDK_INT));
    a(localStringBuilder1, "device_model", this.d);
    a(localStringBuilder1, "ad_unit_id", this.b);
    String str;
    Integer localInteger;
    StringBuilder localStringBuilder3;
    if (this.e == null)
    {
      str = null;
      a(localStringBuilder1, "device_locale", str);
      a(localStringBuilder1, "device_id", this.f.getIdentifier(MoPub.canCollectPersonalInformation()));
      a(localStringBuilder1, "network_type", this.a.getNetworkType());
      a(localStringBuilder1, "platform", "android");
      a(localStringBuilder1, "timestamp", a(this.a.getTimestamp()));
      a(localStringBuilder1, "ad_type", this.a.getAdType());
      Object localObject1 = this.a.getWidth();
      localInteger = this.a.getHeight();
      StringBuilder localStringBuilder2 = new StringBuilder().append("{");
      if (localObject1 == null)
        localObject1 = "0";
      localStringBuilder3 = localStringBuilder2.append(localObject1).append(", ");
      if (localInteger != null)
        break label255;
    }
    label255: for (Object localObject2 = "0"; ; localObject2 = localInteger)
    {
      a(localStringBuilder1, "ad_size", localObject2 + "}");
      return localStringBuilder1.toString();
      str = this.e.toString();
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.AdReport
 * JD-Core Version:    0.6.2
 */
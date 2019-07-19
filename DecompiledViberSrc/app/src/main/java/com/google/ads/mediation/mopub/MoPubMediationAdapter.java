package com.google.ads.mediation.mopub;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkConfiguration.Builder;
import java.util.Iterator;
import java.util.List;

public class MoPubMediationAdapter extends Adapter
{
  private String a = "";

  public VersionInfo getSDKVersionInfo()
  {
    String[] arrayOfString = "5.7.1".split("\\.");
    return new VersionInfo(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]), Integer.parseInt(arrayOfString[2]));
  }

  public VersionInfo getVersionInfo()
  {
    String[] arrayOfString = "5.4.1.2".split("\\.");
    return new VersionInfo(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]), 100 * Integer.parseInt(arrayOfString[2]) + Integer.parseInt(arrayOfString[3]));
  }

  public void initialize(Context paramContext, InitializationCompleteCallback paramInitializationCompleteCallback, List<MediationConfiguration> paramList)
  {
    if (!(paramContext instanceof Activity))
    {
      paramInitializationCompleteCallback.onInitializationFailed("MoPub SDK requires an Activity context to initialize.");
      return;
    }
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      this.a = ((MediationConfiguration)localIterator.next()).getServerParameters().getString("adUnitId");
    }
    while (TextUtils.isEmpty(this.a));
    if (TextUtils.isEmpty(this.a))
    {
      paramInitializationCompleteCallback.onInitializationFailed("Initialization failed: Missing or Invalid MoPub Ad Unit ID.");
      return;
    }
    SdkConfiguration localSdkConfiguration = new SdkConfiguration.Builder(this.a).build();
    b localb = b.a();
    paramInitializationCompleteCallback.getClass();
    localb.a(paramContext, localSdkConfiguration, a.a(paramInitializationCompleteCallback));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.mopub.MoPubMediationAdapter
 * JD-Core Version:    0.6.2
 */
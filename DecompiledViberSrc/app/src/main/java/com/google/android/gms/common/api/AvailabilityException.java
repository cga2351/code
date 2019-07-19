package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AvailabilityException extends Exception
{
  private final ArrayMap<zai<?>, ConnectionResult> zaay;

  public AvailabilityException(ArrayMap<zai<?>, ConnectionResult> paramArrayMap)
  {
    this.zaay = paramArrayMap;
  }

  public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> paramGoogleApi)
  {
    zai localzai = paramGoogleApi.zak();
    if (this.zaay.get(localzai) != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "The given API was not part of the availability request.");
      return (ConnectionResult)this.zaay.get(localzai);
    }
  }

  public String getMessage()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zaay.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      zai localzai = (zai)localIterator.next();
      ConnectionResult localConnectionResult = (ConnectionResult)this.zaay.get(localzai);
      if (localConnectionResult.isSuccess())
        i = 0;
      String str1 = localzai.zan();
      String str2 = String.valueOf(localConnectionResult);
      localArrayList.add(2 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + ": " + str2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (i != 0)
      localStringBuilder.append("None of the queried APIs are available. ");
    while (true)
    {
      localStringBuilder.append(TextUtils.join("; ", localArrayList));
      return localStringBuilder.toString();
      localStringBuilder.append("Some of the queried APIs are unavailable. ");
    }
  }

  public final ArrayMap<zai<?>, ConnectionResult> zaj()
  {
    return this.zaay;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.AvailabilityException
 * JD-Core Version:    0.6.2
 */
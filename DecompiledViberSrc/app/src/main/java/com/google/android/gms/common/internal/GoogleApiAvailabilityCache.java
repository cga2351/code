package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.Client;

public class GoogleApiAvailabilityCache
{
  private final SparseIntArray zaor = new SparseIntArray();
  private GoogleApiAvailabilityLight zaos;

  public GoogleApiAvailabilityCache()
  {
    this(GoogleApiAvailability.getInstance());
  }

  public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight)
  {
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight);
    this.zaos = paramGoogleApiAvailabilityLight;
  }

  public void flush()
  {
    this.zaor.clear();
  }

  public int getClientAvailability(Context paramContext, Api.Client paramClient)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramClient);
    if (!paramClient.requiresGooglePlayServices())
      return 0;
    int i = paramClient.getMinApkVersion();
    int j = this.zaor.get(i, -1);
    if (j != -1)
      return j;
    int k = 0;
    if (k < this.zaor.size())
    {
      int n = this.zaor.keyAt(k);
      if ((n <= i) || (this.zaor.get(n) != 0));
    }
    for (int m = 0; ; m = j)
    {
      if (m == -1)
        m = this.zaos.isGooglePlayServicesAvailable(paramContext, i);
      this.zaor.put(i, m);
      return m;
      k++;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.GoogleApiAvailabilityCache
 * JD-Core Version:    0.6.2
 */
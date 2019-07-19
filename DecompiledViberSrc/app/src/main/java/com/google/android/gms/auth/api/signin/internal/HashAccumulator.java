package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

public class HashAccumulator
{

  @VisibleForTesting
  private static int zaah = 31;
  private int zaai = 1;

  @KeepForSdk
  public HashAccumulator addObject(Object paramObject)
  {
    int i = zaah * this.zaai;
    if (paramObject == null);
    for (int j = 0; ; j = paramObject.hashCode())
    {
      this.zaai = (j + i);
      return this;
    }
  }

  @KeepForSdk
  public int hash()
  {
    return this.zaai;
  }

  public final HashAccumulator zaa(boolean paramBoolean)
  {
    int i = zaah * this.zaai;
    if (paramBoolean);
    for (int j = 1; ; j = 0)
    {
      this.zaai = (j + i);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.HashAccumulator
 * JD-Core Version:    0.6.2
 */
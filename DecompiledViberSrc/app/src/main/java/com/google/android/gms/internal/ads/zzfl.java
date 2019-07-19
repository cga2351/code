package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfl<T>
{
  private final Map<String, AtomicReference<T>> zzaac = new HashMap();

  public final AtomicReference<T> zzar(String paramString)
  {
    try
    {
      if (!this.zzaac.containsKey(paramString))
      {
        AtomicReference localAtomicReference = new AtomicReference();
        this.zzaac.put(paramString, localAtomicReference);
      }
      return (AtomicReference)this.zzaac.get(paramString);
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfl
 * JD-Core Version:    0.6.2
 */
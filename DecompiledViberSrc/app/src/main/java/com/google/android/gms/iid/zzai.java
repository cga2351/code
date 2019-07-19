package com.google.android.gms.iid;

import javax.annotation.concurrent.GuardedBy;

public abstract class zzai
{

  @GuardedBy("SdkFlagFactory.class")
  private static zzai zzdd;

  public static zzai zzy()
  {
    try
    {
      if (zzdd == null)
        zzdd = new zzac();
      zzai localzzai = zzdd;
      return localzzai;
    }
    finally
    {
    }
  }

  public abstract zzaj<Boolean> zzd(String paramString, boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzai
 * JD-Core Version:    0.6.2
 */
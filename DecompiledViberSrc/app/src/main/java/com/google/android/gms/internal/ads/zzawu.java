package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzawu
{

  @GuardedBy("this")
  private String zzdlq = "0";

  @GuardedBy("this")
  private BigInteger zzdup = BigInteger.ONE;

  public final String zzvg()
  {
    try
    {
      String str = this.zzdup.toString();
      this.zzdup = this.zzdup.add(BigInteger.ONE);
      this.zzdlq = str;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String zzvh()
  {
    try
    {
      String str = this.zzdlq;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawu
 * JD-Core Version:    0.6.2
 */
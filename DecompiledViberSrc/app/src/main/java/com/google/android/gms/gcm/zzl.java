package com.google.android.gms.gcm;

import android.os.Bundle;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzl
{
  public static final zzl zzaq = new zzl(0, 30, 3600);
  private static final zzl zzar = new zzl(1, 30, 3600);
  private final int zzas;
  private final int zzat;
  private final int zzau;

  private zzl(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzas = paramInt1;
    this.zzat = 30;
    this.zzau = 3600;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzl localzzl;
    do
    {
      return true;
      if (!(paramObject instanceof zzl))
        return false;
      localzzl = (zzl)paramObject;
    }
    while ((localzzl.zzas == this.zzas) && (localzzl.zzat == this.zzat) && (localzzl.zzau == this.zzau));
    return false;
  }

  public final int hashCode()
  {
    return 1000003 * (1000003 * (0xF4243 ^ 1 + this.zzas) ^ this.zzat) ^ this.zzau;
  }

  public final String toString()
  {
    int i = this.zzas;
    int j = this.zzat;
    int k = this.zzau;
    return 74 + "policy=" + i + " initial_backoff=" + j + " maximum_backoff=" + k;
  }

  public final Bundle zzf(Bundle paramBundle)
  {
    paramBundle.putInt("retry_policy", this.zzas);
    paramBundle.putInt("initial_backoff_seconds", this.zzat);
    paramBundle.putInt("maximum_backoff_seconds", this.zzau);
    return paramBundle;
  }

  public final int zzi()
  {
    return this.zzas;
  }

  public final int zzj()
  {
    return this.zzat;
  }

  public final int zzk()
  {
    return this.zzau;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.zzl
 * JD-Core Version:    0.6.2
 */
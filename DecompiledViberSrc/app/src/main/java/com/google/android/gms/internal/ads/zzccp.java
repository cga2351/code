package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;

final class zzccp
  implements zzo, zzu, zzagu, zzagw, zzxp
{
  private zzxp zzcgj;
  private zzagu zzczo;
  private zzagw zzczp;
  private zzo zzdko;
  private zzu zzdks;

  private final void zza(zzxp paramzzxp, zzagu paramzzagu, zzo paramzzo, zzagw paramzzagw, zzu paramzzu)
  {
    try
    {
      this.zzcgj = paramzzxp;
      this.zzczo = paramzzagu;
      this.zzdko = paramzzo;
      this.zzczp = paramzzagw;
      this.zzdks = paramzzu;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAdClicked()
  {
    try
    {
      if (this.zzcgj != null)
        this.zzcgj.onAdClicked();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAppEvent(String paramString1, String paramString2)
  {
    try
    {
      if (this.zzczp != null)
        this.zzczp.onAppEvent(paramString1, paramString2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onPause()
  {
    try
    {
      if (this.zzdko != null)
        this.zzdko.onPause();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onResume()
  {
    try
    {
      if (this.zzdko != null)
        this.zzdko.onResume();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(String paramString, Bundle paramBundle)
  {
    try
    {
      if (this.zzczo != null)
        this.zzczo.zza(paramString, paramBundle);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzsz()
  {
    try
    {
      if (this.zzdko != null)
        this.zzdko.zzsz();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzta()
  {
    try
    {
      if (this.zzdko != null)
        this.zzdko.zzta();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zztq()
  {
    try
    {
      if (this.zzdks != null)
        this.zzdks.zztq();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzccp
 * JD-Core Version:    0.6.2
 */
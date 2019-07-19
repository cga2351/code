package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import javax.annotation.concurrent.GuardedBy;

public final class zzcoy
  implements zzf
{

  @GuardedBy("this")
  private zzf zzgdd;

  public final void zza(zzf paramzzf)
  {
    try
    {
      this.zzgdd = paramzzf;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzg(View paramView)
  {
    try
    {
      if (this.zzgdd != null)
        this.zzgdd.zzg(paramView);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzky()
  {
    try
    {
      if (this.zzgdd != null)
        this.zzgdd.zzky();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzkz()
  {
    try
    {
      if (this.zzgdd != null)
        this.zzgdd.zzkz();
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzcoy
 * JD-Core Version:    0.6.2
 */
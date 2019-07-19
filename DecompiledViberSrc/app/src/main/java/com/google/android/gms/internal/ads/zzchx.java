package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;

public final class zzchx extends zzart
{
  protected zzchx(zzchw paramzzchw)
  {
  }

  public final void zza(zzayn paramzzayn)
  {
    this.zzfxj.zzddx.setException(new zzayo(paramzzayn.zzdwx, paramzzayn.errorCode));
  }

  public final void zzb(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.zzfxj.zzddx.set(new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzchx
 * JD-Core Version:    0.6.2
 */
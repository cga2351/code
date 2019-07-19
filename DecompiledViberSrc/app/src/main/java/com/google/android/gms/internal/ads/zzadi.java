package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzadi extends zzadl
{
  private final zzf zzcxu;
  private final String zzcxv;
  private final String zzcxw;

  public zzadi(zzf paramzzf, String paramString1, String paramString2)
  {
    this.zzcxu = paramzzf;
    this.zzcxv = paramString1;
    this.zzcxw = paramString2;
  }

  public final String getContent()
  {
    return this.zzcxw;
  }

  public final void recordClick()
  {
    this.zzcxu.zzky();
  }

  public final void recordImpression()
  {
    this.zzcxu.zzkz();
  }

  public final void zzo(IObjectWrapper paramIObjectWrapper)
  {
    if (paramIObjectWrapper == null)
      return;
    this.zzcxu.zzg((View)ObjectWrapper.unwrap(paramIObjectWrapper));
  }

  public final String zzqz()
  {
    return this.zzcxv;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadi
 * JD-Core Version:    0.6.2
 */
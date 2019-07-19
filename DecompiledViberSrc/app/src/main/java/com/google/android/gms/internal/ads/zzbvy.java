package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;

public class zzbvy
{
  private final zzbha zzdbu;
  private final zzbwy zzflm;

  public zzbvy(zzbwy paramzzbwy)
  {
    this(paramzzbwy, null);
  }

  public zzbvy(zzbwy paramzzbwy, zzbha paramzzbha)
  {
    this.zzflm = paramzzbwy;
    this.zzdbu = paramzzbha;
  }

  public Set<zzbuy<zzbrk>> zza(zzbxb paramzzbxb)
  {
    return Collections.singleton(zzbuy.zzb(paramzzbxb, zzbbn.zzeah));
  }

  public final zzbha zzafn()
  {
    return this.zzdbu;
  }

  public final zzbwy zzaha()
  {
    return this.zzflm;
  }

  public final View zzahb()
  {
    if (this.zzdbu == null)
      return null;
    return this.zzdbu.getWebView();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbvy
 * JD-Core Version:    0.6.2
 */
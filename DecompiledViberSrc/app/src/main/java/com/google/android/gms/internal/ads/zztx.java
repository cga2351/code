package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zztx
{
  private final Object lock = new Object();
  private final WeakHashMap<Object, Object> zzbtb = new WeakHashMap();
  private final ArrayList<Object> zzbtc = new ArrayList();
  private final zzbaj zzbtd;
  private final zzaki zzbte;
  private final Context zzys;

  public zztx(Context paramContext, zzbaj paramzzbaj)
  {
    this.zzys = paramContext.getApplicationContext();
    this.zzbtd = paramzzbaj;
    Context localContext = paramContext.getApplicationContext();
    zzaci localzzaci = zzact.zzckx;
    this.zzbte = new zzaki(localContext, paramzzbaj, (String)zzyr.zzpe().zzd(localzzaci));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zztx
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzcz
{
  boolean zzadg = true;
  String zzadi;
  String zzapk;
  String zzapl;
  Boolean zzaqe;
  zzan zzaqz;
  final Context zzri;

  @VisibleForTesting
  public zzcz(Context paramContext, zzan paramzzan)
  {
    Preconditions.checkNotNull(paramContext);
    Context localContext = paramContext.getApplicationContext();
    Preconditions.checkNotNull(localContext);
    this.zzri = localContext;
    if (paramzzan != null)
    {
      this.zzaqz = paramzzan;
      this.zzadi = paramzzan.zzadi;
      this.zzapk = paramzzan.origin;
      this.zzapl = paramzzan.zzadh;
      this.zzadg = paramzzan.zzadg;
      if (paramzzan.zzadj != null)
        this.zzaqe = Boolean.valueOf(paramzzan.zzadj.getBoolean("dataCollectionDefaultEnabled", true));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzcz
 * JD-Core Version:    0.6.2
 */
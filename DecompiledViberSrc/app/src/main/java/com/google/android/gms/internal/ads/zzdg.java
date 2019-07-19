package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzdg extends zzdf
{
  private zzdg(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(paramContext, paramString, paramBoolean);
  }

  public static zzdg zza(String paramString, Context paramContext, boolean paramBoolean)
  {
    zza(paramContext, paramBoolean);
    return new zzdg(paramContext, paramString, paramBoolean);
  }

  protected final List<Callable<Void>> zzb(zzdy paramzzdy, Context paramContext, zzbp.zza.zza paramzza, zzbk.zza paramzza1)
  {
    if ((paramzzdy.zzch() == null) || (!this.zzwf))
      return super.zzb(paramzzdy, paramContext, paramzza, paramzza1);
    int i = paramzzdy.zzcd();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(super.zzb(paramzzdy, paramContext, paramzza, paramzza1));
    localArrayList.add(new zzes(paramzzdy, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", paramzza, i, 24));
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdg
 * JD-Core Version:    0.6.2
 */
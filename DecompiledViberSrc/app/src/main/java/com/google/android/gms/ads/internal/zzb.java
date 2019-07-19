package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzarl;
import com.google.android.gms.internal.ads.zzauz;
import com.google.android.gms.internal.ads.zzavc;
import com.google.android.gms.internal.ads.zzaxj;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzb
{
  private boolean zzbqw;
  private zzavc zzbqx;
  private zzarl zzbqy;
  private final Context zzlj;

  public zzb(Context paramContext, zzavc paramzzavc, zzarl paramzzarl)
  {
    this.zzlj = paramContext;
    this.zzbqx = paramzzavc;
    this.zzbqy = null;
    if (this.zzbqy == null)
      this.zzbqy = new zzarl();
  }

  private final boolean zzkw()
  {
    return ((this.zzbqx != null) && (this.zzbqx.zzuc().zzdry)) || (this.zzbqy.zzdoo);
  }

  public final void recordClick()
  {
    this.zzbqw = true;
  }

  public final void zzbk(String paramString)
  {
    if (!zzkw());
    while (true)
    {
      return;
      if (paramString != null);
      while (this.zzbqx != null)
      {
        this.zzbqx.zza(paramString, null, 3);
        return;
        paramString = "";
      }
      if ((this.zzbqy.zzdoo) && (this.zzbqy.zzdop != null))
      {
        Iterator localIterator = this.zzbqy.zzdop.iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = str1.replace("{NAVIGATION_URL}", Uri.encode(paramString));
            zzk.zzlg();
            zzaxj.zzb(this.zzlj, "", str2);
          }
        }
      }
    }
  }

  public final boolean zzkx()
  {
    return (!zzkw()) || (this.zzbqw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.zzb
 * JD-Core Version:    0.6.2
 */
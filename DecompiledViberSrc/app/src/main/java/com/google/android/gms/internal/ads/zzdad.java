package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public final class zzdad
{
  private final Clock zzbsb;
  private final String zzbsy;
  private final String zzcih;
  private final String zzdlq;
  private final Executor zzfiv;
  private final zzcmt zzfkx;
  private final zzbai zzgnr;
  private final Context zzlj;

  public zzdad(Executor paramExecutor, zzbai paramzzbai, zzcmt paramzzcmt, zzbaj paramzzbaj, String paramString1, String paramString2, Context paramContext, Clock paramClock)
  {
    this.zzfiv = paramExecutor;
    this.zzgnr = paramzzbai;
    this.zzfkx = paramzzcmt;
    this.zzbsy = paramzzbaj.zzbsy;
    this.zzdlq = paramString1;
    this.zzcih = paramString2;
    this.zzlj = paramContext;
    this.zzbsb = paramClock;
  }

  private static String zzc(String paramString1, String paramString2, @Nullable String paramString3)
  {
    if (TextUtils.isEmpty(paramString3))
      paramString3 = "";
    return paramString1.replaceAll(paramString2, paramString3);
  }

  @Nullable
  private static String zzfz(@Nullable String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (zzazy.isEnabled()))
      paramString = "fakeForAdDebugLog";
    return paramString;
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, List<String> paramList)
  {
    zza(paramzzcxt, paramzzcxl, false, paramList);
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, List<String> paramList, zzass paramzzass)
  {
    long l = this.zzbsb.currentTimeMillis();
    try
    {
      String str1 = paramzzass.getType();
      String str2 = Integer.toString(paramzzass.getAmount());
      ArrayList localArrayList = new ArrayList();
      String str3 = zzfz(paramzzcxt.zzgkx.zzfjp.zzgle);
      String str4 = zzfz(paramzzcxt.zzgkx.zzfjp.zzglf);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(zzavy.zzd(zzc(zzc(zzc(zzc(zzc(zzc((String)localIterator.next(), "@gw_rwd_userid@", Uri.encode(str3)), "@gw_rwd_custom_data@", Uri.encode(str4)), "@gw_tmstmp@", Long.toString(l)), "@gw_rwd_itm@", Uri.encode(str1)), "@gw_rwd_amt@", str2), "@gw_sdkver@", this.zzbsy), this.zzlj, paramzzcxl.zzdom));
      zzh(localArrayList);
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public final void zza(zzcxt paramzzcxt, @Nullable zzcxl paramzzcxl, boolean paramBoolean, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean);
    for (String str1 = "1"; ; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = zzc(zzc(zzc((String)localIterator.next(), "@gw_adlocid@", paramzzcxt.zzgkx.zzfjp.zzglb), "@gw_adnetrefresh@", str1), "@gw_sdkver@", this.zzbsy);
        if (paramzzcxl != null)
          str2 = zzavy.zzd(zzc(zzc(zzc(str2, "@gw_qdata@", paramzzcxl.zzdfm), "@gw_adnetid@", paramzzcxl.zzatl), "@gw_allocid@", paramzzcxl.zzdel), this.zzlj, paramzzcxl.zzdom);
        localArrayList.add(zzc(zzc(zzc(str2, "@gw_adnetstatus@", this.zzfkx.zzaku()), "@gw_seqnum@", this.zzdlq), "@gw_sessid@", this.zzcih));
      }
    }
    zzh(localArrayList);
  }

  public final void zzed(String paramString)
  {
    this.zzfiv.execute(new zzdae(this, paramString));
  }

  public final void zzh(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      zzed((String)localIterator.next());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdad
 * JD-Core Version:    0.6.2
 */
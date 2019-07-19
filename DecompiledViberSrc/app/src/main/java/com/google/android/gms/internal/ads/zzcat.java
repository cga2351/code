package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcat
{
  private final zzbaj zzbtd;
  private final zzadx zzdgu;
  private final zzwh zzejf;
  private final zzdh zzekq;
  private final Executor zzfiv;
  private final ScheduledExecutorService zzfiw;
  private final zzcam zzfrl;
  private final zza zzfrm;
  private final zzcbh zzfrn;
  private final Context zzlj;

  public zzcat(Context paramContext, zzcam paramzzcam, zzdh paramzzdh, zzbaj paramzzbaj, zza paramzza, zzwh paramzzwh, Executor paramExecutor, zzcxu paramzzcxu, zzcbh paramzzcbh, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzlj = paramContext;
    this.zzfrl = paramzzcam;
    this.zzekq = paramzzdh;
    this.zzbtd = paramzzbaj;
    this.zzfrm = paramzza;
    this.zzejf = paramzzwh;
    this.zzfiv = paramExecutor;
    this.zzdgu = paramzzcxu.zzdgu;
    this.zzfrn = paramzzcbh;
    this.zzfiw = paramScheduledExecutorService;
  }

  private static <T> zzbbi<T> zza(zzbbi<T> paramzzbbi, T paramT)
  {
    return zzbas.zza(paramzzbbi, Exception.class, new zzcay(null), zzbbn.zzeah);
  }

  private final zzbbi<List<zzadv>> zza(JSONArray paramJSONArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0))
      return zzbas.zzm(Collections.emptyList());
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean2);
    for (int i = paramJSONArray.length(); ; i = 1)
      for (int j = 0; j < i; j++)
        localArrayList.add(zza(paramJSONArray.optJSONObject(j), paramBoolean1));
    return zzbas.zza(zzbas.zze(localArrayList), zzcau.zzdrp, this.zzfiv);
  }

  private final zzbbi<zzadv> zza(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null)
      return zzbas.zzm(null);
    String str = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(str))
      return zzbas.zzm(null);
    double d = paramJSONObject.optDouble("scale", 1.0D);
    boolean bool = paramJSONObject.optBoolean("is_transparent", true);
    int i = paramJSONObject.optInt("width", -1);
    int j = paramJSONObject.optInt("height", -1);
    if (paramBoolean)
      return zzbas.zzm(new zzadv(null, Uri.parse(str), d, i, j));
    zzbbi localzzbbi = zzbas.zza(this.zzfrl.zza(str, d, bool), new zzcav(str, d, i, j), this.zzfiv);
    return zza(paramJSONObject.optBoolean("require"), localzzbbi, null);
  }

  private static <T> zzbbi<T> zza(boolean paramBoolean, zzbbi<T> paramzzbbi, T paramT)
  {
    if (paramBoolean)
      return zzbas.zza(paramzzbbi, new zzcaz(paramzzbbi), zzbbn.zzeah);
    return zza(paramzzbbi, null);
  }

  private static Integer zzf(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
      Integer localInteger = Integer.valueOf(Color.rgb(localJSONObject.getInt("r"), localJSONObject.getInt("g"), localJSONObject.getInt("b")));
      return localInteger;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static List<zzabi> zzi(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("mute");
    if (localJSONObject == null)
      return Collections.emptyList();
    JSONArray localJSONArray = localJSONObject.optJSONArray("reasons");
    if ((localJSONArray == null) || (localJSONArray.length() <= 0))
      return Collections.emptyList();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < localJSONArray.length(); i++)
    {
      zzabi localzzabi = zzk(localJSONArray.optJSONObject(i));
      if (localzzabi != null)
        localArrayList.add(localzzabi);
    }
    return localArrayList;
  }

  public static zzabi zzj(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("mute");
    if (localJSONObject1 == null);
    JSONObject localJSONObject2;
    do
    {
      return null;
      localJSONObject2 = localJSONObject1.optJSONObject("default_reason");
    }
    while (localJSONObject2 == null);
    return zzk(localJSONObject2);
  }

  private static zzabi zzk(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null);
    String str1;
    String str2;
    do
    {
      return null;
      str1 = paramJSONObject.optString("reason");
      str2 = paramJSONObject.optString("ping_url");
    }
    while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    return new zzabi(str1, str2);
  }

  public final zzbbi<zzadv> zzc(JSONObject paramJSONObject, String paramString)
  {
    return zza(paramJSONObject.optJSONObject(paramString), this.zzdgu.zzcym);
  }

  public final zzbbi<List<zzadv>> zzd(JSONObject paramJSONObject, String paramString)
  {
    return zza(paramJSONObject.optJSONArray(paramString), this.zzdgu.zzcym, this.zzdgu.zzbqe);
  }

  public final zzbbi<zzads> zze(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject(paramString);
    if (localJSONObject1 == null)
      return zzbas.zzm(null);
    JSONArray localJSONArray = localJSONObject1.optJSONArray("images");
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("image");
    if ((localJSONArray == null) && (localJSONObject2 != null))
    {
      localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject2);
    }
    zzbbi localzzbbi = zzbas.zza(zza(localJSONArray, false, true), new zzcaw(this, localJSONObject1), this.zzfiv);
    return zza(localJSONObject1.optBoolean("require"), localzzbbi, null);
  }

  public final zzbbi<zzbha> zzl(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = zzazd.zza(paramJSONObject, new String[] { "html_containers", "instream" });
    if (localJSONObject1 == null)
    {
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("video");
      if (localJSONObject2 == null)
        return zzbas.zzm(null);
      if (TextUtils.isEmpty(localJSONObject2.optString("vast_xml")))
      {
        zzaxa.zzep("Required field 'vast_xml' is missing");
        return zzbas.zzm(null);
      }
      zzbbi localzzbbi2 = this.zzfrn.zzm(localJSONObject2);
      zzaci localzzaci = zzact.zzcsf;
      return zza(zzbas.zza(localzzbbi2, ((Integer)zzyr.zzpe().zzd(localzzaci)).intValue(), TimeUnit.SECONDS, this.zzfiw), null);
    }
    zzbbi localzzbbi1 = this.zzfrn.zzq(localJSONObject1.optString("base_url"), localJSONObject1.optString("html"));
    return zza(localJSONObject1.optBoolean("require"), localzzbbi1, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcat
 * JD-Core Version:    0.6.2
 */
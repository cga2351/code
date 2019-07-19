package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;

@zzare
public final class zzavy
{
  @VisibleForTesting
  private static Uri zza(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf("&adurl");
    if (i == -1)
      i = paramString1.indexOf("?adurl");
    if (i != -1)
      return Uri.parse(paramString1.substring(0, i + 1) + paramString2 + "=" + paramString3 + "&" + paramString1.substring(i + 1));
    return Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).build();
  }

  public static String zzb(Uri paramUri, Context paramContext)
  {
    if (!zzk.zzme().zzx(paramContext))
      return paramUri.toString();
    String str1 = zzk.zzme().zzac(paramContext);
    if (str1 == null)
      return paramUri.toString();
    zzaci localzzaci1 = zzact.zzcnw;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
    {
      zzaci localzzaci2 = zzact.zzcnx;
      String str2 = (String)zzyr.zzpe().zzd(localzzaci2);
      String str3 = paramUri.toString();
      if (str3.contains(str2))
      {
        zzk.zzme().zzg(paramContext, str1);
        return str3.replace(str2, str1);
      }
    }
    else if (TextUtils.isEmpty(paramUri.getQueryParameter("fbs_aeid")))
    {
      paramUri = zza(paramUri.toString(), "fbs_aeid", str1);
      zzk.zzme().zzg(paramContext, str1);
    }
    return paramUri.toString();
  }

  public static String zzd(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzaci localzzaci1 = zzact.zzcoe;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue()) && (!paramBoolean));
    String str1;
    do
    {
      do
      {
        String str2;
        do
        {
          do
          {
            do
            {
              do
                return paramString;
              while ((!zzk.zzme().zzx(paramContext)) || (TextUtils.isEmpty(paramString)));
              str1 = zzk.zzme().zzac(paramContext);
            }
            while (str1 == null);
            zzaci localzzaci2 = zzact.zzcnw;
            if (!((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
              break;
            zzaci localzzaci3 = zzact.zzcnx;
            str2 = (String)zzyr.zzpe().zzd(localzzaci3);
          }
          while (!paramString.contains(str2));
          if (zzk.zzlg().zzea(paramString))
          {
            zzk.zzme().zzg(paramContext, str1);
            return paramString.replace(str2, str1);
          }
        }
        while (!zzk.zzlg().zzeb(paramString));
        zzk.zzme().zzh(paramContext, str1);
        return paramString.replace(str2, str1);
      }
      while (paramString.contains("fbs_aeid"));
      if (zzk.zzlg().zzea(paramString))
      {
        zzk.zzme().zzg(paramContext, str1);
        return zza(paramString, "fbs_aeid", str1).toString();
      }
    }
    while (!zzk.zzlg().zzeb(paramString));
    zzk.zzme().zzh(paramContext, str1);
    return zza(paramString, "fbs_aeid", str1).toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzavy
 * JD-Core Version:    0.6.2
 */
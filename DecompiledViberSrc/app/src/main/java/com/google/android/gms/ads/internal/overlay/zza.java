package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzaci;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzact;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzaxj;
import com.google.android.gms.internal.ads.zzyr;

@zzare
public final class zza
{
  private static boolean zza(Context paramContext, Intent paramIntent, zzu paramzzu)
  {
    try
    {
      String str1 = String.valueOf(paramIntent.toURI());
      if (str1.length() != 0);
      for (String str2 = "Launching an intent: ".concat(str1); ; str2 = new String("Launching an intent: "))
      {
        zzaxa.zzds(str2);
        zzk.zzlg();
        zzaxj.zza(paramContext, paramIntent);
        if (paramzzu == null)
          break;
        paramzzu.zztq();
        break;
      }
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      zzaxa.zzep(localActivityNotFoundException.getMessage());
      return false;
    }
    return true;
  }

  public static boolean zza(Context paramContext, zzc paramzzc, zzu paramzzu)
  {
    if (paramzzc == null)
    {
      zzaxa.zzep("No intent data for launcher overlay.");
      return false;
    }
    zzact.initialize(paramContext);
    if (paramzzc.intent != null)
      return zza(paramContext, paramzzc.intent, paramzzu);
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(paramzzc.url))
    {
      zzaxa.zzep("Open GMSG did not contain a URL.");
      return false;
    }
    String[] arrayOfString;
    String str2;
    if (!TextUtils.isEmpty(paramzzc.mimeType))
    {
      localIntent.setDataAndType(Uri.parse(paramzzc.url), paramzzc.mimeType);
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramzzc.packageName))
        localIntent.setPackage(paramzzc.packageName);
      if (TextUtils.isEmpty(paramzzc.zzdjj))
        break label213;
      arrayOfString = paramzzc.zzdjj.split("/", 2);
      if (arrayOfString.length >= 2)
        break label200;
      str2 = String.valueOf(paramzzc.zzdjj);
      if (str2.length() == 0)
        break label186;
    }
    label186: for (String str3 = "Could not parse component name from open GMSG: ".concat(str2); ; str3 = new String("Could not parse component name from open GMSG: "))
    {
      zzaxa.zzep(str3);
      return false;
      localIntent.setData(Uri.parse(paramzzc.url));
      break;
    }
    label200: localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    label213: String str1 = paramzzc.zzdjk;
    if (!TextUtils.isEmpty(str1));
    try
    {
      int j = Integer.parseInt(str1);
      i = j;
      localIntent.addFlags(i);
      zzaci localzzaci1 = zzact.zzcua;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      {
        localIntent.addFlags(268435456);
        localIntent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        return zza(paramContext, localIntent, paramzzu);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        zzaxa.zzep("Could not parse intent flags.");
        int i = 0;
        continue;
        zzaci localzzaci2 = zzact.zzctz;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
        {
          zzk.zzlg();
          zzaxj.zzb(paramContext, localIntent);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zza
 * JD-Core Version:    0.6.2
 */
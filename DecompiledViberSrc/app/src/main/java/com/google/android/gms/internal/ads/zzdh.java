package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;
import android.view.View;

public final class zzdh
{
  private static final String[] zzwo = { "/aclk", "/pcs/click", "/dbm/clk" };
  private String zzwk = "googleads.g.doubleclick.net";
  private String zzwl = "/pagead/ads";
  private String zzwm = "ad.doubleclick.net";
  private String[] zzwn = { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
  private zzdc zzwp;

  public zzdh(zzdc paramzzdc)
  {
    this.zzwp = paramzzdc;
  }

  private final Uri zza(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean, View paramView, Activity paramActivity)
    throws zzdi
  {
    boolean bool;
    try
    {
      bool = zzb(paramUri);
      if (bool)
      {
        if (!paramUri.toString().contains("dc_ms="))
          break label65;
        throw new zzdi("Parameter already exists: dc_ms");
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      throw new zzdi("Provided Uri is not in a valid state");
    }
    if (paramUri.getQueryParameter("ms") != null)
      throw new zzdi("Query parameter already exists: ms");
    label65: String str1;
    if (paramBoolean)
      str1 = this.zzwp.zza(paramContext, paramString, paramView, paramActivity);
    while (bool)
    {
      String str2 = paramUri.toString();
      int i = str2.indexOf(";adurl");
      if (i != -1)
      {
        return Uri.parse(str2.substring(0, i + 1) + "dc_ms" + "=" + str1 + ";" + str2.substring(i + 1));
        str1 = this.zzwp.zza(paramContext);
      }
      else
      {
        String str3 = paramUri.getEncodedPath();
        int j = str2.indexOf(str3);
        return Uri.parse(str2.substring(0, j + str3.length()) + ";" + "dc_ms" + "=" + str1 + ";" + str2.substring(j + str3.length()));
      }
    }
    String str4 = paramUri.toString();
    int k = str4.indexOf("&adurl");
    if (k == -1)
      k = str4.indexOf("?adurl");
    if (k != -1)
      return Uri.parse(str4.substring(0, k + 1) + "ms" + "=" + str1 + "&" + str4.substring(k + 1));
    Uri localUri = paramUri.buildUpon().appendQueryParameter("ms", str1).build();
    return localUri;
  }

  private final boolean zzb(Uri paramUri)
  {
    if (paramUri == null)
      throw new NullPointerException();
    try
    {
      boolean bool = paramUri.getHost().equals(this.zzwm);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  public final Uri zza(Uri paramUri, Context paramContext)
    throws zzdi
  {
    return zza(paramUri, paramContext, null, false, null, null);
  }

  public final Uri zza(Uri paramUri, Context paramContext, View paramView, Activity paramActivity)
    throws zzdi
  {
    try
    {
      Uri localUri = zza(paramUri, paramContext, paramUri.getQueryParameter("ai"), true, paramView, paramActivity);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
    }
    throw new zzdi("Provided Uri is not in a valid state");
  }

  public final void zza(MotionEvent paramMotionEvent)
  {
    this.zzwp.zza(paramMotionEvent);
  }

  public final boolean zza(Uri paramUri)
  {
    if (paramUri == null)
      throw new NullPointerException();
    try
    {
      boolean bool1 = paramUri.getHost().equals(this.zzwk);
      boolean bool2 = false;
      if (bool1)
      {
        boolean bool3 = paramUri.getPath().equals(this.zzwl);
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
      return bool2;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  public final void zzam(String paramString)
  {
    this.zzwn = paramString.split(",");
  }

  public final void zzb(String paramString1, String paramString2)
  {
    this.zzwk = paramString1;
    this.zzwl = paramString2;
  }

  public final boolean zzc(Uri paramUri)
  {
    if (paramUri == null)
      throw new NullPointerException();
    try
    {
      String str = paramUri.getHost();
      String[] arrayOfString = this.zzwn;
      int i = arrayOfString.length;
      for (int j = 0; ; j++)
      {
        boolean bool1 = false;
        if (j < i)
        {
          boolean bool2 = str.endsWith(arrayOfString[j]);
          if (bool2)
            bool1 = true;
        }
        else
        {
          return bool1;
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  public final zzdc zzcg()
  {
    return this.zzwp;
  }

  public final boolean zzd(Uri paramUri)
  {
    boolean bool1 = zzc(paramUri);
    boolean bool2 = false;
    String[] arrayOfString;
    int i;
    if (bool1)
    {
      arrayOfString = zzwo;
      i = arrayOfString.length;
    }
    for (int j = 0; ; j++)
    {
      bool2 = false;
      if (j < i)
      {
        String str = arrayOfString[j];
        if (paramUri.getPath().endsWith(str))
          bool2 = true;
      }
      else
      {
        return bool2;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdh
 * JD-Core Version:    0.6.2
 */
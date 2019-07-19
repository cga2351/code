package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzaa extends zzcs
{
  private long zzahq;
  private String zzahr;
  private Boolean zzahs;

  zzaa(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  protected final boolean zzgy()
  {
    Calendar localCalendar = Calendar.getInstance();
    this.zzahq = TimeUnit.MINUTES.convert(localCalendar.get(15) + localCalendar.get(16), TimeUnit.MILLISECONDS);
    Locale localLocale = Locale.getDefault();
    String str1 = localLocale.getLanguage().toLowerCase(Locale.ENGLISH);
    String str2 = localLocale.getCountry().toLowerCase(Locale.ENGLISH);
    this.zzahr = (1 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + "-" + str2);
    return false;
  }

  public final long zziw()
  {
    zzcl();
    return this.zzahq;
  }

  public final String zzix()
  {
    zzcl();
    return this.zzahr;
  }

  public final boolean zzl(Context paramContext)
  {
    if (this.zzahs == null)
    {
      zzgw();
      this.zzahs = Boolean.valueOf(false);
    }
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager != null)
      {
        localPackageManager.getPackageInfo("com.google.android.gms", 128);
        this.zzahs = Boolean.valueOf(true);
      }
      label50: return this.zzahs.booleanValue();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label50;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaa
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

@zzare
public final class zzasr extends ContextWrapper
{
  private Context zzdqp;
  private WeakReference<Activity> zzdqq = new WeakReference(null);

  private zzasr(Context paramContext)
  {
    super(paramContext);
  }

  private final Intent zzd(Intent paramIntent)
  {
    try
    {
      Intent localIntent;
      if ((this.zzdqp != null) && (paramIntent.getComponent() != null))
      {
        boolean bool = paramIntent.getComponent().getPackageName().equals(this.zzdqp.getPackageName());
        if (bool);
      }
      else
      {
        localIntent = paramIntent;
      }
      while (true)
      {
        return localIntent;
        localIntent = (Intent)paramIntent.clone();
        localIntent.setClassName(super.getPackageName(), paramIntent.getComponent().getClassName());
      }
    }
    finally
    {
    }
  }

  private final void zze(Intent paramIntent)
  {
    try
    {
      Activity localActivity = (Activity)this.zzdqq.get();
      if (localActivity == null)
      {
        paramIntent.addFlags(268435456);
        super.startActivity(paramIntent);
      }
      while (true)
      {
        return;
        try
        {
          Intent localIntent = (Intent)paramIntent.clone();
          localIntent.setFlags(0xEFFFFFFF & paramIntent.getFlags());
          localActivity.startActivity(localIntent);
        }
        catch (Throwable localThrowable)
        {
          zzk.zzlk().zza(localThrowable, "");
          paramIntent.addFlags(268435456);
          super.startActivity(paramIntent);
        }
      }
    }
    finally
    {
    }
  }

  private static Context zzk(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null)
      return paramContext;
    return localContext;
  }

  public static zzasr zzv(Context paramContext)
  {
    return new zzasr(zzk(paramContext));
  }

  public static Context zzw(Context paramContext)
  {
    if ((paramContext instanceof zzasr))
      return ((zzasr)paramContext).getBaseContext();
    return zzk(paramContext);
  }

  public final Context getApplicationContext()
  {
    return this;
  }

  public final ApplicationInfo getApplicationInfo()
  {
    try
    {
      ApplicationInfo localApplicationInfo2;
      if (this.zzdqp != null)
        localApplicationInfo2 = this.zzdqp.getApplicationInfo();
      ApplicationInfo localApplicationInfo1;
      for (Object localObject2 = localApplicationInfo2; ; localObject2 = localApplicationInfo1)
      {
        return localObject2;
        localApplicationInfo1 = super.getApplicationInfo();
      }
    }
    finally
    {
    }
  }

  public final String getPackageName()
  {
    try
    {
      String str2;
      if (this.zzdqp != null)
        str2 = this.zzdqp.getPackageName();
      String str1;
      for (Object localObject2 = str2; ; localObject2 = str1)
      {
        return localObject2;
        str1 = super.getPackageName();
      }
    }
    finally
    {
    }
  }

  public final String getPackageResourcePath()
  {
    try
    {
      String str2;
      if (this.zzdqp != null)
        str2 = this.zzdqp.getPackageResourcePath();
      String str1;
      for (Object localObject2 = str2; ; localObject2 = str1)
      {
        return localObject2;
        str1 = super.getPackageResourcePath();
      }
    }
    finally
    {
    }
  }

  public final void setAppPackageName(String paramString)
    throws PackageManager.NameNotFoundException
  {
    try
    {
      this.zzdqp = super.createPackageContext(paramString, 0);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void startActivity(Intent paramIntent)
  {
    try
    {
      zze(zzd(paramIntent));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzasr
 * JD-Core Version:    0.6.2
 */
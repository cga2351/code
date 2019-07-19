package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.Nonnull;

@zzare
public final class zzabg extends ContentProvider
{
  private static Bundle zzh(Context paramContext)
  {
    try
    {
      Bundle localBundle = Wrappers.packageManager(paramContext).getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      return localBundle;
    }
    catch (NullPointerException localNullPointerException)
    {
      zzbae.zzc("Failed to load metadata: Null pointer exception", localNullPointerException);
      return null;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        zzbae.zzc("Failed to load metadata: Package name not found", localNameNotFoundException);
    }
  }

  public final void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    Bundle localBundle = zzh(paramContext);
    if (localBundle != null);
    while (true)
    {
      try
      {
        String str5 = (String)localBundle.get("com.google.android.gms.ads.APPLICATION_ID");
        str4 = str5;
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          localBoolean = (Boolean)localBundle.get("com.google.android.gms.ads.AD_MANAGER_APP");
          str1 = str4;
          if (((localBoolean == null) || (!localBoolean.booleanValue())) && (str1 == null))
          {
            throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here: https://goo.gl/fQ2neu to add a valid  *\n* App ID inside the AndroidManifest. Google Ad Manager publishers should     *\n* follow instructions here: https://goo.gl/h17b6x.                           *\n******************************************************************************\n\n");
            localClassCastException1 = localClassCastException1;
            zzbae.zzen("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value");
            str4 = null;
            continue;
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          String str4;
          zzbae.zzen("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value");
          str1 = str4;
          localBoolean = null;
          continue;
        }
      }
      String str2;
      if (str1 != null)
      {
        if (!str1.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$"))
          throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here: https://goo.gl/fQ2neu to *\n* find your app ID.                                                          *\n******************************************************************************\n\n");
        str2 = String.valueOf(str1);
        if (str2.length() == 0)
          break label164;
      }
      label164: for (String str3 = "Publisher provided Google AdMob App ID in manifest: ".concat(str2); ; str3 = new String("Publisher provided Google AdMob App ID in manifest: "))
      {
        zzbae.zzdp(str3);
        zzamj.initialize(paramContext, str1);
        super.attachInfo(paramContext, paramProviderInfo);
        return;
      }
      Boolean localBoolean = null;
      String str1 = null;
    }
  }

  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }

  public final String getType(Uri paramUri)
  {
    return null;
  }

  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }

  public final boolean onCreate()
  {
    return false;
  }

  public final Cursor query(@Nonnull Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }

  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabg
 * JD-Core Version:    0.6.2
 */
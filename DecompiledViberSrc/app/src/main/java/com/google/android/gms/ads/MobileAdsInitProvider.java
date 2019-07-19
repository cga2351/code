package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzabg;

@KeepForSdkWithMembers
public class MobileAdsInitProvider extends ContentProvider
{
  private final zzabg zzaau = new zzabg();

  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    this.zzaau.attachInfo(paramContext, paramProviderInfo);
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return this.zzaau.delete(paramUri, paramString, paramArrayOfString);
  }

  public String getType(Uri paramUri)
  {
    return this.zzaau.getType(paramUri);
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return this.zzaau.insert(paramUri, paramContentValues);
  }

  public boolean onCreate()
  {
    return this.zzaau.onCreate();
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.zzaau.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return this.zzaau.update(paramUri, paramContentValues, paramString, paramArrayOfString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.MobileAdsInitProvider
 * JD-Core Version:    0.6.2
 */
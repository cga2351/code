package com.appboy.ui.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import com.appboy.f.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UriUtils
{
  private static final String TAG = c.a(UriUtils.class);

  public static Intent getMainActivityIntent(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    localIntent.setFlags(872415232);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    return localIntent;
  }

  public static Map<String, String> getQueryParameters(Uri paramUri)
  {
    if (paramUri.isOpaque())
    {
      c.b(TAG, "URI is not hierarchical. There are no query parameters to parse.");
      return Collections.emptyMap();
    }
    String str1 = paramUri.getEncodedQuery();
    if (str1 == null)
      return Collections.emptyMap();
    HashMap localHashMap = new HashMap();
    int i = 0;
    do
    {
      int j = str1.indexOf('&', i);
      if (j == -1)
        j = str1.length();
      int k = str1.indexOf('=', i);
      if ((k > j) || (k == -1))
        k = j;
      if (j > i)
      {
        String str2 = str1.substring(i, k);
        String str3 = str1.substring(k + 1, j);
        localHashMap.put(Uri.decode(str2), Uri.decode(str3));
      }
      i = j + 1;
    }
    while (i < str1.length());
    return Collections.unmodifiableMap(localHashMap);
  }

  public static boolean isActivityRegisteredInManifest(Context paramContext, String paramString)
  {
    try
    {
      ActivityInfo localActivityInfo = paramContext.getPackageManager().getActivityInfo(new ComponentName(paramContext, paramString), 0);
      boolean bool = false;
      if (localActivityInfo != null)
        bool = true;
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      c.c(TAG, "Could not find activity info for class with name: " + paramString, localNameNotFoundException);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.support.UriUtils
 * JD-Core Version:    0.6.2
 */
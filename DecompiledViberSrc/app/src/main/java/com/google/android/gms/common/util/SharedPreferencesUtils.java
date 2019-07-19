package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.File;

@KeepForSdk
public class SharedPreferencesUtils
{
  @Deprecated
  @KeepForSdk
  public static void publishWorldReadableSharedPreferences(Context paramContext, SharedPreferences.Editor paramEditor, String paramString)
  {
    File localFile1 = new File(paramContext.getApplicationInfo().dataDir, "shared_prefs");
    File localFile2 = localFile1.getParentFile();
    if (localFile2 != null)
      localFile2.setExecutable(true, false);
    localFile1.setExecutable(true, false);
    paramEditor.commit();
    new File(localFile1, String.valueOf(paramString).concat(".xml")).setReadable(true, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.SharedPreferencesUtils
 * JD-Core Version:    0.6.2
 */
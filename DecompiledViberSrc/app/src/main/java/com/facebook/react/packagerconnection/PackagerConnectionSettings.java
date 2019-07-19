package com.facebook.react.packagerconnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import javax.annotation.Nullable;

public class PackagerConnectionSettings
{
  private static final String PREFS_DEBUG_SERVER_HOST_KEY = "debug_http_host";
  private static final String TAG = PackagerConnectionSettings.class.getSimpleName();
  private final String mPackageName;
  private final SharedPreferences mPreferences;

  public PackagerConnectionSettings(Context paramContext)
  {
    this.mPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    this.mPackageName = paramContext.getPackageName();
  }

  public String getDebugServerHost()
  {
    String str1 = this.mPreferences.getString("debug_http_host", null);
    String str2;
    if (!TextUtils.isEmpty(str1))
      str2 = (String)Assertions.assertNotNull(str1);
    do
    {
      return str2;
      str2 = AndroidInfoHelpers.getServerHost();
    }
    while (!str2.equals("localhost"));
    FLog.w(TAG, "You seem to be running on device. Run 'adb reverse tcp:8081 tcp:8081' to forward the debug server's port to the device.");
    return str2;
  }

  public String getInspectorServerHost()
  {
    return AndroidInfoHelpers.getInspectorProxyHost();
  }

  @Nullable
  public String getPackageName()
  {
    return this.mPackageName;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.PackagerConnectionSettings
 * JD-Core Version:    0.6.2
 */
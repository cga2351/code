package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

@Deprecated
public class InstanceIDListenerService extends zze
{
  static void zzd(Context paramContext, zzak paramzzak)
  {
    paramzzak.zzz();
    Intent localIntent = new Intent("com.google.android.gms.iid.InstanceID");
    localIntent.putExtra("CMD", "RST");
    localIntent.setClassName(paramContext, "com.google.android.gms.gcm.GcmReceiver");
    paramContext.sendBroadcast(localIntent);
  }

  public void handleIntent(Intent paramIntent)
  {
    if (!"com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()));
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getStringExtra("subtype");
        Bundle localBundle = null;
        if (str1 != null)
        {
          localBundle = new Bundle();
          localBundle.putString("subtype", str1);
        }
        InstanceID localInstanceID = InstanceID.getInstance(this, localBundle);
        str2 = paramIntent.getStringExtra("CMD");
        if (Log.isLoggable("InstanceID", 3))
          Log.d("InstanceID", 34 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Service command. subtype:" + str1 + " command:" + str2);
        if ("RST".equals(str2))
        {
          localInstanceID.zzo();
          onTokenRefresh();
          return;
        }
        if (!"RST_FULL".equals(str2))
          break;
      }
      while (InstanceID.zzp().isEmpty());
      InstanceID.zzp().zzz();
      onTokenRefresh();
      return;
    }
    while (!"SYNC".equals(str2));
    zzak localzzak = InstanceID.zzp();
    String str3 = String.valueOf(str1);
    String str4 = String.valueOf("|T|");
    String str5;
    String str6;
    String str7;
    if (str4.length() != 0)
    {
      str5 = str3.concat(str4);
      localzzak.zzi(str5);
      str6 = String.valueOf(str1);
      str7 = String.valueOf("|T-timestamp|");
      if (str7.length() == 0)
        break label277;
    }
    label277: for (String str8 = str6.concat(str7); ; str8 = new String(str6))
    {
      localzzak.zzi(str8);
      onTokenRefresh();
      return;
      str5 = new String(str3);
      break;
    }
  }

  public void onTokenRefresh()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.InstanceIDListenerService
 * JD-Core Version:    0.6.2
 */
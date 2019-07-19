package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.iid.zze;
import com.google.android.gms.internal.gcm.zzl;
import com.google.android.gms.internal.gcm.zzm;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Deprecated
public class GcmListenerService extends zze
{
  private zzl zzg = zzm.zzdk;

  static void zzd(Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str != null) && (str.startsWith("google.c.")))
        localIterator.remove();
    }
  }

  public void handleIntent(Intent paramIntent)
  {
    if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction()))
    {
      String str9 = String.valueOf(paramIntent.getAction());
      if (str9.length() != 0);
      for (String str10 = "Unknown intent action: ".concat(str9); ; str10 = new String("Unknown intent action: "))
      {
        Log.w("GcmListenerService", str10);
        return;
      }
    }
    String str1 = paramIntent.getStringExtra("message_type");
    if (str1 == null)
      str1 = "gcm";
    int i = -1;
    String str7;
    switch (str1.hashCode())
    {
    default:
      switch (i)
      {
      default:
        str7 = String.valueOf(str1);
        if (str7.length() == 0);
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
      break;
    case 102161:
    case -2062414158:
    case 814800675:
    case 814694033:
    }
    for (String str8 = "Received message with unknown type: ".concat(str7); ; str8 = new String("Received message with unknown type: "))
    {
      Log.w("GcmListenerService", str8);
      return;
      if (!str1.equals("gcm"))
        break;
      i = 0;
      break;
      if (!str1.equals("deleted_messages"))
        break;
      i = 1;
      break;
      if (!str1.equals("send_event"))
        break;
      i = 2;
      break;
      if (!str1.equals("send_error"))
        break;
      i = 3;
      break;
      Bundle localBundle1 = paramIntent.getExtras();
      localBundle1.remove("message_type");
      localBundle1.remove("android.support.content.wakelockid");
      int j;
      int k;
      if (("1".equals(zzd.zzd(localBundle1, "gcm.n.e"))) || (zzd.zzd(localBundle1, "gcm.n.icon") != null))
      {
        j = 1;
        if (j == 0)
          break label588;
        if (((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode())
          break label418;
        int m = Process.myPid();
        List localList = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
        if (localList == null)
          break label418;
        Iterator localIterator2 = localList.iterator();
        while (true)
          if (localIterator2.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator2.next();
            if (localRunningAppProcessInfo.pid == m)
              if (localRunningAppProcessInfo.importance == 100)
                k = 1;
          }
      }
      while (true)
      {
        if (k != 0)
          break label424;
        zzd.zzd(this).zze(localBundle1);
        return;
        j = 0;
        break;
        k = 0;
        continue;
        label418: k = 0;
      }
      label424: Bundle localBundle2 = new Bundle();
      Iterator localIterator1 = localBundle1.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str5 = (String)localIterator1.next();
        String str6 = localBundle1.getString(str5);
        if (str5.startsWith("gcm.notification."))
          str5 = str5.replace("gcm.notification.", "gcm.n.");
        if (str5.startsWith("gcm.n."))
        {
          if (!"gcm.n.e".equals(str5))
            localBundle2.putString(str5.substring(6), str6);
          localIterator1.remove();
        }
      }
      String str4 = localBundle2.getString("sound2");
      if (str4 != null)
      {
        localBundle2.remove("sound2");
        localBundle2.putString("sound", str4);
      }
      if (!localBundle2.isEmpty())
        localBundle1.putBundle("notification", localBundle2);
      label588: String str3 = localBundle1.getString("from");
      localBundle1.remove("from");
      zzd(localBundle1);
      this.zzg.zzl("onMessageReceived");
      try
      {
        onMessageReceived(str3, localBundle1);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable = localThrowable;
        throw localThrowable;
      }
      finally
      {
      }
      onDeletedMessages();
      return;
      onMessageSent(paramIntent.getStringExtra("google.message_id"));
      return;
      String str2 = paramIntent.getStringExtra("google.message_id");
      if (str2 == null)
        str2 = paramIntent.getStringExtra("message_id");
      onSendError(str2, paramIntent.getStringExtra("error"));
      return;
    }
  }

  public void onCreate()
  {
    super.onCreate();
    zzm.zzab();
    getClass();
    this.zzg = zzm.zzdk;
  }

  public void onDeletedMessages()
  {
  }

  public void onMessageReceived(String paramString, Bundle paramBundle)
  {
  }

  public void onMessageSent(String paramString)
  {
  }

  public void onSendError(String paramString1, String paramString2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmListenerService
 * JD-Core Version:    0.6.2
 */
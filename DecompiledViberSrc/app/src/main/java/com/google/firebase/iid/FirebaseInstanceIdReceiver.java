package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.concurrent.GuardedBy;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver
{
  private static boolean a = false;

  @GuardedBy("FirebaseInstanceIdReceiver.class")
  private static ak b;

  @GuardedBy("FirebaseInstanceIdReceiver.class")
  private static ak c;

  @SuppressLint({"InlinedApi"})
  @ShowFirstParty
  public static int a(BroadcastReceiver paramBroadcastReceiver, Context paramContext, String paramString, Intent paramIntent)
  {
    int i = 1;
    int j;
    label35: int k;
    if ((PlatformVersion.isAtLeastO()) && (paramContext.getApplicationInfo().targetSdkVersion >= 26))
    {
      j = i;
      if ((0x10000000 & paramIntent.getFlags()) == 0)
        break label63;
      if ((j == 0) || (i != 0))
        break label69;
      k = b(paramBroadcastReceiver, paramContext, paramString, paramIntent);
    }
    label63: label69: 
    do
    {
      return k;
      j = 0;
      break;
      i = 0;
      break label35;
      k = x.a().a(paramContext, paramString, paramIntent);
    }
    while ((!PlatformVersion.isAtLeastO()) || (k != 402));
    b(paramBroadcastReceiver, paramContext, paramString, paramIntent);
    return 403;
  }

  private static ak a(Context paramContext, String paramString)
  {
    try
    {
      if ("com.google.firebase.MESSAGING_EVENT".equals(paramString))
        if (c == null)
          c = new ak(paramContext, paramString);
      for (ak localak = c; ; localak = b)
      {
        return localak;
        if (b == null)
          b = new ak(paramContext, paramString);
      }
    }
    finally
    {
    }
  }

  private final void a(Context paramContext, Intent paramIntent, String paramString)
  {
    paramIntent.setComponent(null);
    paramIntent.setPackage(paramContext.getPackageName());
    if (Build.VERSION.SDK_INT <= 18)
      paramIntent.removeCategory(paramContext.getPackageName());
    String str1 = paramIntent.getStringExtra("gcm.rawData64");
    if (str1 != null)
    {
      paramIntent.putExtra("rawData", Base64.decode(str1, 0));
      paramIntent.removeExtra("gcm.rawData64");
    }
    String str2;
    if (("google.com/iid".equals(paramIntent.getStringExtra("from"))) || ("com.google.firebase.INSTANCE_ID_EVENT".equals(paramString)))
      str2 = "com.google.firebase.INSTANCE_ID_EVENT";
    while (true)
    {
      int i = -1;
      if (str2 != null)
        i = a(this, paramContext, str2, paramIntent);
      if (isOrderedBroadcast())
        setResultCode(i);
      return;
      if (("com.google.android.c2dm.intent.RECEIVE".equals(paramString)) || ("com.google.firebase.MESSAGING_EVENT".equals(paramString)))
      {
        str2 = "com.google.firebase.MESSAGING_EVENT";
      }
      else
      {
        Log.d("FirebaseInstanceId", "Unexpected intent");
        str2 = null;
      }
    }
  }

  private static int b(BroadcastReceiver paramBroadcastReceiver, Context paramContext, String paramString, Intent paramIntent)
  {
    String str1;
    if (Log.isLoggable("FirebaseInstanceId", 3))
    {
      str1 = String.valueOf(paramString);
      if (str1.length() == 0)
        break label67;
    }
    label67: for (String str2 = "Binding to service: ".concat(str1); ; str2 = new String("Binding to service: "))
    {
      Log.d("FirebaseInstanceId", str2);
      if (paramBroadcastReceiver.isOrderedBroadcast())
        paramBroadcastReceiver.setResultCode(-1);
      a(paramContext, paramString).a(paramIntent, paramBroadcastReceiver.goAsync());
      return -1;
    }
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
      return;
    Parcelable localParcelable = paramIntent.getParcelableExtra("wrapped_intent");
    if ((localParcelable instanceof Intent));
    for (Intent localIntent = (Intent)localParcelable; localIntent != null; localIntent = null)
    {
      a(paramContext, localIntent, paramIntent.getAction());
      return;
    }
    a(paramContext, paramIntent, paramIntent.getAction());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceIdReceiver
 * JD-Core Version:    0.6.2
 */
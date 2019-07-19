package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class x
{
  private static x b;
  final Queue<Intent> a = new ArrayDeque();

  @GuardedBy("serviceClassNames")
  private final SimpleArrayMap<String, String> c = new SimpleArrayMap();
  private Boolean d = null;
  private Boolean e = null;
  private final Queue<Intent> f = new ArrayDeque();

  public static x a()
  {
    try
    {
      if (b == null)
        b = new x();
      x localx = b;
      return localx;
    }
    finally
    {
    }
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    paramContext.sendBroadcast(b(paramContext, "com.google.firebase.INSTANCE_ID_EVENT", paramIntent));
  }

  private static Intent b(Context paramContext, String paramString, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, FirebaseInstanceIdReceiver.class);
    localIntent.setAction(paramString);
    localIntent.putExtra("wrapped_intent", paramIntent);
    return localIntent;
  }

  public static void b(Context paramContext, Intent paramIntent)
  {
    paramContext.sendBroadcast(b(paramContext, "com.google.firebase.MESSAGING_EVENT", paramIntent));
  }

  private final int c(Context paramContext, Intent paramIntent)
  {
    String str1;
    ResolveInfo localResolveInfo;
    synchronized (this.c)
    {
      str1 = (String)this.c.get(paramIntent.getAction());
      if (str1 == null)
      {
        localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
        if ((localResolveInfo == null) || (localResolveInfo.serviceInfo == null))
          Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
      }
    }
    try
    {
      ComponentName localComponentName;
      if (a(paramContext))
        localComponentName = WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);
      while (true)
      {
        if (localComponentName != null)
          break label405;
        Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
        return 404;
        localObject1 = finally;
        throw localObject1;
        ServiceInfo localServiceInfo = localResolveInfo.serviceInfo;
        if ((!paramContext.getPackageName().equals(localServiceInfo.packageName)) || (localServiceInfo.name == null))
        {
          String str5 = localServiceInfo.packageName;
          String str6 = localServiceInfo.name;
          Log.e("FirebaseInstanceId", 94 + String.valueOf(str5).length() + String.valueOf(str6).length() + "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + str5 + "/" + str6);
          break;
        }
        str1 = localServiceInfo.name;
        String str7;
        if (str1.startsWith("."))
        {
          str7 = String.valueOf(paramContext.getPackageName());
          String str8 = String.valueOf(str1);
          if (str8.length() == 0)
            break label335;
          str1 = str7.concat(str8);
        }
        while (true)
        {
          synchronized (this.c)
          {
            this.c.put(paramIntent.getAction(), str1);
            if (Log.isLoggable("FirebaseInstanceId", 3))
            {
              String str3 = String.valueOf(str1);
              if (str3.length() != 0)
              {
                str4 = "Restricting intent to a specific service: ".concat(str3);
                Log.d("FirebaseInstanceId", str4);
              }
            }
            else
            {
              paramIntent.setClassName(paramContext.getPackageName(), str1);
              break;
              label335: str1 = new String(str7);
            }
          }
          String str4 = new String("Restricting intent to a specific service: ");
        }
        localComponentName = paramContext.startService(paramIntent);
        Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
      }
    }
    catch (SecurityException localSecurityException)
    {
      Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", localSecurityException);
      return 401;
      return -1;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label405: String str2 = String.valueOf(localIllegalStateException);
      Log.e("FirebaseInstanceId", 45 + String.valueOf(str2).length() + "Failed to start service while in background: " + str2);
    }
    return 402;
  }

  public final int a(Context paramContext, String paramString, Intent paramIntent)
  {
    String str4;
    int i;
    label72: String str1;
    if (Log.isLoggable("FirebaseInstanceId", 3))
    {
      String str3 = String.valueOf(paramString);
      if (str3.length() != 0)
      {
        str4 = "Starting service: ".concat(str3);
        Log.d("FirebaseInstanceId", str4);
      }
    }
    else
    {
      i = -1;
      switch (paramString.hashCode())
      {
      default:
        switch (i)
        {
        default:
          str1 = String.valueOf(paramString);
          if (str1.length() == 0);
          break;
        case 0:
        case 1:
        }
        break;
      case -842411455:
      case 41532704:
      }
    }
    for (String str2 = "Unknown service action: ".concat(str1); ; str2 = new String("Unknown service action: "))
    {
      Log.w("FirebaseInstanceId", str2);
      return 500;
      str4 = new String("Starting service: ");
      break;
      if (!paramString.equals("com.google.firebase.INSTANCE_ID_EVENT"))
        break label72;
      i = 0;
      break label72;
      if (!paramString.equals("com.google.firebase.MESSAGING_EVENT"))
        break label72;
      i = 1;
      break label72;
      this.a.offer(paramIntent);
      while (true)
      {
        Intent localIntent = new Intent(paramString);
        localIntent.setPackage(paramContext.getPackageName());
        return c(paramContext, localIntent);
        this.f.offer(paramIntent);
      }
    }
  }

  final boolean a(Context paramContext)
  {
    if (this.d == null)
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") != 0)
        break label61;
    label61: for (boolean bool = true; ; bool = false)
    {
      this.d = Boolean.valueOf(bool);
      if ((!this.d.booleanValue()) && (Log.isLoggable("FirebaseInstanceId", 3)))
        Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
      return this.d.booleanValue();
    }
  }

  public final Intent b()
  {
    return (Intent)this.f.poll();
  }

  final boolean b(Context paramContext)
  {
    if (this.e == null)
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
        break label61;
    label61: for (boolean bool = true; ; bool = false)
    {
      this.e = Boolean.valueOf(bool);
      if ((!this.d.booleanValue()) && (Log.isLoggable("FirebaseInstanceId", 3)))
        Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
      return this.e.booleanValue();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.x
 * JD-Core Version:    0.6.2
 */
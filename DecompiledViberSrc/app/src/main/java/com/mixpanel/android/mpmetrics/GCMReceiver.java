package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import com.mixpanel.android.b.f;
import org.json.JSONException;
import org.json.JSONObject;

public class GCMReceiver extends BroadcastReceiver
{
  private Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 != null);
    for (Uri localUri = Uri.parse(paramString1); ; localUri = null)
    {
      if (localUri == null);
      for (Intent localIntent = a(paramContext); ; localIntent = new Intent("android.intent.action.VIEW", localUri))
      {
        if (paramString2 != null)
          localIntent.putExtra("mp_campaign_id", paramString2);
        if (paramString3 != null)
          localIntent.putExtra("mp_message_id", paramString3);
        if (paramString4 != null)
          localIntent.putExtra("mp", paramString4);
        return localIntent;
      }
    }
  }

  private void a(Context paramContext, Intent paramIntent)
  {
    String str = i.a(paramContext).B();
    if (str == null)
      str = paramContext.getPackageName();
    p.a locala = new p.a(str, paramContext);
    Notification localNotification = b(paramContext.getApplicationContext(), paramIntent, locala);
    if (localNotification != null)
      ((NotificationManager)paramContext.getSystemService("notification")).notify(0, localNotification);
  }

  private void a(Intent paramIntent)
  {
    final String str = paramIntent.getStringExtra("registration_id");
    if (paramIntent.getStringExtra("error") != null)
      f.e("MixpanelAPI.GCMReceiver", "Error when registering for GCM: " + paramIntent.getStringExtra("error"));
    do
    {
      return;
      if (str != null)
      {
        f.b("MixpanelAPI.GCMReceiver", "Registering GCM ID: " + str);
        MixpanelAPI.allInstances(new MixpanelAPI.a()
        {
          public void a(MixpanelAPI paramAnonymousMixpanelAPI)
          {
            paramAnonymousMixpanelAPI.getPeople().c(str);
          }
        });
        return;
      }
    }
    while (paramIntent.getStringExtra("unregistered") == null);
    f.b("MixpanelAPI.GCMReceiver", "Unregistering from GCM");
    MixpanelAPI.allInstances(new MixpanelAPI.a()
    {
      public void a(MixpanelAPI paramAnonymousMixpanelAPI)
      {
        paramAnonymousMixpanelAPI.getPeople().d();
      }
    });
  }

  private void a(final String paramString1, final String paramString2, final String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null))
      MixpanelAPI.allInstances(new MixpanelAPI.a()
      {
        public void a(MixpanelAPI paramAnonymousMixpanelAPI)
        {
          JSONObject localJSONObject1;
          if (paramAnonymousMixpanelAPI.isAppInForeground())
            localJSONObject1 = new JSONObject();
          while (true)
          {
            try
            {
              if (paramString3 != null)
                localJSONObject2 = new JSONObject(paramString3);
            }
            catch (JSONException localJSONException1)
            {
              try
              {
                localJSONObject2.put("campaign_id", Integer.valueOf(paramString1).intValue());
                localJSONObject2.put("message_id", Integer.valueOf(paramString2).intValue());
                localJSONObject2.put("message_type", "push");
                paramAnonymousMixpanelAPI.track("$campaign_received", localJSONObject2);
                return;
                localJSONException1 = localJSONException1;
                localJSONObject2 = localJSONObject1;
                continue;
              }
              catch (JSONException localJSONException2)
              {
                return;
              }
            }
            JSONObject localJSONObject2 = localJSONObject1;
          }
        }
      });
  }

  private Notification b(Context paramContext, Intent paramIntent, o paramo)
  {
    a locala = a(paramContext, paramIntent, paramo);
    if (locala == null)
      return null;
    f.b("MixpanelAPI.GCMReceiver", "MP GCM notification received: " + locala.e);
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, locala.f, 134217728);
    if (Build.VERSION.SDK_INT >= 26)
      return e(paramContext, localPendingIntent, locala);
    if (Build.VERSION.SDK_INT >= 21)
      return d(paramContext, localPendingIntent, locala);
    if (Build.VERSION.SDK_INT >= 16)
      return c(paramContext, localPendingIntent, locala);
    if (Build.VERSION.SDK_INT >= 11)
      return b(paramContext, localPendingIntent, locala);
    return a(paramContext, localPendingIntent, locala);
  }

  @TargetApi(9)
  protected Notification a(Context paramContext, PendingIntent paramPendingIntent, a parama)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext).setSmallIcon(parama.a).setTicker(parama.e).setWhen(System.currentTimeMillis()).setContentTitle(parama.d).setContentText(parama.e).setContentIntent(paramPendingIntent).setDefaults(i.a(paramContext).u());
    if (parama.b != -1)
      localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), parama.b));
    Notification localNotification = localBuilder.getNotification();
    localNotification.flags = (0x10 | localNotification.flags);
    return localNotification;
  }

  Intent a(Context paramContext)
  {
    return paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
  }

  a a(Context paramContext, Intent paramIntent, o paramo)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str1 = paramIntent.getStringExtra("mp_message");
    String str2 = paramIntent.getStringExtra("mp_icnm");
    String str3 = paramIntent.getStringExtra("mp_icnm_l");
    String str4 = paramIntent.getStringExtra("mp_icnm_w");
    String str5 = paramIntent.getStringExtra("mp_cta");
    Object localObject1 = paramIntent.getStringExtra("mp_title");
    String str6 = paramIntent.getStringExtra("mp_color");
    String str7 = paramIntent.getStringExtra("mp_campaign_id");
    String str8 = paramIntent.getStringExtra("mp_message_id");
    String str9 = paramIntent.getStringExtra("mp");
    int i = -1;
    a(str7, str8, str9);
    if (str6 != null);
    try
    {
      int i1 = Color.parseColor(str6);
      i = i1;
      if (str1 == null)
        return null;
      j = -1;
      if ((str2 != null) && (paramo.a(str2)))
        j = paramo.b(str2);
      if ((str3 != null) && (paramo.a(str3)))
      {
        k = paramo.b(str3);
        if ((str4 != null) && (paramo.a(str4)))
        {
          m = paramo.b(str4);
          try
          {
            ApplicationInfo localApplicationInfo2 = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
            localApplicationInfo1 = localApplicationInfo2;
            if ((j == -1) && (localApplicationInfo1 != null))
              j = localApplicationInfo1.icon;
            if (j == -1)
            {
              n = 17301651;
              if ((localObject1 == null) && (localApplicationInfo1 != null))
                localObject1 = localPackageManager.getApplicationLabel(localApplicationInfo1);
              if (localObject1 == null)
              {
                localObject2 = "A message for you";
                Intent localIntent = a(paramContext, str5, str7, str8, str9);
                return new a(n, k, m, (CharSequence)localObject2, str1, localIntent, i, null);
              }
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            while (true)
              ApplicationInfo localApplicationInfo1 = null;
          }
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        int j;
        continue;
        Object localObject2 = localObject1;
        continue;
        int n = j;
        continue;
        int m = -1;
        continue;
        int k = -1;
      }
    }
  }

  @TargetApi(11)
  protected Notification b(Context paramContext, PendingIntent paramPendingIntent, a parama)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext).setSmallIcon(parama.a).setTicker(parama.e).setWhen(System.currentTimeMillis()).setContentTitle(parama.d).setContentText(parama.e).setContentIntent(paramPendingIntent).setDefaults(i.a(paramContext).u());
    if (parama.b != -1)
      localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), parama.b));
    Notification localNotification = localBuilder.getNotification();
    localNotification.flags = (0x10 | localNotification.flags);
    return localNotification;
  }

  @SuppressLint({"NewApi"})
  @TargetApi(16)
  protected Notification c(Context paramContext, PendingIntent paramPendingIntent, a parama)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext).setSmallIcon(parama.a).setTicker(parama.e).setWhen(System.currentTimeMillis()).setContentTitle(parama.d).setContentText(parama.e).setContentIntent(paramPendingIntent).setStyle(new Notification.BigTextStyle().bigText(parama.e)).setDefaults(i.a(paramContext).u());
    if (parama.b != -1)
      localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), parama.b));
    Notification localNotification = localBuilder.build();
    localNotification.flags = (0x10 | localNotification.flags);
    return localNotification;
  }

  @SuppressLint({"NewApi"})
  @TargetApi(21)
  protected Notification d(Context paramContext, PendingIntent paramPendingIntent, a parama)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext).setTicker(parama.e).setWhen(System.currentTimeMillis()).setContentTitle(parama.d).setContentText(parama.e).setContentIntent(paramPendingIntent).setStyle(new Notification.BigTextStyle().bigText(parama.e)).setDefaults(i.a(paramContext).u());
    if (parama.c != -1)
      localBuilder.setSmallIcon(parama.c);
    while (true)
    {
      if (parama.b != -1)
        localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), parama.b));
      if (parama.g != -1)
        localBuilder.setColor(parama.g);
      Notification localNotification = localBuilder.build();
      localNotification.flags = (0x10 | localNotification.flags);
      return localNotification;
      localBuilder.setSmallIcon(parama.a);
    }
  }

  @SuppressLint({"NewApi"})
  @TargetApi(26)
  protected Notification e(Context paramContext, PendingIntent paramPendingIntent, a parama)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    String str = i.a(paramContext).x();
    NotificationChannel localNotificationChannel = new NotificationChannel(str, i.a(paramContext).y(), i.a(paramContext).z());
    int i = i.a(paramContext).u();
    if ((i == 2) || (i == -1))
      localNotificationChannel.enableVibration(true);
    if ((i == 4) || (i == -1))
    {
      localNotificationChannel.enableLights(true);
      localNotificationChannel.setLightColor(-1);
    }
    localNotificationManager.createNotificationChannel(localNotificationChannel);
    Notification.Builder localBuilder = new Notification.Builder(paramContext).setTicker(parama.e).setWhen(System.currentTimeMillis()).setContentTitle(parama.d).setContentText(parama.e).setContentIntent(paramPendingIntent).setStyle(new Notification.BigTextStyle().bigText(parama.e)).setChannelId(str);
    if (parama.c != -1)
      localBuilder.setSmallIcon(parama.c);
    while (true)
    {
      if (parama.b != -1)
        localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), parama.b));
      if (parama.g != -1)
        localBuilder.setColor(parama.g);
      Notification localNotification = localBuilder.build();
      localNotification.flags = (0x10 | localNotification.flags);
      return localNotification;
      localBuilder.setSmallIcon(parama.a);
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.google.android.c2dm.intent.REGISTRATION".equals(str))
      a(paramIntent);
    while (!"com.google.android.c2dm.intent.RECEIVE".equals(str))
      return;
    a(paramContext, paramIntent);
  }

  protected static class a
  {
    public final int a;
    public final int b;
    public final int c;
    public final CharSequence d;
    public final String e;
    public final Intent f;
    public final int g;

    private a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence, String paramString, Intent paramIntent, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramCharSequence;
      this.e = paramString;
      this.f = paramIntent;
      this.g = paramInt4;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.GCMReceiver
 * JD-Core Version:    0.6.2
 */
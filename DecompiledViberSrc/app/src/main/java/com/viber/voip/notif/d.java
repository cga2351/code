package com.viber.voip.notif;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ag;
import com.viber.voip.sound.RingtoneProvider;
import com.viber.voip.util.dk;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;

  public d(Context paramContext)
  {
    this.b = paramContext;
  }

  @TargetApi(26)
  private NotificationChannel a(b paramb, NotificationChannel paramNotificationChannel)
  {
    NotificationChannel localNotificationChannel = new NotificationChannel(paramb.b(), paramNotificationChannel.getName(), paramNotificationChannel.getImportance());
    localNotificationChannel.setDescription(paramNotificationChannel.getDescription());
    localNotificationChannel.setSound(paramNotificationChannel.getSound(), paramNotificationChannel.getAudioAttributes());
    localNotificationChannel.setVibrationPattern(paramNotificationChannel.getVibrationPattern());
    localNotificationChannel.enableVibration(paramNotificationChannel.shouldVibrate());
    localNotificationChannel.setLightColor(paramNotificationChannel.getLightColor());
    localNotificationChannel.enableLights(paramNotificationChannel.shouldShowLights());
    localNotificationChannel.setShowBadge(paramNotificationChannel.canShowBadge());
    localNotificationChannel.setBypassDnd(paramNotificationChannel.canBypassDnd());
    localNotificationChannel.setLockscreenVisibility(paramNotificationChannel.getLockscreenVisibility());
    String str = paramNotificationChannel.getGroup();
    if (str != null)
      localNotificationChannel.setGroup(str);
    return localNotificationChannel;
  }

  @TargetApi(26)
  private void a(int paramInt1, int paramInt2, f paramf)
  {
    if (a(paramInt1, paramInt2, 1))
    {
      a(new b("messages"), c.a, paramf);
      a(new b("mentions"), c.b, paramf);
    }
    if (a(paramInt1, paramInt2, 2))
      b(new b("system"), c.f, paramf);
    b localb;
    NotificationChannel localNotificationChannel1;
    if (a(paramInt1, paramInt2, 3))
    {
      localb = new b("calls");
      localNotificationChannel1 = paramf.b(localb.b());
      if (localNotificationChannel1 != null);
    }
    else
    {
      return;
    }
    NotificationChannel localNotificationChannel2 = a(c.e.h, localNotificationChannel1);
    localNotificationChannel2.setSound(null, null);
    localNotificationChannel2.enableVibration(false);
    localNotificationChannel2.setImportance(4);
    paramf.a(localb.b());
    paramf.a(localNotificationChannel2);
  }

  @TargetApi(26)
  private void a(b paramb, c paramc, f paramf)
  {
    NotificationChannel localNotificationChannel1 = paramf.b(paramb.b());
    if (localNotificationChannel1 == null)
      return;
    boolean bool1 = dk.e(localNotificationChannel1.getSound());
    Uri localUri = null;
    String str;
    if (bool1)
    {
      str = paramc.c(this.b);
      boolean bool2 = TextUtils.isEmpty(str);
      localUri = null;
      if (!bool2)
        break label103;
    }
    while (true)
    {
      NotificationChannel localNotificationChannel2 = a(paramc.h, localNotificationChannel1);
      if (localUri != null)
        localNotificationChannel2.setSound(localUri, localNotificationChannel2.getAudioAttributes());
      paramf.a(paramb.b());
      paramf.a(localNotificationChannel2);
      return;
      label103: localUri = RingtoneProvider.getNotificationContentUri(str);
    }
  }

  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 < paramInt3) && (paramInt2 >= paramInt3);
  }

  private void b(b paramb, c paramc, f paramf)
  {
    paramf.a(paramb.b());
    paramc.a(this.b, paramf);
  }

  public void a(f paramf)
  {
    if (!a.m());
    int i;
    do
    {
      return;
      if (!d.ag.m.a())
      {
        d.ag.m.a(3);
        return;
      }
      i = d.ag.m.d();
    }
    while (3 <= i);
    a(i, 3, paramf);
    d.ag.m.a(3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d
 * JD-Core Version:    0.6.2
 */
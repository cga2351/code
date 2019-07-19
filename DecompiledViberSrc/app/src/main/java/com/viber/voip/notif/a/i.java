package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Action.Extender;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.ViberActionRunner.am;
import com.viber.voip.util.ViberActionRunner.ap;

public class i extends com.viber.voip.notif.a.a.a
{
  private final h c;
  private final com.viber.voip.model.entity.m d;
  private final MessageEntity e;
  private String f;
  private int g;

  i(com.viber.voip.notif.h.m paramm, String paramString, int paramInt)
  {
    this.c = paramm.e();
    this.d = paramm.d();
    this.e = paramm.c();
    this.f = paramString;
    this.g = paramInt;
  }

  private void a(Intent paramIntent)
  {
    paramIntent.putExtra("notification_tag", this.f);
    paramIntent.putExtra("notification_id", this.g);
  }

  protected int a()
  {
    return R.drawable.ic_action_message_reply;
  }

  protected Intent a(Context paramContext)
  {
    if (com.viber.common.d.a.k());
    for (Intent localIntent = ViberActionRunner.am.a(paramContext, this.c, this.d, this.e); ; localIntent = ViberActionRunner.ap.a(this.c, true))
    {
      a(localIntent);
      return localIntent;
    }
  }

  protected int b()
  {
    return R.string.wear_action_voice_reply;
  }

  protected Intent b(Context paramContext)
  {
    Intent localIntent = ViberActionRunner.am.a(paramContext, this.c, this.d, this.e);
    a(localIntent);
    return localIntent;
  }

  protected void c(Context paramContext)
  {
    if (com.viber.common.d.a.k())
    {
      NotificationCompat.Action.Extender[] arrayOfExtender = new NotificationCompat.Action.Extender[1];
      arrayOfExtender[0] = com.viber.voip.notif.a.b.a.a(paramContext, b(), false);
      a(arrayOfExtender);
    }
  }

  protected int d()
  {
    return (int)this.c.getId();
  }

  protected void d(Context paramContext)
  {
    NotificationCompat.Action.Extender[] arrayOfExtender = new NotificationCompat.Action.Extender[1];
    arrayOfExtender[0] = com.viber.voip.notif.a.b.a.a(paramContext, b(), true);
    b(arrayOfExtender);
  }

  protected int e()
  {
    if (com.viber.common.d.a.k())
      return 0;
    return 2;
  }

  protected int f()
  {
    return R.drawable.ic_action_wear_message_reply;
  }

  protected int g()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.i
 * JD-Core Version:    0.6.2
 */
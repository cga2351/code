package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Action.Extender;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.ViberActionRunner.am;

public class f extends com.viber.voip.notif.a.a.a
{
  private final Member c;
  private final MessageEntity d;

  f(Member paramMember, MessageEntity paramMessageEntity)
  {
    this.c = paramMember;
    this.d = paramMessageEntity;
  }

  protected int a()
  {
    return R.drawable.ic_action_message;
  }

  protected Intent a(Context paramContext)
  {
    if (com.viber.common.d.a.k())
      return ViberActionRunner.am.a(paramContext, this.c, this.d);
    return m.a(-1L, -1L, this.c.getId(), this.c.getPhoneNumber(), 0, this.c.getViberName(), true, false, false, false, false);
  }

  protected int b()
  {
    return R.string.message;
  }

  protected Intent b(Context paramContext)
  {
    return ViberActionRunner.am.a(paramContext, this.c, this.d);
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
    return this.c.getId().hashCode();
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
    return R.drawable.ic_action_wear_message;
  }

  protected int g()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.f
 * JD-Core Version:    0.6.2
 */
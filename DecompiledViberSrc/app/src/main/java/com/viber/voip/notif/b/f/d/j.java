package com.viber.voip.notif.b.f.d;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.c.t;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.ca;
import com.viber.voip.util.dg;

public class j extends d
{
  public j(m paramm)
  {
    super(paramm);
  }

  public String R_()
  {
    return "you_mentioned_in_reply" + this.a.c().getId();
  }

  protected t b(Context paramContext, o paramo)
  {
    return paramo.a(b_(paramContext), b(paramContext));
  }

  public CharSequence b(Context paramContext)
  {
    String str = dg.a(this.a.d(), this.a.e().j(), this.a.e().p());
    int i = R.string.reply_notification_with_mention_body;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ca.a(str, "");
    return com.viber.common.d.c.a(paramContext, i, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.message_notification_new_message);
  }

  public com.viber.voip.notif.c d()
  {
    return com.viber.voip.notif.c.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.j
 * JD-Core Version:    0.6.2
 */
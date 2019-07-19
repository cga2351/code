package com.viber.voip.notif.b.f.d;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;

public class i extends d
{
  public i(m paramm)
  {
    super(paramm);
  }

  public String R_()
  {
    return "you_mentioned" + this.a.c().getId();
  }

  public CharSequence b(Context paramContext)
  {
    String str = dg.b(this.a.e().o());
    int i = R.string.message_notification_you_mentioned;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = str;
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
 * Qualified Name:     com.viber.voip.notif.b.f.d.i
 * JD-Core Version:    0.6.2
 */
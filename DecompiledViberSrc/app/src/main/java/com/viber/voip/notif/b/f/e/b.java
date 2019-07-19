package com.viber.voip.notif.b.f.e;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.b.f.a;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;

abstract class b extends a
{
  b(m paramm)
  {
    super(paramm, null);
  }

  public String R_()
  {
    return "missed_call";
  }

  public int a()
  {
    return -150;
  }

  protected void a(Context paramContext, o paramo)
  {
    super.a(paramContext, paramo);
    if (this.a.j() > 1)
      a(paramo.a(String.valueOf(this.a.j())));
  }

  public int b()
  {
    return R.drawable.status_missed;
  }

  public CharSequence b_(Context paramContext)
  {
    if (this.a.j() > 1)
    {
      int i = R.string.sms_notification_missed_calls_ticker;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.toString(this.a.j());
      return paramContext.getString(i, arrayOfObject);
    }
    return dg.a(this.a.c().getBody(), 1);
  }

  public c d()
  {
    return c.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.e.b
 * JD-Core Version:    0.6.2
 */
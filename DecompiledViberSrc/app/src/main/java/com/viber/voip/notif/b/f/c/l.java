package com.viber.voip.notif.b.f.c;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.f.c;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.c.t;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;

public class l extends c
{
  public l(m paramm)
  {
    super(paramm, null);
  }

  protected void a(Context paramContext, g paramg)
  {
  }

  protected t b(Context paramContext, o paramo)
  {
    int i;
    Object[] arrayOfObject;
    if (this.a.e().b())
    {
      i = R.string.message_spam_notification_group_ticker;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = this.c;
      arrayOfObject[1] = b_(paramContext);
    }
    for (Object localObject = paramContext.getString(i, arrayOfObject); ; localObject = b(paramContext))
      return paramo.b((CharSequence)localObject);
  }

  public CharSequence b(Context paramContext)
  {
    if (this.a.e().b())
    {
      int j = R.string.message_spam_notification_group_text;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.c;
      return paramContext.getString(j, arrayOfObject2);
    }
    int i = R.string.message_spam_notification_text;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.c;
    return paramContext.getString(i, arrayOfObject1);
  }

  public CharSequence b_(Context paramContext)
  {
    if (this.a.e().b())
      return dg.b(this.a.e().o());
    return this.c;
  }

  protected Intent c(Context paramContext)
  {
    return e(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.l
 * JD-Core Version:    0.6.2
 */
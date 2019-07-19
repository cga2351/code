package com.viber.voip.notif.b.e;

import android.content.Context;
import com.viber.common.d.c;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.m;
import com.viber.voip.notif.h.g;
import com.viber.voip.util.ca;
import com.viber.voip.util.dg;

public class e extends d
{
  public e(g paramg)
  {
    super(paramg);
  }

  public String R_()
  {
    return "vote";
  }

  public int a()
  {
    return -225;
  }

  protected CharSequence h(Context paramContext)
  {
    h localh = this.a.c();
    if (this.a.g() == 1)
    {
      String str2 = this.a.b().a(localh.e(), localh.p());
      String str3 = this.a.l();
      int j = R.string.message_notification_option_vote;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = ca.a(str2, "");
      arrayOfObject2[1] = ca.a(str3, "");
      return c.a(paramContext, j, arrayOfObject2);
    }
    String str1 = dg.b(localh.o());
    int i = R.string.message_notification_option_votes;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ca.a(str1, "");
    return c.a(paramContext, i, arrayOfObject1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.e.e
 * JD-Core Version:    0.6.2
 */
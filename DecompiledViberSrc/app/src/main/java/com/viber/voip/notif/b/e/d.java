package com.viber.voip.notif.b.e;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.j;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.e;
import com.viber.voip.notif.h.g;
import com.viber.voip.util.ViberActionRunner.am;
import com.viber.voip.util.ca;
import com.viber.voip.util.dg;

public class d extends com.viber.voip.notif.b.b
{
  protected final g a;
  private CharSequence b;
  private CharSequence c;

  public d(g paramg)
  {
    this.a = paramg;
  }

  private Intent e()
  {
    h localh = this.a.c();
    int i = this.a.g();
    long l1 = localh.getId();
    long l2;
    if (i == 1)
    {
      l2 = this.a.j();
      if (i != 1)
        break label90;
    }
    label90: for (long l3 = this.a.k(); ; l3 = 0L)
    {
      return com.viber.voip.messages.m.a(l1, l2, l3, localh.k(), null, null, localh.j(), null, true, -1, localh.R(), localh.aj(), localh.ao(), false);
      l2 = 0L;
      break;
    }
  }

  private String f()
  {
    return "tel:" + this.a.b().getNumber();
  }

  public String R_()
  {
    return "like";
  }

  public int a()
  {
    return -130;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[7];
    arrayOfn[0] = paramo.a(b_(paramContext), b(paramContext));
    arrayOfn[1] = paramo.a(false);
    arrayOfn[2] = paramo.a(this.a.d().e());
    arrayOfn[3] = b(paramContext, paramo);
    arrayOfn[4] = c(paramContext, paramo);
    arrayOfn[5] = paramo.c(f());
    arrayOfn[6] = paramo.b("msg");
    a(arrayOfn);
  }

  protected void a(Context paramContext, o paramo, e parame)
  {
    a(paramo.a(((com.viber.voip.notif.f.b)parame.a(3)).a(this.a.c(), this.a.b())));
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  protected n b(Context paramContext, o paramo)
  {
    return paramo.b(paramContext, a(), e(), 134217728);
  }

  public final CharSequence b(Context paramContext)
  {
    if (this.c == null)
      this.c = h(paramContext);
    return this.c;
  }

  public final CharSequence b_(Context paramContext)
  {
    if (this.b == null)
      this.b = c(paramContext);
    return this.b;
  }

  protected n c(Context paramContext, o paramo)
  {
    return paramo.a(paramContext, a(), ViberActionRunner.am.a(paramContext, this.a.e()), 134217728);
  }

  protected CharSequence c(Context paramContext)
  {
    return dg.b(this.a.c().o());
  }

  public com.viber.voip.notif.c d()
  {
    return com.viber.voip.notif.c.a;
  }

  protected CharSequence h(Context paramContext)
  {
    h localh = this.a.c();
    String str1 = dg.b(localh.o());
    if (this.a.g() == 1)
    {
      String str2 = this.a.b().a(localh.e(), localh.p());
      int j = R.string.notification_single_like_text;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = ca.a(str2, "");
      arrayOfObject2[1] = ca.a(str1, "");
      return com.viber.common.d.c.a(paramContext, j, arrayOfObject2);
    }
    int i = R.string.notification_many_likes_text;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ca.a(str1, "");
    return com.viber.common.d.c.a(paramContext, i, arrayOfObject1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.e.d
 * JD-Core Version:    0.6.2
 */
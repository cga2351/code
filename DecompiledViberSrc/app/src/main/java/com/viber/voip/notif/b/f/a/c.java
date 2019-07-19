package com.viber.voip.notif.b.f.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.m;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.e;
import com.viber.voip.notif.f.h;
import com.viber.voip.util.dg;

public class c extends b
{
  private final com.viber.voip.notif.h.c a;
  private final Member b;
  private final long c;

  public c(com.viber.voip.notif.h.c paramc, Member paramMember, int paramInt)
  {
    this.a = paramc;
    this.b = paramMember;
    this.c = paramInt;
  }

  private Intent e()
  {
    return m.a(this.a.a(), 0L, 0L, this.a.b(), null, null, 5, null, null, this.a.c(), 0, false, true, false, false, false);
  }

  public String R_()
  {
    return "you_mentioned" + this.c;
  }

  public int a()
  {
    return (int)this.a.a();
  }

  protected void a(Context paramContext, o paramo)
  {
    int i = 13 * (int)this.a.a();
    n[] arrayOfn = new n[2];
    arrayOfn[0] = paramo.b(paramContext, i, e(), 134217728);
    arrayOfn[1] = paramo.b("msg");
    a(arrayOfn);
  }

  protected void a(Context paramContext, o paramo, e parame)
  {
    a(paramo.a(((h)parame.a(2)).a(this.a.d(), R.drawable.ic_community_default)));
  }

  public int b()
  {
    return R.drawable.ic_system_notification_group;
  }

  public CharSequence b(Context paramContext)
  {
    int i = R.string.message_notification_you_mentioned;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b.getViberName();
    arrayOfObject[1] = dg.b(this.a.c());
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

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.a.c
 * JD-Core Version:    0.6.2
 */
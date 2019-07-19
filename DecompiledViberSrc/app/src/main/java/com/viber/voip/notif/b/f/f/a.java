package com.viber.voip.notif.b.f.f;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.h.m;

public class a extends com.viber.voip.notif.b.f.c
{
  private final int h;
  private final int i;
  private final int j;

  private a(m paramm, com.viber.voip.notif.b.f.b.e parame, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramm, parame);
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
  }

  public static a a(m paramm, com.viber.voip.notif.b.f.b.e parame)
  {
    return new a(paramm, parame, R.drawable.status_unread_message, R.drawable.icon_viber_message, R.drawable.ic_wear_system_message);
  }

  public static a b(m paramm, com.viber.voip.notif.b.f.b.e parame)
  {
    return new a(paramm, parame, R.drawable.ic_rakuten_system_notification, R.drawable.ic_rakuten_message, R.drawable.ic_wear_rakuten_message);
  }

  public int a()
  {
    return (int)this.a.e().getId();
  }

  protected void a(Context paramContext, g paramg)
  {
  }

  protected void a(Context paramContext, o paramo, com.viber.voip.notif.f.e parame)
  {
    com.viber.voip.notif.f.c localc = (com.viber.voip.notif.f.c)parame.a(1);
    n[] arrayOfn = new n[1];
    arrayOfn[0] = paramo.a(localc.a(this.i, this.j));
    a(arrayOfn);
  }

  public int b()
  {
    return this.h;
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.f.a
 * JD-Core Version:    0.6.2
 */
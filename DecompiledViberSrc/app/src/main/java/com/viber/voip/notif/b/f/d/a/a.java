package com.viber.voip.notif.b.f.d.a;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.e;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;

public class a extends d
{
  private final CharSequence h;
  private final String i;

  private a(com.viber.voip.notif.h.m paramm, CharSequence paramCharSequence, String paramString)
  {
    super(paramm);
    this.h = paramCharSequence;
    this.i = paramString;
  }

  public static a a(com.viber.voip.notif.h.m paramm)
  {
    return new a(paramm, da.f(dg.a(paramm.d(), paramm.e().j(), paramm.e().p()), dg.b(paramm.e().o())), "join");
  }

  public static a b(com.viber.voip.notif.h.m paramm)
  {
    return new a(paramm, da.k(dg.a(paramm.d(), paramm.e().j(), paramm.e().p())), "join_by_link");
  }

  public String R_()
  {
    return this.i;
  }

  protected n b(Context paramContext, o paramo, e parame)
  {
    return paramo.a(((com.viber.voip.notif.f.h)parame.a(2)).a(this.a.d().p(), this.a.d().a(this.a.e()), R.drawable.generic_image_thirty_x_thirty));
  }

  public CharSequence b(Context paramContext)
  {
    return this.h;
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.a.a
 * JD-Core Version:    0.6.2
 */
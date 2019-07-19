package com.viber.voip.notif.b.f.d.a;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.e;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;

public class b extends d
{
  private String h;
  private String i;
  private String j;

  public b(m paramm, String paramString1, String paramString2)
  {
    super(paramm);
    this.h = dg.b(paramm.e().o());
    this.i = paramString1;
    this.j = paramString2;
  }

  public String R_()
  {
    return "join";
  }

  protected n b(Context paramContext, o paramo, e parame)
  {
    return paramo.a(((com.viber.voip.notif.f.b)parame.a(3)).a(this.a.e(), null));
  }

  public CharSequence b(Context paramContext)
  {
    return da.g(this.j, this.h);
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }

  public CharSequence f(Context paramContext)
  {
    return this.i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.a.b
 * JD-Core Version:    0.6.2
 */
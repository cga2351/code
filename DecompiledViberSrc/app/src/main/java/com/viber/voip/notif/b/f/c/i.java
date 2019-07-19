package com.viber.voip.notif.b.f.c;

import android.content.Context;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.f.b.e;
import com.viber.voip.notif.b.f.c;
import com.viber.voip.notif.h.m;
import com.viber.voip.q.k;
import com.viber.voip.util.ae;

public class i extends c
{
  public i(m paramm, e parame)
  {
    super(paramm, parame);
  }

  private CharSequence a(CharSequence paramCharSequence)
  {
    long l = this.a.c().getDuration();
    return new StringBuilder(paramCharSequence).append(" (").append(ae.f(k.b(l))).append(")");
  }

  protected void a(Context paramContext, g paramg)
  {
    super.a(paramContext, paramg);
    a(paramg.b(this.a));
  }

  public CharSequence b(Context paramContext)
  {
    if (this.a.e().a())
      return a(super.b(paramContext));
    return super.b(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.i
 * JD-Core Version:    0.6.2
 */
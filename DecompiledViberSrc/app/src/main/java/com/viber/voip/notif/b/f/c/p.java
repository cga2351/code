package com.viber.voip.notif.b.f.c;

import android.content.Context;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.f.b;
import com.viber.voip.notif.d.f.a;
import com.viber.voip.notif.h.m;

public class p extends b
{
  public p(m paramm, com.viber.voip.notif.b.f.b.e parame)
  {
    super(paramm, parame);
  }

  public f.a a(Context paramContext)
  {
    return new f.a(com.viber.voip.util.e.e.a(paramContext, this.a.c().getThumbnailUri(), false), false);
  }

  protected void a(Context paramContext, g paramg)
  {
    super.a(paramContext, paramg);
    a(paramg.a(this.a));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.p
 * JD-Core Version:    0.6.2
 */
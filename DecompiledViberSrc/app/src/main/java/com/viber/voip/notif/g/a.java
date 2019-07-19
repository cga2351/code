package com.viber.voip.notif.g;

import android.content.Context;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.b.g;
import com.viber.voip.notif.b.f.b.p;
import com.viber.voip.notif.h.d;

public class a
{
  private final Context a;
  private final p b;
  private final dagger.a<b> c;

  public a(Context paramContext, p paramp, dagger.a<b> parama)
  {
    this.a = paramContext;
    this.b = paramp;
    this.c = parama;
  }

  public com.viber.voip.notif.d.e a(h paramh, Member paramMember, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      return new com.viber.voip.notif.b.f.a.c(com.viber.voip.notif.h.c.a(paramh), paramMember, paramInt);
    return null;
  }

  public com.viber.voip.notif.d.e a(d paramd, e parame)
  {
    if (paramd.v())
    {
      String str = ((b)this.c.get()).a(paramd.i(), 5, paramd.k());
      return new com.viber.voip.notif.b.f.a.c(com.viber.voip.notif.h.c.a(paramd), new Member(paramd.i(), paramd.i(), null, str, null, null, paramd.i()), paramd.q());
    }
    return new com.viber.voip.notif.b.f.a.a(paramd, this.b.a(this.a, paramd).a(parame.a()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.g.a
 * JD-Core Version:    0.6.2
 */
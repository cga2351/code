package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.da;
import dagger.a;

class r extends s
{
  public r(Context paramContext, m paramm, q.a parama, a<aj> parama1, h paramh)
  {
    super(paramContext, paramm, parama, parama1, paramh);
  }

  public e a(boolean paramBoolean)
  {
    e locale = super.a(paramBoolean);
    if (paramBoolean)
    {
      String str = da.d(locale.b().toString(), this.j).toString();
      boolean bool = da.a(this.j);
      CharSequence localCharSequence = null;
      if (!bool)
        localCharSequence = da.a(null, this.j, this.d);
      return new e(locale.a(), str, locale.c(), localCharSequence, true);
    }
    return locale;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.r
 * JD-Core Version:    0.6.2
 */
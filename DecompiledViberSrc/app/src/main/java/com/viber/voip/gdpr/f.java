package com.viber.voip.gdpr;

import android.content.Context;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.v;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;

  private f(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }

  public static f a(Context paramContext)
  {
    return new f(paramContext);
  }

  public void a(int paramInt)
  {
    d.v.i.e();
    d.v.h.a(paramInt);
  }

  public void a(long paramLong)
  {
    d.v.i.a(paramLong);
    a(false);
  }

  public void a(boolean paramBoolean)
  {
    long l = d.v.i.d();
    e locale;
    if (l != d.v.i.f())
    {
      locale = e.a(l);
      if (!locale.c())
        break label74;
    }
    label74: for (int i = 1; ; i = 2)
    {
      if (i != d.v.h.d())
        d.v.h.a(i);
      if ((locale.c()) && (paramBoolean))
        GdprUserBirthdayWatcher.a(this.b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.f
 * JD-Core Version:    0.6.2
 */
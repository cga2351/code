package com.viber.voip.backup.ui.promotion;

import android.content.Context;
import com.viber.common.b.d;
import com.viber.voip.backup.a;
import com.viber.voip.backup.l;
import com.viber.voip.settings.d.j;
import com.viber.voip.util.ViberActionRunner.h;
import com.viber.voip.util.cc;
import java.util.concurrent.TimeUnit;

public class e
{
  private static final long a = TimeUnit.DAYS.toMillis(14L);
  private final Context b;
  private final com.viber.common.b.e c;
  private final com.viber.common.b.e d;
  private final d e;

  public e(Context paramContext)
  {
    this(paramContext, d.j.g, d.j.h, d.j.i);
  }

  e(Context paramContext, com.viber.common.b.e parame1, com.viber.common.b.e parame2, d paramd)
  {
    this.b = paramContext;
    this.c = parame1;
    this.d = parame2;
    this.e = paramd;
  }

  public void a(long paramLong)
  {
    int i = cc.b();
    if ((this.e.d() < i) && (!a.a(this.c.d()).b()) && (paramLong - this.d.d() > a) && (l.a(this.b)))
    {
      this.e.a(i);
      this.d.a(paramLong);
      ViberActionRunner.h.b(this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.promotion.e
 * JD-Core Version:    0.6.2
 */
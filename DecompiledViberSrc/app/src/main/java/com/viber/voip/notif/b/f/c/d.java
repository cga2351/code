package com.viber.voip.notif.b.f.c;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.notif.b.a;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.ab;
import org.jetbrains.annotations.NotNull;

public class d extends a
{
  private long a;

  public d(long paramLong)
  {
    this.a = paramLong;
  }

  public String R_()
  {
    return "message";
  }

  public int a()
  {
    return -101;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[3];
    arrayOfn[0] = paramo.b(b(paramContext));
    arrayOfn[1] = paramo.a(c());
    arrayOfn[2] = paramo.b(paramContext, a(), ViberActionRunner.ab.a(paramContext), 134217728);
    a(arrayOfn);
  }

  protected long c()
  {
    return this.a;
  }

  @NotNull
  protected Intent c(Context paramContext)
  {
    return new Intent();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.d
 * JD-Core Version:    0.6.2
 */
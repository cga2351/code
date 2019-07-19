package com.viber.voip.notif.b.d.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;

public abstract class a extends b
{
  private final int a;

  protected a(int paramInt)
  {
    this.a = paramInt;
  }

  public int a()
  {
    return this.a;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[2];
    arrayOfn[0] = paramo.b(b(paramContext));
    arrayOfn[1] = paramo.b(paramContext, a(), c(paramContext), 268435456);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  protected abstract Intent c(Context paramContext);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.d.a.a
 * JD-Core Version:    0.6.2
 */
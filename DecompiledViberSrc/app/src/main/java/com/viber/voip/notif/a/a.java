package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.i.i;
import com.viber.voip.util.ViberActionRunner.r;

public class a extends com.viber.voip.notif.a.a.a
{
  private final boolean c;
  private final boolean d;

  a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }

  protected int a()
  {
    return R.drawable.ic_action_call;
  }

  protected Intent a(Context paramContext)
  {
    return ViberActionRunner.r.a(paramContext, this.c, this.d);
  }

  protected int b()
  {
    return R.string.notification_accept_call;
  }

  protected int c()
  {
    return R.color.p_green_alt;
  }

  protected int d()
  {
    return i.d(100);
  }

  protected int e()
  {
    return 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.a
 * JD-Core Version:    0.6.2
 */
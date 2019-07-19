package com.viber.voip.notif.b.e;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.model.entity.j;
import com.viber.voip.notif.b.a;
import com.viber.voip.notif.h.g;
import com.viber.voip.util.ViberActionRunner.am;

public class c extends a
{
  private final g a;

  public c(g paramg)
  {
    this.a = paramg;
  }

  public String R_()
  {
    return "like";
  }

  public int a()
  {
    return -135;
  }

  protected long c()
  {
    return this.a.d().e();
  }

  protected Intent c(Context paramContext)
  {
    return ViberActionRunner.am.a(paramContext, this.a.e());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.e.c
 * JD-Core Version:    0.6.2
 */
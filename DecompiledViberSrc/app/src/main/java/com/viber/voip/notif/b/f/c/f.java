package com.viber.voip.notif.b.f.c;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.b.a;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.ViberActionRunner.am;

public class f extends a
{
  private final m a;

  public f(m paramm)
  {
    this.a = paramm;
  }

  public String R_()
  {
    return "message";
  }

  public int a()
  {
    return -140;
  }

  protected long c()
  {
    return this.a.c().getDate();
  }

  protected Intent c(Context paramContext)
  {
    return ViberActionRunner.am.b(paramContext, this.a.g());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.f
 * JD-Core Version:    0.6.2
 */
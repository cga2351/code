package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.a.a.a;
import com.viber.voip.notif.i.i;
import com.viber.voip.util.ViberActionRunner.r;

public class h extends a
{
  protected int a()
  {
    return R.drawable.ic_action_call;
  }

  protected Intent a(Context paramContext)
  {
    return ViberActionRunner.r.a(paramContext);
  }

  protected int b()
  {
    return R.string.notification_reject_call;
  }

  protected int c()
  {
    return R.color.p_red_alt;
  }

  protected int d()
  {
    return i.d(101);
  }

  protected int e()
  {
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.h
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.notif.b.h;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.au;

public class c extends b
{
  public int a()
  {
    return -110;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[1];
    arrayOfn[0] = paramo.a(paramContext, 0, ViberActionRunner.au.b(paramContext), 0, true);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return paramContext.getText(R.string.registration_in_progress);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.h.c
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.notif.b.h;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.au;

public class a extends b
{
  private final String a;

  public a(String paramString)
  {
    this.a = paramString;
  }

  private Intent c(Context paramContext)
  {
    Intent localIntent = ViberActionRunner.au.a(paramContext);
    localIntent.setAction("com.viber.voip.action.REGISTRATION_REMINDER_CANCELED_ACTION");
    return localIntent;
  }

  private Intent h(Context paramContext)
  {
    Intent localIntent = ViberActionRunner.au.b(paramContext);
    localIntent.putExtra("registration_reminder_message", true);
    return localIntent;
  }

  public String R_()
  {
    return "registration_reminder";
  }

  public int a()
  {
    return -170;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[2];
    arrayOfn[0] = paramo.a(paramContext, R_().hashCode(), c(paramContext), 134217728);
    arrayOfn[1] = paramo.b(paramContext, a(), h(paramContext), 0);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return this.a;
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.h.a
 * JD-Core Version:    0.6.2
 */
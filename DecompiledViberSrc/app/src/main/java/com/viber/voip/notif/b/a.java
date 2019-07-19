package com.viber.voip.notif.b;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.e;
import com.viber.voip.util.ViberActionRunner.ab;

public abstract class a extends b
{
  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[4];
    arrayOfn[0] = paramo.b(b(paramContext));
    arrayOfn[1] = paramo.a(c());
    arrayOfn[2] = paramo.b(paramContext, a(), ViberActionRunner.ab.a(paramContext), 134217728);
    arrayOfn[3] = paramo.a(paramContext, a(), c(paramContext), 134217728);
    a(arrayOfn);
  }

  protected void a(Context paramContext, o paramo, e parame)
  {
    com.viber.voip.notif.f.c localc = (com.viber.voip.notif.f.c)parame.a(1);
    n[] arrayOfn = new n[1];
    arrayOfn[0] = paramo.a(localc.a(R.drawable.icon_viber_message, R.drawable.ic_wear_system_message));
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return paramContext.getString(R.string.hidden_chat_notification_message);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.system_contact_name);
  }

  protected abstract long c();

  protected abstract Intent c(Context paramContext);

  public com.viber.voip.notif.c d()
  {
    return com.viber.voip.notif.c.a;
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.a
 * JD-Core Version:    0.6.2
 */
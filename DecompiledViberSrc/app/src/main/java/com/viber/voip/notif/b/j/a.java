package com.viber.voip.notif.b.j;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.am;
import com.viber.voip.util.ViberActionRunner.bq;

public class a extends b
{
  public int a()
  {
    return -180;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[3];
    arrayOfn[0] = paramo.b(b(paramContext));
    arrayOfn[1] = paramo.b(paramContext, a(), ViberActionRunner.bq.c(paramContext), 268435456);
    arrayOfn[2] = paramo.a(paramContext, 0, ViberActionRunner.am.a(paramContext), 134217728);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return paramContext.getText(R.string.notification_approve_sync_history_desktop_message);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getText(R.string.notification_approve_sync_history_desktop_title);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.j.a
 * JD-Core Version:    0.6.2
 */
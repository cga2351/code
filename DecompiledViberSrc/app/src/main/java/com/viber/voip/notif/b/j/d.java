package com.viber.voip.notif.b.j;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.bq;

public class d extends b
{
  public int a()
  {
    return -190;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[2];
    arrayOfn[0] = paramo.b(b(paramContext));
    arrayOfn[1] = paramo.b(paramContext, a(), ViberActionRunner.bq.d(paramContext), 268435456);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return paramContext.getString(R.string.dialog_syncing_history_desktop_message);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.dialog_syncing_history_desktop_title);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.j.d
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.notif.b.j;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.h;

public class c extends b
{
  private final int a;

  public c(int paramInt)
  {
    this.a = paramInt;
  }

  public int a()
  {
    return -210;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[5];
    arrayOfn[0] = paramo.b(true);
    arrayOfn[1] = paramo.a(false);
    arrayOfn[2] = paramo.a(100, this.a);
    arrayOfn[3] = paramo.a(this.a + "%");
    arrayOfn[4] = paramo.b(paramContext, a(), ViberActionRunner.h.a(paramContext), 134217728);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return "";
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.backup_autobackup_progress_notification_title);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.j.c
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.notif.b.j;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.h;

public class b extends com.viber.voip.notif.b.b
{
  public int a()
  {
    return -160;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[3];
    arrayOfn[0] = paramo.a(true);
    arrayOfn[1] = paramo.a(b_(paramContext), b(paramContext));
    arrayOfn[2] = paramo.b(paramContext, a(), ViberActionRunner.h.a(paramContext), 134217728);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return paramContext.getString(R.string.dialog_437_message);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.pref_category_backup_and_restore);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.j.b
 * JD-Core Version:    0.6.2
 */
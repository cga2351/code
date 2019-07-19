package com.viber.voip.notif.b.h;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner.aw;

public class b extends com.viber.voip.notif.b.b
{
  public int a()
  {
    return -240;
  }

  protected void a(Context paramContext, o paramo)
  {
    Intent localIntent = ViberActionRunner.aw.b(paramContext, null, "QR Code");
    n[] arrayOfn = new n[2];
    arrayOfn[0] = paramo.b(paramContext, a(), localIntent, 134217728);
    arrayOfn[1] = paramo.a(paramContext, a(), localIntent, 134217728, true);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  public CharSequence b(Context paramContext)
  {
    return paramContext.getString(R.string.notification_secure_primary_activation_text);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }

  public c d()
  {
    return c.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.h.b
 * JD-Core Version:    0.6.2
 */
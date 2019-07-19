package com.viber.voip.fcm;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner;

public class b extends com.viber.voip.notif.b.b
{
  public int a()
  {
    return -220;
  }

  protected void a(Context paramContext, o paramo)
  {
    n[] arrayOfn = new n[3];
    arrayOfn[0] = paramo.b(true);
    arrayOfn[1] = paramo.a(false);
    arrayOfn[2] = paramo.b(paramContext, a(), ViberActionRunner.b(paramContext), 134217728);
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
    return paramContext.getString(R.string.vibe_retrieving_recent_msgs);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.fcm.b
 * JD-Core Version:    0.6.2
 */
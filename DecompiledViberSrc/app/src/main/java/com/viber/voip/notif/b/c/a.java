package com.viber.voip.notif.b.c;

import android.content.Context;
import android.os.SystemClock;
import com.viber.voip.R.drawable;
import com.viber.voip.notif.b.b;

public class a extends b
{
  private final String a;

  public a(String paramString)
  {
    this.a = paramString;
  }

  public static a e()
  {
    return new a("Clear media process started");
  }

  public static a f()
  {
    return new a("Clear media process ended");
  }

  public String R_()
  {
    return Long.toString(SystemClock.elapsedRealtime());
  }

  public int a()
  {
    return -230;
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
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.c.a
 * JD-Core Version:    0.6.2
 */
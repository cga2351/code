package com.viber.voip.notif.b.f.c;

import android.content.Context;
import android.support.v4.util.CircularArray;
import com.viber.voip.R.string;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.f.b.e;
import com.viber.voip.notif.b.f.c;
import com.viber.voip.notif.h.m;

public class b extends c
{
  private final com.viber.voip.notif.h.b h;
  private final com.viber.voip.notif.b.f.b.o i;
  private CharSequence j;

  public b(com.viber.voip.notif.h.b paramb, com.viber.voip.notif.b.f.b.o paramo)
  {
    super(paramb, null);
    this.h = paramb;
    this.i = paramo;
  }

  private CharSequence h()
  {
    if (this.j == null)
    {
      CircularArray localCircularArray = this.h.b();
      int k = Math.min(4, localCircularArray.size());
      StringBuilder localStringBuilder = new StringBuilder();
      for (int m = k - 1; m >= 0; m--)
      {
        m localm = (m)localCircularArray.get(m);
        if (localStringBuilder.length() != 0)
          localStringBuilder.append(", ");
        localStringBuilder.append(this.i.a(localm).a());
      }
      this.j = localStringBuilder.toString();
    }
    return this.j;
  }

  protected void a(Context paramContext, g paramg)
  {
  }

  protected void a(Context paramContext, com.viber.voip.notif.c.o paramo)
  {
    super.a(paramContext, paramo);
    a(paramo.a(String.valueOf(this.a.j())));
    a(paramo.a(false));
  }

  public CharSequence b(Context paramContext)
  {
    int k = R.string.message_notification_msg_from_text;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = h();
    return paramContext.getString(k, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    int k = R.string.message_notification_x_new_msgs_text;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.h.j());
    return paramContext.getString(k, arrayOfObject);
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getString(R.string.app_name);
  }

  protected int e()
  {
    return a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.b
 * JD-Core Version:    0.6.2
 */
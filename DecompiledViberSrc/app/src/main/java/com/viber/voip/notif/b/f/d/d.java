package com.viber.voip.notif.b.f.d;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.notif.h.m;

public class d extends com.viber.voip.notif.b.f.d
{
  public d(m paramm)
  {
    super(paramm);
  }

  public String R_()
  {
    return "group_icon_changed";
  }

  public CharSequence b(Context paramContext)
  {
    int i = R.string.message_notification_group_icon_removed;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = b_(paramContext);
    return paramContext.getString(i, arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.d
 * JD-Core Version:    0.6.2
 */
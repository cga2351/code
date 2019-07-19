package com.viber.voip.notif.b.f.d;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;

public class b extends d
{
  public b(m paramm)
  {
    super(paramm);
  }

  public String R_()
  {
    return "group_background_changed";
  }

  public CharSequence b(Context paramContext)
  {
    String str = dg.b(this.a.e().o());
    int i = R.string.message_notification_group_new_background_text;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = str;
    return paramContext.getString(i, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.message_notification_group_new_background_title);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.b
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.notif.b.f.d;

import android.content.Context;
import android.text.Html;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.da;

public class c extends d
{
  public c(m paramm)
  {
    super(paramm);
  }

  public String R_()
  {
    return "group_icon_changed";
  }

  public CharSequence b(Context paramContext)
  {
    String str = this.a.e().o();
    if (da.a(str))
    {
      int j = R.string.notification_msg_group_icon_change_pattern;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.c;
      return Html.fromHtml(paramContext.getString(j, arrayOfObject2)).toString();
    }
    int i = R.string.message_notification_group_icon_changed;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.c;
    arrayOfObject1[1] = str;
    return paramContext.getString(i, arrayOfObject1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.c
 * JD-Core Version:    0.6.2
 */
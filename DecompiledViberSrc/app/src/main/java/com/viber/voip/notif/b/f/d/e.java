package com.viber.voip.notif.b.f.d;

import android.content.Context;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.h.m;

public class e extends d
{
  private String h;

  public e(m paramm, String paramString)
  {
    super(paramm);
    this.h = paramString;
  }

  public String R_()
  {
    return "group_many_attrs_changed";
  }

  public CharSequence b(Context paramContext)
  {
    String str = this.h;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.c;
    return String.format(str, arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.e
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.common.d.c;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.notif.h.m;
import dagger.a;

class s extends b
{
  s(Context paramContext, m paramm, q.a parama, a<aj> parama1, h paramh)
  {
    super(paramContext, paramm, parama, parama1, paramh);
  }

  public e a(boolean paramBoolean)
  {
    String str1 = a(this.k.b());
    String str3;
    if (this.d)
    {
      str3 = a(new Object[] { "" }).trim();
      str1 = b(this.f, str1);
    }
    Object[] arrayOfObject;
    for (String str2 = b(this.f, str3); ; str2 = a(arrayOfObject))
    {
      return new e(this.g, str1, str2, null, paramBoolean);
      arrayOfObject = new Object[1];
      arrayOfObject[0] = (c.a(this.f) + ":");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.s
 * JD-Core Version:    0.6.2
 */
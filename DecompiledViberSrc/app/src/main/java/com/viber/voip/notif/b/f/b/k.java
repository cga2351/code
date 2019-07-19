package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.common.d.c;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.notif.h.m;
import dagger.a;

class k extends b
{
  k(Context paramContext, m paramm, q.a parama, a<aj> parama1, h paramh)
  {
    super(paramContext, paramm, parama, parama1, paramh);
  }

  public e a(boolean paramBoolean)
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.h;
    String str1 = a(arrayOfObject1);
    String str3;
    if (this.d)
      str3 = a(new Object[] { "" }).trim();
    Object[] arrayOfObject2;
    for (String str2 = b(this.f, str3); ; str2 = a(arrayOfObject2))
    {
      return new e(this.g, str2, str1, null, paramBoolean);
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = (c.a(this.f) + ":");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.k
 * JD-Core Version:    0.6.2
 */
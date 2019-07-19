package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.notif.h.m;

class t extends a
{
  public t(Context paramContext, m paramm, dagger.a<aj> parama, h paramh)
  {
    super(paramContext, paramm, parama, paramh);
  }

  public e a(boolean paramBoolean)
  {
    String str2;
    String str1;
    if (this.d)
    {
      str2 = b(this.f, this.i);
      str1 = str2;
    }
    while (true)
    {
      return new e(this.g, str1, str2, null, paramBoolean);
      str1 = this.i;
      str2 = a(this.f, this.i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.t
 * JD-Core Version:    0.6.2
 */
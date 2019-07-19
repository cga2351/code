package com.viber.voip.notif.g;

import android.annotation.SuppressLint;
import com.viber.voip.notif.b.e.a;
import com.viber.voip.notif.b.e.c;
import com.viber.voip.notif.b.e.d;
import com.viber.voip.notif.h.g;
import com.viber.voip.util.LongSparseSet;

public class b
{
  @SuppressLint({"SwitchIntDef"})
  public com.viber.voip.notif.d.e a(g paramg)
  {
    switch (paramg.h())
    {
    default:
      return null;
    case 4:
      return new c(paramg);
    case 3:
      if (paramg.e().size() > 1)
        return new a(paramg);
      return new d(paramg);
    case 5:
    }
    if (paramg.e().size() > 1)
      return new com.viber.voip.notif.b.e.b(paramg);
    return new com.viber.voip.notif.b.e.e(paramg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.g.b
 * JD-Core Version:    0.6.2
 */
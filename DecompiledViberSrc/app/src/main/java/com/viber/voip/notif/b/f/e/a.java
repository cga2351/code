package com.viber.voip.notif.b.f.e;

import android.content.Context;
import android.support.v4.util.CircularArray;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.d.g;
import com.viber.voip.notif.d.g.a;
import com.viber.voip.notif.d.g.b;
import com.viber.voip.notif.f.e;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;

public class a extends b
  implements g.a
{
  private final com.viber.voip.notif.h.b h;
  private CharSequence[] i;

  public a(com.viber.voip.notif.h.b paramb)
  {
    super(paramb);
    this.h = paramb;
  }

  private CharSequence[] h()
  {
    if (this.i == null)
    {
      CircularArray localCircularArray = this.h.b();
      int j = localCircularArray.size();
      this.i = new CharSequence[j];
      int k = 0;
      if (k < j)
      {
        m localm = (m)localCircularArray.get(k);
        CharSequence[] arrayOfCharSequence = this.i;
        StringBuilder localStringBuilder = new StringBuilder().append(dg.a(localm.d(), localm.e().j(), 0));
        if (localm.j() > 1);
        for (String str = " (" + localm.j() + ")"; ; str = "")
        {
          arrayOfCharSequence[k] = str;
          k++;
          break;
        }
      }
    }
    return this.i;
  }

  protected void a(Context paramContext, o paramo)
  {
    super.a(paramContext, paramo);
    a(paramo.a(false));
  }

  protected void a(Context paramContext, o paramo, e parame)
  {
  }

  public void a(Context paramContext, g.b paramb)
  {
    paramb.a(h());
  }

  public CharSequence b(Context paramContext)
  {
    if (h().length == 0)
      return "";
    return h()[(-1 + h().length)];
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getString(R.string.app_name);
  }

  public g f(Context paramContext)
  {
    return g.a(this, paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.e.a
 * JD-Core Version:    0.6.2
 */
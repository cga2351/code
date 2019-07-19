package com.viber.voip.publicaccount.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ads.b.b.b.c;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.k;
import com.viber.voip.banner.a.a.g;
import com.viber.voip.i.c.l;
import com.viber.voip.i.f;
import com.viber.voip.i.f.a;

public class a extends k
  implements f.a
{
  public a(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, Handler paramHandler1, c.a parama, Handler paramHandler2)
  {
    super(paramContext, paramPhoneController, paramICdrController, paramHandler1, parama, paramHandler2);
    c.l.b.a(this);
  }

  protected int a()
  {
    return 12;
  }

  protected Uri a(g paramg)
  {
    return paramg.a();
  }

  protected int b()
  {
    if (!c.l.b.e())
      return 0;
    return this.b.a(c.d);
  }

  public void onFeatureStateChanged(f paramf)
  {
    if ((c.l.b.c().equals(paramf.c())) && (!c.l.b.e()))
      this.a = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.a.a
 * JD-Core Version:    0.6.2
 */
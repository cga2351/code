package com.viber.voip.banner.a.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.q;
import com.viber.voip.ads.s;

public class h
  implements f
{
  private final Context a;
  private final Handler b;
  private final Handler c;
  private final Handler d;
  private final PhoneController e;
  private final ICdrController f;
  private final q g;
  private final s h;
  private final g i;
  private d j;
  private d k;
  private final c.a l;
  private boolean m;

  public h(Context paramContext, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, PhoneController paramPhoneController, ICdrController paramICdrController, q paramq, s params, g paramg, c.a parama, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramHandler1;
    this.c = paramHandler2;
    this.d = paramHandler3;
    this.e = paramPhoneController;
    this.f = paramICdrController;
    this.g = paramq;
    this.h = params;
    this.i = paramg;
    this.l = parama;
    this.m = paramBoolean;
  }

  private d b()
  {
    if (this.j == null)
      this.j = new e(new b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.l, this.m), this.b);
    return this.j;
  }

  private d c()
  {
    if (this.k == null)
      this.k = new e(new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.l, this.m), this.b);
    return this.k;
  }

  public d a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return b();
    case 2:
    }
    return c();
  }

  public d[] a()
  {
    d[] arrayOfd = new d[2];
    arrayOfd[0] = b();
    arrayOfd[1] = c();
    return arrayOfd;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.a.a.h
 * JD-Core Version:    0.6.2
 */
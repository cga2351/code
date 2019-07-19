package com.viber.voip.analytics;

import com.viber.common.b.a;
import com.viber.dexshared.Logger;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Im2ReceiverBase;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.a.i;
import com.viber.voip.settings.d.al;

public class u
{
  private static final Logger a = ViberEnv.getLogger();
  private final Im2Exchanger b;
  private boolean c;
  private boolean d;
  private boolean e;
  private final com.viber.common.b.d f;
  private d.al g;

  public u(Im2Exchanger paramIm2Exchanger, com.viber.common.b.d paramd)
  {
    this.b = paramIm2Exchanger;
    this.f = paramd;
  }

  private d.al b()
  {
    if (this.g == null)
    {
      a[] arrayOfa = new a[1];
      arrayOfa[0] = this.f;
      this.g = new d.al(arrayOfa)
      {
        public void onPreferencesChanged(a paramAnonymousa)
        {
          if (2 == u.a(u.this).d())
            u.b(u.this);
        }
      };
    }
    return this.g;
  }

  private void c()
  {
    try
    {
      boolean bool = this.e;
      if (bool);
      while (true)
      {
        return;
        this.c = true;
        e();
      }
    }
    finally
    {
    }
  }

  private void d()
  {
    try
    {
      boolean bool = this.e;
      if (bool);
      while (true)
      {
        return;
        this.d = true;
        e();
      }
    }
    finally
    {
    }
  }

  private void e()
  {
    try
    {
      if ((this.c) && (this.d))
      {
        g.a().a(i.a());
        this.e = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a()
  {
    com.viber.voip.settings.d.a(b());
    Im2Exchanger localIm2Exchanger = this.b;
    Im2ReceiverBase[] arrayOfIm2ReceiverBase = new Im2ReceiverBase[1];
    arrayOfIm2ReceiverBase[0] = new v(this);
    localIm2Exchanger.registerDelegate(arrayOfIm2ReceiverBase);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.u
 * JD-Core Version:    0.6.2
 */
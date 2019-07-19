package com.viber.voip.invitelinks;

import android.os.Handler;
import android.support.v4.util.SparseArrayCompat;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.util.da;
import dagger.a;
import org.greenrobot.eventbus.EventBus;

public abstract class b<InvokeContextType extends b>
  implements p
{
  protected final Logger a = ViberEnv.getLogger(getClass());
  protected boolean b;
  protected final SparseArrayCompat<InvokeContextType> c = new SparseArrayCompat();
  protected final PhoneController d;
  protected final GroupController e;
  protected final Im2Exchanger f;
  protected final ab g;
  protected final a<bs> h;
  protected final Handler i;
  private final EventBus j;

  public b(PhoneController paramPhoneController, GroupController paramGroupController, Im2Exchanger paramIm2Exchanger, ab paramab, a<bs> parama, EventBus paramEventBus, Handler paramHandler)
  {
    this.d = paramPhoneController;
    this.e = paramGroupController;
    this.f = paramIm2Exchanger;
    this.i = paramHandler;
    this.g = paramab;
    this.h = parama;
    this.j = paramEventBus;
  }

  protected int a()
  {
    return 3;
  }

  protected final InvokeContextType a(int paramInt)
  {
    b localb = (b)this.c.get(paramInt);
    if (localb != null)
      this.c.remove(paramInt);
    return localb;
  }

  protected final void a(int paramInt, b<InvokeContextType>.g paramb)
  {
    paramb.a(paramInt);
  }

  protected final void a(InvokeContextType paramInvokeContextType, b<InvokeContextType>.h paramb)
  {
    paramb.b(paramInvokeContextType);
  }

  protected final boolean a_(long paramLong, int paramInt)
  {
    for (int k = 0; ; k++)
    {
      int m = this.c.size();
      boolean bool = false;
      if (k < m)
      {
        b localb = (b)this.c.valueAt(k);
        if ((localb.a == paramLong) && (localb.c == paramInt))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  protected final boolean b()
  {
    if (!this.b)
    {
      this.b = true;
      return true;
    }
    return false;
  }

  protected final boolean b_(String paramString)
  {
    for (int k = 0; ; k++)
    {
      int m = this.c.size();
      boolean bool = false;
      if (k < m)
      {
        if (da.a(paramString, ((b)this.c.valueAt(k)).b))
          bool = true;
      }
      else
        return bool;
    }
  }

  public EventBus c()
  {
    return this.j;
  }

  protected abstract class a extends b<InvokeContextType>.h
  {
    protected a()
    {
      super();
    }

    protected boolean a(InvokeContextType paramInvokeContextType)
    {
      return b.this.b_(paramInvokeContextType.b);
    }
  }

  protected static class b
  {
    protected final long a;
    protected final String b;
    protected final int c;
    protected final int d;

    protected b(long paramLong, String paramString, int paramInt1, int paramInt2)
    {
      this.a = paramLong;
      this.b = paramString;
      this.c = paramInt1;
      this.d = paramInt2;
    }
  }

  protected abstract class c extends b<InvokeContextType>.h
  {
    protected c()
    {
      super();
    }

    protected boolean a(InvokeContextType paramInvokeContextType)
    {
      return b.this.a_(paramInvokeContextType.a, paramInvokeContextType.c);
    }
  }

  protected abstract class d extends b<InvokeContextType>.g
  {
    protected d()
    {
      super();
    }

    protected final void a(InvokeContextType paramInvokeContextType)
    {
      if (a())
      {
        if (paramInvokeContextType.d < b.this.a())
        {
          b(paramInvokeContextType);
          return;
        }
        c(paramInvokeContextType);
        return;
      }
      d(paramInvokeContextType);
    }

    protected abstract boolean a();

    protected abstract void b(InvokeContextType paramInvokeContextType);

    protected abstract void c(InvokeContextType paramInvokeContextType);

    protected abstract void d(InvokeContextType paramInvokeContextType);
  }

  protected abstract class e extends b<InvokeContextType>.g
  {
    protected e()
    {
      super();
    }

    protected final void a(InvokeContextType paramInvokeContextType)
    {
      if (a())
      {
        if (!da.a(b()))
        {
          b(paramInvokeContextType);
          return;
        }
        c(paramInvokeContextType);
        return;
      }
      d(paramInvokeContextType);
    }

    protected abstract boolean a();

    protected abstract String b();

    protected abstract void b(InvokeContextType paramInvokeContextType);

    protected abstract void c(InvokeContextType paramInvokeContextType);

    protected abstract void d(InvokeContextType paramInvokeContextType);
  }

  protected abstract class f extends b<InvokeContextType>.g
  {
    protected f()
    {
      super();
    }

    protected final void a(InvokeContextType paramInvokeContextType)
    {
      if (a())
      {
        a(paramInvokeContextType, 1);
        return;
      }
      b(paramInvokeContextType);
    }

    protected abstract void a(InvokeContextType paramInvokeContextType, int paramInt);

    protected abstract boolean a();

    protected abstract void b(InvokeContextType paramInvokeContextType);
  }

  protected abstract class g
  {
    protected g()
    {
    }

    protected final void a(int paramInt)
    {
      b.b localb = b.this.a(paramInt);
      if (localb == null)
      {
        c();
        return;
      }
      e(localb);
      a(localb);
    }

    protected abstract void a(InvokeContextType paramInvokeContextType);

    protected void c()
    {
    }

    protected void e(InvokeContextType paramInvokeContextType)
    {
    }
  }

  protected abstract class h
  {
    protected h()
    {
    }

    protected abstract void a(int paramInt, InvokeContextType paramInvokeContextType);

    protected abstract boolean a(InvokeContextType paramInvokeContextType);

    protected void b(InvokeContextType paramInvokeContextType)
    {
      if (a(paramInvokeContextType))
      {
        c(paramInvokeContextType);
        return;
      }
      int i = b.this.d.generateSequence();
      b.this.c.put(i, paramInvokeContextType);
      a(i, paramInvokeContextType);
    }

    protected void c(InvokeContextType paramInvokeContextType)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.b
 * JD-Core Version:    0.6.2
 */
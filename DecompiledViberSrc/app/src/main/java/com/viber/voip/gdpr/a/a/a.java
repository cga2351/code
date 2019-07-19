package com.viber.voip.gdpr.a.a;

import android.support.v4.util.SparseArrayCompat;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGdprCommandMsg;
import com.viber.jni.im2.CGdprCommandMsg.Sender;
import com.viber.jni.im2.CGdprCommandReplyMsg;
import com.viber.voip.ViberEnv;
import com.viber.voip.gdpr.a.c;
import com.viber.voip.gdpr.a.f;
import com.viber.voip.util.az;
import com.viber.voip.util.d;

public abstract class a<V extends com.viber.voip.gdpr.ui.a.a>
  implements c
{
  protected final Logger a = ViberEnv.getLogger(getClass());
  protected final az b;
  protected final d c;
  protected final V d;
  private final PhoneController e;
  private final SparseArrayCompat<f> f;
  private final CGdprCommandMsg.Sender g;
  private final b h;

  public a(az paramaz, PhoneController paramPhoneController, d paramd, V paramV, CGdprCommandMsg.Sender paramSender, b paramb)
  {
    this.b = paramaz;
    this.e = paramPhoneController;
    this.c = paramd;
    this.d = paramV;
    this.g = paramSender;
    this.h = paramb;
    this.f = new SparseArrayCompat();
  }

  private void b(f paramf)
  {
    int i = this.e.generateSequence();
    this.f.put(i, paramf);
    final CGdprCommandMsg localCGdprCommandMsg = a(i);
    this.h.a(this, localCGdprCommandMsg, new Runnable()
    {
      public void run()
      {
        a.a(a.this).handleCGdprCommandMsg(localCGdprCommandMsg);
      }
    });
  }

  public int a()
  {
    return 5;
  }

  protected abstract CGdprCommandMsg a(int paramInt);

  protected abstract void a(CGdprCommandReplyMsg paramCGdprCommandReplyMsg);

  protected final void a(final f paramf)
  {
    this.b.a(new Runnable()
    {
      public void run()
      {
        a.a(a.this, paramf);
      }
    });
  }

  public void onCGdprCommandReplyMsg(CGdprCommandReplyMsg paramCGdprCommandReplyMsg)
  {
    f localf = (f)this.f.get(paramCGdprCommandReplyMsg.seq, f.a);
    this.f.remove(paramCGdprCommandReplyMsg.seq);
    if (paramCGdprCommandReplyMsg.status == 0)
    {
      a(paramCGdprCommandReplyMsg);
      return;
    }
    if (4 == paramCGdprCommandReplyMsg.status)
    {
      this.b.b(new c(this.c, paramCGdprCommandReplyMsg.seq, paramCGdprCommandReplyMsg.requestDate, null));
      return;
    }
    if (5 == paramCGdprCommandReplyMsg.status)
    {
      this.b.b(new b(this.c, paramCGdprCommandReplyMsg.seq, paramCGdprCommandReplyMsg.requestDate, paramCGdprCommandReplyMsg.limitDays, null));
      return;
    }
    if (2 == paramCGdprCommandReplyMsg.status)
    {
      if (1 + localf.b == a())
      {
        this.b.b(new d(this.c, paramCGdprCommandReplyMsg.seq, null));
        return;
      }
      a(localf.a());
      return;
    }
    this.b.b(new a(this.c, paramCGdprCommandReplyMsg.seq, null));
  }

  private class a extends com.viber.voip.gdpr.a
  {
    private final int b;

    private a(d paramInt, int arg3)
    {
      super();
      int i;
      this.b = i;
    }

    public void a()
    {
      a.this.d.b();
    }

    public void b()
    {
      a.this.d.b(this.b);
    }
  }

  private class b extends com.viber.voip.gdpr.a
  {
    private final int b;
    private final String c;
    private final int d;

    private b(d paramInt1, int paramString, String paramInt2, int arg5)
    {
      super();
      this.b = paramString;
      this.c = paramInt2;
      int i;
      this.d = i;
    }

    public void a()
    {
      a.this.d.a(this.c, this.d);
    }

    public void b()
    {
      a.this.d.a(this.b, this.c, this.d);
    }
  }

  private class c extends com.viber.voip.gdpr.a
  {
    private final int b;
    private final String c;

    private c(d paramInt, int paramString, String arg4)
    {
      super();
      this.b = paramString;
      Object localObject;
      this.c = localObject;
    }

    public void a()
    {
      a.this.d.a(this.c);
    }

    public void b()
    {
      a.this.d.a(this.b, this.c);
    }
  }

  private class d extends com.viber.voip.gdpr.a
  {
    private final int b;

    private d(d paramInt, int arg3)
    {
      super();
      int i;
      this.b = i;
    }

    public void a()
    {
      a.this.d.a();
    }

    public void b()
    {
      a.this.d.a(this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.a.a.a
 * JD-Core Version:    0.6.2
 */
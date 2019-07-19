package com.viber.voip.ads.a;

import android.os.Handler;
import com.google.d.f;
import com.viber.common.b.h;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGetAdInfoReplyMsg;
import com.viber.jni.im2.CGetAdInfoReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.af;
import com.viber.voip.util.da;

public class b
  implements CGetAdInfoReplyMsg.Receiver
{
  public static long a = 86400000L;
  private static final com.viber.common.a.e b = ViberEnv.getLogger();
  private final com.viber.common.b.d c;
  private final h d;
  private final com.viber.common.b.e e;
  private final f f;
  private final com.viber.voip.util.i.e g;
  private final Im2Exchanger h;
  private final PhoneController i;
  private final Handler j;
  private final af k;
  private Integer l = null;
  private final dagger.a<Engine> m;

  public b(dagger.a<Engine> parama, com.viber.common.b.d paramd, h paramh, com.viber.common.b.e parame, f paramf, com.viber.voip.util.i.e parame1, Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, Handler paramHandler, af paramaf)
  {
    this.m = parama;
    this.c = paramd;
    this.d = paramh;
    this.e = parame;
    this.f = paramf;
    this.g = parame1;
    this.h = paramIm2Exchanger;
    this.i = paramPhoneController;
    this.j = paramHandler;
    this.k = paramaf;
  }

  private void d()
  {
    this.j.post(new c(this));
  }

  public void a()
  {
    if (this.e.d() < 0L)
      this.e.a(this.g.a() + a);
    this.h.registerDelegate(this, this.j);
  }

  public void b()
  {
    if (this.g.a() < this.e.d())
      return;
    d();
  }

  public void onCGetAdInfoReplyMsg(CGetAdInfoReplyMsg paramCGetAdInfoReplyMsg)
  {
    if ((this.l == null) || (!this.l.equals(Integer.valueOf(paramCGetAdInfoReplyMsg.seq))));
    do
    {
      return;
      this.l = null;
    }
    while (paramCGetAdInfoReplyMsg.status != 0);
    if (da.a(paramCGetAdInfoReplyMsg.adInfo))
    {
      this.c.a(d.UNKNOWN.ordinal());
      this.d.a("");
    }
    while (true)
    {
      this.e.a(paramCGetAdInfoReplyMsg.waitIntervalForNextQuery.longValue());
      return;
      try
      {
        a locala = (a)this.f.a(paramCGetAdInfoReplyMsg.adInfo, a.class);
        this.c.a(locala.a().ordinal());
        this.d.a(locala.b());
      }
      catch (Throwable localThrowable)
      {
        this.c.a(d.UNKNOWN.ordinal());
        this.d.a("");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.a.b
 * JD-Core Version:    0.6.2
 */
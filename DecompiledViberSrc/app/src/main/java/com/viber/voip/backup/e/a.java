package com.viber.voip.backup.e;

import com.viber.jni.backup.BackupHeader;
import com.viber.voip.av.e;
import com.viber.voip.backup.i;
import com.viber.voip.backup.o;
import com.viber.voip.backup.r;
import com.viber.voip.messages.controller.b.ac;
import com.viber.voip.messages.controller.b.ac.a;
import com.viber.voip.messages.controller.b.f.a;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class a extends i<e, b>
{
  private volatile CountDownLatch c;
  private final ac d;
  private BackupHeader e;
  private final ac.a f = new ac.a()
  {
    public void a(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
        a.a(a.this, new CountDownLatch(1));
    }

    public void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if ((paramAnonymousBoolean2) && (a.a(a.this) != null))
        a.a(a.this).countDown();
    }

    public boolean a(List<f.a> paramAnonymousList, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      return false;
    }

    public void b(boolean paramAnonymousBoolean)
    {
    }
  };

  public a(ac paramac, r paramr)
  {
    super(paramr);
    this.d = paramac;
  }

  protected int a(b paramb, List<e> paramList)
    throws com.viber.voip.backup.c.d
  {
    return this.e.getMessageCount() + this.e.getGroupMessageCount();
  }

  protected void a(b paramb, String paramString)
    throws com.viber.voip.backup.c.d
  {
    this.e.getPhoneNumber();
    this.d.registerDelegate(this.f, av.e.d.a());
    this.d.a();
  }

  protected void a(e parame, b paramb)
    throws com.viber.voip.backup.c.d
  {
    parame.a(this.e, paramb, this.d);
  }

  protected void a(List<e> paramList, o paramo)
  {
    paramList.add(new d(paramo));
    paramList.add(new c(paramo));
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.d.c(paramBoolean);
    this.d.a(false);
    if (this.c != null);
    try
    {
      this.c.await();
      label35: this.d.removeDelegate(this.f);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label35;
    }
  }

  protected b b(String paramString1, String paramString2)
    throws com.viber.voip.backup.c.d
  {
    this.d.a(true);
    b localb = new b(paramString1);
    this.e = localb.b();
    return localb;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.e.a
 * JD-Core Version:    0.6.2
 */
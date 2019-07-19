package com.viber.voip.backup.e;

import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.jni.backup.BackupHeader;
import com.viber.jni.backup.MessageBackupEntity;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.backup.o;
import com.viber.voip.messages.controller.b.ac;
import com.viber.voip.messages.controller.b.ac.a;
import com.viber.voip.messages.controller.b.f.a;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

abstract class e<M extends MessageBackupEntity>
  implements com.viber.voip.backup.d
{
  private static final Logger a = ViberEnv.getLogger();
  private volatile boolean b;
  private Semaphore c = new Semaphore(1);
  private int d;
  private i e;
  private final o f;
  private final ac.a g = new ac.a()
  {
    public void a(boolean paramAnonymousBoolean)
    {
    }

    public void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
    }

    public boolean a(List<f.a> paramAnonymousList, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      return false;
    }

    public void b(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
        e.a(e.this).release();
    }
  };

  public e(o paramo)
  {
    this.f = paramo;
  }

  private void a(ac paramac)
  {
    if (this.d >= 2000)
      c(paramac);
    this.d = (1 + this.d);
    if (this.d == 1)
    {
      paramac.b(true);
      this.e = i.a();
    }
  }

  private void b(ac paramac)
  {
    if (this.d > 0)
      c(paramac);
  }

  private void c(ac paramac)
  {
    try
    {
      this.c.acquire();
      label7: paramac.a(true, false);
      this.f.a(this.d);
      this.d = 0;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label7;
    }
  }

  protected abstract Iterable<M> a(b paramb);

  public void a()
  {
    this.b = true;
  }

  protected abstract void a(BackupHeader paramBackupHeader, M paramM, ac paramac);

  public void a(BackupHeader paramBackupHeader, b paramb, ac paramac)
    throws com.viber.voip.backup.c.d
  {
    paramac.registerDelegate(this.g, av.e.d.a());
    ViberApplication.getInstance().getCacheManager().a();
    while (true)
    {
      MessageBackupEntity localMessageBackupEntity;
      try
      {
        Iterator localIterator = a(paramb).iterator();
        if (!localIterator.hasNext())
          break;
        localMessageBackupEntity = (MessageBackupEntity)localIterator.next();
        if (this.b)
          throw new com.viber.voip.backup.c.b();
      }
      finally
      {
        paramac.removeDelegate(this.g);
      }
      if (((!da.a(localMessageBackupEntity.getMemberId())) || (av.d(localMessageBackupEntity.getFlags(), 32))) && (localMessageBackupEntity.getMessageToken() != 0L))
      {
        localMessageBackupEntity.setFlags(0x200 | localMessageBackupEntity.getFlags());
        a(paramac);
        a(paramBackupHeader, localMessageBackupEntity, paramac);
      }
    }
    b(paramac);
    paramac.removeDelegate(this.g);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.e.e
 * JD-Core Version:    0.6.2
 */
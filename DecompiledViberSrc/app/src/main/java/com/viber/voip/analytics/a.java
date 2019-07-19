package com.viber.voip.analytics;

import android.support.v4.util.Pair;
import com.google.firebase.messaging.RemoteMessage;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class a
  implements p, w
{
  protected final com.viber.common.a.e a = ViberEnv.getLogger(getClass());
  protected boolean b;
  private boolean c;
  private boolean d;
  private final y e;

  protected a(y paramy)
  {
    this.e = paramy;
  }

  private <PROPERTY> void a(Queue<PROPERTY> paramQueue, com.viber.voip.util.d.a<PROPERTY> parama)
  {
    if (!paramQueue.isEmpty())
    {
      LinkedList localLinkedList = new LinkedList(paramQueue);
      paramQueue.clear();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
        parama.a(localIterator.next());
    }
  }

  private boolean a(com.viber.voip.analytics.story.f paramf)
  {
    if ((!this.c) || (!paramf.b()))
      return false;
    com.viber.voip.analytics.story.k.a locala = paramf.d();
    if (locala == null)
      return true;
    return locala.d();
  }

  private void b(com.viber.voip.analytics.story.f paramf)
  {
    com.viber.voip.analytics.story.k.a locala = paramf.d();
    if (locala != null)
      locala.b();
  }

  private void g()
  {
    a(this.e.e(), new b(this));
  }

  private void h()
  {
    a(this.e.a(), new c(this));
  }

  private void i()
  {
    a(this.e.b(), new d(this));
  }

  private void j()
  {
    a(this.e.d(), new e(this));
  }

  private void k()
  {
    a(this.e.c(), new f(this));
  }

  public final void a()
  {
    this.c = false;
    this.d = true;
    this.e.f();
    c();
    e();
  }

  public void a(RemoteMessage paramRemoteMessage)
  {
    if (!this.d)
    {
      this.e.a(paramRemoteMessage);
      return;
    }
    b(paramRemoteMessage);
  }

  public final void a(com.viber.voip.analytics.story.e parame)
  {
    if (!this.d)
      this.e.a(parame);
    do
    {
      do
        return;
      while (!a(parame));
      if (parame.a())
      {
        d(parame);
        return;
      }
    }
    while (!c(parame));
    b(parame);
  }

  public final void a(com.viber.voip.analytics.story.f paramf, g paramg)
  {
    if (!this.d)
      this.e.a(Pair.create(paramf, paramg));
    while ((!a(paramf)) || (!b(paramf, paramg)))
      return;
    b(paramf);
  }

  public final void a(j paramj)
  {
    if (!this.d)
      this.e.a(paramj);
    while ((!a(paramj)) || (!c(paramj)))
      return;
    b(paramj);
  }

  public final void a(String paramString)
  {
    this.d = true;
    b(paramString);
    this.c = true;
    q_();
    c();
    i();
    j();
    h();
    k();
    g();
  }

  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (this.d)
      c();
  }

  protected void b(RemoteMessage paramRemoteMessage)
  {
  }

  public void b(com.viber.voip.analytics.story.e parame)
  {
    if (this.d)
      e(parame);
  }

  public void b(j paramj)
  {
    if (!this.d)
      this.e.b(paramj);
    while ((!a(paramj)) || (!d(paramj)))
      return;
    b(paramj);
  }

  protected abstract void b(String paramString);

  public boolean b()
  {
    return this.c;
  }

  protected boolean b(com.viber.voip.analytics.story.f paramf, g paramg)
  {
    return false;
  }

  protected void c()
  {
  }

  protected abstract boolean c(com.viber.voip.analytics.story.e parame);

  protected abstract boolean c(j paramj);

  protected abstract void d(com.viber.voip.analytics.story.e parame);

  protected boolean d(j paramj)
  {
    return false;
  }

  protected abstract void e();

  protected boolean e(com.viber.voip.analytics.story.e parame)
  {
    return false;
  }

  public boolean f()
  {
    return x.a(this);
  }

  protected abstract void q_();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.a
 * JD-Core Version:    0.6.2
 */
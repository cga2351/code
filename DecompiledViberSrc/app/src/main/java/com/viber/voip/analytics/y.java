package com.viber.voip.analytics;

import android.support.v4.util.Pair;
import com.google.firebase.messaging.RemoteMessage;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.j;
import com.viber.voip.util.au;
import java.util.LinkedList;
import java.util.Queue;

public class y
{
  protected final com.viber.common.a.e a = ViberEnv.getLogger(getClass());
  private Queue<RemoteMessage> b = new LinkedList();
  private Queue<com.viber.voip.analytics.story.e> c = new au(64);
  private Queue<j> d = new LinkedList();
  private Queue<j> e = new LinkedList();
  private Queue<Pair<f, g>> f = new au(64);

  public y()
  {
  }

  public y(y paramy)
  {
    this();
    if (!paramy.a().isEmpty())
      this.c.addAll(paramy.a());
    if (!paramy.b().isEmpty())
      this.d.addAll(paramy.b());
    if (!paramy.c().isEmpty())
      this.f.addAll(paramy.c());
    if (!paramy.d().isEmpty())
      this.e.addAll(paramy.d());
    if (!paramy.e().isEmpty())
      this.b.addAll(paramy.e());
  }

  public Queue<com.viber.voip.analytics.story.e> a()
  {
    return this.c;
  }

  public void a(Pair<f, g> paramPair)
  {
    this.f.add(paramPair);
  }

  public void a(RemoteMessage paramRemoteMessage)
  {
    this.b.add(paramRemoteMessage);
  }

  public void a(com.viber.voip.analytics.story.e parame)
  {
    this.c.add(parame);
  }

  public void a(j paramj)
  {
    this.d.add(paramj);
  }

  public Queue<j> b()
  {
    return this.d;
  }

  public void b(j paramj)
  {
    this.e.add(paramj);
  }

  public Queue<Pair<f, g>> c()
  {
    return this.f;
  }

  public Queue<j> d()
  {
    return this.e;
  }

  public Queue<RemoteMessage> e()
  {
    return this.b;
  }

  public void f()
  {
    this.c.clear();
    this.d.clear();
    this.f.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.y
 * JD-Core Version:    0.6.2
 */
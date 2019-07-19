package com.viber.voip.publicaccount.d;

import android.os.Handler;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.publicgroup.PublicChatsEnabledListener;
import com.viber.jni.publicgroup.PublicGroupControllerDelegate.EnabledDelegate;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.i.c.l;
import com.viber.voip.i.f;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.k;
import com.viber.voip.settings.d.ap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
  implements PublicGroupControllerDelegate.EnabledDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private static a b;
  private int c = 0;
  private Set<a> d = new HashSet(10);

  private a()
  {
    ViberApplication.getInstance().getEngine(false).getDelegatesManager().getPublicChatsEnabledListener().registerDelegate(this, av.e.f.a());
    this.c = d.ap.d.d();
    f localf = c.l.a;
    int i = this.c;
    boolean bool = false;
    if (i == 2)
      bool = true;
    localf.a(bool);
  }

  @Deprecated
  public static a a()
  {
    try
    {
      if (b == null)
        b = new a();
      a locala = b;
      return locala;
    }
    finally
    {
    }
  }

  private void b(final int paramInt)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = new HashSet(a.a(a.this)).iterator();
        while (localIterator.hasNext())
          ((a.a)localIterator.next()).onVibesStateChanged(paramInt);
      }
    });
  }

  public void a(int paramInt)
  {
    a(paramInt, true);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      f localf;
      if (this.c != paramInt)
      {
        this.c = paramInt;
        d.ap.d.a(this.c);
        if (this.c == 3)
          ViberApplication.getInstance().getMessagesManager().c().a();
        localf = c.l.a;
        if (this.c != 2)
          break label84;
      }
      label84: for (boolean bool = true; ; bool = false)
      {
        localf.a(bool);
        if (paramBoolean)
          b(paramInt);
        return;
      }
    }
    finally
    {
    }
  }

  public void a(a parama)
  {
    this.d.add(parama);
    parama.onVibesStateChanged(this.c);
  }

  public void b()
  {
    if (c() == 0)
      a(1);
  }

  public void b(a parama)
  {
    this.d.remove(parama);
  }

  public int c()
  {
    return this.c;
  }

  public boolean d()
  {
    return (c() != 0) && (c() != 3);
  }

  public boolean e()
  {
    return c() == 3;
  }

  public void onPublicChatSupported(int paramInt)
  {
    a(paramInt);
  }

  public static abstract interface a
  {
    public abstract void onVibesStateChanged(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.d.a
 * JD-Core Version:    0.6.2
 */
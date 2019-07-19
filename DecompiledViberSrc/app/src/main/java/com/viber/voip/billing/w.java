package com.viber.voip.billing;

import android.os.Handler;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.ArrayList;
import java.util.Iterator;

public class w
{
  private static final Logger b = b.a(w.class);
  a a;
  private l c;
  private Handler d = av.a(av.e.a);
  private long e = SystemClock.elapsedRealtime();
  private ArrayList<Purchase> f;
  private Runnable g;
  private ServiceStateDelegate.ServiceState h;
  private long i;
  private ServiceStateDelegate j = new ServiceStateDelegate()
  {
    public void onServiceStateChanged(int paramAnonymousInt)
    {
      ServiceStateDelegate.ServiceState localServiceState = ServiceStateDelegate.ServiceState.resolveEnum(paramAnonymousInt);
      if (localServiceState == w.a(w.this))
        return;
      w.a(w.this, SystemClock.elapsedRealtime());
      switch (w.3.a[localServiceState.ordinal()])
      {
      default:
        w.c(w.this);
      case 1:
      }
      while (true)
      {
        w.a(w.this, localServiceState);
        return;
        w.b(w.this);
      }
    }
  };

  w(l paraml)
  {
    this.c = paraml;
    this.f = new ArrayList();
    ServiceStateListener localServiceStateListener = ViberApplication.getInstance().getEngine(false).getDelegatesManager().getServiceStateListener();
    ServiceStateDelegate[] arrayOfServiceStateDelegate = new ServiceStateDelegate[1];
    arrayOfServiceStateDelegate[0] = this.j;
    localServiceStateListener.registerDelegate(arrayOfServiceStateDelegate);
    Purchase[] arrayOfPurchase = this.c.h();
    int m = arrayOfPurchase.length;
    while (k < m)
    {
      Purchase localPurchase = arrayOfPurchase[k];
      localPurchase.setRetrying(true);
      this.f.add(localPurchase);
      k++;
    }
    e();
  }

  private long b()
  {
    long l1 = SystemClock.elapsedRealtime();
    ArrayList localArrayList = new ArrayList(this.f.size());
    Iterator localIterator = this.f.iterator();
    long l2 = 9223372036854775807L;
    long l4;
    if (localIterator.hasNext())
    {
      Purchase localPurchase = (Purchase)localIterator.next();
      if (!localPurchase.isPending())
        break label142;
      localArrayList.add(localPurchase);
      l4 = localPurchase.lastAction + localPurchase.nextRetryDelay - l1;
      if (l4 >= l2)
        break label142;
    }
    while (true)
    {
      l2 = l4;
      break;
      this.f = localArrayList;
      if (l2 < 0L)
        l2 = 0L;
      long l3 = 20000L - (l1 - this.e);
      if (l3 > l2)
        l2 = l3;
      return l2;
      label142: l4 = l2;
    }
  }

  private void c()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      Purchase localPurchase = (Purchase)localIterator.next();
      long l = SystemClock.elapsedRealtime();
      if (localPurchase.lastAction + localPurchase.nextRetryDelay <= l)
      {
        this.c.a(localPurchase);
        return;
      }
    }
    e();
  }

  private boolean d()
  {
    ServiceStateDelegate.ServiceState localServiceState1 = this.h;
    ServiceStateDelegate.ServiceState localServiceState2 = ServiceStateDelegate.ServiceState.SERVICE_CONNECTED;
    boolean bool1 = false;
    if (localServiceState1 == localServiceState2)
    {
      boolean bool2 = SystemClock.elapsedRealtime() - this.i < 3000L;
      bool1 = false;
      if (!bool2)
        bool1 = true;
    }
    return bool1;
  }

  private void e()
  {
    f();
    long l = b();
    if (l < 9223372036854775807L)
    {
      this.g = new Runnable()
      {
        public void run()
        {
          w.d(w.this);
        }
      };
      this.d.postDelayed(this.g, l);
    }
    while (this.a == null)
      return;
    this.a.a();
  }

  private void f()
  {
    if (this.g != null)
    {
      this.d.removeCallbacks(this.g);
      this.g = null;
    }
  }

  public void a(Purchase paramPurchase)
  {
    if (!this.f.contains(paramPurchase))
      this.f.add(paramPurchase);
    paramPurchase.lastAction = SystemClock.elapsedRealtime();
    if (paramPurchase.nextRetryDelay == 0L)
      paramPurchase.nextRetryDelay = 20000L;
    while (true)
    {
      e();
      return;
      if ((d()) && (paramPurchase.nextRetryDelay < 3600000L))
      {
        paramPurchase.nextRetryDelay = (2L * paramPurchase.nextRetryDelay);
        if (paramPurchase.nextRetryDelay > 3600000L)
          paramPurchase.nextRetryDelay = 3600000L;
      }
    }
  }

  public void a(a parama)
  {
    this.a = parama;
  }

  public boolean a()
  {
    return this.f.size() != 0;
  }

  public void b(Purchase paramPurchase)
  {
    e();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.w
 * JD-Core Version:    0.6.2
 */
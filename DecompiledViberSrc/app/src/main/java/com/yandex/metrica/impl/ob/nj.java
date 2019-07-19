package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.d;
import com.yandex.metrica.impl.d.a;
import java.util.ArrayList;
import java.util.List;

class nj extends nf
  implements d
{
  private final TelephonyManager a;
  private PhoneStateListener b;
  private boolean c = false;
  private mw d;
  private final d.a<nr> e = new d.a();
  private final d.a<ng[]> f = new d.a();
  private final Handler g;
  private final Context h;
  private final ni i;
  private final no j;
  private final nl k;
  private final jb l;
  private iv m;

  protected nj(Context paramContext)
  {
    this(paramContext, new jb());
  }

  protected nj(Context paramContext, jb paramjb)
  {
    this(paramContext, paramjb, new iv(paramjb.a()));
  }

  protected nj(Context paramContext, jb paramjb, iv paramiv)
  {
    this.h = paramContext;
    this.a = ((TelephonyManager)paramContext.getSystemService("phone"));
    HandlerThread localHandlerThread = od.a("YMM-TP");
    localHandlerThread.start();
    this.g = new Handler(localHandlerThread.getLooper());
    this.g.post(new Runnable()
    {
      public void run()
      {
        nj.a(nj.this, new nj.a(nj.this, (byte)0));
      }
    });
    this.i = new ni(this, paramiv);
    this.j = new no(this, paramiv);
    this.k = new nl(this, paramiv);
    this.l = paramjb;
    this.m = paramiv;
  }

  private void a(SignalStrength paramSignalStrength)
  {
    try
    {
      ng localng;
      int i3;
      int n;
      if ((!this.e.b()) && (!this.e.c()))
      {
        localng = ((nr)this.e.a()).b();
        if (localng != null)
        {
          if (!paramSignalStrength.isGsm())
            break label87;
          i3 = paramSignalStrength.getGsmSignalStrength();
          if (99 != i3)
            break label75;
          n = -1;
        }
      }
      while (true)
      {
        localng.a(Integer.valueOf(n));
        return;
        label75: n = -113 + i3 * 2;
        continue;
        label87: n = paramSignalStrength.getCdmaDbm();
        int i1 = paramSignalStrength.getEvdoDbm();
        if (-120 != i1)
          if (-120 == n)
          {
            n = i1;
          }
          else
          {
            int i2 = Math.min(n, i1);
            n = i2;
          }
      }
    }
    finally
    {
    }
  }

  private ng[] j()
  {
    try
    {
      ng[] arrayOfng;
      if ((this.f.b()) || (this.f.c()))
      {
        arrayOfng = f();
        this.f.a(arrayOfng);
      }
      while (true)
      {
        return arrayOfng;
        arrayOfng = (ng[])this.f.a();
      }
    }
    finally
    {
    }
  }

  private boolean k()
  {
    try
    {
      mw localmw = this.d;
      if (localmw != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public void a()
  {
    try
    {
      this.g.post(new Runnable()
      {
        public void run()
        {
          if (!nj.a(nj.this))
            nj.a(nj.this, true);
          try
          {
            if (nj.b(nj.this) != null)
              nj.c(nj.this).listen(nj.b(nj.this), 256);
            return;
          }
          catch (Exception localException)
          {
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(mw parammw)
  {
    this.d = parammw;
    this.l.a(parammw);
    this.m.a(this.l.a());
  }

  public void a(nh paramnh)
  {
    if (paramnh != null);
    try
    {
      paramnh.a(j());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(ns paramns)
  {
    if (paramns != null);
    try
    {
      paramns.a(e());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.l.a(paramBoolean);
    this.m.a(this.l.a());
  }

  public void b()
  {
    try
    {
      this.g.post(new Runnable()
      {
        public void run()
        {
          if (nj.a(nj.this))
          {
            nj.a(nj.this, false);
            h.a().a(nj.this);
          }
          try
          {
            if (nj.b(nj.this) != null)
              nj.c(nj.this).listen(nj.b(nj.this), 0);
            return;
          }
          catch (Exception localException)
          {
          }
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public TelephonyManager c()
  {
    return this.a;
  }

  public Context d()
  {
    return this.h;
  }

  nr e()
  {
    try
    {
      nr localnr1;
      if ((this.e.b()) || (this.e.c()))
      {
        localnr1 = new nr(this.i, this.j, this.k);
        ng localng1 = localnr1.b();
        if ((localng1 != null) && (localng1.a() == null) && (!this.e.b()))
        {
          ng localng2 = ((nr)this.e.a()).b();
          if (localng2 != null)
            localnr1.b().a(localng2.a());
        }
        this.e.a(localnr1);
      }
      for (nr localnr2 = localnr1; ; localnr2 = (nr)this.e.a())
        return localnr2;
    }
    finally
    {
    }
  }

  @SuppressLint({"MissingPermission"})
  ng[] f()
  {
    ArrayList localArrayList = new ArrayList();
    int n;
    CellInfo localCellInfo;
    Object localObject1;
    label96: Object localObject2;
    ng localng1;
    if ((bw.a(17)) && (this.m.a(this.h)))
    {
      try
      {
        List localList = this.a.getAllCellInfo();
        if (!bw.a(localList))
        {
          n = 0;
          if (n < localList.size())
          {
            localCellInfo = (CellInfo)localList.get(n);
            if ((localCellInfo instanceof CellInfoGsm))
            {
              localObject1 = new ng.c();
              break label252;
              if (localObject2 == null)
                break label263;
              localArrayList.add(localObject2);
              break label263;
            }
            else if ((localCellInfo instanceof CellInfoCdma))
            {
              localObject1 = new ng.a();
            }
          }
        }
      }
      catch (Exception localException)
      {
      }
    }
    else
    {
      if (localArrayList.size() > 0)
        break label233;
      localng1 = e().b();
      if (localng1 != null)
        break label224;
      return new ng[0];
    }
    if ((localCellInfo instanceof CellInfoLte))
    {
      localObject1 = new ng.d();
    }
    else
    {
      if ((!bw.a(18)) || (!(localCellInfo instanceof CellInfoWcdma)))
        break label269;
      localObject1 = new ng.e();
    }
    label263: label269: label273: 
    while (true)
    {
      ng localng2 = ((ng.b)localObject1).a(localCellInfo);
      localObject2 = localng2;
      break label96;
      label224: return new ng[] { localng1 };
      label233: return (ng[])localArrayList.toArray(new ng[localArrayList.size()]);
      while (true)
      {
        label252: if (localObject1 != null)
          break label273;
        localObject2 = null;
        break label96;
        n++;
        break;
        localObject1 = null;
      }
    }
  }

  boolean g()
  {
    try
    {
      if (k())
      {
        boolean bool2 = this.d.n.n;
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  boolean h()
  {
    try
    {
      if (k())
      {
        boolean bool2 = this.d.n.m;
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  boolean i()
  {
    try
    {
      if (k())
      {
        boolean bool2 = this.d.n.l;
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  private class a extends PhoneStateListener
  {
    private a()
    {
    }

    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      nj.a(nj.this, paramSignalStrength);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.nj
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.stickers;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.CircularIntArray;
import android.text.TextUtils;
import android.util.SparseArray;
import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.svg.jni.AndroidSvgObject;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.billing.ProductId;
import com.viber.voip.billing.b.c;
import com.viber.voip.billing.b.f;
import com.viber.voip.camrecorder.preview.MediaPreviewActivity;
import com.viber.voip.messages.ui.ConversationActivity;
import com.viber.voip.notif.e.v;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.af;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.ax;
import com.viber.voip.stickers.c.g.a;
import com.viber.voip.stickers.c.g.c;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.ap;
import com.viber.voip.util.at;
import com.viber.voip.util.by;
import com.viber.voip.util.ci;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.cj.b;
import com.viber.voip.util.dd;
import com.viber.voip.util.n;
import com.viber.voip.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
{
  private static long J;
  private static final Logger a = ViberEnv.getLogger();
  private static final HashSet<String> b = new HashSet(4);
  private final com.viber.voip.stickers.a.a A;
  private boolean B = false;
  private final d C = new d("", 0);
  private boolean D;
  private final LongSparseSet E = new LongSparseSet();
  private final com.viber.voip.analytics.g F;
  private final com.viber.voip.analytics.story.j.c G;
  private d.al H;
  private boolean I;
  private PhoneControllerDelegateAdapter K;
  private ServiceStateDelegate L;
  private PhoneControllerDelegateAdapter M;
  private ConnectionDelegate N;
  private final cj.b O;
  private Comparator<com.viber.voip.stickers.entity.a> P;
  private Context c;
  private ViberApplication d;
  private cj e;
  private f f;
  private final com.viber.voip.stickers.b.a g;
  private final com.viber.voip.stickers.e.c h;
  private com.viber.voip.stickers.c.g i;
  private final q j;
  private final h k;
  private final s l;
  private final m m;
  private final t n;
  private final u o;
  private final o p;
  private final Handler q;
  private final Handler r;
  private final SparseArray<Sticker> s = new SparseArray();
  private final LongSparseSet t = new LongSparseSet();
  private List<com.viber.voip.stickers.entity.a> u = new ArrayList();
  private List<com.viber.voip.stickers.entity.a> v = new ArrayList();
  private List<com.viber.voip.stickers.entity.a> w = new ArrayList();
  private int x = 0;
  private g y;
  private final x z;

  static
  {
    b.add(ConversationActivity.class.getName());
    b.add(y.a().getName());
    if (y.c())
      b.add(y.b().getName());
    b.add(MediaPreviewActivity.class.getName());
  }

  private i()
  {
    Handler localHandler = av.e.a.a();
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.ax.r;
    this.H = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        i.a(i.this, d.ax.r.d());
      }
    };
    this.K = new PhoneControllerDelegateAdapter()
    {
      public void onGetPersonalProfile(int paramAnonymousInt, long paramAnonymousLong, String paramAnonymousString)
      {
        if (paramAnonymousInt == 0)
        {
          d.ax.t.a(paramAnonymousString);
          if (paramAnonymousLong <= 600000L)
            break label49;
        }
        while (true)
        {
          d.ax.u.a(paramAnonymousLong + System.currentTimeMillis());
          ViberApplication.getInstance().getEngine(false).removeDelegate(i.q(i.this));
          return;
          label49: paramAnonymousLong = 86400000L;
        }
      }
    };
    this.L = new ServiceStateDelegate()
    {
      public void onServiceStateChanged(int paramAnonymousInt)
      {
        if (paramAnonymousInt == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal())
          i.this.b(true);
      }
    };
    this.M = new PhoneControllerDelegateAdapter()
    {
      public void onOpenMarket()
      {
        av.e.a.a().post(new Runnable()
        {
          public void run()
          {
            i.a(i.this, true);
          }
        });
      }
    };
    this.N = new ConnectionDelegate()
    {
      private int b;

      public void onConnect()
      {
        i.a(i.this, false);
      }

      public void onConnectionStateChange(int paramAnonymousInt)
      {
        if ((paramAnonymousInt == this.b) || (!ViberApplication.isActivated()))
          return;
        if (paramAnonymousInt == 3)
          if ((i.m(i.this).size() == 0) && (!i.r(i.this)))
            i.b(i.this, false);
        while (true)
        {
          this.b = paramAnonymousInt;
          return;
          if (paramAnonymousInt == 0)
            i.s(i.this);
        }
      }
    };
    this.O = new cj.a()
    {
      private AtomicBoolean b = new AtomicBoolean(false);
      private final Runnable c = new Runnable()
      {
        public void run()
        {
          if (!i.26.a(i.26.this).get());
          while (true)
          {
            return;
            Iterator localIterator = i.a(i.this).d().iterator();
            while (localIterator.hasNext())
            {
              com.viber.voip.stickers.entity.b localb = (com.viber.voip.stickers.entity.b)localIterator.next();
              i.this.a(localb);
            }
          }
        }
      };

      public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = 1;
        if (paramAnonymousInt1 == i);
        while (true)
        {
          this.b.set(i);
          if (i == 0)
            break;
          i.b(i.this).post(this.c);
          return;
          i = 0;
        }
        i.b(i.this).removeCallbacks(this.c);
      }
    };
    this.P = new Comparator()
    {
      public int a(com.viber.voip.stickers.entity.a paramAnonymousa1, com.viber.voip.stickers.entity.a paramAnonymousa2)
      {
        if (paramAnonymousa1.o() != paramAnonymousa2.o())
          if (!paramAnonymousa1.o());
        do
        {
          do
          {
            return -1;
            return 1;
            if (paramAnonymousa1.h() == paramAnonymousa2.h())
              break;
          }
          while (paramAnonymousa1.h());
          return 1;
          if (paramAnonymousa1.c() == paramAnonymousa2.c())
            break;
        }
        while (paramAnonymousa1.c());
        return 1;
        if (paramAnonymousa1.a() != paramAnonymousa2.a())
          return paramAnonymousa1.a() - paramAnonymousa2.a();
        return paramAnonymousa1.e() - paramAnonymousa2.e();
      }
    };
    this.c = ViberApplication.getApplication();
    this.d = ViberApplication.getInstance();
    this.e = cj.a(this.c);
    this.q = av.a(av.e.a);
    this.r = av.a(av.e.g);
    this.h = com.viber.voip.stickers.e.c.a();
    this.z = new x(this);
    this.j = new q(this);
    this.g = new com.viber.voip.stickers.b.a();
    this.A = new com.viber.voip.stickers.a.b(this.c, com.viber.voip.ads.b.b.b.c.a.a(), this.r);
    com.viber.voip.schedule.d.a locala = com.viber.voip.schedule.d.a().b();
    this.n = new t(this.c, this);
    locala.a(this.n);
    this.l = new s(this.c, this);
    locala.a(this.l);
    this.m = new m(this.c, this);
    locala.a(this.m);
    this.k = new h(this.c);
    locala.a(this.k);
    this.o = new u(this.r, this.g)
    {
      public void a(CircularIntArray paramAnonymousCircularIntArray)
      {
        i.b(i.this, true);
      }
    };
    E();
    J();
    this.p = new o()
    {
      public void onStickerDeployed(Sticker paramAnonymousSticker)
      {
        super.onStickerDeployed(paramAnonymousSticker);
      }

      public void onStickerPackageDeployed(com.viber.voip.stickers.entity.a paramAnonymousa)
      {
        if ((!paramAnonymousa.o()) && (!paramAnonymousa.l()))
          d.ax.l.a(paramAnonymousa.e());
        com.viber.voip.analytics.story.k.a(paramAnonymousa);
        super.onStickerPackageDeployed(paramAnonymousa);
      }

      public void onStickerPackageDownloadError(boolean paramAnonymousBoolean, com.viber.voip.stickers.entity.a paramAnonymousa)
      {
        super.onStickerPackageDownloadError(paramAnonymousBoolean, paramAnonymousa);
        if (paramAnonymousBoolean)
        {
          i.a(i.this).f(paramAnonymousa.e());
          i.b(i.this, false);
        }
      }
    };
    this.h.a(new com.viber.voip.stickers.e.d()
    {
      public void a(int paramAnonymousInt)
      {
        com.viber.voip.stickers.entity.a locala = i.this.g(paramAnonymousInt);
        if ((locala == null) || (locala.p()))
          i.b(i.this, true);
      }
    });
    this.h.a(new com.viber.voip.stickers.e.g()
    {
      public void a(int paramAnonymousInt)
      {
        com.viber.voip.stickers.entity.a locala = i.this.g(paramAnonymousInt);
        if ((locala == null) || (locala.p()))
          i.b(i.this, true);
      }
    });
    this.h.a(new com.viber.voip.stickers.e.f()
    {
      public void a(int paramAnonymousInt)
      {
        com.viber.voip.stickers.entity.a locala = i.this.g(paramAnonymousInt);
        if ((locala == null) || (locala.p()))
          i.b(i.this, true);
      }
    });
    this.p.a(this.m);
    this.F = com.viber.voip.analytics.g.a();
    this.G = this.F.c().f();
    if (ViberApplication.isActivated())
      C();
  }

  private void A(int paramInt)
  {
    com.viber.voip.stickers.entity.b localb = new com.viber.voip.stickers.entity.b(paramInt);
    localb.c(true);
    this.g.a(localb);
    this.w = a(localb, this.w);
  }

  private void B(int paramInt)
  {
    this.w = a(g(paramInt), this.w);
    this.g.f(paramInt);
  }

  private void C()
  {
    this.D = true;
    this.r.postDelayed(new Runnable()
    {
      public void run()
      {
        i.b(i.this, false);
        i.b(i.this).postDelayed(new Runnable()
        {
          public void run()
          {
            i.this.e().e();
          }
        }
        , 1000L);
        i.c(i.this);
        i.c(i.this, false);
      }
    }
    , 2500L);
  }

  private void D()
  {
    synchronized (this.C)
    {
      this.C.a(this.d.getActivityOnForeground());
      com.viber.voip.util.d.a(new com.viber.voip.util.d.a()
      {
        public void a(final boolean paramAnonymousBoolean, final Class paramAnonymousClass)
        {
          i.b(i.this).post(new Runnable()
          {
            public void run()
            {
              if (paramAnonymousClass == null)
                return;
              synchronized (i.d(i.this))
              {
                if ((paramAnonymousBoolean) && (i.B().contains(paramAnonymousClass.getName())) && (!i.d(i.this).a().equals(paramAnonymousClass.getName())))
                {
                  i.d(i.this).a(paramAnonymousClass.getName());
                  i.d(i.this).a(0);
                }
                return;
              }
            }
          });
        }
      });
      return;
    }
  }

  private void E()
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    localEngine.registerDelegate(this.M);
    localEngine.getDelegatesManager().getConnectionListener().registerDelegate(this.N, av.a(av.e.a));
    this.e.a(this.O);
  }

  private com.viber.voip.stickers.c.g F()
  {
    if (this.i == null)
      this.i = new com.viber.voip.stickers.c.g(this, this.p);
    return this.i;
  }

  private void G()
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = i.a(i.this).c().iterator();
        while (localIterator.hasNext())
        {
          com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localIterator.next();
          if ((locala.n()) && (locala.g()))
            i.this.b(locala);
        }
        d.ax.h.a(false);
      }
    });
  }

  private void H()
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        i.a(i.this).g();
        d.ax.A.a(false);
      }
    });
  }

  private void I()
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        i.o(i.this).a();
      }
    });
  }

  private void J()
  {
    ViberApplication.getInstance().getMediaMountManager().a(new com.viber.voip.storage.c.a()
    {
      public void g()
      {
        i.b(i.this).post(new Runnable()
        {
          public void run()
          {
            i.b(i.this, false);
          }
        });
      }

      public void o()
      {
      }
    });
  }

  private com.viber.voip.stickers.entity.a a(int paramInt, List<com.viber.voip.stickers.entity.a> paramList)
  {
    if (paramInt == 0)
      return null;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localIterator.next();
      if (paramInt == locala.e())
        return locala;
    }
    return null;
  }

  @Deprecated
  public static i a()
  {
    return b.a();
  }

  private List<com.viber.voip.stickers.entity.a> a(com.viber.voip.stickers.entity.a parama, List<com.viber.voip.stickers.entity.a> paramList)
  {
    if (!paramList.contains(parama))
      return paramList;
    ArrayList localArrayList = new ArrayList(paramList);
    localArrayList.remove(parama);
    return localArrayList;
  }

  private List<com.viber.voip.stickers.entity.a> a(com.viber.voip.stickers.entity.b paramb, List<com.viber.voip.stickers.entity.a> paramList)
  {
    if (paramList.contains(paramb))
      return paramList;
    ArrayList localArrayList = new ArrayList(paramList);
    localArrayList.add(paramb);
    return localArrayList;
  }

  private void a(com.viber.voip.bot.item.b<Sticker> paramb, boolean paramBoolean, long paramLong)
  {
    Iterator localIterator = paramb.a().iterator();
    while (true)
    {
      Sticker localSticker;
      if (localIterator.hasNext())
      {
        localSticker = (Sticker)localIterator.next();
        if (System.currentTimeMillis() - paramLong <= 200L);
      }
      else
      {
        return;
      }
      e().a(localSticker, false, paramBoolean, w.a);
    }
  }

  private void b(int paramInt, a parama, String paramString)
  {
    switch (28.a[parama.ordinal()])
    {
    default:
      return;
    case 1:
    case 2:
    }
    ProductId localProductId = ProductId.fromStickerPackageId(paramInt);
    com.viber.voip.billing.b.a().a(localProductId, paramString, new b.f()
    {
      public void a(b.c paramAnonymousc)
      {
        if (paramAnonymousc.a());
      }
    });
  }

  private void b(int paramInt, String paramString, a parama)
  {
    if (paramString == null)
      paramString = Integer.toString(paramInt);
    switch (28.a[parama.ordinal()])
    {
    default:
      return;
    case 1:
    case 2:
    }
    this.F.a(com.viber.voip.analytics.a.i.b(paramString));
    this.F.a(com.viber.voip.analytics.story.l.f.a(paramInt));
  }

  private void c(Sticker paramSticker)
  {
    String str = paramSticker.getOrigPath();
    AndroidSvgObject localAndroidSvgObject;
    Object localObject1;
    if (paramSticker.isSvg())
    {
      localAndroidSvgObject = this.z.b(str);
      localObject1 = null;
      if (localAndroidSvgObject == null);
    }
    while (true)
    {
      try
      {
        int[] arrayOfInt = this.z.a(localAndroidSvgObject);
        localObject1 = null;
        if (arrayOfInt != null)
        {
          g.c localc = new g.c(arrayOfInt[0], arrayOfInt[1]);
          localObject1 = localc;
        }
        if (localAndroidSvgObject != null)
          localAndroidSvgObject.destroy();
        if (localObject1 == null)
          break;
        p.a(paramSticker, ((g.c)localObject1).a(), ((g.c)localObject1).b(), p.a(paramSticker.isSvg()));
        return;
      }
      catch (IOException localIOException)
      {
        localObject1 = null;
        if (localAndroidSvgObject == null)
          continue;
        localAndroidSvgObject.destroy();
        localObject1 = null;
        continue;
      }
      finally
      {
        if (localAndroidSvgObject != null)
          localAndroidSvgObject.destroy();
      }
      BitmapFactory.Options localOptions = com.viber.voip.util.e.j.a(this.c, Uri.fromFile(new File(str)));
      if ((localOptions.outWidth != 0) && (localOptions.outHeight == 0));
      localObject1 = new g.c(localOptions.outWidth, localOptions.outHeight);
    }
    at.f(new File(str));
  }

  private void c(boolean paramBoolean)
  {
    Runnable local7 = new Runnable()
    {
      public void run()
      {
        if (i.h(i.this) == null)
          return;
        ArrayList localArrayList1 = new ArrayList(i.a(i.this).c());
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        CircularIntArray localCircularIntArray = new CircularIntArray();
        ArrayList localArrayList4 = new ArrayList();
        boolean bool = i.h(i.this).a();
        while (true)
        {
          com.viber.voip.stickers.entity.a locala;
          try
          {
            LongSparseSet localLongSparseSet;
            if (i.i(i.this).size() == 0)
            {
              localLongSparseSet = null;
              Iterator localIterator = localArrayList1.iterator();
              if (!localIterator.hasNext())
                break;
              locala = (com.viber.voip.stickers.entity.a)localIterator.next();
              if (locala.p())
              {
                if ((locala.l()) || ((localLongSparseSet != null) && (localLongSparseSet.contains(locala.e()))))
                  continue;
                if ((!locala.o()) && (!locala.h()))
                  localArrayList3.add(locala);
                if (locala.c())
                  localArrayList2.add(locala);
              }
              if (i.a(i.this, locala))
                i.this.b(locala);
              if (!locala.g())
              {
                if ((locala.s()) || (locala.o()))
                  continue;
                localArrayList4.add(locala);
                continue;
              }
            }
            else
            {
              localLongSparseSet = new LongSparseSet(i.i(i.this));
              continue;
            }
          }
          finally
          {
          }
          if ((locala.e() != 400) && ((bool) || (TextUtils.isEmpty(locala.f()))))
            localCircularIntArray.addLast(locala.e());
        }
        Collections.sort(localArrayList3, i.j(i.this));
        Collections.sort(localArrayList2, i.j(i.this));
        synchronized (i.this)
        {
          i.a(i.this, localArrayList1);
          i.b(i.this, localArrayList2);
          i.c(i.this, localArrayList3);
          if (localCircularIntArray.size() > 0)
            i.h(i.this).b(localCircularIntArray);
          i.d(i.this, localArrayList4);
          i.this.d();
          return;
        }
      }
    };
    if (!dd.a())
    {
      local7.run();
      return;
    }
    if (paramBoolean)
    {
      av.e.f.a().removeCallbacks(local7);
      av.e.f.a().postDelayed(local7, 500L);
      return;
    }
    av.e.f.a().post(local7);
  }

  private boolean c(com.viber.voip.stickers.entity.a parama)
  {
    return ((!parama.g()) && (parama.i())) || (133600 == parama.e()) || (143700 == parama.e());
  }

  private void d(final int paramInt, boolean paramBoolean)
  {
    Runnable local21 = new Runnable()
    {
      public void run()
      {
        i.a(i.this, 0);
        com.viber.voip.stickers.entity.a locala = i.this.g(paramInt);
        if ((locala != null) && (!locala.h()) && (locala.g()))
          i.this.b(paramInt, false);
      }
    };
    if (paramBoolean)
    {
      local21.run();
      return;
    }
    this.r.post(local21);
  }

  private void e(final List<com.viber.voip.stickers.entity.a> paramList)
  {
    if (com.viber.voip.util.u.a(paramList))
      return;
    this.r.post(new Runnable()
    {
      public void run()
      {
        CircularIntArray localCircularIntArray = new CircularIntArray();
        StringBuffer localStringBuffer = new StringBuffer();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localIterator.next();
          localStringBuffer.setLength(0);
          localStringBuffer.append("packageId=").append(locala.e());
          if (!locala.t())
          {
            localStringBuffer.append(", empty info");
            localCircularIntArray.addLast(locala.e());
          }
          while (true)
          {
            if (!locala.u())
            {
              localStringBuffer.append(", colored icon");
              i.this.p(locala.e());
            }
            String[] arrayOfString = locala.x();
            if ((!locala.h()) || (arrayOfString == null) || (arrayOfString.length <= 0))
              break;
            if (!locala.w())
            {
              localStringBuffer.append(", thumb");
              i.this.a(locala.e(), locala.m());
            }
            if ((locala.v()) || (!n.a(locala.x(), "mp3")))
              break;
            localStringBuffer.append(", sound");
            i.this.q(locala.e());
            break;
            if ((!locala.h()) && (locala.q() == 0L))
            {
              localStringBuffer.append(", empty weight");
              localCircularIntArray.addLast(locala.e());
            }
          }
        }
        if (!localCircularIntArray.isEmpty())
          i.h(i.this).b(localCircularIntArray);
      }
    });
  }

  static boolean w()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - J > 10000L)
    {
      J = l1;
      return com.viber.voip.util.upload.o.a(com.viber.voip.util.upload.o.b());
    }
    return com.viber.voip.util.upload.o.a(false);
  }

  private void z(int paramInt)
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        synchronized (i.d(i.this))
        {
          i.d(i.this).a(1 + i.d(i.this).b());
          return;
        }
      }
    });
  }

  public x A()
  {
    return this.z;
  }

  public int a(String paramString)
  {
    synchronized (this.C)
    {
      boolean bool = this.C.a().equals(paramString);
      int i1 = 0;
      if (bool)
        i1 = this.C.b();
      return i1;
    }
  }

  public void a(int paramInt)
  {
    this.h.a(paramInt);
  }

  public void a(final int paramInt1, final int paramInt2)
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        com.viber.voip.stickers.entity.b localb = (com.viber.voip.stickers.entity.b)i.this.g(paramInt1);
        if (localb == null);
        int i;
        do
        {
          return;
          i = i.this.x();
          if ((localb.g()) && (localb.d()))
          {
            d.ax.l.a(0);
            localb.a(false);
            i.a(i.this).a(localb);
            i.b(i.this, false);
            return;
          }
        }
        while ((!localb.g()) || (i == 0) || (paramInt2 == i));
        d.ax.l.a(0);
      }
    });
  }

  public void a(int paramInt, a parama)
  {
    a(paramInt, null, parama);
  }

  public void a(final int paramInt, String paramString, final a parama)
  {
    synchronized (this.E)
    {
      this.E.add(paramInt);
      if (a.a == parama)
      {
        z(paramInt);
        c(paramInt);
      }
      if (a.d != parama);
    }
    while (true)
    {
      synchronized (this.E)
      {
        this.E.add(paramInt);
        this.r.post(new Runnable()
        {
          // ERROR //
          public void run()
          {
            // Byte code:
            //   0: lconst_0
            //   1: lstore_1
            //   2: aload_0
            //   3: getfield 22	com/viber/voip/stickers/i$10:a	I
            //   6: invokestatic 35	com/viber/voip/stickers/u:a	(I)Lcom/viber/voip/market/g;
            //   9: astore 19
            //   11: aload 19
            //   13: astore 4
            //   15: aload 4
            //   17: ifnull +303 -> 320
            //   20: aload 4
            //   22: getfield 40	com/viber/voip/market/g:c	Ljava/lang/String;
            //   25: astore 6
            //   27: aload 4
            //   29: getfield 44	com/viber/voip/market/g:f	[Ljava/lang/String;
            //   32: astore 5
            //   34: aload_0
            //   35: getfield 22	com/viber/voip/stickers/i$10:a	I
            //   38: invokestatic 47	com/viber/voip/stickers/u:b	(I)J
            //   41: lstore 23
            //   43: lload 23
            //   45: lstore_1
            //   46: aload 6
            //   48: astore 7
            //   50: aload 5
            //   52: astore 8
            //   54: aload 4
            //   56: astore 9
            //   58: getstatic 52	com/viber/voip/stickers/i$a:d	Lcom/viber/voip/stickers/i$a;
            //   61: aload_0
            //   62: getfield 24	com/viber/voip/stickers/i$10:b	Lcom/viber/voip/stickers/i$a;
            //   65: if_acmpeq +40 -> 105
            //   68: aload_0
            //   69: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   72: astore 16
            //   74: aload_0
            //   75: getfield 22	com/viber/voip/stickers/i$10:a	I
            //   78: istore 17
            //   80: aload 9
            //   82: ifnull +291 -> 373
            //   85: aload 9
            //   87: getfield 40	com/viber/voip/market/g:c	Ljava/lang/String;
            //   90: astore 18
            //   92: aload 16
            //   94: iload 17
            //   96: aload 18
            //   98: aload_0
            //   99: getfield 24	com/viber/voip/stickers/i$10:b	Lcom/viber/voip/stickers/i$a;
            //   102: invokestatic 55	com/viber/voip/stickers/i:a	(Lcom/viber/voip/stickers/i;ILjava/lang/String;Lcom/viber/voip/stickers/i$a;)V
            //   105: aload_0
            //   106: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   109: aload_0
            //   110: getfield 22	com/viber/voip/stickers/i$10:a	I
            //   113: invokevirtual 59	com/viber/voip/stickers/i:g	(I)Lcom/viber/voip/stickers/entity/a;
            //   116: checkcast 61	com/viber/voip/stickers/entity/b
            //   119: astore 10
            //   121: aload 10
            //   123: ifnonnull +256 -> 379
            //   126: new 61	com/viber/voip/stickers/entity/b
            //   129: dup
            //   130: aload_0
            //   131: getfield 22	com/viber/voip/stickers/i$10:a	I
            //   134: invokespecial 64	com/viber/voip/stickers/entity/b:<init>	(I)V
            //   137: astore 10
            //   139: aload 9
            //   141: ifnull +23 -> 164
            //   144: aload 9
            //   146: invokestatic 69	com/viber/voip/stickers/entity/c:a	(Lcom/viber/voip/market/g;)Lcom/viber/voip/stickers/entity/c;
            //   149: astore 15
            //   151: aload 10
            //   153: aload 15
            //   155: invokevirtual 72	com/viber/voip/stickers/entity/b:a	(Lcom/viber/voip/stickers/entity/c;)V
            //   158: aload 15
            //   160: lload_1
            //   161: invokevirtual 75	com/viber/voip/stickers/entity/c:a	(J)V
            //   164: aload 10
            //   166: aload 7
            //   168: invokevirtual 78	com/viber/voip/stickers/entity/b:a	(Ljava/lang/String;)V
            //   171: aload 10
            //   173: aload 8
            //   175: invokevirtual 81	com/viber/voip/stickers/entity/b:a	([Ljava/lang/String;)V
            //   178: aload 10
            //   180: iconst_1
            //   181: invokevirtual 84	com/viber/voip/stickers/entity/b:a	(Z)V
            //   184: aload_0
            //   185: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   188: aload_0
            //   189: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   192: aload 10
            //   194: aload_0
            //   195: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   198: invokestatic 88	com/viber/voip/stickers/i:m	(Lcom/viber/voip/stickers/i;)Ljava/util/List;
            //   201: invokestatic 91	com/viber/voip/stickers/i:a	(Lcom/viber/voip/stickers/i;Lcom/viber/voip/stickers/entity/b;Ljava/util/List;)Ljava/util/List;
            //   204: invokestatic 94	com/viber/voip/stickers/i:a	(Lcom/viber/voip/stickers/i;Ljava/util/List;)Ljava/util/List;
            //   207: pop
            //   208: aload_0
            //   209: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   212: invokestatic 97	com/viber/voip/stickers/i:a	(Lcom/viber/voip/stickers/i;)Lcom/viber/voip/stickers/b/a;
            //   215: aload 10
            //   217: invokevirtual 102	com/viber/voip/stickers/b/a:a	(Lcom/viber/voip/stickers/entity/b;)V
            //   220: getstatic 104	com/viber/voip/stickers/i$a:f	Lcom/viber/voip/stickers/i$a;
            //   223: aload_0
            //   224: getfield 24	com/viber/voip/stickers/i$10:b	Lcom/viber/voip/stickers/i$a;
            //   227: if_acmpne +27 -> 254
            //   230: aload 10
            //   232: iconst_1
            //   233: invokevirtual 107	com/viber/voip/stickers/entity/b:h	(Z)V
            //   236: aload 10
            //   238: iconst_1
            //   239: invokevirtual 109	com/viber/voip/stickers/entity/b:c	(I)V
            //   242: aload_0
            //   243: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   246: invokestatic 97	com/viber/voip/stickers/i:a	(Lcom/viber/voip/stickers/i;)Lcom/viber/voip/stickers/b/a;
            //   249: aload 10
            //   251: invokevirtual 102	com/viber/voip/stickers/b/a:a	(Lcom/viber/voip/stickers/entity/b;)V
            //   254: aload_0
            //   255: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   258: invokestatic 113	com/viber/voip/stickers/i:n	(Lcom/viber/voip/stickers/i;)Lcom/viber/voip/util/LongSparseSet;
            //   261: astore 12
            //   263: aload 12
            //   265: monitorenter
            //   266: aload_0
            //   267: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   270: invokestatic 113	com/viber/voip/stickers/i:n	(Lcom/viber/voip/stickers/i;)Lcom/viber/voip/util/LongSparseSet;
            //   273: aload_0
            //   274: getfield 22	com/viber/voip/stickers/i$10:a	I
            //   277: i2l
            //   278: invokevirtual 118	com/viber/voip/util/LongSparseSet:remove	(J)V
            //   281: aload_0
            //   282: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   285: invokestatic 113	com/viber/voip/stickers/i:n	(Lcom/viber/voip/stickers/i;)Lcom/viber/voip/util/LongSparseSet;
            //   288: invokevirtual 122	com/viber/voip/util/LongSparseSet:size	()I
            //   291: istore 14
            //   293: aload 12
            //   295: monitorexit
            //   296: getstatic 52	com/viber/voip/stickers/i$a:d	Lcom/viber/voip/stickers/i$a;
            //   299: aload_0
            //   300: getfield 24	com/viber/voip/stickers/i$10:b	Lcom/viber/voip/stickers/i$a;
            //   303: if_acmpne +127 -> 430
            //   306: iload 14
            //   308: ifne +11 -> 319
            //   311: aload_0
            //   312: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   315: iconst_0
            //   316: invokestatic 125	com/viber/voip/stickers/i:b	(Lcom/viber/voip/stickers/i;Z)V
            //   319: return
            //   320: aload_0
            //   321: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   324: invokestatic 129	com/viber/voip/stickers/i:l	(Lcom/viber/voip/stickers/i;)Landroid/content/Context;
            //   327: getstatic 134	com/viber/voip/R$string:downloading_stickers	I
            //   330: invokevirtual 140	android/content/Context:getString	(I)Ljava/lang/String;
            //   333: astore 21
            //   335: aload 21
            //   337: astore 6
            //   339: iconst_0
            //   340: anewarray 142	java/lang/String
            //   343: astore 5
            //   345: goto -311 -> 34
            //   348: astore_3
            //   349: aconst_null
            //   350: astore 4
            //   352: aconst_null
            //   353: astore 5
            //   355: aconst_null
            //   356: astore 6
            //   358: aload 6
            //   360: astore 7
            //   362: aload 5
            //   364: astore 8
            //   366: aload 4
            //   368: astore 9
            //   370: goto -312 -> 58
            //   373: aconst_null
            //   374: astore 18
            //   376: goto -284 -> 92
            //   379: aload 10
            //   381: invokevirtual 145	com/viber/voip/stickers/entity/b:h	()Z
            //   384: ifeq -164 -> 220
            //   387: aload 10
            //   389: iconst_1
            //   390: invokevirtual 147	com/viber/voip/stickers/entity/b:f	(Z)V
            //   393: aload 10
            //   395: aload 7
            //   397: invokevirtual 78	com/viber/voip/stickers/entity/b:a	(Ljava/lang/String;)V
            //   400: aload 10
            //   402: aload 8
            //   404: invokevirtual 81	com/viber/voip/stickers/entity/b:a	([Ljava/lang/String;)V
            //   407: aload_0
            //   408: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   411: invokestatic 97	com/viber/voip/stickers/i:a	(Lcom/viber/voip/stickers/i;)Lcom/viber/voip/stickers/b/a;
            //   414: aload 10
            //   416: invokevirtual 102	com/viber/voip/stickers/b/a:a	(Lcom/viber/voip/stickers/entity/b;)V
            //   419: goto -199 -> 220
            //   422: astore 13
            //   424: aload 12
            //   426: monitorexit
            //   427: aload 13
            //   429: athrow
            //   430: aload_0
            //   431: getfield 20	com/viber/voip/stickers/i$10:c	Lcom/viber/voip/stickers/i;
            //   434: aload 10
            //   436: invokevirtual 150	com/viber/voip/stickers/i:b	(Lcom/viber/voip/stickers/entity/a;)V
            //   439: return
            //   440: astore 20
            //   442: aconst_null
            //   443: astore 5
            //   445: aconst_null
            //   446: astore 6
            //   448: goto -90 -> 358
            //   451: astore 25
            //   453: aconst_null
            //   454: astore 5
            //   456: goto -98 -> 358
            //   459: astore 22
            //   461: goto -103 -> 358
            //
            // Exception table:
            //   from	to	target	type
            //   2	11	348	java/io/IOException
            //   266	296	422	finally
            //   424	427	422	finally
            //   20	27	440	java/io/IOException
            //   320	335	440	java/io/IOException
            //   27	34	451	java/io/IOException
            //   339	345	451	java/io/IOException
            //   34	43	459	java/io/IOException
          }
        });
        return;
        localObject1 = finally;
        throw localObject1;
      }
      this.r.post(new k(this, paramInt, parama, paramString));
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if ((v()) && (F().a(paramInt, paramBoolean)));
  }

  public void a(com.viber.voip.stickers.e.a parama)
  {
    try
    {
      this.h.a(parama);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(com.viber.voip.stickers.e.b paramb)
  {
    this.p.a(paramb);
  }

  public void a(Sticker paramSticker)
  {
    if (v())
      F().a(paramSticker);
  }

  void a(com.viber.voip.stickers.entity.a parama)
  {
    if (parama == null)
      return;
    com.viber.voip.market.g.a(parama);
    b(parama);
  }

  public void a(com.viber.voip.stickers.entity.b paramb)
  {
    this.g.a(paramb);
  }

  public void a(final com.viber.voip.stickers.entity.b paramb, boolean paramBoolean)
  {
    if ((this.x == paramb.e()) || (paramb.d()))
      d(paramb.e(), true);
    paramb.g(false);
    this.g.a(paramb, true);
    if (!ao.f())
      this.r.post(new Runnable()
      {
        public void run()
        {
          String str = i.a(i.this).f();
          if (str != null)
            ViberApplication.getInstance().getEngine(false).getCdrController().handleReportStickerPacksInStrickerMenu(str, String.valueOf(paramb.e()));
        }
      });
    if (paramBoolean)
      e().d();
    c(false);
  }

  void a(List<Integer> paramList)
  {
    List localList = l();
    Iterator localIterator1 = localList.iterator();
    int i1 = 0;
    int i4;
    if (localIterator1.hasNext())
    {
      int i3 = ((Integer)localIterator1.next()).intValue();
      if (paramList.contains(Integer.valueOf(i3)))
        break label150;
      i4 = i1 + 1;
      B(i3);
    }
    while (true)
    {
      i1 = i4;
      break;
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        int i2 = ((Integer)localIterator2.next()).intValue();
        if ((!localList.contains(Integer.valueOf(i2))) && (g(i2) == null))
        {
          i1++;
          A(i2);
        }
      }
      if (i1 > 0)
        c(false);
      return;
      label150: i4 = i1;
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      C();
  }

  public void a(final boolean paramBoolean, final Runnable paramRunnable)
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        i.o(i.this).a();
        List localList = i.this.h();
        int i = i.this.m();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localIterator.next();
          if ((paramBoolean) || ((locala.e() != i) && (locala.e() != 400) && (locala.e() != 143700) && (locala.e() != 133600)))
          {
            com.viber.voip.notif.g.a(i.l(i.this)).c().a(locala.e());
            at.h(com.viber.voip.stickers.c.g.a(i.l(i.this), locala.e()));
          }
        }
        i.a(i.this).a(i, paramBoolean);
        i.b(i.this, false);
        synchronized (i.p(i.this))
        {
          i.p(i.this).clear();
          if (paramRunnable != null)
            paramRunnable.run();
          return;
        }
      }
    });
    if (d.ax.s.d())
      com.viber.voip.billing.l.a().a(null);
  }

  public void a(int[] paramArrayOfInt)
  {
    SparseArray localSparseArray1 = this.g.a(paramArrayOfInt);
    SparseArray localSparseArray2 = this.s;
    int i1 = 0;
    try
    {
      while (i1 < paramArrayOfInt.length)
      {
        int i2 = paramArrayOfInt[i1];
        Sticker localSticker = (Sticker)localSparseArray1.get(i2);
        SparseArray localSparseArray3 = this.s;
        if (localSticker == null)
          localSticker = new Sticker(i2);
        localSparseArray3.put(i2, localSticker);
        i1++;
      }
      return;
    }
    finally
    {
    }
  }

  public com.viber.voip.bot.item.b<Sticker>[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = this.y;
    g localg;
    com.viber.voip.bot.item.b[] arrayOfb2;
    long l1;
    if ((paramInt1 != this.x) || (localObject1 == null))
    {
      com.viber.voip.stickers.entity.a locala = g(paramInt1);
      if ((locala != null) && (locala.j()))
      {
        int i4 = this.e.a();
        if ((i4 == 1) || ((i4 == 0) && (!d.af.c.d()) && (!by.a(this.c))))
          a(locala);
      }
      ArrayList localArrayList = new ArrayList();
      if (locala != null)
      {
        localArrayList.addAll(s(paramInt1));
        if ((localArrayList.size() == 0) && (!locala.h()) && (locala.g()))
          b(locala);
      }
      e().a(paramInt1);
      localg = new g(localArrayList, paramInt1, p.a(paramInt1).d());
      this.y = localg;
      com.viber.voip.bot.item.b[] arrayOfb1 = localg.b();
      int i1 = arrayOfb1.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        Iterator localIterator = arrayOfb1[i2].a().iterator();
        while (localIterator.hasNext())
        {
          Sticker localSticker = (Sticker)localIterator.next();
          synchronized (this.s)
          {
            this.s.put(localSticker.id, localSticker);
            if (!localSticker.isReady())
              this.j.a(localSticker);
          }
        }
      }
      this.x = paramInt1;
      if (!paramBoolean)
        break label390;
      arrayOfb2 = localg.a();
      if (paramInt2 < 0)
        break label433;
      l1 = System.currentTimeMillis();
      if (-2 + arrayOfb2.length > paramInt2)
        break label400;
      int i3 = -1 + arrayOfb2.length;
      a(arrayOfb2[i3], paramBoolean, l1);
      if (i3 - 1 <= 0)
        break label433;
      a(arrayOfb2[(i3 - 1)], paramBoolean, l1);
    }
    label390: label400: label433: for (localObject1 = localg; ; localObject1 = localg)
    {
      if (!paramBoolean)
        break label440;
      return ((g)localObject1).a();
      arrayOfb2 = localg.b();
      break;
      a(arrayOfb2[paramInt2], paramBoolean, l1);
      if (arrayOfb2.length > paramInt2 + 1)
        a(arrayOfb2[(paramInt2 + 1)], paramBoolean, l1);
    }
    label440: return ((g)localObject1).b();
  }

  public String[] a(String paramString, ci<com.viber.voip.stickers.entity.a> paramci)
  {
    ArrayList localArrayList1 = new ArrayList(h());
    if (localArrayList1 == null)
      return new String[0];
    if (paramString == null)
      paramString = "";
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    int i1 = localArrayList1.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localArrayList1.get(i2);
      if ((paramci == null) || (paramci.apply(locala)))
        localArrayList2.add(paramString + locala.e());
    }
    return (String[])localArrayList2.toArray(new String[localArrayList2.size()]);
  }

  @Deprecated
  public com.viber.voip.stickers.a.a b()
  {
    return this.A;
  }

  public Sticker b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Sticker localSticker;
    int i1;
    synchronized (this.s)
    {
      localSticker = (Sticker)this.s.get(paramInt1);
      i1 = 0;
      if (localSticker == null)
      {
        localSticker = this.g.b(paramInt1);
        i1 = 0;
        if (localSticker == null)
        {
          localSticker = new Sticker(paramInt1, paramInt2);
          if (!localSticker.isReady())
            break label141;
          b(localSticker);
        }
      }
    }
    synchronized (this.s)
    {
      label141: 
      do
      {
        this.s.put(localSticker.id, localSticker);
        if ((i1 == 0) && (paramBoolean))
        {
          localSticker.checkStatus();
          if (!localSticker.isReady())
            a(localSticker);
        }
        return localSticker;
        localObject1 = finally;
        throw localObject1;
        i1 = 0;
      }
      while (!paramBoolean);
      i1 = 1;
      a(localSticker);
    }
  }

  public String b(String paramString)
  {
    String[] arrayOfString = a(paramString, null);
    StringBuilder localStringBuilder = new StringBuilder(7 * arrayOfString.length);
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
    {
      localStringBuilder.append(arrayOfString[i1]);
      if (i1 + 1 < arrayOfString.length)
        localStringBuilder.append(',');
    }
    return localStringBuilder.toString();
  }

  public void b(int paramInt)
  {
    this.h.b(paramInt);
  }

  public void b(com.viber.voip.stickers.e.a parama)
  {
    try
    {
      this.h.b(parama);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(com.viber.voip.stickers.e.b paramb)
  {
    this.p.b(paramb);
  }

  public void b(final Sticker paramSticker)
  {
    try
    {
      if (!paramSticker.isOwned())
        c(paramSticker);
      f.a(paramSticker, true);
      paramSticker.checkStatus();
      if (paramSticker.isSvg())
        this.z.a(paramSticker);
      e().b(paramSticker);
      if (!paramSticker.isOwned())
        this.g.a(paramSticker);
      this.q.post(new Runnable()
      {
        public void run()
        {
          i.k(i.this).onStickerDeployed(paramSticker);
        }
      });
      return;
    }
    catch (IOException localIOException)
    {
    }
    catch (c localc)
    {
    }
  }

  public void b(com.viber.voip.stickers.entity.a parama)
  {
    if (parama == null);
    int i2;
    a local9;
    label165: 
    do
    {
      return;
      if (parama.e() == this.x)
        this.y = null;
      int i1 = parama.e();
      if (((parama.d()) || (parama.h())) && (!parama.o()));
      for (i2 = 1; ; i2 = 0)
      {
        local9 = new a(this.c, i1, parama.f())
        {
          protected void a(int paramAnonymousInt)
          {
            i.k(i.this).b(this);
          }

          protected void b(int paramAnonymousInt)
          {
            i.k(i.this).b(this);
          }
        };
        if (!v())
          break label165;
        String str1 = com.viber.voip.stickers.c.g.a(i1, p.a);
        String str2 = com.viber.voip.stickers.c.g.g(i1);
        if ((!ViberApplication.getInstance().getDownloadValve().c(str1)) || (!ViberApplication.getInstance().getDownloadValve().c(str2)) || (!F().a(parama)) || (i2 == 0))
          break;
        this.p.a(local9);
        local9.a();
        return;
      }
    }
    while (i2 == 0);
    local9.onStickerPackageDownloadError(false, parama);
  }

  void b(List<com.viber.voip.stickers.entity.b> paramList)
  {
    this.g.b(paramList);
  }

  public void b(boolean paramBoolean)
  {
    long l1 = d.ax.u.d();
    if ((paramBoolean) || (l1 == 0L) || (System.currentTimeMillis() >= l1))
    {
      Engine localEngine = ViberApplication.getInstance().getEngine(false);
      localEngine.registerDelegate(this.K);
      ServiceStateListener localServiceStateListener = localEngine.getDelegatesManager().getServiceStateListener();
      ServiceStateDelegate[] arrayOfServiceStateDelegate = new ServiceStateDelegate[1];
      arrayOfServiceStateDelegate[0] = this.L;
      localServiceStateListener.registerDelegate(arrayOfServiceStateDelegate);
      if (localEngine.isInitialized())
      {
        localEngine.getPhoneController().handleGetPersonalProfile();
        localEngine.getDelegatesManager().getServiceStateListener().removeDelegate(this.L);
      }
    }
  }

  public com.viber.voip.bot.item.b<Sticker>[] b(int paramInt, boolean paramBoolean)
  {
    return a(paramInt, -1, paramBoolean);
  }

  public Sticker c(int paramInt, boolean paramBoolean)
  {
    return b(paramInt, 0, paramBoolean);
  }

  public void c()
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        int i = d.ax.f.d();
        if (3 != i)
          if (d.ad.j.d())
          {
            if (i != 1)
              break label82;
            d.ax.l.a(0);
          }
        while (true)
        {
          d.ax.f.a(3);
          if (!d.ad.j.d())
            break;
          if (d.ax.h.d())
            i.e(i.this);
          if (d.ax.A.d())
            i.f(i.this);
          return;
          label82: if (i == 2)
            i.this.n();
        }
        d.ax.h.a(false);
        d.ax.A.a(false);
      }
    });
  }

  public void c(int paramInt)
  {
    this.h.d(paramInt);
  }

  public void c(final List<? extends com.viber.voip.stickers.entity.d> paramList)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = paramList.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          com.viber.voip.stickers.entity.d locald = (com.viber.voip.stickers.entity.d)localIterator.next();
          i += i.a(i.this).a(locald);
        }
        if (i > 0)
          i.b(i.this, false);
      }
    });
  }

  public void d()
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList(g());
      ArrayList localArrayList2 = new ArrayList(i());
      this.h.a(localArrayList1, localArrayList2);
      return;
    }
    finally
    {
    }
  }

  public void d(int paramInt)
  {
    this.h.c(paramInt);
  }

  public void d(List<Sticker> paramList)
  {
    this.g.a(paramList);
  }

  @Deprecated
  public f e()
  {
    if (this.f == null)
      this.f = new f(this);
    return this.f;
  }

  void e(int paramInt)
  {
    com.viber.voip.stickers.entity.a locala = g(paramInt);
    if ((locala != null) && (locala.g()))
    {
      f(paramInt);
      return;
    }
    a(paramInt, a.f);
  }

  public x f()
  {
    return this.z;
  }

  void f(final int paramInt)
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        i.g(i.this).a(paramInt);
        i.a(i.this).g(paramInt);
        i.b(i.this, false);
      }
    });
  }

  public com.viber.voip.stickers.entity.a g(int paramInt)
  {
    return a(paramInt, h());
  }

  public List<com.viber.voip.stickers.entity.a> g()
  {
    try
    {
      List localList = this.u;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public com.viber.voip.stickers.entity.a h(int paramInt)
  {
    return a(paramInt, g());
  }

  public List<com.viber.voip.stickers.entity.a> h()
  {
    try
    {
      List localList = this.w;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public List<com.viber.voip.stickers.entity.a> i()
  {
    try
    {
      List localList = this.v;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean i(int paramInt)
  {
    return F().d(paramInt);
  }

  public com.viber.voip.stickers.entity.a j()
  {
    try
    {
      com.viber.voip.stickers.entity.a locala = g(143700);
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean j(int paramInt)
  {
    return F().e(paramInt);
  }

  public com.viber.voip.stickers.entity.a k()
  {
    try
    {
      com.viber.voip.stickers.entity.a locala = g(133600);
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean k(int paramInt)
  {
    com.viber.voip.stickers.entity.a locala = g(paramInt);
    return (locala != null) && (!locala.h());
  }

  // ERROR //
  public List<Integer> l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 139	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 140	java/util/ArrayList:<init>	()V
    //   9: astore_1
    //   10: aload_0
    //   11: monitorenter
    //   12: new 139	java/util/ArrayList
    //   15: dup
    //   16: aload_0
    //   17: invokevirtual 950	com/viber/voip/stickers/i:h	()Ljava/util/List;
    //   20: invokespecial 526	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: invokeinterface 500 1 0
    //   32: astore 5
    //   34: aload 5
    //   36: invokeinterface 505 1 0
    //   41: ifeq +55 -> 96
    //   44: aload 5
    //   46: invokeinterface 509 1 0
    //   51: checkcast 511	com/viber/voip/stickers/entity/a
    //   54: astore 6
    //   56: aload 6
    //   58: invokeinterface 922 1 0
    //   63: ifeq -29 -> 34
    //   66: aload_1
    //   67: aload 6
    //   69: invokeinterface 514 1 0
    //   74: invokestatic 860	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: invokevirtual 970	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: goto -47 -> 34
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    //   89: astore 4
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 4
    //   95: athrow
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	12	84	finally
    //   26	34	84	finally
    //   34	81	84	finally
    //   93	96	84	finally
    //   12	26	89	finally
    //   91	93	89	finally
  }

  public boolean l(int paramInt)
  {
    com.viber.voip.stickers.entity.a locala = g(paramInt);
    return (locala != null) && (locala.g());
  }

  int m()
  {
    Iterator localIterator = new ArrayList(h()).iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localIterator.next();
      if ((locala.o()) && (locala.c()))
        return locala.e();
    }
    return -1;
  }

  public boolean m(int paramInt)
  {
    com.viber.voip.stickers.entity.a locala = h(paramInt);
    return (locala != null) && ((locala.s()) || (locala.c()) || (locala.l()));
  }

  void n()
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = i.a(i.this).a().iterator();
        while (true)
          if (localIterator.hasNext())
          {
            Sticker localSticker = (Sticker)localIterator.next();
            if (localSticker.isSvg())
            {
              boolean bool = localSticker.isAnimated();
              try
              {
                i.this.A().b(localSticker);
                if (localSticker.isAnimated() != bool)
                  i.a(i.this).a(localSticker);
              }
              catch (IOException localIOException)
              {
                while (true)
                  localIOException.printStackTrace();
              }
            }
          }
      }
    });
  }

  public boolean n(int paramInt)
  {
    if (j(paramInt))
    {
      b(g(paramInt));
      return true;
    }
    return false;
  }

  public g.a o()
  {
    return F().b();
  }

  public void o(int paramInt)
  {
    av.e.f.a().post(new j(this, paramInt));
  }

  public void p()
  {
    e().a();
  }

  public void p(int paramInt)
  {
    if ((v()) && (F().b(paramInt)));
  }

  public void q()
  {
    this.z.a();
    this.z.b();
    e().b();
  }

  public void q(int paramInt)
  {
    if ((v()) && (F().c(paramInt)));
  }

  public void r()
  {
    synchronized (this.s)
    {
      this.s.clear();
      return;
    }
  }

  public void r(int paramInt)
  {
    com.viber.voip.stickers.entity.b localb = (com.viber.voip.stickers.entity.b)g(paramInt);
    if (localb == null)
      return;
    try
    {
      this.t.add(paramInt);
      int i1 = g().size();
      int i2 = g().indexOf(localb);
      if ((i2 >= 0) && (i1 > 1))
        if (i2 >= i1 - 1)
          break label161;
      label161: for (com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)g().get(i2 + 1); ; locala = (com.viber.voip.stickers.entity.a)g().get(i2 - 1))
      {
        if (locala != null)
          d.ax.j.a(locala.e());
        g().remove(localb);
        i().remove(localb);
        h().remove(localb);
        d();
        this.r.post(new l(this, paramInt));
        return;
      }
    }
    finally
    {
    }
  }

  List<Sticker> s(int paramInt)
  {
    return this.g.c(paramInt);
  }

  public void s()
  {
  }

  public List<com.viber.voip.stickers.entity.b> t()
  {
    return this.g.e();
  }

  public void t(int paramInt)
  {
    b(paramInt, 0, true);
  }

  public Sticker u(int paramInt)
  {
    return b(paramInt, 0, true);
  }

  @Deprecated
  public q u()
  {
    return this.j;
  }

  public void v(int paramInt)
  {
    synchronized (this.s)
    {
      this.s.delete(paramInt);
      return;
    }
  }

  // ERROR //
  public boolean v()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 223	com/viber/voip/stickers/i:c	Landroid/content/Context;
    //   4: invokestatic 1190	com/viber/voip/util/cj:b	(Landroid/content/Context;)Z
    //   7: ifne +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: invokestatic 1192	com/viber/voip/stickers/i:w	()Z
    //   15: ifeq -5 -> 10
    //   18: aload_0
    //   19: getfield 1194	com/viber/voip/stickers/i:I	Z
    //   22: ifeq +5 -> 27
    //   25: iconst_1
    //   26: ireturn
    //   27: getstatic 1199	com/viber/voip/util/dv:g	Lcom/viber/voip/util/dv;
    //   30: aload_0
    //   31: getfield 223	com/viber/voip/stickers/i:c	Landroid/content/Context;
    //   34: ldc_w 1201
    //   37: invokevirtual 1204	com/viber/voip/util/dv:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +51 -> 93
    //   45: aload_1
    //   46: invokevirtual 1207	java/io/File:canWrite	()Z
    //   49: ifeq +44 -> 93
    //   52: new 1209	java/io/FileWriter
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 1212	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   60: astore_2
    //   61: aload_2
    //   62: ldc_w 1214
    //   65: invokevirtual 1217	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 1194	com/viber/voip/stickers/i:I	Z
    //   73: iconst_1
    //   74: anewarray 1219	java/io/Flushable
    //   77: dup
    //   78: iconst_0
    //   79: aload_2
    //   80: aastore
    //   81: invokestatic 1224	com/viber/voip/util/bj:a	([Ljava/io/Flushable;)V
    //   84: aload_2
    //   85: invokestatic 1227	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   88: aload_1
    //   89: invokevirtual 1229	java/io/File:delete	()Z
    //   92: pop
    //   93: aload_0
    //   94: getfield 1194	com/viber/voip/stickers/i:I	Z
    //   97: ireturn
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: getstatic 93	com/viber/voip/stickers/i:a	Lcom/viber/dexshared/Logger;
    //   104: aload_3
    //   105: ldc_w 1231
    //   108: invokeinterface 1236 3 0
    //   113: iconst_1
    //   114: anewarray 1219	java/io/Flushable
    //   117: dup
    //   118: iconst_0
    //   119: aload_2
    //   120: aastore
    //   121: invokestatic 1224	com/viber/voip/util/bj:a	([Ljava/io/Flushable;)V
    //   124: aload_2
    //   125: invokestatic 1227	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   128: aload_1
    //   129: invokevirtual 1229	java/io/File:delete	()Z
    //   132: pop
    //   133: goto -40 -> 93
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_2
    //   140: iconst_1
    //   141: anewarray 1219	java/io/Flushable
    //   144: dup
    //   145: iconst_0
    //   146: aload_2
    //   147: aastore
    //   148: invokestatic 1224	com/viber/voip/util/bj:a	([Ljava/io/Flushable;)V
    //   151: aload_2
    //   152: invokestatic 1227	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   155: aload_1
    //   156: invokevirtual 1229	java/io/File:delete	()Z
    //   159: pop
    //   160: aload 4
    //   162: athrow
    //   163: astore 4
    //   165: goto -25 -> 140
    //   168: astore_3
    //   169: goto -68 -> 101
    //
    // Exception table:
    //   from	to	target	type
    //   52	61	98	java/io/IOException
    //   52	61	136	finally
    //   61	73	163	finally
    //   101	113	163	finally
    //   61	73	168	java/io/IOException
  }

  public Float w(int paramInt)
  {
    return this.n.a(paramInt);
  }

  public int x()
  {
    int i1 = y();
    if (m(i1))
      return i1;
    return 0;
  }

  public int y()
  {
    return d.ax.l.d();
  }

  public boolean z()
  {
    return this.B;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
    }
  }

  private static final class b
  {
    private static final i a;

    static
    {
      if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a);
      for (i locali = new i(null); ; locali = null)
      {
        a = locali;
        return;
      }
    }
  }

  public static class c extends Exception
  {
    public c()
    {
      super();
    }
  }

  class d
  {
    private String b;
    private int c;

    public d(String paramInt, int arg3)
    {
      this.b = paramInt;
      int i;
      this.c = i;
    }

    public String a()
    {
      return this.b;
    }

    public void a(int paramInt)
    {
      this.c = paramInt;
    }

    public void a(String paramString)
    {
      if (paramString == null)
        paramString = "";
      this.b = paramString;
    }

    public int b()
    {
      return this.c;
    }

    public String toString()
    {
      return "PurchasedPackagesSourceInfo{mClassName='" + this.b + '\'' + ", mNumberOfPurchasedPackages=" + this.c + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.i
 * JD-Core Version:    0.6.2
 */
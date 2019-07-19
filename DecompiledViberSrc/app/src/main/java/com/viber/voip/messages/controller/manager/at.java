package com.viber.voip.messages.controller.manager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSyncDataFromMyOtherDeviceMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesReplyMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.f.d.a;
import com.viber.voip.backup.f.d.a.a;
import com.viber.voip.backup.g;
import com.viber.voip.backup.g.b;
import com.viber.voip.backup.j;
import com.viber.voip.backup.t;
import com.viber.voip.registration.af;
import com.viber.voip.ui.am;
import com.viber.voip.util.az;
import com.viber.voip.util.d.b;
import com.viber.voip.util.da;
import com.viber.voip.util.i;
import com.viber.voip.util.i.e;
import com.viber.voip.util.upload.ObjectId;
import dagger.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class at
  implements SyncHistoryCommunicator, av
{
  static final long a = TimeUnit.SECONDS.toMillis(10L);
  private static final Logger b = ViberEnv.getLogger();
  private final a<com.google.d.f> c;
  private final com.viber.voip.i.f d;
  private final e e;
  private final Im2Exchanger f;
  private final PhoneController g;
  private final ConnectionController h;
  private final az i;
  private final com.viber.voip.util.d j;
  private final Map<Integer, b> k;
  private final g l;
  private final a m;
  private final am n;
  private volatile boolean o = false;
  private SyncHistoryCommunicator.b p = SyncHistoryCommunicator.b.a;
  private final ReentrantLock q = new ReentrantLock(true);
  private final SyncHistoryCommunicator.a r;
  private final at.c.a s = new at.c.a()
  {
    public void a()
    {
      at.a(at.this).unlock();
    }
  };
  private final d.b t = new d.b()
  {
    private boolean b = false;

    private boolean a(boolean paramAnonymousBoolean)
    {
      if (this.b != paramAnonymousBoolean)
      {
        this.b = paramAnonymousBoolean;
        at.a(at.this, paramAnonymousBoolean);
        return true;
      }
      return false;
    }

    public void onAppStopped()
    {
    }

    public void onBackground()
    {
      if (!a(true))
        return;
      at.b(at.this);
    }

    public void onForeground()
    {
      if (!a(false));
      do
      {
        return;
        if (at.this.a())
        {
          at.c(at.this).c();
          return;
        }
      }
      while (!at.this.a(4));
      at.c(at.this).e();
    }

    public void onForegroundStateChanged(boolean paramAnonymousBoolean)
    {
      i.a(this, paramAnonymousBoolean);
    }
  };
  private final ConnectionDelegate u = new ConnectionDelegate()
  {
    public void onConnect()
    {
      ArrayList localArrayList = new ArrayList(at.d(at.this).values());
      at.d(at.this).clear();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        at.b localb = (at.b)localIterator.next();
        at.a(at.this, at.b.a(localb), at.b.b(localb));
      }
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
    }
  };
  private final c v = new c()
  {
    public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
    {
      try
      {
        if (at.e(at.this).b())
          at.this.a();
        while (true)
        {
          return;
          at.f(at.this);
        }
      }
      finally
      {
        paramAnonymousa.a();
      }
    }
  };
  private final c w = new c()
  {
    public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
    {
      try
      {
        at.c(at.this).b();
        return;
      }
      finally
      {
        paramAnonymousa.a();
      }
    }
  };
  private final c x = new c()
  {
    public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
    {
      try
      {
        at.c(at.this).f();
        return;
      }
      finally
      {
        paramAnonymousa.a();
      }
    }
  };
  private final c y = new c()
  {
    public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
    {
      try
      {
        at.c(at.this).d();
        return;
      }
      finally
      {
        paramAnonymousa.a();
      }
    }
  };

  at(a<com.google.d.f> parama, com.viber.voip.i.f paramf, e parame, Context paramContext, af paramaf, Im2Exchanger paramIm2Exchanger, Engine paramEngine, com.viber.voip.util.d paramd, az paramaz, g paramg, am paramam)
  {
    this.c = parama;
    this.d = paramf;
    this.e = parame;
    this.f = paramIm2Exchanger;
    this.g = paramEngine.getPhoneController();
    this.h = paramEngine.getConnectionController();
    this.i = paramaz;
    this.j = paramd;
    this.l = paramg;
    this.m = new a(paramEngine, paramContext, paramaf, this.l);
    this.n = paramam;
    this.r = new SyncHistoryCommunicator.a();
    this.k = new LinkedHashMap();
  }

  private void a(final int paramInt, final boolean paramBoolean)
  {
    a(new c()
    {
      public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
      {
        try
        {
          at.c(at.this).a(paramInt);
          paramAnonymousa.a();
          if ((paramAnonymousb.b != null) && (paramBoolean))
            at.a(at.this, at.g(at.this).a(paramAnonymousb.b, paramInt));
          return;
        }
        finally
        {
          paramAnonymousa.a();
        }
      }
    }
    , new int[] { 5 });
  }

  private void a(final SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
  {
    this.i.b(new Runnable()
    {
      public void run()
      {
        if (at.a(at.this, SyncHistoryCommunicator.b.a(paramSyncHistoryMessage, 1), at.j(at.this), new int[] { 0 }))
          return;
        at.a(at.this, at.g(at.this).b(paramSyncHistoryMessage));
      }
    });
  }

  private void a(final SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, final long paramLong)
  {
    this.i.a(new Runnable()
    {
      public void run()
      {
        at.a(at.this, paramSyncHistoryMessage, paramLong);
      }
    });
  }

  private void a(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, boolean paramBoolean)
  {
    if (paramBoolean);
    for (SyncHistoryCommunicator.SyncHistoryMessage localSyncHistoryMessage = this.r.c(paramSyncHistoryMessage); ; localSyncHistoryMessage = this.r.b(paramSyncHistoryMessage))
    {
      d(localSyncHistoryMessage);
      return;
    }
  }

  private void a(final e parame)
  {
    a(new c()
    {
      public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
      {
        try
        {
          at.k(at.this);
          at.a(at.this, SyncHistoryCommunicator.b.a, null, new int[0]);
          paramAnonymousa.a();
          if (parame != null)
            parame.a(paramAnonymousb);
          return;
        }
        finally
        {
          paramAnonymousa.a();
        }
      }
    }
    , new int[] { 5 });
  }

  private boolean a(final int paramInt, c paramc, int[] paramArrayOfInt)
  {
    return a(new d()
    {
      public SyncHistoryCommunicator.b a(SyncHistoryCommunicator.b paramAnonymousb)
      {
        return paramAnonymousb.a(paramInt);
      }
    }
    , paramc, paramArrayOfInt);
  }

  private boolean a(final SyncHistoryCommunicator.b paramb, c paramc, int[] paramArrayOfInt)
  {
    return a(new d()
    {
      public SyncHistoryCommunicator.b a(SyncHistoryCommunicator.b paramAnonymousb)
      {
        return paramb;
      }
    }
    , paramc, paramArrayOfInt);
  }

  private boolean a(c paramc, int[] paramArrayOfInt)
  {
    return a(null, paramc, paramArrayOfInt);
  }

  private boolean a(d paramd, c paramc, int[] paramArrayOfInt)
  {
    this.q.lock();
    if ((paramArrayOfInt.length == 0) || (this.p.a(paramArrayOfInt)))
    {
      if (paramd != null)
        this.p = paramd.a(this.p);
      if (paramc != null)
        paramc.a(this.p, this.s);
      while (true)
      {
        return true;
        this.s.a();
      }
    }
    this.s.a();
    return false;
  }

  private void b(final SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
  {
    this.i.b(new Runnable()
    {
      public void run()
      {
        at.b(at.this, paramSyncHistoryMessage);
      }
    });
  }

  private void b(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, long paramLong)
  {
    int i1 = this.g.generateSequence();
    this.k.put(Integer.valueOf(i1), new b(paramSyncHistoryMessage, paramLong));
    if (!this.h.isConnected())
      return;
    CSyncDataToMyDevicesMsg localCSyncDataToMyDevicesMsg = new CSyncDataToMyDevicesMsg(((com.google.d.f)this.c.get()).b(paramSyncHistoryMessage).getBytes(), 0, 2L, i1, paramLong);
    this.f.handleCSyncDataToMyDevicesMsg(localCSyncDataToMyDevicesMsg);
  }

  private void b(final boolean paramBoolean)
  {
    this.i.a(new Runnable()
    {
      public void run()
      {
        SyncHistoryCommunicator.b localb = at.this.b();
        SyncHistoryCommunicator.SyncHistoryMessage localSyncHistoryMessage1 = localb.b;
        if (localSyncHistoryMessage1 != null)
        {
          if (localb.a(new int[] { 5 }));
        }
        else
          return;
        at localat = at.this;
        if (paramBoolean);
        for (SyncHistoryCommunicator.SyncHistoryMessage localSyncHistoryMessage2 = at.g(at.this).d(localSyncHistoryMessage1); ; localSyncHistoryMessage2 = at.g(at.this).e(localSyncHistoryMessage1))
        {
          at.c(localat, localSyncHistoryMessage2);
          return;
        }
      }
    });
  }

  private void c()
  {
    this.n.b(0);
    this.n.e();
    this.n.g();
    this.n.c();
  }

  private void c(final SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
  {
    a(new c()
    {
      public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
      {
        try
        {
          int i = paramAnonymousb.c;
          if (i == 0)
            return;
          SyncHistoryCommunicator.SyncHistoryMessage localSyncHistoryMessage = paramAnonymousb.b;
          if (localSyncHistoryMessage != null)
          {
            boolean bool = da.a(localSyncHistoryMessage.getSecondaryId(), paramSyncHistoryMessage.getSecondaryId());
            if (bool);
          }
          else
          {
            return;
          }
          at.k(at.this);
          at.l(at.this).a();
          at.a(at.this, SyncHistoryCommunicator.b.a, null, new int[0]);
          return;
        }
        finally
        {
          paramAnonymousa.a();
        }
      }
    }
    , new int[0]);
  }

  private void d(final SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
  {
    this.i.a(new Runnable()
    {
      public void run()
      {
        at.a(at.this, paramSyncHistoryMessage, ObjectId.EMPTY.toLong());
      }
    });
  }

  private boolean d()
  {
    return a(this.w, new int[] { 1 });
  }

  private void e(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
  {
    b(paramSyncHistoryMessage, ObjectId.EMPTY.toLong());
  }

  private boolean e()
  {
    return a(this.y, new int[] { 5 });
  }

  public void a(ConnectionListener paramConnectionListener)
  {
    if (this.o)
      return;
    this.o = true;
    if (paramConnectionListener != null)
      paramConnectionListener.registerDelegate(this.u, this.i.a());
    this.n.a();
    this.j.a(this.t);
  }

  public void a(final boolean paramBoolean)
  {
    a(new c()
    {
      public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
      {
        try
        {
          if (paramBoolean)
          {
            at.a(at.this, 5, null, new int[0]);
            at.c(at.this).a(0);
            at.a locala = at.l(at.this);
            SyncHistoryCommunicator.SyncHistoryMessage localSyncHistoryMessage = paramAnonymousb.b;
            Long localLong = null;
            if (localSyncHistoryMessage != null)
              localLong = paramAnonymousb.b.getFromToken();
            locala.a(localLong);
          }
          while (true)
          {
            paramAnonymousa.a();
            if (paramAnonymousb.b != null)
              at.a(at.this, paramAnonymousb.b, paramBoolean);
            return;
            at.a(at.this, SyncHistoryCommunicator.b.a, null, new int[0]);
          }
        }
        finally
        {
          paramAnonymousa.a();
        }
      }
    }
    , new int[] { 1 });
  }

  public boolean a()
  {
    return a(this.x, new int[] { 1 });
  }

  public boolean a(final int paramInt)
  {
    return a(new c()
    {
      public void a(SyncHistoryCommunicator.b paramAnonymousb, at.c.a paramAnonymousa)
      {
        try
        {
          at.c(at.this).b(paramInt);
          return;
        }
        finally
        {
          paramAnonymousa.a();
        }
      }
    }
    , new int[] { 5 });
  }

  SyncHistoryCommunicator.b b()
  {
    this.q.lock();
    try
    {
      SyncHistoryCommunicator.b localb = this.p;
      return localb;
    }
    finally
    {
      this.s.a();
    }
  }

  public void onCSyncDataFromMyOtherDeviceMsg(CSyncDataFromMyOtherDeviceMsg paramCSyncDataFromMyOtherDeviceMsg)
  {
    String str = new String(paramCSyncDataFromMyOtherDeviceMsg.encryptedData);
    this.n.a(str);
    if (!this.d.e());
    SyncHistoryCommunicator.SyncHistoryMessage localSyncHistoryMessage;
    do
    {
      return;
      localSyncHistoryMessage = (SyncHistoryCommunicator.SyncHistoryMessage)((com.google.d.f)this.c.get()).a(str, SyncHistoryCommunicator.SyncHistoryMessage.class);
      if ("Handshake".equals(localSyncHistoryMessage.getAction()))
      {
        e(this.r.a(localSyncHistoryMessage));
        return;
      }
      if ("Request".equals(localSyncHistoryMessage.getAction()))
      {
        if (this.l.b())
        {
          e(this.r.b(localSyncHistoryMessage));
          return;
        }
        a(localSyncHistoryMessage);
        return;
      }
    }
    while (!"Canceled".equals(localSyncHistoryMessage.getAction()));
    b(localSyncHistoryMessage);
  }

  public void onCSyncDataToMyDevicesReplyMsg(CSyncDataToMyDevicesReplyMsg paramCSyncDataToMyDevicesReplyMsg)
  {
    if ((2 != paramCSyncDataToMyDevicesReplyMsg.status) && (1 != paramCSyncDataToMyDevicesReplyMsg.status))
      this.k.remove(Integer.valueOf(paramCSyncDataToMyDevicesReplyMsg.seq));
  }

  class a
    implements d.a, j
  {
    private final long b = TimeUnit.SECONDS.toMillis(30L);
    private final g c;
    private final Engine d;
    private final Context e;
    private final af f;
    private long g = 0L;
    private int h = -1;
    private final Runnable i = new Runnable()
    {
      public void run()
      {
        if (!at.a.a(at.a.this))
          return;
        at.a.a(at.a.this, Math.max(0, at.a.b(at.a.this)), true);
        at.a.c(at.a.this);
      }
    };

    public a(Engine paramContext, Context paramaf, af paramg, g arg5)
    {
      Object localObject;
      this.c = localObject;
      this.d = paramContext;
      this.e = paramaf;
      this.f = paramg;
    }

    private void a(final int paramInt, final boolean paramBoolean)
    {
      at.i(at.this).b(new Runnable()
      {
        public void run()
        {
          at.a(at.this, paramInt, paramBoolean);
        }
      });
    }

    private void a(final at.e parame)
    {
      at.i(at.this).b(new Runnable()
      {
        public void run()
        {
          at.a(at.this, parame);
        }
      });
    }

    private void b()
    {
      d();
      c();
    }

    private void c()
    {
      at.i(at.this).a().postDelayed(this.i, this.b);
    }

    private void d()
    {
      at.i(at.this).a().removeCallbacks(this.i);
    }

    private boolean e()
    {
      return 3 == this.c.c();
    }

    private void f()
    {
      d();
      this.c.c(this);
      this.g = 0L;
      this.h = -1;
    }

    public void a()
    {
      d();
      this.c.a(3);
    }

    public void a(Uri paramUri, int paramInt)
    {
      if (!t.g(paramUri))
        return;
      int j;
      if (t.h(paramUri) == 2)
      {
        j = 50 + paramInt / 2;
        label23: if (j == this.h)
          break label88;
        long l = at.h(at.this).a();
        if (l - this.g < at.a)
          break label90;
        this.g = l;
      }
      label88: label90: for (boolean bool = true; ; bool = false)
      {
        this.h = j;
        a(j, bool);
        b();
        return;
        j = paramInt / 2;
        break label23;
        break;
      }
    }

    public void a(Uri paramUri, com.viber.voip.backup.c.d paramd)
    {
      if (!t.g(paramUri))
        return;
      if ((paramd instanceof com.viber.voip.backup.c.f))
        a(d.a.a.a);
      while (true)
      {
        f();
        return;
        a(new at.e()
        {
          public void a(SyncHistoryCommunicator.b paramAnonymousb)
          {
            if (paramAnonymousb.b != null)
              at.a(at.this, at.g(at.this).a(paramAnonymousb.b, this.a));
          }
        });
      }
    }

    public void a(final d.a.a parama)
    {
      d();
      a(new at.e()
      {
        public void a(SyncHistoryCommunicator.b paramAnonymousb)
        {
          if (paramAnonymousb.b != null)
            at.b(at.this, at.g(at.this).b(paramAnonymousb.b, parama.b), parama.c);
        }
      });
    }

    public void a(Long paramLong)
    {
      if (!this.c.a(this, 3))
      {
        this.c.a(this.d, this.f.l(), this.f.g(), new com.viber.voip.backup.f.d(this), new b().a(this.e, 3), new com.viber.voip.backup.d.a.d().a(paramLong));
        c();
      }
    }

    public boolean a(Uri paramUri)
    {
      return t.g(paramUri);
    }

    public void b(Uri paramUri)
    {
      if (!t.g(paramUri))
        return;
      f();
    }

    public void c(Uri paramUri)
    {
      if (!t.g(paramUri))
        return;
      a(new at.e()
      {
        public void a(SyncHistoryCommunicator.b paramAnonymousb)
        {
          if (paramAnonymousb.b != null)
            at.a(at.this, at.g(at.this).f(paramAnonymousb.b));
        }
      });
      f();
    }
  }

  private static class b
  {
    private final SyncHistoryCommunicator.SyncHistoryMessage a;
    private final long b;

    b(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, long paramLong)
    {
      this.a = paramSyncHistoryMessage;
      this.b = paramLong;
    }
  }

  private static abstract interface c
  {
    public abstract void a(SyncHistoryCommunicator.b paramb, a parama);

    public static abstract interface a
    {
      public abstract void a();
    }
  }

  private static abstract interface d
  {
    public abstract SyncHistoryCommunicator.b a(SyncHistoryCommunicator.b paramb);
  }

  private static abstract interface e
  {
    public abstract void a(SyncHistoryCommunicator.b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.at
 * JD-Core Version:    0.6.2
 */
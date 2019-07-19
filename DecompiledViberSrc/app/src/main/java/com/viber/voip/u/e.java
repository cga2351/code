package com.viber.voip.u;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.jni.ptt.VideoPttControllerDelegate.VideoRecorder;
import com.viber.jni.ptt.VideoPttRecorderListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.av.f;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.IvmInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.i.c.k;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.extras.image.c;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.phone.ViberVideoPttRecord;
import com.viber.voip.phone.vptt.VideoPttRecord;
import com.viber.voip.phone.vptt.VideoPttRecord.Completion;
import com.viber.voip.phone.vptt.VideoPttRecord.StopCompletion;
import com.viber.voip.phone.vptt.VideoPttRecordProxy;
import com.viber.voip.phone.vptt.v2.MrVideoPttRecorder;
import com.viber.voip.phone.vptt.v2.VideoPttCamera;
import com.viber.voip.phone.vptt.v2.VideoPttCamera.VideoSize;
import com.viber.voip.settings.d.bl;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.ptt.PttFactory;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
import org.greenrobot.eventbus.EventBus;
import org.webrtc.EglBase;
import org.webrtc.videoengine.ViberRTCWorkarounds;

public class e extends PhoneControllerDelegateAdapter
  implements DialerControllerDelegate.DialerPhoneState
{
  private static final Logger b = ViberEnv.getLogger();
  d a;
  private final Context c;
  private Handler d;
  private Handler e;
  private VideoPttRecord f;
  private com.viber.voip.q.f g;
  private d h;
  private final EventBus i;
  private boolean j;
  private n k;
  private c l = c.a;
  private long m;
  private int n;
  private String o;
  private volatile long p;
  private byte[] q;
  private com.viber.voip.widget.d.a r;
  private EglBase s;
  private o t;
  private o[] u;
  private g v;
  private ab w;
  private VideoPttCamera x;

  public e(Context paramContext, Handler paramHandler, com.viber.voip.q.f paramf, d paramd, EventBus paramEventBus)
  {
    this.c = paramContext;
    this.d = paramHandler;
    this.g = paramf;
    this.h = paramd;
    this.i = paramEventBus;
    this.e = av.e.a.a();
    this.w = ab.b();
    this.u = new o[n.values().length];
    this.u[n.a.ordinal()] = new f(null);
    this.u[n.b.ordinal()] = new p(null);
    this.u[n.c.ordinal()] = new g(null);
    this.u[n.d.ordinal()] = new m(null);
    this.u[n.e.ordinal()] = new l(null);
    this.u[n.g.ordinal()] = new e(null);
    this.u[n.f.ordinal()] = new q(null);
    this.u[n.h.ordinal()] = new b(null);
    this.u[n.i.ordinal()] = new j(null);
    this.u[n.j.ordinal()] = new i(null);
    a(n.a);
  }

  private MessageEntity a(String paramString, Uri paramUri, long paramLong)
  {
    if (PttFactory.isNewPtt(paramString))
      return b(paramString, paramUri, paramLong);
    return c(paramString, paramUri, paramLong);
  }

  private static void a(Handler paramHandler, Runnable paramRunnable)
  {
    if (Thread.currentThread() == paramHandler.getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    paramHandler.post(paramRunnable);
  }

  private void a(n paramn)
  {
    this.k = paramn;
    if (this.t != null)
      this.t.f();
    this.t = this.u[paramn.ordinal()];
    this.t.a();
  }

  private MessageEntity b(String paramString, Uri paramUri, long paramLong)
  {
    if (da.a(paramString))
      return null;
    if (this.m == 0L)
      return null;
    com.viber.voip.model.entity.h localh = this.w.f(this.m);
    if (localh == null)
      return null;
    com.viber.voip.messages.controller.c.b localb;
    if (localh.b())
      localb = new com.viber.voip.messages.controller.c.b(localh, null);
    while (true)
    {
      MessageEntity localMessageEntity = localb.a(new File(paramString), localh.ad());
      localMessageEntity.setMimeType(1010);
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        int i1 = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(19)).intValue();
        int i2 = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(18)).intValue();
        int i3 = Integer.valueOf(localMediaMetadataRetriever.extractMetadata(24)).intValue();
        if ((i3 == 90) || (i3 == 270))
        {
          int i4 = i1;
          i1 = i2;
          i2 = i4;
        }
        MediaInfo localMediaInfo = new MediaInfo();
        localMediaInfo.setMediaType(MediaInfo.a.VIDEO);
        localMediaInfo.setWidth(i2);
        localMediaInfo.setHeight(i1);
        IvmInfo localIvmInfo = new IvmInfo();
        localIvmInfo.setShape(a.a(this.n));
        MsgInfo localMsgInfo = localMessageEntity.getMessageInfo();
        localMsgInfo.setIvmInfo(localIvmInfo);
        localMsgInfo.getFileInfo().setMediaInfo(localMediaInfo);
        if (paramUri != null)
          localMessageEntity.setBody(paramUri.toString());
        localMessageEntity.setDuration(paramLong);
        localMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
        return localMessageEntity;
        localb = new com.viber.voip.messages.controller.c.b(localh, ak.a().b(localh.V()));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
      }
    }
    return null;
  }

  private VideoPttRecord b(com.viber.voip.widget.d.a parama, EglBase paramEglBase)
  {
    ViberRTCWorkarounds.initParentContextSupported();
    Handler localHandler = av.a(av.e.e);
    if (c.k.b.e())
      return new VideoPttRecordProxy(new MrVideoPttRecorder(parama, g()), localHandler);
    return new VideoPttRecordProxy(new ViberVideoPttRecord(localHandler, parama, paramEglBase), localHandler);
  }

  private MessageEntity c(String paramString, Uri paramUri, long paramLong)
  {
    if (this.m == 0L)
      return null;
    com.viber.voip.model.entity.h localh = this.w.f(this.m);
    if (localh == null)
      return null;
    if (localh.b());
    for (com.viber.voip.messages.controller.c.b localb = new com.viber.voip.messages.controller.c.b(localh, null); ; localb = new com.viber.voip.messages.controller.c.b(localh, ak.a().b(localh.V())))
    {
      MessageEntity localMessageEntity = localb.a(new File(paramString), localh.ad());
      localMessageEntity.setMimeType(14);
      if (paramUri != null)
        localMessageEntity.setBody(paramUri.toString());
      IvmInfo localIvmInfo = new IvmInfo();
      localIvmInfo.setShape(a.a(this.n));
      MsgInfo localMsgInfo = localMessageEntity.getMessageInfo();
      localMsgInfo.setIvmInfo(localIvmInfo);
      localMessageEntity.setRawMessageInfo(com.viber.voip.flatbuffers.b.e.a().b().a(localMsgInfo));
      localMessageEntity.setDuration(paramLong);
      return localMessageEntity;
    }
  }

  private VideoPttCamera g()
  {
    if (this.x == null);
    try
    {
      if (this.x == null)
        this.x = new VideoPttCamera(this.c);
      return this.x;
    }
    finally
    {
    }
  }

  private void h()
  {
    if (f())
      this.f.stopVideoPttRecord(new VideoPttRecord.StopCompletion()
      {
        public void onCompletion(boolean paramAnonymousBoolean, Error paramAnonymousError, byte[] paramAnonymousArrayOfByte)
        {
          e.this.a.onVideoPttRecordError(5);
        }
      });
  }

  public VideoPttCamera.VideoSize a()
  {
    return g().getPreviewOrientationNormalizedSize();
  }

  public void a(final long paramLong, int paramInt)
  {
    this.h.c();
    ISoundService localISoundService = ViberApplication.getInstance().getSoundService();
    if ((localISoundService.isGSMCallActive()) || (localISoundService.isViberCallActive()) || (localISoundService.isRTCCallActive()))
    {
      this.a.onVideoPttRecordError(2);
      return;
    }
    ViberApplication.getInstance().logToCrashlytics("Video Ptt Record Started");
    a(this.d, new Runnable()
    {
      public void run()
      {
        e.a(e.this, paramLong);
        e.a(e.this, this.b);
        e.b(e.this).a(paramLong, e.a(e.this));
      }
    });
  }

  public void a(EngineDelegatesManager paramEngineDelegatesManager)
  {
    this.a = new d(null);
    paramEngineDelegatesManager.getVideoPttRecorderListener().registerDelegate(this.a, this.d);
    this.g.a(new k(this.d));
    paramEngineDelegatesManager.getDialerPhoneStateListener().registerDelegate(this, this.d);
    paramEngineDelegatesManager.registerDelegate(this, this.d);
  }

  public void a(g paramg)
  {
    this.v = paramg;
  }

  public void a(com.viber.voip.widget.d.a parama, EglBase paramEglBase)
  {
    this.r = parama;
    this.s = paramEglBase;
  }

  public void b()
  {
    try
    {
      if (this.x != null)
      {
        this.x.destroy();
        this.x = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c()
  {
    this.a.onVideoPttRecordError(1);
  }

  public void d()
  {
    a(this.d, new Runnable()
    {
      public void run()
      {
        e.b(e.this).d();
      }
    });
  }

  public void e()
  {
    a(this.d, new Runnable()
    {
      public void run()
      {
        e.b(e.this).e();
      }
    });
  }

  public boolean f()
  {
    return ((this.k != null) && (this.k != n.a)) || ((this.f != null) && (this.f.isRecording()));
  }

  public void onGSMStateChange(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
    }
    h();
  }

  public void onPhoneStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
  }

  private abstract class a extends e.o
  {
    private a()
    {
      super(null);
    }

    private void m()
    {
      switch (e.5.a[e.c(e.this).ordinal()])
      {
      case 2:
      case 4:
      default:
        return;
      case 1:
        e.a(e.this, e.n.a);
        return;
      case 3:
        i();
        return;
      case 5:
      }
      j();
    }

    void a()
    {
      m();
    }

    void b()
    {
      super.b();
      m();
    }

    void c()
    {
      super.c();
      m();
    }
  }

  private class b extends e.a
  {
    private b()
    {
      super(null);
    }

    protected void a(int paramInt)
    {
      l();
    }

    boolean a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      super.a(paramString, paramBoolean, paramArrayOfByte);
      new File(paramString).delete();
      l();
      e.a(e.this, e.n.a);
      return true;
    }
  }

  static enum c
  {
    static
    {
      c[] arrayOfc = new c[6];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
      arrayOfc[4] = e;
      arrayOfc[5] = f;
    }
  }

  private class d
    implements VideoPttControllerDelegate.VideoRecorder
  {
    private d()
    {
    }

    public void onVideoPttRecordError(int paramInt)
    {
      e.b(e.this).b(paramInt);
    }

    public void onVideoPttRecordInited()
    {
      e.b(e.this).b();
    }

    public void onVideoPttRecordStarted()
    {
      e.b(e.this).c();
    }

    public void onVideoPttRecordStopped(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      e.b(e.this).a(paramString, paramBoolean, paramArrayOfByte);
    }
  }

  private class e extends e.a
  {
    private e()
    {
      super(null);
    }

    boolean a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      if (super.a(paramString, paramBoolean, paramArrayOfByte))
      {
        k();
        e.a(e.this, e.n.a);
      }
      return true;
    }
  }

  private class f extends e.o
  {
    private f()
    {
      super(null);
    }

    void a()
    {
      e.a(e.this, null);
      e.a(e.this, null);
    }

    void a(long paramLong, int paramInt)
    {
      super.a(paramLong, paramInt);
      if (e.o(e.this))
      {
        e.p(e.this).a(5);
        e.a(e.this, e.n.b);
      }
      while (!h())
        return;
      e.a(e.this, e.n.c);
    }
  }

  private class g extends e.o
  {
    private g()
    {
      super(null);
    }

    void a()
    {
      b();
    }

    void b()
    {
      super.b();
      i();
      if (!c.k.b.e())
        e.a(e.this, e.n.d);
    }

    void d()
    {
      e.a(e.this, e.n.g);
    }

    void e()
    {
      e.a(e.this, e.n.h);
    }
  }

  protected static abstract interface h
  {
    public abstract void a(g paramg);
  }

  private class i extends e.o
  {
    private i()
    {
      super(null);
    }

    void d()
    {
      k();
      e.a(e.this, e.n.a);
    }

    void e()
    {
      l();
      new File(e.d(e.this)).delete();
      e.a(e.this, e.n.a);
    }
  }

  private class j extends e.o
  {
    private boolean b;

    private j()
    {
      super(null);
    }

    void a()
    {
      j();
      this.b = false;
    }

    boolean a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      if (super.a(paramString, paramBoolean, paramArrayOfByte))
      {
        if (!this.b)
          break label33;
        k();
        e.a(e.this, e.n.a);
      }
      while (true)
      {
        return true;
        label33: e.a(e.this, e.n.j);
      }
    }

    void d()
    {
      this.b = true;
    }

    void e()
    {
      e.a(e.this, e.n.h);
    }
  }

  private class k extends com.viber.voip.q.h
  {
    public k(Handler arg2)
    {
      super();
    }

    public void a(String paramString, int paramInt)
    {
      e.a(e.this, false);
      e.b(e.this).g();
    }

    public void a(String paramString, long paramLong)
    {
      e.a(e.this, true);
    }

    public void b(String paramString, long paramLong)
    {
    }

    public void c(String paramString, long paramLong)
    {
    }
  }

  private class l extends e.o
    implements Runnable
  {
    private l()
    {
      super(null);
    }

    void a()
    {
      e.q(e.this).removeCallbacks(this);
      e.q(e.this).postDelayed(this, d.bl.e.d());
    }

    void d()
    {
      e.a(e.this, e.n.f);
      j();
    }

    void e()
    {
      e.a(e.this, e.n.h);
    }

    void f()
    {
      e.q(e.this).removeCallbacks(this);
    }

    public void run()
    {
      if (!c.k.b.e())
        j();
      a(new e.h()
      {
        public void a(g paramAnonymousg)
        {
          paramAnonymousg.B();
        }
      });
      e.a(e.this, e.n.i);
    }
  }

  private class m extends e.o
  {
    private m()
    {
      super(null);
    }

    void c()
    {
      super.c();
      e.e(e.this).post(b.a(1));
      a(new e.h()
      {
        public void a(g paramAnonymousg)
        {
          e.b(e.this, SystemClock.elapsedRealtime());
          paramAnonymousg.A();
        }
      });
      e.a(e.this, e.n.e);
    }

    void d()
    {
      e.a(e.this, e.n.g);
    }

    void e()
    {
      e.a(e.this, e.n.h);
    }
  }

  private static enum n
  {
    static
    {
      n[] arrayOfn = new n[10];
      arrayOfn[0] = a;
      arrayOfn[1] = b;
      arrayOfn[2] = c;
      arrayOfn[3] = d;
      arrayOfn[4] = e;
      arrayOfn[5] = f;
      arrayOfn[6] = g;
      arrayOfn[7] = h;
      arrayOfn[8] = i;
      arrayOfn[9] = j;
    }
  }

  private abstract class o
  {
    private o()
    {
    }

    private Uri a(byte[] paramArrayOfByte)
    {
      try
      {
        Uri localUri = c.a(e.h(e.this), paramArrayOfByte, e.d(e.this));
        return localUri;
      }
      catch (Exception localException)
      {
      }
      return null;
    }

    private void a(final int paramInt, e.n paramn)
    {
      e.a(e.this, paramn);
      e.e(e.this).post(b.b(paramInt));
      e.g(e.this).post(new Runnable()
      {
        public void run()
        {
          if (e.f(e.this) != null)
            e.f(e.this).h(paramInt);
        }
      });
    }

    private void a(e.c paramc)
    {
      e.a(e.this, paramc);
    }

    private void a(String paramString)
    {
      if (e.d(e.this) != null)
        new File(e.d(e.this)).delete();
      if (paramString != null)
        new File(paramString).delete();
      e.a(e.this, null);
    }

    private int d(int paramInt)
    {
      switch (paramInt)
      {
      case 2:
      case 32000:
      default:
        return 32000;
      case 0:
        return 1;
      case 1:
        return 2;
      case 5:
      }
      return 3;
    }

    void a()
    {
    }

    protected void a(int paramInt)
    {
      c(paramInt);
    }

    void a(long paramLong, int paramInt)
    {
      e.a(e.this, paramLong);
      e.a(e.this, paramInt);
    }

    protected void a(final e.h paramh)
    {
      e.g(e.this).post(new Runnable()
      {
        public void run()
        {
          if (e.f(e.this) != null)
            paramh.a(e.f(e.this));
        }
      });
    }

    boolean a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      if ((e.c(e.this) == e.c.a) && (e.d(e.this) == null) && (paramString == null))
      {
        e.a(e.this, null);
        return false;
      }
      a(e.c.a);
      if ((e.d(e.this) == null) || (!e.d(e.this).equals(paramString)))
      {
        a(paramString);
        c(32000);
        e.a(e.this, null);
        return false;
      }
      if (paramBoolean)
      {
        a(paramString);
        c(0);
        e.a(e.this, null);
        return false;
      }
      e.a(e.this, paramArrayOfByte);
      return true;
    }

    void b()
    {
      a(e.c.c);
    }

    void b(int paramInt)
    {
      if (e.d(e.this) != null)
        new File(e.d(e.this)).delete();
      a(d(paramInt));
      e.a(e.this, e.n.a);
    }

    void c()
    {
      a(e.c.e);
    }

    protected void c(int paramInt)
    {
      a(paramInt, e.n.a);
    }

    void d()
    {
    }

    void e()
    {
    }

    void f()
    {
    }

    void g()
    {
    }

    protected boolean h()
    {
      File localFile = dv.A.b(e.h(e.this), null, false);
      if (localFile != null)
      {
        e.a(e.this, localFile.toString());
        a(e.c.b);
        e.i(e.this).c();
        if (c.k.b.e())
          e.this.a.onVideoPttRecordInited();
        return true;
      }
      c(2);
      return false;
    }

    protected void i()
    {
      a(e.c.d);
      e.i(e.this).c();
      if (e.j(e.this) != null)
      {
        e.j(e.this).dispose();
        e.a(e.this, null);
      }
      e.a(e.this, e.a(e.this, e.k(e.this), e.l(e.this)));
      e.j(e.this).startVideoPttRecord(e.d(e.this), new VideoPttRecord.Completion()
      {
        public void onCompletion(Error paramAnonymousError)
        {
          if (paramAnonymousError != null)
          {
            e.this.a.onVideoPttRecordError(1);
            return;
          }
          if (c.k.b.e())
            e.a(e.this, e.n.d);
          e.this.a.onVideoPttRecordStarted();
        }
      });
    }

    protected void j()
    {
      a(e.c.f);
      e.j(e.this).stopVideoPttRecord(new VideoPttRecord.StopCompletion()
      {
        public void onCompletion(boolean paramAnonymousBoolean, Error paramAnonymousError, byte[] paramAnonymousArrayOfByte)
        {
          av.f.b.execute(new f(this, paramAnonymousError, paramAnonymousBoolean, paramAnonymousArrayOfByte));
        }
      });
    }

    protected void k()
    {
      String str = e.d(e.this);
      if (e.m(e.this) == null);
      for (Uri localUri = null; ; localUri = a(e.m(e.this)))
      {
        long l = Math.min(d.bl.e.d(), SystemClock.elapsedRealtime() - e.n(e.this));
        final MessageEntity localMessageEntity = e.a(e.this, str, localUri, l);
        e.e(e.this).post(b.a(localMessageEntity));
        a(new e.h()
        {
          public void a(g paramAnonymousg)
          {
            paramAnonymousg.a(localMessageEntity);
          }
        });
        return;
      }
    }

    protected void l()
    {
      e.e(e.this).post(b.a(2));
      a(new e.h()
      {
        public void a(g paramAnonymousg)
        {
          paramAnonymousg.C();
        }
      });
    }
  }

  private class p extends e.o
  {
    private p()
    {
      super(null);
    }

    void d()
    {
      c(0);
    }

    void e()
    {
      l();
      e.a(e.this, e.n.a);
    }

    void g()
    {
      if (h())
        e.a(e.this, e.n.c);
    }
  }

  private class q extends e.o
  {
    private q()
    {
      super(null);
    }

    boolean a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      if (super.a(paramString, paramBoolean, paramArrayOfByte))
      {
        k();
        e.a(e.this, e.n.a);
      }
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.e
 * JD-Core Version:    0.6.2
 */
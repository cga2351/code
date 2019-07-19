package com.viber.voip.q;

import android.content.Context;
import android.os.Handler;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.b.d;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.msginfo.AudioPttInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.i.c.k;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.sound.ptt.AudioPttRecordDelegate;
import com.viber.voip.sound.ptt.AudioPttRecorderWrapper;
import com.viber.voip.sound.ptt.PttUtils;
import com.viber.voip.sound.ptt.PttUtils.AudioBarsInfo;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.dialogs.ah;
import dagger.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

public class k
{
  private static final Logger c = ViberEnv.getLogger();
  private static final long d = PttUtils.MAX_PTT_DURATION_IN_MS;
  private static final long e = d - 1000L;
  a<IRingtonePlayer> a;
  protected k b = new d();
  private AudioPttRecorderWrapper f;
  private final f g;
  private Handler h;
  private final EventBus i;
  private final Context j;
  private WeakReference<n> k;
  private ab l;
  private long m;
  private j n = j.a;
  private String o;
  private File p;
  private long q;
  private PttUtils.AudioBarsInfo r;
  private e s = e.a;

  public k(f paramf, a<IRingtonePlayer> parama, Handler paramHandler, EventBus paramEventBus, Context paramContext)
  {
    this.g = paramf;
    this.h = paramHandler;
    this.i = paramEventBus;
    this.j = paramContext;
    this.f = new AudioPttRecorderWrapper();
    b localb = new b(null);
    this.f.setAudioPttRecordDelegate(localb);
    this.a = parama;
    this.l = ab.b();
  }

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new RuntimeException("This error is not to report: " + paramInt);
    case 1:
      com.viber.voip.ui.dialogs.k.m().d();
      return;
    case 2:
    }
    ah.a().d();
  }

  private void a(final MessageEntity paramMessageEntity)
  {
    this.i.post(l.a(paramMessageEntity));
    a(new a()
    {
      public void a(n paramAnonymousn)
      {
        paramAnonymousn.a(paramMessageEntity);
      }
    });
  }

  private void a(final a parama)
  {
    if (this.k == null);
    for (final n localn = null; ; localn = (n)this.k.get())
    {
      if (localn != null)
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            parama.a(localn);
          }
        });
      return;
    }
  }

  public static long b(long paramLong)
  {
    if (paramLong > e)
      paramLong = d;
    return paramLong;
  }

  private MessageEntity d()
  {
    if (this.m == 0L);
    com.viber.voip.model.entity.h localh;
    do
    {
      return null;
      localh = this.l.f(this.m);
    }
    while (localh == null);
    com.viber.voip.messages.controller.c.b localb;
    MessageEntity localMessageEntity;
    if (localh.b())
    {
      localb = new com.viber.voip.messages.controller.c.b(localh, null);
      if (!c.k.a.e())
        break label194;
      localMessageEntity = localb.a(this.p, localh.ad());
      localMessageEntity.setMimeType(1009);
    }
    while (true)
    {
      localMessageEntity.setStatus(0);
      localMessageEntity.setExtraStatus(2);
      MsgInfo localMsgInfo = localMessageEntity.getMessageInfo();
      localMsgInfo.setPttVersion(PttUtils.getPttVersion());
      AudioPttInfo localAudioPttInfo = new AudioPttInfo();
      localAudioPttInfo.setDuration(this.q);
      if (this.r != null)
        localAudioPttInfo.setSoundBarsInfo(PttUtils.packVolumeBarsToBase64(this.r));
      localMsgInfo.setAudioPttInfo(localAudioPttInfo);
      localMessageEntity.setRawMessageInfo(e.a().b().a(localMsgInfo));
      localMessageEntity.setDuration(this.q);
      return localMessageEntity;
      localb = new com.viber.voip.messages.controller.c.b(localh, ak.a().b(localh.V()));
      break;
      label194: localMessageEntity = localb.a(2, this.o, null, null, localh.ad());
    }
  }

  private void e()
  {
    if (this.s == e.c)
    {
      this.f.stopRecord(false);
      this.s = e.d;
    }
  }

  private void f()
  {
    if (this.p != null)
    {
      this.p.delete();
      this.o = null;
      this.p = null;
    }
  }

  private void g()
  {
    this.i.post(l.a(1));
    a(new a()
    {
      public void a(n paramAnonymousn)
      {
        paramAnonymousn.A();
      }
    });
  }

  private void h()
  {
    this.i.post(l.a(2));
    a(new a()
    {
      public void a(n paramAnonymousn)
      {
        paramAnonymousn.C();
      }
    });
  }

  private void i()
  {
    this.i.post(l.a(4));
    a(new a()
    {
      public void a(n paramAnonymousn)
      {
        paramAnonymousn.B();
      }
    });
  }

  public void a(final long paramLong)
  {
    this.h.post(new Runnable()
    {
      public void run()
      {
        k.this.b.a(paramLong);
      }
    });
  }

  public void a(final n paramn)
  {
    this.h.post(new Runnable()
    {
      public void run()
      {
        k.a(k.this, new WeakReference(paramn));
      }
    });
  }

  public boolean a()
  {
    return this.s != e.a;
  }

  public void b()
  {
    this.h.post(new Runnable()
    {
      public void run()
      {
        k.this.b.c();
      }
    });
  }

  public void c()
  {
    this.h.post(new Runnable()
    {
      public void run()
      {
        k.this.b.b();
      }
    });
  }

  public String toString()
  {
    return "Recording{state=" + this.n + ", recorderState=" + this.s + ", pttId=" + this.o + ", duration=" + this.q + ", conversationId=" + this.m + '}';
  }

  private static abstract interface a
  {
    public abstract void a(n paramn);
  }

  private class b
    implements AudioPttRecordDelegate
  {
    private b()
    {
    }

    public void onRecordError(final int paramInt)
    {
      k.o(k.this).post(new Runnable()
      {
        public void run()
        {
          k.this.b.b(paramInt);
        }
      });
    }

    public void onRecordFinished(final int paramInt1, final int paramInt2, final short[] paramArrayOfShort, final int paramInt3, final short paramShort)
    {
      k.o(k.this).post(new Runnable()
      {
        public void run()
        {
          PttUtils.AudioBarsInfo localAudioBarsInfo = PttUtils.getVolumeBars(new PttUtils.AudioBarsInfo(paramArrayOfShort, paramInt3, paramShort), 30, (short)127);
          k.this.b.a(paramInt1, paramInt2, localAudioBarsInfo);
        }
      });
    }

    public void onRecordStarted(final int paramInt)
    {
      k.o(k.this).post(new Runnable()
      {
        public void run()
        {
          k.this.b.a(paramInt);
        }
      });
    }
  }

  class c extends k.k
  {
    c()
    {
      super();
    }

    private void d()
    {
      if (k.l(k.this) == k.e.a)
      {
        k.m(k.this);
        S_();
        return;
      }
      k.h(k.this);
    }

    protected void S_()
    {
      a(k.j.a);
    }

    protected void a()
    {
      d();
    }

    public void a(int paramInt)
    {
      super.a(paramInt);
      d();
    }

    public void a(int paramInt1, int paramInt2, PttUtils.AudioBarsInfo paramAudioBarsInfo)
    {
      super.a(paramInt1, paramInt2, paramAudioBarsInfo);
      d();
    }

    public void a(long paramLong)
    {
      super.a(0L);
      c(3);
    }

    public void b(int paramInt)
    {
      super.b(paramInt);
      d();
    }
  }

  class d extends k.k
  {
    d()
    {
      super();
    }

    protected void a()
    {
      k.a(k.this, 0L);
      k.a(k.this, null);
      k.a(k.this, null);
      k.b(k.this, 0L);
      k.a(k.this, null);
    }

    public void a(long paramLong)
    {
      super.a(paramLong);
      k.a(k.this, PttUtils.getNextPttId());
      k.a(k.this, new File(PttUtils.generatePttFileName(k.b(k.this), k.c(k.this))));
      k.d(k.this).a(5);
      k.f(k.this).startRecord(k.e(k.this), ((IRingtonePlayer)k.this.a.get()).isSoundNotificationsAllowed(), false);
      k.a(k.this, k.e.b);
      a(k.j.b);
    }

    public void b()
    {
      super.b();
      a(k.j.e);
    }
  }

  static enum e
  {
    static
    {
      e[] arrayOfe = new e[4];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
    }
  }

  class f extends k.c
  {
    f()
    {
      super();
    }

    protected void S_()
    {
      k.n(k.this);
      ViberApplication.getInstance().getEngine(false).getCdrController().handleReportVoiceMessage((int)TimeUnit.MILLISECONDS.toSeconds(k.j(k.this)), 2, 2);
      a(k.j.a);
    }
  }

  class g extends k.k
  {
    g()
    {
      super();
    }

    public void b()
    {
      super.b();
      a(k.j.e);
    }

    public void c()
    {
      super.c();
      MessageEntity localMessageEntity = k.k(k.this);
      if (localMessageEntity == null)
      {
        c(4);
        return;
      }
      k.a(k.this, localMessageEntity);
      a(k.j.a);
    }
  }

  class h extends k.k
  {
    h()
    {
      super();
    }

    public void a(int paramInt)
    {
      super.a(paramInt);
      switch (paramInt)
      {
      default:
        c(4);
        return;
      case 0:
        k.g(k.this);
        a(k.j.c);
        return;
      case 1:
        c(1);
        return;
      case 2:
      }
      c(2);
    }

    public void b()
    {
      super.b();
      a(k.j.e);
    }

    public void c()
    {
      super.c();
      c(0);
    }
  }

  class i extends k.k
  {
    i()
    {
      super();
    }

    public void a(int paramInt1, int paramInt2, PttUtils.AudioBarsInfo paramAudioBarsInfo)
    {
      super.a(paramInt1, paramInt2, paramAudioBarsInfo);
      if (paramInt1 == 1)
      {
        k.i(k.this);
        a(k.j.d);
        return;
      }
      if (k.j(k.this) >= 500L)
      {
        MessageEntity localMessageEntity = k.k(k.this);
        if (localMessageEntity == null)
        {
          c(4);
          return;
        }
        k.a(k.this, localMessageEntity);
        a(k.j.a);
        return;
      }
      c(0);
      a(k.j.a);
    }

    public void b()
    {
      super.b();
      a(k.j.e);
    }

    public void b(int paramInt)
    {
      super.b(paramInt);
      switch (paramInt)
      {
      default:
        return;
      case 2:
        k.i(k.this);
        a(k.j.d);
        return;
      case 1:
      }
      c(2);
    }

    public void c()
    {
      super.c();
      k.h(k.this);
    }
  }

  private static enum j
  {
    static
    {
      j[] arrayOfj = new j[6];
      arrayOfj[0] = a;
      arrayOfj[1] = b;
      arrayOfj[2] = c;
      arrayOfj[3] = d;
      arrayOfj[4] = e;
      arrayOfj[5] = f;
    }
  }

  abstract class k
  {
    public k()
    {
    }

    private k b(k.j paramj)
    {
      switch (k.2.a[paramj.ordinal()])
      {
      default:
        return null;
      case 1:
        return new k.d(k.this);
      case 2:
        return new k.h(k.this);
      case 3:
        return new k.i(k.this);
      case 4:
        return new k.g(k.this);
      case 5:
        return new k.f(k.this);
      case 6:
      }
      return new k.c(k.this);
    }

    protected void a()
    {
    }

    public void a(int paramInt)
    {
      if (paramInt == 0)
      {
        k.a(k.this, k.e.c);
        return;
      }
      k.a(k.this, k.e.a);
    }

    public void a(int paramInt1, int paramInt2, PttUtils.AudioBarsInfo paramAudioBarsInfo)
    {
      k.b(k.this, k.b(paramInt2));
      k.a(k.this, paramAudioBarsInfo);
      k.a(k.this, k.e.a);
    }

    public void a(long paramLong)
    {
      k.a(k.this, paramLong);
    }

    protected void a(k.j paramj)
    {
      k.a(k.this, paramj);
      k.this.b = b(paramj);
      k.this.b.a();
    }

    public void b()
    {
    }

    public void b(int paramInt)
    {
      k.a(k.this, k.e.a);
    }

    public void c()
    {
    }

    protected void c(final int paramInt)
    {
      k.a(k.this).post(l.b(paramInt));
      k.a(k.this, new k.a()
      {
        public void a(n paramAnonymousn)
        {
          paramAnonymousn.g(paramInt);
        }
      });
      switch (paramInt)
      {
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        a(k.j.f);
        return;
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            k.a(k.this, paramInt);
          }
        });
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.k
 * JD-Core Version:    0.6.2
 */
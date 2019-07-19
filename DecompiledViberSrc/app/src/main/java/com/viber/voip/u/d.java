package com.viber.voip.u;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.ptt.VideoPttControllerDelegate.VideoPlayer;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.d.l;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.phone.VpttPlayerBuilder;
import com.viber.voip.phone.vptt.VideoPttPlayer;
import com.viber.voip.phone.vptt.VideoPttPlayer.Completion;
import com.viber.voip.q.m;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.audiofocus.AudioFocusManager;
import com.viber.voip.sound.audiofocus.AudioFocusable;
import com.viber.voip.sound.audiofocus.SimpleAudioFocusable;
import com.viber.voip.util.dd;
import com.viber.voip.widget.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class d
  implements VideoPttControllerDelegate.VideoPlayer
{
  private static final Logger a = ViberEnv.getLogger();
  private final m A = new m()
  {
    public void a()
    {
      d.a(d.this);
    }

    public void a(int paramAnonymousInt)
    {
    }

    public void a(MessageEntity paramAnonymousMessageEntity)
    {
    }

    public void b()
    {
    }
  };
  private final PhoneController b;
  private VideoPttPlayer c;
  private final Handler d;
  private final Handler e;
  private final o f;
  private final AudioFocusManager g;
  private final ab h;
  private final Map<l, c> i = new HashMap();
  private long j;
  private long k;
  private volatile boolean l;
  private volatile boolean m;
  private a n;
  private l o;
  private final Set<l> p = new HashSet();
  private final Set<l> q = new HashSet();
  private final List<l> r = new ArrayList();
  private final List<l> s = new ArrayList();
  private final List<l> t = new ArrayList();
  private final Set<l> u = Collections.synchronizedSet(new HashSet());
  private final Map<l, Boolean> v = new HashMap();
  private final Map<l, aa> w = new LinkedHashMap();
  private final b x = new b(null);
  private com.viber.voip.messages.conversation.adapter.d.d y;
  private final AudioFocusable z = new SimpleAudioFocusable()
  {
    public void onGainAudioFocus()
    {
      d.this.a(true, true);
    }

    public void onGainAudioFocusMayDuck()
    {
    }

    public void onLossAudioFocus()
    {
      d.this.a(false, true);
    }

    public void onLossAudioFocusCanDuck()
    {
    }
  };

  public d(PhoneController paramPhoneController, AudioFocusManager paramAudioFocusManager, Handler paramHandler1, Handler paramHandler2, o paramo, ab paramab, EventBus paramEventBus)
  {
    this.b = paramPhoneController;
    this.g = paramAudioFocusManager;
    this.d = paramHandler1;
    this.e = paramHandler2;
    this.f = paramo;
    this.h = paramab;
    paramEventBus.register(this.A);
  }

  private void a(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity == null);
    while (paramMessageEntity.isOpened())
      return;
    paramMessageEntity.setOpened(1);
    this.h.a(paramMessageEntity.getTable(), paramMessageEntity.getId(), "opened", Integer.valueOf(1));
    this.f.a(paramMessageEntity.getConversationId(), paramMessageEntity.getMessageToken(), false);
  }

  private boolean a(final l paraml, Uri paramUri, a parama, boolean paramBoolean)
  {
    if (paramUri == null)
      return false;
    this.n = new a(this.b.generateSequence(), paraml);
    this.n.c = paramBoolean;
    this.r.remove(paraml);
    this.q.add(paraml);
    if (this.c != null)
    {
      this.c.dispose();
      this.c = null;
    }
    this.c = new VpttPlayerBuilder().forUri(paramUri).withUiHandler(this.e).build();
    final int i1 = this.n.a;
    this.c.startVideoPttPlay(i1, paramUri.getPath(), parama, paramBoolean, new VideoPttPlayer.Completion()
    {
      public void onCompletion(Error paramAnonymousError)
      {
        if (paramAnonymousError != null)
        {
          dd.a(d.b(d.this), new Runnable()
          {
            public void run()
            {
              d.this.onVideoPttPlayError(d.8.this.a, 0);
            }
          });
          return;
        }
        dd.a(d.b(d.this), new Runnable()
        {
          public void run()
          {
            d.this.onVideoPttPlayStarted(d.8.this.a);
          }
        });
      }
    }
    , new VideoPttPlayer.Completion()
    {
      public void onCompletion(Error paramAnonymousError)
      {
        if (paramAnonymousError != null)
        {
          dd.a(d.b(d.this), new Runnable()
          {
            public void run()
            {
              if ((d.c(d.this) != null) && (d.this.a(d.9.this.a)))
              {
                d.a(d.this);
                d.this.onVideoPttPlayError(d.c(d.this).a, 0);
              }
            }
          });
          return;
        }
        dd.a(d.b(d.this), new Runnable()
        {
          public void run()
          {
            if ((d.c(d.this) != null) && (d.this.a(d.9.this.a)))
            {
              d.a locala = d.c(d.this);
              d.a(d.this);
              d.this.onVideoPttPlayStopped(locala.a);
            }
          }
        });
      }
    });
    return true;
  }

  private boolean a(l paraml, boolean paramBoolean)
  {
    aa localaa = (aa)this.w.get(paraml);
    if (localaa == null)
      return false;
    if (TextUtils.isEmpty(localaa.o()))
      return false;
    c localc = (c)this.i.get(paraml);
    if (localc == null)
      return false;
    if ((!paramBoolean) && (!this.g.requestAudioFocus(this.z, 3, 2)))
      return false;
    if (!h())
      return false;
    if (this.y != null)
      this.y.a(localaa, true);
    this.v.remove(paraml);
    if (!TextUtils.isEmpty(localaa.o()));
    for (Uri localUri = Uri.parse(localaa.o()); ; localUri = null)
      return a(paraml, localUri, localc.a(localUri), paramBoolean);
  }

  private boolean a(boolean paramBoolean)
  {
    if (!h())
      return false;
    if (this.r.isEmpty())
      return false;
    if (this.n != null)
      return false;
    int i1 = this.r.size();
    int i2 = 0;
    l locall;
    if (i2 < i1)
    {
      locall = (l)this.r.get(i2);
      if (!this.w.containsKey(locall));
    }
    while (true)
    {
      if (locall != null)
      {
        return a(locall, paramBoolean);
        i2++;
        break;
      }
      return false;
      locall = null;
    }
  }

  private void d()
  {
    e();
    f();
  }

  private void e()
  {
    if (this.s.isEmpty())
      return;
    this.k = Math.max(this.k, ((l)this.s.get(0)).a());
    int i1 = this.s.size();
    int i2 = 0;
    label52: l locall;
    aa localaa;
    if (i2 < i1)
    {
      locall = (l)this.s.get(i2);
      localaa = (aa)this.w.get(locall);
      if (localaa != null)
        break label97;
    }
    while (true)
    {
      i2++;
      break label52;
      break;
      label97: if ((locall.a() > 0L) && (locall.a() < this.k) && (localaa.ap()))
      {
        this.p.remove(locall);
        this.r.remove(locall);
        this.q.add(locall);
      }
      else if (((localaa.aK()) && (localaa.o() != null) && (!localaa.bd())) || (this.p.contains(locall)))
      {
        this.p.remove(locall);
        if ((!this.q.contains(locall)) && (!this.r.contains(locall)))
          this.r.add(locall);
      }
    }
  }

  private void f()
  {
    if (this.t.isEmpty());
    while ((this.n == null) || (!this.t.contains(this.n.b)))
      return;
    g();
  }

  private void f(l paraml)
  {
    c localc = (c)this.i.get(paraml);
    if (localc == null)
      return;
    localc.a();
  }

  private void g()
  {
    if (this.n == null)
      return;
    final l locall = new l(this.n.b);
    final int i1 = this.n.a;
    dd.a(this.e, new Runnable()
    {
      public void run()
      {
        d.b(d.this, locall);
      }
    });
    this.c.stopVideoPttPlay(new VideoPttPlayer.Completion()
    {
      public void onCompletion(final Error paramAnonymousError)
      {
        dd.a(d.b(d.this), new Runnable()
        {
          public void run()
          {
            if (paramAnonymousError != null)
              return;
            d.this.onVideoPttPlayStopped(d.7.this.a);
            d.c(d.this, d.7.this.b);
          }
        });
      }
    });
  }

  private void g(l paraml)
  {
    c localc = (c)this.i.get(paraml);
    if (localc == null)
      return;
    localc.d();
  }

  private void h(l paraml)
  {
    c localc = (c)this.i.get(paraml);
    if (localc == null)
      return;
    localc.b();
  }

  private boolean h()
  {
    ISoundService localISoundService = ViberApplication.getInstance().getSoundService();
    return (!localISoundService.isGSMCallActive()) && (!localISoundService.isViberCallActive()) && (!localISoundService.isRTCCallActive()) && (!ViberApplication.getInstance().getMessagesManager().o().f());
  }

  private void i(l paraml)
  {
    c localc = (c)this.i.get(paraml);
    if (localc == null)
      return;
    localc.c();
  }

  private void j(l paraml)
  {
    c localc = (c)this.i.get(paraml);
    if (localc == null)
      return;
    localc.e();
  }

  private void k(l paraml)
  {
    if (paraml == null)
      return;
    if (paraml.c() > 0);
    for (MessageEntity localMessageEntity = this.h.c(paraml.c()); ; localMessageEntity = this.h.k(paraml.b()))
    {
      if (localMessageEntity == null)
        this.u.add(paraml);
      a(localMessageEntity);
      return;
    }
  }

  public void a()
  {
    this.k = 0L;
    this.p.clear();
    this.q.clear();
    this.r.clear();
    this.w.clear();
    this.v.clear();
    this.n = null;
    this.l = true;
    this.m = true;
  }

  public void a(long paramLong)
  {
    this.f.a(this.x);
    b(paramLong);
    a();
  }

  public void a(com.viber.voip.messages.conversation.adapter.d.d paramd)
  {
    this.y = paramd;
  }

  public void a(l paraml, c paramc)
  {
    this.i.put(paraml, paramc);
  }

  public void a(Map<l, aa> paramMap)
  {
    this.s.clear();
    this.t.clear();
    this.s.addAll(paramMap.keySet());
    Iterator localIterator = this.w.keySet().iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (!paramMap.containsKey(locall))
        this.t.add(locall);
    }
    this.w.clear();
    this.w.putAll(paramMap);
    d();
    if (this.l)
      a(true);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.l != paramBoolean1)
    {
      bool2 = bool1;
      if ((!bool2) || ((!paramBoolean2) && (bool2)))
        this.m = this.l;
      this.l = paramBoolean1;
      if ((!bool2) || (!paramBoolean1))
        break label88;
      if (this.o != null)
        break label83;
    }
    while (true)
    {
      if (!a(bool1))
        this.g.abandonAudioFocus();
      this.o = null;
      return;
      bool2 = false;
      break;
      label83: bool1 = false;
    }
    label88: g();
  }

  public boolean a(l paraml)
  {
    return (this.n != null) && (this.n.a(paraml));
  }

  public void b()
  {
    if (this.n == null);
    while (!this.g.requestAudioFocus(this.z, 3, 2))
      return;
    final a locala = this.n;
    final int i1 = this.n.a;
    this.c.restartUnmuted(new VideoPttPlayer.Completion()
    {
      public void onCompletion(final Error paramAnonymousError)
      {
        dd.a(d.b(d.this), new Runnable()
        {
          public void run()
          {
            if (paramAnonymousError == null)
            {
              if (d.3.this.a != null)
                d.3.this.a.c = false;
              d.this.onVideoPttPlayRestarted(d.3.this.b);
            }
          }
        });
      }
    });
  }

  public boolean b(long paramLong)
  {
    if (this.j != paramLong)
    {
      this.j = paramLong;
      return true;
    }
    return false;
  }

  public boolean b(l paraml)
  {
    return (a(paraml)) && (this.n.c);
  }

  public void c()
  {
    g();
  }

  public void c(long paramLong)
  {
    if (this.j != paramLong)
      return;
    g();
    b(0L);
    a();
    this.f.b(this.x);
    this.i.clear();
    this.g.abandonAudioFocus();
  }

  public boolean c(l paraml)
  {
    return (this.v.containsKey(paraml)) && (((Boolean)this.v.get(paraml)).booleanValue());
  }

  public void d(l paraml)
  {
    if (!this.w.containsKey(paraml))
      return;
    this.q.addAll(this.r);
    this.r.clear();
    this.r.add(paraml);
    if (this.n == null)
    {
      a(false);
      return;
    }
    this.o = paraml;
    g();
  }

  public void e(l paraml)
  {
    this.i.remove(paraml);
  }

  public void onVideoPttPlayError(int paramInt1, int paramInt2)
  {
    if ((this.n == null) || (this.n.a != paramInt1));
    do
    {
      return;
      if (paramInt2 != 2)
      {
        l locall = new l(this.n.b);
        this.v.put(locall, Boolean.valueOf(true));
        j(locall);
      }
    }
    while (this.n.d);
    onVideoPttPlayStopped(paramInt1);
  }

  public void onVideoPttPlayRestarted(int paramInt)
  {
    if ((this.n == null) || (this.n.a != paramInt))
      return;
    this.n.c = false;
    h(new l(this.n.b));
  }

  public void onVideoPttPlayStarted(int paramInt)
  {
    if ((this.n == null) || (this.n.a != paramInt))
    {
      this.n = null;
      this.c.stopVideoPttPlay(new VideoPttPlayer.Completion()
      {
        public void onCompletion(Error paramAnonymousError)
        {
          if (paramAnonymousError != null);
        }
      });
      return;
    }
    this.n.d = true;
    final l locall = this.n.b;
    f(new l(locall));
    dd.a(this.d, new Runnable()
    {
      public void run()
      {
        d.a(d.this, locall);
      }
    });
  }

  public void onVideoPttPlayStopped(int paramInt)
  {
    if ((this.n == null) || (this.n.a != paramInt));
    boolean bool;
    do
    {
      do
      {
        return;
        g(new l(this.n.b));
        bool = this.n.c;
        this.n = null;
        if ((this.m) && (!this.l))
          this.l = true;
      }
      while (!this.l);
      if (this.o != null)
      {
        a(this.o, false);
        this.o = null;
        return;
      }
    }
    while (a(bool));
    this.g.abandonAudioFocus();
  }

  public void onVideoPttPlayStopping(int paramInt)
  {
    if ((this.n == null) || (this.n.a != paramInt))
      return;
    i(new l(this.n.b));
  }

  private static class a
  {
    final int a;
    final l b;
    boolean c;
    boolean d;

    a(int paramInt, l paraml)
    {
      this.a = paramInt;
      this.b = paraml;
    }

    boolean a(l paraml)
    {
      return this.b.equals(paraml);
    }

    public String toString()
    {
      return "CurrentlyPlaying{mPlaySequence=" + this.a + ", mMessageId=" + this.b + ", mMuted=" + this.c + '}';
    }
  }

  private class b
    implements bv.l
  {
    private b()
    {
    }

    public void a(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      by.a(this, paramLong1, paramLong2, paramBoolean);
    }

    public void a(long paramLong, Set paramSet)
    {
      by.a(this, paramLong, paramSet);
    }

    public void a(final MessageEntity paramMessageEntity, boolean paramBoolean)
    {
      if ((paramMessageEntity.getConversationId() != d.d(d.this)) || (!paramMessageEntity.isVideoPttBehavior()) || (TextUtils.isEmpty(paramMessageEntity.getMediaUri())))
        return;
      l locall = new l(paramMessageEntity);
      if (d.e(d.this).contains(locall))
      {
        d.e(d.this).remove(locall);
        d.a(d.this, paramMessageEntity);
      }
      dd.a(d.b(d.this), new Runnable()
      {
        public void run()
        {
          d.f(d.this).add(new l(paramMessageEntity));
        }
      });
    }

    public void a(Set paramSet, boolean paramBoolean)
    {
      by.a(this, paramSet, paramBoolean);
    }

    public void a(Set paramSet, boolean paramBoolean1, boolean paramBoolean2)
    {
      by.a(this, paramSet, paramBoolean1, paramBoolean2);
    }

    public void b(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      by.b(this, paramLong1, paramLong2, paramBoolean);
    }
  }

  public static abstract interface c
  {
    public abstract a a(Uri paramUri);

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.d
 * JD-Core Version:    0.6.2
 */
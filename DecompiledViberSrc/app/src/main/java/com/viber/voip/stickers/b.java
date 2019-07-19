package com.viber.voip.stickers;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.SvgViewBackend;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.d.l;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.sound.MessageSoundPlayer;
import com.viber.voip.stickers.entity.Sticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements v.a<l>
{
  private static final Logger a = ViberEnv.getLogger();
  private long b = 0L;
  private Set<l> c = new HashSet();
  private Set<Long> d = new HashSet();
  private Set<l> e = new HashSet();
  private List<l> f = new ArrayList();
  private List<l> g = new ArrayList();
  private List<l> h = new ArrayList();
  private Set<MessageEntity> i = new HashSet();
  private int j = 0;
  private long k = 0L;
  private l l;
  private SvgViewBackend m;
  private Handler n = new Handler(Looper.getMainLooper());
  private Set<l> o = new HashSet();
  private c p;
  private boolean q;
  private Map<l, b> r;
  private final Map<l, v.c<l>> s = new HashMap();
  private List<l> t = new ArrayList();
  private bv.l u = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
      b.a(b.this).post(new c(this, paramAnonymousLong, paramAnonymousSet));
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
      b.a(b.this).post(new d(this, paramAnonymousMessageEntity));
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      b.a(b.this).post(new e(this, paramAnonymousSet, paramAnonymousBoolean2));
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };

  private b()
  {
    o.a().a(this.u);
    this.p = new c(ViberApplication.getApplication(), this);
  }

  private void a(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.getConversationId() == this.b)
      this.e.add(new l(paramMessageEntity));
  }

  private void a(List<l> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0));
    do
    {
      return;
      v.c localc = getCurrentlyPlayedStickerView();
      l locall = this.l;
      if ((localc != null) && (locall != null) && (paramList.contains(locall)))
        this.p.b(localc);
    }
    while ((this.l == null) || (!paramList.contains(this.l)));
    this.p.a();
    this.l = null;
  }

  private void b(Map<l, aa> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0));
    while (true)
    {
      return;
      this.k = Math.max(this.k, ((l)paramMap.keySet().iterator().next()).a());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        l locall = (l)localEntry.getKey();
        aa localaa = (aa)localEntry.getValue();
        if (localaa != null)
        {
          long l1 = localaa.y();
          Sticker localSticker = localaa.bn();
          if ((locall.a() > 0L) && (locall.a() < this.k) && (localaa.ap()))
          {
            this.d.remove(Long.valueOf(l1));
            this.e.remove(locall);
            this.f.remove(locall);
            this.c.add(locall);
          }
          else if ((localaa.ax()) && ((localSticker.isAnimated()) || (localSticker.hasSound())) && (localSticker.isReady()) && ((localaa.bm() != 0) || (this.d.contains(Long.valueOf(l1))) || (this.e.contains(locall))))
          {
            this.d.remove(Long.valueOf(l1));
            this.e.remove(locall);
            if ((!this.c.contains(locall)) && (!this.f.contains(locall)))
              this.f.add(locall);
          }
        }
      }
    }
  }

  private void c(long paramLong)
  {
    if (paramLong != this.b)
      return;
    d();
    a(0L);
  }

  public static b e()
  {
    return a.a();
  }

  private void h()
  {
    Iterator localIterator = this.o.iterator();
    if (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (((!this.f.isEmpty()) && (((l)this.f.get(0)).equals(locall))) || ((locall.b() == 0L) && (locall.a() <= 0L) && (!this.c.contains(locall)) && (g() == null)));
      for (boolean bool = true; ; bool = false)
      {
        v.c localc = (v.c)this.s.get(locall);
        if (localc == null)
          break;
        localc.loadImage(bool);
        break;
      }
    }
    this.o.clear();
  }

  private void i()
  {
    if (g() != null);
    while (true)
    {
      return;
      if (this.f.size() != 0)
      {
        int i1 = this.f.size();
        for (int i2 = 0; i2 < i1; i2++)
        {
          l locall = (l)this.f.get(i2);
          if (this.g.contains(locall))
          {
            v.c localc = (v.c)this.s.get(locall);
            if (localc != null)
            {
              this.p.a(localc);
              return;
            }
          }
        }
      }
    }
  }

  public void a(int paramInt)
  {
    this.j = paramInt;
    v.c localc = getCurrentlyPlayedStickerView();
    if (localc == null)
      return;
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.p.c(localc);
      return;
    case 1:
    }
    this.p.d(localc);
  }

  public void a(long paramLong)
  {
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.h.clear();
    this.j = 0;
    this.k = 0L;
    this.l = null;
    this.b = paramLong;
    this.p.a();
    this.q = false;
    this.r = new HashMap();
    this.s.clear();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
      a((MessageEntity)localIterator.next());
    this.i.clear();
  }

  public void a(l paraml, b paramb)
  {
    this.r.put(paraml, paramb);
  }

  public void a(l paraml, v.c<l> paramc)
  {
    this.s.put(paraml, paramc);
  }

  public void a(Map<l, aa> paramMap)
  {
    if ((this.b == 0L) || (this.q))
      return;
    this.t.clear();
    int i1 = this.g.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      l locall = (l)this.g.get(i2);
      if (!paramMap.containsKey(locall))
        this.t.add(locall);
    }
    this.g.clear();
    this.g.addAll(paramMap.keySet());
    b(paramMap);
    h();
    a(this.t);
    i();
  }

  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public boolean a()
  {
    return this.p.b();
  }

  public boolean a(l paraml)
  {
    return this.p.b(paraml);
  }

  public void b()
  {
    this.g.clear();
    this.g.addAll(this.h);
    this.h.clear();
  }

  public void b(long paramLong)
  {
    c(paramLong);
  }

  public void b(l paraml)
  {
    if ((this.l != null) && (this.l.equals(paraml)))
      this.l = null;
  }

  public void c()
  {
    this.h.clear();
    this.h.addAll(this.g);
    this.g.clear();
    d();
  }

  public void c(l paraml)
  {
    if (!this.g.contains(paraml))
      return;
    this.c.addAll(this.f);
    this.f.clear();
    this.f.add(paraml);
    v.c localc = getCurrentlyPlayedStickerView();
    if (localc != null)
    {
      this.p.b(localc);
      return;
    }
    i();
  }

  public void d()
  {
    v.c localc = getCurrentlyPlayedStickerView();
    if (localc != null)
      this.p.b(localc);
  }

  public void d(l paraml)
  {
    if (paraml.equals(this.l));
    Iterator localIterator;
    do
    {
      return;
      while (!localIterator.hasNext())
        localIterator = this.f.iterator();
    }
    while (!paraml.equals(localIterator.next()));
    localIterator.remove();
  }

  public void e(l paraml)
  {
    this.p.b(paraml);
  }

  public SvgViewBackend f()
  {
    return this.m;
  }

  public void f(l paraml)
  {
    if ((paraml != null) && (!paraml.equals(this.l)))
      this.l = new l(paraml);
  }

  public l g()
  {
    return this.l;
  }

  public void g(l paraml)
  {
    this.p.c(paraml);
  }

  public v.c<l> getCurrentlyPlayedStickerView()
  {
    if (this.l != null)
      return (v.c)this.s.get(this.l);
    return null;
  }

  public void h(l paraml)
  {
    this.f.remove(paraml);
    this.c.add(paraml);
  }

  public void i(l paraml)
  {
    this.p.d(paraml);
  }

  public boolean j(l paraml)
  {
    if (paraml.equals(this.l))
    {
      this.l = null;
      i();
      return true;
    }
    return false;
  }

  public void k(l paraml)
  {
    this.o.add(paraml);
  }

  public void l(l paraml)
  {
    this.s.remove(paraml);
  }

  public void m(l paraml)
  {
    this.r.remove(paraml);
  }

  public void n(l paraml)
  {
    b localb = (b)this.r.get(paraml);
    if (localb != null)
      localb.a(paraml);
  }

  public void o(l paraml)
  {
    b localb = (b)this.r.get(paraml);
    if (localb != null)
      localb.b(paraml);
  }

  public void updateCurrentlyPlayedSvgViewBackend(SvgViewBackend paramSvgViewBackend)
  {
    this.m = paramSvgViewBackend;
  }

  private static final class a
  {
    private static final b a = new b(null);
  }

  public static abstract interface b
  {
    public abstract void a(l paraml);

    public abstract void b(l paraml);
  }

  private class c extends v<l>
  {
    public c(v.a<l> arg2)
    {
      super(locala);
    }

    public void a(l paraml)
    {
      super.onSoundStarted(paraml);
      if (b.f(b.this) != 0)
        this.b.pause(paraml);
    }

    public void b(l paraml)
    {
      super.a(paraml);
      v.c localc = b.this.getCurrentlyPlayedStickerView();
      if ((localc != null) && (b.f(b.this) != 0))
        localc.pauseAnimation();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.b
 * JD-Core Version:    0.6.2
 */
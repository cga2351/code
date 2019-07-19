package com.viber.voip.q;

import android.net.Uri;
import android.os.Handler;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv.f;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.sound.audiofocus.AudioFocusManager;
import com.viber.voip.sound.audiofocus.AudioFocusable;
import com.viber.voip.sound.audiofocus.SimpleAudioFocusable;
import com.viber.voip.ui.dialogs.ah;
import com.viber.voip.util.dd;
import com.viber.voip.util.dx;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class i
{
  private static final Logger a = ViberEnv.getLogger();
  private final f b;
  private final o c;
  private final Handler d;
  private final ab e;
  private Handler f;
  private final AudioFocusManager g;
  private String h;
  private boolean i;
  private Map<String, Boolean> j = Collections.emptyMap();
  private final bv.f k = new bv.f()
  {
    public void a(Set<String> paramAnonymousSet)
    {
      i.a(i.this, paramAnonymousSet);
    }
  };
  private final AudioFocusable l = new SimpleAudioFocusable()
  {
    public void onGainAudioFocus()
    {
    }

    public void onGainAudioFocusMayDuck()
    {
    }

    public void onLossAudioFocus()
    {
      i.a(i.this).b();
    }

    public void onLossAudioFocusCanDuck()
    {
    }
  };
  private final h m = new h()
  {
    public void a(String paramAnonymousString, int paramAnonymousInt)
    {
      i.a(i.this, paramAnonymousString, paramAnonymousInt);
    }

    public void a(String paramAnonymousString, long paramAnonymousLong)
    {
      i.a(i.this, paramAnonymousString);
    }

    public void b(String paramAnonymousString, long paramAnonymousLong)
    {
      i.b(i.this, paramAnonymousString);
    }

    public void c(String paramAnonymousString, long paramAnonymousLong)
    {
      i.c(i.this, paramAnonymousString);
    }
  };

  public i(f paramf, AudioFocusManager paramAudioFocusManager, Handler paramHandler1, Handler paramHandler2, o paramo, ab paramab)
  {
    this.g = paramAudioFocusManager;
    this.f = paramHandler1;
    this.d = paramHandler2;
    this.e = paramab;
    this.c = paramo;
    this.b = paramf;
    this.b.a(this.m);
    paramo.a(this.k);
  }

  private void a(String paramString, int paramInt)
  {
    if (!g(paramString));
    while (true)
    {
      return;
      this.h = null;
      if ((paramInt == 2) && (!this.i))
        f(paramString);
      while (paramInt == 4)
      {
        ah.b().d();
        return;
        this.g.abandonAudioFocus();
      }
    }
  }

  private void a(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty()));
    Uri localUri;
    do
    {
      return;
      localUri = dx.i(this.h);
    }
    while (localUri == null);
    String str = localUri.toString();
    dd.a(this.d, new j(this, paramSet, str));
  }

  private void d(String paramString, long paramLong)
  {
    if (!this.g.requestAudioFocus(this.l, 3, 2))
    {
      ah.b().d();
      return;
    }
    this.h = paramString;
    this.b.a(paramString, paramLong);
  }

  private void f(String paramString)
  {
    if (this.b.c())
      return;
    String str = k(paramString);
    if (str != null)
    {
      d(str, 0L);
      return;
    }
    this.g.abandonAudioFocus();
  }

  private boolean g(String paramString)
  {
    return (this.h != null) && (this.h.equals(paramString));
  }

  private void h(final String paramString)
  {
    this.h = paramString;
    if ((!this.j.containsKey(paramString)) || (((Boolean)this.j.get(paramString)).booleanValue()));
    for (boolean bool = true; ; bool = false)
    {
      this.i = bool;
      this.f.post(new Runnable()
      {
        public void run()
        {
          i.d(i.this, paramString);
        }
      });
      return;
    }
  }

  private void i(String paramString)
  {
    if (!g(paramString))
      return;
    this.g.abandonAudioFocus();
  }

  private void j(String paramString)
  {
    if (!g(paramString))
      return;
    this.g.requestAudioFocus(this.l, 3, 2);
  }

  private String k(String paramString)
  {
    if (paramString == null)
      return null;
    Iterator localIterator = this.j.keySet().iterator();
    int n = 0;
    String str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if ((n == 0) || (((Boolean)this.j.get(str)).booleanValue()));
    }
    while (true)
    {
      return str;
      if (paramString.equals(str));
      for (int i1 = 1; ; i1 = n)
      {
        n = i1;
        break;
      }
      str = null;
    }
  }

  private void l(String paramString)
  {
    Uri localUri = dx.j(paramString);
    if (localUri == null);
    while (true)
    {
      return;
      String str = localUri.toString();
      try
      {
        Long localLong = Long.valueOf(Long.parseLong(str));
        MessageEntity localMessageEntity = this.e.l(localLong.longValue());
        if ((localMessageEntity != null) && (!localMessageEntity.isOpened()))
        {
          this.e.a(localMessageEntity.getTable(), localMessageEntity.getId(), "opened", Integer.valueOf(1));
          this.c.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
          return;
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void a()
  {
    if (this.h == null)
      return;
    this.b.b();
  }

  public void a(h paramh)
  {
    this.b.a(paramh);
  }

  public void a(String paramString)
  {
    if (!g(paramString))
      return;
    this.b.a();
  }

  public void a(String paramString, long paramLong)
  {
    if (paramString == null)
      return;
    d(paramString, paramLong);
  }

  public void a(Map<String, Boolean> paramMap)
  {
    this.j = paramMap;
  }

  public String b()
  {
    return this.h;
  }

  public void b(h paramh)
  {
    this.b.b(paramh);
  }

  public void b(String paramString)
  {
    if (!g(paramString))
      return;
    this.b.b();
  }

  public void b(String paramString, long paramLong)
  {
    if (!g(paramString))
      return;
    this.b.a(paramLong);
  }

  public void c(String paramString, long paramLong)
  {
    if (!g(paramString))
      return;
    this.b.b(paramLong);
  }

  public boolean c(String paramString)
  {
    return (g(paramString)) && (this.b.c());
  }

  public boolean d(String paramString)
  {
    return (g(paramString)) && (this.b.d());
  }

  public long e(String paramString)
  {
    if (!g(paramString))
      return 0L;
    return this.b.f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.i
 * JD-Core Version:    0.6.2
 */
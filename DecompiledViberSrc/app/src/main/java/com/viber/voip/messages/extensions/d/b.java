package com.viber.voip.messages.extensions.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.h;
import com.viber.voip.i.c.q;
import com.viber.voip.i.f.a;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.model.entity.ChatExSuggestionEntity;
import com.viber.voip.registration.af;
import com.viber.voip.schedule.i;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.n;
import com.viber.voip.util.ap;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final c c;
  private final a d;
  private final dagger.a<com.viber.voip.messages.extensions.f> e;
  private final af f;
  private final ap g;
  private final com.viber.voip.i.f h;
  private final com.viber.voip.i.f i;
  private final h j;
  private volatile boolean k;
  private final ReadWriteLock l = new ReentrantReadWriteLock();
  private f.a m = new f.a()
  {
    public void onFeatureStateChanged(com.viber.voip.i.f paramAnonymousf)
    {
      b.a(b.this);
    }
  };
  private SharedPreferences.OnSharedPreferenceChangeListener n = new SharedPreferences.OnSharedPreferenceChangeListener()
  {
    public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
    {
      if (b.b(b.this).c().equals(paramAnonymousString))
        b.a(b.this);
    }
  };

  @Inject
  public b(Context paramContext, ViberApplication paramViberApplication, c paramc, a parama, dagger.a<com.viber.voip.messages.extensions.f> parama1, af paramaf)
  {
    this.b = paramContext;
    this.c = paramc;
    this.d = parama;
    this.e = parama1;
    this.f = paramaf;
    this.g = paramViberApplication.getDownloadValve();
    this.h = c.h.f;
    this.i = c.q.d;
    this.j = d.n.o;
    this.i.a(this.m);
    this.h.a(this.m);
    com.viber.voip.settings.d.a(this.n);
  }

  private com.viber.voip.messages.extensions.d.a.b a(String paramString, int paramInt)
  {
    Lock localLock = this.l.readLock();
    try
    {
      localLock.lock();
      com.viber.voip.messages.extensions.d.a.b localb = this.d.a(paramString, paramInt);
      return localb;
    }
    finally
    {
      localLock.unlock();
    }
  }

  private void d()
  {
    if (!c())
      return;
    p.a.j.b(this.b);
  }

  com.viber.voip.messages.extensions.d.a.a a(String paramString)
  {
    if (da.a(paramString))
      return null;
    int i2;
    for (int i1 = 0; ; i1 = i2)
    {
      i2 = i1 + 1;
      com.viber.voip.messages.extensions.d.a.b localb = a(paramString, i1);
      if (localb != null)
      {
        ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.c.b(localb.b);
        if (localChatExtensionLoaderEntity != null)
          return new com.viber.voip.messages.extensions.d.a.a(localb.a, localChatExtensionLoaderEntity);
      }
      else
      {
        return null;
      }
    }
  }

  public void a()
  {
    this.g.e(d.n.m.d());
    new i().a(Bundle.EMPTY);
  }

  public void a(com.viber.voip.messages.extensions.d.a.d[] paramArrayOfd)
  {
    Lock localLock = this.l.writeLock();
    try
    {
      localLock.lock();
      ((com.viber.voip.messages.extensions.f)this.e.get()).a(paramArrayOfd);
      localLock.unlock();
      if (this.k)
      {
        this.k = false;
        b();
      }
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public void b()
  {
    if (this.k);
    String str;
    do
    {
      return;
      str = this.f.e().toLowerCase();
    }
    while (da.a(str));
    Lock localLock = this.l.writeLock();
    try
    {
      localLock.lock();
      boolean bool = this.k;
      if (bool)
        return;
      this.d.a();
      Iterator localIterator = ((com.viber.voip.messages.extensions.f)this.e.get()).b(str).iterator();
      while (localIterator.hasNext())
      {
        ChatExSuggestionEntity localChatExSuggestionEntity = (ChatExSuggestionEntity)localIterator.next();
        this.d.a(new com.viber.voip.messages.extensions.d.a.b(localChatExSuggestionEntity.getKeyword(), localChatExSuggestionEntity.getServiceUri(), localChatExSuggestionEntity.getTimeframeFrom(), localChatExSuggestionEntity.getTimeframeTo()));
      }
    }
    finally
    {
      localLock.unlock();
    }
    this.k = true;
    localLock.unlock();
  }

  public boolean c()
  {
    return (this.i.e()) && (this.h.e());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.d.b
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.extensions;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap.a;
import com.viber.voip.ap.b;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.extensions.model.c.b;
import com.viber.voip.settings.d.n;
import com.viber.voip.util.av;
import dagger.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final a<ap.a> b;
  private final a<f> c;
  private final i d;
  private final a<o> e;
  private final ReadWriteLock f = new ReentrantReadWriteLock();
  private volatile boolean g;
  private final Map<String, ChatExtensionLoaderEntity> h = new LinkedHashMap();
  private final List<ChatExtensionLoaderEntity> i = new ArrayList();
  private final Map<String, String> j = new ArrayMap();

  @Inject
  public c(a<ap.a> parama, a<f> parama1, i parami, a<o> parama2)
  {
    this.b = parama;
    this.c = parama1;
    this.d = parami;
    this.e = parama2;
  }

  private int k(String paramString)
  {
    if (o().equals(paramString))
      return 0;
    if (j().equals(paramString))
      return 1;
    if (i().equals(paramString))
      return 2;
    return 2147483647;
  }

  private String o()
  {
    return d.n.j.d();
  }

  public ChatExtensionLoaderEntity a(String paramString)
  {
    Lock localLock = this.f.readLock();
    try
    {
      localLock.lock();
      ChatExtensionLoaderEntity localChatExtensionLoaderEntity = (ChatExtensionLoaderEntity)this.h.get(paramString);
      return localChatExtensionLoaderEntity;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public void a()
  {
    if (this.g)
      return;
    Lock localLock = this.f.writeLock();
    try
    {
      localLock.lock();
      boolean bool = this.g;
      if (bool)
        return;
      this.h.clear();
      this.i.clear();
      this.j.clear();
      List localList = ((f)this.c.get()).a();
      String str = o();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ChatExtensionLoaderEntity localChatExtensionLoaderEntity = (ChatExtensionLoaderEntity)localIterator.next();
        this.h.put(localChatExtensionLoaderEntity.getPublicAccountId(), localChatExtensionLoaderEntity);
        this.j.put(localChatExtensionLoaderEntity.getUri(), localChatExtensionLoaderEntity.getPublicAccountId());
        if (!str.equals(localChatExtensionLoaderEntity.getUri()))
          this.i.add(localChatExtensionLoaderEntity);
      }
    }
    finally
    {
      localLock.unlock();
    }
    this.g = true;
    localLock.unlock();
  }

  public void a(List<c.b> paramList)
  {
    Lock localLock = this.f.writeLock();
    try
    {
      localLock.lock();
      f.b localb = ((f)this.c.get()).a(paramList, new d(this));
      if ((localb.a > 0) && (!this.d.b()))
        this.d.d();
      if (localb.a())
        ((o)this.e.get()).f();
      localLock.unlock();
      if (this.g)
      {
        this.g = false;
        a();
      }
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public ChatExtensionLoaderEntity b(String paramString)
  {
    Lock localLock = this.f.readLock();
    try
    {
      localLock.lock();
      String str = (String)this.j.get(paramString);
      if (str != null);
      for (ChatExtensionLoaderEntity localChatExtensionLoaderEntity = (ChatExtensionLoaderEntity)this.h.get(str); ; localChatExtensionLoaderEntity = null)
        return localChatExtensionLoaderEntity;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public boolean b()
  {
    if (!this.g)
      return false;
    Lock localLock = this.f.readLock();
    try
    {
      localLock.lock();
      boolean bool1 = this.h.isEmpty();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      return bool2;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public List<ChatExtensionLoaderEntity> c()
  {
    Lock localLock = this.f.readLock();
    try
    {
      localLock.lock();
      List localList = Collections.unmodifiableList(this.i);
      return localList;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public boolean c(String paramString)
  {
    Lock localLock = this.f.readLock();
    try
    {
      localLock.lock();
      boolean bool = this.h.containsKey(paramString);
      return bool;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public ChatExtensionLoaderEntity d()
  {
    return b(o());
  }

  public boolean d(String paramString)
  {
    Lock localLock = this.f.readLock();
    try
    {
      localLock.lock();
      String str = (String)this.j.get(paramString);
      if (str != null)
      {
        boolean bool1 = this.h.containsKey(str);
        if (!bool1);
      }
      for (boolean bool2 = true; ; bool2 = false)
        return bool2;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public String e()
  {
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = d();
    if (localChatExtensionLoaderEntity != null)
      return localChatExtensionLoaderEntity.getPublicAccountId();
    return null;
  }

  public boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    Lock localLock = this.f.readLock();
    try
    {
      localLock.lock();
      ChatExtensionLoaderEntity localChatExtensionLoaderEntity = (ChatExtensionLoaderEntity)this.h.get(paramString);
      if (localChatExtensionLoaderEntity != null)
      {
        boolean bool1 = o().equals(localChatExtensionLoaderEntity.getUri());
        if (!bool1);
      }
      for (boolean bool2 = true; ; bool2 = false)
        return bool2;
    }
    finally
    {
      localLock.unlock();
    }
  }

  @Deprecated
  public void f(String paramString)
  {
    d.n.d.a(paramString);
  }

  public boolean f()
  {
    return d(o());
  }

  public String g()
  {
    return ((ap.a)this.b.get()).S.e;
  }

  public void g(String paramString)
  {
    d.n.e.a(paramString);
  }

  public boolean h()
  {
    return c(g());
  }

  public boolean h(String paramString)
  {
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = a(paramString);
    return (localChatExtensionLoaderEntity != null) && (av.d(localChatExtensionLoaderEntity.getFlags(), 131072));
  }

  public String i()
  {
    return ((ap.a)this.b.get()).S.d;
  }

  public String i(String paramString)
  {
    Lock localLock = this.f.readLock();
    try
    {
      localLock.lock();
      String str = (String)this.j.get(paramString);
      return str;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public String j()
  {
    return ((ap.a)this.b.get()).S.a;
  }

  @Deprecated
  public String k()
  {
    return d.n.d.d();
  }

  public String l()
  {
    return d.n.e.d();
  }

  public String m()
  {
    Lock localLock = this.f.readLock();
    while (true)
    {
      try
      {
        localLock.lock();
        Iterator localIterator = this.h.keySet().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          boolean bool = h(str);
          if (!bool)
            continue;
          return str;
        }
      }
      finally
      {
        localLock.unlock();
      }
      String str = null;
    }
  }

  public List<String> n()
  {
    Lock localLock = this.f.readLock();
    ArrayList localArrayList;
    try
    {
      localLock.lock();
      localArrayList = new ArrayList();
      Iterator localIterator = this.h.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (c(str))
          localArrayList.add(str);
      }
    }
    finally
    {
      localLock.unlock();
    }
    localLock.unlock();
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.c
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.controller.manager;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class k
{
  private static final Logger b = ViberEnv.getLogger();
  protected final o a = o.a();
  private Set<Long> c = new CopyOnWriteArraySet();
  private Set<Long> d = new CopyOnWriteArraySet();
  private Set<Long> e = new CopyOnWriteArraySet();
  private long f = -1L;
  private long g = -1L;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private String k;

  k(d paramd)
  {
    paramd.a(new d.b()
    {
      public void onAppStopped()
      {
        i.c(this);
      }

      public void onBackground()
      {
        k.this.d();
      }

      public void onForeground()
      {
        i.b(this);
      }

      public void onForegroundStateChanged(boolean paramAnonymousBoolean)
      {
        i.a(this, paramAnonymousBoolean);
      }
    });
  }

  private boolean a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean);
    try
    {
      if ((this.i) && (this.h))
      {
        long l = this.g;
        if (l != paramLong);
      }
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    finally
    {
    }
  }

  private void d(long paramLong)
  {
    if (!this.d.contains(Long.valueOf(paramLong)))
    {
      this.d.clear();
      this.d.add(Long.valueOf(paramLong));
      this.a.c(paramLong);
    }
  }

  private void e(long paramLong)
  {
    try
    {
      this.f = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Set<Long> a()
  {
    return this.c;
  }

  public void a(long paramLong)
  {
    if (this.e.remove(Long.valueOf(paramLong)))
      this.a.b(0L, this.c);
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      d(paramLong);
    if ((paramInt == 0) && (this.c.add(Long.valueOf(paramLong))))
      this.a.b(this.c, false);
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.e.add(Long.valueOf(paramLong2));
    this.a.b(paramLong1, this.e);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity.isPublicGroupType())
      a(paramConversationItemLoaderEntity.getGroupId(), paramConversationItemLoaderEntity.getId());
    while (true)
    {
      this.a.a(paramConversationItemLoaderEntity);
      return;
      a(paramConversationItemLoaderEntity.getId(), paramConversationItemLoaderEntity.getConversationType(), paramConversationItemLoaderEntity.isHiddenConversation());
    }
  }

  public void a(String paramString)
  {
    try
    {
      this.k = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Set<Long> paramSet)
  {
    if (this.c.removeAll(paramSet))
      this.a.b(this.c, false);
    if (this.e.removeAll(paramSet))
      this.a.b(0L, this.e);
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.i != paramBoolean)
      {
        this.i = paramBoolean;
        this.a.a(this.g, c(this.g), this.g);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(boolean paramBoolean, long paramLong)
  {
    this.a.a(paramBoolean, paramLong);
  }

  public long b(boolean paramBoolean)
  {
    try
    {
      if (a(this.g, paramBoolean))
      {
        l = this.g;
        return l;
      }
      long l = -1L;
    }
    finally
    {
    }
  }

  public Set<Long> b()
  {
    return this.d;
  }

  public void b(long paramLong)
  {
    try
    {
      e(paramLong);
      this.h = true;
      long l = this.g;
      this.g = paramLong;
      this.a.a(this.g, c(this.g), l);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramConversationItemLoaderEntity != null);
    try
    {
      if (paramConversationItemLoaderEntity.getId() == this.g)
      {
        this.h = false;
        this.a.a(this.g, c(this.g), this.g);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Set<Long> c()
  {
    return this.e;
  }

  public void c(boolean paramBoolean)
  {
    try
    {
      if (this.j != paramBoolean)
      {
        this.j = paramBoolean;
        this.a.a(paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean c(long paramLong)
  {
    try
    {
      boolean bool = a(paramLong, true);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d()
  {
    if (this.d.size() == 0)
      return;
    if (this.d.contains(Long.valueOf(this.g)))
      this.g = -1L;
    this.d.clear();
    this.a.e();
  }

  public void e()
  {
    d();
    this.c.clear();
    this.a.b(this.c, false);
  }

  public void f()
  {
    this.e.clear();
    this.a.b(0L, this.c);
  }

  public long g()
  {
    try
    {
      long l = b(true);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long h()
  {
    try
    {
      long l = this.f;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public HashSet<Long> i()
  {
    try
    {
      HashSet localHashSet = new HashSet(1);
      localHashSet.add(Long.valueOf(this.g));
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String j()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.k
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.controller.b;

import android.content.Context;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.like.LikeController;
import com.viber.jni.like.LikeControllerDelegate.GroupLikes;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.c;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.manager.aa;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.j;
import com.viber.voip.model.entity.m;
import com.viber.voip.notif.g;
import com.viber.voip.registration.af;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.av;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class n
  implements LikeControllerDelegate.GroupLikes, ac.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final bs c;
  private final ab d;
  private final o e;
  private final bn f;
  private final LikeController g;
  private final af h;

  public n(Context paramContext, af paramaf, bn parambn)
  {
    this.b = paramContext;
    this.g = ViberApplication.getInstance().getEngine(false).getLikeController();
    this.c = new bs(paramContext);
    this.d = ab.b();
    this.f = parambn;
    this.e = o.a();
    this.h = paramaf;
  }

  private bs.f a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, j paramj)
  {
    bs.f localf = this.c.a(paramBoolean2, paramLong, paramj);
    if ((localf.a) || (localf.b))
      this.g.handleGroupMessageLikeAck(paramj.b());
    if ((paramBoolean1) && (!paramj.f()) && (localf.b) && (localf.f != null))
    {
      long l = localf.f.getId();
      if (ViberApplication.getInstance().getMessagesManager().a().c(l))
        a(l, localf.f.d());
      this.f.a(localf.f, localf.h);
    }
    if ((localf.b) && (localf.f != null))
      this.e.a(localf.f.getId(), paramj.b(), false);
    return localf;
  }

  private void a(long paramLong, boolean paramBoolean)
  {
    if (this.c.c(paramLong))
      this.e.a(Collections.singleton(Long.valueOf(paramLong)), paramBoolean, true);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, j paramj)
  {
    bs.c localc = this.c.a(paramBoolean2, paramj.a(), paramj.d(), 1);
    this.g.handleGroupMessageLikeAck(paramj.b());
    if (localc.c != null)
    {
      long l = localc.c.getConversationId();
      this.e.a(l, paramj.b(), false);
      if (paramBoolean1)
        g.a(this.b).e().a(l);
    }
  }

  private static boolean a(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }

  private static boolean b(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }

  private static boolean c(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }

  public void a(boolean paramBoolean)
  {
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public boolean a(List<f.a> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList.isEmpty()) || (paramBoolean1))
      return false;
    i.a();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    b localb = aa.f();
    LongSparseSet localLongSparseSet = new LongSparseSet();
    localb.a();
    while (true)
    {
      f.a locala1;
      j localj2;
      int k;
      try
      {
        this.c.a(new f(false));
        Iterator localIterator1 = paramList.iterator();
        if (!localIterator1.hasNext())
          break;
        locala1 = (f.a)localIterator1.next();
        localLongSparseSet.addAll(locala1.g());
        Iterator localIterator4 = locala1.f().iterator();
        if (localIterator4.hasNext())
        {
          f.b localb1 = (f.b)localIterator4.next();
          localj2 = localb1.a();
          k = localb1.b();
          if (!localb1.c())
            break label269;
          bs.f localf = this.c.a(a(k), locala1.c(), localj2);
          if ((localf.b) && (localf.f != null))
            localHashSet.add(Long.valueOf(localf.f.getId()));
          localArrayList.add(new a(k, localj2, localf));
          continue;
        }
        continue;
      }
      finally
      {
        this.c.a(null);
        localb.b();
      }
      label269: bs.c localc = this.c.a(a(k), localj2.a(), localj2.d(), locala1.i());
      if (localc.c != null)
        localHashSet.add(Long.valueOf(localc.c.getConversationId()));
      localArrayList.add(new a(k, localj2, localc));
    }
    localb.c();
    this.c.a(null);
    localb.b();
    if (!localHashSet.isEmpty())
      this.e.a(localHashSet, 1, false, false);
    for (long l2 : localLongSparseSet.toArray())
      this.g.handleGroupMessageLikeAck(l2);
    Iterator localIterator2 = localArrayList.iterator();
    label562: label600: 
    while (localIterator2.hasNext())
    {
      a locala = (a)localIterator2.next();
      j localj1 = locala.a;
      if ((b(locala.e)) && (locala.g))
      {
        if ((!locala.h) || (localj1.f()))
          break label562;
        this.f.a(locala.d, locala.b);
      }
      while (true)
      {
        if (locala.b == null)
          break label600;
        this.e.a(locala.b.getConversationId(), localj1.b(), false);
        break;
        if ((!locala.h) && (locala.b != null))
          g.a(this.b).e().a(locala.b.getConversationId());
      }
    }
    com.viber.voip.messages.controller.manager.k localk = ViberApplication.getInstance().getMessagesManager().a();
    Iterator localIterator3 = localHashSet.iterator();
    while (localIterator3.hasNext())
    {
      long l1 = ((Long)localIterator3.next()).longValue();
      if (localk.c(l1))
        a(l1, paramBoolean2);
    }
    return false;
  }

  public void b(boolean paramBoolean)
  {
  }

  public boolean onGroupMessageLike(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt, boolean paramBoolean)
  {
    j localj = new j();
    localj.b(0);
    boolean bool1 = a(paramInt);
    boolean bool2;
    if ((c(paramInt)) || (bool1) || (!b(paramInt)))
    {
      bool2 = true;
      localj.a(bool2);
      localj.a(paramLong2);
      localj.b(paramLong3);
      if (bool1)
        paramString = this.h.l();
      localj.a(paramString);
      localj.c(paramLong4);
      if (!paramBoolean)
        break label122;
      a(paramLong1, b(paramInt), bool1, localj);
    }
    while (true)
    {
      return false;
      bool2 = false;
      break;
      label122: a(b(paramInt), bool1, localj);
    }
  }

  public void onLikeGroupMessageReply(long paramLong, int paramInt1, int paramInt2)
  {
    j localj = this.d.b(paramInt1);
    if (localj == null);
    int i;
    do
    {
      return;
      i = localj.h();
    }
    while (i == 0);
    if (paramInt2 == 0)
    {
      switch (i)
      {
      default:
        return;
      case 1:
        localj.b(paramLong);
        localj.b(0);
        this.d.b(localj);
        return;
      case 2:
      }
      this.d.d(localj.a(), localj.d());
      return;
    }
    MessageEntity localMessageEntity = this.d.k(localj.a());
    switch (i)
    {
    default:
    case 2:
    case 1:
    }
    while (true)
    {
      this.d.a(localMessageEntity);
      this.e.a(localMessageEntity.getConversationId(), localMessageEntity.getMessageToken(), false);
      return;
      localMessageEntity.setExtraFlags(av.a(localMessageEntity.getExtraFlags(), 12, true));
      localMessageEntity.setLikesCount(new UnsignedInt(localMessageEntity.getLikesCount()).increment());
      localj.b(0);
      this.d.b(localj);
      continue;
      localMessageEntity.setExtraFlags(av.a(localMessageEntity.getExtraFlags(), 12, false));
      localMessageEntity.setLikesCount(new UnsignedInt(localMessageEntity.getLikesCount()).decrement());
      this.d.d(localj.a(), localj.d());
    }
  }

  private static class a
  {
    final j a;
    final MessageEntity b;
    final m c;
    final h d;
    final int e;
    final boolean f;
    final boolean g;
    final boolean h;

    a(int paramInt, j paramj, bs.c paramc)
    {
      this.e = paramInt;
      this.a = paramj;
      this.b = paramc.c;
      this.c = null;
      this.d = null;
      this.f = paramc.a;
      this.g = paramc.b;
      this.h = false;
    }

    a(int paramInt, j paramj, bs.f paramf)
    {
      this.e = paramInt;
      this.a = paramj;
      this.b = paramf.h;
      this.c = paramf.g;
      this.d = paramf.f;
      this.f = paramf.a;
      this.g = paramf.b;
      this.h = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.n
 * JD-Core Version:    0.6.2
 */
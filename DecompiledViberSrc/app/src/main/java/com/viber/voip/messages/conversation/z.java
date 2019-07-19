package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.LruCache;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.e;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.m;
import com.viber.voip.user.UserData.OwnerChangedEvent;
import dagger.a;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class z<T extends aa> extends d
{
  private EventBus l;
  private LruCache<Integer, T> m = new LruCache(100)
  {
    protected int a(Integer paramAnonymousInteger, T paramAnonymousT)
    {
      return 1;
    }
  };
  private bv.l n = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousLong1 == z.this.t)
      {
        z.this.a(paramAnonymousLong2, paramAnonymousBoolean);
        z.this.l();
      }
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
      if (paramAnonymousLong == z.this.t)
        z.this.b(paramAnonymousLong);
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousMessageEntity.getConversationId() == z.this.t) && (!paramAnonymousMessageEntity.isPollOptionMessage()))
      {
        z.this.a(paramAnonymousMessageEntity.getId(), paramAnonymousMessageEntity.getMessageToken(), paramAnonymousBoolean);
        z.this.l();
      }
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousSet.contains(Long.valueOf(z.this.t)))
      {
        z.this.v();
        z.this.l();
      }
    }

    public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };
  private bv.n o = new bv.n()
  {
    public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousSet.contains(Long.valueOf(z.this.t)))
        z.this.l();
    }

    public void onContactStatusChanged(Map<Long, bv.n.a> paramAnonymousMap)
    {
    }

    public void onInitCache()
    {
      z.this.l();
    }

    public void onNewInfo(List<m> paramAnonymousList, boolean paramAnonymousBoolean)
    {
    }

    public void onParticipantDeleted(m paramAnonymousm)
    {
    }
  };
  protected long t;
  protected a<k> u;

  public z(Context paramContext, int paramInt, Uri paramUri, String[] paramArrayOfString, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    super(paramInt, paramUri, paramContext, paramLoaderManager, parama1, 0);
    this.u = parama;
    this.l = paramEventBus;
    a(paramArrayOfString);
    a("messages.conversation_id=? AND +deleted=0 AND status<>12 AND extra_flags & 4194304 = 0");
  }

  public z(Context paramContext, int paramInt, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    super(paramInt, c.e.a, paramContext, paramLoaderManager, parama1, 0);
    this.u = parama;
    this.l = paramEventBus;
    a(aa.a);
    a("messages.conversation_id=? AND +deleted=0 AND status<>12 AND extra_flags & 4194304 = 0");
  }

  public long I()
  {
    return this.t;
  }

  public long a(int paramInt)
  {
    aa localaa = (aa)this.m.get(Integer.valueOf(paramInt));
    if (localaa != null)
      return localaa.a();
    return super.a(paramInt);
  }

  protected abstract T a(Cursor paramCursor);

  protected abstract T a(MessageEntity paramMessageEntity);

  public void a(long paramLong)
  {
    if (this.t != paramLong)
    {
      this.t = paramLong;
      this.m.evictAll();
      r();
    }
  }

  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
  }

  protected void a(long paramLong, boolean paramBoolean)
  {
  }

  protected void b(long paramLong)
  {
  }

  public long d_(int paramInt)
  {
    aa localaa = (aa)this.m.get(Integer.valueOf(paramInt));
    if (localaa != null)
      return localaa.y();
    if (b_(paramInt))
      return this.f.getLong(16);
    return -1L;
  }

  public T f(int paramInt)
  {
    aa localaa = (aa)this.m.get(Integer.valueOf(paramInt));
    if ((localaa == null) && (b_(paramInt)))
    {
      localaa = a(this.f);
      this.m.put(Integer.valueOf(paramInt), localaa);
    }
    return localaa;
  }

  protected void m()
  {
    this.m.evictAll();
  }

  @Subscribe
  public void onOwnerChanged(UserData.OwnerChangedEvent paramOwnerChangedEvent)
  {
    l();
  }

  public void p()
  {
    super.p();
    bv localbv = ((k)this.u.get()).b();
    localbv.a(this.n, av.a(av.e.a));
    localbv.a(this.o);
    if (!this.l.isRegistered(this))
      this.l.register(this);
  }

  public void q()
  {
    super.q();
    bv localbv = ((k)this.u.get()).b();
    localbv.b(this.n);
    localbv.b(this.o);
    if (this.l.isRegistered(this))
      this.l.unregister(this);
  }

  protected void r()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(this.t);
    b(arrayOfString);
  }

  protected void v()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.z
 * JD-Core Version:    0.6.2
 */
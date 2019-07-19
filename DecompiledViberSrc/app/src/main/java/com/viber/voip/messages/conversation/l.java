package com.viber.voip.messages.conversation;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.d;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.m;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.r;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class l extends com.viber.provider.d
{
  private final a l;
  private final dagger.a<k> m;
  private ConversationItemLoaderEntity n;
  private long o;
  private bv.d p = new bv.d()
  {
    public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if (paramAnonymousSet.contains(Long.valueOf(l.a(l.this))))
        l.this.l();
    }

    public void onDelete(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousSet.contains(Long.valueOf(l.a(l.this))))
        l.b(l.this).c_(l.a(l.this));
    }

    public void onReadOutgoing(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousLong == l.a(l.this))
        l.this.l();
    }

    public void onWatchersCountChange(long paramAnonymousLong, int paramAnonymousInt)
    {
      if (paramAnonymousLong == l.a(l.this))
        l.this.l();
    }
  };
  private bv.n q = new bv.n()
  {
    public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousSet.contains(Long.valueOf(l.a(l.this))))
        l.this.l();
    }

    public void onContactStatusChanged(Map<Long, bv.n.a> paramAnonymousMap)
    {
    }

    public void onInitCache()
    {
    }

    public void onNewInfo(List<m> paramAnonymousList, boolean paramAnonymousBoolean)
    {
    }

    public void onParticipantDeleted(m paramAnonymousm)
    {
    }
  };
  private d.al r;

  protected l(int paramInt, Uri paramUri, Context paramContext, LoaderManager paramLoaderManager, d.a parama, dagger.a<k> parama1, a parama2)
  {
    super(paramInt, paramUri, paramContext, paramLoaderManager, parama, 0);
    Handler localHandler = this.i;
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.r.j;
    this.r = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        l.this.l();
      }
    };
    this.m = parama1;
    this.l = parama2;
    a(ConversationItemLoaderEntity.PROJECTIONS);
    a("conversations._id=?");
  }

  public l(Context paramContext, LoaderManager paramLoaderManager, dagger.a<k> parama, a parama1, d.a parama2)
  {
    super(2, c.d.b, paramContext, paramLoaderManager, parama2, 0);
    Handler localHandler = this.i;
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.r.j;
    this.r = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        l.this.l();
      }
    };
    this.m = parama;
    this.l = parama1;
    a(ConversationItemLoaderEntity.PROJECTIONS);
    a("conversations._id=?");
  }

  public void a(long paramLong)
  {
    this.o = paramLong;
    this.n = null;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    b(arrayOfString);
  }

  public ConversationItemLoaderEntity e(int paramInt)
  {
    if ((this.n == null) && (b_(paramInt)))
      this.n = new ConversationItemLoaderEntity(this.f);
    return this.n;
  }

  protected void m()
  {
    super.m();
    this.n = null;
  }

  public void p()
  {
    super.p();
    bv localbv = ((k)this.m.get()).b();
    localbv.a(this.p);
    localbv.a(this.q);
    com.viber.voip.settings.d.a(this.r);
  }

  public void q()
  {
    super.q();
    bv localbv = ((k)this.m.get()).b();
    localbv.b(this.p);
    localbv.b(this.q);
    com.viber.voip.settings.d.b(this.r);
  }

  public long r()
  {
    return this.o;
  }

  public static abstract interface a
  {
    public abstract void c_(long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.l
 * JD-Core Version:    0.6.2
 */
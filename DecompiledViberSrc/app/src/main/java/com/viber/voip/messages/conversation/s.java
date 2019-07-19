package com.viber.voip.messages.conversation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.o.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.i.c.d;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.controller.bv.j;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.b.ag;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.registration.ao;
import com.viber.voip.u.a.f.a;
import com.viber.voip.util.da;
import org.greenrobot.eventbus.EventBus;

public class s
  implements ah, f.a
{
  private static final Logger b = ViberEnv.getLogger();
  bv.j a = new bv.j()
  {
    public void a()
    {
      if ((s.this.j() != null) && (s.this.j().getId() == s.l(s.this)) && (s.h(s.this) != null))
        s.h(s.this).b(s.l(s.this));
    }

    public void a(long paramAnonymousLong)
    {
    }
  };
  private ConversationData c;
  private l d;
  private q e;
  private ac f;
  private com.viber.voip.messages.conversation.adapter.a.b.f g;
  private dagger.a<com.viber.voip.messages.k> h;
  private f i;
  private g j;
  private Context k;
  private LoaderManager l;
  private com.viber.voip.messages.conversation.ui.b.f m;
  private com.viber.voip.messages.conversation.ui.b.o n;
  private ag o;
  private com.viber.voip.messages.conversation.ui.b.l p;
  private boolean q;
  private boolean r;
  private long s;
  private EventBus t;
  private d.a u = new d.a()
  {
    public void onLoadFinished(d paramAnonymousd, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousd == s.a(s.this))
        if (s.b(s.this).r() == s.a(s.this).s())
          s.c(s.this).a(s.a(s.this), paramAnonymousBoolean);
      do
      {
        ConversationItemLoaderEntity localConversationItemLoaderEntity;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramAnonymousd != s.d(s.this))
                  break;
              }
              while (s.b(s.this).r() != s.d(s.this).r());
              s.e(s.this).a(s.d(s.this), paramAnonymousBoolean);
              return;
              if ((paramAnonymousd == s.f(s.this)) && (s.f(s.this).u()))
              {
                s.g(s.this).a(s.f(s.this), paramAnonymousBoolean, s.f(s.this).C(), s.f(s.this).u());
                return;
              }
              if (paramAnonymousd != s.b(s.this))
                break;
              localConversationItemLoaderEntity = s.this.j();
            }
            while ((localConversationItemLoaderEntity != null) && (s.this.r() != localConversationItemLoaderEntity.getId()));
            s.h(s.this).a(localConversationItemLoaderEntity, paramAnonymousBoolean);
          }
          while (!paramAnonymousBoolean);
          s.i(s.this);
        }
        while (localConversationItemLoaderEntity == null);
        if ((localConversationItemLoaderEntity.isGroupType()) || (localConversationItemLoaderEntity.isBroadcastListType()) || (localConversationItemLoaderEntity.isCommunityType()))
          s.a(s.this, localConversationItemLoaderEntity.getId());
        if (localConversationItemLoaderEntity.isGroupBehavior())
          s.b(s.this, localConversationItemLoaderEntity.getId());
        if (localConversationItemLoaderEntity.isBroadcastListType())
          s.c(s.this, localConversationItemLoaderEntity.getId());
        ((com.viber.voip.messages.k)s.j(s.this).get()).a().a(localConversationItemLoaderEntity);
        return;
      }
      while (paramAnonymousd != s.k(s.this));
      s.a(s.this, s.k(s.this).e(0));
      s.h(s.this).i();
    }

    public void onLoaderReset(d paramAnonymousd)
    {
    }
  };
  private l.a v = new l.a()
  {
    public void c_(final long paramAnonymousLong)
    {
      av.a(av.e.a).post(new Runnable()
      {
        public void run()
        {
          s.a(s.this, null);
          s.f(s.this).F();
          if (s.h(s.this) != null)
            s.h(s.this).b(paramAnonymousLong);
        }
      });
    }
  };

  public s(Context paramContext, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, com.viber.voip.messages.conversation.ui.b.f paramf, com.viber.voip.messages.conversation.ui.b.o paramo, com.viber.voip.messages.conversation.ui.b.l paraml, ag paramag, EventBus paramEventBus, int paramInt, Bundle paramBundle)
  {
    this.k = paramContext;
    this.l = paramLoaderManager;
    this.m = paramf;
    this.m.a(this);
    this.n = paramo;
    this.p = paraml;
    this.o = paramag;
    this.h = parama;
    this.t = paramEventBus;
    if (paramBundle != null)
      this.s = paramBundle.getLong("verified_conversation_id_extra");
    b(paramInt);
    com.viber.voip.messages.controller.manager.o.a().a(this.a);
  }

  private void a(long paramLong)
  {
    this.f.b(paramLong);
    this.f.i();
  }

  private void a(long paramLong, int paramInt)
  {
    long l1 = this.d.r();
    if ((l1 > 0L) && (l1 != paramLong))
      if ((j() == null) || (!j().isSecret()))
        break label155;
    label155: for (boolean bool = true; ; bool = false)
    {
      ((com.viber.voip.messages.k)this.h.get()).a().a(bool, l1);
      this.d.a(paramLong);
      this.e.a(paramLong);
      if (-1 != paramInt)
      {
        int i1 = Math.max(paramInt + 10, 50);
        this.e.d(i1);
      }
      this.d.i();
      this.e.i();
      if (this.f != null)
        this.f.b(0L);
      if (this.i != null)
        this.i.a(-1L);
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l1 = this.s;
      a();
      this.s = l1;
    }
  }

  private boolean a(ConversationData paramConversationData)
  {
    return (this.c != null) && (this.c.equals(paramConversationData));
  }

  private void b(int paramInt)
  {
    if (m.b(paramInt))
    {
      this.e = new k(this.k, this.l, this.h, this.u, this.t);
      this.d = new com.viber.voip.messages.conversation.publicaccount.a(this.k, this.l, this.h, this.v, this.u);
    }
    while (true)
    {
      if (!m.a(paramInt))
      {
        this.i = new f(this.k, ((com.viber.voip.messages.k)this.h.get()).b(), this.l, this.u, -1L);
        this.f = new ac(this.k, true, true, this.l, this.h, this.u, this.t);
      }
      this.g = new com.viber.voip.messages.conversation.adapter.a.b.f(this.k, this.l, this.h, this.u, ViberApplication.getInstance().getEngine(false), this.t);
      return;
      if (m.a(paramInt))
      {
        this.e = new k(this.k, this.l, this.h, this.u, this.t);
        this.d = new com.viber.voip.messages.conversation.publicaccount.n(this.k, this.l, this.h, this.v, this.u);
      }
      else
      {
        this.e = new t(this.k, this.l, this.h, this.u, this.t);
        this.d = new l(this.k, this.l, this.h, this.v, this.u);
      }
    }
  }

  private void b(long paramLong)
  {
    this.g.a(paramLong);
    this.g.i();
  }

  private void b(long paramLong1, long paramLong2)
  {
    this.e.a(paramLong1, paramLong2, 50);
    a(paramLong1, -1);
  }

  private void c(long paramLong)
  {
    this.i.a(paramLong);
    this.i.i();
  }

  private long u()
  {
    if (this.j != null)
      return this.j.a();
    return -1L;
  }

  private void v()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = j();
    if ((localConversationItemLoaderEntity == null) || (this.c == null))
      return;
    boolean bool1 = localConversationItemLoaderEntity.isHiddenConversation();
    if (localConversationItemLoaderEntity.getId() == this.s);
    for (int i1 = 1; ; i1 = 0)
    {
      int i2 = 0;
      if (i1 == 0)
      {
        i2 = 0;
        if (bool1)
        {
          boolean bool2 = this.c.ignorePin;
          i2 = 0;
          if (!bool2)
            i2 = 1;
        }
      }
      if (i1 == 0)
        this.s = 0L;
      if (i2 == 0)
        break label121;
      if (this.q)
        break;
      this.r = true;
      return;
    }
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        s.e(s.this).J();
      }
    });
    return;
    label121: if ((!ao.f()) && (localConversationItemLoaderEntity.showSpamOverlay()) && (localConversationItemLoaderEntity.hasBusinessInboxOverlay()) && (!c.d.a.e()))
      this.e.c(true);
    c();
    this.o.K();
  }

  public void a()
  {
    this.s = 0L;
    this.d.a(0L);
    this.d.j();
    this.e.F();
    this.e.j();
  }

  public void a(int paramInt)
  {
    this.d.y_();
    this.e.y_();
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.e.F();
    this.e.a(paramLong1, paramLong2, 50);
    this.e.i();
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putLong("verified_conversation_id_extra", this.s);
  }

  public void a(MessageEntity[] paramArrayOfMessageEntity, Bundle paramBundle)
  {
    if (paramArrayOfMessageEntity.length == 0)
      return;
    int i1 = paramArrayOfMessageEntity.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      MessageEntity localMessageEntity = paramArrayOfMessageEntity[i2];
      if (localMessageEntity.getMessageSeq() <= 0)
        localMessageEntity.setMessageSeq(ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence());
      this.e.a(this.e.a(localMessageEntity));
    }
    if (da.a(com.viber.voip.analytics.story.n.b(paramBundle)))
      paramBundle = com.viber.voip.analytics.story.n.a(paramBundle, StoryConstants.o.a.a(paramArrayOfMessageEntity[0]));
    Bundle localBundle = com.viber.voip.analytics.story.n.a(paramBundle, m());
    if (paramArrayOfMessageEntity.length > 1)
    {
      ((com.viber.voip.messages.k)this.h.get()).c().a(paramArrayOfMessageEntity, localBundle);
      return;
    }
    ((com.viber.voip.messages.k)this.h.get()).c().a(paramArrayOfMessageEntity[0], localBundle);
  }

  public boolean a(aa paramaa)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = j();
    if (localConversationItemLoaderEntity != null)
    {
      if (localConversationItemLoaderEntity.isBroadcastListType())
        if (paramaa.a() > u());
      while (paramaa.y() <= localConversationItemLoaderEntity.getReadNotificationToken())
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }

  public boolean a(final ConversationData paramConversationData, boolean paramBoolean)
  {
    if ((!a(paramConversationData)) || (paramBoolean));
    ai.e local4;
    for (boolean bool = true; ; bool = false)
    {
      this.c = paramConversationData;
      local4 = new ai.e()
      {
        public void a(final ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
        {
          av.a(av.e.a).postAtFrontOfQueue(new Runnable()
          {
            public void run()
            {
              if ((s.h(s.this) != null) && (paramAnonymousConversationItemLoaderEntity != null) && (s.b(s.this, s.4.this.a)))
                s.a(s.this, paramAnonymousConversationItemLoaderEntity.getId(), 0);
            }
          });
        }
      };
      if (bool)
      {
        this.j = null;
        this.e.F();
      }
      if (paramConversationData.conversationId <= 0L)
        break label135;
      if (!paramBoolean)
        break;
      b(paramConversationData.conversationId, paramConversationData.foundMessageOrderKey);
      return bool;
    }
    if (paramConversationData.unreadMessagesAndCallsCount != -1)
    {
      a(paramConversationData.conversationId, paramConversationData.unreadMessagesAndCallsCount);
      return bool;
    }
    a(bool);
    ((com.viber.voip.messages.k)this.h.get()).c().a(paramConversationData.conversationId, local4);
    return bool;
    label135: if ((paramConversationData.conversationType == 0) || (1 == paramConversationData.conversationType))
    {
      a(bool);
      int i1;
      ai localai;
      int i2;
      if (paramConversationData.conversationType == 0)
      {
        i1 = 1;
        localai = ((com.viber.voip.messages.k)this.h.get()).c();
        i2 = paramConversationData.conversationType;
        if (i1 == 0)
          break label242;
      }
      label242: for (Member localMember = new Member(paramConversationData.memberId, paramConversationData.number); ; localMember = null)
      {
        localai.a(i2, localMember, paramConversationData.groupId, true, paramConversationData.secretConversation, local4);
        return bool;
        i1 = 0;
        break;
      }
    }
    a(bool);
    if ((paramConversationData instanceof PublicGroupConversationData));
    for (PublicAccount localPublicAccount = ((PublicGroupConversationData)paramConversationData).publicGroupInfo; ; localPublicAccount = null)
    {
      ((com.viber.voip.messages.k)this.h.get()).c().a(paramConversationData.conversationType, paramConversationData.groupId, localPublicAccount, local4);
      return bool;
    }
  }

  public void b()
  {
    this.e.c(false);
  }

  public void c()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = j();
    if ((localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isHiddenConversation()))
    {
      this.s = localConversationItemLoaderEntity.getId();
      this.m.a(localConversationItemLoaderEntity, this.d.f());
    }
    this.e.b(true);
    if (this.e.f())
      this.u.onLoadFinished(this.e, true);
  }

  public boolean d()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = j();
    return (localConversationItemLoaderEntity != null) && (localConversationItemLoaderEntity.isHiddenConversation()) && (this.s == localConversationItemLoaderEntity.getId());
  }

  public void e()
  {
    this.q = true;
    if (this.r)
    {
      v();
      this.r = false;
    }
  }

  public void f()
  {
    k();
    com.viber.voip.messages.controller.manager.o.a().b(this.a);
    if (this.d.r() > 0L)
      if ((j() == null) || (!j().isSecret()))
        break label130;
    label130: for (boolean bool = true; ; bool = false)
    {
      ((com.viber.voip.messages.k)this.h.get()).a().a(bool, this.d.r());
      this.d.j();
      this.e.j();
      if (this.f != null)
        this.f.j();
      if (this.i != null)
        this.i.j();
      if (this.g != null)
        this.g.j();
      return;
    }
  }

  public q g()
  {
    return this.e;
  }

  public ac h()
  {
    return this.f;
  }

  public com.viber.voip.messages.conversation.adapter.a.b.f i()
  {
    return this.g;
  }

  public ConversationItemLoaderEntity j()
  {
    return this.d.e(0);
  }

  public void k()
  {
    this.e.q();
    this.d.q();
    if (this.f != null)
      this.f.q();
    if (this.i != null)
      this.i.q();
    if (this.g != null)
      this.g.q();
  }

  public void l()
  {
    this.e.p();
    this.d.p();
    if (this.f != null)
      this.f.p();
    if (this.g != null)
      this.g.p();
    if (this.i != null)
      this.i.p();
  }

  public int m()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = j();
    if ((this.f != null) && (localConversationItemLoaderEntity != null))
    {
      if (localConversationItemLoaderEntity.isCommunityType())
        return da.a(this.f, (PublicGroupConversationItemLoaderEntity)localConversationItemLoaderEntity);
      return this.f.getCount();
    }
    return 0;
  }

  public void n()
  {
    this.e.A();
  }

  public boolean o()
  {
    return this.e.B();
  }

  public long p()
  {
    aa localaa = this.e.f(0);
    if (localaa != null)
      return localaa.y();
    return -1L;
  }

  public long q()
  {
    return this.e.H();
  }

  public long r()
  {
    return this.d.r();
  }

  public void s()
  {
  }

  public void t()
  {
    this.d.c();
    this.e.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.s
 * JD-Core Version:    0.6.2
 */
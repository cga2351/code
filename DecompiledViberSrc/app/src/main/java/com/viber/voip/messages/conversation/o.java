package com.viber.voip.messages.conversation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ai.l;
import com.viber.voip.messages.controller.bv.j;
import com.viber.voip.messages.controller.manager.ag;
import com.viber.voip.messages.controller.manager.y;
import com.viber.voip.messages.controller.manager.y.a;
import com.viber.voip.messages.conversation.a.h;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.util.LongSparseSet;
import java.util.ArrayList;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class o extends ai
  implements bv.j
{
  protected static final Logger w = ViberEnv.getLogger();
  protected ArrayList<RegularConversationLoaderEntity> x;
  private LongSparseSet y;
  private final ai.l z = new ai.l()
  {
    public void a(final y paramAnonymousy, final ArrayList paramAnonymousArrayList)
    {
      o.d(o.this).post(new Runnable()
      {
        public void run()
        {
          if ((paramAnonymousy.a() != null) && (paramAnonymousy.a().equals(o.this.o)))
          {
            o.this.x = new ArrayList();
            o.this.r = new ArrayList();
            o.a(o.this, new LongSparseSet());
            int i = paramAnonymousArrayList.size();
            int j = 0;
            int k = 0;
            if (j < i)
            {
              RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)paramAnonymousArrayList.get(j);
              if (localRegularConversationLoaderEntity.isCommunityType())
                o.a(o.this).add(localRegularConversationLoaderEntity.getGroupId());
              if (k == 0)
              {
                if ((ConversationLoaderEntity.a.e == localRegularConversationLoaderEntity.getSearchSection()) || (ConversationLoaderEntity.a.d == localRegularConversationLoaderEntity.getSearchSection()))
                  k = 1;
              }
              else
              {
                label172: if ((!paramAnonymousy.g()) || (k != 0))
                  break label215;
                o.this.x.add(localRegularConversationLoaderEntity);
              }
              while (true)
              {
                j++;
                break;
                k = 0;
                break label172;
                label215: o.this.r.add(localRegularConversationLoaderEntity);
              }
            }
            if (o.b(o.this) != null)
              o.c(o.this).onLoadFinished(o.this, false);
          }
        }
      });
    }
  };

  public o(Context paramContext, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, boolean paramBoolean1, boolean paramBoolean2, n.a parama1, Bundle paramBundle, String paramString, d.a parama2, EventBus paramEventBus, h paramh, dagger.a<ConferenceCallsRepository> parama3)
  {
    super(paramContext, paramLoaderManager, parama, paramBoolean1, paramBoolean2, parama1, paramBundle, paramString, parama2, paramEventBus, paramh, parama3);
  }

  protected void D()
  {
    super.D();
    this.x = null;
    this.y = null;
  }

  public ArrayList<RegularConversationLoaderEntity> H()
  {
    return this.x;
  }

  public LongSparseSet I()
  {
    return this.y;
  }

  public final String J()
  {
    if (this.x == null);
    for (int i = 0; i == 0; i = this.x.size())
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    for (int j = 0; j < i; j++)
    {
      ConversationLoaderEntity localConversationLoaderEntity = (ConversationLoaderEntity)this.x.get(j);
      long l = localConversationLoaderEntity.getContactId();
      if (!localConversationLoaderEntity.isGroupBehavior())
        localStringBuilder.append(l).append(',');
    }
    if (localStringBuilder.length() == 0)
      return null;
    localStringBuilder.setLength(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  public void a()
  {
    F();
  }

  public void a(long paramLong)
  {
    F();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }

  public void i()
  {
    try
    {
      super.i();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void p()
  {
    super.p();
    if (this.s)
      com.viber.voip.messages.controller.manager.o.a().a(this);
  }

  public void q()
  {
    super.q();
    if (this.s)
      com.viber.voip.messages.controller.manager.o.a().b(this);
  }

  protected String v()
  {
    if (this.s)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(super.v()).append(" OR ");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = com.viber.voip.s.a.e(((com.viber.voip.messages.k)this.n.get()).a().b());
      return String.format("conversations._id IN(%s)", arrayOfObject);
    }
    return super.v();
  }

  protected void w()
  {
    if (this.u == null)
      this.u = new ag();
    ((com.viber.voip.messages.k)this.n.get()).c().a(y().a(), this.u, this.z);
  }

  protected Set<Long> z()
  {
    return ((com.viber.voip.messages.k)this.n.get()).a().a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.o
 * JD-Core Version:    0.6.2
 */
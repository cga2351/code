package com.viber.voip.messages.conversation.publicaccount;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.conversation.ConversationWithPublicAccountLoaderEntity;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.m;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.b;
import com.viber.voip.messages.ui.PublicGroupsFragmentModeManager.a;
import com.viber.voip.util.av;
import java.util.HashSet;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class o extends n<ConversationWithPublicAccountLoaderEntity>
{
  private Set<Long> w = new HashSet();

  public o(Context paramContext, int paramInt, Uri paramUri, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, d.a parama1, EventBus paramEventBus)
  {
    super(paramContext, paramInt, paramUri, paramLoaderManager, parama, parama1, paramEventBus, null, null);
  }

  public o(Context paramContext, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, boolean paramBoolean, d.a parama1, EventBus paramEventBus)
  {
    super(paramContext, 17, c.h.b, paramLoaderManager, parama, parama1, paramEventBus, null, null);
    this.q = paramBoolean;
    a(ConversationWithPublicAccountLoaderEntity.PROJECTIONS);
    this.p = z();
    a(r());
  }

  protected MessagesFragmentModeManager.b C()
  {
    int i = this.f.getInt(6);
    if ((3 == i) || (av.c(this.f.getInt(ConversationWithPublicAccountLoaderEntity.PUBLIC_GROUP_EXTRA_FLAG_INDX), 0)) || (av.c(this.f.getInt(3), 6)));
    for (boolean bool = true; ; bool = false)
      return new PublicGroupsFragmentModeManager.a(true, false, bool, this.f.getLong(0), i, this.f.getString(4), this.f.getLong(5), this.f.getInt(1), this.f.getLong(3), this.f.getInt(9), this.f.getInt(50), av.c(this.f.getInt(ConversationWithPublicAccountLoaderEntity.PUBLIC_GROUP_EXTRA_FLAG_INDX), 0));
  }

  protected ConversationWithPublicAccountLoaderEntity a(Cursor paramCursor)
  {
    return new ConversationWithPublicAccountLoaderEntity(paramCursor);
  }

  protected String r()
  {
    if (ViberApplication.isTablet(this.d))
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = com.viber.voip.s.a.e(z());
      return String.format("((conversations.deleted=0 AND conversations.conversation_type=2) OR conversations._id IN (%s)) AND conversations.group_id=public_accounts.group_id AND public_accounts.verified & 16384=0", arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = com.viber.voip.s.a.e(z());
    return String.format("(conversations.deleted=0 AND conversations.conversation_type=2) OR conversations._id IN (%s)", arrayOfObject1);
  }

  protected bv.e s()
  {
    if (this.t == null)
      this.t = new bv.d()
      {
        public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          if (m.a(paramAnonymousInt))
            o.this.l();
        }

        public void onDelete(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (m.a(paramAnonymousInt))
            o.this.l();
        }

        public void onOpenPublicGroup(long paramAnonymousLong, Set<Long> paramAnonymousSet)
        {
          if (o.a(o.this))
          {
            o.this.a(o.this.r());
            o.this.l();
          }
        }

        public void onRead(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (m.a(paramAnonymousInt))
            o.this.l();
        }

        public void onWatchersCountChange(long paramAnonymousLong, int paramAnonymousInt)
        {
          if (paramAnonymousInt < 1000.0D)
            o.this.l();
        }
      };
    return this.t;
  }

  protected Set<Long> z()
  {
    if (ViberApplication.isTablet(this.d))
      this.w = ((com.viber.voip.messages.k)this.n.get()).a().c();
    return this.w;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.o
 * JD-Core Version:    0.6.2
 */
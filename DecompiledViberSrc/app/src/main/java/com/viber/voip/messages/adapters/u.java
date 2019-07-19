package com.viber.voip.messages.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import com.viber.dexshared.Logger;
import com.viber.provider.c;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.g.b.b;
import com.viber.voip.messages.adapters.a.c.a.a;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.ui.ck;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.ui.ac;
import com.viber.voip.ui.g.d;
import java.util.Collection;

public class u extends BaseAdapter
  implements AbsListView.RecyclerListener
{
  protected static final Logger a = ViberEnv.getLogger();
  private final dagger.a<v> b;
  private c<ConversationLoaderEntity> c;
  private MessagesFragmentModeManager d;
  private ac e;
  private dagger.a<com.viber.voip.messages.adapters.a.c.a> f;
  private long g;
  private final boolean h;
  private final dagger.a<ConferenceCallsRepository> i;

  public u(Context paramContext, c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, dagger.a<ConferenceCallsRepository> parama, boolean paramBoolean1, boolean paramBoolean2, LayoutInflater paramLayoutInflater, e parame)
  {
  }

  public u(final Context paramContext, c<ConversationLoaderEntity> paramc, ac paramac, dagger.a<ConferenceCallsRepository> parama, final boolean paramBoolean1, boolean paramBoolean2, final LayoutInflater paramLayoutInflater, final e parame)
  {
    this.h = paramBoolean2;
    this.c = paramc;
    this.e = paramac;
    this.i = parama;
    this.f = new b()
    {
      protected com.viber.voip.messages.adapters.a.c.a a()
      {
        com.viber.voip.messages.adapters.a.c.a locala = new com.viber.voip.messages.adapters.a.c.a(paramContext, u.a(u.this), paramBoolean1, u.b(u.this), u.this.c());
        locala.a(u.c(u.this));
        return locala;
      }
    };
    this.b = new b()
    {
      protected v a()
      {
        return v.a(paramLayoutInflater, parame);
      }
    };
  }

  private int c(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
  {
    a.a locala = ((com.viber.voip.messages.adapters.a.c.a)this.f.get()).c();
    if ((paramRegularConversationLoaderEntity != null) && (a(paramRegularConversationLoaderEntity)))
      return 5;
    if ((paramRegularConversationLoaderEntity != null) && (b(paramRegularConversationLoaderEntity)) && (a.a.a == locala))
      return 6;
    if (a.a.a != locala)
    {
      if ((paramRegularConversationLoaderEntity != null) && (!paramRegularConversationLoaderEntity.isGroupBehavior()))
        return 2;
      if (a.a.c == locala)
        return 4;
      return 3;
    }
    if (d(paramRegularConversationLoaderEntity))
    {
      if (paramRegularConversationLoaderEntity.isGroupBehavior())
        return 8;
      return 7;
    }
    if ((paramRegularConversationLoaderEntity != null) && (paramRegularConversationLoaderEntity.isGroupBehavior()))
      return 1;
    return 0;
  }

  private boolean d(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
  {
    return (paramRegularConversationLoaderEntity != null) && (this.i != null) && (b()) && (((ConferenceCallsRepository)this.i.get()).hasConversationConferenceAvailableToJoin(paramRegularConversationLoaderEntity.getId()));
  }

  public com.viber.voip.messages.adapters.a.a a(int paramInt)
  {
    boolean bool1 = true;
    RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)this.c.b(paramInt);
    OngoingConferenceCallModel localOngoingConferenceCallModel;
    boolean bool2;
    if ((localRegularConversationLoaderEntity != null) && (this.i != null))
    {
      localOngoingConferenceCallModel = ((ConferenceCallsRepository)this.i.get()).getConversationConferenceAvailableToJoin(localRegularConversationLoaderEntity.getId());
      if (localRegularConversationLoaderEntity == null)
        break label122;
      if ((this.d == null) || (!this.d.b(Long.valueOf(localRegularConversationLoaderEntity.getId()))))
        break label111;
      bool2 = bool1;
      label79: if (localRegularConversationLoaderEntity.getId() != this.g)
        break label117;
    }
    while (true)
    {
      return new g(localRegularConversationLoaderEntity, bool2, bool1, localOngoingConferenceCallModel);
      localOngoingConferenceCallModel = null;
      break;
      label111: bool2 = false;
      break label79;
      label117: bool1 = false;
    }
    label122: return null;
  }

  public void a()
  {
    ((com.viber.voip.messages.adapters.a.c.a)this.f.get()).d();
  }

  public void a(long paramLong)
  {
    this.g = paramLong;
  }

  public void a(long paramLong, Collection<ck> paramCollection)
  {
    ((com.viber.voip.messages.adapters.a.c.a)this.f.get()).a(paramLong, paramCollection);
  }

  public void a(a.a parama)
  {
    ((com.viber.voip.messages.adapters.a.c.a)this.f.get()).a(parama);
  }

  public void a(String paramString, int paramInt, ck paramck, boolean paramBoolean)
  {
    ((com.viber.voip.messages.adapters.a.c.a)this.f.get()).a(paramString, paramInt, paramck, paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
    ((com.viber.voip.messages.adapters.a.c.a)this.f.get()).a(paramBoolean);
  }

  protected boolean a(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
  {
    return paramRegularConversationLoaderEntity.isInBusinessInbox();
  }

  protected boolean b()
  {
    return false;
  }

  protected boolean b(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
  {
    return paramRegularConversationLoaderEntity.isVlnConversation();
  }

  protected boolean c()
  {
    return false;
  }

  public com.viber.voip.messages.adapters.a.c.a d()
  {
    return (com.viber.voip.messages.adapters.a.c.a)this.f.get();
  }

  public int getCount()
  {
    return this.c.getCount();
  }

  public long getItemId(int paramInt)
  {
    return this.c.a(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    return c((RegularConversationLoaderEntity)this.c.b(paramInt));
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.viber.voip.messages.adapters.a.a locala = a(paramInt);
    RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)locala.a();
    Object localObject1;
    Object localObject2;
    label39: int j;
    if (paramView == null)
    {
      localObject1 = null;
      if (paramView == null)
        break label160;
      localObject2 = paramView.getTag(R.id.list_item_type);
      j = c(localRegularConversationLoaderEntity);
      if ((paramView == null) || ((localObject2 != null) && (((Integer)localObject2).intValue() == j)))
        break label176;
    }
    label160: label176: for (View localView1 = null; ; localView1 = paramView)
    {
      if ((localView1 == null) || (!(localObject1 instanceof com.viber.voip.ui.g.a)));
      for (View localView2 = ((v)this.b.get()).a(j, paramViewGroup); ; localView2 = localView1)
      {
        ((com.viber.voip.ui.g.a)localView2.getTag()).a().a(locala, (com.viber.voip.ui.g.a.a)this.f.get());
        localView2.setTag(R.id.list_item_type, Integer.valueOf(j));
        return localView2;
        localObject1 = paramView.getTag();
        break;
        localObject2 = Integer.valueOf(-1);
        break label39;
      }
    }
  }

  public int getViewTypeCount()
  {
    return 9;
  }

  public void onMovedToScrapHeap(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof com.viber.voip.ui.g.a))
      ((com.viber.voip.ui.g.a)localObject).a().a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.u
 * JD-Core Version:    0.6.2
 */
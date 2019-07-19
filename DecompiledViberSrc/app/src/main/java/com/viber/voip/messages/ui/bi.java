package com.viber.voip.messages.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.contacts.adapters.g.a;
import com.viber.voip.contacts.adapters.i;
import com.viber.voip.messages.adapters.a.b.h;
import com.viber.voip.messages.adapters.a.b.j;
import com.viber.voip.messages.adapters.a.c.a.a;
import com.viber.voip.messages.adapters.g;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity.a;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.model.entity.d;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.widget.AvatarWithInitialsView;
import java.util.ArrayList;

public class bi extends i
  implements com.viber.provider.c
{
  private final ArrayList<RegularConversationLoaderEntity> k = new ArrayList();
  private final dagger.a<com.viber.voip.messages.adapters.a.c.a> l;
  private final SparseArray<String> m;
  private final Drawable n;
  private final int o;
  private boolean p;

  public bi(final Activity paramActivity, final boolean paramBoolean, com.viber.voip.contacts.a parama1, com.viber.voip.contacts.a parama2, LayoutInflater paramLayoutInflater)
  {
    super(paramActivity, paramBoolean, parama1, parama2, paramLayoutInflater);
    this.l = new com.viber.voip.g.b.b()
    {
      protected com.viber.voip.messages.adapters.a.c.a a()
      {
        return new com.viber.voip.messages.adapters.a.c.a(paramActivity, null, false, paramBoolean, false);
      }
    };
    this.m = new SparseArray(3);
    this.m.append(R.string.search_hidden_chats_title, paramActivity.getString(R.string.search_hidden_chats_title));
    this.m.append(R.string.search_chats_title, paramActivity.getString(R.string.search_chats_title));
    this.m.append(R.string.search_other_contacts_title, paramActivity.getString(R.string.search_other_contacts_title));
    this.n = ContextCompat.getDrawable(paramActivity, R.drawable.hidden_chat_overlay);
    this.o = paramActivity.getResources().getDimensionPixelSize(R.dimen.contacts_item_top_bottom_margin);
  }

  private String g(int paramInt)
  {
    if (paramInt < this.k.size())
      return (String)this.m.get(((RegularConversationLoaderEntity)this.k.get(paramInt)).getSearchSection().a());
    if (paramInt == this.k.size())
      return (String)this.m.get(R.string.search_other_contacts_title);
    return null;
  }

  public long a(int paramInt)
  {
    return getItemId(paramInt);
  }

  public void a(a.a parama)
  {
    ((com.viber.voip.messages.adapters.a.c.a)this.l.get()).a(parama);
  }

  public void a(ArrayList<RegularConversationLoaderEntity> paramArrayList)
  {
    this.k.clear();
    this.p = false;
    if (paramArrayList != null)
    {
      this.k.addAll(paramArrayList);
      if ((this.k.size() <= 0) || (!((RegularConversationLoaderEntity)this.k.get(0)).isHiddenConversation()))
        break label60;
    }
    label60: for (boolean bool = true; ; bool = false)
    {
      this.p = bool;
      return;
    }
  }

  protected com.viber.provider.c b()
  {
    return this;
  }

  public Object b(int paramInt)
  {
    return c(paramInt);
  }

  public com.viber.voip.model.c c(int paramInt)
  {
    if (paramInt < this.k.size())
      return new a((ConversationLoaderEntity)this.k.get(paramInt), (com.viber.voip.messages.adapters.a.c.a)this.l.get());
    return super.c(paramInt - this.k.size());
  }

  public boolean c()
  {
    return this.p;
  }

  protected int e(int paramInt)
  {
    if (paramInt < this.k.size())
      return 0;
    return super.e(paramInt);
  }

  public boolean e_(int paramInt)
  {
    return g(paramInt) != null;
  }

  public int getCount()
  {
    return this.k.size() + super.getCount();
  }

  public long getItemId(int paramInt)
  {
    if (paramInt < this.k.size())
      return -1L;
    return super.getItemId(paramInt - this.k.size());
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.k.size())
    {
      if (((RegularConversationLoaderEntity)this.k.get(paramInt)).isGroupBehavior())
        return 3;
      return 2;
    }
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    g.a locala = (g.a)localView.getTag();
    String str = g(paramInt);
    int i;
    label148: RegularConversationLoaderEntity localRegularConversationLoaderEntity;
    if (str != null)
    {
      locala.i.setVisibility(0);
      locala.i.setText(f(getSectionForPosition(paramInt)));
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)locala.o.getLayoutParams();
      if (this.k.size() == 0)
      {
        i = 0;
        localMarginLayoutParams.topMargin = 0;
        localMarginLayoutParams.bottomMargin = i;
        locala.o.setPadding(0, locala.o.getPaddingTop(), locala.o.getPaddingRight(), locala.o.getPaddingBottom());
        locala.e.setVisibility(0);
        locala.h.setText(str);
        if ((paramInt == -1 + this.k.size()) || ((paramInt < -1 + getCount()) && (e_(paramInt + 1))))
          locala.n.setVisibility(8);
        if (paramInt >= this.k.size())
          break label358;
        localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)this.k.get(paramInt);
        label215: if ((localRegularConversationLoaderEntity == null) || (!localRegularConversationLoaderEntity.isHiddenConversation()))
          break label407;
        if (localRegularConversationLoaderEntity.getUnreadEventsCount() != 0)
          break label364;
        dj.c(locala.c, false);
        label245: if (3 != getItemViewType(paramInt))
          break label392;
        ((j)localView.getTag(R.id.participants_view_binder)).a(new g(localRegularConversationLoaderEntity, false, false), (com.viber.voip.messages.adapters.a.c.a)this.l.get());
      }
    }
    while (true)
    {
      if (localRegularConversationLoaderEntity != null)
        ((h)localView.getTag(R.id.status_icon_view_binder)).a(new g(localRegularConversationLoaderEntity, false, false), (com.viber.voip.messages.adapters.a.c.a)this.l.get());
      return localView;
      i = this.o;
      break;
      locala.e.setVisibility(8);
      break label148;
      label358: localRegularConversationLoaderEntity = null;
      break label215;
      label364: dj.c(locala.c, true);
      locala.c.setText(String.valueOf(localRegularConversationLoaderEntity.getUnreadEventsCount()));
      break label245;
      label392: locala.r.setSelector(this.n);
      continue;
      label407: locala.r.setSelector(null);
      dj.c(locala.c, false);
    }
  }

  public static final class a extends d
  {
    private final com.viber.voip.messages.adapters.a.c.a F;
    private final ConversationLoaderEntity a;

    a(ConversationLoaderEntity paramConversationLoaderEntity, com.viber.voip.messages.adapters.a.c.a parama)
    {
      this.a = paramConversationLoaderEntity;
      this.F = parama;
      if (this.a.isGroupBehavior())
        c();
      while (true)
      {
        c(true);
        return;
        b();
      }
    }

    private void b()
    {
      String str1;
      if ((this.a.isVlnConversation()) && (this.F.c() != a.a.a))
      {
        str1 = dg.a(this.a.getParticipantName(), this.a.getToNumber());
        i(str1);
        if (!TextUtils.isEmpty(str1))
          break label134;
      }
      label134: for (String str2 = ""; ; str2 = str1.substring(0, 1))
      {
        k(str2);
        f(this.a.getParticipantMemberId() + g + this.a.getNumber());
        a(com.viber.voip.messages.d.c.c().a(this.a.getParticipantInfos()[0]));
        return;
        str1 = this.a.getParticipantName();
        break;
      }
    }

    private void c()
    {
      String str = dg.b(this.a.getGroupName());
      i(str);
      k(str.substring(0, 1));
      f(null);
      a(null);
    }

    public ConversationLoaderEntity a()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bi
 * JD-Core Version:    0.6.2
 */
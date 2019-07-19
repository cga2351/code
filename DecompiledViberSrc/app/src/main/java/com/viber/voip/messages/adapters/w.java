package com.viber.voip.messages.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ads.d.n;
import com.viber.voip.messages.adapters.a.b.s;
import com.viber.voip.messages.conversation.ConversationWithPublicAccountLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.o;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.PublicAccountAdView.a;

public class w extends BaseAdapter
{
  private b a;
  private LayoutInflater b;
  private o c;
  private e d;
  private com.viber.voip.messages.adapters.a.c.a e;
  private com.viber.voip.messages.d.b f;
  private ai g;
  private com.viber.voip.messages.j h;
  private long i;
  private MessagesFragmentModeManager j;
  private PublicAccountAdView.a k;
  private n l;

  public w(Context paramContext, MessagesFragmentModeManager paramMessagesFragmentModeManager, o paramo, PublicAccountAdView.a parama, LayoutInflater paramLayoutInflater)
  {
    this.c = paramo;
    this.k = parama;
    this.f = com.viber.voip.messages.d.c.c();
    this.h = new com.viber.voip.messages.j(paramContext);
    this.g = new ai(paramContext);
    this.b = paramLayoutInflater;
    this.e = new com.viber.voip.messages.adapters.a.c.a(paramContext, paramMessagesFragmentModeManager, false, ViberApplication.isTablet(paramContext), false);
    this.j = paramMessagesFragmentModeManager;
  }

  private View a(a parama, ViewGroup paramViewGroup)
  {
    if (a.a == parama)
    {
      View localView3 = this.b.inflate(R.layout.fragment_messages_public_account_list_item, paramViewGroup, false);
      localView3.setTag(new com.viber.voip.messages.adapters.a.a.j(this.d).a(localView3, parama.ordinal(), paramViewGroup));
      return localView3;
    }
    if (a.b == parama)
    {
      View localView2 = this.b.inflate(R.layout.fragment_messages_public_account_with_public_chat_list_item, paramViewGroup, false);
      localView2.setTag(new com.viber.voip.messages.adapters.a.a.k(this.h, this.g, this.d, this.f).a(localView2, parama.ordinal(), paramViewGroup));
      return localView2;
    }
    View localView1 = this.b.inflate(R.layout.fragment_messages_public_group_ad_list_item, paramViewGroup, false);
    localView1.setTag(new s(localView1, this.k));
    return localView1;
  }

  private com.viber.voip.messages.adapters.a.c a(int paramInt)
  {
    boolean bool1 = true;
    ConversationWithPublicAccountLoaderEntity localConversationWithPublicAccountLoaderEntity = (ConversationWithPublicAccountLoaderEntity)this.c.e(paramInt);
    if (localConversationWithPublicAccountLoaderEntity == null)
      throw new IllegalArgumentException("ConversationWithPublicAccountLoaderEntity can't be null!");
    boolean bool2;
    if ((this.j != null) && (this.j.b(Long.valueOf(localConversationWithPublicAccountLoaderEntity.getId()))))
    {
      bool2 = bool1;
      if (localConversationWithPublicAccountLoaderEntity.getId() != this.i)
        break label85;
    }
    while (true)
    {
      return new h(localConversationWithPublicAccountLoaderEntity, bool2, bool1);
      bool2 = false;
      break;
      label85: bool1 = false;
    }
  }

  public void a(long paramLong)
  {
    this.i = paramLong;
  }

  public int getCount()
  {
    return this.c.getCount();
  }

  public Object getItem(int paramInt)
  {
    if (-10L == getItemId(paramInt))
    {
      n localn = ViberApplication.getInstance().getMessagesManager().r().d();
      if (localn != null)
        this.l = localn;
      if ((this.a == null) || (this.a.j() != this.l))
        this.a = new b(this.l);
      return this.a;
    }
    return a(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return this.c.a(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    if (-10L == getItemId(paramInt))
      return a.c.ordinal();
    if (((com.viber.voip.messages.adapters.a.c)getItem(paramInt)).m())
      return a.b.ordinal();
    return a.a.ordinal();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.d == null)
      this.d = e.a(ViberApplication.getApplication());
    a locala = a.values()[getItemViewType(paramInt)];
    if ((paramView == null) || (paramView.getTag() == null))
      paramView = a(locala, paramViewGroup);
    Object localObject = paramView.getTag();
    switch (1.a[locala.ordinal()])
    {
    default:
    case 1:
    }
    for (d locald = ((com.viber.voip.ui.g.a)localObject).a(); ; locald = (d)localObject)
    {
      locald.a((com.viber.voip.messages.adapters.a.a)getItem(paramInt), this.e);
      return paramView;
    }
  }

  public int getViewTypeCount()
  {
    return a.values().length;
  }

  public boolean isEnabled(int paramInt)
  {
    return (-10L != getItemId(paramInt)) || ((!this.j.v()) && (!this.e.y()));
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.w
 * JD-Core Version:    0.6.2
 */
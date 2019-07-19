package com.viber.voip.messages.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.adapters.g;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.j;
import com.viber.voip.messages.k;
import com.viber.voip.ui.g.d;
import com.viber.voip.util.e.e;

public class f extends BaseAdapter
{
  private final LayoutInflater a;
  private final n<RegularConversationLoaderEntity> b;
  private final e c;
  private final b d;
  private final ai e;
  private final j f;
  private final MessagesFragmentModeManager g;
  private final com.viber.voip.stickers.i h;
  private final dagger.a<k> i;
  private final com.viber.voip.messages.adapters.a.c.a j;
  private long k;

  public f(Context paramContext, n<RegularConversationLoaderEntity> paramn, e parame, b paramb, ai paramai, j paramj, dagger.a<k> parama, MessagesFragmentModeManager paramMessagesFragmentModeManager, com.viber.voip.stickers.i parami, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = paramn;
    this.c = parame;
    this.d = paramb;
    this.e = paramai;
    this.f = paramj;
    this.i = parama;
    this.g = paramMessagesFragmentModeManager;
    this.h = parami;
    this.j = new com.viber.voip.messages.adapters.a.c.a(paramContext, paramMessagesFragmentModeManager, false, ViberApplication.isTablet(paramContext), true);
  }

  private View a(ViewGroup paramViewGroup)
  {
    View localView = this.a.inflate(R.layout.fragment_messages_list_item, null);
    localView.setTag(new com.viber.voip.messages.adapters.a.a.i(this.f, this.e, this.c, this.d).a(localView, 0, paramViewGroup));
    return localView;
  }

  public g a(int paramInt)
  {
    RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)this.b.e(paramInt);
    if (localRegularConversationLoaderEntity == null)
      throw new IllegalArgumentException("RegularConversationLoaderEntity can't be null!");
    boolean bool1 = this.g.b(Long.valueOf(localRegularConversationLoaderEntity.getId()));
    if (localRegularConversationLoaderEntity.getId() == this.k);
    for (boolean bool2 = true; ; bool2 = false)
      return new g(localRegularConversationLoaderEntity, bool1, bool2);
  }

  public void a(long paramLong)
  {
    this.k = paramLong;
  }

  public int getCount()
  {
    return this.b.getCount();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof com.viber.voip.ui.g.a)))
      paramView = a(paramViewGroup);
    ((com.viber.voip.ui.g.a)paramView.getTag()).a().a(a(paramInt), this.j);
    return paramView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.f
 * JD-Core Version:    0.6.2
 */
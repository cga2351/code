package com.viber.voip.engagement.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import java.util.Collections;
import java.util.List;

class i extends BaseAdapter
{
  private final LayoutInflater a;
  private final e b;
  private final m c;
  private final com.viber.voip.messages.adapters.a.c.a d;
  private final g e;
  private List<RegularConversationLoaderEntity> f = Collections.emptyList();
  private int g;

  i(Context paramContext, g paramg, m paramm, boolean paramBoolean, int paramInt, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = e.a(paramContext);
    this.c = paramm;
    this.d = new com.viber.voip.messages.adapters.a.c.a(paramContext, null, false, paramBoolean, false);
    this.e = paramg;
    this.g = paramInt;
  }

  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      View localView = this.a.inflate(R.layout.list_item_suggested_contact_with_header, paramViewGroup, false);
      dj.b(localView.findViewById(R.id.top_divider), false);
      ((TextView)localView.findViewById(R.id.label)).setText(this.g);
      return localView;
    }
    return this.a.inflate(R.layout.list_item_engagement_contact, paramViewGroup, false);
  }

  private void a(View paramView, RegularConversationLoaderEntity paramRegularConversationLoaderEntity, boolean paramBoolean)
  {
    j localj = (j)paramView.getTag();
    if (localj == null)
    {
      localj = new j(paramView, this.b, this.e, this.d);
      paramView.setTag(localj);
    }
    localj.a(paramRegularConversationLoaderEntity, paramBoolean);
    this.c.a(localj, SendButtonReceiverId.createFromConversationId(paramRegularConversationLoaderEntity.getId()));
  }

  public com.viber.voip.messages.adapters.a.a a(int paramInt)
  {
    RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)this.f.get(paramInt);
    if (localRegularConversationLoaderEntity != null)
      return new com.viber.voip.messages.adapters.g(localRegularConversationLoaderEntity, false, false);
    return null;
  }

  public void a(List<RegularConversationLoaderEntity> paramList)
  {
    this.f = paramList;
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.f.size();
  }

  public long getItemId(int paramInt)
  {
    return ((RegularConversationLoaderEntity)this.f.get(paramInt)).getId();
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
      return 1;
    return 0;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)this.f.get(paramInt);
    if (paramView != null)
      if (paramInt != -1 + getCount())
        break label57;
    label57: for (boolean bool = true; ; bool = false)
    {
      a(paramView, localRegularConversationLoaderEntity, bool);
      return paramView;
      paramView = a(paramViewGroup, getItemViewType(paramInt));
      break;
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.i
 * JD-Core Version:    0.6.2
 */
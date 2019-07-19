package com.viber.voip.engagement.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.contacts.adapters.f;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.model.c;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class n extends com.viber.voip.contacts.adapters.g
  implements g
{
  private final g j;
  private final a k = (a)this.a;
  private final m l;

  public n(Context paramContext, m paramm, g paramg, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, false, new a(null), paramLayoutInflater);
    this.j = paramg;
    this.l = paramm;
  }

  protected f a(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    return new d(paramContext, paramLayoutInflater, this, true);
  }

  protected void a(int paramInt, View paramView, c paramc)
  {
    super.a(paramInt, paramView, paramc);
    b localb = (b)paramView.getTag();
    if (paramInt == -1 + getCount());
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localb.n, bool);
      this.l.a(localb, SendButtonReceiverId.createFromContactId(paramc.getId()));
      return;
    }
  }

  public void a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
  }

  public void a(c paramc, boolean paramBoolean)
  {
    this.j.a(paramc, paramBoolean);
  }

  public void a(List<com.viber.voip.model.a> paramList)
  {
    notifyDataSetInvalidated();
    this.k.a(paramList);
    notifyDataSetChanged();
  }

  protected View d(int paramInt)
  {
    View localView = super.d(paramInt);
    if (paramInt == 1)
    {
      dj.b(localView.findViewById(R.id.top_divider), false);
      ((b)localView.getTag()).h.setText(R.string.title_suggested_contact);
    }
    return localView;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
      return 1;
    return super.getItemViewType(paramInt);
  }

  private static final class a
    implements com.viber.voip.contacts.a
  {
    private List<com.viber.voip.model.a> a = Collections.emptyList();

    public long a(int paramInt)
    {
      return ((com.viber.voip.model.a)this.a.get(paramInt)).getId();
    }

    public String a()
    {
      return "";
    }

    public void a(List<com.viber.voip.model.a> paramList)
    {
      this.a = new ArrayList(paramList);
    }

    public c c(int paramInt)
    {
      return (c)this.a.get(paramInt);
    }

    public int getCount()
    {
      return this.a.size();
    }

    public boolean x_()
    {
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.n
 * JD-Core Version:    0.6.2
 */
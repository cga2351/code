package com.viber.voip.messages.conversation.adapter.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.adapter.k.b;
import com.viber.voip.messages.conversation.adapter.k.b.a;
import com.viber.voip.messages.conversation.ui.at;

public class a
  implements k.b
{
  private final k a;
  private View b;
  private int c = 0;

  public a(k paramk)
  {
    this.a = paramk;
  }

  public View a()
  {
    return this.b;
  }

  public View a(ViewGroup paramViewGroup, View paramView)
  {
    if (paramView == null)
    {
      this.b = new View(paramViewGroup.getContext());
      this.b.setLayoutParams(new AbsListView.LayoutParams(-1, this.c));
    }
    while (true)
    {
      return this.b;
      this.b = paramView;
    }
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
    this.a.a(this);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat)
  {
    if ((this.b.getLayoutParams().height != this.c) && (this.c > 0))
    {
      this.b.getLayoutParams().height = this.c;
      this.b.requestLayout();
    }
  }

  public void a(boolean paramBoolean)
  {
    this.a.a(this, paramBoolean);
  }

  public k.b.a b()
  {
    return k.b.a.a;
  }

  public void b(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      this.a.notifyDataSetChanged();
    }
  }

  public int c()
  {
    if (this.c > 0)
      return this.c;
    return -1;
  }

  public int d()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.a.a
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.Space;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.viber.voip.R.dimen;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.at;

public class u
  implements k.b
{
  private View a;

  private int a(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(R.dimen.list_bottom_padding);
  }

  public View a()
  {
    return this.a;
  }

  public View a(ViewGroup paramViewGroup, View paramView)
  {
    if (this.a != null)
      return this.a;
    this.a = new Space(paramViewGroup.getContext());
    this.a.setLayoutParams(new AbsListView.LayoutParams(0, a(paramViewGroup.getContext())));
    return this.a;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat)
  {
  }

  public k.b.a b()
  {
    return k.b.a.b;
  }

  public int c()
  {
    return l.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.u
 * JD-Core Version:    0.6.2
 */
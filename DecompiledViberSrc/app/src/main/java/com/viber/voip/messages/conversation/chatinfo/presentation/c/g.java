package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.viber.voip.messages.conversation.chatinfo.d.d;
import com.viber.voip.messages.conversation.chatinfo.e.e;

public abstract class g<Item extends d> extends RecyclerView.ViewHolder
{
  public g(View paramView)
  {
    super(paramView);
  }

  public abstract void a(Item paramItem, e parame);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.g
 * JD-Core Version:    0.6.2
 */
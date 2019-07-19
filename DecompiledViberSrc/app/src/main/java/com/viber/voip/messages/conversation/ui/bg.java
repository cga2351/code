package com.viber.voip.messages.conversation.ui;

import android.widget.AbsListView;
import com.viber.voip.ConversationListView;

public class bg extends bt
{
  private final ConversationListView a;
  private final j b;
  private boolean c = false;
  private int d = -1;

  bg(ConversationListView paramConversationListView, j paramj)
  {
    this.a = paramConversationListView;
    this.b = paramj;
  }

  public boolean a()
  {
    return this.c;
  }

  public boolean b()
  {
    return this.a.b();
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.d != paramInt)
    {
      this.d = paramInt;
      if (paramInt != 0)
      {
        this.b.a();
        this.c = true;
      }
    }
    else
    {
      return;
    }
    this.c = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bg
 * JD-Core Version:    0.6.2
 */
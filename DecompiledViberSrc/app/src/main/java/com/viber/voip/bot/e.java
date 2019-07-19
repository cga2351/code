package com.viber.voip.bot;

import android.support.v7.widget.RecyclerView;
import com.viber.voip.messages.conversation.ui.ba;

public class e
{
  private final ba a;

  public e(ba paramba)
  {
    this.a = paramba;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, RecyclerView paramRecyclerView)
  {
    if ((paramInt1 == 0) || ((paramInt2 == 0) && (paramInt3 == paramInt1 - 1)))
    {
      this.a.removeConversationIgnoredView(paramRecyclerView);
      return;
    }
    this.a.addConversationIgnoredView(paramRecyclerView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.e
 * JD-Core Version:    0.6.2
 */
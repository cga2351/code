package com.viber.voip.messages.adapters.a.b;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.adapters.a.c;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class n<T extends com.viber.voip.messages.adapters.a.a> extends e<T, com.viber.voip.messages.adapters.a.c.a>
{
  private final TextView a;

  public n(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  private void a(com.viber.voip.messages.adapters.a.c.a parama, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    int i = parama.a(paramConversationLoaderEntity.isCommunityType(), paramConversationLoaderEntity.isMuteConversation(), paramConversationLoaderEntity.isSnoozedConversation());
    int j = this.a.getPaddingLeft();
    int k = this.a.getPaddingTop();
    int m = this.a.getPaddingRight();
    int n = this.a.getPaddingBottom();
    this.a.setBackground(parama.m());
    this.a.setPadding(j, k, m, n);
    this.a.getBackground().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
  }

  public void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama)
  {
    super.a(paramT, parama);
    ConversationLoaderEntity localConversationLoaderEntity = paramT.a();
    boolean bool1 = localConversationLoaderEntity.isMarkedAsUnreadConversation();
    int i = localConversationLoaderEntity.getMessageStatus();
    boolean bool2 = localConversationLoaderEntity.hasMessages();
    boolean bool3 = parama.a(paramT.i());
    int j;
    int k;
    if ((paramT.k()) && (!bool3))
    {
      j = 1;
      if (((paramT instanceof c)) && (!((c)paramT).m()))
        break label137;
      k = 1;
    }
    while (true)
      if ((bool1) || ((j != 0) && (k != 0)))
      {
        dj.b(this.a, true);
        if (bool1)
        {
          this.a.setText("");
          this.a.setBackground(parama.n());
          return;
          j = 0;
          break;
          label137: k = 0;
          continue;
        }
        String str = paramT.a(paramT.l());
        a(parama, localConversationLoaderEntity);
        this.a.setText(str);
        return;
      }
    if ((i <= -1) && (bool2))
    {
      dj.b(this.a, true);
      this.a.setText(null);
      this.a.setBackgroundResource(R.drawable.ic_warning_medium);
      return;
    }
    dj.b(this.a, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.n
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.adapters.a.b;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity.a;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class x extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private TextView a;
  private View b;

  public x(View paramView, TextView paramTextView)
  {
    this.b = paramView;
    this.a = paramTextView;
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    ConversationLoaderEntity.a locala = parama.a().getSearchSection();
    if (ConversationLoaderEntity.a.a == locala)
    {
      dj.c(this.b, 8);
      return;
    }
    dj.c(this.b, 0);
    this.a.setText(locala.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.x
 * JD-Core Version:    0.6.2
 */
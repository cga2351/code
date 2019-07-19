package com.viber.voip.messages.adapters.a.b;

import android.content.Context;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class i<T extends com.viber.voip.messages.adapters.a.a> extends e<T, com.viber.voip.messages.adapters.a.c.a>
{
  private final Context a;
  private final TextView b;
  private int c;
  private int d;

  public i(Context paramContext, TextView paramTextView)
  {
    this.a = paramContext;
    this.b = paramTextView;
    this.c = dc.d(this.a, R.attr.textTimeMessageItemAlternativeColor);
    this.d = dc.d(this.a, R.attr.textTimeMessageItemColor);
  }

  public void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama)
  {
    super.a(paramT, parama);
    ConversationLoaderEntity localConversationLoaderEntity = paramT.a();
    boolean bool1 = localConversationLoaderEntity.isMarkedAsUnreadConversation();
    boolean bool2 = paramT.k();
    boolean bool3 = parama.a(paramT.i());
    boolean bool4;
    TextView localTextView;
    if ((!localConversationLoaderEntity.isMissedCall()) || (localConversationLoaderEntity.hasMessageDraft()))
    {
      bool4 = true;
      dj.c(this.b, bool4);
      localTextView = this.b;
      if ((!bool1) && ((!bool2) || (bool3)))
        break label121;
    }
    label121: for (int i = this.c; ; i = this.d)
    {
      localTextView.setTextColor(i);
      this.b.setText(localConversationLoaderEntity.getFormatedData(parama.v()));
      return;
      bool4 = false;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.i
 * JD-Core Version:    0.6.2
 */
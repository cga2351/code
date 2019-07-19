package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.adapter.k.b;
import com.viber.voip.messages.conversation.adapter.k.b.a;
import com.viber.voip.messages.conversation.adapter.l;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class bi
{
  private static final Logger a = ViberEnv.getLogger();
  private final k b;
  private k.b c;

  public bi(k paramk)
  {
    this.b = paramk;
  }

  public void a()
  {
    if (this.c == null)
      this.c = new a(null);
    this.b.c(this.c);
  }

  public void b()
  {
    if (this.c != null)
      this.b.b(this.c, true);
  }

  private static class a
    implements k.b
  {
    private View a;

    public View a()
    {
      return this.a;
    }

    public View a(ViewGroup paramViewGroup, View paramView)
    {
      if (paramView == null)
      {
        Context localContext = paramViewGroup.getContext();
        this.a = LayoutInflater.from(localContext).inflate(R.layout.loading_msgs_banner_layout, paramViewGroup, false);
        this.a.findViewById(R.id.loadingMessagesLabelView).setBackground(dj.a(dc.d(localContext, R.attr.conversationNotificationBackgroundColor)));
      }
      while (true)
      {
        return this.a;
        this.a = paramView;
      }
    }

    public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat)
    {
    }

    public k.b.a b()
    {
      return k.b.a.a;
    }

    public int c()
    {
      return l.a(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bi
 * JD-Core Version:    0.6.2
 */
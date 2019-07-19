package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.adapter.k.b;
import com.viber.voip.messages.conversation.adapter.k.b.a;
import com.viber.voip.messages.conversation.adapter.l;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.n;
import com.viber.voip.messages.conversation.ui.banner.n.a;
import com.viber.voip.registration.ao;
import com.viber.voip.util.ae;

public class bc
  implements n.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final ConversationAlertView c;
  private final ConversationFragment d;
  private final c e;
  private n f;
  private ConversationItemLoaderEntity g;
  private k.b h;

  public bc(ConversationFragment paramConversationFragment, ConversationAlertView paramConversationAlertView, c paramc)
  {
    this.d = paramConversationFragment;
    this.b = paramConversationFragment.getContext();
    this.c = paramConversationAlertView;
    this.e = paramc;
  }

  private void a(int paramInt, View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.addRule(2, paramInt);
    paramView.setLayoutParams(localLayoutParams);
  }

  private void a(k paramk)
  {
    if (this.h != null)
      paramk.b(this.h, false);
  }

  private k.b b()
  {
    return new k.b()
    {
      private View b;
      private TextView c;

      public View a()
      {
        return this.b;
      }

      public View a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
      {
        if (paramAnonymousView == null)
        {
          this.b = LayoutInflater.from(paramAnonymousViewGroup.getContext()).inflate(R.layout.engagement_banner_layout, paramAnonymousViewGroup, false);
          int i = paramAnonymousViewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.engagement_banner_left_right_padding);
          int j = paramAnonymousViewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.engagement_banner_top_padding);
          this.b.setPadding(i, 0, i, j);
        }
        while (true)
        {
          this.c = ((TextView)this.b.findViewById(R.id.description));
          return this.b;
          this.b = paramAnonymousView;
        }
      }

      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity, at paramAnonymousat)
      {
        Context localContext = this.c.getContext();
        int i;
        Object[] arrayOfObject;
        if (paramAnonymousConversationItemLoaderEntity.isEngagementConversation())
        {
          i = R.string.user_engagement_banner_text;
          arrayOfObject = new Object[1];
          arrayOfObject[0] = paramAnonymousConversationItemLoaderEntity.getParticipantName();
        }
        for (String str = localContext.getString(i, arrayOfObject); ; str = localContext.getString(R.string.tap_sticker_to_say_hi))
        {
          this.c.setText(str);
          return;
        }
      }

      public k.b.a b()
      {
        return k.b.a.b;
      }

      public int c()
      {
        return l.a(this);
      }
    };
  }

  private void c()
  {
    if (this.f != null)
      this.c.a(this.f.a(), false);
  }

  public void a()
  {
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, k paramk, View paramView, ConversationListView paramConversationListView)
  {
    if (ao.f())
      return;
    this.g = paramConversationItemLoaderEntity;
    if ((paramConversationItemLoaderEntity.isNewUserJoinedConversation()) && (paramConversationItemLoaderEntity.canSendMessages(0)) && (paramConversationItemLoaderEntity.getContactId() > 0L))
    {
      if (!paramConversationItemLoaderEntity.hasMessages())
      {
        if (this.f == null)
          this.f = new n(this.c, this, this.d.getLayoutInflater());
        if (!this.c.a())
          this.e.a(ae.b());
        this.c.a(this.f, false);
        a(paramk);
        this.f.a(paramConversationItemLoaderEntity);
        a(R.id.message_composer, paramView);
        return;
      }
      if (this.h == null)
        this.h = b();
      paramk.c(this.h);
      c();
      a(R.id.compose_bar_top_banners_container, paramView);
      paramConversationListView.a(false);
      return;
    }
    c();
    a(paramk);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bc
 * JD-Core Version:    0.6.2
 */
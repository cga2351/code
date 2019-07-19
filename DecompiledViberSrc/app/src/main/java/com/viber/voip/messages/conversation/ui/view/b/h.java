package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.view.View;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.ui.ConversationBannerView;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.conversation.ui.az;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.presenter.theme.ConversationThemePresenter;
import com.viber.voip.messages.conversation.ui.view.f;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.x;

public class h extends a<ConversationThemePresenter>
  implements f
{
  private final MessageComposerView a;
  private final x b;
  private final ConversationAlertView g;
  private final k h;
  private final az i;
  private final ConversationBannerView j;

  public h(ConversationThemePresenter paramConversationThemePresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, MessageComposerView paramMessageComposerView, x paramx, ConversationAlertView paramConversationAlertView, k paramk, az paramaz, ConversationBannerView paramConversationBannerView)
  {
    super(paramConversationThemePresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.a = paramMessageComposerView;
    this.b = paramx;
    this.g = paramConversationAlertView;
    this.h = paramk;
    this.i = paramaz;
    this.j = paramConversationBannerView;
  }

  public void a(at paramat)
  {
    this.a.a(paramat);
    this.b.a(paramat);
    this.g.a(paramat);
    this.h.a(paramat);
    this.i.a(paramat);
    this.j.a(paramat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.h
 * JD-Core Version:    0.6.2
 */
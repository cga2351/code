package com.viber.voip.messages.conversation.community.c;

import android.app.Activity;
import android.view.View;
import com.viber.common.dialogs.m;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.presenter.DeleteConversationRelatedActionsPresenter;
import com.viber.voip.messages.conversation.ui.view.b.a;
import com.viber.voip.messages.conversation.ui.view.b.i;
import com.viber.voip.messages.conversation.ui.view.g;

public class d extends a<DeleteConversationRelatedActionsPresenter>
  implements g
{
  private final i a;

  public d(DeleteConversationRelatedActionsPresenter paramDeleteConversationRelatedActionsPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean)
  {
    super(paramDeleteConversationRelatedActionsPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.a = new i(paramDeleteConversationRelatedActionsPresenter, paramConversationFragment, paramView);
  }

  public void a()
  {
    this.a.a();
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a(paramBoolean1, paramBoolean2);
  }

  public void b()
  {
    this.a.b();
  }

  public void c()
  {
    this.a.c();
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    return this.a.onDialogAction(paramm, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.c.d
 * JD-Core Version:    0.6.2
 */
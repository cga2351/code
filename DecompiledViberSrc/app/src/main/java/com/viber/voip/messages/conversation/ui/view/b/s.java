package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.view.View;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.z;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.presenter.input.PublicGroupInputFieldPresenter;
import com.viber.voip.messages.conversation.ui.view.l;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.ui.dialogs.DialogCode;

public class s extends n<PublicGroupInputFieldPresenter>
  implements l
{
  protected final DialogCode a;
  protected final a.a b;

  public s(PublicGroupInputFieldPresenter paramPublicGroupInputFieldPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, MessageComposerView paramMessageComposerView, ai paramai, DialogCode paramDialogCode, a.a parama)
  {
    super(paramPublicGroupInputFieldPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean, paramMessageComposerView, paramai);
    this.a = paramDialogCode;
    this.b = parama;
  }

  public void m()
  {
    if ((this.b != null) && (z.c(this.d.getFragmentManager(), this.a) == null))
      this.b.a(this.d).b(this.d);
  }

  public void onResume()
  {
    if (this.d.isVisible())
      ((PublicGroupInputFieldPresenter)this.mPresenter).o();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.s
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation.ui.view.b;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;
import com.viber.common.dialogs.DialogCodeProvider;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ui.presenter.DeleteConversationRelatedActionsPresenter;
import com.viber.voip.messages.conversation.ui.view.g;
import com.viber.voip.mvp.core.d;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.k;

public class i extends d<DeleteConversationRelatedActionsPresenter>
  implements g
{
  private Fragment a;

  public i(DeleteConversationRelatedActionsPresenter paramDeleteConversationRelatedActionsPresenter, Fragment paramFragment, View paramView)
  {
    super(paramDeleteConversationRelatedActionsPresenter, paramView);
    this.a = paramFragment;
  }

  public void a()
  {
    Toast.makeText(this.a.requireContext().getApplicationContext(), R.string.snooze_community_pref_body, 1).show();
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      k.j().a(this.a).b(this.a);
      return;
    }
    if (paramBoolean2)
    {
      k.l().a(this.a).b(this.a);
      return;
    }
    k.h().a(this.a).b(this.a);
  }

  public void b()
  {
    Toast.makeText(this.a.requireContext().getApplicationContext(), R.string.conversation_muted_toast, 1).show();
  }

  public void c()
  {
    k.d().a(this.a).b(this.a);
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    String str = paramm.c().code();
    if ((paramm.a(DialogCode.D330)) || (paramm.a(DialogCode.D343e)) || (paramm.a(DialogCode.D343c)))
    {
      if (-1 == paramInt)
      {
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).c();
        if (paramm.a(DialogCode.D343c))
          ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(str, "Leave and Delete");
      }
      while (true)
      {
        return true;
        if (((-2 == paramInt) || (-1000 == paramInt)) && (paramm.a(DialogCode.D343c)))
          ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(str, "Cancel");
      }
    }
    if (paramm.a(DialogCode.D343))
    {
      switch (paramInt)
      {
      default:
      case -1000:
      case -2:
      case -3:
      case -1:
      }
      while (true)
      {
        return true;
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(str, "Cancel");
        continue;
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).b(true);
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(str, "Mute");
        continue;
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).c();
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(str, "Leave and Delete");
      }
    }
    if (paramm.a(DialogCode.D343f))
    {
      switch (paramInt)
      {
      default:
      case -1:
      case -3:
      case -1000:
      case -2:
      }
      while (true)
      {
        return true;
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(true);
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(str, "Snooze");
        continue;
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).b();
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(str, "Leave and Delete");
        continue;
        ((DeleteConversationRelatedActionsPresenter)this.mPresenter).a(str, "Cancel");
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.i
 * JD-Core Version:    0.6.2
 */
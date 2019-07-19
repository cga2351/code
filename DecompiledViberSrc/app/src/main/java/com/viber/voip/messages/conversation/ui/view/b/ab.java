package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.m;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.presenter.TranslateMessagePresenter;
import com.viber.voip.messages.conversation.ui.view.q;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.util.dd;

public class ab extends a<TranslateMessagePresenter>
  implements q
{
  ConversationAlertView a;

  public ab(TranslateMessagePresenter paramTranslateMessagePresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, ConversationAlertView paramConversationAlertView)
  {
    super(paramTranslateMessagePresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.a = paramConversationAlertView;
  }

  public void a(long paramLong)
  {
    p.a(paramLong).a(this.d).b(this.d);
  }

  public void a(boolean paramBoolean)
  {
    dd.a(new ac(this, paramBoolean));
  }

  public boolean a()
  {
    return this.a.a();
  }

  public void b()
  {
    p.h().b(this.d);
  }

  public void c()
  {
    this.a.a(ConversationAlertView.a.l, null, false);
  }

  public void d()
  {
    dd.a(new ad(this));
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (107 == paramInt1)
    {
      if (paramInt2 == -1)
      {
        String str = paramIntent.getStringExtra("selected_lang");
        ((TranslateMessagePresenter)this.mPresenter).a(str);
        long l = paramIntent.getLongExtra("selected_msg", -1L);
        if (l > -1L)
          ((TranslateMessagePresenter)this.mPresenter).d(l);
      }
      return true;
    }
    return false;
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D3911))
    {
      ((TranslateMessagePresenter)this.mPresenter).a(((Long)paramm.d()).longValue(), paramInt);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.ab
 * JD-Core Version:    0.6.2
 */
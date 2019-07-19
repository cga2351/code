package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.view.View;
import com.viber.voip.ConversationListView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.d;

public abstract class a<PRESENTER extends BaseMvpPresenter> extends d<PRESENTER>
{
  protected Activity c;
  protected ConversationFragment d;
  protected ConversationListView e;
  protected final boolean f;

  protected a(PRESENTER paramPRESENTER, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean)
  {
    super(paramPRESENTER, paramView);
    this.c = paramActivity;
    this.d = paramConversationFragment;
    this.f = paramBoolean;
    t();
  }

  private void t()
  {
    this.e = ((ConversationListView)this.mRootView.findViewById(R.id.conversation_list));
  }

  public void L_()
  {
  }

  public void a(int paramInt, aa paramaa)
  {
  }

  public void d_(boolean paramBoolean)
  {
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.c = null;
    this.d = null;
    this.mRootView = null;
  }

  public final boolean r()
  {
    return this.f;
  }

  public void s()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.a
 * JD-Core Version:    0.6.2
 */
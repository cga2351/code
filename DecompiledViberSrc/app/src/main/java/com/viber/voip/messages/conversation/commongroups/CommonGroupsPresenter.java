package com.viber.voip.messages.conversation.commongroups;

import android.arch.lifecycle.h;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;

public class CommonGroupsPresenter extends BaseMvpPresenter<g, State>
  implements i.a
{
  private final i a;

  public CommonGroupsPresenter(i parami)
  {
    this.a = parami;
  }

  public void a(f paramf)
  {
    ConversationData localConversationData = new ConversationData(paramf.a(), paramf.b(), "", "", 1, "", "", paramf.c(), paramf.f(), false, false, false, false);
    ((g)this.mView).a(localConversationData);
  }

  public void a(boolean paramBoolean)
  {
    ((g)this.mView).a();
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.a.a();
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.a.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.commongroups.CommonGroupsPresenter
 * JD-Core Version:    0.6.2
 */
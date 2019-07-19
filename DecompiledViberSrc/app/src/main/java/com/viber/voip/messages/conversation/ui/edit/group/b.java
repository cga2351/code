package com.viber.voip.messages.conversation.ui.edit.group;

import android.app.Activity;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;

class b
{
  private static final Logger a = ViberEnv.getLogger();
  private final Activity b;
  private final g c;

  public b(Activity paramActivity, g paramg)
  {
    this.b = paramActivity;
    this.c = paramg;
  }

  public void a()
  {
    if (!this.b.isFinishing())
      this.b.finish();
  }

  public void a(AddGroupDetailsPresenter.AddDetailsGoNextAction paramAddDetailsGoNextAction, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (paramAddDetailsGoNextAction != null)
      paramAddDetailsGoNextAction.goNext(this.b, this.c, paramConversationItemLoaderEntity.getGroupName(), paramConversationItemLoaderEntity.getIconUri(), null);
    if (!this.b.isFinishing())
      this.b.finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.edit.group.b
 * JD-Core Version:    0.6.2
 */
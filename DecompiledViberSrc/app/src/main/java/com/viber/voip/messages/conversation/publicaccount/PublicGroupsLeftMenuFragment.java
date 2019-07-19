package com.viber.voip.messages.conversation.publicaccount;

import android.os.Bundle;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;

public class PublicGroupsLeftMenuFragment extends PublicGroupsFragment
{
  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramConversationItemLoaderEntity != null))
    {
      if (!c())
        k();
      a(this, paramConversationItemLoaderEntity, paramBoolean);
    }
  }

  protected void h()
  {
  }

  protected boolean j()
  {
    return false;
  }

  protected void o()
  {
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getView().findViewById(R.id.emptyProgress).setVisibility(8);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.PublicGroupsLeftMenuFragment
 * JD-Core Version:    0.6.2
 */
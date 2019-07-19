package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.adapters.u;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.ui.ViberListView;
import org.greenrobot.eventbus.EventBus;

public class BusinessInboxMessagesLeftMenuFragment extends j
{
  protected Intent a(int paramInt, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    return super.a(0, paramConversationLoaderEntity);
  }

  protected u a(Context paramContext, com.viber.provider.c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, LayoutInflater paramLayoutInflater, e parame)
  {
    return new a(paramContext, paramc, paramMessagesFragmentModeManager, paramBoolean1, paramBoolean2, paramLayoutInflater, parame);
  }

  protected n a(Bundle paramBundle, String paramString)
  {
    return new com.viber.voip.services.inbox.screen.c(getActivity(), getLoaderManager(), this.j, paramBundle, this, EventBus.getDefault());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.n.a(this);
    return localView;
  }

  private static class a extends u
  {
    public a(Context paramContext, com.viber.provider.c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, LayoutInflater paramLayoutInflater, e parame)
    {
      super(paramc, paramMessagesFragmentModeManager, null, paramBoolean1, paramBoolean2, paramLayoutInflater, parame);
    }

    protected boolean a(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
    {
      return false;
    }

    protected boolean c()
    {
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.BusinessInboxMessagesLeftMenuFragment
 * JD-Core Version:    0.6.2
 */
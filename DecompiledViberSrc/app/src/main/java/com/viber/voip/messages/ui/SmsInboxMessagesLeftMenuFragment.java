package com.viber.voip.messages.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.adapters.u;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.n;
import org.greenrobot.eventbus.EventBus;

public class SmsInboxMessagesLeftMenuFragment extends j
{
  private b F = cu.a;

  protected Intent a(int paramInt, ConversationLoaderEntity paramConversationLoaderEntity)
  {
    return super.a(0, paramConversationLoaderEntity);
  }

  protected u a(Context paramContext, com.viber.provider.c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, LayoutInflater paramLayoutInflater, e parame)
  {
    return new a(paramContext, paramc, paramMessagesFragmentModeManager, paramBoolean1, paramBoolean2, getLayoutInflater(), parame);
  }

  protected n a(Bundle paramBundle, String paramString)
  {
    return new com.viber.voip.vln.ui.c(getActivity(), getLoaderManager(), this.j, paramBundle, this, EventBus.getDefault(), this.F.h());
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof b))
      this.F = ((b)paramActivity);
  }

  private static class a extends u
  {
    public a(Context paramContext, com.viber.provider.c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, LayoutInflater paramLayoutInflater, e parame)
    {
      super(paramc, paramMessagesFragmentModeManager, null, paramBoolean1, paramBoolean2, paramLayoutInflater, parame);
    }

    protected boolean b(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
    {
      return false;
    }

    protected boolean c()
    {
      return true;
    }
  }

  public static abstract interface b
  {
    public abstract String h();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.SmsInboxMessagesLeftMenuFragment
 * JD-Core Version:    0.6.2
 */
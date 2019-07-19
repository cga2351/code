package com.viber.voip.messages.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import com.viber.provider.c;
import com.viber.voip.messages.adapters.a.e;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.a.h;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import javax.inject.Inject;

public class MessagesLeftMenuFragment extends j
{

  @Inject
  dagger.a<h> F;

  protected com.viber.voip.messages.adapters.u a(Context paramContext, c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, LayoutInflater paramLayoutInflater, e parame)
  {
    return new a(paramContext, paramc, paramMessagesFragmentModeManager, paramBoolean1, paramBoolean2, this.s, paramLayoutInflater, parame);
  }

  protected n a(Bundle paramBundle, String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    LoaderManager localLoaderManager = getLoaderManager();
    dagger.a locala = this.j;
    boolean bool;
    if (!this.f)
    {
      bool = true;
      if (!this.g)
        break label85;
    }
    label85: for (n.a locala1 = n.a.b; ; locala1 = n.a.a)
    {
      return new com.viber.voip.messages.conversation.u(localFragmentActivity, localLoaderManager, locala, true, bool, locala1, paramBundle, paramString, this, com.viber.voip.h.a.b(), (h)this.F.get(), this.s);
      bool = false;
      break;
    }
  }

  private static class a extends com.viber.voip.messages.adapters.u
  {
    public a(Context paramContext, c<ConversationLoaderEntity> paramc, MessagesFragmentModeManager paramMessagesFragmentModeManager, boolean paramBoolean1, boolean paramBoolean2, dagger.a<ConferenceCallsRepository> parama, LayoutInflater paramLayoutInflater, e parame)
    {
      super(paramc, paramMessagesFragmentModeManager, parama, paramBoolean1, paramBoolean2, paramLayoutInflater, parame);
    }

    protected boolean b()
    {
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.MessagesLeftMenuFragment
 * JD-Core Version:    0.6.2
 */
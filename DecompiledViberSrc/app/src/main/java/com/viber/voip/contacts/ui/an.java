package com.viber.voip.contacts.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ai;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.messages.ui.bk;
import com.viber.voip.ui.k;
import com.viber.voip.ui.x;

public class an extends bk
{
  protected n a(Bundle paramBundle, String paramString)
  {
    this.q = true;
    FragmentActivity localFragmentActivity = getActivity();
    LoaderManager localLoaderManager = getLoaderManager();
    dagger.a locala = this.j;
    boolean bool1;
    ai localai;
    Bundle localBundle;
    boolean bool2;
    if (!this.f)
    {
      bool1 = true;
      localai = new ai(localFragmentActivity, localLoaderManager, locala, true, bool1, n.a.c, paramBundle, paramString, this, com.viber.voip.h.a.b());
      localai.c(false);
      localai.h(true);
      localai.e(true);
      localai.f(true);
      localBundle = getArguments();
      if ((localBundle == null) || (!localBundle.getBoolean("show_secret_chats_extra", true)))
        break label206;
      bool2 = true;
      label107: localai.l(bool2);
      if ((localBundle == null) || (!localBundle.getBoolean("show_middle_state_communities_extra", true)))
        break label212;
    }
    label206: label212: for (boolean bool3 = true; ; bool3 = false)
    {
      localai.m(bool3);
      localai.j(localBundle.getBoolean("show_public_groups_extra", false));
      localai.k(localBundle.getBoolean("enable_communities_extra", true));
      localai.p(localBundle.getBoolean("show_writable_conversations_only", false));
      localai.a(localBundle.getIntArray("group_roles"));
      localai.e(false);
      return localai;
      bool1 = false;
      break;
      bool2 = false;
      break label107;
    }
  }

  protected String a(Context paramContext)
  {
    return paramContext.getResources().getString(R.string.search_groups);
  }

  protected x b()
  {
    return new k(1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.an
 * JD-Core Version:    0.6.2
 */
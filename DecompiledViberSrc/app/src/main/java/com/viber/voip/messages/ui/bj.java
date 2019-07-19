package com.viber.voip.messages.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import com.viber.voip.messages.conversation.ai;
import com.viber.voip.messages.conversation.n;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.ui.k;
import com.viber.voip.ui.x;

public class bj extends bk
{
  protected n a(Bundle paramBundle, String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    LoaderManager localLoaderManager = getLoaderManager();
    dagger.a locala = this.j;
    boolean bool1;
    ai localai;
    int i;
    label69: boolean bool2;
    label89: boolean bool3;
    label110: boolean bool4;
    label131: boolean bool5;
    label152: boolean bool6;
    label173: boolean bool7;
    label194: boolean bool8;
    label215: boolean bool9;
    label236: boolean bool10;
    if (!this.f)
    {
      bool1 = true;
      localai = new ai(localFragmentActivity, localLoaderManager, locala, true, bool1, n.a.a, paramBundle, paramString, this, com.viber.voip.h.a.b());
      localai.h(true);
      if (getArguments() == null)
        break label363;
      i = 1;
      if ((i == 0) || (!getArguments().getBoolean("show_public_accounts_extra")))
        break label369;
      bool2 = true;
      if ((i == 0) || (!getArguments().getBoolean("show_secret_chats_extra", true)))
        break label375;
      bool3 = true;
      if ((i == 0) || (!getArguments().getBoolean("show_broadcast_list_extra", true)))
        break label381;
      bool4 = true;
      if ((i == 0) || (!getArguments().getBoolean("show_broadcast_list_w_p_extra", false)))
        break label387;
      bool5 = true;
      if ((i == 0) || (!getArguments().getBoolean("show_public_groups_extra", false)))
        break label393;
      bool6 = true;
      if ((i == 0) || (!getArguments().getBoolean("enable_communities_extra", true)))
        break label399;
      bool7 = true;
      if ((i == 0) || (!getArguments().getBoolean("show_writable_conversations_only", false)))
        break label405;
      bool8 = true;
      if ((i == 0) || (!getArguments().getBoolean("hide_sms_inbox_extra", false)))
        break label411;
      bool9 = true;
      if ((i == 0) || (!getArguments().getBoolean("show_middle_state_communities_extra", false)))
        break label417;
      bool10 = true;
      label257: if ((i == 0) || (!getArguments().getBoolean("hide_anonymous_extra", false)))
        break label423;
    }
    label387: label393: label399: label405: label411: label417: label423: for (boolean bool11 = true; ; bool11 = false)
    {
      localai.i(bool2);
      localai.l(bool3);
      localai.n(bool4);
      localai.o(bool5);
      localai.j(bool6);
      localai.k(bool7);
      localai.p(bool8);
      localai.r(bool9);
      localai.s(bool11);
      localai.m(bool10);
      localai.e(false);
      return localai;
      bool1 = false;
      break;
      label363: i = 0;
      break label69;
      label369: bool2 = false;
      break label89;
      label375: bool3 = false;
      break label110;
      label381: bool4 = false;
      break label131;
      bool5 = false;
      break label152;
      bool6 = false;
      break label173;
      bool7 = false;
      break label194;
      bool8 = false;
      break label215;
      bool9 = false;
      break label236;
      bool10 = false;
      break label257;
    }
  }

  protected x b()
  {
    return new k(0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bj
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.g.a.a.b;

import android.os.Bundle;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.conversation.commongroups.CommonGroupsPresenter;
import com.viber.voip.messages.conversation.commongroups.c;
import com.viber.voip.messages.conversation.commongroups.i;
import dagger.a;

public abstract class f
{
  static CommonGroupsPresenter a(i parami)
  {
    return new CommonGroupsPresenter(parami);
  }

  static i a(c paramc, a<bv> parama)
  {
    Bundle localBundle = paramc.getArguments();
    if (localBundle != null);
    for (String str = localBundle.getString("members_id", ""); ; str = "")
      return new i(paramc.requireContext(), paramc.getLoaderManager(), parama, str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.f
 * JD-Core Version:    0.6.2
 */
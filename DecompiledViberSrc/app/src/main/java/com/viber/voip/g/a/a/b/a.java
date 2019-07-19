package com.viber.voip.g.a.a.b;

import android.support.v4.app.FragmentActivity;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.extensions.ui.details.ChatExtensionDetailsPresenter;
import com.viber.voip.settings.d.n;

public abstract class a
{
  static ChatExtensionDetailsPresenter a(com.viber.voip.messages.extensions.b.b paramb, com.viber.voip.messages.extensions.c paramc, com.viber.voip.messages.extensions.a parama, com.viber.common.permission.c paramc1, d paramd, com.viber.voip.app.b paramb1, o paramo, com.viber.voip.analytics.story.c.c paramc2)
  {
    FragmentActivity localFragmentActivity = paramb.requireActivity();
    return new ChatExtensionDetailsPresenter(paramb.b(), new com.viber.voip.messages.controller.publicaccount.b(localFragmentActivity, paramc1, paramc), parama, paramd, new com.viber.voip.app.c(localFragmentActivity, paramb1), paramo, paramc2, d.n.l);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.a
 * JD-Core Version:    0.6.2
 */
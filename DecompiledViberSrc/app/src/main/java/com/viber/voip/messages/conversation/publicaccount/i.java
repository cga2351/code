package com.viber.voip.messages.conversation.publicaccount;

import android.support.v4.app.Fragment;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.controller.manager.k;
import dagger.b;

public final class i
  implements b<PublicChatsActivity>
{
  public static void a(PublicChatsActivity paramPublicChatsActivity, g paramg)
  {
    paramPublicChatsActivity.c = paramg;
  }

  public static void a(PublicChatsActivity paramPublicChatsActivity, com.viber.voip.analytics.story.e.c paramc)
  {
    paramPublicChatsActivity.d = paramc;
  }

  public static void a(PublicChatsActivity paramPublicChatsActivity, k paramk)
  {
    paramPublicChatsActivity.e = paramk;
  }

  public static void a(PublicChatsActivity paramPublicChatsActivity, dagger.android.c<Fragment> paramc)
  {
    paramPublicChatsActivity.f = paramc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.i
 * JD-Core Version:    0.6.2
 */
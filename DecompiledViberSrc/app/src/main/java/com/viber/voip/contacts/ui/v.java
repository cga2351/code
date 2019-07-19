package com.viber.voip.contacts.ui;

import com.viber.voip.analytics.story.e.c;
import dagger.a;
import dagger.b;

public final class v
  implements b<s>
{
  public static void a(s params, c paramc)
  {
    params.mMessagesTracker = paramc;
  }

  public static void a(s params, a<com.viber.voip.invitelinks.f> parama)
  {
    params.mCommunityFollowerInviteLinksHelper = parama;
  }

  public static void b(s params, a<com.viber.voip.invitelinks.linkscreen.f> parama)
  {
    params.mLinkActionsInteractor = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.v
 * JD-Core Version:    0.6.2
 */
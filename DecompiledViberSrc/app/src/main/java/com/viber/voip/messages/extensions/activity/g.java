package com.viber.voip.messages.extensions.activity;

import dagger.a;
import dagger.b;
import java.util.concurrent.ScheduledExecutorService;

public final class g
  implements b<ChatExInternalBrowserActivity>
{
  public static void a(ChatExInternalBrowserActivity paramChatExInternalBrowserActivity, com.viber.voip.messages.extensions.c paramc)
  {
    paramChatExInternalBrowserActivity.b = paramc;
  }

  public static void a(ChatExInternalBrowserActivity paramChatExInternalBrowserActivity, a<com.viber.voip.analytics.story.e.c> parama)
  {
    paramChatExInternalBrowserActivity.c = parama;
  }

  public static void a(ChatExInternalBrowserActivity paramChatExInternalBrowserActivity, ScheduledExecutorService paramScheduledExecutorService)
  {
    paramChatExInternalBrowserActivity.d = paramScheduledExecutorService;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.activity.g
 * JD-Core Version:    0.6.2
 */
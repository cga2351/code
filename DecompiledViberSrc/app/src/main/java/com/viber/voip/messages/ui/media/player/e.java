package com.viber.voip.messages.ui.media.player;

import dagger.a;
import dagger.b;
import java.util.concurrent.ScheduledExecutorService;

public final class e
  implements b<FullScreenVideoPlayerActivity>
{
  public static void a(FullScreenVideoPlayerActivity paramFullScreenVideoPlayerActivity, a<com.viber.voip.messages.extensions.c> parama)
  {
    paramFullScreenVideoPlayerActivity.b = parama;
  }

  public static void a(FullScreenVideoPlayerActivity paramFullScreenVideoPlayerActivity, ScheduledExecutorService paramScheduledExecutorService)
  {
    paramFullScreenVideoPlayerActivity.d = paramScheduledExecutorService;
  }

  public static void b(FullScreenVideoPlayerActivity paramFullScreenVideoPlayerActivity, a<com.viber.voip.analytics.story.e.c> parama)
  {
    paramFullScreenVideoPlayerActivity.c = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.e
 * JD-Core Version:    0.6.2
 */
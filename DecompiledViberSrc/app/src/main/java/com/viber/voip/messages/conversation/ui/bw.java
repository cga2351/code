package com.viber.voip.messages.conversation.ui;

import android.os.Handler;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.messages.k;
import com.viber.voip.user.UserManager;
import dagger.b;
import org.greenrobot.eventbus.EventBus;

public final class bw
  implements b<ShareScreenshotActivity>
{
  public static void a(ShareScreenshotActivity paramShareScreenshotActivity, Handler paramHandler)
  {
    paramShareScreenshotActivity.c = paramHandler;
  }

  public static void a(ShareScreenshotActivity paramShareScreenshotActivity, a parama)
  {
    paramShareScreenshotActivity.d = parama;
  }

  public static void a(ShareScreenshotActivity paramShareScreenshotActivity, k paramk)
  {
    paramShareScreenshotActivity.a = paramk;
  }

  public static void a(ShareScreenshotActivity paramShareScreenshotActivity, UserManager paramUserManager)
  {
    paramShareScreenshotActivity.b = paramUserManager;
  }

  public static void a(ShareScreenshotActivity paramShareScreenshotActivity, EventBus paramEventBus)
  {
    paramShareScreenshotActivity.e = paramEventBus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bw
 * JD-Core Version:    0.6.2
 */
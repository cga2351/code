package com.viber.voip.messages.ui;

import android.os.Handler;
import android.support.v4.app.Fragment;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.messages.controller.manager.k;
import com.viber.voip.messages.ui.media.player.d.e;
import dagger.b;

public final class s
  implements b<ConversationActivity>
{
  public static void a(ConversationActivity paramConversationActivity, Handler paramHandler)
  {
    paramConversationActivity.a = paramHandler;
  }

  public static void a(ConversationActivity paramConversationActivity, ICdrController paramICdrController)
  {
    paramConversationActivity.l = paramICdrController;
  }

  public static void a(ConversationActivity paramConversationActivity, k paramk)
  {
    paramConversationActivity.b = paramk;
  }

  public static void a(ConversationActivity paramConversationActivity, e parame)
  {
    paramConversationActivity.c = parame;
  }

  public static void a(ConversationActivity paramConversationActivity, dagger.a<com.viber.voip.analytics.story.e.c> parama)
  {
    paramConversationActivity.m = parama;
  }

  public static void a(ConversationActivity paramConversationActivity, dagger.android.c<Fragment> paramc)
  {
    paramConversationActivity.k = paramc;
  }

  public static void b(ConversationActivity paramConversationActivity, dagger.a<com.viber.voip.analytics.story.a.a> parama)
  {
    paramConversationActivity.n = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.s
 * JD-Core Version:    0.6.2
 */
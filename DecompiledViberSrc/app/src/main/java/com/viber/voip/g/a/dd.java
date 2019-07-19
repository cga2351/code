package com.viber.voip.g.a;

import android.content.Context;
import com.viber.jni.Engine;
import com.viber.voip.bk;
import com.viber.voip.vln.e;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

public abstract class dd
{
  @Singleton
  public static com.viber.voip.l.a a(Context paramContext, Engine paramEngine, EventBus paramEventBus, com.viber.voip.analytics.story.g.a parama, e parame)
  {
    return new com.viber.voip.l.a(bk.a(), paramContext, paramEngine, paramEventBus, parama, parame);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dd
 * JD-Core Version:    0.6.2
 */
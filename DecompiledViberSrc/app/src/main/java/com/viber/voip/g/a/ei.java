package com.viber.voip.g.a;

import android.content.Context;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.h;
import com.viber.voip.app.b;
import com.viber.voip.news.q;
import com.viber.voip.util.cv;
import dagger.a;
import javax.inject.Singleton;

public abstract class ei
{
  @Singleton
  static q a(Context paramContext, g paramg, b paramb, a<cv> parama, a<ICdrController> parama1)
  {
    q localq = new q(paramContext, paramg, paramb, parama, parama1);
    paramg.b().a(localq);
    return localq;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ei
 * JD-Core Version:    0.6.2
 */
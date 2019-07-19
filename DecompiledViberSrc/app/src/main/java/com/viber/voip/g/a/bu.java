package com.viber.voip.g.a;

import android.app.Application;
import com.squareup.leakcanary.RefWatcher;
import javax.inject.Singleton;

public abstract class bu
{
  @Singleton
  static RefWatcher a(Application paramApplication)
  {
    return RefWatcher.DISABLED;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bu
 * JD-Core Version:    0.6.2
 */
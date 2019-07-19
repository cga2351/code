package com.viber.voip.settings.ui;

import dagger.b;
import org.greenrobot.eventbus.EventBus;

public final class p
  implements b<GeneralPreferenceFragment>
{
  public static void a(GeneralPreferenceFragment paramGeneralPreferenceFragment, EventBus paramEventBus)
  {
    paramGeneralPreferenceFragment.b = paramEventBus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.p
 * JD-Core Version:    0.6.2
 */
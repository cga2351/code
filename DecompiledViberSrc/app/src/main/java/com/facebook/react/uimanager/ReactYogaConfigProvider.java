package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConfig;

public class ReactYogaConfigProvider
{
  private static YogaConfig YOGA_CONFIG;

  public static YogaConfig get()
  {
    if (YOGA_CONFIG == null)
    {
      YOGA_CONFIG = new YogaConfig();
      YOGA_CONFIG.setPointScaleFactor(0.0F);
      YOGA_CONFIG.setUseLegacyStretchBehaviour(true);
    }
    return YOGA_CONFIG;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactYogaConfigProvider
 * JD-Core Version:    0.6.2
 */
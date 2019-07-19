package com.viber.jni.banner;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class BannerControllerWrapper
  implements BannerController
{
  private static final Logger L = ViberEnv.getLogger();
  private final BannerController mBannerController;

  public BannerControllerWrapper(BannerController paramBannerController)
  {
    this.mBannerController = paramBannerController;
  }

  public void handleBannerOrSplashAck(long paramLong, int paramInt)
  {
    this.mBannerController.handleBannerOrSplashAck(paramLong, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.banner.BannerControllerWrapper
 * JD-Core Version:    0.6.2
 */
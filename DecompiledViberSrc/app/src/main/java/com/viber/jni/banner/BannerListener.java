package com.viber.jni.banner;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class BannerListener extends ControllerListener<BannerDelegate>
  implements BannerDelegate
{
  public void onBannerOrSplashReceived(final long paramLong1, String paramString1, final long paramLong2, final String paramString2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(BannerDelegate paramAnonymousBannerDelegate)
      {
        paramAnonymousBannerDelegate.onBannerOrSplashReceived(paramLong1, paramLong2, paramString2, this.val$tag);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.banner.BannerListener
 * JD-Core Version:    0.6.2
 */
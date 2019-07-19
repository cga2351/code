package com.appboy.ui.inappmessage.factories;

import android.content.res.Resources;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.appboy.b.a.h;
import com.appboy.e.b;
import com.appboy.e.m;
import com.appboy.ui.inappmessage.IInAppMessageAnimationFactory;
import com.appboy.ui.support.AnimationUtils;

public class AppboyInAppMessageAnimationFactory
  implements IInAppMessageAnimationFactory
{
  private final int mShortAnimationDurationMillis = Resources.getSystem().getInteger(17694720);

  public Animation getClosingAnimation(b paramb)
  {
    if ((paramb instanceof m))
    {
      if (((m)paramb).B() == h.a)
        return AnimationUtils.createVerticalAnimation(0.0F, -1.0F, this.mShortAnimationDurationMillis, false);
      return AnimationUtils.createVerticalAnimation(0.0F, 1.0F, this.mShortAnimationDurationMillis, false);
    }
    return AnimationUtils.setAnimationParams(new AlphaAnimation(1.0F, 0.0F), this.mShortAnimationDurationMillis, false);
  }

  public Animation getOpeningAnimation(b paramb)
  {
    if ((paramb instanceof m))
    {
      if (((m)paramb).B() == h.a)
        return AnimationUtils.createVerticalAnimation(-1.0F, 0.0F, this.mShortAnimationDurationMillis, false);
      return AnimationUtils.createVerticalAnimation(1.0F, 0.0F, this.mShortAnimationDurationMillis, false);
    }
    return AnimationUtils.setAnimationParams(new AlphaAnimation(0.0F, 1.0F), this.mShortAnimationDurationMillis, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboyInAppMessageAnimationFactory
 * JD-Core Version:    0.6.2
 */
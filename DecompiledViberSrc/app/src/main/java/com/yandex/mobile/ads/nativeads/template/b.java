package com.yandex.mobile.ads.nativeads.template;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

final class b
{
  static final int a = Color.parseColor("#eaeaea");
  private final ImageView[] b;

  b(ImageView[] paramArrayOfImageView)
  {
    this.b = paramArrayOfImageView;
    b();
  }

  @TargetApi(11)
  private static ObjectAnimator a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
    arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofInt("alpha", new int[] { paramInt1, paramInt2 });
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramDrawable, arrayOfPropertyValuesHolder);
    localObjectAnimator.setTarget(paramDrawable);
    localObjectAnimator.setDuration(500L);
    return localObjectAnimator;
  }

  private void b()
  {
    ImageView[] arrayOfImageView = this.b;
    int i = arrayOfImageView.length;
    int j = 0;
    if (j < i)
    {
      ImageView localImageView = arrayOfImageView[j];
      if (localImageView != null)
      {
        if (localImageView.getDrawable() == null)
          break label45;
        localImageView.setBackgroundColor(0);
      }
      while (true)
      {
        j++;
        break;
        label45: localImageView.setBackgroundColor(a);
      }
    }
  }

  final void a()
  {
    for (ImageView localImageView : this.b)
      if (Build.VERSION.SDK_INT >= 11)
      {
        ColorDrawable localColorDrawable = (ColorDrawable)localImageView.getBackground();
        Drawable localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localColorDrawable.getAlpha() == 255))
        {
          a(localColorDrawable, 255, 0).start();
          a(localDrawable, 0, 255).start();
        }
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.b
 * JD-Core Version:    0.6.2
 */
package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.transition.l;
import android.support.transition.s;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public class i extends l
{
  private void d(s params)
  {
    if ((params.b instanceof TextView))
    {
      TextView localTextView = (TextView)params.b;
      params.a.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }

  public Animator a(ViewGroup paramViewGroup, s params1, s params2)
  {
    float f1 = 1.0F;
    if ((params1 == null) || (params2 == null) || (!(params1.b instanceof TextView)) || (!(params2.b instanceof TextView)))
      return null;
    final TextView localTextView = (TextView)params2.b;
    Map localMap1 = params1.a;
    Map localMap2 = params2.a;
    if (localMap1.get("android:textscale:scale") != null);
    for (float f2 = ((Float)localMap1.get("android:textscale:scale")).floatValue(); ; f2 = f1)
    {
      if (localMap2.get("android:textscale:scale") != null)
        f1 = ((Float)localMap2.get("android:textscale:scale")).floatValue();
      if (f2 != f1)
        break;
      return null;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        localTextView.setScaleX(f);
        localTextView.setScaleY(f);
      }
    });
    return localValueAnimator;
  }

  public void a(s params)
  {
    d(params);
  }

  public void b(s params)
  {
    d(params);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.i
 * JD-Core Version:    0.6.2
 */
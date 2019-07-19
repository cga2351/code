package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class d extends ai
{
  public d()
  {
  }

  public d(int paramInt)
  {
    a(paramInt);
  }

  private static float a(s params, float paramFloat)
  {
    if (params != null)
    {
      Float localFloat = (Float)params.a.get("android:fade:transitionAlpha");
      if (localFloat != null)
        paramFloat = localFloat.floatValue();
    }
    return paramFloat;
  }

  private Animator a(final View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2)
      return null;
    ad.a(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, ad.a, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new a(paramView));
    a(new m()
    {
      public void a(l paramAnonymousl)
      {
        ad.a(paramView, 1.0F);
        ad.e(paramView);
        paramAnonymousl.b(this);
      }
    });
    return localObjectAnimator;
  }

  public Animator a(ViewGroup paramViewGroup, View paramView, s params1, s params2)
  {
    float f1 = a(params1, 0.0F);
    boolean bool = f1 < 1.0F;
    float f2 = 0.0F;
    if (!bool);
    while (true)
    {
      return a(paramView, f2, 1.0F);
      f2 = f1;
    }
  }

  public void a(s params)
  {
    super.a(params);
    params.a.put("android:fade:transitionAlpha", Float.valueOf(ad.c(params.b)));
  }

  public Animator b(ViewGroup paramViewGroup, View paramView, s params1, s params2)
  {
    ad.d(paramView);
    return a(paramView, a(params1, 1.0F), 0.0F);
  }

  private static class a extends AnimatorListenerAdapter
  {
    private final View a;
    private boolean b = false;

    a(View paramView)
    {
      this.a = paramView;
    }

    public void onAnimationEnd(Animator paramAnimator)
    {
      ad.a(this.a, 1.0F);
      if (this.b)
        this.a.setLayerType(0, null);
    }

    public void onAnimationStart(Animator paramAnimator)
    {
      if ((ViewCompat.hasOverlappingRendering(this.a)) && (this.a.getLayerType() == 0))
      {
        this.b = true;
        this.a.setLayerType(2, null);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.d
 * JD-Core Version:    0.6.2
 */
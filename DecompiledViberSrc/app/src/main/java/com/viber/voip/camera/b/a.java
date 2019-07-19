package com.viber.voip.camera.b;

import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.viber.voip.camera.R.id;
import com.viber.voip.camera.activity.ViberCcamActivity;
import com.viber.voip.camera.c.b;
import java.lang.ref.WeakReference;

public class a
{
  private static final Pair<String, Drawable> a = Pair.create(null, null);
  private final WeakReference<ViberCcamActivity> b;
  private final WeakReference<ViewAnimator> c;
  private final Animation.AnimationListener d = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      ViewAnimator localViewAnimator = a.a(a.this);
      ViberCcamActivity localViberCcamActivity = a.b(a.this);
      if ((localViewAnimator == null) || (localViberCcamActivity == null))
        return;
      if (localViewAnimator.getDisplayedChild() != 0);
      for (int i = 0; ; i = 1)
      {
        a.a(localViewAnimator.getChildAt(i), a.b());
        localViberCcamActivity.v();
        return;
      }
    }

    public void onAnimationRepeat(Animation paramAnonymousAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnonymousAnimation)
    {
    }
  };

  public a(ViberCcamActivity paramViberCcamActivity)
  {
    this.b = new WeakReference(paramViberCcamActivity);
    ViewAnimator localViewAnimator = (ViewAnimator)paramViberCcamActivity.findViewById(R.id.switch_flash_mode);
    this.c = new WeakReference(localViewAnimator);
    if ((localViewAnimator != null) && (localViewAnimator.getInAnimation() != null))
      localViewAnimator.getInAnimation().setAnimationListener(this.d);
  }

  private static void b(View paramView, Pair<String, Drawable> paramPair)
  {
    if ((paramView instanceof TextView))
      ((TextView)paramView).setText((CharSequence)paramPair.first);
    if ((paramView instanceof ImageView))
      ((ImageView)paramView).setImageDrawable((Drawable)paramPair.second);
    while (!(paramView instanceof TextView))
      return;
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds((Drawable)paramPair.second, null, null, null);
  }

  private b c()
  {
    ViberCcamActivity localViberCcamActivity = d();
    if (localViberCcamActivity == null)
      return null;
    return localViberCcamActivity.s();
  }

  private ViberCcamActivity d()
  {
    return (ViberCcamActivity)this.b.get();
  }

  private ViewAnimator e()
  {
    return (ViewAnimator)this.c.get();
  }

  public void a()
  {
    String str1 = null;
    b localb = c();
    if (localb == null)
      return;
    String str2 = localb.j();
    label21: label60: int i;
    label63: String str3;
    if (str2 != null)
      switch (str2.hashCode())
      {
      default:
        i = -1;
        switch (i)
        {
        default:
          str3 = null;
        case 0:
        case 1:
        case 2:
        }
        break;
      case -1146923872:
      case 1625570446:
      case -1195303778:
      }
    while ((str1 != null) && (!localb.d(str1)) && (str3 != null))
    {
      localb.d(str3);
      return;
      str2 = "";
      break label21;
      if (!str2.equals("flash_off"))
        break label60;
      i = 0;
      break label63;
      if (!str2.equals("flash_on"))
        break label60;
      i = 1;
      break label63;
      if (!str2.equals("flash_auto"))
        break label60;
      i = 2;
      break label63;
      str1 = "flash_on";
      str3 = "flash_auto";
      continue;
      str1 = "flash_auto";
      str3 = "flash_off";
      continue;
      str1 = "flash_off";
      str3 = "flash_on";
    }
  }

  public void a(String paramString, boolean paramBoolean)
  {
    ViewAnimator localViewAnimator = e();
    ViberCcamActivity localViberCcamActivity = d();
    if ((localViewAnimator == null) || (localViberCcamActivity == null))
      return;
    b localb = c();
    if ((localb != null) && (localb.Y()));
    for (String str = ""; ; str = paramString)
    {
      Pair localPair;
      if (str != null)
      {
        localPair = localViberCcamActivity.b(str);
        if (localPair == null)
          break label134;
        label63: if (localViewAnimator.getDisplayedChild() == 0)
          break label142;
      }
      label134: label142: for (int i = 0; ; i = 1)
      {
        if ((paramBoolean) && (localViewAnimator.getInAnimation() != null) && ((localPair.first != null) || (localPair.second != null)))
          break label148;
        b(localViewAnimator.getCurrentView(), localPair);
        b(localViewAnimator.getChildAt(i), a);
        localViberCcamActivity.v();
        return;
        str = "";
        break;
        localPair = a;
        break label63;
      }
      label148: b(localViewAnimator.getChildAt(i), localPair);
      localViewAnimator.showNext();
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    b localb = c();
    if (localb != null)
      a(localb.j(), paramBoolean);
  }

  public static abstract interface a
  {
    public abstract Pair<String, Drawable> b(String paramString);

    public abstract a c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.b.a
 * JD-Core Version:    0.6.2
 */
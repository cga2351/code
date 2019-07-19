package com.viber.voip.messages.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.viber.voip.R.attr;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.a;
import com.viber.voip.util.e.c.b;
import com.viber.voip.util.e.c.b.a;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;
import org.jetbrains.annotations.NotNull;

public class ac extends ad
{
  private e a;
  private f b;
  private Drawable c;
  private b d;

  public ac(Context paramContext)
  {
    super(paramContext);
  }

  private void a(Animation.AnimationListener paramAnimationListener)
  {
    ScaleAnimation localScaleAnimation = d();
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setAnimationListener(paramAnimationListener);
    startAnimation(localScaleAnimation);
  }

  private void c()
  {
    ScaleAnimation localScaleAnimation = e();
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    startAnimation(localScaleAnimation);
  }

  @NotNull
  private ScaleAnimation d()
  {
    return new ScaleAnimation(1.0F, 0.3F, 1.0F, 0.3F, 1, 0.5F, 1, 0.5F);
  }

  @NotNull
  private ScaleAnimation e()
  {
    return new ScaleAnimation(0.3F, 1.0F, 0.3F, 1.0F, 1, 0.5F, 1, 0.5F);
  }

  public void a()
  {
    if (getDrawable() == this.c)
      return;
    a(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        ac.this.setImageDrawable(ac.b(ac.this));
        ac.a(ac.this);
      }
    });
  }

  protected void a(Context paramContext)
  {
    super.a(paramContext);
    this.a = e.a(paramContext);
    this.b = new f.a().b(Integer.valueOf(dc.a(paramContext, R.attr.chatExDefaultIcon))).a(f.b.b).b(false).c();
    this.d = new b(this, new b.a()
    {
      public void a(final ac paramAnonymousac, final Drawable paramAnonymousDrawable)
      {
        if ((paramAnonymousDrawable instanceof a))
        {
          paramAnonymousac.setImageDrawable(paramAnonymousDrawable);
          return;
        }
        ac.a(paramAnonymousac, new a.a()
        {
          public void onAnimationEnd(Animation paramAnonymous2Animation)
          {
            paramAnonymousac.setImageDrawable(paramAnonymousDrawable);
            ac.a(paramAnonymousac);
          }
        });
      }
    });
  }

  public void a(Uri paramUri)
  {
    this.a.a(paramUri, this.d, this.b);
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.c == null)
      this.c = paramDrawable;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ac
 * JD-Core Version:    0.6.2
 */
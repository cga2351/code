package com.viber.voip.messages.conversation.ui;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.df;

public class bh extends bt
{
  private static final Logger a = ViberEnv.getLogger();
  private final View b;
  private Handler c;
  private Animation d;
  private Animation e;
  private Runnable f = new Runnable()
  {
    public void run()
    {
      bh.this.a();
    }
  };
  private Animation.AnimationListener g = new Animation.AnimationListener()
  {
    public void onAnimationEnd(Animation paramAnonymousAnimation)
    {
      bh.this.b();
      paramAnonymousAnimation.setAnimationListener(null);
    }

    public void onAnimationRepeat(Animation paramAnonymousAnimation)
    {
    }

    public void onAnimationStart(Animation paramAnonymousAnimation)
    {
    }
  };

  public bh(View paramView, Handler paramHandler, final a parama)
  {
    this.b = paramView;
    this.c = paramHandler;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        parama.a();
      }
    });
  }

  public void a()
  {
    this.c.removeCallbacks(this.f);
    if (this.b.getVisibility() == 0)
    {
      this.b.setVisibility(4);
      this.e = df.a(this.b.getContext(), this.e, R.anim.jump_button_fade_out);
      this.b.startAnimation(this.e);
    }
  }

  public void a(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    if (paramView == null);
    for (int i = R.id.message_composer; ; i = paramView.getId())
    {
      localLayoutParams.addRule(2, i);
      this.b.setLayoutParams(localLayoutParams);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.c.removeCallbacks(this.f);
    if (this.b.getVisibility() == 4)
    {
      this.b.setVisibility(0);
      this.d = df.a(this.b.getContext(), this.d, R.anim.jump_button_fade_in);
      localAnimation = this.d;
      if (paramBoolean)
      {
        localAnimationListener = this.g;
        localAnimation.setAnimationListener(localAnimationListener);
        this.b.startAnimation(this.d);
      }
    }
    while (!paramBoolean)
      while (true)
      {
        Animation localAnimation;
        return;
        Animation.AnimationListener localAnimationListener = null;
      }
    b();
  }

  public void b()
  {
    this.c.removeCallbacks(this.f);
    this.c.postDelayed(this.f, 2000L);
  }

  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a();
      return;
    }
    b();
  }

  protected void c()
  {
    a();
  }

  protected void d()
  {
    a(false);
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bh
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.ui.view;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig.a;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.c;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.util.dj;

public class k
  implements ExpandablePanelLayout.c
{
  private static final Logger a = ViberEnv.getLogger();
  private View b;
  private MessageComposerView c;
  private BotReplyConfig.a d;
  private int e = 1;
  private ImageView f;
  private int g;
  private int h;

  public k(View paramView, MessageComposerView paramMessageComposerView)
  {
    this.b = paramView;
    this.c = paramMessageComposerView;
  }

  private static void a(final View paramView, boolean paramBoolean, Interpolator paramInterpolator, int paramInt)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(((View)paramView.getParent()).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    Animation local1 = new Animation()
    {
      protected void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        if (this.a)
        {
          paramView.getLayoutParams().height = ((int)(paramAnonymousFloat * this.c));
          paramView.requestLayout();
          return;
        }
        paramView.getLayoutParams().height = (this.c - (int)(paramAnonymousFloat * this.c));
        paramView.requestLayout();
      }

      public boolean willChangeBounds()
      {
        return true;
      }
    };
    local1.setAnimationListener(new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (this.a)
        {
          paramView.getLayoutParams().height = -2;
          paramView.requestLayout();
          return;
        }
        paramView.setVisibility(8);
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        if (this.a)
        {
          paramView.getLayoutParams().height = 1;
          paramView.setVisibility(0);
          paramView.requestLayout();
        }
      }
    });
    local1.setInterpolator(paramInterpolator);
    local1.setDuration(paramInt);
    paramView.startAnimation(local1);
  }

  private void a(boolean paramBoolean)
  {
    dj.b(this.f, false);
    if ((this.e == 1) && (paramBoolean))
      a(true, false);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a(this.c, paramBoolean1, com.viber.voip.ui.b.c.f, 200);
      return;
    }
    if (paramBoolean1)
    {
      this.c.getLayoutParams().height = -2;
      this.c.setVisibility(0);
    }
    while (true)
    {
      this.c.requestLayout();
      return;
      this.c.getLayoutParams().height = 1;
      this.c.setVisibility(8);
    }
  }

  private void b()
  {
    switch (this.e)
    {
    default:
      return;
    case 2:
      this.e = 1;
      dj.c(this.c);
      a(false, true);
      b(false);
      return;
    case 1:
    }
    this.e = 2;
    a(true, true);
    b(true);
  }

  private void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = R.drawable.small_arrow_down; ; i = R.drawable.small_arrow_up)
    {
      this.f.setImageResource(i);
      return;
    }
  }

  private void c(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.f == null)
    {
      this.f = ((ImageView)this.b.findViewById(R.id.expander_icon));
      this.f.setOnClickListener(new l(this));
      if (paramInt != 2)
        break label81;
      bool2 = bool1;
      label48: a(bool2, false);
      if (paramInt != 2)
        break label86;
    }
    while (true)
    {
      b(bool1);
      this.e = paramInt;
      return;
      dj.b(this.f, bool1);
      break;
      label81: bool2 = false;
      break label48;
      label86: bool1 = false;
    }
  }

  public int a()
  {
    return this.e;
  }

  public void a(int paramInt)
  {
    com.viber.voip.messages.ui.expanel.c.a(this, paramInt);
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    if ((this.d != null) && (this.d == BotReplyConfig.a.MINIMIZED))
    {
      if ((paramInt1 != 3) || (paramInt2 != R.id.bot_keyboard))
        break label56;
      this.c.setViewState(2);
      c(this.e);
    }
    while (true)
    {
      this.g = paramInt1;
      this.h = paramInt2;
      return;
      label56: this.c.setViewState(1);
      a(true);
    }
  }

  public void a(BotReplyConfig.a parama)
  {
    this.d = parama;
    switch (3.a[this.d.ordinal()])
    {
    default:
    case 1:
    case 2:
      do
      {
        return;
        this.c.setViewState(1);
        a(true);
        return;
      }
      while ((this.g == 2) || ((this.h != R.id.bot_keyboard) && (this.h != 0)));
      this.c.setViewState(2);
      c(this.e);
      return;
    case 3:
    }
    this.c.setViewState(3);
    a(false);
  }

  public void b(int paramInt)
  {
    this.e = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.k
 * JD-Core Version:    0.6.2
 */
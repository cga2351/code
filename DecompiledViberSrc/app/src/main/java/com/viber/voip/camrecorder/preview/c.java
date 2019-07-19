package com.viber.voip.camrecorder.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ui.doodle.extras.d;
import com.viber.voip.ui.doodle.pickers.BrushPickerView;
import com.viber.voip.ui.doodle.pickers.BrushPickerView.a;
import com.viber.voip.ui.doodle.pickers.ColorPickerView;
import com.viber.voip.ui.doodle.pickers.ColorPickerView.a;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;

abstract class c
  implements d
{
  private final com.viber.voip.ui.doodle.extras.c a;
  private Resources b;
  private AnimatorSet c;
  private AnimatorSet d;
  private final BrushPickerView e;
  private final ColorPickerView f;
  private final View g;
  private final boolean h;

  c(Context paramContext, View paramView, DoodleActivity.a parama, Bundle paramBundle)
  {
    this.b = paramContext.getResources();
    int i = this.b.getColor(R.color.main);
    int j = j.a(paramContext, BrushPickerView.a[1]);
    int i1;
    int k;
    if (paramBundle != null)
    {
      int n = paramBundle.getInt("color", i);
      i1 = paramBundle.getInt("size", j);
      k = n;
    }
    for (int m = i1; ; m = j)
    {
      this.a = new com.viber.voip.ui.doodle.extras.c(k, m);
      this.e = ((BrushPickerView)paramView.findViewById(R.id.brush_picker));
      this.e.setBrushSize(m);
      this.e.setColor(k);
      this.e.setOnBrushSizeChangedListener(new BrushPickerView.a()
      {
        public void a(int paramAnonymousInt)
        {
          c.a(c.this).a(paramAnonymousInt);
        }
      });
      this.f = ((ColorPickerView)paramView.findViewById(R.id.color_picker));
      this.f.setOnColorChangedListener(new ColorPickerView.a()
      {
        public void a(int paramAnonymousInt)
        {
          c.b(c.this).setColor(paramAnonymousInt);
          c.a(c.this).b(paramAnonymousInt);
        }
      });
      this.g = paramView.findViewById(R.id.btn_undo_doodle);
      if ((parama != null) && (parama.equals(DoodleActivity.a.b)));
      for (boolean bool = true; ; bool = false)
      {
        this.h = bool;
        j();
        return;
      }
      k = i;
    }
  }

  private void j()
  {
    this.c = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.e, View.ALPHA, new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.f, View.ALPHA, new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.g, View.ALPHA, new float[] { 0.0F, 1.0F });
    this.c.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    this.c.setDuration(300L);
    this.c.addListener(new a()
    {
      public void a(Animator paramAnonymousAnimator)
      {
        c.this.d();
      }

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        c.b(c.this).setAlpha(1.0F);
        c.c(c.this).setAlpha(1.0F);
        c.d(c.this).setAlpha(1.0F);
      }
    });
    this.d = new AnimatorSet();
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.e, View.ALPHA, new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.f, View.ALPHA, new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.g, View.ALPHA, new float[] { 1.0F, 0.0F });
    this.d.playTogether(new Animator[] { localObjectAnimator4, localObjectAnimator5, localObjectAnimator6 });
    this.d.setDuration(300L);
    this.d.addListener(new a()
    {
      public void a(Animator paramAnonymousAnimator)
      {
        c.this.e();
      }

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        c.b(c.this).setAlpha(1.0F);
        c.c(c.this).setAlpha(1.0F);
        c.d(c.this).setAlpha(1.0F);
      }
    });
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("color", this.a.h());
    paramBundle.putInt("size", (int)this.a.g());
  }

  abstract boolean a();

  Animator b()
  {
    return this.c;
  }

  Animator c()
  {
    return this.d;
  }

  void d()
  {
    if (!a())
      return;
    dj.b(this.e, true);
    dj.b(this.f, true);
    dj.b(this.g, this.h);
  }

  void e()
  {
    dj.b(this.e, false);
    dj.b(this.f, false);
    dj.b(this.g, false);
  }

  void f()
  {
    this.f.getLayoutParams().height = this.b.getDimensionPixelSize(R.dimen.custom_cam_media_preview_color_picker_height);
  }

  public float g()
  {
    return this.a.g();
  }

  public int h()
  {
    return this.a.h();
  }

  public View i()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.c
 * JD-Core Version:    0.6.2
 */
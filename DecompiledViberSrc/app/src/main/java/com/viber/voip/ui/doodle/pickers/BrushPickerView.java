package com.viber.voip.ui.doodle.pickers;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.viber.voip.R.color;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;
import java.util.ArrayList;
import java.util.List;

public class BrushPickerView extends LinearLayout
{
  public static final int[] a = { 6, 12, 16, 22, 26 };
  private a b;
  private int c;
  private a d;
  private List<c> e;
  private boolean f;
  private int g;
  private int h;
  private View.OnClickListener i = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (paramAnonymousView != BrushPickerView.a(BrushPickerView.this))
      {
        int i = ((a)paramAnonymousView).b();
        BrushPickerView.this.setBrushSize(i);
        if (BrushPickerView.b(BrushPickerView.this) != null)
          BrushPickerView.b(BrushPickerView.this).a(i);
      }
      BrushPickerView localBrushPickerView = BrushPickerView.this;
      if (!BrushPickerView.c(BrushPickerView.this));
      for (boolean bool = true; ; bool = false)
      {
        BrushPickerView.a(localBrushPickerView, bool);
        return;
      }
    }
  };

  public BrushPickerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public BrushPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public BrushPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a()
  {
    int j = -1 + this.e.size();
    for (int k = j; k >= 0; k--)
    {
      final a locala = (a)this.e.get(k);
      float f1 = locala.b();
      dj.b(locala, true);
      ViewCompat.setAlpha(locala, 0.0F);
      ViewCompat.setTranslationX(locala, f1);
      ViewCompat.animate(locala).alpha(1.0F).translationX(0.0F).setStartDelay(25L * (j - k)).setDuration(75L).setListener(new ViewPropertyAnimatorListenerAdapter()
      {
        public void onAnimationEnd(View paramAnonymousView)
        {
          ViewCompat.setAlpha(locala, 1.0F);
          ViewCompat.setTranslationX(locala, 0.0F);
        }
      }).start();
    }
  }

  private void a(Context paramContext)
  {
    this.g = j.a(paramContext, 36.0F);
    this.h = j.a(paramContext, 22.0F);
    this.c = paramContext.getResources().getColor(R.color.main);
    setGravity(5);
    this.e = new ArrayList();
    for (int j = 0; j < a.length; j++)
    {
      int m = a[j];
      c localc = new c(paramContext, this.g, j.a(paramContext, m), this.c);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.g, this.g);
      localLayoutParams.rightMargin = this.h;
      localc.setLayoutParams(localLayoutParams);
      localc.setOnClickListener(this.i);
      localc.setVisibility(8);
      if (j == 1)
        localc.setChecked(true);
      this.e.add(localc);
      addView(localc);
    }
    int k = j.a(paramContext, a[1]);
    this.d = new a(paramContext, this.g, k, this.c);
    this.d.setLayoutParams(new LinearLayout.LayoutParams(this.g, this.g));
    b localb = new b(this.g, this.g, -1728053248, j.a(paramContext, 1.0F), -2130706433);
    dj.a(this.d, localb);
    this.d.setOnClickListener(this.i);
    addView(this.d);
  }

  private void b()
  {
    for (int j = 0; j < this.e.size(); j++)
    {
      final a locala = (a)this.e.get(j);
      float f1 = locala.b();
      ViewCompat.setAlpha(locala, 1.0F);
      ViewCompat.setTranslationX(locala, 0.0F);
      ViewCompat.animate(locala).alpha(0.0F).translationX(f1).setStartDelay(25L * j).setDuration(75L).setListener(new ViewPropertyAnimatorListenerAdapter()
      {
        public void onAnimationEnd(View paramAnonymousView)
        {
          dj.b(locala, false);
        }
      }).start();
    }
  }

  private void setBrushesVisible(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      if (this.f)
        a();
    }
    else
    {
      return;
    }
    b();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = 1 + a.length;
    setMeasuredDimension(j * this.g + (j - 1) * this.h, this.g);
  }

  public void setBrushSize(int paramInt)
  {
    this.d.b(paramInt);
    int j = 0;
    if (j < this.e.size())
    {
      c localc = (c)this.e.get(j);
      if (paramInt == localc.b());
      for (boolean bool = true; ; bool = false)
      {
        localc.setChecked(bool);
        j++;
        break;
      }
    }
  }

  public void setColor(int paramInt)
  {
    this.c = paramInt;
    this.d.a(this.c);
    for (int j = 0; j < this.e.size(); j++)
      ((a)this.e.get(j)).a(this.c);
  }

  public void setGravity(int paramInt)
  {
    if (5 == paramInt)
      super.setGravity(paramInt);
  }

  public void setOnBrushSizeChangedListener(a parama)
  {
    this.b = parama;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.pickers.BrushPickerView
 * JD-Core Version:    0.6.2
 */
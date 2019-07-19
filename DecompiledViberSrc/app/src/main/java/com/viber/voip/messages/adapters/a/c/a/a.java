package com.viber.voip.messages.adapters.a.c.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.v4.util.LongSparseArray;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dc;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private final int c;
  private final LongSparseArray<a> d = new LongSparseArray();

  public a(Context paramContext)
  {
    this.b = dc.d(paramContext, R.attr.conversationsListEngagementAnimationStartColor);
    this.c = dc.d(paramContext, R.attr.conversationsListEngagementAnimationEndColor);
  }

  private void b(View paramView)
  {
    long l = ((Long)paramView.getTag(R.id.engagement_item_id)).longValue();
    this.d.remove(l);
  }

  public void a(View paramView)
  {
    paramView.setBackgroundColor(this.b);
  }

  public boolean a(long paramLong)
  {
    return this.d.get(paramLong) != null;
  }

  public boolean a(View paramView, long paramLong)
  {
    if (!b(paramView, paramLong))
    {
      paramView.setBackgroundColor(this.b);
      ArgbEvaluator localArgbEvaluator = new ArgbEvaluator();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.b);
      arrayOfObject[1] = Integer.valueOf(this.c);
      a locala = a.a(this, paramView, localArgbEvaluator, arrayOfObject);
      locala.setStartDelay(1500L);
      locala.setDuration(400L);
      locala.setInterpolator(new DecelerateInterpolator());
      this.d.put(paramLong, locala);
      paramView.setTag(R.id.engagement_item_id, Long.valueOf(paramLong));
      locala.start();
    }
    return true;
  }

  public boolean b(View paramView, long paramLong)
  {
    a locala = (a)this.d.get(paramLong);
    if ((locala != null) && (locala.a(paramView)))
    {
      paramView.setTag(R.id.engagement_item_id, Long.valueOf(paramLong));
      if ((locala.isStarted()) && (!locala.isRunning()))
        paramView.setBackgroundColor(this.b);
      return true;
    }
    return false;
  }

  public boolean c(View paramView, long paramLong)
  {
    Object localObject = paramView.getTag(R.id.engagement_item_id);
    if (localObject != null)
    {
      long l = ((Long)localObject).longValue();
      a locala = (a)this.d.get(l);
      if ((locala != null) && (l != paramLong))
        locala.a(null);
      return true;
    }
    return false;
  }

  private static class a extends ValueAnimator
  {
    private a a;
    private View b;
    private boolean c;

    a(a parama, View paramView)
    {
      this.a = parama;
      this.b = paramView;
      addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          if (a.a.a(a.a.this) != null)
            a.a.a(a.a.this).setBackgroundColor(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
      });
      addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          a.a.a(a.a.this, true);
          if (a.a.a(a.a.this) != null)
            a.a(a.this, a.a.a(a.a.this));
          a.a.a(a.a.this, null);
        }
      });
    }

    static a a(a parama, View paramView, TypeEvaluator paramTypeEvaluator, Object[] paramArrayOfObject)
    {
      a locala = new a(parama, paramView);
      locala.setObjectValues(paramArrayOfObject);
      locala.setEvaluator(paramTypeEvaluator);
      return locala;
    }

    boolean a(View paramView)
    {
      if (!this.c)
      {
        this.b = paramView;
        return true;
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.c.a.a
 * JD-Core Version:    0.6.2
 */
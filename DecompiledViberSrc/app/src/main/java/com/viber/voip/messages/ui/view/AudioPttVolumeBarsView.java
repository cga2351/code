package com.viber.voip.messages.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.adapter.d.v.b;
import com.viber.voip.messages.conversation.adapter.d.v.c;
import com.viber.voip.sound.ptt.PttUtils.AudioBarsInfo;
import com.viber.voip.util.dc;

public class AudioPttVolumeBarsView extends View
  implements v.b, v.c
{
  private static Logger a = ViberEnv.getLogger();
  private static final PttUtils.AudioBarsInfo b = new PttUtils.AudioBarsInfo(null, 30, (short)0);
  private static RectF[] c;
  private static OvershootInterpolator d = new OvershootInterpolator();
  private static LinearInterpolator e = new LinearInterpolator();
  private ValueAnimator A;
  private ValueAnimator B;
  private final RectF C = new RectF();
  private Paint f = new Paint(1);
  private Paint g = new Paint(1);
  private Paint h = new Paint(1);
  private int i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private PttUtils.AudioBarsInfo p = b;
  private RectF[] q = new RectF[this.p.count];
  private boolean r;
  private float s = 0.0F;
  private boolean t = false;
  private Region u = new Region();
  private Region v = new Region();
  private Region w = new Region();
  private Path x = new Path();
  private Path y = new Path();
  private a z;

  public AudioPttVolumeBarsView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public AudioPttVolumeBarsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public AudioPttVolumeBarsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private float a(int paramInt, RectF paramRectF)
  {
    if (this.A.isStarted())
    {
      float f1 = paramInt / this.p.count;
      float f2 = Math.max(Math.min(2.0F * ((Float)this.A.getAnimatedValue()).floatValue() - f1, 1.0F), 0.0F);
      float f3 = d.getInterpolation(f2);
      return Math.max(paramRectF.width(), f3 * paramRectF.height() + Math.max(f3 - 1.0F, 0.0F) * (this.l - paramRectF.height()));
    }
    return paramRectF.height();
  }

  private void a(float paramFloat)
  {
    if (c != null);
    while (true)
    {
      return;
      c = new RectF[b.count];
      for (int i1 = 0; i1 < b.count; i1++)
        a(c, i1, 0.0F, 0.0F, paramFloat, paramFloat);
    }
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    if (this.q.length != this.p.count)
      this.q = new RectF[this.p.count];
    float f1 = paramFloat2 / this.p.peakVolume;
    for (int i1 = 0; i1 < this.p.count; i1++)
    {
      float f2 = Math.max(paramFloat1, f1 * this.p.volumes[i1]);
      a(this.q, i1, 0.0F, 0.0F, paramFloat1, f2);
    }
  }

  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.z != null) && (this.i > 0))
      this.z.a(paramFloat1 * this.p.count / this.i, paramFloat2 * this.p.count / this.i, paramBoolean1, paramBoolean2);
  }

  private void a(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.t) && (!paramBoolean1));
    while (true)
    {
      return;
      if ((paramFloat < 0.0F) || (g()))
        paramFloat = 0.0F;
      while (this.s != paramFloat)
      {
        if ((this.z != null) && (!g()))
          a(this.i, paramFloat, paramBoolean1, paramBoolean2);
        this.s = paramFloat;
        invalidate();
        return;
        if (paramFloat > this.i)
          paramFloat = this.i;
      }
    }
  }

  private void a(Context paramContext, TypedArray paramTypedArray)
  {
    this.f.setColor(paramTypedArray.getColor(R.styleable.AudioPttVolumeBarsView_readStateBgColor, dc.d(paramContext, R.attr.conversationPttBarBgColor)));
    this.f.setStyle(Paint.Style.FILL);
    this.g.setColor(paramTypedArray.getColor(R.styleable.AudioPttVolumeBarsView_unreadStateBgColor, dc.d(paramContext, R.attr.conversationPttBarUnreadColor)));
    this.g.setStyle(Paint.Style.FILL);
    this.h.setColor(paramTypedArray.getColor(R.styleable.AudioPttVolumeBarsView_progressStateColor, dc.d(paramContext, R.attr.conversationPttBarProgressColor)));
    this.h.setStyle(Paint.Style.FILL);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null)
      return;
    this.A = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.A.addUpdateListener(new e(this));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AudioPttVolumeBarsView);
    try
    {
      a(paramContext, localTypedArray);
      b(paramContext, localTypedArray);
      localTypedArray.recycle();
      this.o = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private void a(RectF[] paramArrayOfRectF, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramInt >= paramArrayOfRectF.length)
      return;
    RectF localRectF = paramArrayOfRectF[paramInt];
    if (localRectF == null)
    {
      localRectF = new RectF();
      paramArrayOfRectF[paramInt] = localRectF;
    }
    localRectF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  private boolean a(PttUtils.AudioBarsInfo paramAudioBarsInfo)
  {
    if (paramAudioBarsInfo == null);
    while ((paramAudioBarsInfo.volumes == null) || (paramAudioBarsInfo.peakVolume == 0) || (paramAudioBarsInfo.count == 0) || (paramAudioBarsInfo.count != paramAudioBarsInfo.volumes.length))
      return false;
    return true;
  }

  private void b(Context paramContext, TypedArray paramTypedArray)
  {
    this.j = paramTypedArray.getFloat(R.styleable.AudioPttVolumeBarsView_spaceToLineRatio, 2.0F);
    if (this.j <= 0.0F)
      this.j = 2.0F;
  }

  private boolean f()
  {
    if (this.p.count == 0);
    while ((getWidth() <= 0) || (getHeight() <= 0))
      return false;
    int i1 = getWidth() - getPaddingLeft() - getPaddingRight();
    int i2 = getHeight() - getPaddingTop() - getPaddingBottom();
    float f1 = i1 / (this.p.count * (1.0F + this.j) - this.j);
    this.k = f1;
    this.l = i2;
    this.m = (0.5F * this.k);
    this.n = (f1 * this.j);
    this.u.set(0, 0, i1, i2);
    this.i = i1;
    if (g())
      a(this.k);
    while (true)
    {
      return true;
      a(this.k, this.l);
    }
  }

  private boolean g()
  {
    return this.p == b;
  }

  private RectF[] getVolumeBars()
  {
    if (g())
      return c;
    return this.q;
  }

  public void a()
  {
    b();
    this.A.start();
  }

  public void a(long paramLong)
  {
    long l1 = paramLong - 100L;
    if ((this.i == 0) || (l1 <= 0L))
      return;
    d();
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.s;
    arrayOfFloat[1] = this.i;
    this.B = ValueAnimator.ofFloat(arrayOfFloat).setDuration(l1);
    this.B.setInterpolator(e);
    this.B.addUpdateListener(new f(this));
    this.B.start();
  }

  public void a(View paramView)
  {
  }

  public void a(View paramView, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (g());
    ViewParent localViewParent;
    do
    {
      do
      {
        return;
        if (this.t)
          break;
      }
      while (Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX()) < this.o);
      localViewParent = getParent();
    }
    while (localViewParent == null);
    localViewParent.requestDisallowInterceptTouchEvent(true);
    this.t = true;
    a(paramMotionEvent2.getX() - getPaddingLeft(), true, false);
  }

  public void b()
  {
    if (this.A.isStarted())
      this.A.cancel();
  }

  public void b(View paramView)
  {
    if (g());
    do
    {
      do
      {
        ViewParent localViewParent;
        do
        {
          return;
          localViewParent = getParent();
        }
        while (localViewParent == null);
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
      while (!this.t);
      this.t = false;
    }
    while (this.z == null);
    a(this.s, this.s, true, true);
  }

  public boolean c()
  {
    return this.A.isStarted();
  }

  public void d()
  {
    if ((this.B != null) && (this.B.isStarted()))
      this.B.cancel();
  }

  public boolean e()
  {
    return (this.B != null) && (this.B.isStarted());
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.k == 0.0F) || (this.l == 0.0F))
      return;
    paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    RectF[] arrayOfRectF = getVolumeBars();
    int i1 = 0;
    while (i1 < this.p.count)
    {
      RectF localRectF1 = arrayOfRectF[i1];
      float f1 = i1 * (this.k + this.n);
      float f2 = a(i1, localRectF1);
      this.C.set(f1, this.l - f2, f1 + localRectF1.width(), this.l);
      if (this.s >= f1 + this.k)
      {
        paramCanvas.drawRoundRect(this.C, this.m, this.m, this.h);
        i1++;
      }
      else
      {
        RectF localRectF2 = this.C;
        float f3 = this.m;
        float f4 = this.m;
        if (this.r);
        for (Paint localPaint = this.g; ; localPaint = this.f)
        {
          paramCanvas.drawRoundRect(localRectF2, f3, f4, localPaint);
          if ((this.s <= f1) || (this.s >= f1 + this.k))
            break;
          this.x.reset();
          this.y.reset();
          this.x.addRoundRect(this.C, this.m, this.m, Path.Direction.CW);
          this.y.addRect(this.C.left, this.C.top, Math.min(this.C.right, this.s), this.C.bottom, Path.Direction.CW);
          this.v.setPath(this.x, this.u);
          this.w.setPath(this.y, this.u);
          this.v.op(this.w, Region.Op.INTERSECT);
          this.x.reset();
          this.v.getBoundaryPath(this.x);
          this.x.close();
          paramCanvas.drawPath(this.x, this.h);
          break;
        }
      }
    }
    paramCanvas.restore();
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f();
  }

  public void setAudioBarsInfo(PttUtils.AudioBarsInfo paramAudioBarsInfo)
  {
    if (this.p.equals(paramAudioBarsInfo))
      return;
    if (a(paramAudioBarsInfo));
    for (this.p = paramAudioBarsInfo; ; this.p = b)
    {
      a(0.0F, false, true);
      if (!f())
        break;
      invalidate();
      return;
    }
  }

  public void setProgress(float paramFloat)
  {
    if (this.i == 0);
    while (g())
      return;
    a(paramFloat * (this.k + this.n), false, true);
  }

  public void setProgressChangeListener(a parama)
  {
    this.z = parama;
  }

  public void setUnreadState(boolean paramBoolean)
  {
    if (this.r == paramBoolean);
    do
    {
      return;
      this.r = paramBoolean;
    }
    while (g());
    invalidate();
  }

  public static abstract interface a
  {
    public abstract void a(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.view.AudioPttVolumeBarsView
 * JD-Core Version:    0.6.2
 */
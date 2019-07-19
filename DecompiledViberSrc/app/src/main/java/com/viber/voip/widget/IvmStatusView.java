package com.viber.voip.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.viber.common.d.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.b.c;
import com.viber.voip.util.av;

public class IvmStatusView extends View
{
  private static final Logger a = ViberEnv.getLogger();
  private float A = 0.0F;
  private int B = -1;
  private float C;
  private AnimatorSet D;
  private ValueAnimator E;
  private final Animator.AnimatorListener F = new AnimatorListenerAdapter()
  {
    @SuppressLint({"SwitchIntDef"})
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      switch (IvmStatusView.a(IvmStatusView.this))
      {
      default:
      case 3:
      case 4:
      }
      do
      {
        return;
        IvmStatusView.this.setStatus(2);
        return;
      }
      while (IvmStatusView.b(IvmStatusView.this) != 100);
      IvmStatusView.this.setStatus(0);
    }
  };
  private Drawable b;
  private ColorStateList c;
  private ColorStateList d;
  private ColorStateList e;
  private int f;
  private int g;
  private int h;
  private final Paint i = new Paint(1);
  private final Paint j = new Paint(1);
  private final Paint k = new Paint(1);
  private final Path l = new Path();
  private final Path m = new Path();
  private final Path n = new Path();
  private final PathMeasure o = new PathMeasure();
  private final Matrix p = new Matrix();
  private final PointF q = new PointF();
  private final RectF r = new RectF();
  private int s;
  private long t;
  private long u;
  private int v;
  private int w;
  private float x;
  private int y = 255;
  private float z = 1.0F;

  public IvmStatusView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public IvmStatusView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public IvmStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  public IvmStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }

  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    if (paramColorStateList == null)
      return 0;
    if (!paramColorStateList.isStateful())
      return paramColorStateList.getDefaultColor();
    return paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());
  }

  private void a()
  {
    if (this.s != 3);
    for (int i1 = 1; ; i1 = 0)
    {
      this.s = 3;
      if (i1 != 0)
        invalidate();
      return;
    }
  }

  private void a(float paramFloat1, float paramFloat2, Interpolator paramInterpolator, long paramLong1, long paramLong2)
  {
    j();
    this.E = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    this.E.setInterpolator(paramInterpolator);
    this.E.setDuration(paramLong1);
    this.E.addUpdateListener(new n(this, paramLong2));
    this.E.addListener(this.F);
    this.E.start();
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.l.reset();
    float f1 = this.h / 2.0F;
    switch (this.v)
    {
    default:
      this.l.addRect(f1, f1, paramInt1 - f1, paramInt2 - f1, Path.Direction.CW);
      this.o.setPath(this.l, true);
      this.C = this.o.getLength();
      return;
    case 1:
      if (paramInt1 > paramInt2);
      while (true)
      {
        float f3 = paramInt2 / 2.0F - f1;
        this.l.addCircle(this.q.x, this.q.y, f3, Path.Direction.CW);
        this.p.reset();
        this.p.postRotate(-90.0F, this.q.x, this.q.y);
        this.l.transform(this.p);
        break;
        paramInt2 = paramInt1;
      }
    case 2:
    }
    if (paramInt1 > paramInt2);
    while (true)
    {
      float f2 = paramInt2 - this.h;
      h.b(f2, f2, f1, f1, this.l);
      break;
      paramInt2 = paramInt1;
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setLayerType(1, null);
    Resources localResources = paramContext.getResources();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.IvmStatusView);
    try
    {
      this.c = localTypedArray.getColorStateList(R.styleable.IvmStatusView_overlayColor);
      this.d = localTypedArray.getColorStateList(R.styleable.IvmStatusView_strokeColor);
      if (this.d == null)
        this.d = ColorStateList.valueOf(-1);
      this.e = localTypedArray.getColorStateList(R.styleable.IvmStatusView_warningColor);
      if (this.e == null)
        this.e = ColorStateList.valueOf(-65536);
      this.b = localTypedArray.getDrawable(R.styleable.IvmStatusView_playIcon);
      int i1 = localResources.getDimensionPixelSize(R.dimen.ivm_status_default_stroke_width);
      this.h = localTypedArray.getDimensionPixelSize(R.styleable.IvmStatusView_strokeWidth, i1);
      this.v = localTypedArray.getInt(R.styleable.IvmStatusView_videoShape, 0);
      localTypedArray.recycle();
      int[] arrayOfInt = getDrawableState();
      if (this.c != null)
        this.i.setColor(a(this.c, arrayOfInt));
      this.f = a(this.d, arrayOfInt);
      this.g = a(this.e, arrayOfInt);
      this.i.setStyle(Paint.Style.FILL);
      this.j.setStyle(Paint.Style.STROKE);
      this.j.setStrokeJoin(Paint.Join.ROUND);
      this.j.setStrokeCap(Paint.Cap.SQUARE);
      this.j.setStrokeWidth(this.h);
      this.k.setColor(ContextCompat.getColor(paramContext, R.color.ivm_player_error_icon));
      this.k.setStyle(Paint.Style.STROKE);
      this.k.setStrokeJoin(Paint.Join.ROUND);
      this.k.setStrokeCap(Paint.Cap.ROUND);
      this.k.setStrokeWidth(localResources.getDimensionPixelSize(R.dimen.ivm_error_arrow_width));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private void a(Canvas paramCanvas)
  {
    if ((this.c == null) || (!av.d(this.s, 2)))
      return;
    paramCanvas.drawPath(this.l, this.i);
  }

  private void b()
  {
    int i1 = 1;
    int i2;
    if (this.s != 0)
    {
      i2 = i1;
      this.s = 0;
      if (h())
        break label39;
    }
    while (true)
    {
      if ((i2 | i1) != 0)
        invalidate();
      return;
      i2 = 0;
      break;
      label39: i1 = 0;
    }
  }

  private void b(int paramInt1, int paramInt2)
  {
    h.e(paramInt1, paramInt2, this.n);
    this.n.computeBounds(this.r, true);
    this.p.reset();
    this.p.postTranslate(this.q.x - this.r.width() / 2.0F, this.q.y - this.r.height() / 2.0F);
    this.n.transform(this.p);
  }

  private void b(Canvas paramCanvas)
  {
    if ((this.b == null) || (!av.d(this.s, 1)))
      return;
    int i1 = this.b.getIntrinsicWidth();
    int i2 = this.b.getIntrinsicHeight();
    int i3 = Math.round(this.q.x - i1 / 2.0F);
    int i4 = Math.round(this.q.y - i2 / 2.0F);
    this.b.setBounds(i3, i4, i1 + i3, i2 + i4);
    this.b.draw(paramCanvas);
  }

  private void c()
  {
    int i1 = 1;
    int i2;
    if (this.s != 3)
    {
      i2 = i1;
      this.s = 3;
      if (h())
        break label40;
    }
    while (true)
    {
      if ((i2 | i1) != 0)
        invalidate();
      return;
      i2 = 0;
      break;
      label40: i1 = 0;
    }
  }

  private void c(Canvas paramCanvas)
  {
    float f1 = this.C * this.x / 100.0F;
    Object localObject;
    if (this.C == f1)
      localObject = this.l;
    while (true)
    {
      Paint localPaint;
      if (localObject != null)
      {
        localPaint = this.j;
        if (!av.d(this.s, 8))
          break label131;
      }
      label131: for (int i1 = this.g; ; i1 = this.f)
      {
        localPaint.setColor(i1);
        paramCanvas.drawPath((Path)localObject, this.j);
        return;
        if (f1 <= 0.0F)
          break label140;
        this.m.reset();
        boolean bool = this.o.getSegment(0.0F, f1, this.m, true);
        this.m.rLineTo(0.0F, 0.0F);
        Path localPath = null;
        if (bool)
          localPath = this.m;
        localObject = localPath;
        break;
      }
      label140: localObject = null;
    }
  }

  private void d()
  {
    int i1 = 1;
    int i2;
    if (this.s != 0)
    {
      i2 = i1;
      this.s = 0;
      if (i())
        break label39;
    }
    while (true)
    {
      if ((i2 | i1) != 0)
        invalidate();
      return;
      i2 = 0;
      break;
      label39: i1 = 0;
    }
  }

  private void d(Canvas paramCanvas)
  {
    if (!av.d(this.s, 4))
      return;
    int i1 = paramCanvas.save();
    paramCanvas.scale(this.z, this.z, this.q.x, this.q.y);
    paramCanvas.rotate(this.A, this.q.x, this.q.y);
    this.k.setAlpha(this.y);
    paramCanvas.drawPath(this.n, this.k);
    paramCanvas.restoreToCount(i1);
  }

  private void e()
  {
    int i1 = 1;
    int i2;
    if (this.s != 14)
    {
      i2 = i1;
      this.s = 14;
      if (h())
        break label42;
    }
    while (true)
    {
      if ((i2 | i1) != 0)
        k();
      return;
      i2 = 0;
      break;
      label42: i1 = 0;
    }
  }

  private void f()
  {
    if (this.w != 100)
    {
      j();
      this.w = 100;
      a(0.0F, 100.0F, c.a, this.t, this.u);
    }
  }

  private void g()
  {
    if (j())
    {
      this.w = 100;
      a(this.x, 100.0F, c.c, 150L, 0L);
      return;
    }
    h();
  }

  private boolean h()
  {
    int i1 = this.w;
    boolean bool = false;
    if (i1 != 100)
    {
      j();
      this.x = 100.0F;
      this.w = 100;
      invalidate();
      bool = true;
    }
    return bool;
  }

  private boolean i()
  {
    int i1 = this.w;
    boolean bool = false;
    if (i1 != 0)
    {
      j();
      this.s = av.f(this.s, 8);
      this.w = 0;
      this.x = 0.0F;
      invalidate();
      bool = true;
    }
    return bool;
  }

  private boolean j()
  {
    ValueAnimator localValueAnimator = this.E;
    boolean bool1 = false;
    if (localValueAnimator != null)
    {
      boolean bool2 = this.E.isRunning();
      bool1 = false;
      if (bool2)
      {
        this.E.cancel();
        this.E = null;
        bool1 = true;
      }
    }
    return bool1;
  }

  private void k()
  {
    l();
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 50, 255 });
    localValueAnimator1.addUpdateListener(new o(this));
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { -180.0F, 0.0F });
    localValueAnimator2.addUpdateListener(new p(this));
    ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { 0.4F, 1.0F });
    localValueAnimator3.addUpdateListener(new q(this));
    this.D = new AnimatorSet();
    this.D.playTogether(new Animator[] { localValueAnimator2, localValueAnimator3, localValueAnimator1 });
    this.D.setInterpolator(c.c);
    this.D.setDuration(300L);
    this.D.start();
  }

  private void l()
  {
    if ((this.D != null) && (this.D.isRunning()))
    {
      this.D.cancel();
      this.D = null;
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.w)
    {
      if (this.B != 4)
        setStatus(4);
      j();
      this.w = paramInt;
      if (paramBoolean)
        a(this.x, this.w, c.c, 150L, 0L);
    }
    else
    {
      return;
    }
    this.x = paramInt;
    invalidate();
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    this.f = a(this.d, arrayOfInt);
    this.g = a(this.e, arrayOfInt);
    this.i.setColor(a(this.c, arrayOfInt));
    if ((this.d != null) || (this.e != null) || (this.c != null))
      invalidate();
  }

  public ColorStateList getOverlayColor()
  {
    return this.c;
  }

  public Drawable getPlayIcon()
  {
    return this.b;
  }

  public int getProgress()
  {
    return this.w;
  }

  public long getRecordWarningDuration()
  {
    return this.u;
  }

  public long getRecordingDuration()
  {
    return this.t;
  }

  public int getShape()
  {
    return this.v;
  }

  public int getStatus()
  {
    return this.B;
  }

  public ColorStateList getStrokeColor()
  {
    return this.d;
  }

  public int getStrokeWidth()
  {
    return this.h;
  }

  public ColorStateList getWarningColor()
  {
    return this.e;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
    d(paramCanvas);
    c(paramCanvas);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.q.set(paramInt1 / 2.0F, paramInt2 / 2.0F);
    a(paramInt1, paramInt2);
    b(paramInt1, paramInt2);
  }

  public void setOverlayColor(ColorStateList paramColorStateList)
  {
    if (this.c != paramColorStateList)
    {
      this.c = paramColorStateList;
      if (paramColorStateList != null)
        this.i.setColor(a(paramColorStateList, getDrawableState()));
      if (av.d(this.s, 2))
        invalidate();
    }
  }

  public void setPlayIcon(Drawable paramDrawable)
  {
    if (this.b != paramDrawable)
    {
      this.b = paramDrawable;
      if (av.d(this.s, 1))
        invalidate();
    }
  }

  public void setRecordWarningDuration(long paramLong)
  {
    if (paramLong < this.t);
    while (true)
    {
      this.u = paramLong;
      return;
      paramLong = 0L;
    }
  }

  public void setRecordingDuration(long paramLong)
  {
    this.t = paramLong;
  }

  public void setShape(int paramInt)
  {
    if (this.v != paramInt)
    {
      this.v = paramInt;
      a(getWidth(), getHeight());
      invalidate();
    }
  }

  public void setStatus(int paramInt)
  {
    if (this.B == paramInt)
      return;
    int i1 = this.B;
    this.B = paramInt;
    switch (paramInt)
    {
    default:
      d();
      return;
    case 0:
      c();
      return;
    case 1:
      b();
      return;
    case 4:
      a();
      return;
    case 2:
      if (i1 == 3)
      {
        g();
        return;
      }
      d();
      return;
    case 3:
      d();
      f();
      return;
    case 5:
    }
    e();
  }

  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.d != paramColorStateList)
      if (paramColorStateList == null)
        break label44;
    while (true)
    {
      this.d = paramColorStateList;
      this.f = a(this.d, getDrawableState());
      if (this.w > 0)
        invalidate();
      return;
      label44: paramColorStateList = ColorStateList.valueOf(-1);
    }
  }

  public void setStrokeWidth(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      this.j.setStrokeWidth(paramInt);
      if (this.w > 0)
        invalidate();
    }
  }

  public void setWarningColor(ColorStateList paramColorStateList)
  {
    if (this.e != paramColorStateList)
      if (paramColorStateList == null)
        break label44;
    while (true)
    {
      this.e = paramColorStateList;
      this.g = a(this.e, getDrawableState());
      if (this.w > 0)
        invalidate();
      return;
      label44: paramColorStateList = ColorStateList.valueOf(-65536);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.IvmStatusView
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.View.MeasureSpec;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberEnv;

public class d extends View
{
  private static Logger a = ViberEnv.getLogger();
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private Paint g;
  private Paint h;
  private RectF i;
  private String j;
  private Rect k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private a q;
  private a r;
  private int s;

  public d(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void a()
  {
    this.f = getResources().getDimensionPixelSize(R.dimen.wink_progress_stroke_width);
    this.e = getResources().getColor(R.color.negative);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setStrokeWidth(this.f);
    this.g.setColor(this.e);
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setColor(this.e);
    this.h.setStrokeWidth(2.0F);
    this.i = new RectF();
    this.k = new Rect();
    this.o = true;
    this.q = a.a;
    this.r = a.a;
  }

  private void a(int paramInt)
  {
    int i1 = this.b;
    if ((this.q != a.a) && (this.r != a.a))
    {
      paramInt = (int)(paramInt * this.r.d / this.q.d);
      i1 = (int)(this.b * this.r.d / this.q.d);
    }
    if (this.s != paramInt)
    {
      this.s = paramInt;
      this.j = String.valueOf(Math.min(this.c + this.s, i1));
    }
  }

  private void b()
  {
    this.h.setColor(this.e);
    this.g.setColor(this.e);
  }

  public void a(int paramInt, a parama)
  {
    this.b = paramInt;
    this.r = parama;
  }

  public void a(Canvas paramCanvas)
  {
    this.h.getTextBounds(this.j, 0, this.j.length(), this.k);
    paramCanvas.drawText(this.j, this.m - this.k.exactCenterX(), this.l - this.k.exactCenterY(), this.h);
  }

  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1;
    if (this.p)
    {
      i1 = -90;
      if (!this.p)
        break label75;
    }
    label75: for (int i2 = -360 + this.n; ; i2 = this.n)
    {
      paramCanvas.drawArc(this.i, i1, i2, false, this.g);
      if ((this.o) && (this.j != null))
        a(paramCanvas);
      return;
      i1 = 270;
      break;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    this.m = (i1 / 2);
    this.l = (i2 / 2);
    int i3 = (Math.min(i1, i2) - this.f) / 2;
    this.h.setTextSize(i3);
    this.i.set(this.f, this.f, i1 - this.f, i2 - this.f);
  }

  public void setColor(int paramInt)
  {
    this.e = paramInt;
    b();
  }

  public void setInvertedProgress(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setMax(int paramInt)
  {
    a(paramInt, a.a);
  }

  public void setMin(int paramInt)
  {
    this.c = paramInt;
  }

  public void setProgress(int paramInt)
  {
    if (this.b == 0)
      return;
    if (this.p);
    for (int i1 = Math.min(this.b - paramInt, this.b); ; i1 = Math.min(paramInt, this.b))
    {
      this.d = i1;
      this.n = (360 * (100 * this.d / this.b) / 100);
      if (this.o)
        a(paramInt);
      invalidate();
      return;
    }
  }

  public void setTextDisplayUnit(a parama)
  {
    this.q = parama;
  }

  public static enum a
  {
    long d;

    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }

    private a(long paramLong)
    {
      this.d = paramLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.d
 * JD-Core Version:    0.6.2
 */
package com.d.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends LinearLayout
{
  private final Rect A = new Rect();
  private boolean B;
  private boolean C;
  private boolean D = true;
  private boolean E = true;
  protected final Paint a;
  protected e b;
  private String[] c;
  private String[] d;
  private String e;
  private boolean f;
  private boolean g;
  private double h;
  private double i;
  private final View j;
  private com.d.a.a.b k;
  private boolean l;
  private final NumberFormat[] m = new NumberFormat[2];
  private final List<d> n;
  private boolean o = false;
  private c p = c.b;
  private boolean q;
  private boolean r;
  private boolean s;
  private double t;
  private double u;
  private final a v;
  private a w;
  private Integer x;
  private Integer y;
  private Integer z;

  public b(Context paramContext, String paramString)
  {
    super(paramContext);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    if (paramString == null);
    for (this.e = ""; ; this.e = paramString)
    {
      this.b = new e();
      this.b.a(paramContext);
      this.a = new Paint();
      this.n = new ArrayList();
      this.j = new d(paramContext);
      addView(this.j);
      this.v = new a(paramContext);
      addView(this.v, new LinearLayout.LayoutParams(-1, -1, 1.0F));
      return;
    }
  }

  private c[] a(int paramInt)
  {
    while (true)
    {
      ArrayList localArrayList;
      int i1;
      synchronized (((d)this.n.get(paramInt)).c)
      {
        if ((this.h == 0.0D) && (this.i == 0.0D))
          return ???;
        localArrayList = new ArrayList();
        i1 = 0;
        if (i1 < ???.length)
        {
          if (???[i1].a() < this.h)
            break label158;
          if (???[i1].a() > this.h + this.i)
            localArrayList.add(???[i1]);
        }
        else
        {
          c[] arrayOfc2 = (c[])localArrayList.toArray(new c[localArrayList.size()]);
          return arrayOfc2;
        }
      }
      localArrayList.add(???[i1]);
      break label196;
      label158: if (localArrayList.isEmpty())
        localArrayList.add(???[i1]);
      localArrayList.set(0, ???[i1]);
      label196: i1++;
    }
  }

  private String[] a(float paramFloat)
  {
    int i1 = 0;
    int i2 = -1 + getGraphViewStyle().h();
    if (i2 < 0)
    {
      if (paramFloat <= 0.0F)
        paramFloat = 1.0F;
      i2 = (int)(paramFloat / (2 * this.y.intValue()));
    }
    String[] arrayOfString = new String[i2 + 1];
    double d1 = b(false);
    double d2 = a(false);
    while (i1 <= i2)
    {
      arrayOfString[i1] = a(d1 + (d2 - d1) * i1 / i2, true);
      i1++;
    }
    return arrayOfString;
  }

  private String[] b(float paramFloat)
  {
    double d1 = 0.0D;
    while (true)
    {
      double d2;
      try
      {
        int i1 = -1 + getGraphViewStyle().i();
        if (i1 < 0)
        {
          if (paramFloat <= 0.0F)
            paramFloat = 1.0F;
          i1 = (int)(paramFloat / (3 * this.x.intValue()));
          if (i1 == 0)
            Log.w("GraphView", "Height of Graph is smaller than the label text height, so no vertical labels were shown!");
        }
        int i2 = i1;
        String[] arrayOfString = new String[i2 + 1];
        d2 = getMinY();
        double d3 = getMaxY();
        if (d3 == d2)
        {
          if (d3 == d1)
          {
            d3 = 1.0D;
            break label175;
            if (i3 <= i2)
            {
              arrayOfString[(i2 - i3)] = a(d1 + (d3 - d1) * i3 / i2, false);
              i3++;
              continue;
            }
          }
          else
          {
            d3 *= 1.05D;
            d1 = 0.95D * d2;
            break label175;
          }
          return arrayOfString;
        }
      }
      finally
      {
      }
      d1 = d2;
      label175: int i3 = 0;
    }
  }

  protected double a(boolean paramBoolean)
  {
    double d1 = 0.0D;
    if ((!paramBoolean) && (this.i != d1))
      d1 = this.h + this.i;
    while (this.n.size() <= 0)
      return d1;
    c[] arrayOfc1 = ((d)this.n.get(0)).c;
    if (arrayOfc1.length == 0);
    for (double d2 = d1; ; d2 = arrayOfc1[(-1 + arrayOfc1.length)].a())
    {
      d1 = d2;
      for (int i1 = 1; i1 < this.n.size(); i1++)
      {
        c[] arrayOfc2 = ((d)this.n.get(i1)).c;
        if (arrayOfc2.length > 0)
          d1 = Math.max(d1, arrayOfc2[(-1 + arrayOfc2.length)].a());
      }
      break;
    }
  }

  @Deprecated
  protected String a(double paramDouble, boolean paramBoolean)
  {
    if (this.w != null)
    {
      String str = this.w.a(paramDouble, paramBoolean);
      if (str != null)
        return str;
    }
    int i1;
    double d1;
    label66: double d2;
    if (paramBoolean)
    {
      i1 = 1;
      if (this.m[i1] == null)
      {
        this.m[i1] = NumberFormat.getNumberInstance();
        if (!paramBoolean)
          break label119;
        d1 = a(false);
        if (!paramBoolean)
          break label128;
        d2 = b(false);
        label77: if (d1 - d2 >= 0.1D)
          break label137;
        this.m[i1].setMaximumFractionDigits(6);
      }
    }
    while (true)
    {
      return this.m[i1].format(paramDouble);
      i1 = 0;
      break;
      label119: d1 = getMaxY();
      break label66;
      label128: d2 = getMinY();
      break label77;
      label137: if (d1 - d2 < 1.0D)
        this.m[i1].setMaximumFractionDigits(4);
      else if (d1 - d2 < 20.0D)
        this.m[i1].setMaximumFractionDigits(3);
      else if (d1 - d2 < 100.0D)
        this.m[i1].setMaximumFractionDigits(1);
      else
        this.m[i1].setMaximumFractionDigits(0);
    }
  }

  public void a(double paramDouble1, double paramDouble2)
  {
    if (paramDouble2 < 0.0D)
      throw new IllegalArgumentException("Viewport size must be greater than 0!");
    this.h = paramDouble1;
    this.i = paramDouble2;
  }

  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    float f1 = this.a.getTextSize();
    int i1 = getGraphViewStyle().e();
    int i2 = getGraphViewStyle().d();
    int i3 = getGraphViewStyle().f();
    int i4 = (int)(0.8D * f1);
    this.a.setARGB(180, 100, 100, 100);
    float f2 = (i4 + i1) * this.n.size() + i2 * 2 - i1;
    float f3 = paramFloat2 - i3 - i2 * 2;
    float f4;
    switch (2.a[this.p.ordinal()])
    {
    default:
      f4 = paramFloat1 - 20.0F - f2 - getGraphViewStyle().g();
    case 1:
    case 2:
    }
    while (true)
    {
      paramCanvas.drawRoundRect(new RectF(f3, f4, f3 + i3, f4 + f2), 8.0F, 8.0F, this.a);
      for (int i5 = 0; i5 < this.n.size(); i5++)
      {
        this.a.setColor(((d)this.n.get(i5)).b.a);
        paramCanvas.drawRect(new RectF(f3 + i2, f4 + i2 + i5 * (i4 + i1), f3 + i2 + i4, f4 + i2 + i5 * (i4 + i1) + i4), this.a);
        if (((d)this.n.get(i5)).a != null)
        {
          this.a.setColor(-1);
          this.a.setTextAlign(Paint.Align.LEFT);
          paramCanvas.drawText(((d)this.n.get(i5)).a, f3 + i2 + i4 + i1, f4 + i2 + i4 + i5 * (i4 + i1), this.a);
        }
      }
      f4 = 0.0F;
      continue;
      f4 = paramFloat1 / 2.0F - f2 / 2.0F;
    }
  }

  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, String[] paramArrayOfString, float paramFloat4)
  {
    int i1 = -1 + paramArrayOfString.length;
    for (int i2 = 0; i2 < paramArrayOfString.length; i2++)
    {
      this.a.setColor(this.b.a());
      float f1 = paramFloat2 + paramFloat4 / i1 * i2;
      if (this.b.b().a())
        paramCanvas.drawLine(f1, paramFloat3 - paramFloat1, f1, paramFloat1, this.a);
      if (this.D)
      {
        this.a.setTextAlign(Paint.Align.CENTER);
        if (i2 == -1 + paramArrayOfString.length)
          this.a.setTextAlign(Paint.Align.RIGHT);
        if (i2 == 0)
          this.a.setTextAlign(Paint.Align.LEFT);
        this.a.setColor(this.b.c());
        String[] arrayOfString = paramArrayOfString[i2].split("\n");
        for (int i3 = 0; i3 < arrayOfString.length; i3++)
        {
          float f2 = paramFloat3 - 4.0F - 1.1F * ((-1 + (arrayOfString.length - i3)) * this.b.j());
          paramCanvas.drawText(arrayOfString[i3], f1, f2, this.a);
        }
      }
    }
  }

  protected abstract void a(Canvas paramCanvas, c[] paramArrayOfc, float paramFloat1, float paramFloat2, float paramFloat3, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat4, d.a parama);

  public void a(d paramd)
  {
    paramd.a(this);
    this.n.add(paramd);
    c();
  }

  public boolean a()
  {
    return this.g;
  }

  protected double b(boolean paramBoolean)
  {
    double d1 = 0.0D;
    if ((!paramBoolean) && (this.i != d1))
      d1 = this.h;
    while (this.n.size() <= 0)
      return d1;
    c[] arrayOfc1 = ((d)this.n.get(0)).c;
    if (arrayOfc1.length == 0);
    for (double d2 = d1; ; d2 = arrayOfc1[0].a())
    {
      d1 = d2;
      for (int i1 = 1; i1 < this.n.size(); i1++)
      {
        c[] arrayOfc2 = ((d)this.n.get(i1)).c;
        if (arrayOfc2.length > 0)
          d1 = Math.min(d1, arrayOfc2[0].a());
      }
      break;
    }
  }

  public boolean b()
  {
    return this.f;
  }

  public void c()
  {
    if (!this.C)
      this.d = null;
    if (!this.B)
      this.c = null;
    this.m[0] = null;
    this.m[1] = null;
    this.x = null;
    this.y = null;
    this.z = null;
    invalidate();
    this.j.invalidate();
    this.v.invalidate();
  }

  public void d()
  {
    if (!this.f)
      throw new IllegalStateException("This GraphView is not scrollable.");
    this.h = (a(true) - this.i);
    if (!this.C)
      this.d = null;
    if (!this.B)
      this.c = null;
    invalidate();
    this.j.invalidate();
    this.v.invalidate();
  }

  public a getCustomLabelFormatter()
  {
    return this.w;
  }

  public e getGraphViewStyle()
  {
    return this.b;
  }

  public c getLegendAlign()
  {
    return this.p;
  }

  @Deprecated
  public float getLegendWidth()
  {
    return getGraphViewStyle().f();
  }

  protected double getMaxY()
  {
    if ((this.q) || (this.r))
    {
      d1 = this.t;
      return d1;
    }
    double d1 = -2147483648.0D;
    int i1 = 0;
    label27: c[] arrayOfc;
    int i2;
    if (i1 < this.n.size())
    {
      arrayOfc = a(i1);
      i2 = 0;
      label50: if (i2 < arrayOfc.length)
        if (arrayOfc[i2].b() <= d1)
          break label100;
    }
    label100: for (double d2 = arrayOfc[i2].b(); ; d2 = d1)
    {
      i2++;
      d1 = d2;
      break label50;
      i1++;
      break label27;
      break;
    }
  }

  protected double getMinY()
  {
    if ((this.q) || (this.s))
    {
      d1 = this.u;
      return d1;
    }
    double d1 = 2147483647.0D;
    int i1 = 0;
    label27: c[] arrayOfc;
    int i2;
    if (i1 < this.n.size())
    {
      arrayOfc = a(i1);
      i2 = 0;
      label50: if (i2 < arrayOfc.length)
        if (arrayOfc[i2].b() >= d1)
          break label100;
    }
    label100: for (double d2 = arrayOfc[i2].b(); ; d2 = d1)
    {
      i2++;
      d1 = d2;
      break label50;
      i1++;
      break label27;
      break;
    }
  }

  public boolean getShowHorizontalLabels()
  {
    return this.D;
  }

  public boolean getShowVerticalLabels()
  {
    return this.E;
  }

  public double getViewportSize()
  {
    return this.i;
  }

  public void setCustomLabelFormatter(a parama)
  {
    this.w = parama;
  }

  public void setDisableTouch(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public void setGraphViewStyle(e parame)
  {
    this.b = parame;
    this.x = null;
  }

  public void setHorizontalLabels(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null);
    for (boolean bool = true; ; bool = false)
    {
      this.B = bool;
      this.c = paramArrayOfString;
      return;
    }
  }

  public void setLegendAlign(c paramc)
  {
    this.p = paramc;
  }

  @Deprecated
  public void setLegendWidth(float paramFloat)
  {
    getGraphViewStyle().b((int)paramFloat);
  }

  public void setManualMaxY(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public void setManualMinY(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public void setManualYAxis(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public void setManualYMaxBound(double paramDouble)
  {
    this.t = paramDouble;
    this.r = true;
  }

  public void setManualYMinBound(double paramDouble)
  {
    this.u = paramDouble;
    this.s = true;
  }

  public void setScalable(boolean paramBoolean)
  {
    try
    {
      this.l = paramBoolean;
      if ((paramBoolean == true) && (this.k == null))
      {
        this.f = true;
        this.k = new com.d.a.a.b(getContext(), new com.d.a.a.b.a()
        {
        });
      }
      return;
    }
    finally
    {
    }
  }

  public void setScrollable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public void setShowHorizontalLabels(boolean paramBoolean)
  {
    this.D = paramBoolean;
    c();
  }

  public void setShowLegend(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public void setShowVerticalLabels(boolean paramBoolean)
  {
    this.E = paramBoolean;
    if (this.E)
    {
      addView(this.j, 0);
      return;
    }
    removeView(this.j);
  }

  public void setTitle(String paramString)
  {
    this.e = paramString;
  }

  public void setVerticalLabels(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null);
    for (boolean bool = true; ; bool = false)
    {
      this.C = bool;
      this.d = paramArrayOfString;
      return;
    }
  }

  private class a extends View
  {
    private float b;
    private float c;
    private boolean d;

    public a(Context arg2)
    {
      super();
      setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    private void a(float paramFloat)
    {
      double d2;
      if (b.i(b.this) != 0.0D)
      {
        b.a(b.this, paramFloat * b.i(b.this) / this.c);
        double d1 = b.this.b(true);
        d2 = b.this.a(true);
        if (b.j(b.this) >= d1)
          break label132;
        b.b(b.this, d1);
      }
      while (true)
      {
        if (!b.k(b.this))
          b.a(b.this, null);
        if (!b.l(b.this))
          b.b(b.this, null);
        b.m(b.this).invalidate();
        invalidate();
        return;
        label132: if (b.j(b.this) + b.i(b.this) > d2)
          b.b(b.this, d2 - b.i(b.this));
      }
    }

    protected void onDraw(Canvas paramCanvas)
    {
      b.this.a.setAntiAlias(true);
      b.this.a.setStrokeWidth(0.0F);
      float f1 = getHeight();
      float f2 = -1 + getWidth();
      double d1 = b.this.getMaxY();
      double d2 = b.this.getMinY();
      double d3 = b.this.a(false);
      double d4 = b.this.b(false);
      double d5 = d3 - d4;
      if ((b.a(b.this) == null) || (b.b(b.this) == null))
      {
        b.this.a.setTextSize(b.this.getGraphViewStyle().j());
        double d6 = 0.783D * (b.this.a(true) - b.this.b(true)) + b.this.b(true);
        String str = b.this.a(d6, true);
        b.this.a.getTextBounds(str, 0, str.length(), b.c(b.this));
        byte[] arrayOfByte = str.getBytes();
        int i = arrayOfByte.length;
        int j = 1;
        for (int k = 0; k < i; k++)
          if (arrayOfByte[k] == 10)
            j++;
        b.a(b.this, Integer.valueOf(j * b.c(b.this).height()));
        b.b(b.this, Integer.valueOf(b.c(b.this).width()));
      }
      float f3 = 20.0F + b.a(b.this).intValue();
      float f4 = f1 - 2.0F * f3;
      this.c = f2;
      if (b.d(b.this) == null)
      {
        b.a(b.this, b.a(b.this, this.c));
        if (b.e(b.this) != null)
          break label503;
        b.b(b.this, b.b(b.this, f4));
      }
      while (true)
      {
        if (!b.this.b.b().b())
          break label527;
        b.this.a.setTextAlign(Paint.Align.LEFT);
        int n = -1 + b.e(b.this).length;
        for (int i1 = 0; i1 < b.e(b.this).length; i1++)
        {
          b.this.a.setColor(b.this.b.a());
          float f5 = f3 + f4 / n * i1;
          paramCanvas.drawLine(0.0F, f5, f2, f5, b.this.a);
        }
        if (b.this.getGraphViewStyle().h() <= 0)
          break;
        Log.w("GraphView", "when you use static labels (via setHorizontalLabels) the labels will just be shown exactly in that way, that you have set it. setNumHorizontalLabels does not have any effect.");
        break;
        label503: if (b.this.getGraphViewStyle().i() > 0)
          Log.w("GraphView", "when you use static labels (via setVerticalLabels) the labels will just be shown exactly in that way, that you have set it. setNumVerticalLabels does not have any effect.");
      }
      label527: b.this.a(paramCanvas, f3, 0.0F, f1, b.d(b.this), this.c);
      b.this.a.setColor(b.this.b.c());
      b.this.a.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(b.f(b.this), 0.0F + this.c / 2.0F, f3 - 4.0F, b.this.a);
      double d7;
      if (d1 == d2)
        if (d1 == 0.0D)
        {
          d7 = 1.0D;
          d2 = 0.0D;
        }
      while (true)
      {
        double d8 = d7 - d2;
        b.this.a.setStrokeCap(Paint.Cap.ROUND);
        int m = 0;
        while (true)
          if (m < b.g(b.this).size())
          {
            b.this.a(paramCanvas, b.a(b.this, m), this.c, f4, f3, d4, d2, d5, d8, 0.0F, ((d)b.g(b.this).get(m)).b);
            m++;
            continue;
            d7 = 1.05D * d1;
            d2 *= 0.95D;
            break;
          }
        if (b.h(b.this))
          b.this.a(paramCanvas, f1, f2);
        return;
        d7 = d1;
      }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((!b.this.b()) || (b.this.a()))
      {
        bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      if ((b.n(b.this)) && (b.o(b.this) != null))
        b.o(b.this).a(paramMotionEvent);
      for (boolean bool = b.o(b.this).a(); ; bool = false)
      {
        if (!bool)
        {
          if (((0x0 & paramMotionEvent.getAction()) == 0) && ((0x2 & paramMotionEvent.getAction()) == 0))
          {
            this.d = true;
            bool = true;
          }
          if ((0x1 & paramMotionEvent.getAction()) == 1)
          {
            this.d = false;
            this.b = 0.0F;
            bool = true;
          }
          if (((0x2 & paramMotionEvent.getAction()) == 2) && (this.d))
          {
            if (this.b != 0.0F)
              a(paramMotionEvent.getX() - this.b);
            this.b = paramMotionEvent.getX();
            bool = true;
          }
          if (!bool)
            break;
          invalidate();
          return bool;
        }
        this.d = false;
        this.b = 0.0F;
        return bool;
      }
    }
  }

  public static class b
    implements c
  {
    public final double a;
    public final double b;

    public b(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }

    public double a()
    {
      return this.a;
    }

    public double b()
    {
      return this.b;
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[3];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
    }
  }

  private class d extends View
  {
    public d(Context arg2)
    {
      super();
      if (b.this.getGraphViewStyle().m() == 0);
      for (int i = 100; ; i = b.this.getGraphViewStyle().m())
      {
        setLayoutParams(new LinearLayout.LayoutParams(i, -1));
        return;
      }
    }

    protected void onDraw(Canvas paramCanvas)
    {
      b.this.a.setStrokeWidth(0.0F);
      if ((b.a(b.this) == null) || (b.p(b.this) == null))
      {
        b.this.a.setTextSize(b.this.getGraphViewStyle().j());
        double d = 0.783D * (b.this.getMaxY() - b.this.getMinY()) + b.this.getMinY();
        String str = b.this.a(d, false);
        b.this.a.getTextBounds(str, 0, str.length(), b.c(b.this));
        b.a(b.this, Integer.valueOf(b.c(b.this).height()));
        b.c(b.this, Integer.valueOf(b.c(b.this).width()));
      }
      float f1;
      float f2;
      label278: int i;
      if ((b.this.getGraphViewStyle().m() == 0) && (getLayoutParams().width != 20.0F + b.p(b.this).intValue()))
      {
        setLayoutParams(new LinearLayout.LayoutParams((int)(20.0F + b.p(b.this).intValue()), -1));
        f1 = 20.0F + b.a(b.this).intValue();
        f2 = getHeight() - 2.0F * f1;
        if (b.e(b.this) != null)
          break label524;
        b.b(b.this, b.b(b.this, f2));
        b.this.a.setTextAlign(b.this.getGraphViewStyle().k());
        i = getWidth();
        if (b.this.getGraphViewStyle().k() != Paint.Align.RIGHT)
          break label548;
      }
      while (true)
      {
        label320: int j = -1 + b.e(b.this).length;
        for (int k = 0; ; k++)
        {
          if (k >= b.e(b.this).length)
            break label579;
          float f3 = f1 + f2 / j * k;
          b.this.a.setColor(b.this.b.l());
          String[] arrayOfString = b.e(b.this)[k].split("\n");
          int m = 0;
          while (true)
            if (m < arrayOfString.length)
            {
              float f4 = f3 - 1.1F * ((-1 + (arrayOfString.length - m)) * b.this.b.j());
              paramCanvas.drawText(arrayOfString[m], i, f4, b.this.a);
              m++;
              continue;
              if ((b.this.getGraphViewStyle().m() == 0) || (b.this.getGraphViewStyle().m() == getLayoutParams().width))
                break;
              setLayoutParams(new LinearLayout.LayoutParams(b.this.getGraphViewStyle().m(), -1));
              break;
              label524: if (b.this.getGraphViewStyle().i() <= 0)
                break label278;
              Log.w("GraphView", "when you use static labels (via setVerticalLabels) the labels will just be shown exactly in that way, that you have set it. setNumVerticalLabels does not have any effect.");
              break label278;
              label548: if (b.this.getGraphViewStyle().k() != Paint.Align.CENTER)
                break label593;
              i /= 2;
              break label320;
            }
        }
        label579: b.this.a.setTextAlign(Paint.Align.LEFT);
        return;
        label593: i = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.d.a.b
 * JD-Core Version:    0.6.2
 */
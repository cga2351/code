package com.viber.voip.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import com.viber.common.d.a;
import com.viber.voip.R.styleable;
import com.viber.voip.stickers.ui.d;

public class aa extends d
{
  private Path a;
  private Paint b;
  private int c = 0;
  private int d;
  private a e;

  public aa(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0;
    case 1:
      return 1;
    case 2:
    }
    return 2;
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new Path();
    this.b = new Paint(3);
    if (a.n())
      this.e = new b();
    while (true)
    {
      this.b.setXfermode(this.e.a());
      TypedArray localTypedArray;
      if (paramAttributeSet != null)
        localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundCornersKeyboardGrid);
      try
      {
        this.c = a(localTypedArray.getInt(R.styleable.RoundCornersKeyboardGrid_roundMode, 0));
        this.d = localTypedArray.getDimensionPixelSize(R.styleable.RoundCornersKeyboardGrid_cornerRadius, 0);
        return;
        this.e = new a();
      }
      finally
      {
        localTypedArray.recycle();
      }
    }
  }

  private void c()
  {
    if (d())
      invalidate();
  }

  private boolean d()
  {
    int i = getWidth();
    int j = getHeight();
    if ((i > 0) && (j > 0))
    {
      this.e.a(this.a, this.c, i, j);
      return true;
    }
    return false;
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    super.draw(paramCanvas);
    paramCanvas.drawPath(this.a, this.b);
    paramCanvas.restore();
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }

  public void setCornerRadiusPx(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      c();
    }
  }

  public void setRoundMode(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      c();
    }
  }

  class a
  {
    private RectF b = new RectF();
    private float[] c = new float[8];

    a()
    {
    }

    Xfermode a()
    {
      return new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    void a(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPath.reset();
      this.b.set(0.0F, 0.0F, paramInt2, paramInt3);
      switch (aa.a(aa.this))
      {
      default:
        return;
      case 0:
        paramPath.addRoundRect(this.b, aa.b(aa.this), aa.b(aa.this), Path.Direction.CW);
        return;
      case 1:
        float[] arrayOfFloat8 = this.c;
        float[] arrayOfFloat9 = this.c;
        float[] arrayOfFloat10 = this.c;
        float[] arrayOfFloat11 = this.c;
        float f2 = aa.b(aa.this);
        arrayOfFloat11[7] = f2;
        arrayOfFloat10[6] = f2;
        arrayOfFloat9[1] = f2;
        arrayOfFloat8[0] = f2;
        float[] arrayOfFloat12 = this.c;
        float[] arrayOfFloat13 = this.c;
        float[] arrayOfFloat14 = this.c;
        this.c[5] = 0.0F;
        arrayOfFloat14[4] = 0.0F;
        arrayOfFloat13[3] = 0.0F;
        arrayOfFloat12[2] = 0.0F;
        paramPath.addRoundRect(this.b, this.c, Path.Direction.CW);
        return;
      case 2:
      }
      float[] arrayOfFloat1 = this.c;
      float[] arrayOfFloat2 = this.c;
      float[] arrayOfFloat3 = this.c;
      this.c[7] = 0.0F;
      arrayOfFloat3[6] = 0.0F;
      arrayOfFloat2[1] = 0.0F;
      arrayOfFloat1[0] = 0.0F;
      float[] arrayOfFloat4 = this.c;
      float[] arrayOfFloat5 = this.c;
      float[] arrayOfFloat6 = this.c;
      float[] arrayOfFloat7 = this.c;
      float f1 = aa.b(aa.this);
      arrayOfFloat7[5] = f1;
      arrayOfFloat6[4] = f1;
      arrayOfFloat5[3] = f1;
      arrayOfFloat4[2] = f1;
      paramPath.addRoundRect(this.b, this.c, Path.Direction.CW);
    }
  }

  @TargetApi(28)
  class b extends aa.a
  {
    private Region c = new Region();
    private Region d = new Region();

    b()
    {
      super();
    }

    public Xfermode a()
    {
      return new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    public void a(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
    {
      super.a(paramPath, paramInt1, paramInt2, paramInt3);
      this.c.set(0, 0, paramInt2, paramInt3);
      this.d.setPath(paramPath, this.c);
      this.c.op(this.d, Region.Op.DIFFERENCE);
      paramPath.reset();
      this.c.getBoundaryPath(paramPath);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.aa
 * JD-Core Version:    0.6.2
 */
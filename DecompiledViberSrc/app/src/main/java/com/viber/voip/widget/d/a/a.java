package com.viber.voip.widget.d.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.viber.common.d.h;
import com.viber.voip.widget.d.c;

public class a extends c
  implements com.viber.voip.widget.d.a
{
  private Path a;
  private Paint b;
  private int c;
  private int d;
  private int e;

  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    setShape(1);
    this.d = paramInt1;
    this.e = paramInt2;
    c();
  }

  private void c()
  {
    this.a = new Path();
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }

  public boolean a()
  {
    return false;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.c != 0)
    {
      paramCanvas.drawPath(this.a, this.b);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }

  public float getAspectRatio()
  {
    return this.d / this.e;
  }

  public View getView()
  {
    return this;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = 0.0F;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    switch (this.c)
    {
    default:
      return;
    case 1:
      float f4 = paramInt1 / 2.0F;
      float f5 = paramInt2 / 2.0F;
      if (paramInt1 > paramInt2);
      while (true)
      {
        float f6 = paramInt2 / 2.0F;
        this.a.reset();
        this.a.addCircle(f4, f5, f6, Path.Direction.CW);
        return;
        paramInt2 = paramInt1;
      }
    case 2:
      float f2;
      if (paramInt1 > paramInt2)
        f2 = paramInt2;
      for (float f3 = (paramInt1 - paramInt2) / 2.0F; ; f3 = 0.0F)
      {
        h.b(f2, f2, f3, f1, this.a);
        return;
        f2 = paramInt1;
        f1 = (paramInt2 - paramInt1) / 2.0F;
      }
    case 0:
    }
    this.a.reset();
  }

  public void setShape(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      invalidate();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.d.a.a
 * JD-Core Version:    0.6.2
 */
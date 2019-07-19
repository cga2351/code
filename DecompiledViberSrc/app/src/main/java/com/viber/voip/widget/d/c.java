package com.viber.voip.widget.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.viber.common.d.h;
import org.webrtc.SurfaceViewRenderer;

public class c extends SurfaceViewRenderer
  implements a
{
  private Path a;
  private Paint b;
  private int c;

  public c(Context paramContext)
  {
    super(paramContext);
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
    return true;
  }

  public boolean b()
  {
    return b.a(this);
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
    return 1.0F;
  }

  public View getView()
  {
    return this;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    switch (this.c)
    {
    default:
      return;
    case 1:
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      if (paramInt1 > paramInt2);
      while (true)
      {
        float f3 = paramInt2 / 2.0F;
        this.a.reset();
        this.a.addCircle(f1, f2, f3, Path.Direction.CW);
        return;
        paramInt2 = paramInt1;
      }
    case 2:
      h.d(paramInt1, paramInt2, this.a);
      return;
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
 * Qualified Name:     com.viber.voip.widget.d.c
 * JD-Core Version:    0.6.2
 */
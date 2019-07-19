package com.viber.voip.widget.animated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.viber.common.d.h;
import com.viber.voip.ui.call.a.d;

public class b
{
  private Path[] a = new Path[4];
  private Paint[] b = new Paint[4];
  private Rect c = new Rect();
  private Paint d;
  private int[] e = { 4, 10, 6, 12 };
  private int[] f = { -1973791, -1315861, -592138, -592138 };
  private com.viber.voip.ui.call.a.b[] g;
  private d h;

  public b()
  {
    com.viber.voip.ui.call.a.b[] arrayOfb = new com.viber.voip.ui.call.a.b[4];
    arrayOfb[0] = new com.viber.voip.ui.call.a.b(0.0F, 1.0F, new float[] { 0.0F, 1.0F }, new float[] { 255.0F, 255.0F });
    arrayOfb[1] = new com.viber.voip.ui.call.a.b(0.0F, 1.0F, new float[] { 0.0F, 0.1666667F, 0.8333334F, 1.0F }, new float[] { 0.0F, 255.0F, 255.0F, 0.0F });
    arrayOfb[2] = new com.viber.voip.ui.call.a.b(0.0F, 1.0F, new float[] { 0.1666667F, 0.3333333F, 0.6666667F, 0.8333334F }, new float[] { 0.0F, 255.0F, 255.0F, 0.0F });
    arrayOfb[3] = new com.viber.voip.ui.call.a.b(0.0F, 1.0F, new float[] { 0.3333333F, 0.5F, 0.6666667F }, new float[] { 0.0F, 255.0F, 0.0F });
    this.g = arrayOfb;
    this.h = new d(1800L, this.g);
    this.d = new Paint(5);
    this.d.setStyle(Paint.Style.STROKE);
    this.h.a(d.a);
    this.h.c();
  }

  private int a(int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    int k = 0;
    while (i < j)
    {
      k += paramArrayOfInt[i];
      i++;
    }
    return k;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = paramInt1 - (paramInt3 + paramInt5) / 2;
    int j = paramInt2 - (paramInt4 + paramInt6) / 2;
    this.c.set(paramInt3, paramInt4, i, j);
    int k = a(this.e);
    for (int m = 0; m < this.e.length; m++)
    {
      if (this.b[m] == null)
      {
        this.b[m] = new Paint(this.d);
        this.b[m].setShadowLayer(3.0F, 0.0F, 0.0F, this.f[m]);
        this.b[m].setColor(this.f[m]);
      }
      int n = (int)(this.e[m] / k * paramInt4);
      this.b[m].setStrokeWidth(n);
      if (this.a[m] == null)
        this.a[m] = new Path();
      this.c.inset(-n / 2, -n / 2);
      Path localPath = this.a[m];
      localPath.reset();
      h.a(this.c.width(), this.c.height(), this.c.left, this.c.top, localPath);
      this.c.inset(-n / 2, -n / 2);
    }
  }

  public void a(Canvas paramCanvas)
  {
    this.h.a(System.currentTimeMillis());
    for (int i = 0; i < this.a.length; i++)
    {
      this.b[i].setAlpha((int)this.g[i].c);
      paramCanvas.drawPath(this.a[i], this.b[i]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.animated.b
 * JD-Core Version:    0.6.2
 */
package com.BV.LinearGradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;

public class b extends View
{
  private final Paint a = new Paint(1);
  private Path b;
  private RectF c;
  private LinearGradient d;
  private float[] e;
  private float[] f = { 0.0F, 0.0F };
  private float[] g = { 0.0F, 1.0F };
  private int[] h;
  private int[] i = { 0, 0 };
  private float[] j = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };

  public b(Context paramContext)
  {
    super(paramContext);
  }

  private void a()
  {
    if ((this.h == null) || ((this.e != null) && (this.h.length != this.e.length)))
      return;
    this.d = new LinearGradient(this.f[0] * this.i[0], this.f[1] * this.i[1], this.g[0] * this.i[0], this.g[1] * this.i[1], this.h, this.e, Shader.TileMode.CLAMP);
    this.a.setShader(this.d);
    invalidate();
  }

  private void b()
  {
    if (this.b == null)
    {
      this.b = new Path();
      this.c = new RectF();
    }
    this.b.reset();
    this.c.set(0.0F, 0.0F, this.i[0], this.i[1]);
    this.b.addRoundRect(this.c, this.j, Path.Direction.CW);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b == null)
    {
      paramCanvas.drawPaint(this.a);
      return;
    }
    paramCanvas.drawPath(this.b, this.a);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = new int[] { paramInt1, paramInt2 };
    b();
    a();
  }

  public void setBorderRadii(ReadableArray paramReadableArray)
  {
    float[] arrayOfFloat = new float[paramReadableArray.size()];
    for (int k = 0; k < arrayOfFloat.length; k++)
      arrayOfFloat[k] = PixelUtil.toPixelFromDIP((float)paramReadableArray.getDouble(k));
    this.j = arrayOfFloat;
    b();
    a();
  }

  public void setColors(ReadableArray paramReadableArray)
  {
    int[] arrayOfInt = new int[paramReadableArray.size()];
    for (int k = 0; k < arrayOfInt.length; k++)
      arrayOfInt[k] = paramReadableArray.getInt(k);
    this.h = arrayOfInt;
    a();
  }

  public void setEndPosition(ReadableArray paramReadableArray)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = ((float)paramReadableArray.getDouble(0));
    arrayOfFloat[1] = ((float)paramReadableArray.getDouble(1));
    this.g = arrayOfFloat;
    a();
  }

  public void setLocations(ReadableArray paramReadableArray)
  {
    float[] arrayOfFloat = new float[paramReadableArray.size()];
    for (int k = 0; k < arrayOfFloat.length; k++)
      arrayOfFloat[k] = ((float)paramReadableArray.getDouble(k));
    this.e = arrayOfFloat;
    a();
  }

  public void setStartPosition(ReadableArray paramReadableArray)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = ((float)paramReadableArray.getDouble(0));
    arrayOfFloat[1] = ((float)paramReadableArray.getDouble(1));
    this.f = arrayOfFloat;
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.BV.LinearGradient.b
 * JD-Core Version:    0.6.2
 */
package com.d.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class f extends b
{
  private final Paint c = new Paint();
  private boolean d;
  private boolean e;
  private float f = 10.0F;

  public f(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.c.setColor(Color.rgb(20, 40, 60));
    this.c.setStrokeWidth(4.0F);
    this.c.setAlpha(128);
  }

  public void a(Canvas paramCanvas, c[] paramArrayOfc, float paramFloat1, float paramFloat2, float paramFloat3, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, float paramFloat4, d.a parama)
  {
    this.a.setStrokeWidth(parama.b);
    this.a.setColor(parama.a);
    if (this.d);
    for (Path localPath = new Path(); ; localPath = null)
    {
      int i = 0;
      float f1 = 0.0F;
      double d1 = 0.0D;
      double d2 = 0.0D;
      double d3;
      double d4;
      float f2;
      float f4;
      float f5;
      if (i < paramArrayOfc.length)
      {
        d3 = (paramArrayOfc[i].b() - paramDouble2) / paramDouble4 * paramFloat2;
        d4 = (paramArrayOfc[i].a() - paramDouble1) / paramDouble3 * paramFloat1;
        if (i > 0)
        {
          f2 = (float)d1 + (1.0F + paramFloat4);
          float f3 = paramFloat2 + (float)(paramFloat3 - d2);
          f4 = (float)d4 + (1.0F + paramFloat4);
          f5 = paramFloat2 + (float)(paramFloat3 - d3);
          if (this.e)
            paramCanvas.drawCircle(f4, f5, this.f, this.a);
          paramCanvas.drawLine(f2, f3, f4, f5, this.a);
          if (localPath == null)
            break label273;
          if (i != 1)
            break label326;
          localPath.moveTo(f2, f3);
        }
      }
      while (true)
      {
        localPath.lineTo(f4, f5);
        while (true)
        {
          i++;
          f1 = f2;
          d2 = d3;
          d1 = d4;
          break;
          if (this.e)
            paramCanvas.drawCircle((float)d4 + (1.0F + paramFloat4), paramFloat2 + (float)(paramFloat3 - d3), this.f, this.a);
          label273: f2 = f1;
        }
        if (localPath != null)
        {
          localPath.lineTo((float)d1, paramFloat2 + paramFloat3);
          localPath.lineTo(f1, paramFloat2 + paramFloat3);
          localPath.close();
          paramCanvas.drawPath(localPath, this.c);
        }
        return;
        label326: f2 = f1;
      }
    }
  }

  public int getBackgroundColor()
  {
    return this.c.getColor();
  }

  public float getDataPointsRadius()
  {
    return this.f;
  }

  public boolean getDrawBackground()
  {
    return this.d;
  }

  public boolean getDrawDataPoints()
  {
    return this.e;
  }

  public void setBackgroundColor(int paramInt)
  {
    this.c.setColor(paramInt);
  }

  public void setDataPointsRadius(float paramFloat)
  {
    this.f = paramFloat;
  }

  public void setDrawBackground(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public void setDrawDataPoints(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.d.a.f
 * JD-Core Version:    0.6.2
 */
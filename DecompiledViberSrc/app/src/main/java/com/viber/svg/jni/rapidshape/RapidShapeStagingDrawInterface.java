package com.viber.svg.jni.rapidshape;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract interface RapidShapeStagingDrawInterface
{
  public abstract Paint beginShape(Paint paramPaint);

  public abstract void endShape();

  public abstract Canvas getCanvas();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.rapidshape.RapidShapeStagingDrawInterface
 * JD-Core Version:    0.6.2
 */
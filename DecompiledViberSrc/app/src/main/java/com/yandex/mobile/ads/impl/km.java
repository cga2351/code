package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public final class km extends View
{
  private final cy a;
  private Paint b;
  private int c;
  private int d;

  public km(Context paramContext, cy paramcy)
  {
    super(paramContext);
    this.a = paramcy;
    this.c = cy.a(paramContext, 1.0F);
    this.d = cy.a(paramContext, 0.5F);
    this.b = new Paint();
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.c);
    this.b.setColor(-65536);
    setClickable(false);
    setFocusable(false);
  }

  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawRect(this.d, this.d, getWidth() - this.d, getHeight() - this.d, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.km
 * JD-Core Version:    0.6.2
 */
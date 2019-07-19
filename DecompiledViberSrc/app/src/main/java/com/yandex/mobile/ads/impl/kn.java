package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.view.View;

public final class kn extends View
{
  private final cy a;
  private Paint b;
  private Paint c;
  private Paint d;
  private float e;
  private float f;
  private float g;
  private float h;

  public kn(Context paramContext, cy paramcy)
  {
    super(paramContext);
    this.a = paramcy;
    this.e = 40.0F;
    this.f = cy.a(paramContext, 34.0F);
    this.g = cy.a(paramContext, 3.0F);
    this.h = cy.a(paramContext, 20.0F);
    this.b = new Paint();
    this.b.setStyle(Paint.Style.FILL);
    this.c = new Paint();
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.g);
    this.c.setAntiAlias(true);
    this.d = new Paint();
    this.d.setStyle(Paint.Style.FILL);
    this.d.setTextSize(this.h);
    this.d.setTextAlign(Paint.Align.CENTER);
    a();
  }

  private void a()
  {
    this.c.setColor(dh.a(-65536, this.e));
    this.b.setColor(dh.a(-1, this.e));
    this.d.setColor(dh.a(-65536, this.e));
  }

  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.f / 2.0F;
    paramCanvas.drawCircle(f1, f1, f1, this.b);
    paramCanvas.drawCircle(f1, f1, f1 - this.g / 2.0F, this.c);
    paramCanvas.drawText("!", this.f / 2.0F, this.f / 2.0F - (this.d.descent() + this.d.ascent()) / 2.0F, this.d);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension((int)this.f, (int)this.f);
  }

  public final void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    if (paramBoolean);
    for (float f1 = 0.0F; ; f1 = 40.0F)
    {
      this.e = f1;
      a();
      invalidate();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.kn
 * JD-Core Version:    0.6.2
 */
package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;

public class CtaButtonDrawable extends BaseWidgetDrawable
{
  private final Paint a;
  private final Paint b;
  private final Paint c;
  private final RectF d;
  private final Rect e;
  private final int f;
  private String g;

  public CtaButtonDrawable(Context paramContext)
  {
    int i = Dips.dipsToIntPixels(2.0F, paramContext);
    float f1 = Dips.dipsToFloatPixels(15.0F, paramContext);
    this.a = new Paint();
    this.a.setColor(-16777216);
    this.a.setAlpha(51);
    this.a.setStyle(DrawableConstants.CtaButton.BACKGROUND_STYLE);
    this.a.setAntiAlias(true);
    this.b = new Paint();
    this.b.setColor(-1);
    this.b.setAlpha(51);
    this.b.setStyle(DrawableConstants.CtaButton.OUTLINE_STYLE);
    this.b.setStrokeWidth(i);
    this.b.setAntiAlias(true);
    this.c = new Paint();
    this.c.setColor(-1);
    this.c.setTextAlign(DrawableConstants.CtaButton.TEXT_ALIGN);
    this.c.setTypeface(DrawableConstants.CtaButton.TEXT_TYPEFACE);
    this.c.setTextSize(f1);
    this.c.setAntiAlias(true);
    this.e = new Rect();
    this.g = "Learn More";
    this.d = new RectF();
    this.f = Dips.dipsToIntPixels(6.0F, paramContext);
  }

  public void draw(Canvas paramCanvas)
  {
    this.d.set(getBounds());
    paramCanvas.drawRoundRect(this.d, this.f, this.f, this.a);
    paramCanvas.drawRoundRect(this.d, this.f, this.f, this.b);
    a(paramCanvas, this.c, this.e, this.g);
  }

  @Deprecated
  @VisibleForTesting
  public String getCtaText()
  {
    return this.g;
  }

  public void setCtaText(String paramString)
  {
    this.g = paramString;
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.resource.CtaButtonDrawable
 * JD-Core Version:    0.6.2
 */
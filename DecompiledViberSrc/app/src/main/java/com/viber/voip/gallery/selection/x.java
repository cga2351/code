package com.viber.voip.gallery.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.viber.voip.R.drawable;
import com.viber.voip.util.ae;

public class x extends Drawable
{
  private static final int c = R.drawable.video_duration_badge;
  protected float a;
  protected float b;
  private Drawable d;
  private Rect e;
  private Paint f;
  private long g;
  private String h;
  private float i;

  public x(Context paramContext)
  {
    this(paramContext, 0L);
  }

  public x(Context paramContext, long paramLong)
  {
    a(paramLong);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.i = TypedValue.applyDimension(1, 14.0F, localDisplayMetrics);
    this.a = TypedValue.applyDimension(1, 4.0F, localDisplayMetrics);
    this.b = TypedValue.applyDimension(1, 6.0F, localDisplayMetrics);
    this.f = new Paint(1);
    this.f.setTextSize(this.i);
    this.f.setColor(-1);
    this.d = ContextCompat.getDrawable(paramContext, d());
    this.e = new Rect();
  }

  private String e()
  {
    if (TextUtils.isEmpty(this.h))
      this.h = ae.f(this.g);
    return this.h;
  }

  protected int a()
  {
    return this.e.width() + 2 * (int)this.a;
  }

  public void a(long paramLong)
  {
    this.g = paramLong;
    this.h = ae.f(this.g);
  }

  protected int b()
  {
    return 0;
  }

  protected int c()
  {
    return this.e.height() + 2 * (int)this.b;
  }

  protected int d()
  {
    return c;
  }

  public void draw(Canvas paramCanvas)
  {
    this.f.getTextBounds(this.h, 0, this.h.length(), this.e);
    this.d.setBounds(0, b(), a(), c());
    this.d.draw(paramCanvas);
    paramCanvas.drawText(e(), this.a, getBounds().top + this.b + this.e.height(), this.f);
  }

  public int getOpacity()
  {
    return -3;
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.x
 * JD-Core Version:    0.6.2
 */
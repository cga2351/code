package com.viber.voip.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.e.c;
import com.viber.voip.util.e.j;

public class a extends Drawable
{
  private static final Logger a = ViberEnv.getLogger();
  private final c b;
  private a c;
  private boolean d;

  public a(Context paramContext, int paramInt)
  {
    this.c = new a(paramContext, paramInt);
    this.b = c.a(paramContext);
  }

  private void d()
  {
    if (getBounds().isEmpty())
      return;
    try
    {
      this.c.c = Bitmap.createBitmap(getBounds().width() / 4, getBounds().height() / 4, Bitmap.Config.ARGB_8888);
      a.a(this.c, new Canvas(this.c.c));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
    }
  }

  public Canvas a()
  {
    return a.a(this.c);
  }

  public void b()
  {
    if ((this.c.c == null) || (this.c.c.isRecycled()))
      return;
    this.c.c.eraseColor(0);
  }

  public void c()
  {
    j.c(this.c.c);
    this.c.c = null;
    a.a(this.c, null);
  }

  public void draw(Canvas paramCanvas)
  {
    if ((a.a(this.c) == null) || (this.c.c == null) || (getBounds().isEmpty()))
      return;
    this.b.a(this.c.c, this.c.d, false, true);
    paramCanvas.save();
    paramCanvas.scale(paramCanvas.getWidth() / a.a(this.c).getWidth(), paramCanvas.getHeight() / a.a(this.c).getHeight());
    paramCanvas.drawBitmap(this.c.c, 0.0F, 0.0F, this.c.b);
    paramCanvas.restore();
  }

  public int getOpacity()
  {
    if ((a.a(this.c) == null) || (this.c.b.getAlpha() < 255))
      return -3;
    return -1;
  }

  public final Drawable mutate()
  {
    if ((!this.d) && (super.mutate() == this))
    {
      this.c = new a(this.c);
      this.d = true;
    }
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    d();
  }

  public void setAlpha(int paramInt)
  {
    this.c.b.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.c.b.setColorFilter(paramColorFilter);
  }

  static class a extends Drawable.ConstantState
  {
    Context a;
    Paint b = new Paint(3);
    Bitmap c;
    int d;
    int e;
    private Canvas f;

    a(Context paramContext, int paramInt)
    {
      this.a = paramContext;
      this.d = paramInt;
    }

    a(a parama)
    {
      this(parama.a, parama.d);
      this.c = parama.c;
      this.f = parama.f;
      this.e = parama.e;
      this.b = new Paint(parama.b);
    }

    public int getChangingConfigurations()
    {
      return this.e;
    }

    public Drawable newDrawable()
    {
      return new a(this.a, this.d);
    }

    public Drawable newDrawable(Resources paramResources)
    {
      return new a(this.a, this.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.d.a
 * JD-Core Version:    0.6.2
 */
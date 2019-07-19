package com.viber.voip.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView.ScaleType;
import com.viber.common.d.h;
import com.viber.common.ui.a.a;
import com.viber.voip.R.attr;
import com.viber.voip.util.dc;

public class b extends com.viber.common.ui.a
{
  private final Resources e;
  private a f;
  private final Matrix g = new Matrix();
  private final Matrix h = new Matrix();
  private final PointF i = new PointF();
  private Bitmap j;
  private Shader k;
  private int l;
  private int m;
  private float n;
  private float o;

  public b(Context paramContext, Bitmap paramBitmap)
  {
    this(paramContext, paramBitmap, false);
  }

  protected b(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    this(new a(paramBitmap, paramBoolean, dc.d(paramContext, R.attr.contactDefaultPhotoBackgroundColor), dc.a(paramContext, R.attr.contactDefaultPhoto), dc.a(paramContext, R.attr.contactDefaultPhotoPart)), paramContext.getResources());
  }

  public b(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }

  protected b(a parama, Resources paramResources)
  {
    super(parama, paramResources);
    this.e = paramResources;
    this.f = parama;
    a(ImageView.ScaleType.CENTER_CROP);
    f();
  }

  private void a(Canvas paramCanvas)
  {
    a locala = this.f;
    paramCanvas.drawPath(this.b, locala.j);
    Paint localPaint = ae_();
    localPaint.setShader(this.k);
    int i1 = paramCanvas.save();
    switch (locala.f)
    {
    default:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      paramCanvas.drawRect(this.c, localPaint);
      paramCanvas.restoreToCount(i1);
      return;
      j();
      paramCanvas.translate(this.i.x, this.i.y);
      continue;
      j();
      paramCanvas.translate(-this.i.x, this.i.y);
      continue;
      j();
      paramCanvas.translate(this.i.x, -this.i.y);
      continue;
      j();
      paramCanvas.translate(-this.i.x, -this.i.y);
    }
  }

  private void f()
  {
    a locala = this.f;
    if (!locala.g)
    {
      g();
      return;
    }
    if (locala.f == 0);
    for (int i1 = locala.h; ; i1 = locala.i)
    {
      this.j = ((BitmapDrawable)this.e.getDrawable(i1)).getBitmap();
      h();
      this.k = new BitmapShader(this.j, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      return;
    }
  }

  private void g()
  {
    this.i.set(0.0F, 0.0F);
    this.h.reset();
    this.j = null;
    this.k = null;
    this.m = -1;
    this.l = -1;
    this.o = -1.0F;
    this.n = -1.0F;
  }

  private void h()
  {
    if (this.j == null)
      return;
    if (com.viber.common.d.a.n())
      this.l = this.j.getWidth();
    for (this.m = this.j.getHeight(); ; this.m = this.j.getScaledHeight(this.a))
    {
      this.n = this.l;
      this.o = this.m;
      return;
      this.l = this.j.getScaledWidth(this.a);
    }
  }

  private void i()
  {
    float f1 = 0.0F;
    float f2 = this.d.height();
    float f3 = this.d.width();
    float f4;
    if (f2 * this.n > f3 * this.o)
      f4 = f2 / this.o;
    for (float f5 = (f3 - f4 * this.n) / 2.0F; ; f5 = 0.0F)
    {
      this.h.reset();
      this.h.setScale(f4, f4);
      this.h.postTranslate((int)(f5 + 0.5F), (int)(f1 + 0.5F));
      this.k.setLocalMatrix(this.h);
      return;
      f4 = f3 / this.n;
      f1 = (f2 - f4 * this.o) / 2.0F;
    }
  }

  private void j()
  {
    float f1 = this.d.width();
    float f2 = this.d.height();
    float f3 = f1 - 4.0F * f1 / 9.424778F;
    float f4 = f2 - 4.0F * f2 / 9.424778F;
    this.i.set(f3 - f1 / 2.0F, f4 - f2 / 2.0F);
  }

  public final void a(int paramInt)
  {
    if (this.f.f != paramInt)
    {
      int i1 = this.f.f;
      this.f.f = paramInt;
      if ((i1 == 0) || (paramInt == 0))
        f();
      c();
    }
  }

  protected void a(Path paramPath, Rect paramRect)
  {
    int i1 = this.f.f;
    switch (i1)
    {
    default:
      h.c(paramRect.width(), paramRect.height(), paramPath);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      this.g.reset();
      switch (i1)
      {
      case 3:
      default:
        return;
        h.b(2 * paramRect.width(), paramRect.height(), paramPath);
        continue;
        h.a(2 * paramRect.width(), 2 * paramRect.height(), paramPath);
      case 2:
      case 4:
      case 5:
      case 6:
      }
    }
    this.g.postScale(-1.0F, 1.0F);
    this.g.postTranslate(paramRect.width(), 0.0F);
    paramPath.transform(this.g);
    return;
    this.g.postScale(1.0F, -1.0F);
    this.g.postTranslate(0.0F, paramRect.height());
    paramPath.transform(this.g);
    return;
    this.g.postScale(-1.0F, -1.0F);
    this.g.postTranslate(paramRect.width(), paramRect.height());
    paramPath.transform(this.g);
  }

  public void a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != ImageView.ScaleType.CENTER_CROP)
      paramScaleType = ImageView.ScaleType.CENTER_CROP;
    super.a(paramScaleType);
  }

  public Bitmap b()
  {
    if (this.f.g)
      return this.j;
    return super.b();
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.f.g)
      a(paramCanvas);
    super.draw(paramCanvas);
  }

  protected a e()
  {
    this.f = new a(this.f);
    return this.f;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    if (this.f.g)
      i();
  }

  static final class a extends a.a
  {
    int f;
    boolean g;
    int h;
    int i;
    Paint j = new Paint(1);

    a(Bitmap paramBitmap, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
      this.g = paramBoolean;
      this.h = paramInt2;
      this.i = paramInt3;
      this.j.setStyle(Paint.Style.FILL);
      this.j.setColor(paramInt1);
    }

    a(a parama)
    {
      super();
      this.f = parama.f;
      this.g = parama.g;
      this.h = parama.h;
      this.i = parama.i;
      this.j = parama.j;
    }

    public Drawable newDrawable()
    {
      return new b(this, null);
    }

    public Drawable newDrawable(Resources paramResources)
    {
      return new b(this, paramResources);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.d.b
 * JD-Core Version:    0.6.2
 */
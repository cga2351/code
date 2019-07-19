package com.viber.voip.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.util.AttributeSet;
import com.viber.common.ui.ShapeImageView;
import java.util.Arrays;
import pl.droidsonroids.gif.a.a;
import pl.droidsonroids.gif.b;

public class GifShapeImageView extends ShapeImageView
{
  h d = new h(new h.a()
  {
    public Drawable.Callback a()
    {
      return GifShapeImageView.this;
    }

    public void a(b paramAnonymousb)
    {
      GifShapeImageView.a(GifShapeImageView.this, paramAnonymousb);
    }
  });

  public GifShapeImageView(Context paramContext)
  {
    super(paramContext);
  }

  public GifShapeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public GifShapeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected Drawable a(Drawable paramDrawable, Context paramContext)
  {
    if ((paramDrawable instanceof b))
      return paramDrawable;
    return super.a(paramDrawable, paramContext);
  }

  protected void a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof b))
    {
      b localb = (b)paramDrawable;
      Paint localPaint = localb.g();
      localPaint.setAntiAlias(true);
      localPaint.setFilterBitmap(true);
      a locala = localb.k();
      if ((locala instanceof a))
        ((a)locala).a(this.c, this.b);
      while ((this.c <= 0.0F) || (this.b <= 0))
        return;
      localb.a(new a(this.c, this.b));
      return;
    }
    super.a(paramDrawable);
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.d.a(null);
    super.setImageBitmap(paramBitmap);
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof b))
      this.d.a((b)paramDrawable);
    do
    {
      return;
      this.d.a(null);
    }
    while (paramDrawable == null);
    super.setImageDrawable(paramDrawable);
  }

  public void setImageIcon(Icon paramIcon)
  {
    this.d.a(null);
    super.setImageIcon(paramIcon);
  }

  public void setImageResource(int paramInt)
  {
    this.d.a(null);
    super.setImageResource(paramInt);
  }

  public void setImageURI(Uri paramUri)
  {
    this.d.a(null);
    super.setImageURI(paramUri);
  }

  private static class a
    implements a
  {
    private float a;
    private int b;
    private Shader c;
    private final RectF d = new RectF();
    private Path e = new Path();
    private float[] f = new float[8];

    public a(float paramFloat, int paramInt)
    {
      a(paramFloat, paramInt);
    }

    private void a()
    {
      Arrays.fill(this.f, 0.0F);
      if ((0x1 & this.b) != 0)
      {
        this.f[0] = this.a;
        this.f[1] = this.a;
      }
      if ((0x2 & this.b) != 0)
      {
        this.f[2] = this.a;
        this.f[3] = this.a;
      }
      if ((0x8 & this.b) != 0)
      {
        this.f[4] = this.a;
        this.f[5] = this.a;
      }
      if ((0x4 & this.b) != 0)
      {
        this.f[6] = this.a;
        this.f[7] = this.a;
      }
    }

    public void a(float paramFloat, int paramInt)
    {
      float f1 = Math.max(0.0F, paramFloat);
      if ((f1 == this.a) && (paramInt == this.b))
        return;
      this.a = f1;
      this.b = paramInt;
      a();
      this.c = null;
    }

    public void a(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap)
    {
      float f1 = 0.0F;
      if (this.a == 0.0F)
      {
        paramCanvas.drawBitmap(paramBitmap, null, this.d, paramPaint);
        return;
      }
      Matrix localMatrix;
      float f2;
      float f3;
      float f4;
      if (this.c == null)
      {
        this.c = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        localMatrix = new Matrix();
        f2 = this.d.height();
        f3 = this.d.width();
        if (f2 * paramBitmap.getWidth() <= f3 * paramBitmap.getHeight())
          break label204;
        f4 = f2 / paramBitmap.getHeight();
      }
      for (float f5 = 0.5F * (f3 - f4 * paramBitmap.getWidth()); ; f5 = 0.0F)
      {
        localMatrix.setScale(f4, f4);
        localMatrix.postTranslate((int)(f5 + 0.5F), (int)(f1 + 0.5F));
        this.c.setLocalMatrix(localMatrix);
        this.e.reset();
        this.e.addRoundRect(this.d, this.f, Path.Direction.CCW);
        paramPaint.setShader(this.c);
        paramCanvas.drawPath(this.e, paramPaint);
        return;
        label204: f4 = f3 / paramBitmap.getWidth();
        f1 = 0.5F * (f2 - f4 * paramBitmap.getHeight());
      }
    }

    public void a(Rect paramRect)
    {
      this.d.set(paramRect);
      this.c = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.GifShapeImageView
 * JD-Core Version:    0.6.2
 */
package android.support.design.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.widget.MathUtils;
import android.view.View;

public class c
{
  public static final int a = 0;
  private final a b;
  private final View c;
  private final Path d;
  private final Paint e;
  private final Paint f;
  private d.d g;
  private Drawable h;
  private boolean i;
  private boolean j;

  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = 1;
      return;
    }
  }

  private float b(d.d paramd)
  {
    return MathUtils.distanceToFurthestCorner(paramd.a, paramd.b, 0.0F, 0.0F, this.c.getWidth(), this.c.getHeight());
  }

  private void b(Canvas paramCanvas)
  {
    if (j())
    {
      Rect localRect = this.h.getBounds();
      float f1 = this.g.a - localRect.width() / 2.0F;
      float f2 = this.g.b - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.h.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }

  private void g()
  {
    if (a == 1)
    {
      this.d.rewind();
      if (this.g != null)
        this.d.addCircle(this.g.a, this.g.b, this.g.c, Path.Direction.CW);
    }
    this.c.invalidate();
  }

  private boolean h()
  {
    int k;
    if ((this.g == null) || (this.g.a()))
    {
      k = 1;
      if (a != 0)
        break label45;
      if ((k != 0) || (!this.j))
        break label43;
    }
    label43: label45: 
    while (k == 0)
    {
      return true;
      k = 0;
      break;
      return false;
    }
    return false;
  }

  private boolean i()
  {
    return (!this.i) && (Color.alpha(this.f.getColor()) != 0);
  }

  private boolean j()
  {
    return (!this.i) && (this.h != null) && (this.g != null);
  }

  public void a()
  {
    if (a == 0)
    {
      this.i = true;
      this.j = false;
      this.c.buildDrawingCache();
      Bitmap localBitmap = this.c.getDrawingCache();
      if ((localBitmap == null) && (this.c.getWidth() != 0) && (this.c.getHeight() != 0))
      {
        localBitmap = Bitmap.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        this.c.draw(localCanvas);
      }
      if (localBitmap != null)
        this.e.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      this.i = false;
      this.j = true;
    }
  }

  public void a(int paramInt)
  {
    this.f.setColor(paramInt);
    this.c.invalidate();
  }

  public void a(Canvas paramCanvas)
  {
    if (h())
      switch (a)
      {
      default:
        throw new IllegalStateException("Unsupported strategy " + a);
      case 2:
        this.b.a(paramCanvas);
        if (i())
          paramCanvas.drawRect(0.0F, 0.0F, this.c.getWidth(), this.c.getHeight(), this.f);
        break;
      case 1:
      case 0:
      }
    while (true)
    {
      b(paramCanvas);
      return;
      int k = paramCanvas.save();
      paramCanvas.clipPath(this.d);
      this.b.a(paramCanvas);
      if (i())
        paramCanvas.drawRect(0.0F, 0.0F, this.c.getWidth(), this.c.getHeight(), this.f);
      paramCanvas.restoreToCount(k);
      continue;
      paramCanvas.drawCircle(this.g.a, this.g.b, this.g.c, this.e);
      if (i())
      {
        paramCanvas.drawCircle(this.g.a, this.g.b, this.g.c, this.f);
        continue;
        this.b.a(paramCanvas);
        if (i())
          paramCanvas.drawRect(0.0F, 0.0F, this.c.getWidth(), this.c.getHeight(), this.f);
      }
    }
  }

  public void a(Drawable paramDrawable)
  {
    this.h = paramDrawable;
    this.c.invalidate();
  }

  public void a(d.d paramd)
  {
    if (paramd == null)
      this.g = null;
    label71: 
    while (true)
    {
      g();
      return;
      if (this.g == null)
        this.g = new d.d(paramd);
      while (true)
      {
        if (!MathUtils.geq(paramd.c, b(paramd), 1.0E-004F))
          break label71;
        this.g.c = 3.4028235E+38F;
        break;
        this.g.a(paramd);
      }
    }
  }

  public void b()
  {
    if (a == 0)
    {
      this.j = false;
      this.c.destroyDrawingCache();
      this.e.setShader(null);
      this.c.invalidate();
    }
  }

  public d.d c()
  {
    d.d locald;
    if (this.g == null)
      locald = null;
    do
    {
      return locald;
      locald = new d.d(this.g);
    }
    while (!locald.a());
    locald.c = b(locald);
    return locald;
  }

  public int d()
  {
    return this.f.getColor();
  }

  public Drawable e()
  {
    return this.h;
  }

  public boolean f()
  {
    return (this.b.c()) && (!h());
  }

  static abstract interface a
  {
    public abstract void a(Canvas paramCanvas);

    public abstract boolean c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.c.c
 * JD-Core Version:    0.6.2
 */
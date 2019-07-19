package android.support.design.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

public class b extends FrameLayout
  implements d
{
  private final c a;

  public void a()
  {
    this.a.a();
  }

  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }

  public void b()
  {
    this.a.b();
  }

  public boolean c()
  {
    return super.isOpaque();
  }

  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }

  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.a.e();
  }

  public int getCircularRevealScrimColor()
  {
    return this.a.d();
  }

  public d.d getRevealInfo()
  {
    return this.a.c();
  }

  public boolean isOpaque()
  {
    if (this.a != null)
      return this.a.f();
    return super.isOpaque();
  }

  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.a.a(paramDrawable);
  }

  public void setCircularRevealScrimColor(int paramInt)
  {
    this.a.a(paramInt);
  }

  public void setRevealInfo(d.d paramd)
  {
    this.a.a(paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.c.b
 * JD-Core Version:    0.6.2
 */
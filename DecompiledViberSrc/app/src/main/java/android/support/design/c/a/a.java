package android.support.design.c.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.design.c.c;
import android.support.design.c.d;
import android.support.design.c.d.d;
import android.support.v7.widget.CardView;

public class a extends CardView
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
 * Qualified Name:     android.support.design.c.a.a
 * JD-Core Version:    0.6.2
 */
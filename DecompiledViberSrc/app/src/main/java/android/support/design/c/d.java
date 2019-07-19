package android.support.design.c;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.support.design.widget.MathUtils;
import android.util.Property;

public abstract interface d extends c.a
{
  public abstract void a();

  public abstract void b();

  public abstract int getCircularRevealScrimColor();

  public abstract d getRevealInfo();

  public abstract void setCircularRevealOverlayDrawable(Drawable paramDrawable);

  public abstract void setCircularRevealScrimColor(int paramInt);

  public abstract void setRevealInfo(d paramd);

  public static class a
    implements TypeEvaluator<d.d>
  {
    public static final TypeEvaluator<d.d> a = new a();
    private final d.d b = new d.d(null);

    public d.d a(float paramFloat, d.d paramd1, d.d paramd2)
    {
      this.b.a(MathUtils.lerp(paramd1.a, paramd2.a, paramFloat), MathUtils.lerp(paramd1.b, paramd2.b, paramFloat), MathUtils.lerp(paramd1.c, paramd2.c, paramFloat));
      return this.b;
    }
  }

  public static class b extends Property<d, d.d>
  {
    public static final Property<d, d.d> a = new b("circularReveal");

    private b(String paramString)
    {
      super(paramString);
    }

    public d.d a(d paramd)
    {
      return paramd.getRevealInfo();
    }

    public void a(d paramd, d.d paramd1)
    {
      paramd.setRevealInfo(paramd1);
    }
  }

  public static class c extends Property<d, Integer>
  {
    public static final Property<d, Integer> a = new c("circularRevealScrimColor");

    private c(String paramString)
    {
      super(paramString);
    }

    public Integer a(d paramd)
    {
      return Integer.valueOf(paramd.getCircularRevealScrimColor());
    }

    public void a(d paramd, Integer paramInteger)
    {
      paramd.setCircularRevealScrimColor(paramInteger.intValue());
    }
  }

  public static class d
  {
    public float a;
    public float b;
    public float c;

    private d()
    {
    }

    public d(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
    }

    public d(d paramd)
    {
      this(paramd.a, paramd.b, paramd.c);
    }

    public void a(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
    }

    public void a(d paramd)
    {
      a(paramd.a, paramd.b, paramd.c);
    }

    public boolean a()
    {
      return this.c == 3.4028235E+38F;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.c.d
 * JD-Core Version:    0.6.2
 */
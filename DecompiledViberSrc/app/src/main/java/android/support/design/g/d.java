package android.support.design.g;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.List;

public class d
{
  public float a;
  public float b;
  public float c;
  public float d;
  private final List<c> e;

  public void a(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e.clear();
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a locala = new a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    locala.e = paramFloat5;
    locala.f = paramFloat6;
    this.e.add(locala);
    this.c = (0.5F * (paramFloat1 + paramFloat3) + (paramFloat3 - paramFloat1) / 2.0F * (float)Math.cos(Math.toRadians(paramFloat5 + paramFloat6)));
    this.d = (0.5F * (paramFloat2 + paramFloat4) + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(paramFloat5 + paramFloat6)));
  }

  public void a(Matrix paramMatrix, Path paramPath)
  {
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((c)this.e.get(j)).a(paramMatrix, paramPath);
  }

  public void b(float paramFloat1, float paramFloat2)
  {
    b localb = new b();
    b.a(localb, paramFloat1);
    b.b(localb, paramFloat2);
    this.e.add(localb);
    this.c = paramFloat1;
    this.d = paramFloat2;
  }

  public static class a extends d.c
  {
    private static final RectF h = new RectF();
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;

    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramFloat4;
    }

    public void a(Matrix paramMatrix, Path paramPath)
    {
      Matrix localMatrix = this.g;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      h.set(this.a, this.b, this.c, this.d);
      paramPath.arcTo(h, this.e, this.f, false);
      paramPath.transform(paramMatrix);
    }
  }

  public static class b extends d.c
  {
    private float a;
    private float b;

    public void a(Matrix paramMatrix, Path paramPath)
    {
      Matrix localMatrix = this.g;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      paramPath.lineTo(this.a, this.b);
      paramPath.transform(paramMatrix);
    }
  }

  public static abstract class c
  {
    protected final Matrix g = new Matrix();

    public abstract void a(Matrix paramMatrix, Path paramPath);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.g.d
 * JD-Core Version:    0.6.2
 */
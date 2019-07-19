package com.viber.voip.ui.call.a;

public class b extends a
{
  public float c;
  private a.a d;
  private float[] e = new float[0];
  private float[] f = new float[0];
  private int g = -1;
  private boolean h = false;
  private boolean i = false;

  public b(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this(paramFloat1, paramFloat2, paramArrayOfFloat1, paramArrayOfFloat2, null);
  }

  public b(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, a.a parama)
  {
    super(paramFloat1, paramFloat2);
    this.e = paramArrayOfFloat1;
    this.f = paramArrayOfFloat2;
    this.d = parama;
  }

  public void a(float paramFloat)
  {
    if (0.0F == paramFloat)
      c();
    if ((paramFloat >= this.a) && (paramFloat <= this.b))
    {
      boolean bool = this.h;
      int j = 0;
      if (!bool)
      {
        this.h = true;
        a.a locala = this.d;
        j = 0;
        if (locala != null)
          this.d.b(paramFloat);
      }
      while ((this.g < -1 + this.e.length) && (b(paramFloat) > this.e[(1 + this.g)]))
      {
        this.g = (1 + this.g);
        if (this.c != this.f[this.g])
        {
          this.c = this.f[this.g];
          j = 1;
        }
        if (this.d != null)
        {
          if (this.g > 0)
            this.d.b(paramFloat, -1 + this.g);
          this.d.a(paramFloat, this.g);
        }
      }
      if ((j == 0) && (this.g >= 0) && (this.g < -1 + this.e.length))
        this.c = (this.f[this.g] + (this.f[(1 + this.g)] - this.f[this.g]) * a(this.e[this.g], this.e[(1 + this.g)], b(paramFloat)));
    }
    do
    {
      return;
      if ((paramFloat <= this.a) && (this.g != 0))
      {
        c();
        return;
      }
    }
    while ((paramFloat <= this.b) || (this.f.length <= 0));
    if (!this.i)
    {
      this.i = true;
      if (this.d != null)
        this.d.c(paramFloat);
    }
    this.c = this.f[(-1 + this.f.length)];
  }

  public void c()
  {
    this.g = -1;
    this.c = this.f[0];
    this.h = false;
    this.i = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.call.a.b
 * JD-Core Version:    0.6.2
 */
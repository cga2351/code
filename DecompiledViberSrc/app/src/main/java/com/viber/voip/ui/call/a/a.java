package com.viber.voip.ui.call.a;

public abstract class a
  implements c
{
  protected float a;
  protected float b;

  public a(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }

  public float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }

  public float b(float paramFloat)
  {
    return a(this.a, this.b, paramFloat);
  }

  public static abstract interface a
  {
    public abstract void a(float paramFloat, int paramInt);

    public abstract void b(float paramFloat);

    public abstract void b(float paramFloat, int paramInt);

    public abstract void c(float paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.call.a.a
 * JD-Core Version:    0.6.2
 */
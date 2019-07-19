package com.viber.voip.ui.doodle.extras;

public class c
  implements d
{
  private int a;
  private float b;

  public c(int paramInt, float paramFloat)
  {
    this.a = paramInt;
    this.b = paramFloat;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void b(int paramInt)
  {
    this.a = paramInt;
  }

  public float g()
  {
    return this.b;
  }

  public int h()
  {
    return this.a;
  }

  public String toString()
  {
    return "DoodleSettings{mColor=" + this.a + ", mSize=" + this.b + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.extras.c
 * JD-Core Version:    0.6.2
 */
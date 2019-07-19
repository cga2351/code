package com.appnexus.opensdk;

public class AdSize
{
  private final int a;
  private final int b;

  public AdSize(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean fitsIn(int paramInt1, int paramInt2)
  {
    return (this.b < paramInt2) && (this.a < paramInt1);
  }

  public int height()
  {
    return this.b;
  }

  public int width()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.AdSize
 * JD-Core Version:    0.6.2
 */
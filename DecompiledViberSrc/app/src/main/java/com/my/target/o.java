package com.my.target;

public class o extends p
{
  private float a = -1.0F;
  private float b = -1.0F;

  private o(String paramString)
  {
    super("playheadReachedValue", paramString);
  }

  public static o a(String paramString)
  {
    return new o(paramString);
  }

  public float a()
  {
    return this.a;
  }

  public void a(float paramFloat)
  {
    this.a = paramFloat;
  }

  public float b()
  {
    return this.b;
  }

  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ProgressStat{");
    localStringBuilder.append("value=").append(this.a);
    localStringBuilder.append(", pvalue=").append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.o
 * JD-Core Version:    0.6.2
 */
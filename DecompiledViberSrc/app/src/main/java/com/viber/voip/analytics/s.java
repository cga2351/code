package com.viber.voip.analytics;

@Deprecated
public class s
{
  private final String a;
  private final boolean b;

  public s(String paramString)
  {
    this(paramString, true);
  }

  public s(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }

  public String a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public String toString()
  {
    return getClass().getSimpleName() + ": name=" + this.a + ", enabled=" + this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.s
 * JD-Core Version:    0.6.2
 */
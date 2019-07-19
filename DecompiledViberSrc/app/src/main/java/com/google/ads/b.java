package com.google.ads;

import com.google.android.gms.ads.AdSize;

@Deprecated
public final class b
{
  public static final b a = new b(-1, -2, "mb");
  public static final b b = new b(320, 50, "mb");
  public static final b c = new b(300, 250, "as");
  public static final b d = new b(468, 60, "as");
  public static final b e = new b(728, 90, "as");
  public static final b f = new b(160, 600, "as");
  private final AdSize g;

  private b(int paramInt1, int paramInt2, String paramString)
  {
    this(new AdSize(paramInt1, paramInt2));
  }

  public b(AdSize paramAdSize)
  {
    this.g = paramAdSize;
  }

  public final int a()
  {
    return this.g.getWidth();
  }

  public final int b()
  {
    return this.g.getHeight();
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b))
      return false;
    b localb = (b)paramObject;
    return this.g.equals(localb.g);
  }

  public final int hashCode()
  {
    return this.g.hashCode();
  }

  public final String toString()
  {
    return this.g.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.b
 * JD-Core Version:    0.6.2
 */
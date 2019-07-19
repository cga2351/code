package com.google.android.gms.common.images;

public final class Size
{
  private final int zand;
  private final int zane;

  public Size(int paramInt1, int paramInt2)
  {
    this.zand = paramInt1;
    this.zane = paramInt2;
  }

  public static Size parseSize(String paramString)
    throws NumberFormatException
  {
    if (paramString == null)
      throw new IllegalArgumentException("string must not be null");
    int i = paramString.indexOf('*');
    if (i < 0)
      i = paramString.indexOf('x');
    if (i < 0)
      throw zah(paramString);
    try
    {
      Size localSize = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw zah(paramString);
  }

  private static NumberFormatException zah(String paramString)
  {
    throw new NumberFormatException(16 + String.valueOf(paramString).length() + "Invalid Size: \"" + paramString + "\"");
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == null);
    Size localSize;
    do
    {
      do
      {
        return false;
        if (this == paramObject)
          return true;
      }
      while (!(paramObject instanceof Size));
      localSize = (Size)paramObject;
    }
    while ((this.zand != localSize.zand) || (this.zane != localSize.zane));
    return true;
  }

  public final int getHeight()
  {
    return this.zane;
  }

  public final int getWidth()
  {
    return this.zand;
  }

  public final int hashCode()
  {
    return this.zane ^ (this.zand << 16 | this.zand >>> 16);
  }

  public final String toString()
  {
    int i = this.zand;
    int j = this.zane;
    return 23 + i + "x" + j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.Size
 * JD-Core Version:    0.6.2
 */
package org.webrtc;

public class Size
{
  public int height;
  public int width;

  public Size(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Size));
    Size localSize;
    do
    {
      return false;
      localSize = (Size)paramObject;
    }
    while ((this.width != localSize.width) || (this.height != localSize.height));
    return true;
  }

  public int hashCode()
  {
    return 1 + 65537 * this.width + this.height;
  }

  public String toString()
  {
    return this.width + "x" + this.height;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.Size
 * JD-Core Version:    0.6.2
 */
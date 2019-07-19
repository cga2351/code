package org.simpleframework.xml.core;

class Revision
{
  private boolean equal = true;

  public boolean compare(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 != null)
      this.equal = paramObject2.equals(paramObject1);
    while (true)
    {
      return this.equal;
      if (paramObject1 != null)
        this.equal = paramObject1.equals(Double.valueOf(1.0D));
    }
  }

  public double getDefault()
  {
    return 1.0D;
  }

  public boolean isEqual()
  {
    return this.equal;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Revision
 * JD-Core Version:    0.6.2
 */
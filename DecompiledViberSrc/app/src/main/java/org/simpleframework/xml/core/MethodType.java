package org.simpleframework.xml.core;

 enum MethodType
{
  private int prefix;

  static
  {
    NONE = new MethodType("NONE", 3, 0);
    MethodType[] arrayOfMethodType = new MethodType[4];
    arrayOfMethodType[0] = GET;
    arrayOfMethodType[1] = IS;
    arrayOfMethodType[2] = SET;
    arrayOfMethodType[3] = NONE;
  }

  private MethodType(int paramInt)
  {
    this.prefix = paramInt;
  }

  public int getPrefix()
  {
    return this.prefix;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodType
 * JD-Core Version:    0.6.2
 */
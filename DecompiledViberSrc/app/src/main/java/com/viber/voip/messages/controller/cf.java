package com.viber.voip.messages.controller;

public class cf
{
  public final long a;
  public final int b;

  public cf(long paramLong, int paramInt)
  {
    this.a = paramLong;
    this.b = paramInt;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null)
      return false;
    if (getClass() != paramObject.getClass())
      return false;
    if (this.a != ((cf)paramObject).a)
      return false;
    return this.b == ((cf)paramObject).b;
  }

  public int hashCode()
  {
    return (int)(this.a << 16) ^ this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.cf
 * JD-Core Version:    0.6.2
 */
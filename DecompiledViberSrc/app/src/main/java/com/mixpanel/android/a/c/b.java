package com.mixpanel.android.a.c;

public class b extends Exception
{
  private int a;

  public b(int paramInt)
  {
    this.a = paramInt;
  }

  public b(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }

  public b(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.a = paramInt;
  }

  public int a()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.c.b
 * JD-Core Version:    0.6.2
 */
package com.crashlytics.android.c;

class ae
  implements av
{
  private final int a;
  private final av[] b;
  private final af c;

  public ae(int paramInt, av[] paramArrayOfav)
  {
    this.a = paramInt;
    this.b = paramArrayOfav;
    this.c = new af(paramInt);
  }

  public StackTraceElement[] a(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement.length <= this.a)
      return paramArrayOfStackTraceElement;
    av[] arrayOfav = this.b;
    int i = arrayOfav.length;
    int j = 0;
    StackTraceElement[] arrayOfStackTraceElement;
    for (Object localObject = paramArrayOfStackTraceElement; ; localObject = arrayOfStackTraceElement)
    {
      av localav;
      if (j < i)
      {
        localav = arrayOfav[j];
        if (localObject.length > this.a);
      }
      else
      {
        if (localObject.length > this.a)
          localObject = this.c.a((StackTraceElement[])localObject);
        return localObject;
      }
      arrayOfStackTraceElement = localav.a(paramArrayOfStackTraceElement);
      j++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ae
 * JD-Core Version:    0.6.2
 */
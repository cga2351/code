package com.crashlytics.android.c;

class af
  implements av
{
  private final int a;

  public af(int paramInt)
  {
    this.a = paramInt;
  }

  public StackTraceElement[] a(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement.length <= this.a)
      return paramArrayOfStackTraceElement;
    int i = this.a / 2;
    int j = this.a - i;
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[this.a];
    System.arraycopy(paramArrayOfStackTraceElement, 0, arrayOfStackTraceElement, 0, j);
    System.arraycopy(paramArrayOfStackTraceElement, paramArrayOfStackTraceElement.length - i, arrayOfStackTraceElement, j, i);
    return arrayOfStackTraceElement;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.af
 * JD-Core Version:    0.6.2
 */
package com.viber.common.a;

public abstract interface e
{
  public abstract String a();

  public abstract void a(String paramString, Object[] paramArrayOfObject);

  public abstract void a(Throwable paramThrowable, String paramString);

  public abstract void a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject);

  public abstract void b(String paramString, Object[] paramArrayOfObject);

  public abstract void b(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject);

  public abstract void c(String paramString, Object[] paramArrayOfObject);

  public abstract void d(String paramString, Object[] paramArrayOfObject);

  public abstract void e(String paramString, Object[] paramArrayOfObject);

  public static enum a
  {
    private final int g;

    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
    }

    private a(int paramInt)
    {
      this.g = paramInt;
    }

    public static CharSequence[] a()
    {
      a[] arrayOfa = values();
      CharSequence[] arrayOfCharSequence = new CharSequence[arrayOfa.length];
      int j;
      for (int i = 0; i < arrayOfa.length; i = j)
      {
        j = i + 1;
        arrayOfCharSequence[i] = arrayOfa[i].name();
      }
      return arrayOfCharSequence;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.a.e
 * JD-Core Version:    0.6.2
 */
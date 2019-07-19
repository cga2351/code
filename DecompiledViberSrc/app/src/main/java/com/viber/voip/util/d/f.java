package com.viber.voip.util.d;

public abstract class f<T>
{
  private volatile T a;

  protected abstract T d();

  public final T e()
  {
    if (this.a == null);
    try
    {
      if (this.a == null)
        this.a = d();
      return this.a;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.d.f
 * JD-Core Version:    0.6.2
 */
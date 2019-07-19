package com.viber.voip.backup.d;

public abstract class d<T>
{
  protected abstract boolean a(T paramT);

  public byte[] b(T paramT)
  {
    if (a(paramT))
      return c(paramT);
    return null;
  }

  protected abstract byte[] c(T paramT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.d
 * JD-Core Version:    0.6.2
 */
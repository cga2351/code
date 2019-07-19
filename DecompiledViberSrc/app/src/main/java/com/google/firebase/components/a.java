package com.google.firebase.components;

import java.util.Set;

abstract class a
  implements e
{
  public <T> T a(Class<T> paramClass)
  {
    com.google.firebase.b.a locala = c(paramClass);
    if (locala == null)
      return null;
    return locala.a();
  }

  public <T> Set<T> b(Class<T> paramClass)
  {
    return (Set)d(paramClass).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.a
 * JD-Core Version:    0.6.2
 */
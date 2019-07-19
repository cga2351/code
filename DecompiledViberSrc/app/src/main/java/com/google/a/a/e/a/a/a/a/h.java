package com.google.a.a.e.a.a.a.a;

import javax.annotation.Nullable;

public final class h
{
  public static void a(@Nullable Throwable paramThrowable)
  {
    a(paramThrowable, Error.class);
    a(paramThrowable, RuntimeException.class);
  }

  public static <X extends Throwable> void a(@Nullable Throwable paramThrowable, Class<X> paramClass)
    throws Throwable
  {
    if ((paramThrowable != null) && (paramClass.isInstance(paramThrowable)))
      throw ((Throwable)paramClass.cast(paramThrowable));
  }

  public static RuntimeException b(Throwable paramThrowable)
  {
    a((Throwable)e.a(paramThrowable));
    throw new RuntimeException(paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.e.a.a.a.a.h
 * JD-Core Version:    0.6.2
 */
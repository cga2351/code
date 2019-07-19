package androidx.work;

import android.annotation.SuppressLint;

public abstract interface l
{

  @SuppressLint({"SyntheticAccessor"})
  public static final l.a.c a = new l.a.c(null);

  @SuppressLint({"SyntheticAccessor"})
  public static final l.a.b b = new l.a.b(null);

  public static abstract class a
  {
    public static final class a extends l.a
    {
      private final Throwable a;

      public a(Throwable paramThrowable)
      {
        this.a = paramThrowable;
      }

      public Throwable a()
      {
        return this.a;
      }

      public String toString()
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.a.getMessage();
        return String.format("FAILURE (%s)", arrayOfObject);
      }
    }

    public static final class b extends l.a
    {
      public String toString()
      {
        return "IN_PROGRESS";
      }
    }

    public static final class c extends l.a
    {
      public String toString()
      {
        return "SUCCESS";
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.l
 * JD-Core Version:    0.6.2
 */
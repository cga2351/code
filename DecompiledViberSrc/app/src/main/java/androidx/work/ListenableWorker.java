package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Keep;
import com.google.b.a.a.a;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker
{
  private Context a;
  private WorkerParameters b;
  private volatile boolean c;
  private boolean d;

  @SuppressLint({"BanKeepAnnotation"})
  @Keep
  public ListenableWorker(Context paramContext, WorkerParameters paramWorkerParameters)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("Application Context is null");
    if (paramWorkerParameters == null)
      throw new IllegalArgumentException("WorkerParameters is null");
    this.a = paramContext;
    this.b = paramWorkerParameters;
  }

  public final Context a()
  {
    return this.a;
  }

  public final UUID b()
  {
    return this.b.a();
  }

  public final e c()
  {
    return this.b.b();
  }

  public abstract a<a> d();

  public final void e()
  {
    this.c = true;
    f();
  }

  public void f()
  {
  }

  public final boolean g()
  {
    return this.d;
  }

  public final void h()
  {
    this.d = true;
  }

  public Executor i()
  {
    return this.b.c();
  }

  public s j()
  {
    return this.b.d();
  }

  public static abstract class a
  {
    public static a a()
    {
      return new c();
    }

    public static a a(e parame)
    {
      return new c(parame);
    }

    public static a b()
    {
      return new b();
    }

    public static a c()
    {
      return new a();
    }

    public static final class a extends ListenableWorker.a
    {
      private final e a;

      public a()
      {
        this(e.a);
      }

      public a(e parame)
      {
        this.a = parame;
      }

      public e d()
      {
        return this.a;
      }

      public boolean equals(Object paramObject)
      {
        if (this == paramObject)
          return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        a locala = (a)paramObject;
        return this.a.equals(locala.a);
      }

      public int hashCode()
      {
        return 31 * a.class.getName().hashCode() + this.a.hashCode();
      }

      public String toString()
      {
        return "Failure {mOutputData=" + this.a + '}';
      }
    }

    public static final class b extends ListenableWorker.a
    {
      public boolean equals(Object paramObject)
      {
        if (this == paramObject);
        while ((paramObject != null) && (getClass() == paramObject.getClass()))
          return true;
        return false;
      }

      public int hashCode()
      {
        return b.class.getName().hashCode();
      }

      public String toString()
      {
        return "Retry";
      }
    }

    public static final class c extends ListenableWorker.a
    {
      private final e a;

      public c()
      {
        this(e.a);
      }

      public c(e parame)
      {
        this.a = parame;
      }

      public e d()
      {
        return this.a;
      }

      public boolean equals(Object paramObject)
      {
        if (this == paramObject)
          return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        c localc = (c)paramObject;
        return this.a.equals(localc.a);
      }

      public int hashCode()
      {
        return 31 * c.class.getName().hashCode() + this.a.hashCode();
      }

      public String toString()
      {
        return "Success {mOutputData=" + this.a + '}';
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.ListenableWorker
 * JD-Core Version:    0.6.2
 */
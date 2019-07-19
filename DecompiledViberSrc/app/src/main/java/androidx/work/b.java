package androidx.work;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b
{
  private final Executor a;
  private final s b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;

  b(a parama)
  {
    if (parama.a == null)
    {
      this.a = g();
      if (parama.b != null)
        break label77;
    }
    label77: for (this.b = s.a(); ; this.b = parama.b)
    {
      this.c = parama.c;
      this.d = parama.d;
      this.e = parama.e;
      this.f = parama.f;
      return;
      this.a = parama.a;
      break;
    }
  }

  private Executor g()
  {
    return Executors.newFixedThreadPool(Math.max(2, Math.min(-1 + Runtime.getRuntime().availableProcessors(), 4)));
  }

  public Executor a()
  {
    return this.a;
  }

  public s b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public int f()
  {
    if (Build.VERSION.SDK_INT == 23)
      return this.f / 2;
    return this.f;
  }

  public static final class a
  {
    Executor a;
    s b;
    int c = 4;
    int d = 0;
    int e = 2147483647;
    int f = 20;

    public b a()
    {
      return new b(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.b
 * JD-Core Version:    0.6.2
 */
package androidx.work;

import android.os.Build.VERSION;
import androidx.work.impl.b.j;
import java.util.concurrent.TimeUnit;

public final class m extends q
{
  m(a parama)
  {
    super(parama.b, parama.c, parama.d);
  }

  public static final class a extends q.a<a, m>
  {
    public a(Class<? extends ListenableWorker> paramClass, long paramLong1, TimeUnit paramTimeUnit1, long paramLong2, TimeUnit paramTimeUnit2)
    {
      super();
      this.c.a(paramTimeUnit1.toMillis(paramLong1), paramTimeUnit2.toMillis(paramLong2));
    }

    m a()
    {
      if ((this.a) && (Build.VERSION.SDK_INT >= 23) && (this.c.j.c()))
        throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
      return new m(this);
    }

    a b()
    {
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.m
 * JD-Core Version:    0.6.2
 */
package androidx.work;

import android.os.Build.VERSION;
import androidx.work.impl.b.j;

public final class k extends q
{
  k(a parama)
  {
    super(parama.b, parama.c, parama.d);
  }

  public static final class a extends q.a<a, k>
  {
    public a(Class<? extends ListenableWorker> paramClass)
    {
      super();
      this.c.d = OverwritingInputMerger.class.getName();
    }

    k a()
    {
      if ((this.a) && (Build.VERSION.SDK_INT >= 23) && (this.c.j.c()))
        throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
      return new k(this);
    }

    a b()
    {
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.k
 * JD-Core Version:    0.6.2
 */
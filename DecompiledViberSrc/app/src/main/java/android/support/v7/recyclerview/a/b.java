package android.support.v7.recyclerview.a;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.d.c;
import android.support.v7.d.c.a;
import android.support.v7.d.c.b;
import android.support.v7.d.c.c;
import android.support.v7.d.d;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class b<T>
{
  private static final Executor e = new a();
  final a<T> a;
  final Executor b;
  int c;
  private final d d;
  private List<T> f;
  private List<T> g = Collections.emptyList();

  public b(d paramd, a<T> parama)
  {
    this.d = paramd;
    this.a = parama;
    if (parama.a() != null)
    {
      this.b = parama.a();
      return;
    }
    this.b = e;
  }

  public List<T> a()
  {
    return this.g;
  }

  public void a(final List<T> paramList)
  {
    final int i = 1 + this.c;
    this.c = i;
    if (paramList == this.f)
      return;
    if (paramList == null)
    {
      int j = this.f.size();
      this.f = null;
      this.g = Collections.emptyList();
      this.d.onRemoved(0, j);
      return;
    }
    if (this.f == null)
    {
      this.f = paramList;
      this.g = Collections.unmodifiableList(paramList);
      this.d.onInserted(0, paramList.size());
      return;
    }
    final List localList = this.f;
    this.a.b().execute(new Runnable()
    {
      public void run()
      {
        final c.b localb = c.a(new c.a()
        {
          public boolean areContentsTheSame(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = b.1.this.a.get(paramAnonymous2Int1);
            Object localObject2 = b.1.this.b.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null))
              return b.this.a.c().b(localObject1, localObject2);
            if ((localObject1 == null) && (localObject2 == null))
              return true;
            throw new AssertionError();
          }

          public boolean areItemsTheSame(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = b.1.this.a.get(paramAnonymous2Int1);
            Object localObject2 = b.1.this.b.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null))
              return b.this.a.c().a(localObject1, localObject2);
            return (localObject1 == null) && (localObject2 == null);
          }

          public Object getChangePayload(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = b.1.this.a.get(paramAnonymous2Int1);
            Object localObject2 = b.1.this.b.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null))
              return b.this.a.c().c(localObject1, localObject2);
            throw new AssertionError();
          }

          public int getNewListSize()
          {
            return b.1.this.b.size();
          }

          public int getOldListSize()
          {
            return b.1.this.a.size();
          }
        });
        b.this.b.execute(new Runnable()
        {
          public void run()
          {
            if (b.this.c == b.1.this.c)
              b.this.a(b.1.this.b, localb);
          }
        });
      }
    });
  }

  void a(List<T> paramList, c.b paramb)
  {
    this.f = paramList;
    this.g = Collections.unmodifiableList(paramList);
    paramb.a(this.d);
  }

  private static class a
    implements Executor
  {
    final Handler a = new Handler(Looper.getMainLooper());

    public void execute(Runnable paramRunnable)
    {
      this.a.post(paramRunnable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.recyclerview.a.b
 * JD-Core Version:    0.6.2
 */
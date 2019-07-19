package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.h;
import androidx.work.impl.utils.a.c;
import androidx.work.o;
import java.util.List;

public abstract class g<T>
  implements Runnable
{
  private final c<T> a = c.d();

  public static g<List<o>> a(h paramh, final String paramString)
  {
    return new g()
    {
      List<o> c()
      {
        List localList = this.a.d().m().g(paramString);
        return (List)j.q.a(localList);
      }
    };
  }

  abstract T a();

  public com.google.b.a.a.a<T> b()
  {
    return this.a;
  }

  public void run()
  {
    try
    {
      Object localObject = a();
      this.a.a(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.a.a(localThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.g
 * JD-Core Version:    0.6.2
 */
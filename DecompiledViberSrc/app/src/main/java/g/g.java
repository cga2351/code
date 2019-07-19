package g;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

final class g extends c.a
{
  final Executor a;

  g(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }

  public c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, m paramm)
  {
    if (a(paramType) != b.class)
      return null;
    return new c()
    {
      public Type a()
      {
        return this.a;
      }

      public b<Object> b(b<Object> paramAnonymousb)
      {
        return new g.a(g.this.a, paramAnonymousb);
      }
    };
  }

  static final class a<T>
    implements b<T>
  {
    final Executor a;
    final b<T> b;

    a(Executor paramExecutor, b<T> paramb)
    {
      this.a = paramExecutor;
      this.b = paramb;
    }

    public l<T> a()
      throws IOException
    {
      return this.b.a();
    }

    public void a(final d<T> paramd)
    {
      o.a(paramd, "callback == null");
      this.b.a(new d()
      {
        public void a(b<T> paramAnonymousb, final l<T> paramAnonymousl)
        {
          g.a.this.a.execute(new Runnable()
          {
            public void run()
            {
              if (g.a.this.b.b())
              {
                g.a.1.this.a.a(g.a.this, new IOException("Canceled"));
                return;
              }
              g.a.1.this.a.a(g.a.this, paramAnonymousl);
            }
          });
        }

        public void a(b<T> paramAnonymousb, final Throwable paramAnonymousThrowable)
        {
          g.a.this.a.execute(new Runnable()
          {
            public void run()
            {
              g.a.1.this.a.a(g.a.this, paramAnonymousThrowable);
            }
          });
        }
      });
    }

    public boolean b()
    {
      return this.b.b();
    }

    public b<T> c()
    {
      return new a(this.a, this.b.c());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.g
 * JD-Core Version:    0.6.2
 */
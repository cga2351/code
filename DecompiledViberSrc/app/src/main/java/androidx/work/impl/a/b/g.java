package androidx.work.impl.a.b;

import android.content.Context;

public class g
{
  private static g a;
  private a b;
  private b c;
  private e d;
  private f e;

  private g(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    this.b = new a(localContext);
    this.c = new b(localContext);
    this.d = new e(localContext);
    this.e = new f(localContext);
  }

  public static g a(Context paramContext)
  {
    try
    {
      if (a == null)
        a = new g(paramContext);
      g localg = a;
      return localg;
    }
    finally
    {
    }
  }

  public a a()
  {
    return this.b;
  }

  public b b()
  {
    return this.c;
  }

  public e c()
  {
    return this.d;
  }

  public f d()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.b.g
 * JD-Core Version:    0.6.2
 */
package c.a.a.a.a.a;

import android.content.Context;

public abstract class a<T>
  implements c<T>
{
  private final c<T> a;

  public a(c<T> paramc)
  {
    this.a = paramc;
  }

  private void b(Context paramContext, T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    a(paramContext, paramT);
  }

  protected abstract T a(Context paramContext);

  public final T a(Context paramContext, d<T> paramd)
    throws Exception
  {
    try
    {
      Object localObject2 = a(paramContext);
      if (localObject2 == null)
        if (this.a == null)
          break label46;
      label46: Object localObject3;
      for (localObject2 = this.a.a(paramContext, paramd); ; localObject2 = localObject3)
      {
        b(paramContext, localObject2);
        return localObject2;
        localObject3 = paramd.a(paramContext);
      }
    }
    finally
    {
    }
  }

  protected abstract void a(Context paramContext, T paramT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.a.a
 * JD-Core Version:    0.6.2
 */
package android.arch.persistence.room;

import android.arch.persistence.a.f;

public abstract class b<T> extends i
{
  public b(e parame)
  {
    super(parame);
  }

  protected abstract void a(f paramf, T paramT);

  public final void a(T paramT)
  {
    f localf = c();
    try
    {
      a(localf, paramT);
      localf.b();
      return;
    }
    finally
    {
      a(localf);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.b
 * JD-Core Version:    0.6.2
 */
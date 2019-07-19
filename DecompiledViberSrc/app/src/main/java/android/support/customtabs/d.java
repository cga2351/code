package android.support.customtabs;

import android.os.IBinder;

public class d
{
  private final e a;
  private final a b;

  d(e parame)
  {
    this.a = parame;
    this.b = new a()
    {
    };
  }

  IBinder a()
  {
    return this.a.asBinder();
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d))
      return false;
    return ((d)paramObject).a().equals(this.a.asBinder());
  }

  public int hashCode()
  {
    return a().hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.customtabs.d
 * JD-Core Version:    0.6.2
 */
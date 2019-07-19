package android.support.transition;

import android.os.IBinder;

class aj
  implements al
{
  private final IBinder a;

  aj(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof aj)) && (((aj)paramObject).a.equals(this.a));
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.aj
 * JD-Core Version:    0.6.2
 */
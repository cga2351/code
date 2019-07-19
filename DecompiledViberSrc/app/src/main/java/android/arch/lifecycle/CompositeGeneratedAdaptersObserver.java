package android.arch.lifecycle;

public class CompositeGeneratedAdaptersObserver
  implements GenericLifecycleObserver
{
  private final d[] a;

  CompositeGeneratedAdaptersObserver(d[] paramArrayOfd)
  {
    this.a = paramArrayOfd;
  }

  public void a(h paramh, e.a parama)
  {
    int i = 0;
    l locall = new l();
    d[] arrayOfd1 = this.a;
    int j = arrayOfd1.length;
    for (int k = 0; k < j; k++)
      arrayOfd1[k].a(paramh, parama, false, locall);
    d[] arrayOfd2 = this.a;
    int m = arrayOfd2.length;
    while (i < m)
    {
      arrayOfd2[i].a(paramh, parama, true, locall);
      i++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.CompositeGeneratedAdaptersObserver
 * JD-Core Version:    0.6.2
 */
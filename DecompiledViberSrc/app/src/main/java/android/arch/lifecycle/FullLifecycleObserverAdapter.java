package android.arch.lifecycle;

class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  private final FullLifecycleObserver a;

  FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    this.a = paramFullLifecycleObserver;
  }

  public void a(h paramh, e.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      return;
    case 1:
      this.a.onCreate(paramh);
      return;
    case 2:
      this.a.onStart(paramh);
      return;
    case 3:
      this.a.onResume(paramh);
      return;
    case 4:
      this.a.onPause(paramh);
      return;
    case 5:
      this.a.onStop(paramh);
      return;
    case 6:
      this.a.onDestroy(paramh);
      return;
    case 7:
    }
    throw new IllegalArgumentException("ON_ANY must not been send by anybody");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.6.2
 */
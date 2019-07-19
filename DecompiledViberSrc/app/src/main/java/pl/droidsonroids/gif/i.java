package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class i extends Handler
{
  private final WeakReference<b> a;

  public i(b paramb)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramb);
  }

  public void handleMessage(Message paramMessage)
  {
    b localb = (b)this.a.get();
    if (localb == null);
    while (true)
    {
      return;
      if (paramMessage.what == -1)
      {
        localb.invalidateSelf();
        return;
      }
      Iterator localIterator = localb.g.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a(paramMessage.what);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.i
 * JD-Core Version:    0.6.2
 */
package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

public class k
  implements Drawable.Callback
{
  private final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList();
  private final boolean b;

  public k()
  {
    this(false);
  }

  public k(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public void a(Drawable.Callback paramCallback)
  {
    for (int i = 0; i < this.a.size(); i++)
    {
      a locala = (a)this.a.get(i);
      if ((Drawable.Callback)locala.get() == null)
        this.a.remove(locala);
    }
    this.a.addIfAbsent(new a(paramCallback));
  }

  public void b(Drawable.Callback paramCallback)
  {
    for (int i = 0; i < this.a.size(); i++)
    {
      a locala = (a)this.a.get(i);
      Drawable.Callback localCallback = (Drawable.Callback)locala.get();
      if ((localCallback == null) || (localCallback == paramCallback))
        this.a.remove(locala);
    }
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    int i = 0;
    if (i < this.a.size())
    {
      a locala = (a)this.a.get(i);
      Drawable.Callback localCallback = (Drawable.Callback)locala.get();
      if (localCallback != null)
        if ((this.b) && ((localCallback instanceof View)))
          ((View)localCallback).invalidate();
      while (true)
      {
        i++;
        break;
        localCallback.invalidateDrawable(paramDrawable);
        continue;
        this.a.remove(locala);
      }
    }
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    int i = 0;
    if (i < this.a.size())
    {
      a locala = (a)this.a.get(i);
      Drawable.Callback localCallback = (Drawable.Callback)locala.get();
      if (localCallback != null)
        localCallback.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      while (true)
      {
        i++;
        break;
        this.a.remove(locala);
      }
    }
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    int i = 0;
    if (i < this.a.size())
    {
      a locala = (a)this.a.get(i);
      Drawable.Callback localCallback = (Drawable.Callback)locala.get();
      if (localCallback != null)
        localCallback.unscheduleDrawable(paramDrawable, paramRunnable);
      while (true)
      {
        i++;
        break;
        this.a.remove(locala);
      }
    }
  }

  static final class a extends WeakReference<Drawable.Callback>
  {
    a(Drawable.Callback paramCallback)
    {
      super();
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
      }
      while (get() == ((a)paramObject).get());
      return false;
    }

    public int hashCode()
    {
      Drawable.Callback localCallback = (Drawable.Callback)get();
      if (localCallback != null)
        return localCallback.hashCode();
      return 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.k
 * JD-Core Version:    0.6.2
 */
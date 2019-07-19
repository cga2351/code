package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public abstract class d<T extends d<T>>
{
  private h a;
  private b b;
  private ScheduledThreadPoolExecutor c;
  private boolean d = true;
  private f e = new f();

  public T a(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.a = new h.a(paramContentResolver, paramUri);
    return b();
  }

  public T a(f paramf)
  {
    this.e.a(paramf);
    return b();
  }

  protected abstract T b();

  public b c()
    throws IOException
  {
    if (this.a == null)
      throw new NullPointerException("Source is not set");
    return this.a.a(this.b, this.c, this.d, this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.d
 * JD-Core Version:    0.6.2
 */
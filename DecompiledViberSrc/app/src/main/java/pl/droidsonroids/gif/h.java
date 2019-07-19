package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public abstract class h
{
  abstract GifInfoHandle a()
    throws IOException;

  final GifInfoHandle a(f paramf)
    throws IOException
  {
    GifInfoHandle localGifInfoHandle = a();
    localGifInfoHandle.a(paramf.a, paramf.b);
    return localGifInfoHandle;
  }

  final b a(b paramb, ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, boolean paramBoolean, f paramf)
    throws IOException
  {
    return new b(a(paramf), paramb, paramScheduledThreadPoolExecutor, paramBoolean);
  }

  public static final class a extends h
  {
    private final ContentResolver a;
    private final Uri b;

    public a(ContentResolver paramContentResolver, Uri paramUri)
    {
      super();
      this.a = paramContentResolver;
      this.b = paramUri;
    }

    GifInfoHandle a()
      throws IOException
    {
      return GifInfoHandle.a(this.a, this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.h
 * JD-Core Version:    0.6.2
 */
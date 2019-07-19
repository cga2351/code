package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.f.aa.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class b<T extends a<T>>
  implements aa.a<T>
{
  private final aa.a<T> a;
  private final List<c> b;

  public b(aa.a<T> parama, List<c> paramList)
  {
    this.a = parama;
    this.b = paramList;
  }

  public T a(Uri paramUri, InputStream paramInputStream)
    throws IOException
  {
    a locala = (a)this.a.b(paramUri, paramInputStream);
    if ((this.b == null) || (this.b.isEmpty()))
      return locala;
    return (a)locala.a(this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.offline.b
 * JD-Core Version:    0.6.2
 */
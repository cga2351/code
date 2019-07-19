package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.metadata.id3.a.a;
import java.io.EOFException;
import java.io.IOException;

public final class l
{
  private final r a = new r(10);

  public Metadata a(h paramh, a.a parama)
    throws IOException, InterruptedException
  {
    Metadata localMetadata = null;
    int i = 0;
    try
    {
      paramh.c(this.a.a, 0, 10);
      this.a.c(0);
      if (this.a.l() != a.b)
      {
        label42: paramh.a();
        paramh.c(i);
        return localMetadata;
      }
      this.a.d(3);
      int j = this.a.u();
      int k = j + 10;
      if (localMetadata == null)
      {
        byte[] arrayOfByte = new byte[k];
        System.arraycopy(this.a.a, 0, arrayOfByte, 0, 10);
        paramh.c(arrayOfByte, 10, j);
        localMetadata = new a(parama).a(arrayOfByte, k);
      }
      while (true)
      {
        i += k;
        break;
        paramh.c(j);
      }
    }
    catch (EOFException localEOFException)
    {
      break label42;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.l
 * JD-Core Version:    0.6.2
 */
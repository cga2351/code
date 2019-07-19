package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.c;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  public Metadata a(c paramc)
  {
    ByteBuffer localByteBuffer = paramc.b;
    byte[] arrayOfByte1 = localByteBuffer.array();
    int i = localByteBuffer.limit();
    r localr = new r(arrayOfByte1, i);
    String str1 = (String)com.google.android.exoplayer2.g.a.a(localr.A());
    String str2 = (String)com.google.android.exoplayer2.g.a.a(localr.A());
    long l1 = localr.n();
    long l2 = ag.d(localr.n(), 1000000L, l1);
    long l3 = ag.d(localr.n(), 1000L, l1);
    long l4 = localr.n();
    byte[] arrayOfByte2 = Arrays.copyOfRange(arrayOfByte1, localr.d(), i);
    Metadata.Entry[] arrayOfEntry = new Metadata.Entry[1];
    arrayOfEntry[0] = new EventMessage(str1, str2, l3, l4, arrayOfByte2, l2);
    return new Metadata(arrayOfEntry);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.a
 * JD-Core Version:    0.6.2
 */
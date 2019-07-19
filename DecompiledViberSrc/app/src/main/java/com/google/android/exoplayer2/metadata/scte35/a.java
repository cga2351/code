package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.c;
import java.nio.ByteBuffer;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  private final r a = new r();
  private final q b = new q();
  private ad c;

  public Metadata a(c paramc)
  {
    if ((this.c == null) || (paramc.d != this.c.c()))
    {
      this.c = new ad(paramc.c);
      this.c.c(paramc.c - paramc.d);
    }
    ByteBuffer localByteBuffer = paramc.b;
    byte[] arrayOfByte = localByteBuffer.array();
    int i = localByteBuffer.limit();
    this.a.a(arrayOfByte, i);
    this.b.a(arrayOfByte, i);
    this.b.b(39);
    long l = this.b.c(1) << 32 | this.b.c(32);
    this.b.b(20);
    int j = this.b.c(12);
    int k = this.b.c(8);
    this.a.d(14);
    Object localObject;
    switch (k)
    {
    default:
      localObject = null;
    case 0:
    case 4:
    case 5:
    case 6:
    case 255:
    }
    while (localObject == null)
    {
      return new Metadata(new Metadata.Entry[0]);
      localObject = new SpliceNullCommand();
      continue;
      localObject = SpliceScheduleCommand.parseFromSection(this.a);
      continue;
      localObject = SpliceInsertCommand.parseFromSection(this.a, l, this.c);
      continue;
      localObject = TimeSignalCommand.parseFromSection(this.a, l, this.c);
      continue;
      localObject = PrivateCommand.parseFromSection(this.a, j, l);
    }
    return new Metadata(new Metadata.Entry[] { localObject });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.a
 * JD-Core Version:    0.6.2
 */
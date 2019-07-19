package okhttp3.internal.cache2;

import f.c;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class FileOperator
{
  private final FileChannel fileChannel;

  FileOperator(FileChannel paramFileChannel)
  {
    this.fileChannel = paramFileChannel;
  }

  public void read(long paramLong1, c paramc, long paramLong2)
    throws IOException
  {
    if (paramLong2 < 0L)
      throw new IndexOutOfBoundsException();
    while (true)
    {
      Object localObject1;
      long l2;
      long l1;
      if (localObject1 > 0L)
      {
        Object localObject2;
        long l3 = this.fileChannel.transferTo(localObject2, localObject1, paramc);
        localObject2 += l3;
        localObject1 -= l3;
      }
      else
      {
        return;
        l1 = paramLong2;
        l2 = paramLong1;
      }
    }
  }

  public void write(long paramLong1, c paramc, long paramLong2)
    throws IOException
  {
    if ((paramLong2 < 0L) || (paramLong2 > paramc.a()))
      throw new IndexOutOfBoundsException();
    while (true)
    {
      Object localObject1;
      long l2;
      long l1;
      if (localObject1 > 0L)
      {
        Object localObject2;
        long l3 = this.fileChannel.transferFrom(paramc, localObject2, localObject1);
        localObject2 += l3;
        localObject1 -= l3;
      }
      else
      {
        return;
        l1 = paramLong2;
        l2 = paramLong1;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache2.FileOperator
 * JD-Core Version:    0.6.2
 */
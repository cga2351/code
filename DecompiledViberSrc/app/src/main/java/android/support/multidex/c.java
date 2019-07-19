package android.support.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class c
{
  static long a(File paramFile)
    throws IOException
  {
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    try
    {
      long l = a(localRandomAccessFile, a(localRandomAccessFile));
      return l;
    }
    finally
    {
      localRandomAccessFile.close();
    }
  }

  static long a(RandomAccessFile paramRandomAccessFile, a parama)
    throws IOException
  {
    CRC32 localCRC32 = new CRC32();
    long l = parama.b;
    paramRandomAccessFile.seek(parama.a);
    int i = (int)Math.min(16384L, l);
    byte[] arrayOfByte = new byte[16384];
    for (int j = paramRandomAccessFile.read(arrayOfByte, 0, i); ; j = paramRandomAccessFile.read(arrayOfByte, 0, (int)Math.min(16384L, l)))
      if (j != -1)
      {
        localCRC32.update(arrayOfByte, 0, j);
        l -= j;
        if (l != 0L);
      }
      else
      {
        return localCRC32.getValue();
      }
  }

  static a a(RandomAccessFile paramRandomAccessFile)
    throws IOException, ZipException
  {
    long l1 = 0L;
    long l2 = paramRandomAccessFile.length() - 22L;
    if (l2 < l1)
      throw new ZipException("File too short to be a zip file: " + paramRandomAccessFile.length());
    long l3 = l2 - 65536L;
    if (l3 < l1);
    while (true)
    {
      int i = Integer.reverseBytes(101010256);
      long l4 = l2;
      do
      {
        paramRandomAccessFile.seek(l4);
        if (paramRandomAccessFile.readInt() == i)
        {
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          a locala = new a();
          locala.b = (0xFFFFFFFF & Integer.reverseBytes(paramRandomAccessFile.readInt()));
          locala.a = (0xFFFFFFFF & Integer.reverseBytes(paramRandomAccessFile.readInt()));
          return locala;
        }
        l4 -= 1L;
      }
      while (l4 >= l1);
      throw new ZipException("End Of Central Directory signature not found");
      l1 = l3;
    }
  }

  static class a
  {
    long a;
    long b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.multidex.c
 * JD-Core Version:    0.6.2
 */
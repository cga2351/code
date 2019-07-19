package c.a.a.a.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class u
  implements Closeable
{
  private static final Logger b = Logger.getLogger(u.class.getName());
  int a;
  private final RandomAccessFile c;
  private int d;
  private a e;
  private a f;
  private final byte[] g = new byte[16];

  public u(File paramFile)
    throws IOException
  {
    if (!paramFile.exists())
      a(paramFile);
    this.c = b(paramFile);
    e();
  }

  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return ((0xFF & paramArrayOfByte[paramInt]) << 24) + ((0xFF & paramArrayOfByte[(paramInt + 1)]) << 16) + ((0xFF & paramArrayOfByte[(paramInt + 2)]) << 8) + (0xFF & paramArrayOfByte[(paramInt + 3)]);
  }

  private a a(int paramInt)
    throws IOException
  {
    if (paramInt == 0)
      return a.a;
    this.c.seek(paramInt);
    return new a(paramInt, this.c.readInt());
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException
  {
    a(this.g, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
    this.c.seek(0L);
    this.c.write(this.g);
  }

  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException
  {
    int i = b(paramInt1);
    if (i + paramInt3 <= this.a)
    {
      this.c.seek(i);
      this.c.write(paramArrayOfByte, paramInt2, paramInt3);
      return;
    }
    int j = this.a - i;
    this.c.seek(i);
    this.c.write(paramArrayOfByte, paramInt2, j);
    this.c.seek(16L);
    this.c.write(paramArrayOfByte, paramInt2 + j, paramInt3 - j);
  }

  private static void a(File paramFile)
    throws IOException
  {
    File localFile = new File(paramFile.getPath() + ".tmp");
    RandomAccessFile localRandomAccessFile = b(localFile);
    try
    {
      localRandomAccessFile.setLength(4096L);
      localRandomAccessFile.seek(0L);
      byte[] arrayOfByte = new byte[16];
      a(arrayOfByte, new int[] { 4096, 0, 0, 0 });
      localRandomAccessFile.write(arrayOfByte);
      localRandomAccessFile.close();
      if (!localFile.renameTo(paramFile))
        throw new IOException("Rename failed!");
    }
    finally
    {
      localRandomAccessFile.close();
    }
  }

  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    int k = 0;
    while (i < j)
    {
      b(paramArrayOfByte, k, paramArrayOfInt[i]);
      k += 4;
      i++;
    }
  }

  private int b(int paramInt)
  {
    if (paramInt < this.a)
      return paramInt;
    return paramInt + 16 - this.a;
  }

  private static RandomAccessFile b(File paramFile)
    throws FileNotFoundException
  {
    return new RandomAccessFile(paramFile, "rwd");
  }

  private static <T> T b(T paramT, String paramString)
  {
    if (paramT == null)
      throw new NullPointerException(paramString);
    return paramT;
  }

  private void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException
  {
    int i = b(paramInt1);
    if (i + paramInt3 <= this.a)
    {
      this.c.seek(i);
      this.c.readFully(paramArrayOfByte, paramInt2, paramInt3);
      return;
    }
    int j = this.a - i;
    this.c.seek(i);
    this.c.readFully(paramArrayOfByte, paramInt2, j);
    this.c.seek(16L);
    this.c.readFully(paramArrayOfByte, paramInt2 + j, paramInt3 - j);
  }

  private static void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 24));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)paramInt2);
  }

  private void c(int paramInt)
    throws IOException
  {
    int i = paramInt + 4;
    int j = f();
    if (j >= i)
      return;
    int k = this.a;
    do
    {
      j += k;
      k <<= 1;
    }
    while (j < i);
    d(k);
    int m = b(4 + this.f.b + this.f.c);
    if (m < this.e.b)
    {
      FileChannel localFileChannel = this.c.getChannel();
      localFileChannel.position(this.a);
      int i1 = m - 4;
      if (localFileChannel.transferTo(16L, i1, localFileChannel) != i1)
        throw new AssertionError("Copied insufficient number of bytes!");
    }
    if (this.f.b < this.e.b)
    {
      int n = -16 + (this.a + this.f.b);
      a(k, this.d, this.e.b, n);
      this.f = new a(n, this.f.c);
    }
    while (true)
    {
      this.a = k;
      return;
      a(k, this.d, this.e.b, this.f.b);
    }
  }

  private void d(int paramInt)
    throws IOException
  {
    this.c.setLength(paramInt);
    this.c.getChannel().force(true);
  }

  private void e()
    throws IOException
  {
    this.c.seek(0L);
    this.c.readFully(this.g);
    this.a = a(this.g, 0);
    if (this.a > this.c.length())
      throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.c.length());
    this.d = a(this.g, 4);
    int i = a(this.g, 8);
    int j = a(this.g, 12);
    this.e = a(i);
    this.f = a(j);
  }

  private int f()
  {
    return this.a - a();
  }

  public int a()
  {
    if (this.d == 0)
      return 16;
    if (this.f.b >= this.e.b)
      return 16 + (4 + (this.f.b - this.e.b) + this.f.c);
    return 4 + this.f.b + this.f.c + this.a - this.e.b;
  }

  public void a(c paramc)
    throws IOException
  {
    try
    {
      int i = this.e.b;
      for (int j = 0; j < this.d; j++)
      {
        a locala = a(i);
        paramc.a(new b(locala, null), locala.c);
        int k = b(4 + locala.b + locala.c);
        i = k;
      }
      return;
    }
    finally
    {
    }
  }

  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      b(paramArrayOfByte, "buffer");
      if (((paramInt1 | paramInt2) < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1))
        throw new IndexOutOfBoundsException();
    }
    finally
    {
    }
    c(paramInt2);
    boolean bool = b();
    int i;
    a locala;
    if (bool)
    {
      i = 16;
      locala = new a(i, paramInt2);
      b(this.g, 0, paramInt2);
      a(locala.b, this.g, 0, 4);
      a(4 + locala.b, paramArrayOfByte, paramInt1, paramInt2);
      if (!bool)
        break label199;
    }
    label199: for (int j = locala.b; ; j = this.e.b)
    {
      a(this.a, 1 + this.d, j, locala.b);
      this.f = locala;
      this.d = (1 + this.d);
      if (bool)
        this.e = this.f;
      return;
      i = b(4 + this.f.b + this.f.c);
      break;
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 + (4 + a()) <= paramInt2;
  }

  public boolean b()
  {
    try
    {
      int i = this.d;
      if (i == 0)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public void c()
    throws IOException
  {
    try
    {
      if (b())
        throw new NoSuchElementException();
    }
    finally
    {
    }
    if (this.d == 1)
      d();
    while (true)
    {
      return;
      int i = b(4 + this.e.b + this.e.c);
      b(i, this.g, 0, 4);
      int j = a(this.g, 0);
      a(this.a, -1 + this.d, i, this.f.b);
      this.d = (-1 + this.d);
      this.e = new a(i, j);
    }
  }

  public void close()
    throws IOException
  {
    try
    {
      this.c.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d()
    throws IOException
  {
    try
    {
      a(4096, 0, 0, 0);
      this.d = 0;
      this.e = a.a;
      this.f = a.a;
      if (this.a > 4096)
        d(4096);
      this.a = 4096;
      return;
    }
    finally
    {
    }
  }

  public String toString()
  {
    final StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName()).append('[');
    localStringBuilder.append("fileLength=").append(this.a);
    localStringBuilder.append(", size=").append(this.d);
    localStringBuilder.append(", first=").append(this.e);
    localStringBuilder.append(", last=").append(this.f);
    localStringBuilder.append(", element lengths=[");
    try
    {
      a(new c()
      {
        boolean a = true;

        public void a(InputStream paramAnonymousInputStream, int paramAnonymousInt)
          throws IOException
        {
          if (this.a)
            this.a = false;
          while (true)
          {
            localStringBuilder.append(paramAnonymousInt);
            return;
            localStringBuilder.append(", ");
          }
        }
      });
      localStringBuilder.append("]]");
      return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      while (true)
        b.log(Level.WARNING, "read error", localIOException);
    }
  }

  static class a
  {
    static final a a = new a(0, 0);
    final int b;
    final int c;

    a(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      this.c = paramInt2;
    }

    public String toString()
    {
      return getClass().getSimpleName() + "[position = " + this.b + ", length = " + this.c + "]";
    }
  }

  private final class b extends InputStream
  {
    private int b;
    private int c;

    private b(u.a arg2)
    {
      Object localObject;
      this.b = u.a(u.this, 4 + localObject.b);
      this.c = localObject.c;
    }

    public int read()
      throws IOException
    {
      if (this.c == 0)
        return -1;
      u.a(u.this).seek(this.b);
      int i = u.a(u.this).read();
      this.b = u.a(u.this, 1 + this.b);
      this.c = (-1 + this.c);
      return i;
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      u.a(paramArrayOfByte, "buffer");
      if (((paramInt1 | paramInt2) < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1))
        throw new ArrayIndexOutOfBoundsException();
      if (this.c > 0)
      {
        if (paramInt2 > this.c)
          paramInt2 = this.c;
        u.a(u.this, this.b, paramArrayOfByte, paramInt1, paramInt2);
        this.b = u.a(u.this, paramInt2 + this.b);
        this.c -= paramInt2;
        return paramInt2;
      }
      return -1;
    }
  }

  public static abstract interface c
  {
    public abstract void a(InputStream paramInputStream, int paramInt)
      throws IOException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.u
 * JD-Core Version:    0.6.2
 */
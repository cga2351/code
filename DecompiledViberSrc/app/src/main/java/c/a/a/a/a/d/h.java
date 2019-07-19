package c.a.a.a.a.d;

import android.content.Context;
import c.a.a.a.a.b.i;
import c.a.a.a.a.b.u;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class h
  implements c
{
  private final Context a;
  private final File b;
  private final String c;
  private final File d;
  private u e;
  private File f;

  public h(Context paramContext, File paramFile, String paramString1, String paramString2)
    throws IOException
  {
    this.a = paramContext;
    this.b = paramFile;
    this.c = paramString2;
    this.d = new File(this.b, paramString1);
    this.e = new u(this.d);
    e();
  }

  // ERROR //
  private void a(File paramFile1, File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 48	java/io/FileInputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore 4
    //   12: aload_0
    //   13: aload_2
    //   14: invokevirtual 52	c/a/a/a/a/d/h:a	(Ljava/io/File;)Ljava/io/OutputStream;
    //   17: astore_3
    //   18: aload 4
    //   20: aload_3
    //   21: sipush 1024
    //   24: newarray byte
    //   26: invokestatic 57	c/a/a/a/a/b/i:a	(Ljava/io/InputStream;Ljava/io/OutputStream;[B)V
    //   29: aload 4
    //   31: ldc 59
    //   33: invokestatic 62	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   36: aload_3
    //   37: ldc 64
    //   39: invokestatic 62	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   42: aload_1
    //   43: invokevirtual 68	java/io/File:delete	()Z
    //   46: pop
    //   47: return
    //   48: astore 5
    //   50: aconst_null
    //   51: astore 4
    //   53: aload 4
    //   55: ldc 59
    //   57: invokestatic 62	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   60: aload_3
    //   61: ldc 64
    //   63: invokestatic 62	c/a/a/a/a/b/i:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   66: aload_1
    //   67: invokevirtual 68	java/io/File:delete	()Z
    //   70: pop
    //   71: aload 5
    //   73: athrow
    //   74: astore 5
    //   76: goto -23 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   2	12	48	finally
    //   12	29	74	finally
  }

  private void e()
  {
    this.f = new File(this.b, this.c);
    if (!this.f.exists())
      this.f.mkdirs();
  }

  public int a()
  {
    return this.e.a();
  }

  public OutputStream a(File paramFile)
    throws IOException
  {
    return new FileOutputStream(paramFile);
  }

  public List<File> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = this.f.listFiles();
    int i = arrayOfFile.length;
    for (int j = 0; ; j++)
      if (j < i)
      {
        localArrayList.add(arrayOfFile[j]);
        if (localArrayList.size() < paramInt);
      }
      else
      {
        return localArrayList;
      }
  }

  public void a(String paramString)
    throws IOException
  {
    this.e.close();
    a(this.d, new File(this.f, paramString));
    this.e = new u(this.d);
  }

  public void a(List<File> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      Context localContext = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localFile.getName();
      i.a(localContext, String.format("deleting sent analytics file %s", arrayOfObject));
      localFile.delete();
    }
  }

  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    this.e.a(paramArrayOfByte);
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return this.e.a(paramInt1, paramInt2);
  }

  public boolean b()
  {
    return this.e.b();
  }

  public List<File> c()
  {
    return Arrays.asList(this.f.listFiles());
  }

  public void d()
  {
    try
    {
      this.e.close();
      label7: this.d.delete();
      return;
    }
    catch (IOException localIOException)
    {
      break label7;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.d.h
 * JD-Core Version:    0.6.2
 */
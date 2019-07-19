package a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.appboy.f.c;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ae
{
  private static final String a = c.a(ae.class);
  private final af b;

  public ae(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.b = af.a(paramFile, paramInt1, paramInt2, paramLong);
  }

  private String c(String paramString)
  {
    return Integer.toString(paramString.hashCode());
  }

  // ERROR //
  public Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 47	a/a/ae:c	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: aload_0
    //   7: getfield 28	a/a/ae:b	La/a/af;
    //   10: aload_2
    //   11: invokevirtual 50	a/a/af:a	(Ljava/lang/String;)La/a/af$b;
    //   14: astore 9
    //   16: aload 9
    //   18: astore 4
    //   20: aload 4
    //   22: iconst_0
    //   23: invokevirtual 55	a/a/af$b:a	(I)Ljava/io/InputStream;
    //   26: invokestatic 61	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   29: astore 10
    //   31: aload 4
    //   33: ifnull +8 -> 41
    //   36: aload 4
    //   38: invokevirtual 64	a/a/af$b:close	()V
    //   41: aload 10
    //   43: areturn
    //   44: astore 6
    //   46: aconst_null
    //   47: astore 4
    //   49: getstatic 17	a/a/ae:a	Ljava/lang/String;
    //   52: new 66	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   59: ldc 69
    //   61: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: aload 6
    //   73: invokestatic 80	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   76: pop
    //   77: aload 4
    //   79: ifnull +8 -> 87
    //   82: aload 4
    //   84: invokevirtual 64	a/a/af$b:close	()V
    //   87: getstatic 17	a/a/ae:a	Ljava/lang/String;
    //   90: new 66	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   97: ldc 82
    //   99: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 85	com/appboy/f/c:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   112: pop
    //   113: aconst_null
    //   114: areturn
    //   115: astore_3
    //   116: aconst_null
    //   117: astore 4
    //   119: aload_3
    //   120: astore 5
    //   122: aload 4
    //   124: ifnull +8 -> 132
    //   127: aload 4
    //   129: invokevirtual 64	a/a/af$b:close	()V
    //   132: aload 5
    //   134: athrow
    //   135: astore 5
    //   137: goto -15 -> 122
    //   140: astore 6
    //   142: goto -93 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   6	16	44	java/lang/Throwable
    //   6	16	115	finally
    //   20	31	135	finally
    //   49	77	135	finally
    //   20	31	140	java/lang/Throwable
  }

  public void a(String paramString, Bitmap paramBitmap)
  {
    String str = c(paramString);
    OutputStream localOutputStream = null;
    try
    {
      af.a locala = this.b.b(str);
      localOutputStream = locala.a(0);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localOutputStream);
      localOutputStream.flush();
      localOutputStream.close();
      locala.a();
      if (localOutputStream != null);
      try
      {
        localOutputStream.close();
        return;
      }
      catch (IOException localIOException3)
      {
        c.d(a, "Exception while closing disk cache output stream for key" + str, localIOException3);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      do
        c.d(a, "Error while producing output stream or compressing bitmap for key " + str, localThrowable);
      while (localOutputStream == null);
      try
      {
        localOutputStream.close();
        return;
      }
      catch (IOException localIOException2)
      {
        c.d(a, "Exception while closing disk cache output stream for key" + str, localIOException2);
        return;
      }
    }
    finally
    {
      if (localOutputStream == null);
    }
    try
    {
      localOutputStream.close();
      throw localObject;
    }
    catch (IOException localIOException1)
    {
      while (true)
        c.d(a, "Exception while closing disk cache output stream for key" + str, localIOException1);
    }
  }

  public boolean b(String paramString)
  {
    String str = c(paramString);
    try
    {
      af.b localb = this.b.a(str);
      bool = false;
      if (localb != null)
        bool = true;
      if (localb != null)
        localb.close();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      c.d(a, "Error while retrieving disk for key " + str, localThrowable);
      boolean bool = false;
      return false;
    }
    finally
    {
      if (0 != 0)
        null.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ae
 * JD-Core Version:    0.6.2
 */
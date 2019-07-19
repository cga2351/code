package com.viber.voip.stickers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.AndroidSvgObject;
import com.viber.voip.ViberEnv;
import java.io.FileNotFoundException;
import java.io.IOException;

public class aa
{
  private static final Logger a = ViberEnv.getLogger();

  // ERROR //
  public Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 26	com/viber/voip/stickers/aa:b	(Ljava/lang/String;)Lcom/viber/svg/jni/AndroidSvgObject;
    //   5: astore 8
    //   7: aload 8
    //   9: astore 5
    //   11: aload 5
    //   13: ifnonnull +15 -> 28
    //   16: aload 5
    //   18: ifnull +8 -> 26
    //   21: aload 5
    //   23: invokevirtual 31	com/viber/svg/jni/AndroidSvgObject:destroy	()V
    //   26: aconst_null
    //   27: areturn
    //   28: iload_2
    //   29: iload_3
    //   30: getstatic 37	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   33: invokestatic 43	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   36: astore 9
    //   38: aload_0
    //   39: aload 5
    //   41: aload 9
    //   43: iload_2
    //   44: iload_3
    //   45: invokevirtual 46	com/viber/voip/stickers/aa:a	(Lcom/viber/svg/jni/AndroidSvgObject;Landroid/graphics/Bitmap;II)V
    //   48: aload 5
    //   50: ifnull +8 -> 58
    //   53: aload 5
    //   55: invokevirtual 31	com/viber/svg/jni/AndroidSvgObject:destroy	()V
    //   58: aload 9
    //   60: areturn
    //   61: astore 7
    //   63: aconst_null
    //   64: astore 5
    //   66: getstatic 16	com/viber/voip/stickers/aa:a	Lcom/viber/dexshared/Logger;
    //   69: aload 7
    //   71: new 48	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   78: ldc 51
    //   80: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokeinterface 64 3 0
    //   95: aload 5
    //   97: ifnull -71 -> 26
    //   100: aload 5
    //   102: invokevirtual 31	com/viber/svg/jni/AndroidSvgObject:destroy	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore 4
    //   109: aconst_null
    //   110: astore 5
    //   112: aload 4
    //   114: astore 6
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokevirtual 31	com/viber/svg/jni/AndroidSvgObject:destroy	()V
    //   126: aload 6
    //   128: athrow
    //   129: astore 6
    //   131: goto -15 -> 116
    //   134: astore 7
    //   136: goto -70 -> 66
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	61	java/lang/OutOfMemoryError
    //   0	7	107	finally
    //   28	48	129	finally
    //   66	95	129	finally
    //   28	48	134	java/lang/OutOfMemoryError
  }

  public void a(AndroidSvgObject paramAndroidSvgObject, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    paramAndroidSvgObject.prepare(paramInt1, paramInt2);
    paramAndroidSvgObject.renderToArea(new Canvas(paramBitmap), 0, 0, paramInt1, paramInt2, paramAndroidSvgObject.getMaxTime());
  }

  public void a(AndroidSvgObject paramAndroidSvgObject, Picture paramPicture, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramPicture == null)
      return;
    Canvas localCanvas = paramPicture.beginRecording(paramInt1, paramInt2);
    paramAndroidSvgObject.prepare(paramInt1, paramInt2);
    if (paramBoolean);
    for (double d = 0.0D; ; d = paramAndroidSvgObject.getMaxTime())
    {
      paramAndroidSvgObject.renderToArea(localCanvas, 0, 0, paramInt1, paramInt2, d);
      paramPicture.endRecording();
      return;
    }
  }

  public int[] a(AndroidSvgObject paramAndroidSvgObject)
    throws IOException
  {
    return new int[] { paramAndroidSvgObject.getWidth(), paramAndroidSvgObject.getHeight() };
  }

  public AndroidSvgObject b(String paramString)
  {
    try
    {
      AndroidSvgObject localAndroidSvgObject = new AndroidSvgObject(paramString, 0);
      localAndroidSvgObject.parseFile(paramString);
      return localAndroidSvgObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      return null;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.aa
 * JD-Core Version:    0.6.2
 */
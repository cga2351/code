package com.viber.voip.videoconvert;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import com.viber.voip.Resolution;
import java.util.Map;
import java.util.TreeMap;

public class o
{
  private static final Resolution[] a;
  private static final Resolution[] b;
  private static final Map<Integer, Resolution> c;
  private static final Map<Integer, Resolution> d;

  static
  {
    int i = 0;
    Resolution[] arrayOfResolution1 = new Resolution[7];
    arrayOfResolution1[0] = new Resolution(320, 240, 250000);
    arrayOfResolution1[1] = new Resolution(480, 320, 300000);
    arrayOfResolution1[2] = new Resolution(640, 480, 400000);
    arrayOfResolution1[3] = new Resolution(800, 600, 700000);
    arrayOfResolution1[4] = new Resolution(1024, 768, 800000);
    arrayOfResolution1[5] = new Resolution(1280, 800, 1000000);
    arrayOfResolution1[6] = new Resolution(1600, 1200, 1350000);
    a = arrayOfResolution1;
    Resolution[] arrayOfResolution2 = new Resolution[6];
    arrayOfResolution2[0] = new Resolution(640, 360, 550000);
    arrayOfResolution2[1] = new Resolution(864, 486, 750000);
    arrayOfResolution2[2] = new Resolution(1024, 576, 950000);
    arrayOfResolution2[3] = new Resolution(1280, 720, 1000000);
    arrayOfResolution2[4] = new Resolution(1600, 900, 1350000);
    arrayOfResolution2[5] = new Resolution(1920, 1080, 1750000);
    b = arrayOfResolution2;
    c = new TreeMap();
    d = new TreeMap();
    for (Resolution localResolution2 : a)
      c.put(Integer.valueOf(localResolution2.hashCode()), localResolution2);
    Resolution[] arrayOfResolution4 = b;
    int m = arrayOfResolution4.length;
    while (i < m)
    {
      Resolution localResolution1 = arrayOfResolution4[i];
      d.put(Integer.valueOf(localResolution1.hashCode()), localResolution1);
      i++;
    }
  }

  public static Resolution a(Uri paramUri, long[] paramArrayOfLong)
  {
    try
    {
      MediaPlayer localMediaPlayer = MediaPlayer.create(VideoConverterService.b(), paramUri);
      int i = localMediaPlayer.getVideoWidth();
      int j = localMediaPlayer.getVideoHeight();
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
        paramArrayOfLong[0] = localMediaPlayer.getDuration();
      localMediaPlayer.release();
      return new Resolution(i, j);
    }
    catch (Throwable localThrowable)
    {
      e.a().a(localThrowable);
    }
    return null;
  }

  // ERROR //
  public static a a(com.viber.voip.VideoConverterRequest paramVideoConverterRequest)
  {
    // Byte code:
    //   0: iconst_1
    //   1: newarray long
    //   3: astore 4
    //   5: aload_0
    //   6: invokevirtual 104	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   9: aload 4
    //   11: invokestatic 106	com/viber/voip/videoconvert/o:b	(Landroid/net/Uri;[J)Lcom/viber/voip/Resolution;
    //   14: astore 5
    //   16: aload 5
    //   18: getfield 110	com/viber/voip/Resolution:width	I
    //   21: istore 6
    //   23: aload 5
    //   25: getfield 113	com/viber/voip/Resolution:height	I
    //   28: istore 7
    //   30: new 115	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 104	com/viber/voip/VideoConverterRequest:source	()Landroid/net/Uri;
    //   38: invokevirtual 121	android/net/Uri:getPath	()Ljava/lang/String;
    //   41: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 128	java/io/File:length	()J
    //   47: pop2
    //   48: iload 6
    //   50: iload 7
    //   52: if_icmple +89 -> 141
    //   55: iload 7
    //   57: i2d
    //   58: iload 6
    //   60: i2d
    //   61: ddiv
    //   62: dstore 10
    //   64: dload 10
    //   66: ldc2_w 129
    //   69: dmul
    //   70: d2i
    //   71: istore 12
    //   73: new 132	com/viber/voip/videoconvert/o$a
    //   76: dup
    //   77: invokespecial 133	com/viber/voip/videoconvert/o$a:<init>	()V
    //   80: astore_2
    //   81: aload_2
    //   82: sipush 1024
    //   85: putfield 135	com/viber/voip/videoconvert/o$a:a	I
    //   88: aload_2
    //   89: iload 12
    //   91: putfield 137	com/viber/voip/videoconvert/o$a:b	I
    //   94: aload_2
    //   95: ldc 25
    //   97: i2l
    //   98: putfield 140	com/viber/voip/videoconvert/o$a:c	J
    //   101: iload 7
    //   103: iload 6
    //   105: if_icmple +34 -> 139
    //   108: aload_2
    //   109: getfield 137	com/viber/voip/videoconvert/o$a:b	I
    //   112: aload_2
    //   113: getfield 135	com/viber/voip/videoconvert/o$a:a	I
    //   116: if_icmpgt +23 -> 139
    //   119: aload_2
    //   120: getfield 135	com/viber/voip/videoconvert/o$a:a	I
    //   123: istore 13
    //   125: aload_2
    //   126: aload_2
    //   127: getfield 137	com/viber/voip/videoconvert/o$a:b	I
    //   130: putfield 135	com/viber/voip/videoconvert/o$a:a	I
    //   133: aload_2
    //   134: iload 13
    //   136: putfield 137	com/viber/voip/videoconvert/o$a:b	I
    //   139: aload_2
    //   140: areturn
    //   141: iload 6
    //   143: i2d
    //   144: iload 7
    //   146: i2d
    //   147: ddiv
    //   148: dstore 10
    //   150: goto -86 -> 64
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_1
    //   157: astore_3
    //   158: invokestatic 92	com/viber/voip/videoconvert/e:a	()Lcom/viber/voip/videoconvert/e;
    //   161: aload_3
    //   162: invokevirtual 95	com/viber/voip/videoconvert/e:a	(Ljava/lang/Throwable;)V
    //   165: aload_2
    //   166: areturn
    //   167: astore_3
    //   168: goto -10 -> 158
    //
    // Exception table:
    //   from	to	target	type
    //   0	48	153	java/lang/Exception
    //   55	64	153	java/lang/Exception
    //   73	81	153	java/lang/Exception
    //   81	101	167	java/lang/Exception
    //   108	139	167	java/lang/Exception
  }

  public static Resolution b(Uri paramUri, long[] paramArrayOfLong)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(VideoConverterService.b(), paramUri);
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
        paramArrayOfLong[0] = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(9));
      localMediaMetadataRetriever.release();
      return new Resolution(i, j);
    }
    catch (Throwable localThrowable)
    {
      e.a().a(localThrowable);
    }
    return a(paramUri, paramArrayOfLong);
  }

  public static class a
  {
    public int a;
    public int b;
    public long c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.o
 * JD-Core Version:    0.6.2
 */
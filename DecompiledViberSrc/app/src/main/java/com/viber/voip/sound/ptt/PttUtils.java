package com.viber.voip.sound.ptt;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import com.viber.voip.audioptt.c;
import com.viber.voip.i.c.k;
import com.viber.voip.i.f;
import com.viber.voip.util.dv;
import java.io.File;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PttUtils
{
  public static final int AUDIO_BIT_RATE = 32000;
  public static final int BIT_DEPTH_16 = 16;
  public static final int BIT_DEPTH_8 = 8;
  private static final int MAX_BASE64_BARS_LENGTH = 50;
  public static final short MAX_POSSIBLE_BAR_VOLUME = 127;
  public static final long MAX_PTT_DURATION_IN_MS = 0L;
  public static final int MAX_PTT_FRAMES_COUNT = 0;
  static final byte PTT_BARS_VERSION = 1;
  static final byte PTT_BARS_VERSION_SIZE_IN_BYTES = 1;
  private static final Pattern PTT_URI_PATTERN = Pattern.compile("/([^/]+)\\.speex$");
  public static final int PTT_VERSION_M4A = 3;
  public static final int PTT_VERSION_MEDIASHARE = 2;
  public static final int SAMPLE_RATE_16000 = 16000;
  public static final int SAMPLE_RATE_22050 = 22050;
  public static final int SAMPLE_RATE_32000 = 32000;
  public static final int SAMPLE_RATE_44100 = 44100;
  public static final int SAMPLE_RATE_48000 = 48000;
  public static final int SPEEX_DEFAULT_FRAME_BUFFER_SIZE = 65536;
  private static final int SPEEX_ERROR_DURATION = -1;
  public static final int SPEEX_FRAME_LENGTH_IN_MS = 20;
  public static final byte SPEEX_PREENCODED_HEADER = 26;
  public static final int VOLUME_BARS_COUNT = 30;
  private static final short VOLUME_BAR_NORMALIZE_THRESHOLD = 6000;

  public static File generateLegacyPttFile(String paramString, Context paramContext)
  {
    File localFile1 = dv.w.b(paramContext, paramString);
    if (!localFile1.exists())
    {
      File localFile2 = dv.y.b(paramContext, paramString);
      if ((localFile2.exists()) && (!localFile2.renameTo(localFile1)))
        return localFile2;
    }
    return localFile1;
  }

  public static String generateLegacyPttFileName(String paramString, Context paramContext)
  {
    return generateLegacyPttFile(paramString, paramContext).getAbsolutePath();
  }

  private static File generatePttFile(String paramString, Context paramContext)
  {
    if (c.k.a.e())
      return dv.x.b(paramContext, paramString);
    return generateLegacyPttFile(paramString, paramContext);
  }

  public static String generatePttFileName(String paramString, Context paramContext)
  {
    return generatePttFile(paramString, paramContext).getAbsolutePath();
  }

  public static int getBitDepth(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 56:
    case 1573:
    }
    while (true)
      switch (i)
      {
      default:
        return 16;
        if (paramString.equals("8"))
        {
          i = 0;
          continue;
          if (paramString.equals("16"))
            i = 2;
        }
        break;
      case 0:
      }
    return 8;
  }

  public static String getNextPttId()
  {
    return Long.toHexString(0xFFFFFFFF & new SecureRandom().nextInt() | (0xFFFFFFFF & System.currentTimeMillis() / 1000L) << 32);
  }

  private static short getNormalizedVolume(short paramShort1, short paramShort2, short paramShort3)
  {
    if (paramShort1 > 6000);
    while (true)
    {
      return (short)(paramShort1 * paramShort3 / paramShort2);
      paramShort2 = 6000;
    }
  }

  public static String getPackedBase64VolumeBars(String paramString)
  {
    return packVolumeBarsToBase64(getVolumeBars(getRawPttFramesVolumes(paramString), 30, (short)127));
  }

  public static String getPackedBase64VolumeBarsByPttId(String paramString, Context paramContext)
  {
    return getPackedBase64VolumeBars(getPttFileNameFromPttId(paramString, paramContext));
  }

  // ERROR //
  public static int getPttDuration(String paramString)
  {
    // Byte code:
    //   0: new 205	java/io/BufferedInputStream
    //   3: dup
    //   4: new 207	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 213	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_1
    //   16: ldc 43
    //   18: newarray byte
    //   20: astore_2
    //   21: aload_1
    //   22: aload_2
    //   23: iconst_0
    //   24: iconst_1
    //   25: invokevirtual 217	java/io/BufferedInputStream:read	([BII)I
    //   28: pop
    //   29: aload_2
    //   30: iconst_0
    //   31: baload
    //   32: istore 7
    //   34: iconst_0
    //   35: istore 8
    //   37: iload 7
    //   39: bipush 26
    //   41: if_icmpeq +12 -> 53
    //   44: aload_1
    //   45: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   48: iconst_m1
    //   49: ireturn
    //   50: iinc 8 1
    //   53: aload_1
    //   54: aload_2
    //   55: iconst_0
    //   56: iconst_2
    //   57: invokevirtual 217	java/io/BufferedInputStream:read	([BII)I
    //   60: istore 9
    //   62: iload 9
    //   64: iconst_2
    //   65: if_icmpge +13 -> 78
    //   68: aload_1
    //   69: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   72: iload 8
    //   74: bipush 20
    //   76: imul
    //   77: ireturn
    //   78: aload_2
    //   79: iconst_0
    //   80: baload
    //   81: istore 10
    //   83: aload_2
    //   84: iconst_1
    //   85: baload
    //   86: istore 11
    //   88: iload 10
    //   90: iload 11
    //   92: bipush 8
    //   94: ishl
    //   95: ior
    //   96: istore 12
    //   98: iload 12
    //   100: ldc 43
    //   102: if_icmplt +13 -> 115
    //   105: aload_1
    //   106: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   109: iconst_m1
    //   110: ireturn
    //   111: astore 5
    //   113: iconst_m1
    //   114: ireturn
    //   115: aload_1
    //   116: aload_2
    //   117: iconst_0
    //   118: iload 12
    //   120: invokevirtual 217	java/io/BufferedInputStream:read	([BII)I
    //   123: istore 13
    //   125: iload 13
    //   127: iload 12
    //   129: if_icmpeq -79 -> 50
    //   132: aload_1
    //   133: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   136: iconst_m1
    //   137: ireturn
    //   138: astore_3
    //   139: aload_1
    //   140: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   143: aload_3
    //   144: athrow
    //   145: astore 14
    //   147: iconst_m1
    //   148: ireturn
    //   149: astore 4
    //   151: iconst_m1
    //   152: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   44	48	111	java/io/IOException
    //   68	72	111	java/io/IOException
    //   105	109	111	java/io/IOException
    //   132	136	111	java/io/IOException
    //   139	145	111	java/io/IOException
    //   21	34	138	finally
    //   53	62	138	finally
    //   78	88	138	finally
    //   115	125	138	finally
    //   0	16	145	java/io/FileNotFoundException
    //   44	48	149	java/lang/IndexOutOfBoundsException
    //   68	72	149	java/lang/IndexOutOfBoundsException
    //   105	109	149	java/lang/IndexOutOfBoundsException
    //   132	136	149	java/lang/IndexOutOfBoundsException
    //   139	145	149	java/lang/IndexOutOfBoundsException
  }

  public static File getPttFileFromPttId(String paramString, Context paramContext)
  {
    if (c.k.a.e())
    {
      File localFile = generatePttFile(paramString, paramContext);
      if (localFile.exists())
        return localFile;
    }
    return generateLegacyPttFile(paramString, paramContext);
  }

  public static String getPttFileNameFromPttId(String paramString, Context paramContext)
  {
    return getPttFileFromPttId(paramString, paramContext).getAbsolutePath();
  }

  public static byte getPttVersion()
  {
    if (c.k.a.e())
      return 3;
    return 2;
  }

  // ERROR //
  public static AudioBarsInfo getRawPttFramesVolumes(String paramString)
  {
    // Byte code:
    //   0: new 205	java/io/BufferedInputStream
    //   3: dup
    //   4: new 207	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 213	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_1
    //   16: new 227	com/viber/voip/sound/ptt/PttUtils$AudioBarsInfo
    //   19: dup
    //   20: invokespecial 228	com/viber/voip/sound/ptt/PttUtils$AudioBarsInfo:<init>	()V
    //   23: astore_2
    //   24: new 230	com/viber/voip/audioptt/a
    //   27: dup
    //   28: invokespecial 231	com/viber/voip/audioptt/a:<init>	()V
    //   31: astore_3
    //   32: aload_3
    //   33: new 233	com/viber/voip/sound/ptt/PttUtils$1
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 236	com/viber/voip/sound/ptt/PttUtils$1:<init>	(Lcom/viber/voip/sound/ptt/PttUtils$AudioBarsInfo;)V
    //   41: invokevirtual 239	com/viber/voip/audioptt/a:a	(Lcom/viber/voip/audioptt/c;)V
    //   44: aload_3
    //   45: aload_1
    //   46: iconst_0
    //   47: invokevirtual 242	com/viber/voip/audioptt/a:a	(Ljava/io/InputStream;Z)V
    //   50: aload_3
    //   51: invokevirtual 245	com/viber/voip/audioptt/a:h	()V
    //   54: aload_1
    //   55: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   58: aload_2
    //   59: areturn
    //   60: astore 4
    //   62: aload_1
    //   63: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   66: aload 4
    //   68: athrow
    //   69: astore 6
    //   71: aconst_null
    //   72: areturn
    //   73: astore 5
    //   75: aconst_null
    //   76: areturn
    //   77: astore 7
    //   79: aconst_null
    //   80: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   24	54	60	finally
    //   54	58	69	java/io/IOException
    //   62	69	69	java/io/IOException
    //   54	58	73	java/lang/IndexOutOfBoundsException
    //   62	69	73	java/lang/IndexOutOfBoundsException
    //   0	16	77	java/io/FileNotFoundException
  }

  public static int getSampleRate(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 46908907:
    case 47713419:
    case 48636785:
    case 49620849:
    }
    while (true)
      switch (i)
      {
      default:
        return 44100;
        if (paramString.equals("16000"))
        {
          i = 0;
          continue;
          if (paramString.equals("22050"))
          {
            i = 1;
            continue;
            if (paramString.equals("32000"))
            {
              i = 2;
              continue;
              if (paramString.equals("44100"))
                i = 4;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    return 16000;
    return 22050;
    return 32000;
  }

  public static int getVideoBitRate(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 1958013297:
    case 2101159052:
    case -1449450318:
    case -1306304563:
    case -561946637:
    }
    while (true)
      switch (i)
      {
      case 2:
      default:
        return 2000000;
        if (paramString.equals("1000000"))
        {
          i = 0;
          continue;
          if (paramString.equals("1500000"))
          {
            i = 1;
            continue;
            if (paramString.equals("2000000"))
            {
              i = 2;
              continue;
              if (paramString.equals("2500000"))
              {
                i = 3;
                continue;
                if (paramString.equals("3000000"))
                  i = 4;
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 3:
      case 4:
      }
    return 1000000;
    return 1500000;
    return 2500000;
    return 3000000;
  }

  public static AudioBarsInfo getVolumeBars(AudioBarsInfo paramAudioBarsInfo, int paramInt, short paramShort)
  {
    if ((paramAudioBarsInfo == null) || (paramAudioBarsInfo.count < paramInt))
      return null;
    AudioBarsInfo localAudioBarsInfo = new AudioBarsInfo(paramInt);
    int i = 0;
    short s = 0;
    int j = 0;
    while (i < paramAudioBarsInfo.count)
    {
      int k = i * paramInt / paramAudioBarsInfo.count;
      if (j != k)
      {
        localAudioBarsInfo.volumes[j] = getNormalizedVolume(s, paramAudioBarsInfo.peakVolume, paramShort);
        s = 0;
        j = k;
      }
      if (paramAudioBarsInfo.volumes[i] > s)
        s = paramAudioBarsInfo.volumes[i];
      i++;
    }
    localAudioBarsInfo.volumes[j] = getNormalizedVolume(s, paramAudioBarsInfo.peakVolume, paramShort);
    localAudioBarsInfo.count = (j + 1);
    return localAudioBarsInfo;
  }

  public static String packVolumeBarsToBase64(AudioBarsInfo paramAudioBarsInfo)
  {
    int i = 1;
    if ((paramAudioBarsInfo == null) || (paramAudioBarsInfo.count != 30) || (paramAudioBarsInfo.volumes == null))
      return "";
    byte[] arrayOfByte = new byte[1 + paramAudioBarsInfo.count];
    arrayOfByte[0] = ((byte)i);
    while (i < 1 + paramAudioBarsInfo.count)
    {
      arrayOfByte[i] = ((byte)(paramAudioBarsInfo.volumes[(i - 1)] % 128));
      i++;
    }
    return Base64.encodeToString(arrayOfByte, 2);
  }

  public static AudioBarsInfo unpackVolumeBarsFromBase64(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.isEmpty()) || (paramString.length() > 50))
      return null;
    byte[] arrayOfByte = Base64.decode(paramString, 2);
    if (arrayOfByte == null)
      return null;
    if (arrayOfByte[0] != 1)
      return null;
    int j = -1 + arrayOfByte.length;
    AudioBarsInfo localAudioBarsInfo = new AudioBarsInfo(j);
    localAudioBarsInfo.count = j;
    while (i < -1 + arrayOfByte.length)
    {
      localAudioBarsInfo.volumes[i] = ((short)arrayOfByte[(i + 1)]);
      if (localAudioBarsInfo.volumes[i] > localAudioBarsInfo.peakVolume)
      {
        localAudioBarsInfo.peakVolume = localAudioBarsInfo.volumes[i];
        if (localAudioBarsInfo.peakVolume > 127)
          return null;
      }
      i++;
    }
    return localAudioBarsInfo;
  }

  public static String uriToPttId(Uri paramUri)
  {
    Matcher localMatcher = PTT_URI_PATTERN.matcher(paramUri.toString());
    if (localMatcher.find())
      return localMatcher.group(1);
    throw new IllegalArgumentException("Invalid PTT path: " + paramUri);
  }

  public static class AudioBarsInfo
  {
    public int count;
    public short peakVolume;
    public short[] volumes;

    public AudioBarsInfo()
    {
      this.volumes = new short[PttUtils.MAX_PTT_FRAMES_COUNT];
      this.peakVolume = 0;
      this.count = 0;
    }

    public AudioBarsInfo(int paramInt)
    {
      this.volumes = new short[paramInt];
      this.peakVolume = 0;
      this.count = 0;
    }

    public AudioBarsInfo(short[] paramArrayOfShort, int paramInt, short paramShort)
    {
      this.volumes = paramArrayOfShort;
      this.peakVolume = paramShort;
      this.count = paramInt;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (this == paramObject)
        bool = true;
      AudioBarsInfo localAudioBarsInfo;
      int k;
      int m;
      do
      {
        int i;
        int j;
        do
        {
          Class localClass1;
          Class localClass2;
          do
          {
            do
            {
              return bool;
              bool = false;
            }
            while (paramObject == null);
            localClass1 = getClass();
            localClass2 = paramObject.getClass();
            bool = false;
          }
          while (localClass1 != localClass2);
          localAudioBarsInfo = (AudioBarsInfo)paramObject;
          i = this.peakVolume;
          j = localAudioBarsInfo.peakVolume;
          bool = false;
        }
        while (i != j);
        k = this.count;
        m = localAudioBarsInfo.count;
        bool = false;
      }
      while (k != m);
      return Arrays.equals(this.volumes, localAudioBarsInfo.volumes);
    }

    public int hashCode()
    {
      return 31 * (31 * Arrays.hashCode(this.volumes) + this.peakVolume) + this.count;
    }

    public String toReadableString()
    {
      if (this.volumes == null)
        return "";
      StringBuilder localStringBuilder = new StringBuilder(this.count);
      int i = 0;
      if (i < this.count)
      {
        int j = 100 * this.volumes[i] / this.peakVolume;
        char c = ' ';
        if (j >= 70)
          c = '^';
        while (true)
        {
          localStringBuilder.append(c);
          i++;
          break;
          if (j >= 40)
            c = '-';
          else if (j >= 10)
            c = '_';
        }
      }
      return localStringBuilder.toString();
    }

    public String toString()
    {
      if (this.volumes == null)
        return "";
      StringBuilder localStringBuilder = new StringBuilder(1 + 7 * this.count);
      for (int i = 0; i < this.count; i++)
      {
        localStringBuilder.append(this.volumes[i]);
        localStringBuilder.append(", ");
      }
      return localStringBuilder.toString();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.PttUtils
 * JD-Core Version:    0.6.2
 */
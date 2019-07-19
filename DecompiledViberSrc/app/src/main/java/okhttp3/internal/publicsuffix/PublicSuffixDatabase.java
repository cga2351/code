package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class PublicSuffixDatabase
{
  private static final String[] EMPTY_RULE = new String[0];
  private static final byte EXCEPTION_MARKER = 33;
  private static final String[] PREVAILING_RULE = { "*" };
  public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
  private static final byte[] WILDCARD_LABEL = { 42 };
  private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
  private final AtomicBoolean listRead = new AtomicBoolean(false);
  private byte[] publicSuffixExceptionListBytes;
  private byte[] publicSuffixListBytes;
  private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

  private static String binarySearchBytes(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    if (i < j)
    {
      for (int k = (i + j) / 2; (k > -1) && (paramArrayOfByte[k] != 10); k--);
      int m = k + 1;
      for (int n = 1; paramArrayOfByte[(m + n)] != 10; n++);
      int i1 = m + n - m;
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      int i5 = paramInt;
      label90: int i6;
      label102: int i7;
      int i10;
      int i9;
      label131: int i15;
      int i14;
      if (i4 != 0)
      {
        i6 = 46;
        i4 = 0;
        i7 = i6 - (0xFF & paramArrayOfByte[(m + i3)]);
        if (i7 == 0)
          break label171;
        i10 = i3;
        i9 = i2;
        if (i7 >= 0)
          break label244;
        i15 = m - 1;
        i14 = i;
      }
      while (true)
      {
        j = i15;
        i = i14;
        break;
        i6 = 0xFF & paramArrayOfByte1[i5][i2];
        break label102;
        label171: i3++;
        int i8 = i2 + 1;
        if (i3 == i1)
        {
          i9 = i8;
          i10 = i3;
          break label131;
        }
        if (paramArrayOfByte1[i5].length == i8)
        {
          if (i5 == -1 + paramArrayOfByte1.length)
          {
            i9 = i8;
            i10 = i3;
            break label131;
          }
          i5++;
          i8 = -1;
          i4 = 1;
        }
        i2 = i8;
        break label90;
        label244: if (i7 > 0)
        {
          i14 = 1 + (n + m);
          i15 = j;
        }
        else
        {
          int i11 = i1 - i10;
          int i12 = paramArrayOfByte1[i5].length - i9;
          for (int i13 = i5 + 1; i13 < paramArrayOfByte1.length; i13++)
            i12 += paramArrayOfByte1[i13].length;
          if (i12 < i11)
          {
            i15 = m - 1;
            i14 = i;
          }
          else
          {
            if (i12 <= i11)
              break label353;
            i14 = 1 + (n + m);
            i15 = j;
          }
        }
      }
      label353: return new String(paramArrayOfByte, m, i1, Util.UTF_8);
    }
    return null;
  }

  private String[] findMatchingRule(String[] paramArrayOfString)
  {
    if ((!this.listRead.get()) && (this.listRead.compareAndSet(false, true)))
      readTheListUninterruptibly();
    while (true)
    {
      try
      {
        if (this.publicSuffixListBytes != null)
          break;
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
      }
      finally
      {
      }
      try
      {
        this.readCompleteLatch.await();
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
    byte[][] arrayOfByte = new byte[paramArrayOfString.length][];
    for (int i = 0; i < paramArrayOfString.length; i++)
      arrayOfByte[i] = paramArrayOfString[i].getBytes(Util.UTF_8);
    int j = 0;
    String str1;
    if (j < arrayOfByte.length)
    {
      str1 = binarySearchBytes(this.publicSuffixListBytes, arrayOfByte, j);
      if (str1 == null);
    }
    while (true)
    {
      int n;
      label153: String str4;
      if (arrayOfByte.length > 1)
      {
        byte[][] arrayOfByte1 = (byte[][])arrayOfByte.clone();
        n = 0;
        if (n < -1 + arrayOfByte1.length)
        {
          arrayOfByte1[n] = WILDCARD_LABEL;
          str4 = binarySearchBytes(this.publicSuffixListBytes, arrayOfByte1, n);
          if (str4 == null);
        }
      }
      for (String str2 = str4; ; str2 = null)
      {
        int k = 0;
        Object localObject2 = null;
        if (str2 != null)
        {
          label204: int m = -1 + arrayOfByte.length;
          localObject2 = null;
          if (k < m)
          {
            String str3 = binarySearchBytes(this.publicSuffixExceptionListBytes, arrayOfByte, k);
            if (str3 == null)
              break label290;
            localObject2 = str3;
          }
        }
        String[] arrayOfString2;
        if (localObject2 != null)
          arrayOfString2 = ("!" + localObject2).split("\\.");
        label290: label358: label364: 
        while (true)
        {
          return arrayOfString2;
          j++;
          break;
          n++;
          break label153;
          k++;
          break label204;
          if ((str1 == null) && (str2 == null))
            return PREVAILING_RULE;
          String[] arrayOfString1;
          if (str1 != null)
          {
            arrayOfString1 = str1.split("\\.");
            if (str2 == null)
              break label358;
          }
          for (arrayOfString2 = str2.split("\\."); ; arrayOfString2 = EMPTY_RULE)
          {
            if (arrayOfString1.length <= arrayOfString2.length)
              break label364;
            return arrayOfString1;
            arrayOfString1 = EMPTY_RULE;
            break;
          }
        }
      }
      str1 = null;
    }
  }

  public static PublicSuffixDatabase get()
  {
    return instance;
  }

  // ERROR //
  private void readTheList()
    throws IOException
  {
    // Byte code:
    //   0: ldc 2
    //   2: ldc 14
    //   4: invokevirtual 138	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: new 140	f/j
    //   16: dup
    //   17: aload_1
    //   18: invokestatic 146	f/l:a	(Ljava/io/InputStream;)Lf/t;
    //   21: invokespecial 149	f/j:<init>	(Lf/t;)V
    //   24: invokestatic 152	f/l:a	(Lf/t;)Lf/e;
    //   27: astore_2
    //   28: aload_2
    //   29: invokeinterface 158 1 0
    //   34: newarray byte
    //   36: astore 4
    //   38: aload_2
    //   39: aload 4
    //   41: invokeinterface 161 2 0
    //   46: aload_2
    //   47: invokeinterface 158 1 0
    //   52: newarray byte
    //   54: astore 5
    //   56: aload_2
    //   57: aload 5
    //   59: invokeinterface 161 2 0
    //   64: aload_2
    //   65: invokestatic 165	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   68: aload_0
    //   69: monitorenter
    //   70: aload_0
    //   71: aload 4
    //   73: putfield 84	okhttp3/internal/publicsuffix/PublicSuffixDatabase:publicSuffixListBytes	[B
    //   76: aload_0
    //   77: aload 5
    //   79: putfield 109	okhttp3/internal/publicsuffix/PublicSuffixDatabase:publicSuffixExceptionListBytes	[B
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_0
    //   85: getfield 56	okhttp3/internal/publicsuffix/PublicSuffixDatabase:readCompleteLatch	Ljava/util/concurrent/CountDownLatch;
    //   88: invokevirtual 168	java/util/concurrent/CountDownLatch:countDown	()V
    //   91: return
    //   92: astore_3
    //   93: aload_2
    //   94: invokestatic 165	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   97: aload_3
    //   98: athrow
    //   99: astore 6
    //   101: aload_0
    //   102: monitorexit
    //   103: aload 6
    //   105: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   28	64	92	finally
    //   70	84	99	finally
    //   101	103	99	finally
  }

  private void readTheListUninterruptibly()
  {
    int i = 0;
    try
    {
      readTheList();
      return;
    }
    catch (InterruptedIOException localInterruptedIOException)
    {
      while (true)
        i = 1;
    }
    catch (IOException localIOException)
    {
      Platform.get().log(5, "Failed to read public suffix list", localIOException);
      return;
    }
    finally
    {
      if (i != 0)
        Thread.currentThread().interrupt();
    }
  }

  public String getEffectiveTldPlusOne(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("domain == null");
    String[] arrayOfString1 = IDN.toUnicode(paramString).split("\\.");
    String[] arrayOfString2 = findMatchingRule(arrayOfString1);
    if ((arrayOfString1.length == arrayOfString2.length) && (arrayOfString2[0].charAt(0) != '!'))
      return null;
    if (arrayOfString2[0].charAt(0) == '!');
    StringBuilder localStringBuilder;
    for (int i = arrayOfString1.length - arrayOfString2.length; ; i = arrayOfString1.length - (1 + arrayOfString2.length))
    {
      localStringBuilder = new StringBuilder();
      String[] arrayOfString3 = paramString.split("\\.");
      while (i < arrayOfString3.length)
      {
        localStringBuilder.append(arrayOfString3[i]).append('.');
        i++;
      }
    }
    localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  void setListBytes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.publicSuffixListBytes = paramArrayOfByte1;
    this.publicSuffixExceptionListBytes = paramArrayOfByte2;
    this.listRead.set(true);
    this.readCompleteLatch.countDown();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.publicsuffix.PublicSuffixDatabase
 * JD-Core Version:    0.6.2
 */
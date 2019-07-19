package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class MinElf
{
  public static final int DT_NEEDED = 1;
  public static final int DT_NULL = 0;
  public static final int DT_STRTAB = 5;
  public static final int ELF_MAGIC = 1179403647;
  public static final int PN_XNUM = 65535;
  public static final int PT_DYNAMIC = 2;
  public static final int PT_LOAD = 1;

  public static String[] extract_DT_NEEDED(File paramFile)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      String[] arrayOfString = extract_DT_NEEDED(localFileInputStream.getChannel());
      return arrayOfString;
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public static String[] extract_DT_NEEDED(FileChannel paramFileChannel)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (getu32(paramFileChannel, localByteBuffer, 0L) != 1179403647L)
      throw new ElfError("file is not ELF");
    int i;
    long l1;
    label85: long l2;
    label100: int j;
    label114: long l26;
    label137: label154: long l3;
    long l4;
    long l5;
    if (getu8(paramFileChannel, localByteBuffer, 4L) == 1)
    {
      i = 1;
      if (getu8(paramFileChannel, localByteBuffer, 5L) == 2)
        localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      if (i == 0)
        break label239;
      l1 = getu32(paramFileChannel, localByteBuffer, 28L);
      if (i == 0)
        break label252;
      l2 = getu16(paramFileChannel, localByteBuffer, 44L);
      if (i == 0)
        break label266;
      j = getu16(paramFileChannel, localByteBuffer, 42L);
      if (l2 == 65535L)
      {
        if (i == 0)
          break label279;
        l26 = getu32(paramFileChannel, localByteBuffer, 32L);
        if (i == 0)
          break label292;
        l2 = getu32(paramFileChannel, localByteBuffer, l26 + 28L);
      }
      l3 = 0L;
      l4 = 0L;
      l5 = l1;
    }
    while (true)
    {
      long l24;
      if (l4 < l2)
      {
        if (i == 0)
          break label308;
        l24 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        label187: if (l24 != 2L)
          break label338;
        if (i == 0)
          break label322;
      }
      label266: label279: label292: label308: label322: for (long l25 = getu32(paramFileChannel, localByteBuffer, 4L + l5); ; l25 = get64(paramFileChannel, localByteBuffer, 8L + l5))
      {
        l3 = l25;
        if (l3 != 0L)
          break label355;
        throw new ElfError("ELF file does not contain dynamic linking information");
        i = 0;
        break;
        label239: l1 = get64(paramFileChannel, localByteBuffer, 32L);
        break label85;
        label252: l2 = getu16(paramFileChannel, localByteBuffer, 56L);
        break label100;
        j = getu16(paramFileChannel, localByteBuffer, 54L);
        break label114;
        l26 = get64(paramFileChannel, localByteBuffer, 40L);
        break label137;
        l2 = getu32(paramFileChannel, localByteBuffer, l26 + 44L);
        break label154;
        l24 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        break label187;
      }
      label338: l5 += j;
      l4 = 1L + l4;
    }
    label355: int k = 0;
    long l6 = 0L;
    long l7 = l3;
    long l8;
    if (i != 0)
      l8 = getu32(paramFileChannel, localByteBuffer, 0L + l7);
    long l9;
    int m;
    while (l8 == 1L)
      if (k == 2147483647)
      {
        throw new ElfError("malformed DT_NEEDED section");
        l8 = get64(paramFileChannel, localByteBuffer, 0L + l7);
      }
      else
      {
        int i2 = k + 1;
        l9 = l6;
        m = i2;
      }
    while (true)
    {
      if (i != 0);
      long l11;
      for (long l10 = 8L; ; l10 = 16L)
      {
        l11 = l10 + l7;
        if (l8 != 0L)
          break label927;
        if (l9 != 0L)
          break label533;
        throw new ElfError("Dynamic section string-table not found");
        if (l8 != 5L)
          break label942;
        if (i != 0);
        for (long l23 = getu32(paramFileChannel, localByteBuffer, 4L + l7); ; l23 = get64(paramFileChannel, localByteBuffer, 8L + l7))
        {
          l9 = l23;
          m = k;
          break;
        }
      }
      label533: int n = 0;
      long l12 = l1;
      long l18;
      label564: long l20;
      label588: long l21;
      label605: long l22;
      if (n < l2)
        if (i != 0)
        {
          l18 = getu32(paramFileChannel, localByteBuffer, 0L + l12);
          if (l18 != 1L)
            break label730;
          if (i == 0)
            break label682;
          l20 = getu32(paramFileChannel, localByteBuffer, 8L + l12);
          if (i == 0)
            break label698;
          l21 = getu32(paramFileChannel, localByteBuffer, 20L + l12);
          if ((l20 > l9) || (l9 >= l21 + l20))
            break label730;
          if (i == 0)
            break label714;
          l22 = getu32(paramFileChannel, localByteBuffer, 4L + l12);
        }
      label641: for (long l13 = l22 + (l9 - l20); ; l13 = 0L)
      {
        if (l13 == 0L)
        {
          throw new ElfError("did not find file offset of DT_STRTAB table");
          l18 = getu32(paramFileChannel, localByteBuffer, 0L + l12);
          break label564;
          label682: l20 = get64(paramFileChannel, localByteBuffer, 16L + l12);
          break label588;
          label698: l21 = get64(paramFileChannel, localByteBuffer, 40L + l12);
          break label605;
          label714: l22 = get64(paramFileChannel, localByteBuffer, 8L + l12);
          break label641;
          label730: long l19 = l12 + j;
          n++;
          l12 = l19;
          break;
        }
        String[] arrayOfString = new String[m];
        int i1 = 0;
        while (true)
        {
          long l14;
          if (i != 0)
          {
            l14 = getu32(paramFileChannel, localByteBuffer, 0L + l3);
            if (l14 != 1L)
              break label862;
            if (i == 0)
              break label843;
          }
          label843: for (long l17 = getu32(paramFileChannel, localByteBuffer, 4L + l3); ; l17 = get64(paramFileChannel, localByteBuffer, 8L + l3))
          {
            arrayOfString[i1] = getSz(paramFileChannel, localByteBuffer, l17 + l13);
            if (i1 != 2147483647)
              break label859;
            throw new ElfError("malformed DT_NEEDED section");
            l14 = get64(paramFileChannel, localByteBuffer, 0L + l3);
            break;
          }
          label859: i1++;
          label862: if (i != 0);
          long l16;
          for (long l15 = 8L; ; l15 = 16L)
          {
            l16 = l15 + l3;
            if (l14 != 0L)
              break label914;
            if (i1 == arrayOfString.length)
              break;
            throw new ElfError("malformed DT_NEEDED section");
          }
          return arrayOfString;
          label914: l3 = l16;
        }
      }
      label927: l7 = l11;
      k = m;
      l6 = l9;
      break;
      label942: l9 = l6;
      m = k;
    }
  }

  private static long get64(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 8, paramLong);
    return paramByteBuffer.getLong();
  }

  private static String getSz(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
    {
      long l = 1L + paramLong;
      int i = getu8(paramFileChannel, paramByteBuffer, paramLong);
      if (i == 0)
        break;
      localStringBuilder.append((char)i);
      paramLong = l;
    }
    return localStringBuilder.toString();
  }

  private static int getu16(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 2, paramLong);
    return 0xFFFF & paramByteBuffer.getShort();
  }

  private static long getu32(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 4, paramLong);
    return 0xFFFFFFFF & paramByteBuffer.getInt();
  }

  private static short getu8(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
    throws IOException
  {
    read(paramFileChannel, paramByteBuffer, 1, paramLong);
    return (short)(0xFF & paramByteBuffer.get());
  }

  private static void read(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
    throws IOException
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    while (true)
    {
      int i;
      if (paramByteBuffer.remaining() > 0)
      {
        i = paramFileChannel.read(paramByteBuffer, paramLong);
        if (i != -1);
      }
      else
      {
        if (paramByteBuffer.remaining() <= 0)
          break;
        throw new ElfError("ELF file truncated");
      }
      paramLong += i;
    }
    paramByteBuffer.position(0);
  }

  private static class ElfError extends RuntimeException
  {
    ElfError(String paramString)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.MinElf
 * JD-Core Version:    0.6.2
 */
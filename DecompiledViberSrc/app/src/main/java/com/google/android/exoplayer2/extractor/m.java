package com.google.android.exoplayer2.extractor;

public final class m
{
  private static final String[] h = { "audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg" };
  private static final int[] i = { 44100, 48000, 32000 };
  private static final int[] j = { 32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000 };
  private static final int[] k = { 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000 };
  private static final int[] l = { 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000 };
  private static final int[] m = { 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000 };
  private static final int[] n = { 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000 };
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;

  public static int a(int paramInt)
  {
    if ((paramInt & 0xFFE00000) != -2097152);
    int i1;
    int i2;
    int i3;
    int i4;
    do
    {
      do
      {
        do
        {
          do
          {
            return -1;
            i1 = 0x3 & paramInt >>> 19;
          }
          while (i1 == 1);
          i2 = 0x3 & paramInt >>> 17;
        }
        while (i2 == 0);
        i3 = 0xF & paramInt >>> 12;
      }
      while ((i3 == 0) || (i3 == 15));
      i4 = 0x3 & paramInt >>> 10;
    }
    while (i4 == 3);
    int i5 = i[i4];
    int i6;
    if (i1 == 2)
      i6 = i5 / 2;
    while (true)
    {
      int i7 = 0x1 & paramInt >>> 9;
      if (i2 == 3)
      {
        if (i1 == 3);
        for (int i11 = j[(i3 - 1)]; ; i11 = k[(i3 - 1)])
        {
          return 4 * (i7 + i11 * 12 / i6);
          if (i1 != 0)
            break label245;
          i6 = i5 / 4;
          break;
        }
      }
      int i10;
      if (i1 == 3)
        if (i2 == 2)
          i10 = l[(i3 - 1)];
      for (int i8 = i10; ; i8 = n[(i3 - 1)])
      {
        if (i1 != 3)
          break label216;
        return i7 + i8 * 144 / i6;
        i10 = m[(i3 - 1)];
        break;
      }
      label216: if (i2 == 1);
      for (int i9 = 72; ; i9 = 144)
        return i7 + i9 * i8 / i6;
      label245: i6 = i5;
    }
  }

  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
  }

  public static boolean a(int paramInt, m paramm)
  {
    int i1 = 2;
    if ((paramInt & 0xFFE00000) != -2097152)
      return false;
    int i2 = 0x3 & paramInt >>> 19;
    if (i2 == 1)
      return false;
    int i3 = 0x3 & paramInt >>> 17;
    if (i3 == 0)
      return false;
    int i4 = 0xF & paramInt >>> 12;
    if ((i4 == 0) || (i4 == 15))
      return false;
    int i5 = 0x3 & paramInt >>> 10;
    if (i5 == 3)
      return false;
    int i6 = i[i5];
    int i7;
    if (i2 == i1)
    {
      i6 /= 2;
      i7 = 0x1 & paramInt >>> 9;
      if (i3 != 3)
        break label228;
      if (i2 != 3)
        break label215;
    }
    int i11;
    int i9;
    label215: for (int i14 = j[(i4 - 1)]; ; i14 = k[(i4 - 1)])
    {
      i11 = 4 * (i7 + i14 * 12 / i6);
      i9 = 384;
      int i12 = i6 * (i11 * 8) / i9;
      String str = h[(3 - i3)];
      if ((0x3 & paramInt >> 6) == 3)
        i1 = 1;
      paramm.a(i2, str, i11, i6, i1, i12, i9);
      return true;
      if (i2 != 0)
        break;
      i6 /= 4;
      break;
    }
    label228: if (i2 == 3)
    {
      if (i3 == i1);
      for (int i13 = l[(i4 - 1)]; ; i13 = m[(i4 - 1)])
      {
        i9 = 1152;
        i11 = i7 + i13 * 144 / i6;
        break;
      }
    }
    int i8 = n[(i4 - 1)];
    if (i3 == 1)
    {
      i9 = 576;
      label305: if (i3 != 1)
        break label339;
    }
    label339: for (int i10 = 72; ; i10 = 144)
    {
      i11 = i7 + i10 * i8 / i6;
      break;
      i9 = 1152;
      break label305;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.m
 * JD-Core Version:    0.6.2
 */
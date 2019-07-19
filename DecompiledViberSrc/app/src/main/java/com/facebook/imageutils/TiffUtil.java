package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;

class TiffUtil
{
  private static final Class<?> TAG = TiffUtil.class;
  public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
  public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
  public static final int TIFF_TAG_ORIENTATION = 274;
  public static final int TIFF_TYPE_SHORT = 3;

  public static int getAutoRotateAngleFromOrientation(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
    case 1:
    case 2:
    case 4:
    case 5:
    case 7:
    default:
      return 0;
    case 3:
      return 180;
    case 6:
      return 90;
    case 8:
    }
    return 270;
  }

  private static int getOrientationFromTiffEntry(InputStream paramInputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (paramInt < 10);
    while ((StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean) != 3) || (StreamProcessor.readPackedInt(paramInputStream, 4, paramBoolean) != 1))
      return 0;
    int i = StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean);
    StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean);
    return i;
  }

  private static int moveToTiffEntryWithTag(InputStream paramInputStream, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 14)
      return 0;
    int i = StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean);
    int j = paramInt1 - 2;
    while (true)
    {
      int k = i - 1;
      if ((i <= 0) || (j < 12))
        break;
      int m = StreamProcessor.readPackedInt(paramInputStream, 2, paramBoolean);
      int n = j - 2;
      if (m == paramInt2)
        return n;
      paramInputStream.skip(10L);
      j = n - 10;
      i = k;
    }
  }

  public static int readOrientationFromTIFF(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    TiffHeader localTiffHeader = new TiffHeader(null);
    int i = readTiffHeader(paramInputStream, paramInt, localTiffHeader);
    int j = -8 + localTiffHeader.firstIfdOffset;
    if ((i == 0) || (j > i))
      return 0;
    paramInputStream.skip(j);
    return getOrientationFromTiffEntry(paramInputStream, moveToTiffEntryWithTag(paramInputStream, i - j, localTiffHeader.isLittleEndian, 274), localTiffHeader.isLittleEndian);
  }

  private static int readTiffHeader(InputStream paramInputStream, int paramInt, TiffHeader paramTiffHeader)
    throws IOException
  {
    if (paramInt <= 8)
      return 0;
    paramTiffHeader.byteOrder = StreamProcessor.readPackedInt(paramInputStream, 4, false);
    int i = paramInt - 4;
    if ((paramTiffHeader.byteOrder != 1229531648) && (paramTiffHeader.byteOrder != 1296891946))
    {
      FLog.e(TAG, "Invalid TIFF header");
      return 0;
    }
    if (paramTiffHeader.byteOrder == 1229531648);
    int j;
    for (boolean bool = true; ; bool = false)
    {
      paramTiffHeader.isLittleEndian = bool;
      paramTiffHeader.firstIfdOffset = StreamProcessor.readPackedInt(paramInputStream, 4, paramTiffHeader.isLittleEndian);
      j = i - 4;
      if ((paramTiffHeader.firstIfdOffset >= 8) && (-8 + paramTiffHeader.firstIfdOffset <= j))
        break;
      FLog.e(TAG, "Invalid offset");
      return 0;
    }
    return j;
  }

  private static class TiffHeader
  {
    int byteOrder;
    int firstIfdOffset;
    boolean isLittleEndian;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imageutils.TiffUtil
 * JD-Core Version:    0.6.2
 */
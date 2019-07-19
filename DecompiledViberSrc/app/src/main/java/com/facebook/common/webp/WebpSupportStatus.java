package com.facebook.common.webp;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;

public class WebpSupportStatus
{
  private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
  private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
  private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
  private static final byte[] WEBP_NAME_BYTES;
  private static final byte[] WEBP_RIFF_BYTES;
  private static final byte[] WEBP_VP8L_BYTES;
  private static final byte[] WEBP_VP8X_BYTES;
  private static final byte[] WEBP_VP8_BYTES;
  public static final boolean sIsExtendedWebpSupported;
  public static final boolean sIsSimpleWebpSupported;
  public static final boolean sIsWebpSupportRequired;

  @Nullable
  public static WebpBitmapFactory sWebpBitmapFactory;
  private static boolean sWebpLibraryChecked;

  static
  {
    boolean bool1 = true;
    boolean bool2;
    if (Build.VERSION.SDK_INT <= 17)
    {
      bool2 = bool1;
      sIsWebpSupportRequired = bool2;
      if (Build.VERSION.SDK_INT < 14)
        break label88;
    }
    while (true)
    {
      sIsSimpleWebpSupported = bool1;
      sIsExtendedWebpSupported = isExtendedWebpSupported();
      sWebpBitmapFactory = null;
      sWebpLibraryChecked = false;
      WEBP_RIFF_BYTES = asciiBytes("RIFF");
      WEBP_NAME_BYTES = asciiBytes("WEBP");
      WEBP_VP8_BYTES = asciiBytes("VP8 ");
      WEBP_VP8L_BYTES = asciiBytes("VP8L");
      WEBP_VP8X_BYTES = asciiBytes("VP8X");
      return;
      bool2 = false;
      break;
      label88: bool1 = false;
    }
  }

  private static byte[] asciiBytes(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ASCII");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("ASCII not found!", localUnsupportedEncodingException);
    }
  }

  public static boolean isAnimatedWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8X_BYTES);
    if ((0x2 & paramArrayOfByte[(paramInt + 20)]) == 2);
    for (int i = 1; (bool) && (i != 0); i = 0)
      return true;
    return false;
  }

  public static boolean isExtendedWebpHeader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 21) && (matchBytePattern(paramArrayOfByte, paramInt1 + 12, WEBP_VP8X_BYTES));
  }

  public static boolean isExtendedWebpHeaderWithAlpha(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8X_BYTES);
    if ((0x10 & paramArrayOfByte[(paramInt + 20)]) == 16);
    for (int i = 1; (bool) && (i != 0); i = 0)
      return true;
    return false;
  }

  private static boolean isExtendedWebpSupported()
  {
    if (Build.VERSION.SDK_INT < 17);
    BitmapFactory.Options localOptions;
    do
    {
      return false;
      if (Build.VERSION.SDK_INT != 17)
        break;
      byte[] arrayOfByte = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    while ((localOptions.outHeight != 1) || (localOptions.outWidth != 1));
    return true;
  }

  public static boolean isLosslessWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    return matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8L_BYTES);
  }

  public static boolean isSimpleWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    return matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8_BYTES);
  }

  public static boolean isWebpHeader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 20) && (matchBytePattern(paramArrayOfByte, paramInt1, WEBP_RIFF_BYTES)) && (matchBytePattern(paramArrayOfByte, paramInt1 + 8, WEBP_NAME_BYTES));
  }

  public static boolean isWebpSupportedByPlatform(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2;
    if (isSimpleWebpHeader(paramArrayOfByte, paramInt1))
      bool2 = sIsSimpleWebpSupported;
    boolean bool3;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        if (isLosslessWebpHeader(paramArrayOfByte, paramInt1))
          return sIsExtendedWebpSupported;
        bool1 = isExtendedWebpHeader(paramArrayOfByte, paramInt1, paramInt2);
        bool2 = false;
      }
      while (!bool1);
      bool3 = isAnimatedWebpHeader(paramArrayOfByte, paramInt1);
      bool2 = false;
    }
    while (bool3);
    return sIsExtendedWebpSupported;
  }

  @Nullable
  public static WebpBitmapFactory loadWebpBitmapFactoryIfExists()
  {
    if (sWebpLibraryChecked)
      return sWebpBitmapFactory;
    try
    {
      localWebpBitmapFactory = (WebpBitmapFactory)Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
      sWebpLibraryChecked = true;
      return localWebpBitmapFactory;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        WebpBitmapFactory localWebpBitmapFactory = null;
    }
  }

  private static boolean matchBytePattern(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null));
    while (paramInt + paramArrayOfByte2.length > paramArrayOfByte1.length)
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte2.length)
        break label44;
      if (paramArrayOfByte1[(i + paramInt)] != paramArrayOfByte2[i])
        break;
    }
    label44: return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.webp.WebpSupportStatus
 * JD-Core Version:    0.6.2
 */
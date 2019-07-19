package okhttp3.internal.http2;

import f.f;
import java.io.IOException;
import okhttp3.internal.Util;

public final class Http2
{
  static final String[] BINARY;
  static final f CONNECTION_PREFACE = f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final String[] FLAGS;
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PADDED = 8;
  static final byte FLAG_PRIORITY = 32;
  private static final String[] FRAME_NAMES = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;

  static
  {
    FLAGS = new String[64];
    BINARY = new String[256];
    for (int i = 0; i < BINARY.length; i++)
    {
      String[] arrayOfString = BINARY;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.toBinaryString(i);
      arrayOfString[i] = Util.format("%8s", arrayOfObject).replace(' ', '0');
    }
    FLAGS[0] = "";
    FLAGS[1] = "END_STREAM";
    int[] arrayOfInt1 = { 1 };
    FLAGS[8] = "PADDED";
    int j = arrayOfInt1.length;
    for (int k = 0; k < j; k++)
    {
      int i6 = arrayOfInt1[k];
      FLAGS[(i6 | 0x8)] = (FLAGS[i6] + "|PADDED");
    }
    FLAGS[4] = "END_HEADERS";
    FLAGS[32] = "PRIORITY";
    FLAGS[36] = "END_HEADERS|PRIORITY";
    int[] arrayOfInt2 = { 4, 32, 36 };
    int m = arrayOfInt2.length;
    int i1;
    for (int n = 0; ; n++)
    {
      i1 = 0;
      if (n >= m)
        break;
      int i2 = arrayOfInt2[n];
      int i3 = arrayOfInt1.length;
      for (int i4 = 0; i4 < i3; i4++)
      {
        int i5 = arrayOfInt1[i4];
        FLAGS[(i5 | i2)] = (FLAGS[i5] + '|' + FLAGS[i2]);
        FLAGS[(0x8 | (i5 | i2))] = (FLAGS[i5] + '|' + FLAGS[i2] + "|PADDED");
      }
    }
    while (i1 < FLAGS.length)
    {
      if (FLAGS[i1] == null)
        FLAGS[i1] = BINARY[i1];
      i1++;
    }
  }

  static String formatFlags(byte paramByte1, byte paramByte2)
  {
    String str;
    if (paramByte2 == 0)
      str = "";
    do
    {
      return str;
      switch (paramByte1)
      {
      case 5:
      default:
        if (paramByte2 >= FLAGS.length)
          break;
      case 4:
      case 6:
      case 2:
      case 3:
      case 7:
      case 8:
      }
      for (str = FLAGS[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = BINARY[paramByte2])
      {
        return str.replace("HEADERS", "PUSH_PROMISE");
        if (paramByte2 == 1)
          return "ACK";
        return BINARY[paramByte2];
        return BINARY[paramByte2];
      }
    }
    while ((paramByte1 != 0) || ((paramByte2 & 0x20) == 0));
    return str.replace("PRIORITY", "COMPRESSED");
  }

  static String frameLog(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    String str2;
    Object[] arrayOfObject2;
    if (paramByte1 < FRAME_NAMES.length)
    {
      str1 = FRAME_NAMES[paramByte1];
      str2 = formatFlags(paramByte1, paramByte2);
      arrayOfObject2 = new Object[5];
      if (!paramBoolean)
        break label105;
    }
    label105: for (String str3 = "<<"; ; str3 = ">>")
    {
      arrayOfObject2[0] = str3;
      arrayOfObject2[1] = Integer.valueOf(paramInt1);
      arrayOfObject2[2] = Integer.valueOf(paramInt2);
      arrayOfObject2[3] = str1;
      arrayOfObject2[4] = str2;
      return Util.format("%s 0x%08x %5d %-13s %s", arrayOfObject2);
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Byte.valueOf(paramByte1);
      str1 = Util.format("0x%02x", arrayOfObject1);
      break;
    }
  }

  static IllegalArgumentException illegalArgument(String paramString, Object[] paramArrayOfObject)
  {
    throw new IllegalArgumentException(Util.format(paramString, paramArrayOfObject));
  }

  static IOException ioException(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    throw new IOException(Util.format(paramString, paramArrayOfObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2
 * JD-Core Version:    0.6.2
 */
package org.ajwcc.pduUtils.gsm3040;

import com.viber.voip.messages.d.k;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.BitSet;

public class PduUtils
{
  public static final int ADDRESS_NUMBER_PLAN_ID_MASK = 15;
  public static final int ADDRESS_NUMBER_PLAN_ID_TELEPHONE = 1;
  public static final int ADDRESS_NUMBER_PLAN_ID_UNKNOWN = 0;
  public static final int ADDRESS_TYPE_ALPHANUMERIC = 80;
  public static final int ADDRESS_TYPE_INTERNATIONAL = 16;
  public static final int ADDRESS_TYPE_MASK = 112;
  public static final int ADDRESS_TYPE_UNKNOWN = 0;
  public static final int DCS_CODING_GROUP_DATA = 240;
  public static final int DCS_CODING_GROUP_GENERAL = 192;
  public static final int DCS_CODING_GROUP_MASK = 15;
  public static final int DCS_ENCODING_7BIT = 0;
  public static final int DCS_ENCODING_8BIT = 4;
  public static final int DCS_ENCODING_MASK = 243;
  public static final int DCS_ENCODING_UCS2 = 8;
  public static final int DCS_MESSAGE_CLASS_FLASH = 16;
  public static final int DCS_MESSAGE_CLASS_MASK = 236;
  public static final int DCS_MESSAGE_CLASS_ME = 17;
  public static final int DCS_MESSAGE_CLASS_NONE = 0;
  public static final int DCS_MESSAGE_CLASS_SIM = 18;
  public static final int DCS_MESSAGE_CLASS_TE = 19;
  public static final int TP_MMS_MASK = 251;
  public static final int TP_MMS_MORE_MESSAGES = 4;
  public static final int TP_MMS_NO_MESSAGES = 0;
  public static final int TP_MTI_MASK = 252;
  public static final int TP_MTI_SMS_DELIVER = 0;
  public static final int TP_MTI_SMS_STATUS_REPORT = 2;
  public static final int TP_MTI_SMS_SUBMIT = 1;
  public static final int TP_RD_ACCEPT_DUPLICATES = 0;
  public static final int TP_RD_MASK = 251;
  public static final int TP_RD_REJECT_DUPLICATES = 4;
  public static final int TP_SRI_MASK = 223;
  public static final int TP_SRI_NO_REPORT = 0;
  public static final int TP_SRI_REPORT = 32;
  public static final int TP_SRR_MASK = 223;
  public static final int TP_SRR_NO_REPORT = 0;
  public static final int TP_SRR_REPORT = 32;
  public static final int TP_UDHI_MASK = 191;
  public static final int TP_UDHI_NO_UDH = 0;
  public static final int TP_UDHI_WITH_UDH = 64;
  public static final int TP_VPF_INTEGER = 16;
  public static final int TP_VPF_MASK = 231;
  public static final int TP_VPF_NONE = 0;
  public static final int TP_VPF_TIMESTAMP = 24;
  private static final char[] extAlphabet = { 12, 94, 123, 125, 92, 91, 126, 93, 124, 8364 };
  private static final String[] extBytes = { "1b0a", "1b14", "1b28", "1b29", "1b2f", "1b3c", "1b3d", "1b3e", "1b40", "1b65" };
  private static final char[][] grcAlphabetRemapping = { { 902, 65 }, { 904, 69 }, { 905, 72 }, { 906, 73 }, { 908, 79 }, { 910, 89 }, { 911, 937 }, { 912, 73 }, { 913, 65 }, { 914, 66 }, { 915, 915 }, { 916, 916 }, { 917, 69 }, { 918, 90 }, { 919, 72 }, { 920, 920 }, { 921, 73 }, { 922, 75 }, { 923, 923 }, { 924, 77 }, { 925, 78 }, { 926, 926 }, { 927, 79 }, { 928, 928 }, { 929, 80 }, { 931, 931 }, { 932, 84 }, { 933, 89 }, { 934, 934 }, { 935, 88 }, { 936, 936 }, { 937, 937 }, { 938, 73 }, { 939, 89 }, { 940, 65 }, { 941, 69 }, { 942, 72 }, { 943, 73 }, { 944, 89 }, { 945, 65 }, { 946, 66 }, { 947, 915 }, { 948, 916 }, { 949, 69 }, { 950, 90 }, { 951, 72 }, { 952, 920 }, { 953, 73 }, { 954, 75 }, { 955, 923 }, { 956, 77 }, { 957, 78 }, { 958, 926 }, { 959, 79 }, { 960, 928 }, { 961, 80 }, { 962, 931 }, { 963, 931 }, { 964, 84 }, { 965, 89 }, { 966, 934 }, { 967, 88 }, { 968, 936 }, { 969, 937 }, { 970, 73 }, { 971, 89 }, { 972, 79 }, { 973, 89 }, { 974, 937 } };
  private static final char[] stdAlphabet = { 64, 163, 36, 165, 232, 233, 249, 236, 242, 199, 10, 216, 248, 13, 197, 229, 916, 95, 934, 915, 923, 937, 928, 936, 931, 920, 926, 160, 198, 230, 223, 201, 32, 33, 34, 35, 164, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 161, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 196, 214, 209, 220, 167, 191, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 228, 246, 241, 252, 224 };

  public static String byteToBits(byte paramByte)
  {
    for (String str = Integer.toBinaryString(paramByte & 0xFF); str.length() < 8; str = "0" + str);
    return str;
  }

  public static String byteToPdu(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Integer.toHexString(paramInt & 0xFF);
    if (str.length() == 1)
      localStringBuffer.append("0");
    localStringBuffer.append(str);
    return k.a(localStringBuffer.toString());
  }

  public static String bytesToBits(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      for (String str = Integer.toBinaryString(0xFF & paramArrayOfByte[i]); str.length() < 8; str = "0" + str);
      if (i > 0)
        localStringBuffer.append(" ");
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }

  public static String bytesToPdu(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayOfByte.length; i++)
      localStringBuffer.append(byteToPdu(0xFF & paramArrayOfByte[i]));
    return localStringBuffer.toString();
  }

  public static int createAddressType(int paramInt)
  {
    return paramInt | 0x80;
  }

  public static int createSwappedBCD(int paramInt)
  {
    int i = (paramInt & 0xFF) / 10;
    return i | (paramInt & 0xFF) - i * 10 << 4;
  }

  public static String decode7bitEncoding(byte[] paramArrayOfByte)
  {
    return decode7bitEncoding(null, paramArrayOfByte);
  }

  public static String decode7bitEncoding(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null);
    for (int i = 0; i == 0; i = paramArrayOfByte1.length)
      return unencodedSeptetsToString(encodedSeptetsToUnencodedSeptets(paramArrayOfByte2));
    String str = unencodedSeptetsToString(encodedSeptetsToUnencodedSeptets(paramArrayOfByte1, false));
    return unencodedSeptetsToString(encodedSeptetsToUnencodedSeptets(paramArrayOfByte2)).substring(str.length());
  }

  public static String decode8bitEncoding(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i;
    if (paramArrayOfByte1 == null)
      i = 0;
    try
    {
      while (true)
      {
        return new String(paramArrayOfByte2, i, paramArrayOfByte2.length - i, "ISO8859_1");
        i = paramArrayOfByte1.length;
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static String decodeDataCodingScheme(Pdu paramPdu)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    switch (extractDcsEncoding(paramPdu.getDataCodingScheme()))
    {
    default:
      if ((0xFFFFFF3F & paramPdu.getDataCodingScheme()) == 0)
        switch (extractDcsClass(paramPdu.getDataCodingScheme()))
        {
        default:
        case 16:
        case 17:
        case 18:
        case 19:
        }
      break;
    case 0:
    case 4:
    case 8:
    }
    while (true)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("7-bit GSM Alphabet");
      break;
      localStringBuffer.append("8-bit encoding");
      break;
      localStringBuffer.append("UCS2 encoding");
      break;
      localStringBuffer.append(", (Flash Message)");
      continue;
      localStringBuffer.append(", (Class1 ME Message)");
      continue;
      localStringBuffer.append(", (Class2 SIM Message)");
      continue;
      localStringBuffer.append(", (Class3 TE Message)");
    }
  }

  public static String decodeFirstOctet(Pdu paramPdu)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("First Octet: " + byteToPdu(paramPdu.getFirstOctet()));
    localStringBuffer.append(" [");
    switch (paramPdu.getTpMti())
    {
    default:
      throw new RuntimeException("Invalid message type");
    case 0:
      localStringBuffer.append("TP-MTI: (SMS-DELIVER)");
      if (hasTpField(paramPdu, "TpMms") != null)
      {
        if (hasTpField(paramPdu, "TpMms").booleanValue())
          localStringBuffer.append(", TP-MMS: (Has more messages)");
      }
      else
      {
        label126: if (hasTpField(paramPdu, "TpRd") != null)
        {
          if (!hasTpField(paramPdu, "TpRd").booleanValue())
            break label355;
          localStringBuffer.append(", TP-RD: (Reject duplicates)");
        }
        label157: if ((hasTpField(paramPdu, "TpVpf") != null) && (hasTpField(paramPdu, "TpVpf").booleanValue()));
        switch (getTpField(paramPdu, "TpVpf").intValue())
        {
        default:
          label224: if (hasTpField(paramPdu, "TpSri") != null)
          {
            if (hasTpField(paramPdu, "TpSri").booleanValue())
              localStringBuffer.append(", TP-SRI: (Requests Status Report)");
          }
          else
          {
            label255: if (hasTpField(paramPdu, "TpSrr") != null)
            {
              if (!hasTpField(paramPdu, "TpSrr").booleanValue())
                break label410;
              localStringBuffer.append(", TP-SRR: (Requests Status Report)");
            }
            if (!paramPdu.hasTpUdhi())
              break label421;
            localStringBuffer.append(", TP-UDHI: (has UDH)");
          }
          label286: break;
        case 16:
        case 24:
        case 0:
        }
      }
      break;
    case 2:
    case 1:
    }
    while (true)
    {
      localStringBuffer.append("]");
      localStringBuffer.append("\n");
      return localStringBuffer.toString();
      localStringBuffer.append("TP-MTI: (SMS-STATUS REPORT)");
      break;
      localStringBuffer.append("TP-MTI: (SMS-SUBMIT)");
      break;
      localStringBuffer.append(", TP-MMS: (has no messages)");
      break label126;
      label355: localStringBuffer.append(", TP-RD: (allow duplicates)");
      break label157;
      localStringBuffer.append(", TP-VPF: (validity format, integer");
      break label224;
      localStringBuffer.append(", TP-VPF: (validity format, timestamp");
      break label224;
      localStringBuffer.append(", TP-VPF: (validity format, none)");
      break label224;
      localStringBuffer.append(", TP-SRI: (No Status Report)");
      break label255;
      label410: localStringBuffer.append(", TP-SRR: (No Status Report)");
      break label286;
      label421: localStringBuffer.append(", TP-UDHI: (no UDH)");
    }
  }

  public static String decodeUcs2Encoding(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i;
    if (paramArrayOfByte1 == null)
      i = 0;
    try
    {
      while (true)
      {
        return new String(paramArrayOfByte2, i, paramArrayOfByte2.length - i, "UTF-16");
        i = paramArrayOfByte1.length;
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static byte[] encode7bitUserData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null)
      return unencodedSeptetsToEncodedSeptets(paramArrayOfByte2);
    byte[] arrayOfByte1 = encodedSeptetsToUnencodedSeptets(paramArrayOfByte1, false);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte2.length);
    return unencodedSeptetsToEncodedSeptets(arrayOfByte2);
  }

  public static byte[] encode8bitUserData(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO8859_1");
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static byte[] encodeUcs2UserData(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-16BE");
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }

  public static String encodedSeptetsToString(byte[] paramArrayOfByte)
  {
    return unencodedSeptetsToString(encodedSeptetsToUnencodedSeptets(paramArrayOfByte));
  }

  public static byte[] encodedSeptetsToUnencodedSeptets(byte[] paramArrayOfByte)
  {
    return encodedSeptetsToUnencodedSeptets(paramArrayOfByte, true);
  }

  public static byte[] encodedSeptetsToUnencodedSeptets(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    BitSet localBitSet = new BitSet(8 * paramArrayOfByte.length);
    int i = 0;
    for (int j = 0; j < paramArrayOfByte.length; j++)
      for (int i4 = 0; i4 < 8; i4++)
      {
        i = i4 + j * 8;
        if ((paramArrayOfByte[j] & 1 << i4) != 0)
          localBitSet.set(i);
      }
    int k = i + 1;
    int m = k / 7;
    int n;
    int i1;
    byte[] arrayOfByte1;
    if (k % 7 != 0)
    {
      n = 1;
      i1 = n + m;
      if (i1 == 0)
        i1++;
      arrayOfByte1 = new byte[i1];
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        break label202;
      int i3 = 0;
      while (true)
        if (i3 < 7)
        {
          if ((k + 1 > i3 + i2 * 7) && (localBitSet.get(i3 + i2 * 7)))
            arrayOfByte1[i2] = ((byte)(arrayOfByte1[i2] | (byte)(1 << i3)));
          i3++;
          continue;
          n = 0;
          break;
        }
    }
    label202: if ((paramBoolean) && (arrayOfByte1[(-1 + arrayOfByte1.length)] == 0))
    {
      byte[] arrayOfByte2 = new byte[-1 + arrayOfByte1.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
      return arrayOfByte2;
    }
    return arrayOfByte1;
  }

  public static int extractAddressType(int paramInt)
  {
    return paramInt & 0x70;
  }

  public static int extractDcsClass(int paramInt)
  {
    return paramInt & 0xFFFFFF13;
  }

  public static int extractDcsCodingGroup(int paramInt)
  {
    return paramInt & 0xFFFFFFF0;
  }

  public static int extractDcsEncoding(int paramInt)
  {
    return paramInt & 0xFFFFFF0C;
  }

  public static int extractDcsFlash(int paramInt)
  {
    return paramInt & 0xFFFFFF13;
  }

  public static int extractNumberPlan(int paramInt)
  {
    return paramInt & 0xF;
  }

  public static int getAddressTypeFor(String paramString)
  {
    int i = 0;
    int j;
    if (paramString.startsWith("+"))
    {
      paramString = paramString.substring(1);
      j = 1;
    }
    while (true)
      if (i < paramString.length())
      {
        if (!Character.isDigit(paramString.charAt(i)))
          return createAddressType(80);
        i++;
      }
      else
      {
        if (j != 0)
          return createAddressType(17);
        return createAddressType(1);
        j = 0;
        i = 0;
      }
  }

  public static String getMultiCharFor(char paramChar)
  {
    switch (paramChar)
    {
    default:
      return "";
    case '\n':
      return "'\f'";
    case 'Λ':
      return "^";
    case '(':
      return "{";
    case ')':
      return "}";
    case '/':
      return "\\";
    case '<':
      return "[";
    case '=':
      return "~";
    case '>':
      return "]";
    case '¡':
      return "|";
    case 'e':
    }
    return "€";
  }

  public static int getNumMultiCharsInSeptets(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[i] == 27)
        j++;
      i++;
    }
    return j;
  }

  public static int getNumSeptetsForOctets(int paramInt)
  {
    int i = paramInt * 8 / 7;
    if (paramInt * 8 % 7 != 0);
    for (int j = 1; ; j = 0)
      return j + i;
  }

  private static Integer getTpField(Pdu paramPdu, String paramString)
  {
    try
    {
      Integer localInteger = (Integer)paramPdu.getClass().getMethod("get" + paramString, new Class[0]).invoke(paramPdu, new Object[0]);
      return localInteger;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static Boolean hasTpField(Pdu paramPdu, String paramString)
  {
    try
    {
      Boolean localBoolean = (Boolean)paramPdu.getClass().getMethod("has" + paramString, new Class[0]).invoke(paramPdu, new Object[0]);
      return localBoolean;
    }
    catch (Exception localException)
    {
    }
    return Boolean.valueOf(false);
  }

  public static String pduToBits(String paramString)
  {
    return bytesToBits(pduToBytes(paramString));
  }

  public static byte[] pduToBytes(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int i = 0; i < paramString.length(); i += 2)
      arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(paramString.substring(i, i + 2), 16));
    return arrayOfByte;
  }

  public static String readBCDNumbers(int paramInt, byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = paramArrayOfByte[i];
      localStringBuffer.append(j & 0xF);
      int k = 0xF & j >>> 4;
      if (k != 15)
        localStringBuffer.append(k);
    }
    return localStringBuffer.toString();
  }

  public static String stringToPdu(String paramString)
  {
    return bytesToPdu(unencodedSeptetsToEncodedSeptets(stringToUnencodedSeptets(paramString)));
  }

  public static byte[] stringToUnencodedSeptets(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    int j = 0;
    int k;
    int m;
    if (j < paramString.length())
    {
      k = paramString.charAt(j);
      m = 0;
      label30: if (m >= extAlphabet.length)
        break label307;
      if (extAlphabet[m] != k);
    }
    while (true)
    {
      if (m != -1)
      {
        localByteArrayOutputStream.write((byte)Integer.parseInt(extBytes[m].substring(0, 2), 16));
        int i6 = i + 1;
        localByteArrayOutputStream.write((byte)Integer.parseInt(extBytes[m].substring(2, 4), 16));
        i = i6 + 1;
        j++;
        break;
        m++;
        break label30;
      }
      int n = 0;
      label123: int i5;
      int i1;
      if (n < stdAlphabet.length)
        if (stdAlphabet[n] == k)
        {
          localByteArrayOutputStream.write((byte)n);
          i5 = i + 1;
          i1 = n;
        }
      for (int i2 = i5; ; i2 = i)
      {
        int i3;
        if (i1 == -1)
        {
          i3 = 0;
          label172: if (i3 >= grcAlphabetRemapping.length)
            break label291;
          if (grcAlphabetRemapping[i3][0] == k)
            k = grcAlphabetRemapping[i3][1];
        }
        while (true)
        {
          if (i3 != -1)
            for (int i4 = 0; ; i4++)
            {
              if (i4 >= stdAlphabet.length)
                break label285;
              if (stdAlphabet[i4] == k)
              {
                localByteArrayOutputStream.write((byte)i4);
                i = i2 + 1;
                break;
                n++;
                break label123;
                i3++;
                break label172;
              }
            }
          localByteArrayOutputStream.write(32);
          i = i2 + 1;
          break;
          return localByteArrayOutputStream.toByteArray();
          label285: i = i2;
          break;
          label291: i3 = i1;
        }
        i1 = -1;
      }
      label307: m = -1;
    }
  }

  public static byte swapNibbles(int paramInt)
  {
    return (byte)(0xF0 & paramInt << 4 | 0xF & paramInt >>> 4);
  }

  public static byte[] unencodedSeptetsToEncodedSeptets(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    BitSet localBitSet = new BitSet();
    for (int j = 0; j < i; j++)
      for (int i5 = 0; i5 < 7; i5++)
        if ((paramArrayOfByte[j] & 1 << i5) != 0)
          localBitSet.set(i5 + j * 7);
    int k = i * 7 / 8;
    int m;
    int n;
    byte[] arrayOfByte;
    if (i * 7 % 8 != 0)
    {
      m = 1;
      n = k + m;
      arrayOfByte = new byte[n];
    }
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= n)
        break label181;
      int i2 = 0;
      label110: if (i2 < 8)
      {
        int i3 = arrayOfByte[i1];
        if (localBitSet.get(i2 + i1 * 8));
        for (int i4 = 1; ; i4 = 0)
        {
          arrayOfByte[i1] = ((byte)(i3 | (byte)(i4 << i2)));
          i2++;
          break label110;
          m = 0;
          break;
        }
      }
    }
    label181: return arrayOfByte;
  }

  public static String unencodedSeptetsToString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j;
    if (i < paramArrayOfByte.length)
      if (paramArrayOfByte[i] == 27)
      {
        if (i < -1 + paramArrayOfByte.length)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("1b");
          j = i + 1;
          String str = Integer.toHexString(paramArrayOfByte[j]);
          for (int k = 0; k < extBytes.length; k++)
            if (extBytes[k].equalsIgnoreCase(str))
              localStringBuffer.append(extAlphabet[k]);
        }
      }
      else
        localStringBuffer.append(stdAlphabet[paramArrayOfByte[i]]);
    while (true)
    {
      i++;
      break;
      return localStringBuffer.toString();
      i = j;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.gsm3040.PduUtils
 * JD-Core Version:    0.6.2
 */
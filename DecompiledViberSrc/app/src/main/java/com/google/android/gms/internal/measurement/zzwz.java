package com.google.android.gms.internal.measurement;

final class zzwz
{
  static String zzd(zzte paramzzte)
  {
    zzxa localzzxa = new zzxa(paramzzte);
    StringBuilder localStringBuilder = new StringBuilder(localzzxa.size());
    int i = 0;
    if (i < localzzxa.size())
    {
      int j = localzzxa.zzam(i);
      switch (j)
      {
      default:
        if ((j >= 32) && (j <= 126))
          localStringBuilder.append((char)j);
        break;
      case 7:
      case 8:
      case 12:
      case 10:
      case 13:
      case 9:
      case 11:
      case 92:
      case 39:
      case 34:
      }
      while (true)
      {
        i++;
        break;
        localStringBuilder.append("\\a");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\v");
        continue;
        localStringBuilder.append("\\\\");
        continue;
        localStringBuilder.append("\\'");
        continue;
        localStringBuilder.append("\\\"");
        continue;
        localStringBuilder.append('\\');
        localStringBuilder.append((char)(48 + (0x3 & j >>> 6)));
        localStringBuilder.append((char)(48 + (0x7 & j >>> 3)));
        localStringBuilder.append((char)(48 + (j & 0x7)));
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwz
 * JD-Core Version:    0.6.2
 */
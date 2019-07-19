package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.MurmurHash3;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzvc
{
  public static int zzbn(String paramString)
  {
    try
    {
      byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
      arrayOfByte1 = arrayOfByte2;
      return MurmurHash3.murmurhash3_x86_32(arrayOfByte1, 0, arrayOfByte1.length, 0);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        byte[] arrayOfByte1 = paramString.getBytes();
    }
  }

  public static String[] zzg(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    char[] arrayOfChar = paramString.toCharArray();
    int i = paramString.length();
    int j = 0;
    int k = 0;
    int m = 0;
    int n;
    int i1;
    int i7;
    label186: int i8;
    label222: int i2;
    label230: int i3;
    int i4;
    if (m < i)
    {
      n = Character.codePointAt(arrayOfChar, m);
      i1 = Character.charCount(n);
      if (Character.isLetter(n))
      {
        Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(n);
        if ((localUnicodeBlock == Character.UnicodeBlock.BOPOMOFO) || (localUnicodeBlock == Character.UnicodeBlock.BOPOMOFO_EXTENDED) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (localUnicodeBlock == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS) || (localUnicodeBlock == Character.UnicodeBlock.HANGUL_JAMO) || (localUnicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES) || (localUnicodeBlock == Character.UnicodeBlock.HIRAGANA) || (localUnicodeBlock == Character.UnicodeBlock.KATAKANA) || (localUnicodeBlock == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS))
        {
          i7 = 1;
          if (i7 == 0)
          {
            if (((n < 65382) || (n > 65437)) && ((n < 65441) || (n > 65500)))
              break label312;
            i8 = 1;
            if (i8 == 0)
              break label318;
          }
          i2 = 1;
          if (i2 == 0)
            break label324;
          if (j != 0)
            localArrayList.add(new String(arrayOfChar, k, m - k));
          localArrayList.add(new String(arrayOfChar, m, i1));
          i3 = k;
          i4 = 0;
        }
      }
    }
    while (true)
    {
      m += i1;
      int i5 = i4;
      k = i3;
      j = i5;
      break;
      i7 = 0;
      break label186;
      label312: i8 = 0;
      break label222;
      label318: i2 = 0;
      break label230;
      label324: if ((Character.isLetterOrDigit(n)) || (Character.getType(n) == 6) || (Character.getType(n) == 8))
      {
        if (j == 0)
          k = m;
        i3 = k;
        i4 = 1;
      }
      else if ((paramBoolean) && (Character.charCount(n) == 1) && (Character.toChars(n)[0] == '\''))
      {
        if (j == 0)
          k = m;
        i3 = k;
        i4 = 1;
      }
      else if (j != 0)
      {
        localArrayList.add(new String(arrayOfChar, k, m - k));
        i3 = k;
        i4 = 0;
        continue;
        if (j != 0)
          localArrayList.add(new String(arrayOfChar, k, m - k));
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      else
      {
        int i6 = j;
        i3 = k;
        i4 = i6;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvc
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.util.a;

public class c
{
  protected static String[] a = { "a", "a", "i", "i", "u", "u", "e", "e", "o", "o", "ka", "ga", "ki", "gi", "ku", "gu", "ke", "ge", "ko", "go", "sa", "za", "shi", "ji", "su", "zu", "se", "ze", "so", "zo", "ta", "da", "chi", "ji", "tsu", "tsu", "zu", "te", "de", "to", "do", "na", "ni", "nu", "ne", "no", "ha", "ba", "pa", "hi", "bi", "pi", "fu", "bu", "pu", "he", "be", "pe", "ho", "bo", "po", "ma", "mi", "mu", "me", "mo", "a", "ya", "u", "yu", "o", "yo", "ra", "ri", "ru", "re", "ro", "wa", "wa", "wi", "we", "o", "n", "v", "ka", "ke" };
  protected static char[] b = { 12434, 12353, 12355, 12357, 12359, 12361, 12419, 12421, 12423, 12387, 12540, 12354, 12356, 12358, 12360, 12362, 12363, 12365, 12367, 12369, 12371, 12373, 12375, 12377, 12379, 12381, 12383, 12385, 12388, 12390, 12392, 12394, 12395, 12396, 12397, 12398, 12399, 12402, 12405, 12408, 12411, 12414, 12415, 12416, 12417, 12418, 12420, 12422, 12424, 12425, 12426, 12427, 12428, 12429, 12431, 12435 };

  public static int a(char paramChar)
  {
    if (f(paramChar))
      return 0;
    if (c(paramChar))
      return 1;
    if (b(paramChar))
      return 2;
    if (g(paramChar))
      return 3;
    return -1;
  }

  public static boolean b(char paramChar)
  {
    return ('ぁ' <= paramChar) && (paramChar <= 'ゞ');
  }

  public static boolean c(char paramChar)
  {
    return (d(paramChar)) || (e(paramChar));
  }

  public static boolean d(char paramChar)
  {
    return (65382 <= paramChar) && (paramChar <= 65437);
  }

  public static boolean e(char paramChar)
  {
    return ('ァ' <= paramChar) && (paramChar <= 'ヾ');
  }

  public static boolean f(char paramChar)
  {
    if (('一' <= paramChar) && (paramChar <= 40869));
    while (('々' <= paramChar) && (paramChar <= '〇'))
      return true;
    return false;
  }

  public static boolean g(char paramChar)
  {
    if (('A' <= paramChar) && (paramChar <= ''));
    while ((('a' <= paramChar) && (paramChar <= 'z')) || (('!' <= paramChar) && (paramChar <= ':')) || (('A' <= paramChar) && (paramChar <= 'Z')))
      return true;
    return false;
  }

  public static char h(char paramChar)
  {
    if (b(paramChar))
      paramChar = (char)(paramChar + '`');
    return paramChar;
  }

  public static char i(char paramChar)
  {
    if (e(paramChar))
      paramChar = (char)(paramChar - '`');
    while (!d(paramChar))
      return paramChar;
    return b[(paramChar - 65382)];
  }

  public static boolean j(char paramChar)
  {
    return (Character.UnicodeBlock.of(paramChar) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (Character.UnicodeBlock.of(paramChar) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (Character.UnicodeBlock.of(paramChar) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (Character.UnicodeBlock.of(paramChar) == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS) || (Character.UnicodeBlock.of(paramChar) == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (Character.UnicodeBlock.of(paramChar) == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT) || (Character.UnicodeBlock.of(paramChar) == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (Character.UnicodeBlock.of(paramChar) == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.a.c
 * JD-Core Version:    0.6.2
 */
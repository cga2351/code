package com.facebook.react.views.text;

import java.text.BreakIterator;

public enum TextTransform
{
  static
  {
    LOWERCASE = new TextTransform("LOWERCASE", 2);
    CAPITALIZE = new TextTransform("CAPITALIZE", 3);
    UNSET = new TextTransform("UNSET", 4);
    TextTransform[] arrayOfTextTransform = new TextTransform[5];
    arrayOfTextTransform[0] = NONE;
    arrayOfTextTransform[1] = UPPERCASE;
    arrayOfTextTransform[2] = LOWERCASE;
    arrayOfTextTransform[3] = CAPITALIZE;
    arrayOfTextTransform[4] = UNSET;
  }

  public static String apply(String paramString, TextTransform paramTextTransform)
  {
    if (paramString == null)
      return null;
    switch (1.$SwitchMap$com$facebook$react$views$text$TextTransform[paramTextTransform.ordinal()])
    {
    default:
      return paramString;
    case 1:
      return paramString.toUpperCase();
    case 2:
      return paramString.toLowerCase();
    case 3:
    }
    return capitalize(paramString);
  }

  private static String capitalize(String paramString)
  {
    BreakIterator localBreakIterator = BreakIterator.getWordInstance();
    localBreakIterator.setText(paramString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = localBreakIterator.first();
    int j = localBreakIterator.next();
    if (j != -1)
    {
      String str = paramString.substring(i, j);
      if (Character.isLetterOrDigit(str.charAt(0)))
      {
        localStringBuilder.append(Character.toUpperCase(str.charAt(0)));
        localStringBuilder.append(str.substring(1).toLowerCase());
      }
      while (true)
      {
        int k = localBreakIterator.next();
        i = j;
        j = k;
        break;
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.TextTransform
 * JD-Core Version:    0.6.2
 */
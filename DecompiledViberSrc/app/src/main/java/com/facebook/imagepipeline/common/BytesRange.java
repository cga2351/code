package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class BytesRange
{
  public static final int TO_END_OF_CONTENT = 2147483647;

  @Nullable
  private static Pattern sHeaderParsingRegEx;
  public final int from;
  public final int to;

  public BytesRange(int paramInt1, int paramInt2)
  {
    this.from = paramInt1;
    this.to = paramInt2;
  }

  public static BytesRange from(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new BytesRange(paramInt, 2147483647);
    }
  }

  @Nullable
  public static BytesRange fromContentRangeHeader(@Nullable String paramString)
    throws IllegalArgumentException
  {
    if (paramString == null)
      return null;
    if (sHeaderParsingRegEx == null)
      sHeaderParsingRegEx = Pattern.compile("[-/ ]");
    while (true)
    {
      try
      {
        String[] arrayOfString = sHeaderParsingRegEx.split(paramString);
        if (arrayOfString.length == 4)
        {
          bool1 = true;
          Preconditions.checkArgument(bool1);
          Preconditions.checkArgument(arrayOfString[0].equals("bytes"));
          int i = Integer.parseInt(arrayOfString[1]);
          int j = Integer.parseInt(arrayOfString[2]);
          int k = Integer.parseInt(arrayOfString[3]);
          if (j <= i)
            break label174;
          bool2 = true;
          Preconditions.checkArgument(bool2);
          if (k <= j)
            break label180;
          bool3 = true;
          Preconditions.checkArgument(bool3);
          if (j < k - 1)
            return new BytesRange(i, j);
          BytesRange localBytesRange = new BytesRange(i, 2147483647);
          return localBytesRange;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new IllegalArgumentException(String.format((Locale)null, "Invalid Content-Range header value: \"%s\"", new Object[] { paramString }), localIllegalArgumentException);
      }
      boolean bool1 = false;
      continue;
      label174: boolean bool2 = false;
      continue;
      label180: boolean bool3 = false;
    }
  }

  public static BytesRange toMax(int paramInt)
  {
    if (paramInt > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new BytesRange(0, paramInt);
    }
  }

  private static String valueOrEmpty(int paramInt)
  {
    if (paramInt == 2147483647)
      return "";
    return Integer.toString(paramInt);
  }

  public boolean contains(@Nullable BytesRange paramBytesRange)
  {
    if (paramBytesRange == null);
    while ((this.from > paramBytesRange.from) || (this.to < paramBytesRange.to))
      return false;
    return true;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    BytesRange localBytesRange;
    do
    {
      return true;
      if (!(paramObject instanceof BytesRange))
        return false;
      localBytesRange = (BytesRange)paramObject;
    }
    while ((this.from == localBytesRange.from) && (this.to == localBytesRange.to));
    return false;
  }

  public int hashCode()
  {
    return HashCodeUtil.hashCode(this.from, this.to);
  }

  public String toHttpRangeHeaderValue()
  {
    Locale localLocale = (Locale)null;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = valueOrEmpty(this.from);
    arrayOfObject[1] = valueOrEmpty(this.to);
    return String.format(localLocale, "bytes=%s-%s", arrayOfObject);
  }

  public String toString()
  {
    Locale localLocale = (Locale)null;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = valueOrEmpty(this.from);
    arrayOfObject[1] = valueOrEmpty(this.to);
    return String.format(localLocale, "%s-%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.common.BytesRange
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cm
  implements FilenameFilter
{
  private final Pattern a;

  public cm(String paramString)
  {
    this(Pattern.compile(paramString));
  }

  public cm(Pattern paramPattern)
  {
    this.a = paramPattern;
  }

  public boolean accept(File paramFile, String paramString)
  {
    return this.a.matcher(paramString).matches();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cm
 * JD-Core Version:    0.6.2
 */
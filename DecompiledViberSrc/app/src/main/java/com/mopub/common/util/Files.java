package com.mopub.common.util;

import java.io.File;

public class Files
{
  public static File createDirectory(String paramString)
  {
    if (paramString == null);
    File localFile;
    do
    {
      return null;
      localFile = new File(paramString);
    }
    while (((!localFile.exists()) || (!localFile.isDirectory())) && ((!localFile.mkdirs()) || (!localFile.isDirectory())));
    return localFile;
  }

  public static int intLength(File paramFile)
  {
    if (paramFile == null)
      return 0;
    long l = paramFile.length();
    if (l < 2147483647L)
      return (int)l;
    return 2147483647;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Files
 * JD-Core Version:    0.6.2
 */
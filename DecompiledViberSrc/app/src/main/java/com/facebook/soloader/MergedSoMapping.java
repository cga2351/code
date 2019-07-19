package com.facebook.soloader;

import javax.annotation.Nullable;

class MergedSoMapping
{
  static void invokeJniOnload(String paramString)
  {
    throw new IllegalArgumentException("Unknown library: " + paramString);
  }

  @Nullable
  static String mapLibName(String paramString)
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.MergedSoMapping
 * JD-Core Version:    0.6.2
 */
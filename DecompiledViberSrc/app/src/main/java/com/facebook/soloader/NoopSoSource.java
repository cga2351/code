package com.facebook.soloader;

import android.os.StrictMode.ThreadPolicy;
import java.io.File;

public class NoopSoSource extends SoSource
{
  public int loadLibrary(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    return 1;
  }

  public File unpackLibrary(String paramString)
  {
    throw new UnsupportedOperationException("unpacking not supported in test mode");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.NoopSoSource
 * JD-Core Version:    0.6.2
 */
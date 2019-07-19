package com.facebook.soloader;

import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nullable;

public class DirectorySoSource extends SoSource
{
  public static final int ON_LD_LIBRARY_PATH = 2;
  public static final int RESOLVE_DEPENDENCIES = 1;
  protected final int flags;
  protected final File soDirectory;

  public DirectorySoSource(File paramFile, int paramInt)
  {
    this.soDirectory = paramFile;
    this.flags = paramInt;
  }

  private static String[] getDependencies(File paramFile)
    throws IOException
  {
    if (SoLoader.SYSTRACE_LIBRARY_LOADING)
      Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[" + paramFile.getName() + "]");
    try
    {
      String[] arrayOfString = MinElf.extract_DT_NEEDED(paramFile);
      return arrayOfString;
    }
    finally
    {
      if (SoLoader.SYSTRACE_LIBRARY_LOADING)
        Api18TraceUtils.endSection();
    }
  }

  private void loadDependencies(File paramFile, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
    throws IOException
  {
    String[] arrayOfString = getDependencies(paramFile);
    Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(arrayOfString));
    int i = 0;
    if (i < arrayOfString.length)
    {
      String str = arrayOfString[i];
      if (str.startsWith("/"));
      while (true)
      {
        i++;
        break;
        SoLoader.loadLibraryBySoName(str, paramInt | 0x1, paramThreadPolicy);
      }
    }
  }

  public void addToLdLibraryPath(Collection<String> paramCollection)
  {
    paramCollection.add(this.soDirectory.getAbsolutePath());
  }

  public int loadLibrary(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
    throws IOException
  {
    return loadLibraryFrom(paramString, paramInt, this.soDirectory, paramThreadPolicy);
  }

  protected int loadLibraryFrom(String paramString, int paramInt, File paramFile, StrictMode.ThreadPolicy paramThreadPolicy)
    throws IOException
  {
    File localFile = new File(paramFile, paramString);
    if (!localFile.exists())
    {
      Log.d("SoLoader", paramString + " not found on " + paramFile.getCanonicalPath());
      return 0;
    }
    Log.d("SoLoader", paramString + " found on " + paramFile.getCanonicalPath());
    if (((paramInt & 0x1) != 0) && ((0x2 & this.flags) != 0))
    {
      Log.d("SoLoader", paramString + " loaded implicitly");
      return 2;
    }
    if ((0x1 & this.flags) != 0)
      loadDependencies(localFile, paramInt, paramThreadPolicy);
    try
    {
      while (true)
      {
        SoLoader.sSoFileLoader.load(localFile.getAbsolutePath(), paramInt);
        return 1;
        Log.d("SoLoader", "Not resolving dependencies for " + paramString);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (localUnsatisfiedLinkError.getMessage().contains("bad ELF magic"))
      {
        Log.d("SoLoader", "Corrupted lib file detected");
        return 3;
      }
      throw localUnsatisfiedLinkError;
    }
  }

  public String toString()
  {
    try
    {
      String str2 = String.valueOf(this.soDirectory.getCanonicalPath());
      str1 = str2;
      return getClass().getName() + "[root = " + str1 + " flags = " + this.flags + ']';
    }
    catch (IOException localIOException)
    {
      while (true)
        String str1 = this.soDirectory.getName();
    }
  }

  @Nullable
  public File unpackLibrary(String paramString)
    throws IOException
  {
    File localFile = new File(this.soDirectory, paramString);
    if (localFile.exists())
      return localFile;
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.DirectorySoSource
 * JD-Core Version:    0.6.2
 */
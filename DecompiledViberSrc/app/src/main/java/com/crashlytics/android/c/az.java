package com.crashlytics.android.c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

final class az
{
  private static final FilenameFilter a = new FilenameFilter()
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return true;
    }
  };

  static int a(File paramFile, int paramInt, Comparator<File> paramComparator)
  {
    return a(paramFile, a, paramInt, paramComparator);
  }

  static int a(File paramFile, FilenameFilter paramFilenameFilter, int paramInt, Comparator<File> paramComparator)
  {
    File[] arrayOfFile = paramFile.listFiles(paramFilenameFilter);
    int i = 0;
    if (arrayOfFile == null);
    label81: 
    while (true)
    {
      return i;
      int j = arrayOfFile.length;
      Arrays.sort(arrayOfFile, paramComparator);
      int k = arrayOfFile.length;
      i = j;
      int m = 0;
      while (true)
      {
        if (m >= k)
          break label81;
        File localFile = arrayOfFile[m];
        if (i <= paramInt)
          break;
        localFile.delete();
        int n = i - 1;
        m++;
        i = n;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.az
 * JD-Core Version:    0.6.2
 */
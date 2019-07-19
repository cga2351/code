package com.facebook.soloader;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;

public class ExtractFromZipSoSource extends UnpackingSoSource
{
  protected final File mZipFileName;
  protected final String mZipSearchPattern;

  public ExtractFromZipSoSource(Context paramContext, String paramString1, File paramFile, String paramString2)
  {
    super(paramContext, paramString1);
    this.mZipFileName = paramFile;
    this.mZipSearchPattern = paramString2;
  }

  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ZipUnpacker(this);
  }

  private static final class ZipDso extends UnpackingSoSource.Dso
    implements Comparable
  {
    final int abiScore;
    final ZipEntry backingEntry;

    ZipDso(String paramString, ZipEntry paramZipEntry, int paramInt)
    {
      super(makePseudoHash(paramZipEntry));
      this.backingEntry = paramZipEntry;
      this.abiScore = paramInt;
    }

    private static String makePseudoHash(ZipEntry paramZipEntry)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramZipEntry.getName();
      arrayOfObject[1] = Long.valueOf(paramZipEntry.getSize());
      arrayOfObject[2] = Long.valueOf(paramZipEntry.getCompressedSize());
      arrayOfObject[3] = Long.valueOf(paramZipEntry.getCrc());
      return String.format("pseudo-zip-hash-1-%s-%s-%s-%s", arrayOfObject);
    }

    public int compareTo(Object paramObject)
    {
      return this.name.compareTo(((ZipDso)paramObject).name);
    }
  }

  protected class ZipUnpacker extends UnpackingSoSource.Unpacker
  {

    @Nullable
    private ExtractFromZipSoSource.ZipDso[] mDsos;
    private final UnpackingSoSource mSoSource;
    private final ZipFile mZipFile = new ZipFile(ExtractFromZipSoSource.this.mZipFileName);

    ZipUnpacker(UnpackingSoSource arg2)
      throws IOException
    {
      Object localObject;
      this.mSoSource = localObject;
    }

    public void close()
      throws IOException
    {
      this.mZipFile.close();
    }

    final ExtractFromZipSoSource.ZipDso[] ensureDsos()
    {
      int i = 0;
      if (this.mDsos == null)
      {
        LinkedHashSet localLinkedHashSet = new LinkedHashSet();
        HashMap localHashMap = new HashMap();
        Pattern localPattern = Pattern.compile(ExtractFromZipSoSource.this.mZipSearchPattern);
        String[] arrayOfString = SysUtil.getSupportedAbis();
        Enumeration localEnumeration = this.mZipFile.entries();
        while (localEnumeration.hasMoreElements())
        {
          ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
          Matcher localMatcher = localPattern.matcher(localZipEntry.getName());
          if (localMatcher.matches())
          {
            String str1 = localMatcher.group(1);
            String str2 = localMatcher.group(2);
            int i1 = SysUtil.findAbiScore(arrayOfString, str1);
            if (i1 >= 0)
            {
              localLinkedHashSet.add(str1);
              ExtractFromZipSoSource.ZipDso localZipDso3 = (ExtractFromZipSoSource.ZipDso)localHashMap.get(str2);
              if ((localZipDso3 == null) || (i1 < localZipDso3.abiScore))
                localHashMap.put(str2, new ExtractFromZipSoSource.ZipDso(str2, localZipEntry, i1));
            }
          }
        }
        this.mSoSource.setSoSourceAbis((String[])localLinkedHashSet.toArray(new String[localLinkedHashSet.size()]));
        ExtractFromZipSoSource.ZipDso[] arrayOfZipDso1 = (ExtractFromZipSoSource.ZipDso[])localHashMap.values().toArray(new ExtractFromZipSoSource.ZipDso[localHashMap.size()]);
        Arrays.sort(arrayOfZipDso1);
        int j = 0;
        int k = 0;
        if (j < arrayOfZipDso1.length)
        {
          ExtractFromZipSoSource.ZipDso localZipDso2 = arrayOfZipDso1[j];
          if (shouldExtract(localZipDso2.backingEntry, localZipDso2.name))
            k++;
          while (true)
          {
            j++;
            break;
            arrayOfZipDso1[j] = null;
          }
        }
        ExtractFromZipSoSource.ZipDso[] arrayOfZipDso2 = new ExtractFromZipSoSource.ZipDso[k];
        for (int m = 0; m < arrayOfZipDso1.length; m++)
        {
          ExtractFromZipSoSource.ZipDso localZipDso1 = arrayOfZipDso1[m];
          if (localZipDso1 != null)
          {
            int n = i + 1;
            arrayOfZipDso2[i] = localZipDso1;
            i = n;
          }
        }
        this.mDsos = arrayOfZipDso2;
      }
      return this.mDsos;
    }

    protected final UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException
    {
      return new UnpackingSoSource.DsoManifest(ensureDsos());
    }

    protected final UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException
    {
      return new ZipBackedInputDsoIterator(null);
    }

    protected boolean shouldExtract(ZipEntry paramZipEntry, String paramString)
    {
      return true;
    }

    private final class ZipBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator
    {
      private int mCurrentDso;

      private ZipBackedInputDsoIterator()
      {
      }

      public boolean hasNext()
      {
        ExtractFromZipSoSource.ZipUnpacker.this.ensureDsos();
        return this.mCurrentDso < ExtractFromZipSoSource.ZipUnpacker.this.mDsos.length;
      }

      public UnpackingSoSource.InputDso next()
        throws IOException
      {
        ExtractFromZipSoSource.ZipUnpacker.this.ensureDsos();
        ExtractFromZipSoSource.ZipDso[] arrayOfZipDso = ExtractFromZipSoSource.ZipUnpacker.this.mDsos;
        int i = this.mCurrentDso;
        this.mCurrentDso = (i + 1);
        ExtractFromZipSoSource.ZipDso localZipDso = arrayOfZipDso[i];
        InputStream localInputStream = ExtractFromZipSoSource.ZipUnpacker.this.mZipFile.getInputStream(localZipDso.backingEntry);
        try
        {
          UnpackingSoSource.InputDso localInputDso = new UnpackingSoSource.InputDso(localZipDso, localInputStream);
          if (0 != 0)
            null.close();
          return localInputDso;
        }
        finally
        {
          if (localInputStream != null)
            localInputStream.close();
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.ExtractFromZipSoSource
 * JD-Core Version:    0.6.2
 */
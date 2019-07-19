package com.viber.svg.jni;

import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class PictureRasterizationInfoStorage
{
  private static final String saveDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/svg-raster-cache";
  protected String filename;
  protected String id;
  protected int prepareViewportHeight;
  protected int prepareViewportWidth;
  protected int rasterizationVersion;

  static
  {
    new File(saveDir).mkdirs();
  }

  public PictureRasterizationInfoStorage(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    this.id = paramString1;
    this.rasterizationVersion = paramInt1;
    this.prepareViewportWidth = paramInt2;
    this.prepareViewportHeight = paramInt3;
    this.filename = (saveDir + "/" + paramString1.replace('/', '_') + '.' + paramString2);
  }

  protected static String md5hash(String paramString)
  {
    StringBuilder localStringBuilder;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      localStringBuilder = new StringBuilder();
      int i = arrayOfByte.length;
      for (int j = 0; j < i; j++)
      {
        int k = arrayOfByte[j];
        localStringBuilder.append(Integer.toHexString(0xF & k >> 4));
        localStringBuilder.append(Integer.toHexString(0xF & k >> 0));
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return null;
    }
    return localStringBuilder.toString();
  }

  protected static String readFile(Reader paramReader)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = new char[16384];
    try
    {
      while (true)
      {
        int i = paramReader.read(arrayOfChar);
        if (i <= 0)
          return localStringBuilder.toString();
        localStringBuilder.append(arrayOfChar, 0, i);
      }
    }
    finally
    {
      paramReader.close();
    }
  }

  public abstract BitmapPictureRenderer.PictureRasterizationInfo[] load()
    throws IOException;

  public abstract void save(BitmapPictureRenderer.PictureRasterizationInfo[] paramArrayOfPictureRasterizationInfo)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.PictureRasterizationInfoStorage
 * JD-Core Version:    0.6.2
 */
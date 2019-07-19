package com.vk.sdk.api.httpClient;

import android.util.Pair;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Random;

public class VKMultipartEntity
{
  private static final String VK_BOUNDARY = "Boundary(======VK_SDK_%d======)";
  private final String mBoundary;
  private final File[] mFiles;
  private String mType;

  public VKMultipartEntity(File[] paramArrayOfFile)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(new Random().nextInt());
    this.mBoundary = String.format(localLocale, "Boundary(======VK_SDK_%d======)", arrayOfObject);
    this.mFiles = paramArrayOfFile;
  }

  public VKMultipartEntity(File[] paramArrayOfFile, String paramString)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(new Random().nextInt());
    this.mBoundary = String.format(localLocale, "Boundary(======VK_SDK_%d======)", arrayOfObject);
    this.mFiles = paramArrayOfFile;
    this.mType = paramString;
  }

  private String getBoundaryEnd()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mBoundary;
    return String.format("\r\n--%s--\r\n", arrayOfObject);
  }

  protected static String getMimeType(String paramString)
  {
    String str1 = MimeTypeMap.getFileExtensionFromUrl(paramString);
    String str2 = null;
    if (str1 != null)
      str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1);
    return str2;
  }

  public InputStream getContent()
    throws IOException, IllegalStateException
  {
    throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
  }

  public long getContentLength()
  {
    long l = 0L;
    for (int i = 0; i < this.mFiles.length; i++)
    {
      File localFile = this.mFiles[i];
      l = l + localFile.length() + getFileDescription(localFile, i).length();
    }
    return l + getBoundaryEnd().length();
  }

  public Pair<String, String> getContentType()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mBoundary;
    return new Pair("Content-Type", String.format("multipart/form-data; boundary=%s", arrayOfObject));
  }

  protected String getFileDescription(File paramFile, int paramInt)
  {
    if ((this.mType != null) && (this.mType.equals("doc")));
    Locale localLocale;
    Object[] arrayOfObject1;
    for (String str1 = "file"; ; str1 = String.format(localLocale, "file%d", arrayOfObject1))
    {
      String str2 = MimeTypeMap.getFileExtensionFromUrl(paramFile.getAbsolutePath());
      StringBuilder localStringBuilder1 = new StringBuilder();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.mBoundary;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(String.format("\r\n--%s\r\n", arrayOfObject2)).append(String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s.%s\"\r\n", new Object[] { str1, str1, str2 }));
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = getMimeType(paramFile.getAbsolutePath());
      return String.format("Content-Type: %s\r\n\r\n", arrayOfObject3);
      localLocale = Locale.US;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramInt + 1);
    }
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = 0; i < this.mFiles.length; i++)
    {
      File localFile = this.mFiles[i];
      paramOutputStream.write(getFileDescription(localFile, i).getBytes("UTF-8"));
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      byte[] arrayOfByte = new byte[2048];
      while (true)
      {
        int j = localFileInputStream.read(arrayOfByte);
        if (j == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, j);
      }
      localFileInputStream.close();
    }
    paramOutputStream.write(getBoundaryEnd().getBytes("UTF-8"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.httpClient.VKMultipartEntity
 * JD-Core Version:    0.6.2
 */
package com.facebook.react.modules.network;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.facebook.common.logging.FLog;
import f.d;
import f.f;
import f.l;
import f.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.GZIPOutputStream;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

class RequestBodyUtil
{
  private static final String CONTENT_ENCODING_GZIP = "gzip";
  private static final String NAME = "RequestBodyUtil";
  private static final String TEMP_FILE_SUFFIX = "temp";

  public static RequestBody create(MediaType paramMediaType, final InputStream paramInputStream)
  {
    return new RequestBody()
    {
      public long contentLength()
      {
        try
        {
          int i = paramInputStream.available();
          return i;
        }
        catch (IOException localIOException)
        {
        }
        return 0L;
      }

      public MediaType contentType()
      {
        return this.val$mediaType;
      }

      public void writeTo(d paramAnonymousd)
        throws IOException
      {
        t localt = null;
        try
        {
          localt = l.a(paramInputStream);
          paramAnonymousd.a(localt);
          return;
        }
        finally
        {
          Util.closeQuietly(localt);
        }
      }
    };
  }

  @Nullable
  public static RequestBody createGzip(MediaType paramMediaType, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes());
      localGZIPOutputStream.close();
      return RequestBody.create(paramMediaType, localByteArrayOutputStream.toByteArray());
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public static ProgressRequestBody createProgressRequest(RequestBody paramRequestBody, ProgressListener paramProgressListener)
  {
    return new ProgressRequestBody(paramRequestBody, paramProgressListener);
  }

  private static InputStream getDownloadFileInputStream(Context paramContext, Uri paramUri)
    throws IOException
  {
    File localFile = File.createTempFile("RequestBodyUtil", "temp", paramContext.getApplicationContext().getCacheDir());
    localFile.deleteOnExit();
    InputStream localInputStream = new URL(paramUri.toString()).openStream();
    try
    {
      ReadableByteChannel localReadableByteChannel = Channels.newChannel(localInputStream);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        try
        {
          localFileOutputStream.getChannel().transferFrom(localReadableByteChannel, 0L, 9223372036854775807L);
          FileInputStream localFileInputStream = new FileInputStream(localFile);
          return localFileInputStream;
        }
        finally
        {
        }
      }
      finally
      {
        localReadableByteChannel.close();
      }
    }
    finally
    {
      localInputStream.close();
    }
  }

  public static RequestBody getEmptyBody(String paramString)
  {
    RequestBody localRequestBody;
    if ((!paramString.equals("POST")) && (!paramString.equals("PUT")))
    {
      boolean bool = paramString.equals("PATCH");
      localRequestBody = null;
      if (!bool);
    }
    else
    {
      localRequestBody = RequestBody.create(null, f.b);
    }
    return localRequestBody;
  }

  @Nullable
  public static InputStream getFileInputStream(Context paramContext, String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri.getScheme().startsWith("http"))
        return getDownloadFileInputStream(paramContext, localUri);
      InputStream localInputStream = paramContext.getContentResolver().openInputStream(localUri);
      return localInputStream;
    }
    catch (Exception localException)
    {
      FLog.e("ReactNative", "Could not retrieve file for contentUri " + paramString, localException);
    }
    return null;
  }

  public static boolean isGzipEncoding(@Nullable String paramString)
  {
    return "gzip".equalsIgnoreCase(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.RequestBodyUtil
 * JD-Core Version:    0.6.2
 */
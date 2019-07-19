package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class FileIoHandler
  implements Runnable
{
  private static final long FILE_TTL = 30000L;
  private static final String TAG = JSPackagerClient.class.getSimpleName();
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private int mNextHandle = 1;
  private final Map<Integer, TtlFileInputStream> mOpenFiles = new HashMap();
  private final Map<String, RequestHandler> mRequestHandlers = new HashMap();

  public FileIoHandler()
  {
    this.mRequestHandlers.put("fopen", new RequestOnlyHandler()
    {
      public void onRequest(@Nullable Object paramAnonymousObject, Responder paramAnonymousResponder)
      {
        while (true)
        {
          JSONObject localJSONObject;
          String str1;
          synchronized (FileIoHandler.this.mOpenFiles)
          {
            try
            {
              localJSONObject = (JSONObject)paramAnonymousObject;
              if (localJSONObject != null)
                continue;
              throw new Exception("params must be an object { mode: string, filename: string }");
            }
            catch (Exception localException)
            {
              paramAnonymousResponder.error(localException.toString());
            }
            return;
            str1 = localJSONObject.optString("mode");
            if (str1 == null)
              throw new Exception("missing params.mode");
          }
          String str2 = localJSONObject.optString("filename");
          if (str2 == null)
            throw new Exception("missing params.filename");
          if (!str1.equals("r"))
            throw new IllegalArgumentException("unsupported mode: " + str1);
          paramAnonymousResponder.respond(Integer.valueOf(FileIoHandler.this.addOpenFile(str2)));
        }
      }
    });
    this.mRequestHandlers.put("fclose", new RequestOnlyHandler()
    {
      public void onRequest(@Nullable Object paramAnonymousObject, Responder paramAnonymousResponder)
      {
        while (true)
        {
          FileIoHandler.TtlFileInputStream localTtlFileInputStream;
          synchronized (FileIoHandler.this.mOpenFiles)
          {
            try
            {
              if ((paramAnonymousObject instanceof Number))
                continue;
              throw new Exception("params must be a file handle");
            }
            catch (Exception localException)
            {
              paramAnonymousResponder.error(localException.toString());
            }
            return;
            localTtlFileInputStream = (FileIoHandler.TtlFileInputStream)FileIoHandler.this.mOpenFiles.get(Integer.valueOf(((Integer)paramAnonymousObject).intValue()));
            if (localTtlFileInputStream == null)
              throw new Exception("invalid file handle, it might have timed out");
          }
          FileIoHandler.this.mOpenFiles.remove(Integer.valueOf(((Integer)paramAnonymousObject).intValue()));
          localTtlFileInputStream.close();
          paramAnonymousResponder.respond("");
        }
      }
    });
    this.mRequestHandlers.put("fread", new RequestOnlyHandler()
    {
      public void onRequest(@Nullable Object paramAnonymousObject, Responder paramAnonymousResponder)
      {
        while (true)
        {
          JSONObject localJSONObject;
          int i;
          synchronized (FileIoHandler.this.mOpenFiles)
          {
            try
            {
              localJSONObject = (JSONObject)paramAnonymousObject;
              if (localJSONObject != null)
                continue;
              throw new Exception("params must be an object { file: handle, size: number }");
            }
            catch (Exception localException)
            {
              paramAnonymousResponder.error(localException.toString());
            }
            return;
            i = localJSONObject.optInt("file");
            if (i == 0)
              throw new Exception("invalid or missing file handle");
          }
          int j = localJSONObject.optInt("size");
          if (j == 0)
            throw new Exception("invalid or missing read size");
          FileIoHandler.TtlFileInputStream localTtlFileInputStream = (FileIoHandler.TtlFileInputStream)FileIoHandler.this.mOpenFiles.get(Integer.valueOf(i));
          if (localTtlFileInputStream == null)
            throw new Exception("invalid file handle, it might have timed out");
          paramAnonymousResponder.respond(localTtlFileInputStream.read(j));
        }
      }
    });
  }

  private int addOpenFile(String paramString)
    throws FileNotFoundException
  {
    int i = this.mNextHandle;
    this.mNextHandle = (i + 1);
    this.mOpenFiles.put(Integer.valueOf(i), new TtlFileInputStream(paramString));
    if (this.mOpenFiles.size() == 1)
      this.mHandler.postDelayed(this, 30000L);
    return i;
  }

  public Map<String, RequestHandler> handlers()
  {
    return this.mRequestHandlers;
  }

  public void run()
  {
    synchronized (this.mOpenFiles)
    {
      Iterator localIterator = this.mOpenFiles.values().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          TtlFileInputStream localTtlFileInputStream = (TtlFileInputStream)localIterator.next();
          if (!localTtlFileInputStream.expiredTtl())
            continue;
          localIterator.remove();
          try
          {
            localTtlFileInputStream.close();
          }
          catch (IOException localIOException)
          {
            FLog.e(TAG, "closing expired file failed: " + localIOException.toString());
          }
        }
    }
    if (!this.mOpenFiles.isEmpty())
      this.mHandler.postDelayed(this, 30000L);
  }

  private static class TtlFileInputStream
  {
    private final FileInputStream mStream;
    private long mTtl;

    public TtlFileInputStream(String paramString)
      throws FileNotFoundException
    {
      this.mStream = new FileInputStream(paramString);
      this.mTtl = (30000L + System.currentTimeMillis());
    }

    private void extendTtl()
    {
      this.mTtl = (30000L + System.currentTimeMillis());
    }

    public void close()
      throws IOException
    {
      this.mStream.close();
    }

    public boolean expiredTtl()
    {
      return System.currentTimeMillis() >= this.mTtl;
    }

    public String read(int paramInt)
      throws IOException
    {
      extendTtl();
      byte[] arrayOfByte = new byte[paramInt];
      return Base64.encodeToString(arrayOfByte, 0, this.mStream.read(arrayOfByte), 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.FileIoHandler
 * JD-Core Version:    0.6.2
 */
package com.facebook.react.modules.network;

import f.d;
import f.l;
import f.s;
import java.io.IOException;
import java.io.OutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ProgressRequestBody extends RequestBody
{
  private long mContentLength = 0L;
  private final ProgressListener mProgressListener;
  private final RequestBody mRequestBody;

  public ProgressRequestBody(RequestBody paramRequestBody, ProgressListener paramProgressListener)
  {
    this.mRequestBody = paramRequestBody;
    this.mProgressListener = paramProgressListener;
  }

  private s outputStreamSink(d paramd)
  {
    return l.a(new CountingOutputStream(paramd.c())
    {
      private void sendProgressUpdate()
        throws IOException
      {
        long l1 = getCount();
        long l2 = ProgressRequestBody.this.contentLength();
        ProgressListener localProgressListener = ProgressRequestBody.this.mProgressListener;
        if (l1 == l2);
        for (boolean bool = true; ; bool = false)
        {
          localProgressListener.onProgress(l1, l2, bool);
          return;
        }
      }

      public void write(int paramAnonymousInt)
        throws IOException
      {
        super.write(paramAnonymousInt);
        sendProgressUpdate();
      }

      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        super.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        sendProgressUpdate();
      }
    });
  }

  public long contentLength()
    throws IOException
  {
    if (this.mContentLength == 0L)
      this.mContentLength = this.mRequestBody.contentLength();
    return this.mContentLength;
  }

  public MediaType contentType()
  {
    return this.mRequestBody.contentType();
  }

  public void writeTo(d paramd)
    throws IOException
  {
    d locald = l.a(outputStreamSink(paramd));
    contentLength();
    this.mRequestBody.writeTo(locald);
    locald.flush();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ProgressRequestBody
 * JD-Core Version:    0.6.2
 */
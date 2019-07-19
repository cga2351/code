package com.facebook.react.modules.network;

import f.c;
import f.e;
import f.h;
import f.l;
import f.t;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

public class ProgressResponseBody extends ResponseBody
{

  @Nullable
  private e mBufferedSource;
  private final ProgressListener mProgressListener;
  private final ResponseBody mResponseBody;
  private long mTotalBytesRead;

  public ProgressResponseBody(ResponseBody paramResponseBody, ProgressListener paramProgressListener)
  {
    this.mResponseBody = paramResponseBody;
    this.mProgressListener = paramProgressListener;
    this.mTotalBytesRead = 0L;
  }

  private t source(t paramt)
  {
    return new h(paramt)
    {
      public long read(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        long l1 = super.read(paramAnonymousc, paramAnonymousLong);
        ProgressResponseBody localProgressResponseBody = ProgressResponseBody.this;
        long l2 = ProgressResponseBody.this.mTotalBytesRead;
        long l3;
        ProgressListener localProgressListener;
        long l4;
        long l5;
        if (l1 != -1L)
        {
          l3 = l1;
          ProgressResponseBody.access$002(localProgressResponseBody, l3 + l2);
          localProgressListener = ProgressResponseBody.this.mProgressListener;
          l4 = ProgressResponseBody.this.mTotalBytesRead;
          l5 = ProgressResponseBody.this.mResponseBody.contentLength();
          if (l1 != -1L)
            break label111;
        }
        label111: for (boolean bool = true; ; bool = false)
        {
          localProgressListener.onProgress(l4, l5, bool);
          return l1;
          l3 = 0L;
          break;
        }
      }
    };
  }

  public long contentLength()
  {
    return this.mResponseBody.contentLength();
  }

  public MediaType contentType()
  {
    return this.mResponseBody.contentType();
  }

  public e source()
  {
    if (this.mBufferedSource == null)
      this.mBufferedSource = l.a(source(this.mResponseBody.source()));
    return this.mBufferedSource;
  }

  public long totalBytesRead()
  {
    return this.mTotalBytesRead;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ProgressResponseBody
 * JD-Core Version:    0.6.2
 */
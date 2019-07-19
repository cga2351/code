package g;

import f.c;
import f.e;
import f.t;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

final class h<T>
  implements b<T>
{
  private final n<T, ?> a;

  @Nullable
  private final Object[] b;
  private volatile boolean c;

  @Nullable
  @GuardedBy("this")
  private Call d;

  @Nullable
  @GuardedBy("this")
  private Throwable e;

  @GuardedBy("this")
  private boolean f;

  h(n<T, ?> paramn, @Nullable Object[] paramArrayOfObject)
  {
    this.a = paramn;
    this.b = paramArrayOfObject;
  }

  private Call e()
    throws IOException
  {
    Request localRequest = this.a.a(this.b);
    Call localCall = this.a.c.newCall(localRequest);
    if (localCall == null)
      throw new NullPointerException("Call.Factory returned null.");
    return localCall;
  }

  public l<T> a()
    throws IOException
  {
    try
    {
      if (this.f)
        throw new IllegalStateException("Already executed.");
    }
    finally
    {
    }
    this.f = true;
    if (this.e != null)
    {
      if ((this.e instanceof IOException))
        throw ((IOException)this.e);
      throw ((RuntimeException)this.e);
    }
    Call localCall = this.d;
    if (localCall == null);
    try
    {
      localCall = e();
      this.d = localCall;
      if (this.c)
        localCall.cancel();
      return a(localCall.execute());
    }
    catch (RuntimeException localRuntimeException)
    {
      this.e = localRuntimeException;
      throw localRuntimeException;
    }
    catch (IOException localIOException)
    {
      label108: break label108;
    }
  }

  l<T> a(Response paramResponse)
    throws IOException
  {
    ResponseBody localResponseBody = paramResponse.body();
    Response localResponse = paramResponse.newBuilder().body(new b(localResponseBody.contentType(), localResponseBody.contentLength())).build();
    int i = localResponse.code();
    if ((i < 200) || (i >= 300))
      try
      {
        l locall1 = l.a(o.a(localResponseBody), localResponse);
        return locall1;
      }
      finally
      {
        localResponseBody.close();
      }
    if ((i == 204) || (i == 205))
    {
      localResponseBody.close();
      return l.a(null, localResponse);
    }
    a locala = new a(localResponseBody);
    try
    {
      l locall2 = l.a(this.a.a(locala), localResponse);
      return locall2;
    }
    catch (RuntimeException localRuntimeException)
    {
      locala.a();
      throw localRuntimeException;
    }
  }

  public void a(final d<T> paramd)
  {
    o.a(paramd, "callback == null");
    try
    {
      if (this.f)
        throw new IllegalStateException("Already executed.");
    }
    finally
    {
    }
    this.f = true;
    Call localCall1 = this.d;
    Throwable localThrowable1 = this.e;
    if ((localCall1 == null) && (localThrowable1 == null));
    while (true)
    {
      try
      {
        localCall2 = e();
        this.d = localCall2;
        if (localThrowable1 != null)
        {
          paramd.a(this, localThrowable1);
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        this.e = localThrowable2;
        localCall2 = localCall1;
        continue;
        if (this.c)
          localCall2.cancel();
        localCall2.enqueue(new Callback()
        {
          private void a(l<T> paramAnonymousl)
          {
            try
            {
              paramd.a(h.this, paramAnonymousl);
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }

          private void a(Throwable paramAnonymousThrowable)
          {
            try
            {
              paramd.a(h.this, paramAnonymousThrowable);
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }

          public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
          {
            try
            {
              paramd.a(h.this, paramAnonymousIOException);
              return;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }

          public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
            throws IOException
          {
            try
            {
              l locall = h.this.a(paramAnonymousResponse);
              a(locall);
              return;
            }
            catch (Throwable localThrowable)
            {
              a(localThrowable);
            }
          }
        });
        return;
      }
      Call localCall2 = localCall1;
    }
  }

  public boolean b()
  {
    boolean bool = true;
    if (this.c)
      return bool;
    while (true)
    {
      try
      {
        if ((this.d != null) && (this.d.isCanceled()))
          return bool;
      }
      finally
      {
      }
      bool = false;
    }
  }

  public h<T> d()
  {
    return new h(this.a, this.b);
  }

  static final class a extends ResponseBody
  {
    IOException a;
    private final ResponseBody b;

    a(ResponseBody paramResponseBody)
    {
      this.b = paramResponseBody;
    }

    void a()
      throws IOException
    {
      if (this.a != null)
        throw this.a;
    }

    public void close()
    {
      this.b.close();
    }

    public long contentLength()
    {
      return this.b.contentLength();
    }

    public MediaType contentType()
    {
      return this.b.contentType();
    }

    public e source()
    {
      return f.l.a(new f.h(this.b.source())
      {
        public long read(c paramAnonymousc, long paramAnonymousLong)
          throws IOException
        {
          try
          {
            long l = super.read(paramAnonymousc, paramAnonymousLong);
            return l;
          }
          catch (IOException localIOException)
          {
            h.a.this.a = localIOException;
            throw localIOException;
          }
        }
      });
    }
  }

  static final class b extends ResponseBody
  {
    private final MediaType a;
    private final long b;

    b(MediaType paramMediaType, long paramLong)
    {
      this.a = paramMediaType;
      this.b = paramLong;
    }

    public long contentLength()
    {
      return this.b;
    }

    public MediaType contentType()
    {
      return this.a;
    }

    public e source()
    {
      throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.h
 * JD-Core Version:    0.6.2
 */
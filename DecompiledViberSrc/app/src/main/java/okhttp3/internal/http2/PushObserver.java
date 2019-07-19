package okhttp3.internal.http2;

import f.e;
import java.io.IOException;
import java.util.List;

public abstract interface PushObserver
{
  public static final PushObserver CANCEL = new PushObserver()
  {
    public boolean onData(int paramAnonymousInt1, e paramAnonymouse, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      throws IOException
    {
      paramAnonymouse.i(paramAnonymousInt2);
      return true;
    }

    public boolean onHeaders(int paramAnonymousInt, List<Header> paramAnonymousList, boolean paramAnonymousBoolean)
    {
      return true;
    }

    public boolean onRequest(int paramAnonymousInt, List<Header> paramAnonymousList)
    {
      return true;
    }

    public void onReset(int paramAnonymousInt, ErrorCode paramAnonymousErrorCode)
    {
    }
  };

  public abstract boolean onData(int paramInt1, e parame, int paramInt2, boolean paramBoolean)
    throws IOException;

  public abstract boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean);

  public abstract boolean onRequest(int paramInt, List<Header> paramList);

  public abstract void onReset(int paramInt, ErrorCode paramErrorCode);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.PushObserver
 * JD-Core Version:    0.6.2
 */
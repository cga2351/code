package g;

import javax.annotation.Nullable;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class l<T>
{
  private final Response a;

  @Nullable
  private final T b;

  @Nullable
  private final ResponseBody c;

  private l(Response paramResponse, @Nullable T paramT, @Nullable ResponseBody paramResponseBody)
  {
    this.a = paramResponse;
    this.b = paramT;
    this.c = paramResponseBody;
  }

  public static <T> l<T> a(@Nullable T paramT, Response paramResponse)
  {
    o.a(paramResponse, "rawResponse == null");
    if (!paramResponse.isSuccessful())
      throw new IllegalArgumentException("rawResponse must be successful response");
    return new l(paramResponse, paramT, null);
  }

  public static <T> l<T> a(ResponseBody paramResponseBody, Response paramResponse)
  {
    o.a(paramResponseBody, "body == null");
    o.a(paramResponse, "rawResponse == null");
    if (paramResponse.isSuccessful())
      throw new IllegalArgumentException("rawResponse should not be successful response");
    return new l(paramResponse, null, paramResponseBody);
  }

  public boolean a()
  {
    return this.a.isSuccessful();
  }

  @Nullable
  public T b()
  {
    return this.b;
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.l
 * JD-Core Version:    0.6.2
 */
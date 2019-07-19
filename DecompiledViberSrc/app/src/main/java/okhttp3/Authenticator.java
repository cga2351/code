package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

public abstract interface Authenticator
{
  public static final Authenticator NONE = new Authenticator()
  {
    public Request authenticate(Route paramAnonymousRoute, Response paramAnonymousResponse)
    {
      return null;
    }
  };

  @Nullable
  public abstract Request authenticate(Route paramRoute, Response paramResponse)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Authenticator
 * JD-Core Version:    0.6.2
 */
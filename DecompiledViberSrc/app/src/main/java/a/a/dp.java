package a.a;

import android.net.Uri;
import com.appboy.f.c;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class dp
{
  private static final String a = c.a(dp.class);

  public static String a(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    int j = 0;
    long l1 = 1L;
    if (j < i)
    {
      int k = paramArrayOfObject[j].hashCode();
      if (k == 0);
      for (long l2 = 1L; ; l2 = k)
      {
        l1 *= l2;
        j++;
        break;
      }
    }
    return Long.toHexString(l1);
  }

  public static URI a(Uri paramUri)
  {
    try
    {
      URI localURI = new URI(paramUri.toString());
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      c.e(a, "Could not create URI from uri [" + paramUri.toString() + "]");
    }
    return null;
  }

  public static URL a(URI paramURI)
  {
    try
    {
      URL localURL = new URL(paramURI.toString());
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      c.d(a, "Unable to parse URI [" + localMalformedURLException.getMessage() + "]", localMalformedURLException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dp
 * JD-Core Version:    0.6.2
 */
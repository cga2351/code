package c.b.a.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class c
  implements e
{
  private final AssetManager a;

  public c(AssetManager paramAssetManager)
  {
    this.a = paramAssetManager;
  }

  public InputStream a(String paramString)
  {
    String str = paramString.substring(1);
    try
    {
      InputStream localInputStream = this.a.open(str);
      return localInputStream;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.c
 * JD-Core Version:    0.6.2
 */
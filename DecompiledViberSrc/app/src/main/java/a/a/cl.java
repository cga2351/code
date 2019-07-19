package a.a;

import android.net.Uri;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class cl
  implements ci
{
  public final Uri a;
  private Map<String, String> b;

  protected cl(Uri paramUri, Map<String, String> paramMap)
  {
    this.b = paramMap;
    this.a = Uri.parse(paramUri + j());
  }

  public Uri a()
  {
    return this.a;
  }

  public String j()
  {
    if ((this.b == null) || (this.b.size() == 0))
      return "";
    Iterator localIterator = this.b.keySet().iterator();
    String str2;
    for (String str1 = "?"; localIterator.hasNext(); str1 = str1 + str2 + "=" + (String)this.b.get(str2) + "&")
      str2 = (String)localIterator.next();
    return str1.substring(0, -1 + str1.length());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cl
 * JD-Core Version:    0.6.2
 */
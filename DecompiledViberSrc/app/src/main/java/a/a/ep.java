package a.a;

import java.util.Iterator;
import java.util.List;

public final class ep extends eq
  implements ee
{
  public ep(List<ee> paramList)
  {
    super(paramList);
  }

  public boolean a(ez paramez)
  {
    Iterator localIterator = this.a.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = true)
      if (!((ee)localIterator.next()).a(paramez))
        return false;
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ep
 * JD-Core Version:    0.6.2
 */
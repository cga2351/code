package androidx.work;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class OverwritingInputMerger extends h
{
  public e a(List<e> paramList)
  {
    e.a locala = new e.a();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localHashMap.putAll(((e)localIterator.next()).a());
    locala.a(localHashMap);
    return locala.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.OverwritingInputMerger
 * JD-Core Version:    0.6.2
 */
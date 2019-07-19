package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class LabelMap extends LinkedHashMap<String, Label>
  implements Iterable<Label>
{
  private final Policy policy;

  public LabelMap()
  {
    this(null);
  }

  public LabelMap(Policy paramPolicy)
  {
    this.policy = paramPolicy;
  }

  private String[] getArray(Set<String> paramSet)
  {
    return (String[])paramSet.toArray(new String[0]);
  }

  public String[] getKeys()
    throws Exception
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel != null)
      {
        String str1 = localLabel.getPath();
        String str2 = localLabel.getName();
        localHashSet.add(str1);
        localHashSet.add(str2);
      }
    }
    return getArray(localHashSet);
  }

  public Label getLabel(String paramString)
  {
    return (Label)remove(paramString);
  }

  public LabelMap getLabels()
    throws Exception
  {
    LabelMap localLabelMap = new LabelMap(this.policy);
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel != null)
        localLabelMap.put(localLabel.getPath(), localLabel);
    }
    return localLabelMap;
  }

  public String[] getPaths()
    throws Exception
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel != null)
        localHashSet.add(localLabel.getPath());
    }
    return getArray(localHashSet);
  }

  public boolean isStrict(Context paramContext)
  {
    if (this.policy == null)
      return paramContext.isStrict();
    return (paramContext.isStrict()) && (this.policy.isStrict());
  }

  public Iterator<Label> iterator()
  {
    return values().iterator();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.LabelMap
 * JD-Core Version:    0.6.2
 */
package com.mopub.network;

import com.mopub.common.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ImpressionsEmitter
{
  private static final HashSet<ImpressionListener> a = new HashSet();

  private static Set<ImpressionListener> a()
  {
    try
    {
      HashSet localHashSet = new HashSet(a);
      return localHashSet;
    }
    finally
    {
    }
  }

  static void a(String paramString, ImpressionData paramImpressionData)
  {
    Preconditions.checkNotNull(paramString);
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((ImpressionListener)localIterator.next()).onImpression(paramString, paramImpressionData);
  }

  public static void addListener(ImpressionListener paramImpressionListener)
  {
    Preconditions.checkNotNull(paramImpressionListener);
    try
    {
      a.add(paramImpressionListener);
      return;
    }
    finally
    {
    }
  }

  public static void removeListener(ImpressionListener paramImpressionListener)
  {
    Preconditions.checkNotNull(paramImpressionListener);
    try
    {
      a.remove(paramImpressionListener);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.ImpressionsEmitter
 * JD-Core Version:    0.6.2
 */
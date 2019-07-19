package twitter4j.management;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class APIStatistics
  implements APIStatisticsMBean
{
  private final InvocationStatisticsCalculator API_STATS_CALCULATOR;
  private final int HISTORY_SIZE;
  private final Map<String, InvocationStatisticsCalculator> METHOD_STATS_MAP;

  public APIStatistics(int paramInt)
  {
    this.API_STATS_CALCULATOR = new InvocationStatisticsCalculator("API", paramInt);
    this.METHOD_STATS_MAP = new HashMap(100);
    this.HISTORY_SIZE = paramInt;
  }

  private InvocationStatisticsCalculator getMethodStatistics(String paramString)
  {
    try
    {
      InvocationStatisticsCalculator localInvocationStatisticsCalculator = (InvocationStatisticsCalculator)this.METHOD_STATS_MAP.get(paramString);
      if (localInvocationStatisticsCalculator == null)
      {
        localInvocationStatisticsCalculator = new InvocationStatisticsCalculator(paramString, this.HISTORY_SIZE);
        this.METHOD_STATS_MAP.put(paramString, localInvocationStatisticsCalculator);
      }
      return localInvocationStatisticsCalculator;
    }
    finally
    {
    }
  }

  public long getAverageTime()
  {
    return this.API_STATS_CALCULATOR.getAverageTime();
  }

  public long getCallCount()
  {
    return this.API_STATS_CALCULATOR.getCallCount();
  }

  public long getErrorCount()
  {
    return this.API_STATS_CALCULATOR.getErrorCount();
  }

  public Iterable<? extends InvocationStatistics> getInvocationStatistics()
  {
    try
    {
      Collection localCollection = this.METHOD_STATS_MAP.values();
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Map<String, String> getMethodLevelSummariesAsString()
  {
    HashMap localHashMap;
    try
    {
      localHashMap = new HashMap();
      Iterator localIterator = this.METHOD_STATS_MAP.values().iterator();
      while (localIterator.hasNext())
      {
        InvocationStatisticsCalculator localInvocationStatisticsCalculator = (InvocationStatisticsCalculator)localIterator.next();
        localHashMap.put(localInvocationStatisticsCalculator.getName(), localInvocationStatisticsCalculator.toString());
      }
    }
    finally
    {
    }
    return localHashMap;
  }

  public String getMethodLevelSummary(String paramString)
  {
    try
    {
      String str = ((InvocationStatisticsCalculator)this.METHOD_STATS_MAP.get(paramString)).toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String getName()
  {
    return this.API_STATS_CALCULATOR.getName();
  }

  public long getTotalTime()
  {
    return this.API_STATS_CALCULATOR.getTotalTime();
  }

  public void methodCalled(String paramString, long paramLong, boolean paramBoolean)
  {
    try
    {
      getMethodStatistics(paramString).increment(paramLong, paramBoolean);
      this.API_STATS_CALCULATOR.increment(paramLong, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void reset()
  {
    try
    {
      this.API_STATS_CALCULATOR.reset();
      this.METHOD_STATS_MAP.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.management.APIStatistics
 * JD-Core Version:    0.6.2
 */
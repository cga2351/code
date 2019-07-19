package twitter4j.management;

public class InvocationStatisticsCalculator
  implements InvocationStatistics
{
  private long callCount;
  private long errorCount;
  private int index;
  private String name;
  private long[] times;
  private long totalTime;

  public InvocationStatisticsCalculator(String paramString, int paramInt)
  {
    this.name = paramString;
    this.times = new long[paramInt];
  }

  public long getAverageTime()
  {
    long l1 = 0L;
    try
    {
      int i = Math.min(Math.abs((int)this.callCount), this.times.length);
      if (i == 0);
      while (true)
      {
        return l1;
        long l2 = l1;
        for (int j = 0; j < i; j++)
          l2 += this.times[j];
        l1 = l2 / i;
      }
    }
    finally
    {
    }
  }

  public long getCallCount()
  {
    return this.callCount;
  }

  public long getErrorCount()
  {
    return this.errorCount;
  }

  public String getName()
  {
    return this.name;
  }

  public long getTotalTime()
  {
    return this.totalTime;
  }

  void increment(long paramLong, boolean paramBoolean)
  {
    long l1 = 1L;
    this.callCount = (l1 + this.callCount);
    long l2 = this.errorCount;
    if (paramBoolean)
      l1 = 0L;
    this.errorCount = (l1 + l2);
    this.totalTime = (paramLong + this.totalTime);
    this.times[this.index] = paramLong;
    int i = 1 + this.index;
    this.index = i;
    if (i >= this.times.length)
      this.index = 0;
  }

  public void reset()
  {
    try
    {
      this.callCount = 0L;
      this.errorCount = 0L;
      this.totalTime = 0L;
      this.times = new long[this.times.length];
      this.index = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("calls=").append(getCallCount()).append(",").append("errors=").append(getErrorCount()).append(",").append("totalTime=").append(getTotalTime()).append(",").append("avgTime=").append(getAverageTime());
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.management.InvocationStatisticsCalculator
 * JD-Core Version:    0.6.2
 */
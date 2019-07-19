package com.facebook.systrace;

public final class SystraceMessage
{
  private static final Builder NOOP_BUILDER = new NoopBuilder(null);

  public static Builder beginSection(long paramLong, String paramString)
  {
    return NOOP_BUILDER;
  }

  public static Builder endSection(long paramLong)
  {
    return NOOP_BUILDER;
  }

  public static abstract class Builder
  {
    public abstract Builder arg(String paramString, double paramDouble);

    public abstract Builder arg(String paramString, int paramInt);

    public abstract Builder arg(String paramString, long paramLong);

    public abstract Builder arg(String paramString, Object paramObject);

    public abstract void flush();
  }

  private static abstract interface Flusher
  {
    public abstract void flush(StringBuilder paramStringBuilder);
  }

  private static class NoopBuilder extends SystraceMessage.Builder
  {
    public SystraceMessage.Builder arg(String paramString, double paramDouble)
    {
      return this;
    }

    public SystraceMessage.Builder arg(String paramString, int paramInt)
    {
      return this;
    }

    public SystraceMessage.Builder arg(String paramString, long paramLong)
    {
      return this;
    }

    public SystraceMessage.Builder arg(String paramString, Object paramObject)
    {
      return this;
    }

    public void flush()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.systrace.SystraceMessage
 * JD-Core Version:    0.6.2
 */
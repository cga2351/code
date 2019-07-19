package com.facebook.imagepipeline.systrace;

import android.os.Build.VERSION;
import android.os.Trace;

public class DefaultFrescoSystrace
  implements FrescoSystrace.Systrace
{
  public void beginSection(String paramString)
  {
  }

  public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String paramString)
  {
    return FrescoSystrace.NO_OP_ARGS_BUILDER;
  }

  public void endSection()
  {
  }

  public boolean isTracing()
  {
    return false;
  }

  private static final class DefaultArgsBuilder
    implements FrescoSystrace.ArgsBuilder
  {
    private final StringBuilder mStringBuilder;

    public DefaultArgsBuilder(String paramString)
    {
      this.mStringBuilder = new StringBuilder(paramString);
    }

    public FrescoSystrace.ArgsBuilder arg(String paramString, double paramDouble)
    {
      this.mStringBuilder.append(';').append(paramString).append('=').append(Double.toString(paramDouble));
      return this;
    }

    public FrescoSystrace.ArgsBuilder arg(String paramString, int paramInt)
    {
      this.mStringBuilder.append(';').append(paramString).append('=').append(Integer.toString(paramInt));
      return this;
    }

    public FrescoSystrace.ArgsBuilder arg(String paramString, long paramLong)
    {
      this.mStringBuilder.append(';').append(paramString).append('=').append(Long.toString(paramLong));
      return this;
    }

    public FrescoSystrace.ArgsBuilder arg(String paramString, Object paramObject)
    {
      StringBuilder localStringBuilder = this.mStringBuilder.append(';').append(paramString).append('=');
      if (paramObject == null);
      for (String str = "null"; ; str = paramObject.toString())
      {
        localStringBuilder.append(str);
        return this;
      }
    }

    public void flush()
    {
      if (this.mStringBuilder.length() > 127)
        this.mStringBuilder.setLength(127);
      if (Build.VERSION.SDK_INT >= 18)
        Trace.beginSection(this.mStringBuilder.toString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.systrace.DefaultFrescoSystrace
 * JD-Core Version:    0.6.2
 */
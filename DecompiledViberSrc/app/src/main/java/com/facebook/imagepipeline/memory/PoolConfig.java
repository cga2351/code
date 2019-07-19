package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import javax.annotation.concurrent.Immutable;

@Immutable
public class PoolConfig
{
  private final PoolParams mBitmapPoolParams;
  private final PoolStatsTracker mBitmapPoolStatsTracker;
  private final PoolParams mFlexByteArrayPoolParams;
  private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  private final PoolParams mNativeMemoryChunkPoolParams;
  private final PoolStatsTracker mNativeMemoryChunkPoolStatsTracker;
  private final PoolParams mSmallByteArrayPoolParams;
  private final PoolStatsTracker mSmallByteArrayPoolStatsTracker;

  private PoolConfig(Builder paramBuilder)
  {
    PoolParams localPoolParams1;
    Object localObject1;
    label31: PoolParams localPoolParams2;
    label48: Object localObject2;
    label66: PoolParams localPoolParams3;
    label84: Object localObject3;
    label102: PoolParams localPoolParams4;
    if (paramBuilder.mBitmapPoolParams == null)
    {
      localPoolParams1 = DefaultBitmapPoolParams.get();
      this.mBitmapPoolParams = localPoolParams1;
      if (paramBuilder.mBitmapPoolStatsTracker != null)
        break label153;
      localObject1 = NoOpPoolStatsTracker.getInstance();
      this.mBitmapPoolStatsTracker = ((PoolStatsTracker)localObject1);
      if (paramBuilder.mFlexByteArrayPoolParams != null)
        break label161;
      localPoolParams2 = DefaultFlexByteArrayPoolParams.get();
      this.mFlexByteArrayPoolParams = localPoolParams2;
      if (paramBuilder.mMemoryTrimmableRegistry != null)
        break label170;
      localObject2 = NoOpMemoryTrimmableRegistry.getInstance();
      this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)localObject2);
      if (paramBuilder.mNativeMemoryChunkPoolParams != null)
        break label179;
      localPoolParams3 = DefaultNativeMemoryChunkPoolParams.get();
      this.mNativeMemoryChunkPoolParams = localPoolParams3;
      if (paramBuilder.mNativeMemoryChunkPoolStatsTracker != null)
        break label188;
      localObject3 = NoOpPoolStatsTracker.getInstance();
      this.mNativeMemoryChunkPoolStatsTracker = ((PoolStatsTracker)localObject3);
      if (paramBuilder.mSmallByteArrayPoolParams != null)
        break label197;
      localPoolParams4 = DefaultByteArrayPoolParams.get();
      label120: this.mSmallByteArrayPoolParams = localPoolParams4;
      if (paramBuilder.mSmallByteArrayPoolStatsTracker != null)
        break label206;
    }
    label153: label161: label170: label179: label188: label197: label206: for (Object localObject4 = NoOpPoolStatsTracker.getInstance(); ; localObject4 = paramBuilder.mSmallByteArrayPoolStatsTracker)
    {
      this.mSmallByteArrayPoolStatsTracker = ((PoolStatsTracker)localObject4);
      return;
      localPoolParams1 = paramBuilder.mBitmapPoolParams;
      break;
      localObject1 = paramBuilder.mBitmapPoolStatsTracker;
      break label31;
      localPoolParams2 = paramBuilder.mFlexByteArrayPoolParams;
      break label48;
      localObject2 = paramBuilder.mMemoryTrimmableRegistry;
      break label66;
      localPoolParams3 = paramBuilder.mNativeMemoryChunkPoolParams;
      break label84;
      localObject3 = paramBuilder.mNativeMemoryChunkPoolStatsTracker;
      break label102;
      localPoolParams4 = paramBuilder.mSmallByteArrayPoolParams;
      break label120;
    }
  }

  public static Builder newBuilder()
  {
    return new Builder(null);
  }

  public PoolParams getBitmapPoolParams()
  {
    return this.mBitmapPoolParams;
  }

  public PoolStatsTracker getBitmapPoolStatsTracker()
  {
    return this.mBitmapPoolStatsTracker;
  }

  public PoolParams getFlexByteArrayPoolParams()
  {
    return this.mFlexByteArrayPoolParams;
  }

  public MemoryTrimmableRegistry getMemoryTrimmableRegistry()
  {
    return this.mMemoryTrimmableRegistry;
  }

  public PoolParams getNativeMemoryChunkPoolParams()
  {
    return this.mNativeMemoryChunkPoolParams;
  }

  public PoolStatsTracker getNativeMemoryChunkPoolStatsTracker()
  {
    return this.mNativeMemoryChunkPoolStatsTracker;
  }

  public PoolParams getSmallByteArrayPoolParams()
  {
    return this.mSmallByteArrayPoolParams;
  }

  public PoolStatsTracker getSmallByteArrayPoolStatsTracker()
  {
    return this.mSmallByteArrayPoolStatsTracker;
  }

  public static class Builder
  {
    private PoolParams mBitmapPoolParams;
    private PoolStatsTracker mBitmapPoolStatsTracker;
    private PoolParams mFlexByteArrayPoolParams;
    private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private PoolParams mNativeMemoryChunkPoolParams;
    private PoolStatsTracker mNativeMemoryChunkPoolStatsTracker;
    private PoolParams mSmallByteArrayPoolParams;
    private PoolStatsTracker mSmallByteArrayPoolStatsTracker;

    public PoolConfig build()
    {
      return new PoolConfig(this, null);
    }

    public Builder setBitmapPoolParams(PoolParams paramPoolParams)
    {
      this.mBitmapPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }

    public Builder setBitmapPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mBitmapPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }

    public Builder setFlexByteArrayPoolParams(PoolParams paramPoolParams)
    {
      this.mFlexByteArrayPoolParams = paramPoolParams;
      return this;
    }

    public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry paramMemoryTrimmableRegistry)
    {
      this.mMemoryTrimmableRegistry = paramMemoryTrimmableRegistry;
      return this;
    }

    public Builder setNativeMemoryChunkPoolParams(PoolParams paramPoolParams)
    {
      this.mNativeMemoryChunkPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }

    public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mNativeMemoryChunkPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }

    public Builder setSmallByteArrayPoolParams(PoolParams paramPoolParams)
    {
      this.mSmallByteArrayPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }

    public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mSmallByteArrayPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.PoolConfig
 * JD-Core Version:    0.6.2
 */
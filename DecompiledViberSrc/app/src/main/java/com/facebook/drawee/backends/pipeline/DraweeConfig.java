package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class DraweeConfig
{

  @Nullable
  private final ImmutableList<DrawableFactory> mCustomDrawableFactories;
  private final Supplier<Boolean> mDebugOverlayEnabledSupplier;

  @Nullable
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

  private DraweeConfig(Builder paramBuilder)
  {
    ImmutableList localImmutableList;
    if (paramBuilder.mCustomDrawableFactories != null)
    {
      localImmutableList = ImmutableList.copyOf(paramBuilder.mCustomDrawableFactories);
      this.mCustomDrawableFactories = localImmutableList;
      if (paramBuilder.mDebugOverlayEnabledSupplier == null)
        break label55;
    }
    label55: for (Supplier localSupplier = paramBuilder.mDebugOverlayEnabledSupplier; ; localSupplier = Suppliers.of(Boolean.valueOf(false)))
    {
      this.mDebugOverlayEnabledSupplier = localSupplier;
      this.mPipelineDraweeControllerFactory = paramBuilder.mPipelineDraweeControllerFactory;
      return;
      localImmutableList = null;
      break;
    }
  }

  public static Builder newBuilder()
  {
    return new Builder();
  }

  @Nullable
  public ImmutableList<DrawableFactory> getCustomDrawableFactories()
  {
    return this.mCustomDrawableFactories;
  }

  public Supplier<Boolean> getDebugOverlayEnabledSupplier()
  {
    return this.mDebugOverlayEnabledSupplier;
  }

  @Nullable
  public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory()
  {
    return this.mPipelineDraweeControllerFactory;
  }

  public static class Builder
  {
    private List<DrawableFactory> mCustomDrawableFactories;
    private Supplier<Boolean> mDebugOverlayEnabledSupplier;
    private PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public Builder addCustomDrawableFactory(DrawableFactory paramDrawableFactory)
    {
      if (this.mCustomDrawableFactories == null)
        this.mCustomDrawableFactories = new ArrayList();
      this.mCustomDrawableFactories.add(paramDrawableFactory);
      return this;
    }

    public DraweeConfig build()
    {
      return new DraweeConfig(this, null);
    }

    public Builder setDebugOverlayEnabledSupplier(Supplier<Boolean> paramSupplier)
    {
      Preconditions.checkNotNull(paramSupplier);
      this.mDebugOverlayEnabledSupplier = paramSupplier;
      return this;
    }

    public Builder setDrawDebugOverlay(boolean paramBoolean)
    {
      return setDebugOverlayEnabledSupplier(Suppliers.of(Boolean.valueOf(paramBoolean)));
    }

    public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory paramPipelineDraweeControllerFactory)
    {
      this.mPipelineDraweeControllerFactory = paramPipelineDraweeControllerFactory;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.DraweeConfig
 * JD-Core Version:    0.6.2
 */
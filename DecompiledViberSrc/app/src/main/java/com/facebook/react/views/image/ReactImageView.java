package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.RoundingParams.RoundingMethod;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper;
import com.facebook.react.views.imagehelper.MultiSourceHelper.MultiSourceResult;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

public class ReactImageView extends GenericDraweeView
{
  public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
  public static final String REMOTE_TRANSPARENT_BITMAP_URI = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=";
  private static float[] sComputedCornerRadii = new float[4];
  private static final Matrix sInverse = new Matrix();
  private static final Matrix sMatrix = new Matrix();
  private static final Matrix sTileMatrix = new Matrix();
  private int mBackgroundColor = 0;

  @Nullable
  private RoundedColorDrawable mBackgroundImageDrawable;
  private int mBorderColor;

  @Nullable
  private float[] mBorderCornerRadii;
  private float mBorderRadius = (0.0F / 0.0F);
  private float mBorderWidth;

  @Nullable
  private ImageSource mCachedImageSource;

  @Nullable
  private final Object mCallerContext;

  @Nullable
  private ControllerListener mControllerForTesting;

  @Nullable
  private ControllerListener mControllerListener;

  @Nullable
  private Drawable mDefaultImageDrawable;
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  private int mFadeDurationMs = -1;

  @Nullable
  private GlobalImageLoadListener mGlobalImageLoadListener;
  private ReadableMap mHeaders;

  @Nullable
  private ImageSource mImageSource;
  private boolean mIsDirty;

  @Nullable
  private IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;

  @Nullable
  private Drawable mLoadingImageDrawable;
  private int mOverlayColor;
  private boolean mProgressiveRenderingEnabled;
  private ImageResizeMethod mResizeMethod = ImageResizeMethod.AUTO;
  private final RoundedCornerPostprocessor mRoundedCornerPostprocessor;
  private ScalingUtils.ScaleType mScaleType = ImageResizeMode.defaultValue();
  private final List<ImageSource> mSources;
  private Shader.TileMode mTileMode = ImageResizeMode.defaultTileMode();
  private final TilePostprocessor mTilePostprocessor;

  public ReactImageView(Context paramContext, AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable GlobalImageLoadListener paramGlobalImageLoadListener, @Nullable Object paramObject)
  {
    super(paramContext, buildHierarchy(paramContext));
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mRoundedCornerPostprocessor = new RoundedCornerPostprocessor(null);
    this.mTilePostprocessor = new TilePostprocessor(null);
    this.mGlobalImageLoadListener = paramGlobalImageLoadListener;
    this.mCallerContext = paramObject;
    this.mSources = new LinkedList();
  }

  private static GenericDraweeHierarchy buildHierarchy(Context paramContext)
  {
    return new GenericDraweeHierarchyBuilder(paramContext.getResources()).setRoundingParams(RoundingParams.fromCornersRadius(0.0F)).build();
  }

  private void cornerRadii(float[] paramArrayOfFloat)
  {
    float f1;
    float f2;
    label41: float f3;
    if (!YogaConstants.isUndefined(this.mBorderRadius))
    {
      f1 = this.mBorderRadius;
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[0])))
        break label145;
      f2 = this.mBorderCornerRadii[0];
      paramArrayOfFloat[0] = f2;
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[1])))
        break label150;
      f3 = this.mBorderCornerRadii[1];
      label72: paramArrayOfFloat[1] = f3;
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[2])))
        break label156;
    }
    label145: label150: label156: for (float f4 = this.mBorderCornerRadii[2]; ; f4 = f1)
    {
      paramArrayOfFloat[2] = f4;
      if ((this.mBorderCornerRadii != null) && (!YogaConstants.isUndefined(this.mBorderCornerRadii[3])))
        f1 = this.mBorderCornerRadii[3];
      paramArrayOfFloat[3] = f1;
      return;
      f1 = 0.0F;
      break;
      f2 = f1;
      break label41;
      f3 = f1;
      break label72;
    }
  }

  private boolean hasMultipleSources()
  {
    return this.mSources.size() > 1;
  }

  private boolean isTiled()
  {
    return this.mTileMode != Shader.TileMode.CLAMP;
  }

  private void setSourceImage()
  {
    this.mImageSource = null;
    if (this.mSources.isEmpty())
    {
      localImageSource = new ImageSource(getContext(), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=");
      this.mSources.add(localImageSource);
    }
    while (!hasMultipleSources())
    {
      ImageSource localImageSource;
      this.mImageSource = ((ImageSource)this.mSources.get(0));
      return;
    }
    MultiSourceHelper.MultiSourceResult localMultiSourceResult = MultiSourceHelper.getBestSourceForSize(getWidth(), getHeight(), this.mSources);
    this.mImageSource = localMultiSourceResult.getBestResult();
    this.mCachedImageSource = localMultiSourceResult.getBestResultInCache();
  }

  private boolean shouldResize(ImageSource paramImageSource)
  {
    boolean bool1;
    if (this.mResizeMethod == ImageResizeMethod.AUTO)
      if (!UriUtil.isLocalContentUri(paramImageSource.getUri()))
      {
        boolean bool2 = UriUtil.isLocalFileUri(paramImageSource.getUri());
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
    ImageResizeMethod localImageResizeMethod1;
    ImageResizeMethod localImageResizeMethod2;
    do
    {
      return bool1;
      localImageResizeMethod1 = this.mResizeMethod;
      localImageResizeMethod2 = ImageResizeMethod.RESIZE;
      bool1 = false;
    }
    while (localImageResizeMethod1 != localImageResizeMethod2);
    return true;
  }

  private void warnImageSource(String paramString)
  {
  }

  public boolean hasOverlappingRendering()
  {
    return false;
  }

  public void maybeUpdateView()
  {
    if (!this.mIsDirty);
    boolean bool;
    do
    {
      do
      {
        do
          return;
        while ((hasMultipleSources()) && ((getWidth() <= 0) || (getHeight() <= 0)));
        setSourceImage();
      }
      while (this.mImageSource == null);
      bool = shouldResize(this.mImageSource);
    }
    while (((bool) && ((getWidth() <= 0) || (getHeight() <= 0))) || ((isTiled()) && ((getWidth() <= 0) || (getHeight() <= 0))));
    GenericDraweeHierarchy localGenericDraweeHierarchy = (GenericDraweeHierarchy)getHierarchy();
    localGenericDraweeHierarchy.setActualImageScaleType(this.mScaleType);
    if (this.mDefaultImageDrawable != null)
      localGenericDraweeHierarchy.setPlaceholderImage(this.mDefaultImageDrawable, this.mScaleType);
    if (this.mLoadingImageDrawable != null)
      localGenericDraweeHierarchy.setPlaceholderImage(this.mLoadingImageDrawable, ScalingUtils.ScaleType.CENTER);
    int i;
    RoundingParams localRoundingParams;
    label286: int j;
    label305: ResizeOptions localResizeOptions;
    if ((this.mScaleType != ScalingUtils.ScaleType.CENTER_CROP) && (this.mScaleType != ScalingUtils.ScaleType.FOCUS_CROP))
    {
      i = 1;
      localRoundingParams = localGenericDraweeHierarchy.getRoundingParams();
      cornerRadii(sComputedCornerRadii);
      localRoundingParams.setCornersRadii(sComputedCornerRadii[0], sComputedCornerRadii[1], sComputedCornerRadii[2], sComputedCornerRadii[3]);
      if (this.mBackgroundImageDrawable != null)
      {
        this.mBackgroundImageDrawable.setBorder(this.mBorderColor, this.mBorderWidth);
        this.mBackgroundImageDrawable.setRadii(localRoundingParams.getCornersRadii());
        localGenericDraweeHierarchy.setBackgroundImage(this.mBackgroundImageDrawable);
      }
      if (i != 0)
        localRoundingParams.setCornersRadius(0.0F);
      localRoundingParams.setBorder(this.mBorderColor, this.mBorderWidth);
      if (this.mOverlayColor == 0)
        break label635;
      localRoundingParams.setOverlayColor(this.mOverlayColor);
      localGenericDraweeHierarchy.setRoundingParams(localRoundingParams);
      if (this.mFadeDurationMs < 0)
        break label647;
      j = this.mFadeDurationMs;
      localGenericDraweeHierarchy.setFadeDuration(j);
      LinkedList localLinkedList = new LinkedList();
      if (i != 0)
        localLinkedList.add(this.mRoundedCornerPostprocessor);
      if (this.mIterativeBoxBlurPostProcessor != null)
        localLinkedList.add(this.mIterativeBoxBlurPostProcessor);
      if (isTiled())
        localLinkedList.add(this.mTilePostprocessor);
      Postprocessor localPostprocessor = MultiPostprocessor.from(localLinkedList);
      if (!bool)
        break label671;
      localResizeOptions = new ResizeOptions(getWidth(), getHeight());
      label402: ReactNetworkImageRequest localReactNetworkImageRequest = ReactNetworkImageRequest.fromBuilderWithHeaders(ImageRequestBuilder.newBuilderWithSource(this.mImageSource.getUri()).setPostprocessor(localPostprocessor).setResizeOptions(localResizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled), this.mHeaders);
      if (this.mGlobalImageLoadListener != null)
        this.mGlobalImageLoadListener.onLoadAttempt(this.mImageSource.getUri());
      this.mDraweeControllerBuilder.reset();
      this.mDraweeControllerBuilder.setAutoPlayAnimations(true).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(localReactNetworkImageRequest);
      if (this.mCachedImageSource != null)
      {
        ImageRequest localImageRequest = ImageRequestBuilder.newBuilderWithSource(this.mCachedImageSource.getUri()).setPostprocessor(localPostprocessor).setResizeOptions(localResizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build();
        this.mDraweeControllerBuilder.setLowResImageRequest(localImageRequest);
      }
      if ((this.mControllerListener == null) || (this.mControllerForTesting == null))
        break label677;
      ForwardingControllerListener localForwardingControllerListener = new ForwardingControllerListener();
      localForwardingControllerListener.addListener(this.mControllerListener);
      localForwardingControllerListener.addListener(this.mControllerForTesting);
      this.mDraweeControllerBuilder.setControllerListener(localForwardingControllerListener);
    }
    while (true)
    {
      setController(this.mDraweeControllerBuilder.build());
      this.mIsDirty = false;
      this.mDraweeControllerBuilder.reset();
      return;
      i = 0;
      break;
      label635: localRoundingParams.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
      break label286;
      label647: if (this.mImageSource.isResource())
      {
        j = 0;
        break label305;
      }
      j = 300;
      break label305;
      label671: localResizeOptions = null;
      break label402;
      label677: if (this.mControllerForTesting != null)
        this.mDraweeControllerBuilder.setControllerListener(this.mControllerForTesting);
      else if (this.mControllerListener != null)
        this.mDraweeControllerBuilder.setControllerListener(this.mControllerListener);
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0))
      if ((!this.mIsDirty) && (!hasMultipleSources()) && (!isTiled()))
        break label52;
    label52: for (boolean bool = true; ; bool = false)
    {
      this.mIsDirty = bool;
      maybeUpdateView();
      return;
    }
  }

  public void setBackgroundColor(int paramInt)
  {
    if (this.mBackgroundColor != paramInt)
    {
      this.mBackgroundColor = paramInt;
      this.mBackgroundImageDrawable = new RoundedColorDrawable(paramInt);
      this.mIsDirty = true;
    }
  }

  public void setBlurRadius(float paramFloat)
  {
    int i = (int)PixelUtil.toPixelFromDIP(paramFloat);
    if (i == 0);
    for (this.mIterativeBoxBlurPostProcessor = null; ; this.mIterativeBoxBlurPostProcessor = new IterativeBoxBlurPostProcessor(i))
    {
      this.mIsDirty = true;
      return;
    }
  }

  public void setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
    this.mIsDirty = true;
  }

  public void setBorderRadius(float paramFloat)
  {
    if (!FloatUtil.floatsEqual(this.mBorderRadius, paramFloat))
    {
      this.mBorderRadius = paramFloat;
      this.mIsDirty = true;
    }
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    if (this.mBorderCornerRadii == null)
    {
      this.mBorderCornerRadii = new float[4];
      Arrays.fill(this.mBorderCornerRadii, (0.0F / 0.0F));
    }
    if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[paramInt], paramFloat))
    {
      this.mBorderCornerRadii[paramInt] = paramFloat;
      this.mIsDirty = true;
    }
  }

  public void setBorderWidth(float paramFloat)
  {
    this.mBorderWidth = PixelUtil.toPixelFromDIP(paramFloat);
    this.mIsDirty = true;
  }

  public void setControllerListener(ControllerListener paramControllerListener)
  {
    this.mControllerForTesting = paramControllerListener;
    this.mIsDirty = true;
    maybeUpdateView();
  }

  public void setDefaultSource(@Nullable String paramString)
  {
    this.mDefaultImageDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), paramString);
    this.mIsDirty = true;
  }

  public void setFadeDuration(int paramInt)
  {
    this.mFadeDurationMs = paramInt;
  }

  public void setHeaders(ReadableMap paramReadableMap)
  {
    this.mHeaders = paramReadableMap;
  }

  public void setLoadingIndicatorSource(@Nullable String paramString)
  {
    Drawable localDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), paramString);
    if (localDrawable != null);
    for (AutoRotateDrawable localAutoRotateDrawable = new AutoRotateDrawable(localDrawable, 1000); ; localAutoRotateDrawable = null)
    {
      this.mLoadingImageDrawable = localAutoRotateDrawable;
      this.mIsDirty = true;
      return;
    }
  }

  public void setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
    this.mIsDirty = true;
  }

  public void setProgressiveRenderingEnabled(boolean paramBoolean)
  {
    this.mProgressiveRenderingEnabled = paramBoolean;
  }

  public void setResizeMethod(ImageResizeMethod paramImageResizeMethod)
  {
    this.mResizeMethod = paramImageResizeMethod;
    this.mIsDirty = true;
  }

  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
    this.mIsDirty = true;
  }

  public void setShouldNotifyLoadEvents(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (this.mControllerListener = null; ; this.mControllerListener = new BaseControllerListener()
    {
      public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 1, true, paramAnonymousThrowable.getMessage()));
      }

      public void onFinalImageSet(String paramAnonymousString, @Nullable ImageInfo paramAnonymousImageInfo, @Nullable Animatable paramAnonymousAnimatable)
      {
        if (paramAnonymousImageInfo != null)
        {
          this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 2, ReactImageView.this.mImageSource.getSource(), paramAnonymousImageInfo.getWidth(), paramAnonymousImageInfo.getHeight()));
          this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 3));
        }
      }

      public void onSubmit(String paramAnonymousString, Object paramAnonymousObject)
      {
        this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 4));
      }
    })
    {
      this.mIsDirty = true;
      return;
    }
  }

  public void setSource(@Nullable ReadableArray paramReadableArray)
  {
    this.mSources.clear();
    if ((paramReadableArray == null) || (paramReadableArray.size() == 0))
    {
      ImageSource localImageSource1 = new ImageSource(getContext(), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=");
      this.mSources.add(localImageSource1);
    }
    while (true)
    {
      this.mIsDirty = true;
      return;
      int i = paramReadableArray.size();
      int j = 0;
      if (i == 1)
      {
        String str2 = paramReadableArray.getMap(0).getString("uri");
        ImageSource localImageSource3 = new ImageSource(getContext(), str2);
        this.mSources.add(localImageSource3);
        if (Uri.EMPTY.equals(localImageSource3.getUri()))
          warnImageSource(str2);
      }
      else
      {
        while (j < paramReadableArray.size())
        {
          ReadableMap localReadableMap = paramReadableArray.getMap(j);
          String str1 = localReadableMap.getString("uri");
          ImageSource localImageSource2 = new ImageSource(getContext(), str1, localReadableMap.getDouble("width"), localReadableMap.getDouble("height"));
          this.mSources.add(localImageSource2);
          if (Uri.EMPTY.equals(localImageSource2.getUri()))
            warnImageSource(str1);
          j++;
        }
      }
    }
  }

  public void setTileMode(Shader.TileMode paramTileMode)
  {
    this.mTileMode = paramTileMode;
    this.mIsDirty = true;
  }

  private class RoundedCornerPostprocessor extends BasePostprocessor
  {
    private RoundedCornerPostprocessor()
    {
    }

    void getRadii(Bitmap paramBitmap, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
    {
      ReactImageView.this.mScaleType.getTransform(ReactImageView.sMatrix, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), paramBitmap.getWidth(), paramBitmap.getHeight(), 0.0F, 0.0F);
      ReactImageView.sMatrix.invert(ReactImageView.sInverse);
      paramArrayOfFloat2[0] = ReactImageView.sInverse.mapRadius(paramArrayOfFloat1[0]);
      paramArrayOfFloat2[1] = paramArrayOfFloat2[0];
      paramArrayOfFloat2[2] = ReactImageView.sInverse.mapRadius(paramArrayOfFloat1[1]);
      paramArrayOfFloat2[3] = paramArrayOfFloat2[2];
      paramArrayOfFloat2[4] = ReactImageView.sInverse.mapRadius(paramArrayOfFloat1[2]);
      paramArrayOfFloat2[5] = paramArrayOfFloat2[4];
      paramArrayOfFloat2[6] = ReactImageView.sInverse.mapRadius(paramArrayOfFloat1[3]);
      paramArrayOfFloat2[7] = paramArrayOfFloat2[6];
    }

    public void process(Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      ReactImageView.this.cornerRadii(ReactImageView.sComputedCornerRadii);
      paramBitmap1.setHasAlpha(true);
      if ((FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[0], 0.0F)) && (FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[1], 0.0F)) && (FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[2], 0.0F)) && (FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[3], 0.0F)))
      {
        super.process(paramBitmap1, paramBitmap2);
        return;
      }
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setShader(new BitmapShader(paramBitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      Canvas localCanvas = new Canvas(paramBitmap1);
      float[] arrayOfFloat = new float[8];
      getRadii(paramBitmap2, ReactImageView.sComputedCornerRadii, arrayOfFloat);
      Path localPath = new Path();
      localPath.addRoundRect(new RectF(0.0F, 0.0F, paramBitmap2.getWidth(), paramBitmap2.getHeight()), arrayOfFloat, Path.Direction.CW);
      localCanvas.drawPath(localPath, localPaint);
    }
  }

  private class TilePostprocessor extends BasePostprocessor
  {
    private TilePostprocessor()
    {
    }

    public CloseableReference<Bitmap> process(Bitmap paramBitmap, PlatformBitmapFactory paramPlatformBitmapFactory)
    {
      Rect localRect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
      ReactImageView.this.mScaleType.getTransform(ReactImageView.sTileMatrix, localRect, paramBitmap.getWidth(), paramBitmap.getHeight(), 0.0F, 0.0F);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      BitmapShader localBitmapShader = new BitmapShader(paramBitmap, ReactImageView.this.mTileMode, ReactImageView.this.mTileMode);
      localBitmapShader.setLocalMatrix(ReactImageView.sTileMatrix);
      localPaint.setShader(localBitmapShader);
      CloseableReference localCloseableReference1 = paramPlatformBitmapFactory.createBitmap(ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
      try
      {
        new Canvas((Bitmap)localCloseableReference1.get()).drawRect(localRect, localPaint);
        CloseableReference localCloseableReference2 = localCloseableReference1.clone();
        return localCloseableReference2;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference1);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.ReactImageView
 * JD-Core Version:    0.6.2
 */
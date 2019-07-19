package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfControllerListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

public class ImagePerfMonitor extends BaseRequestListener
{
  private boolean mEnabled;

  @Nullable
  private ForwardingRequestListener mForwardingRequestListener;

  @Nullable
  private ImageOriginListener mImageOriginListener;

  @Nullable
  private ImageOriginRequestListener mImageOriginRequestListener;

  @Nullable
  private ImagePerfControllerListener mImagePerfControllerListener;

  @Nullable
  private List<ImagePerfDataListener> mImagePerfDataListeners;

  @Nullable
  private ImagePerfRequestListener mImagePerfRequestListener;
  private final ImagePerfState mImagePerfState;
  private final MonotonicClock mMonotonicClock;
  private final PipelineDraweeController mPipelineDraweeController;

  public ImagePerfMonitor(MonotonicClock paramMonotonicClock, PipelineDraweeController paramPipelineDraweeController)
  {
    this.mMonotonicClock = paramMonotonicClock;
    this.mPipelineDraweeController = paramPipelineDraweeController;
    this.mImagePerfState = new ImagePerfState();
  }

  private void setupListeners()
  {
    if (this.mImagePerfControllerListener == null)
      this.mImagePerfControllerListener = new ImagePerfControllerListener(this.mMonotonicClock, this.mImagePerfState, this);
    if (this.mImagePerfRequestListener == null)
      this.mImagePerfRequestListener = new ImagePerfRequestListener(this.mMonotonicClock, this.mImagePerfState);
    if (this.mImageOriginListener == null)
      this.mImageOriginListener = new ImagePerfImageOriginListener(this.mImagePerfState, this);
    if (this.mImageOriginRequestListener == null)
      this.mImageOriginRequestListener = new ImageOriginRequestListener(this.mPipelineDraweeController.getId(), this.mImageOriginListener);
    while (true)
    {
      if (this.mForwardingRequestListener == null)
      {
        RequestListener[] arrayOfRequestListener = new RequestListener[2];
        arrayOfRequestListener[0] = this.mImagePerfRequestListener;
        arrayOfRequestListener[1] = this.mImageOriginRequestListener;
        this.mForwardingRequestListener = new ForwardingRequestListener(arrayOfRequestListener);
      }
      return;
      this.mImageOriginRequestListener.init(this.mPipelineDraweeController.getId());
    }
  }

  public void addImagePerfDataListener(@Nullable ImagePerfDataListener paramImagePerfDataListener)
  {
    if (paramImagePerfDataListener == null)
      return;
    if (this.mImagePerfDataListeners == null)
      this.mImagePerfDataListeners = new LinkedList();
    this.mImagePerfDataListeners.add(paramImagePerfDataListener);
  }

  public void clearImagePerfDataListeners()
  {
    if (this.mImagePerfDataListeners != null)
      this.mImagePerfDataListeners.clear();
  }

  public void notifyListeners(ImagePerfState paramImagePerfState, int paramInt)
  {
    paramImagePerfState.setImageLoadStatus(paramInt);
    if ((!this.mEnabled) || (this.mImagePerfDataListeners == null) || (this.mImagePerfDataListeners.isEmpty()));
    while (true)
    {
      return;
      ImagePerfData localImagePerfData = paramImagePerfState.snapshot();
      Iterator localIterator = this.mImagePerfDataListeners.iterator();
      while (localIterator.hasNext())
        ((ImagePerfDataListener)localIterator.next()).onImagePerfDataUpdated(localImagePerfData, paramInt);
    }
  }

  public void removeImagePerfDataListener(ImagePerfDataListener paramImagePerfDataListener)
  {
    if (this.mImagePerfDataListeners == null)
      return;
    this.mImagePerfDataListeners.remove(paramImagePerfDataListener);
  }

  public void reset()
  {
    clearImagePerfDataListeners();
    setEnabled(false);
    this.mImagePerfState.reset();
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
    if (paramBoolean)
    {
      setupListeners();
      if (this.mImageOriginListener != null)
        this.mPipelineDraweeController.addImageOriginListener(this.mImageOriginListener);
      if (this.mImagePerfControllerListener != null)
        this.mPipelineDraweeController.addControllerListener(this.mImagePerfControllerListener);
      if (this.mForwardingRequestListener != null)
        this.mPipelineDraweeController.addRequestListener(this.mForwardingRequestListener);
    }
    do
    {
      return;
      if (this.mImageOriginListener != null)
        this.mPipelineDraweeController.removeImageOriginListener(this.mImageOriginListener);
      if (this.mImagePerfControllerListener != null)
        this.mPipelineDraweeController.removeControllerListener(this.mImagePerfControllerListener);
    }
    while (this.mForwardingRequestListener == null);
    this.mPipelineDraweeController.removeRequestListener(this.mForwardingRequestListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor
 * JD-Core Version:    0.6.2
 */
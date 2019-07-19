package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ARTSurfaceViewShadowNode extends LayoutShadowNode
  implements TextureView.SurfaceTextureListener
{

  @Nullable
  private Integer mBackgroundColor;

  @Nullable
  private Surface mSurface;

  private void drawOutput()
  {
    if ((this.mSurface == null) || (!this.mSurface.isValid()))
      markChildrenUpdatesSeen(this);
    while (true)
    {
      return;
      try
      {
        Canvas localCanvas = this.mSurface.lockCanvas(null);
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.mBackgroundColor != null)
          localCanvas.drawColor(this.mBackgroundColor.intValue());
        Paint localPaint = new Paint();
        for (int i = 0; i < getChildCount(); i++)
        {
          ARTVirtualNode localARTVirtualNode = (ARTVirtualNode)getChildAt(i);
          localARTVirtualNode.draw(localCanvas, localPaint, 1.0F);
          localARTVirtualNode.markUpdateSeen();
        }
        if (this.mSurface == null)
          continue;
        this.mSurface.unlockCanvasAndPost(localCanvas);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        FLog.e("ReactNative", localIllegalArgumentException.getClass().getSimpleName() + " in Surface.unlockCanvasAndPost");
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        label125: break label125;
      }
    }
  }

  private void markChildrenUpdatesSeen(ReactShadowNode paramReactShadowNode)
  {
    for (int i = 0; i < paramReactShadowNode.getChildCount(); i++)
    {
      ReactShadowNode localReactShadowNode = paramReactShadowNode.getChildAt(i);
      localReactShadowNode.markUpdateSeen();
      markChildrenUpdatesSeen(localReactShadowNode);
    }
  }

  public boolean isVirtual()
  {
    return false;
  }

  public boolean isVirtualAnchor()
  {
    return true;
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    super.onCollectExtraUpdates(paramUIViewOperationQueue);
    drawOutput();
    paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), this);
  }

  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mSurface = new Surface(paramSurfaceTexture);
    drawOutput();
  }

  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture.release();
    this.mSurface = null;
    return true;
  }

  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
  }

  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
  }

  @ReactProp(customType="Color", name="backgroundColor")
  public void setBackgroundColor(Integer paramInteger)
  {
    this.mBackgroundColor = paramInteger;
    markUpdated();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTSurfaceViewShadowNode
 * JD-Core Version:    0.6.2
 */
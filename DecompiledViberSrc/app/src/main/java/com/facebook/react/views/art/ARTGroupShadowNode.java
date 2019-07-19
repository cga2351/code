package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ARTGroupShadowNode extends ARTVirtualNode
{

  @Nullable
  protected RectF mClipping;

  private static RectF createClipping(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 4)
      throw new JSApplicationIllegalArgumentException("Clipping should be array of length 4 (e.g. [x, y, width, height])");
    return new RectF(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[0] + paramArrayOfFloat[2], paramArrayOfFloat[1] + paramArrayOfFloat[3]);
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat)
  {
    float f = paramFloat * this.mOpacity;
    if (f > 0.01F)
    {
      saveAndSetupCanvas(paramCanvas);
      if (this.mClipping != null)
        paramCanvas.clipRect(this.mClipping.left * this.mScale, this.mClipping.top * this.mScale, this.mClipping.right * this.mScale, this.mClipping.bottom * this.mScale, Region.Op.REPLACE);
      for (int i = 0; i < getChildCount(); i++)
      {
        ARTVirtualNode localARTVirtualNode = (ARTVirtualNode)getChildAt(i);
        localARTVirtualNode.draw(paramCanvas, paramPaint, f);
        localARTVirtualNode.markUpdateSeen();
      }
      restoreCanvas(paramCanvas);
    }
  }

  public boolean isVirtual()
  {
    return true;
  }

  @ReactProp(name="clipping")
  public void setClipping(@Nullable ReadableArray paramReadableArray)
  {
    float[] arrayOfFloat = PropHelper.toFloatArray(paramReadableArray);
    if (arrayOfFloat != null)
    {
      this.mClipping = createClipping(arrayOfFloat);
      markUpdated();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTGroupShadowNode
 * JD-Core Version:    0.6.2
 */
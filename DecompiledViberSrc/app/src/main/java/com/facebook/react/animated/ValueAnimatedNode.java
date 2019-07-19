package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import javax.annotation.Nullable;

class ValueAnimatedNode extends AnimatedNode
{
  double mOffset = 0.0D;
  double mValue = (0.0D / 0.0D);

  @Nullable
  private AnimatedNodeValueListener mValueListener;

  public ValueAnimatedNode()
  {
  }

  public ValueAnimatedNode(ReadableMap paramReadableMap)
  {
    this.mValue = paramReadableMap.getDouble("value");
    this.mOffset = paramReadableMap.getDouble("offset");
  }

  public void extractOffset()
  {
    this.mOffset += this.mValue;
    this.mValue = 0.0D;
  }

  public void flattenOffset()
  {
    this.mValue += this.mOffset;
    this.mOffset = 0.0D;
  }

  public double getValue()
  {
    return this.mOffset + this.mValue;
  }

  public void onValueUpdate()
  {
    if (this.mValueListener == null)
      return;
    this.mValueListener.onValueUpdate(getValue());
  }

  public void setValueListener(@Nullable AnimatedNodeValueListener paramAnimatedNodeValueListener)
  {
    this.mValueListener = paramAnimatedNodeValueListener;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.ValueAnimatedNode
 * JD-Core Version:    0.6.2
 */
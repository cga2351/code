package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import javax.annotation.Nullable;

public class ImageLoadEvent extends Event<ImageLoadEvent>
{
  public static final int ON_ERROR = 1;
  public static final int ON_LOAD = 2;
  public static final int ON_LOAD_END = 3;
  public static final int ON_LOAD_START = 4;
  public static final int ON_PROGRESS = 5;
  private final int mEventType;
  private final int mHeight;

  @Nullable
  private final String mImageError;

  @Nullable
  private final String mImageUri;
  private final int mWidth;

  public ImageLoadEvent(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }

  public ImageLoadEvent(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, paramString, 0, 0, null);
  }

  public ImageLoadEvent(int paramInt1, int paramInt2, @Nullable String paramString, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramString, paramInt3, paramInt4, null);
  }

  public ImageLoadEvent(int paramInt1, int paramInt2, @Nullable String paramString1, int paramInt3, int paramInt4, @Nullable String paramString2)
  {
    super(paramInt1);
    this.mEventType = paramInt2;
    this.mImageUri = paramString1;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    this.mImageError = paramString2;
  }

  public ImageLoadEvent(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    this(paramInt1, paramInt2, null, 0, 0, paramString);
  }

  public static String eventNameForType(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalStateException("Invalid image event: " + Integer.toString(paramInt));
    case 1:
      return "topError";
    case 2:
      return "topLoad";
    case 3:
      return "topLoadEnd";
    case 4:
      return "topLoadStart";
    case 5:
    }
    return "topProgress";
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    WritableMap localWritableMap1;
    if ((this.mImageUri == null) && (this.mEventType != 2))
    {
      int i = this.mEventType;
      localWritableMap1 = null;
      if (i != 1);
    }
    else
    {
      localWritableMap1 = Arguments.createMap();
      if (this.mImageUri != null)
        localWritableMap1.putString("uri", this.mImageUri);
      if (this.mEventType != 2)
        break label134;
      WritableMap localWritableMap2 = Arguments.createMap();
      localWritableMap2.putDouble("width", this.mWidth);
      localWritableMap2.putDouble("height", this.mHeight);
      if (this.mImageUri != null)
        localWritableMap2.putString("url", this.mImageUri);
      localWritableMap1.putMap("source", localWritableMap2);
    }
    while (true)
    {
      paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), localWritableMap1);
      return;
      label134: if (this.mEventType == 1)
        localWritableMap1.putString("error", this.mImageError);
    }
  }

  public short getCoalescingKey()
  {
    return (short)this.mEventType;
  }

  public String getEventName()
  {
    return eventNameForType(this.mEventType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.ImageLoadEvent
 * JD-Core Version:    0.6.2
 */
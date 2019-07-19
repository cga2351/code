package com.facebook.react.fabric;

import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.Systrace;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class FabricEventEmitter
  implements RCTEventEmitter
{
  private static final String TAG = FabricEventEmitter.class.getSimpleName();
  private final FabricUIManager mUIManager;

  public FabricEventEmitter(FabricUIManager paramFabricUIManager)
  {
    this.mUIManager = paramFabricUIManager;
  }

  private WritableArray copyWritableArray(WritableArray paramWritableArray)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    for (int i = 0; i < paramWritableArray.size(); i++)
      localWritableNativeArray.pushMap(getWritableMap(paramWritableArray.getMap(i)));
    return localWritableNativeArray;
  }

  private WritableMap getWritableMap(ReadableMap paramReadableMap)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.merge(paramReadableMap);
    return localWritableNativeMap;
  }

  private Pair<WritableArray, WritableArray> removeTouchesAtIndices(WritableArray paramWritableArray1, WritableArray paramWritableArray2)
  {
    WritableNativeArray localWritableNativeArray1 = new WritableNativeArray();
    WritableNativeArray localWritableNativeArray2 = new WritableNativeArray();
    HashSet localHashSet = new HashSet();
    int k;
    for (int i = 0; ; i++)
    {
      int j = paramWritableArray2.size();
      k = 0;
      if (i >= j)
        break;
      int m = paramWritableArray2.getInt(i);
      localWritableNativeArray1.pushMap(getWritableMap(paramWritableArray1.getMap(m)));
      localHashSet.add(Integer.valueOf(m));
    }
    while (k < paramWritableArray1.size())
    {
      if (!localHashSet.contains(Integer.valueOf(k)))
        localWritableNativeArray2.pushMap(getWritableMap(paramWritableArray1.getMap(k)));
      k++;
    }
    return new Pair(localWritableNativeArray1, localWritableNativeArray2);
  }

  private Pair<WritableArray, WritableArray> touchSubsequence(WritableArray paramWritableArray1, WritableArray paramWritableArray2)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    for (int i = 0; i < paramWritableArray2.size(); i++)
      localWritableNativeArray.pushMap(getWritableMap(paramWritableArray1.getMap(paramWritableArray2.getInt(i))));
    return new Pair(localWritableNativeArray, paramWritableArray1);
  }

  public void receiveEvent(int paramInt, String paramString, @Nullable WritableMap paramWritableMap)
  {
    Systrace.beginSection(0L, "FabricEventEmitter.receiveEvent('" + paramString + "')");
    this.mUIManager.receiveEvent(paramInt, paramString, paramWritableMap);
    Systrace.endSection(0L);
  }

  public void receiveTouches(String paramString, WritableArray paramWritableArray1, WritableArray paramWritableArray2)
  {
    if (("topTouchEnd".equalsIgnoreCase(paramString)) || ("topTouchCancel".equalsIgnoreCase(paramString)));
    for (Pair localPair = removeTouchesAtIndices(paramWritableArray1, paramWritableArray2); ; localPair = touchSubsequence(paramWritableArray1, paramWritableArray2))
    {
      WritableArray localWritableArray1 = (WritableArray)localPair.first;
      WritableArray localWritableArray2 = (WritableArray)localPair.second;
      for (int i = 0; i < localWritableArray1.size(); i++)
      {
        WritableMap localWritableMap = getWritableMap(localWritableArray1.getMap(i));
        localWritableMap.putArray("changedTouches", copyWritableArray(localWritableArray1));
        localWritableMap.putArray("touches", copyWritableArray(localWritableArray2));
        int j = localWritableMap.getInt("target");
        if (j < 1)
        {
          FLog.e(TAG, "A view is reporting that a touch occurred on tag zero.");
          j = 0;
        }
        receiveEvent(j, paramString, localWritableMap);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.FabricEventEmitter
 * JD-Core Version:    0.6.2
 */
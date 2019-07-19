package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TransformAnimatedNode extends AnimatedNode
{
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final List<TransformConfig> mTransformConfigs;

  TransformAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    ReadableArray localReadableArray = paramReadableMap.getArray("transforms");
    this.mTransformConfigs = new ArrayList(localReadableArray.size());
    int i = 0;
    if (i < localReadableArray.size())
    {
      ReadableMap localReadableMap = localReadableArray.getMap(i);
      String str = localReadableMap.getString("property");
      if (localReadableMap.getString("type").equals("animated"))
      {
        AnimatedTransformConfig localAnimatedTransformConfig = new AnimatedTransformConfig(null);
        localAnimatedTransformConfig.mProperty = str;
        localAnimatedTransformConfig.mNodeTag = localReadableMap.getInt("nodeTag");
        this.mTransformConfigs.add(localAnimatedTransformConfig);
      }
      while (true)
      {
        i++;
        break;
        StaticTransformConfig localStaticTransformConfig = new StaticTransformConfig(null);
        localStaticTransformConfig.mProperty = str;
        localStaticTransformConfig.mValue = localReadableMap.getDouble("value");
        this.mTransformConfigs.add(localStaticTransformConfig);
      }
    }
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
  }

  public void collectViewUpdates(JavaOnlyMap paramJavaOnlyMap)
  {
    ArrayList localArrayList = new ArrayList(this.mTransformConfigs.size());
    Iterator localIterator = this.mTransformConfigs.iterator();
    if (localIterator.hasNext())
    {
      TransformConfig localTransformConfig = (TransformConfig)localIterator.next();
      AnimatedNode localAnimatedNode;
      if ((localTransformConfig instanceof AnimatedTransformConfig))
      {
        int i = ((AnimatedTransformConfig)localTransformConfig).mNodeTag;
        localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(i);
        if (localAnimatedNode == null)
          throw new IllegalArgumentException("Mapped style node does not exists");
        if (!(localAnimatedNode instanceof ValueAnimatedNode));
      }
      for (double d = ((ValueAnimatedNode)localAnimatedNode).getValue(); ; d = ((StaticTransformConfig)localTransformConfig).mValue)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localTransformConfig.mProperty;
        arrayOfObject[1] = Double.valueOf(d);
        localArrayList.add(JavaOnlyMap.of(arrayOfObject));
        break;
        throw new IllegalArgumentException("Unsupported type of node used as a transform child node " + localAnimatedNode.getClass());
      }
    }
    paramJavaOnlyMap.putArray("transform", JavaOnlyArray.from(localArrayList));
  }

  private class AnimatedTransformConfig extends TransformAnimatedNode.TransformConfig
  {
    public int mNodeTag;

    private AnimatedTransformConfig()
    {
      super(null);
    }
  }

  private class StaticTransformConfig extends TransformAnimatedNode.TransformConfig
  {
    public double mValue;

    private StaticTransformConfig()
    {
      super(null);
    }
  }

  private class TransformConfig
  {
    public String mProperty;

    private TransformConfig()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.TransformAnimatedNode
 * JD-Core Version:    0.6.2
 */
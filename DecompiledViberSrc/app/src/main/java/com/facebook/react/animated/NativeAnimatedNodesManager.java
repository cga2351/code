package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import javax.annotation.Nullable;

class NativeAnimatedNodesManager
  implements EventDispatcherListener
{
  private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray();
  private int mAnimatedGraphBFSColor = 0;
  private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray();
  private final UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
  private final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
  private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
  private final UIImplementation mUIImplementation;
  private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray();

  public NativeAnimatedNodesManager(UIManagerModule paramUIManagerModule)
  {
    this.mUIImplementation = paramUIManagerModule.getUIImplementation();
    paramUIManagerModule.getEventDispatcher().addListener(this);
    this.mCustomEventNamesResolver = paramUIManagerModule.getDirectEventNamesResolver();
  }

  private void handleEvent(Event paramEvent)
  {
    if (!this.mEventDrivers.isEmpty())
    {
      String str = this.mCustomEventNamesResolver.resolveCustomEventName(paramEvent.getEventName());
      List localList = (List)this.mEventDrivers.get(paramEvent.getViewTag() + str);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          EventAnimationDriver localEventAnimationDriver = (EventAnimationDriver)localIterator.next();
          stopAnimationsForNode(localEventAnimationDriver.mValueNode);
          paramEvent.dispatch(localEventAnimationDriver);
          this.mRunUpdateNodeList.add(localEventAnimationDriver.mValueNode);
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
      }
    }
  }

  private void stopAnimationsForNode(AnimatedNode paramAnimatedNode)
  {
    for (int i = 0; i < this.mActiveAnimations.size(); i++)
    {
      AnimationDriver localAnimationDriver = (AnimationDriver)this.mActiveAnimations.valueAt(i);
      if (paramAnimatedNode.equals(localAnimationDriver.mAnimatedValue))
      {
        if (localAnimationDriver.mEndCallback != null)
        {
          WritableMap localWritableMap = Arguments.createMap();
          localWritableMap.putBoolean("finished", false);
          localAnimationDriver.mEndCallback.invoke(new Object[] { localWritableMap });
        }
        this.mActiveAnimations.removeAt(i);
        i--;
      }
    }
  }

  private void updateNodes(List<AnimatedNode> paramList)
  {
    this.mAnimatedGraphBFSColor = (1 + this.mAnimatedGraphBFSColor);
    if (this.mAnimatedGraphBFSColor == 0)
      this.mAnimatedGraphBFSColor = (1 + this.mAnimatedGraphBFSColor);
    ArrayDeque localArrayDeque = new ArrayDeque();
    Iterator localIterator1 = paramList.iterator();
    int i = 0;
    int i2;
    while (localIterator1.hasNext())
    {
      AnimatedNode localAnimatedNode6 = (AnimatedNode)localIterator1.next();
      if (localAnimatedNode6.mBFSColor != this.mAnimatedGraphBFSColor)
      {
        localAnimatedNode6.mBFSColor = this.mAnimatedGraphBFSColor;
        i++;
        localArrayDeque.add(localAnimatedNode6);
      }
      continue;
      i2 = j;
    }
    label105: for (int j = i2; ; j = i)
    {
      if (!localArrayDeque.isEmpty())
      {
        AnimatedNode localAnimatedNode4 = (AnimatedNode)localArrayDeque.poll();
        if (localAnimatedNode4.mChildren == null)
          break;
        i2 = j;
        for (int i3 = 0; i3 < localAnimatedNode4.mChildren.size(); i3++)
        {
          AnimatedNode localAnimatedNode5 = (AnimatedNode)localAnimatedNode4.mChildren.get(i3);
          localAnimatedNode5.mActiveIncomingNodes = (1 + localAnimatedNode5.mActiveIncomingNodes);
          if (localAnimatedNode5.mBFSColor != this.mAnimatedGraphBFSColor)
          {
            localAnimatedNode5.mBFSColor = this.mAnimatedGraphBFSColor;
            i2++;
            localArrayDeque.add(localAnimatedNode5);
          }
        }
        break label105;
      }
      this.mAnimatedGraphBFSColor = (1 + this.mAnimatedGraphBFSColor);
      if (this.mAnimatedGraphBFSColor == 0)
        this.mAnimatedGraphBFSColor = (1 + this.mAnimatedGraphBFSColor);
      Iterator localIterator2 = paramList.iterator();
      int k = 0;
      int n;
      while (localIterator2.hasNext())
      {
        AnimatedNode localAnimatedNode3 = (AnimatedNode)localIterator2.next();
        if ((localAnimatedNode3.mActiveIncomingNodes == 0) && (localAnimatedNode3.mBFSColor != this.mAnimatedGraphBFSColor))
        {
          localAnimatedNode3.mBFSColor = this.mAnimatedGraphBFSColor;
          k++;
          localArrayDeque.add(localAnimatedNode3);
        }
        continue;
        n = m;
      }
      for (int m = n; ; m = k)
      {
        while (true)
          if (!localArrayDeque.isEmpty())
          {
            AnimatedNode localAnimatedNode1 = (AnimatedNode)localArrayDeque.poll();
            localAnimatedNode1.update();
            if ((localAnimatedNode1 instanceof PropsAnimatedNode));
            try
            {
              ((PropsAnimatedNode)localAnimatedNode1).updateView();
              if ((localAnimatedNode1 instanceof ValueAnimatedNode))
                ((ValueAnimatedNode)localAnimatedNode1).onValueUpdate();
              if (localAnimatedNode1.mChildren == null)
                break;
              n = m;
              for (int i1 = 0; i1 < localAnimatedNode1.mChildren.size(); i1++)
              {
                AnimatedNode localAnimatedNode2 = (AnimatedNode)localAnimatedNode1.mChildren.get(i1);
                localAnimatedNode2.mActiveIncomingNodes = (-1 + localAnimatedNode2.mActiveIncomingNodes);
                if ((localAnimatedNode2.mBFSColor != this.mAnimatedGraphBFSColor) && (localAnimatedNode2.mActiveIncomingNodes == 0))
                {
                  localAnimatedNode2.mBFSColor = this.mAnimatedGraphBFSColor;
                  n++;
                  localArrayDeque.add(localAnimatedNode2);
                }
              }
            }
            catch (IllegalViewOperationException localIllegalViewOperationException)
            {
              while (true)
                FLog.e("ReactNative", "Native animation workaround, frame lost as result of race condition", localIllegalViewOperationException);
            }
          }
        if (j != m)
          throw new IllegalStateException("Looks like animated nodes graph has cycles, there are " + j + " but toposort visited only " + m);
        return;
      }
    }
  }

  public void addAnimatedEventToView(int paramInt, String paramString, ReadableMap paramReadableMap)
  {
    int i = paramReadableMap.getInt("animatedValueTag");
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(i);
    if (localAnimatedNode == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
    if (!(localAnimatedNode instanceof ValueAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node connected to event should beof type " + ValueAnimatedNode.class.getName());
    ReadableArray localReadableArray = paramReadableMap.getArray("nativeEventPath");
    ArrayList localArrayList1 = new ArrayList(localReadableArray.size());
    for (int j = 0; j < localReadableArray.size(); j++)
      localArrayList1.add(localReadableArray.getString(j));
    EventAnimationDriver localEventAnimationDriver = new EventAnimationDriver(localArrayList1, (ValueAnimatedNode)localAnimatedNode);
    String str = paramInt + paramString;
    if (this.mEventDrivers.containsKey(str))
    {
      ((List)this.mEventDrivers.get(str)).add(localEventAnimationDriver);
      return;
    }
    ArrayList localArrayList2 = new ArrayList(1);
    localArrayList2.add(localEventAnimationDriver);
    this.mEventDrivers.put(str, localArrayList2);
  }

  public void connectAnimatedNodeToView(int paramInt1, int paramInt2)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localAnimatedNode == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt1 + " does not exists");
    if (!(localAnimatedNode instanceof PropsAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
    ((PropsAnimatedNode)localAnimatedNode).connectToView(paramInt2);
    this.mUpdatedNodes.put(paramInt1, localAnimatedNode);
  }

  public void connectAnimatedNodes(int paramInt1, int paramInt2)
  {
    AnimatedNode localAnimatedNode1 = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localAnimatedNode1 == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt1 + " does not exists");
    AnimatedNode localAnimatedNode2 = (AnimatedNode)this.mAnimatedNodes.get(paramInt2);
    if (localAnimatedNode2 == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt2 + " does not exists");
    localAnimatedNode1.addChild(localAnimatedNode2);
    this.mUpdatedNodes.put(paramInt2, localAnimatedNode2);
  }

  public void createAnimatedNode(int paramInt, ReadableMap paramReadableMap)
  {
    if (this.mAnimatedNodes.get(paramInt) != null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " already exists");
    String str = paramReadableMap.getString("type");
    Object localObject;
    if ("style".equals(str))
      localObject = new StyleAnimatedNode(paramReadableMap, this);
    while (true)
    {
      ((AnimatedNode)localObject).mTag = paramInt;
      this.mAnimatedNodes.put(paramInt, localObject);
      this.mUpdatedNodes.put(paramInt, localObject);
      return;
      if ("value".equals(str))
      {
        localObject = new ValueAnimatedNode(paramReadableMap);
      }
      else if ("props".equals(str))
      {
        localObject = new PropsAnimatedNode(paramReadableMap, this, this.mUIImplementation);
      }
      else if ("interpolation".equals(str))
      {
        localObject = new InterpolationAnimatedNode(paramReadableMap);
      }
      else if ("addition".equals(str))
      {
        localObject = new AdditionAnimatedNode(paramReadableMap, this);
      }
      else if ("subtraction".equals(str))
      {
        localObject = new SubtractionAnimatedNode(paramReadableMap, this);
      }
      else if ("division".equals(str))
      {
        localObject = new DivisionAnimatedNode(paramReadableMap, this);
      }
      else if ("multiplication".equals(str))
      {
        localObject = new MultiplicationAnimatedNode(paramReadableMap, this);
      }
      else if ("modulus".equals(str))
      {
        localObject = new ModulusAnimatedNode(paramReadableMap, this);
      }
      else if ("diffclamp".equals(str))
      {
        localObject = new DiffClampAnimatedNode(paramReadableMap, this);
      }
      else if ("transform".equals(str))
      {
        localObject = new TransformAnimatedNode(paramReadableMap, this);
      }
      else
      {
        if (!"tracking".equals(str))
          break;
        localObject = new TrackingAnimatedNode(paramReadableMap, this);
      }
    }
    throw new JSApplicationIllegalArgumentException("Unsupported node type: " + str);
  }

  public void disconnectAnimatedNodeFromView(int paramInt1, int paramInt2)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localAnimatedNode == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt1 + " does not exists");
    if (!(localAnimatedNode instanceof PropsAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
    ((PropsAnimatedNode)localAnimatedNode).disconnectFromView(paramInt2);
  }

  public void disconnectAnimatedNodes(int paramInt1, int paramInt2)
  {
    AnimatedNode localAnimatedNode1 = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localAnimatedNode1 == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt1 + " does not exists");
    AnimatedNode localAnimatedNode2 = (AnimatedNode)this.mAnimatedNodes.get(paramInt2);
    if (localAnimatedNode2 == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt2 + " does not exists");
    localAnimatedNode1.removeChild(localAnimatedNode2);
    this.mUpdatedNodes.put(paramInt2, localAnimatedNode2);
  }

  public void dropAnimatedNode(int paramInt)
  {
    this.mAnimatedNodes.remove(paramInt);
    this.mUpdatedNodes.remove(paramInt);
  }

  public void extractAnimatedNodeOffset(int paramInt)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).extractOffset();
  }

  public void flattenAnimatedNodeOffset(int paramInt)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).flattenOffset();
  }

  @Nullable
  AnimatedNode getNodeById(int paramInt)
  {
    return (AnimatedNode)this.mAnimatedNodes.get(paramInt);
  }

  public boolean hasActiveAnimations()
  {
    return (this.mActiveAnimations.size() > 0) || (this.mUpdatedNodes.size() > 0);
  }

  public void onEventDispatch(final Event paramEvent)
  {
    if (UiThreadUtil.isOnUiThread())
    {
      handleEvent(paramEvent);
      return;
    }
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        NativeAnimatedNodesManager.this.handleEvent(paramEvent);
      }
    });
  }

  public void removeAnimatedEventFromView(int paramInt1, String paramString, int paramInt2)
  {
    String str = paramInt1 + paramString;
    List localList;
    if (this.mEventDrivers.containsKey(str))
    {
      localList = (List)this.mEventDrivers.get(str);
      if (localList.size() != 1)
        break label90;
    }
    label90: ListIterator localListIterator;
    do
    {
      this.mEventDrivers.remove(paramInt1 + paramString);
      return;
      while (!localListIterator.hasNext())
        localListIterator = localList.listIterator();
    }
    while (((EventAnimationDriver)localListIterator.next()).mValueNode.mTag != paramInt2);
    localListIterator.remove();
  }

  public void restoreDefaultValues(int paramInt1, int paramInt2)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localAnimatedNode == null)
      return;
    if (!(localAnimatedNode instanceof PropsAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
    ((PropsAnimatedNode)localAnimatedNode).restoreDefaultValues();
  }

  public void runUpdates(long paramLong)
  {
    UiThreadUtil.assertOnUiThread();
    for (int i = 0; i < this.mUpdatedNodes.size(); i++)
    {
      AnimatedNode localAnimatedNode = (AnimatedNode)this.mUpdatedNodes.valueAt(i);
      this.mRunUpdateNodeList.add(localAnimatedNode);
    }
    this.mUpdatedNodes.clear();
    int j = 0;
    int k = 0;
    while (j < this.mActiveAnimations.size())
    {
      AnimationDriver localAnimationDriver2 = (AnimationDriver)this.mActiveAnimations.valueAt(j);
      localAnimationDriver2.runAnimationStep(paramLong);
      ValueAnimatedNode localValueAnimatedNode = localAnimationDriver2.mAnimatedValue;
      this.mRunUpdateNodeList.add(localValueAnimatedNode);
      if (localAnimationDriver2.mHasFinished)
        k = 1;
      j++;
    }
    updateNodes(this.mRunUpdateNodeList);
    this.mRunUpdateNodeList.clear();
    if (k != 0)
      for (int m = -1 + this.mActiveAnimations.size(); m >= 0; m--)
      {
        AnimationDriver localAnimationDriver1 = (AnimationDriver)this.mActiveAnimations.valueAt(m);
        if (localAnimationDriver1.mHasFinished)
        {
          if (localAnimationDriver1.mEndCallback != null)
          {
            WritableMap localWritableMap = Arguments.createMap();
            localWritableMap.putBoolean("finished", true);
            localAnimationDriver1.mEndCallback.invoke(new Object[] { localWritableMap });
          }
          this.mActiveAnimations.removeAt(m);
        }
      }
  }

  public void setAnimatedNodeOffset(int paramInt, double paramDouble)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).mOffset = paramDouble;
    this.mUpdatedNodes.put(paramInt, localAnimatedNode);
  }

  public void setAnimatedNodeValue(int paramInt, double paramDouble)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    stopAnimationsForNode(localAnimatedNode);
    ((ValueAnimatedNode)localAnimatedNode).mValue = paramDouble;
    this.mUpdatedNodes.put(paramInt, localAnimatedNode);
  }

  public void startAnimatingNode(int paramInt1, int paramInt2, ReadableMap paramReadableMap, Callback paramCallback)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt2);
    if (localAnimatedNode == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt2 + " does not exists");
    if (!(localAnimatedNode instanceof ValueAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node should be of type " + ValueAnimatedNode.class.getName());
    AnimationDriver localAnimationDriver = (AnimationDriver)this.mActiveAnimations.get(paramInt1);
    if (localAnimationDriver != null)
    {
      localAnimationDriver.resetConfig(paramReadableMap);
      return;
    }
    String str = paramReadableMap.getString("type");
    Object localObject;
    if ("frames".equals(str))
      localObject = new FrameBasedAnimationDriver(paramReadableMap);
    while (true)
    {
      ((AnimationDriver)localObject).mId = paramInt1;
      ((AnimationDriver)localObject).mEndCallback = paramCallback;
      ((AnimationDriver)localObject).mAnimatedValue = ((ValueAnimatedNode)localAnimatedNode);
      this.mActiveAnimations.put(paramInt1, localObject);
      return;
      if ("spring".equals(str))
      {
        localObject = new SpringAnimation(paramReadableMap);
      }
      else
      {
        if (!"decay".equals(str))
          break;
        localObject = new DecayAnimation(paramReadableMap);
      }
    }
    throw new JSApplicationIllegalArgumentException("Unsupported animation type: " + str);
  }

  public void startListeningToAnimatedNodeValue(int paramInt, AnimatedNodeValueListener paramAnimatedNodeValueListener)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).setValueListener(paramAnimatedNodeValueListener);
  }

  public void stopAnimation(int paramInt)
  {
    for (int i = 0; ; i++)
      if (i < this.mActiveAnimations.size())
      {
        AnimationDriver localAnimationDriver = (AnimationDriver)this.mActiveAnimations.valueAt(i);
        if (localAnimationDriver.mId == paramInt)
        {
          if (localAnimationDriver.mEndCallback != null)
          {
            WritableMap localWritableMap = Arguments.createMap();
            localWritableMap.putBoolean("finished", false);
            localAnimationDriver.mEndCallback.invoke(new Object[] { localWritableMap });
          }
          this.mActiveAnimations.removeAt(i);
        }
      }
      else
      {
        return;
      }
  }

  public void stopListeningToAnimatedNodeValue(int paramInt)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).setValueListener(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.NativeAnimatedNodesManager
 * JD-Core Version:    0.6.2
 */
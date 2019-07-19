package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class ViewManagersPropertyCache
{
  private static final Map<Class, Map<String, PropSetter>> CLASS_PROPS_CACHE = new HashMap();
  private static final Map<String, PropSetter> EMPTY_PROPS_MAP = new HashMap();

  public static void clear()
  {
    CLASS_PROPS_CACHE.clear();
    EMPTY_PROPS_MAP.clear();
  }

  private static PropSetter createPropSetter(ReactProp paramReactProp, Method paramMethod, Class<?> paramClass)
  {
    if (paramClass == Dynamic.class)
      return new DynamicPropSetter(paramReactProp, paramMethod);
    if (paramClass == Boolean.TYPE)
      return new BooleanPropSetter(paramReactProp, paramMethod, paramReactProp.defaultBoolean());
    if (paramClass == Integer.TYPE)
      return new IntPropSetter(paramReactProp, paramMethod, paramReactProp.defaultInt());
    if (paramClass == Float.TYPE)
      return new FloatPropSetter(paramReactProp, paramMethod, paramReactProp.defaultFloat());
    if (paramClass == Double.TYPE)
      return new DoublePropSetter(paramReactProp, paramMethod, paramReactProp.defaultDouble());
    if (paramClass == String.class)
      return new StringPropSetter(paramReactProp, paramMethod);
    if (paramClass == Boolean.class)
      return new BoxedBooleanPropSetter(paramReactProp, paramMethod);
    if (paramClass == Integer.class)
      return new BoxedIntPropSetter(paramReactProp, paramMethod);
    if (paramClass == ReadableArray.class)
      return new ArrayPropSetter(paramReactProp, paramMethod);
    if (paramClass == ReadableMap.class)
      return new MapPropSetter(paramReactProp, paramMethod);
    throw new RuntimeException("Unrecognized type: " + paramClass + " for method: " + paramMethod.getDeclaringClass().getName() + "#" + paramMethod.getName());
  }

  private static void createPropSetters(ReactPropGroup paramReactPropGroup, Method paramMethod, Class<?> paramClass, Map<String, PropSetter> paramMap)
  {
    String[] arrayOfString = paramReactPropGroup.names();
    int i = 0;
    if (paramClass == Dynamic.class)
      while (i < arrayOfString.length)
      {
        paramMap.put(arrayOfString[i], new DynamicPropSetter(paramReactPropGroup, paramMethod, i));
        i++;
      }
    Class localClass1 = Integer.TYPE;
    int j = 0;
    if (paramClass == localClass1)
      while (j < arrayOfString.length)
      {
        paramMap.put(arrayOfString[j], new IntPropSetter(paramReactPropGroup, paramMethod, j, paramReactPropGroup.defaultInt()));
        j++;
      }
    Class localClass2 = Float.TYPE;
    int k = 0;
    if (paramClass == localClass2)
      while (k < arrayOfString.length)
      {
        paramMap.put(arrayOfString[k], new FloatPropSetter(paramReactPropGroup, paramMethod, k, paramReactPropGroup.defaultFloat()));
        k++;
      }
    if (paramClass == Double.TYPE)
      for (int n = 0; n < arrayOfString.length; n++)
        paramMap.put(arrayOfString[n], new DoublePropSetter(paramReactPropGroup, paramMethod, n, paramReactPropGroup.defaultDouble()));
    int m = 0;
    if (paramClass == Integer.class)
      while (m < arrayOfString.length)
      {
        paramMap.put(arrayOfString[m], new BoxedIntPropSetter(paramReactPropGroup, paramMethod, m));
        m++;
      }
    throw new RuntimeException("Unrecognized type: " + paramClass + " for method: " + paramMethod.getDeclaringClass().getName() + "#" + paramMethod.getName());
  }

  private static void extractPropSettersFromShadowNodeClassDefinition(Class<? extends ReactShadowNode> paramClass, Map<String, PropSetter> paramMap)
  {
    for (Method localMethod : paramClass.getDeclaredMethods())
    {
      ReactProp localReactProp = (ReactProp)localMethod.getAnnotation(ReactProp.class);
      if (localReactProp != null)
      {
        Class[] arrayOfClass2 = localMethod.getParameterTypes();
        if (arrayOfClass2.length != 1)
          throw new RuntimeException("Wrong number of args for prop setter: " + paramClass.getName() + "#" + localMethod.getName());
        paramMap.put(localReactProp.name(), createPropSetter(localReactProp, localMethod, arrayOfClass2[0]));
      }
      ReactPropGroup localReactPropGroup = (ReactPropGroup)localMethod.getAnnotation(ReactPropGroup.class);
      if (localReactPropGroup != null)
      {
        Class[] arrayOfClass1 = localMethod.getParameterTypes();
        if (arrayOfClass1.length != 2)
          throw new RuntimeException("Wrong number of args for group prop setter: " + paramClass.getName() + "#" + localMethod.getName());
        if (arrayOfClass1[0] != Integer.TYPE)
          throw new RuntimeException("Second argument should be property index: " + paramClass.getName() + "#" + localMethod.getName());
        createPropSetters(localReactPropGroup, localMethod, arrayOfClass1[1], paramMap);
      }
    }
  }

  private static void extractPropSettersFromViewManagerClassDefinition(Class<? extends ViewManager> paramClass, Map<String, PropSetter> paramMap)
  {
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    for (int i = 0; i < arrayOfMethod.length; i++)
    {
      Method localMethod = arrayOfMethod[i];
      ReactProp localReactProp = (ReactProp)localMethod.getAnnotation(ReactProp.class);
      if (localReactProp != null)
      {
        Class[] arrayOfClass2 = localMethod.getParameterTypes();
        if (arrayOfClass2.length != 2)
          throw new RuntimeException("Wrong number of args for prop setter: " + paramClass.getName() + "#" + localMethod.getName());
        if (!View.class.isAssignableFrom(arrayOfClass2[0]))
          throw new RuntimeException("First param should be a view subclass to be updated: " + paramClass.getName() + "#" + localMethod.getName());
        paramMap.put(localReactProp.name(), createPropSetter(localReactProp, localMethod, arrayOfClass2[1]));
      }
      ReactPropGroup localReactPropGroup = (ReactPropGroup)localMethod.getAnnotation(ReactPropGroup.class);
      if (localReactPropGroup != null)
      {
        Class[] arrayOfClass1 = localMethod.getParameterTypes();
        if (arrayOfClass1.length != 3)
          throw new RuntimeException("Wrong number of args for group prop setter: " + paramClass.getName() + "#" + localMethod.getName());
        if (!View.class.isAssignableFrom(arrayOfClass1[0]))
          throw new RuntimeException("First param should be a view subclass to be updated: " + paramClass.getName() + "#" + localMethod.getName());
        if (arrayOfClass1[1] != Integer.TYPE)
          throw new RuntimeException("Second argument should be property index: " + paramClass.getName() + "#" + localMethod.getName());
        createPropSetters(localReactPropGroup, localMethod, arrayOfClass1[2], paramMap);
      }
    }
  }

  static Map<String, PropSetter> getNativePropSettersForShadowNodeClass(Class<? extends ReactShadowNode> paramClass)
  {
    Class[] arrayOfClass = paramClass.getInterfaces();
    int i = arrayOfClass.length;
    int j = 0;
    Map localMap;
    if (j < i)
      if (arrayOfClass[j] == ReactShadowNode.class)
        localMap = EMPTY_PROPS_MAP;
    do
    {
      return localMap;
      j++;
      break;
      localMap = (Map)CLASS_PROPS_CACHE.get(paramClass);
    }
    while (localMap != null);
    HashMap localHashMap = new HashMap(getNativePropSettersForShadowNodeClass(paramClass.getSuperclass()));
    extractPropSettersFromShadowNodeClassDefinition(paramClass, localHashMap);
    CLASS_PROPS_CACHE.put(paramClass, localHashMap);
    return localHashMap;
  }

  static Map<String, PropSetter> getNativePropSettersForViewManagerClass(Class<? extends ViewManager> paramClass)
  {
    Map localMap;
    if (paramClass == ViewManager.class)
      localMap = EMPTY_PROPS_MAP;
    do
    {
      return localMap;
      localMap = (Map)CLASS_PROPS_CACHE.get(paramClass);
    }
    while (localMap != null);
    HashMap localHashMap = new HashMap(getNativePropSettersForViewManagerClass(paramClass.getSuperclass()));
    extractPropSettersFromViewManagerClassDefinition(paramClass, localHashMap);
    CLASS_PROPS_CACHE.put(paramClass, localHashMap);
    return localHashMap;
  }

  static Map<String, String> getNativePropsForView(Class<? extends ViewManager> paramClass, Class<? extends ReactShadowNode> paramClass1)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = getNativePropSettersForViewManagerClass(paramClass).values().iterator();
    while (localIterator1.hasNext())
    {
      PropSetter localPropSetter2 = (PropSetter)localIterator1.next();
      localHashMap.put(localPropSetter2.getPropName(), localPropSetter2.getPropType());
    }
    Iterator localIterator2 = getNativePropSettersForShadowNodeClass(paramClass1).values().iterator();
    while (localIterator2.hasNext())
    {
      PropSetter localPropSetter1 = (PropSetter)localIterator2.next();
      localHashMap.put(localPropSetter1.getPropName(), localPropSetter1.getPropType());
    }
    return localHashMap;
  }

  private static class ArrayPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    public ArrayPropSetter(ReactProp paramReactProp, Method paramMethod)
    {
      super("Array", paramMethod, null);
    }

    @Nullable
    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      return paramReactStylesDiffMap.getArray(this.mPropName);
    }
  }

  private static class BooleanPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    private final boolean mDefaultValue;

    public BooleanPropSetter(ReactProp paramReactProp, Method paramMethod, boolean paramBoolean)
    {
      super("boolean", paramMethod, null);
      this.mDefaultValue = paramBoolean;
    }

    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      if (paramReactStylesDiffMap.getBoolean(this.mPropName, this.mDefaultValue))
        return Boolean.TRUE;
      return Boolean.FALSE;
    }
  }

  private static class BoxedBooleanPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    public BoxedBooleanPropSetter(ReactProp paramReactProp, Method paramMethod)
    {
      super("boolean", paramMethod, null);
    }

    @Nullable
    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      if (!paramReactStylesDiffMap.isNull(this.mPropName))
      {
        if (paramReactStylesDiffMap.getBoolean(this.mPropName, false))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return null;
    }
  }

  private static class BoxedIntPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    public BoxedIntPropSetter(ReactProp paramReactProp, Method paramMethod)
    {
      super("number", paramMethod, null);
    }

    public BoxedIntPropSetter(ReactPropGroup paramReactPropGroup, Method paramMethod, int paramInt)
    {
      super("number", paramMethod, paramInt, null);
    }

    @Nullable
    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      if (!paramReactStylesDiffMap.isNull(this.mPropName))
        return Integer.valueOf(paramReactStylesDiffMap.getInt(this.mPropName, 0));
      return null;
    }
  }

  private static class DoublePropSetter extends ViewManagersPropertyCache.PropSetter
  {
    private final double mDefaultValue;

    public DoublePropSetter(ReactProp paramReactProp, Method paramMethod, double paramDouble)
    {
      super("number", paramMethod, null);
      this.mDefaultValue = paramDouble;
    }

    public DoublePropSetter(ReactPropGroup paramReactPropGroup, Method paramMethod, int paramInt, double paramDouble)
    {
      super("number", paramMethod, paramInt, null);
      this.mDefaultValue = paramDouble;
    }

    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      return Double.valueOf(paramReactStylesDiffMap.getDouble(this.mPropName, this.mDefaultValue));
    }
  }

  private static class DynamicPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    public DynamicPropSetter(ReactProp paramReactProp, Method paramMethod)
    {
      super("mixed", paramMethod, null);
    }

    public DynamicPropSetter(ReactPropGroup paramReactPropGroup, Method paramMethod, int paramInt)
    {
      super("mixed", paramMethod, paramInt, null);
    }

    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      return paramReactStylesDiffMap.getDynamic(this.mPropName);
    }
  }

  private static class FloatPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    private final float mDefaultValue;

    public FloatPropSetter(ReactProp paramReactProp, Method paramMethod, float paramFloat)
    {
      super("number", paramMethod, null);
      this.mDefaultValue = paramFloat;
    }

    public FloatPropSetter(ReactPropGroup paramReactPropGroup, Method paramMethod, int paramInt, float paramFloat)
    {
      super("number", paramMethod, paramInt, null);
      this.mDefaultValue = paramFloat;
    }

    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      return Float.valueOf(paramReactStylesDiffMap.getFloat(this.mPropName, this.mDefaultValue));
    }
  }

  private static class IntPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    private final int mDefaultValue;

    public IntPropSetter(ReactProp paramReactProp, Method paramMethod, int paramInt)
    {
      super("number", paramMethod, null);
      this.mDefaultValue = paramInt;
    }

    public IntPropSetter(ReactPropGroup paramReactPropGroup, Method paramMethod, int paramInt1, int paramInt2)
    {
      super("number", paramMethod, paramInt1, null);
      this.mDefaultValue = paramInt2;
    }

    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      return Integer.valueOf(paramReactStylesDiffMap.getInt(this.mPropName, this.mDefaultValue));
    }
  }

  private static class MapPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    public MapPropSetter(ReactProp paramReactProp, Method paramMethod)
    {
      super("Map", paramMethod, null);
    }

    @Nullable
    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      return paramReactStylesDiffMap.getMap(this.mPropName);
    }
  }

  static abstract class PropSetter
  {
    private static final Object[] SHADOW_ARGS = new Object[1];
    private static final Object[] SHADOW_GROUP_ARGS = new Object[2];
    private static final Object[] VIEW_MGR_ARGS = new Object[2];
    private static final Object[] VIEW_MGR_GROUP_ARGS = new Object[3];

    @Nullable
    protected final Integer mIndex;
    protected final String mPropName;
    protected final String mPropType;
    protected final Method mSetter;

    private PropSetter(ReactProp paramReactProp, String paramString, Method paramMethod)
    {
      this.mPropName = paramReactProp.name();
      if ("__default_type__".equals(paramReactProp.customType()));
      while (true)
      {
        this.mPropType = paramString;
        this.mSetter = paramMethod;
        this.mIndex = null;
        return;
        paramString = paramReactProp.customType();
      }
    }

    private PropSetter(ReactPropGroup paramReactPropGroup, String paramString, Method paramMethod, int paramInt)
    {
      this.mPropName = paramReactPropGroup.names()[paramInt];
      if ("__default_type__".equals(paramReactPropGroup.customType()));
      while (true)
      {
        this.mPropType = paramString;
        this.mSetter = paramMethod;
        this.mIndex = Integer.valueOf(paramInt);
        return;
        paramString = paramReactPropGroup.customType();
      }
    }

    @Nullable
    protected abstract Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap);

    public String getPropName()
    {
      return this.mPropName;
    }

    public String getPropType()
    {
      return this.mPropType;
    }

    public void updateShadowNodeProp(ReactShadowNode paramReactShadowNode, ReactStylesDiffMap paramReactStylesDiffMap)
    {
      try
      {
        if (this.mIndex == null)
        {
          SHADOW_ARGS[0] = extractProperty(paramReactStylesDiffMap);
          this.mSetter.invoke(paramReactShadowNode, SHADOW_ARGS);
          Arrays.fill(SHADOW_ARGS, null);
          return;
        }
        SHADOW_GROUP_ARGS[0] = this.mIndex;
        SHADOW_GROUP_ARGS[1] = extractProperty(paramReactStylesDiffMap);
        this.mSetter.invoke(paramReactShadowNode, SHADOW_GROUP_ARGS);
        Arrays.fill(SHADOW_GROUP_ARGS, null);
        return;
      }
      catch (Throwable localThrowable)
      {
        FLog.e(ViewManager.class, "Error while updating prop " + this.mPropName, localThrowable);
        throw new JSApplicationIllegalArgumentException("Error while updating property '" + this.mPropName + "' in shadow node of type: " + paramReactShadowNode.getViewClass(), localThrowable);
      }
    }

    public void updateViewProp(ViewManager paramViewManager, View paramView, ReactStylesDiffMap paramReactStylesDiffMap)
    {
      try
      {
        if (this.mIndex == null)
        {
          VIEW_MGR_ARGS[0] = paramView;
          VIEW_MGR_ARGS[1] = extractProperty(paramReactStylesDiffMap);
          this.mSetter.invoke(paramViewManager, VIEW_MGR_ARGS);
          Arrays.fill(VIEW_MGR_ARGS, null);
          return;
        }
        VIEW_MGR_GROUP_ARGS[0] = paramView;
        VIEW_MGR_GROUP_ARGS[1] = this.mIndex;
        VIEW_MGR_GROUP_ARGS[2] = extractProperty(paramReactStylesDiffMap);
        this.mSetter.invoke(paramViewManager, VIEW_MGR_GROUP_ARGS);
        Arrays.fill(VIEW_MGR_GROUP_ARGS, null);
        return;
      }
      catch (Throwable localThrowable)
      {
        FLog.e(ViewManager.class, "Error while updating prop " + this.mPropName, localThrowable);
        throw new JSApplicationIllegalArgumentException("Error while updating property '" + this.mPropName + "' of a view managed by: " + paramViewManager.getName(), localThrowable);
      }
    }
  }

  private static class StringPropSetter extends ViewManagersPropertyCache.PropSetter
  {
    public StringPropSetter(ReactProp paramReactProp, Method paramMethod)
    {
      super("String", paramMethod, null);
    }

    @Nullable
    protected Object extractProperty(ReactStylesDiffMap paramReactStylesDiffMap)
    {
      return paramReactStylesDiffMap.getString(this.mPropName);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewManagersPropertyCache
 * JD-Core Version:    0.6.2
 */
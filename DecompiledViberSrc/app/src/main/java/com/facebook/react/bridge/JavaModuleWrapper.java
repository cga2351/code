package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@DoNotStrip
public class JavaModuleWrapper
{
  private final ArrayList<MethodDescriptor> mDescs;
  private final JSInstance mJSInstance;
  private final ArrayList<NativeModule.NativeMethod> mMethods;
  private final ModuleHolder mModuleHolder;

  public JavaModuleWrapper(JSInstance paramJSInstance, ModuleHolder paramModuleHolder)
  {
    this.mJSInstance = paramJSInstance;
    this.mModuleHolder = paramModuleHolder;
    this.mMethods = new ArrayList();
    this.mDescs = new ArrayList();
  }

  @DoNotStrip
  private void findMethods()
  {
    Systrace.beginSection(0L, "findMethods");
    HashSet localHashSet = new HashSet();
    Class localClass1 = this.mModuleHolder.getModule().getClass();
    Class localClass2 = localClass1.getSuperclass();
    if (ReactModuleWithSpec.class.isAssignableFrom(localClass2));
    while (true)
    {
      for (Method localMethod : localClass2.getDeclaredMethods())
      {
        ReactMethod localReactMethod = (ReactMethod)localMethod.getAnnotation(ReactMethod.class);
        if (localReactMethod != null)
        {
          String str = localMethod.getName();
          if (localHashSet.contains(str))
            throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + str);
          MethodDescriptor localMethodDescriptor = new MethodDescriptor();
          JavaMethodWrapper localJavaMethodWrapper = new JavaMethodWrapper(this, localMethod, localReactMethod.isBlockingSynchronousMethod());
          localMethodDescriptor.name = str;
          localMethodDescriptor.type = localJavaMethodWrapper.getType();
          if (localMethodDescriptor.type == "sync")
          {
            localMethodDescriptor.signature = localJavaMethodWrapper.getSignature();
            localMethodDescriptor.method = localMethod;
          }
          this.mMethods.add(localJavaMethodWrapper);
          this.mDescs.add(localMethodDescriptor);
        }
      }
      Systrace.endSection(0L);
      return;
      localClass2 = localClass1;
    }
  }

  @Nullable
  @DoNotStrip
  public NativeMap getConstants()
  {
    if (!this.mModuleHolder.getHasConstants())
      return null;
    String str = getName();
    SystraceMessage.beginSection(0L, "JavaModuleWrapper.getConstants").arg("moduleName", str).flush();
    ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_START, str);
    BaseJavaModule localBaseJavaModule = getModule();
    Systrace.beginSection(0L, "module.getConstants");
    Map localMap = localBaseJavaModule.getConstants();
    Systrace.endSection(0L);
    Systrace.beginSection(0L, "create WritableNativeMap");
    ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_START, str);
    try
    {
      WritableNativeMap localWritableNativeMap = Arguments.makeNativeMap(localMap);
      return localWritableNativeMap;
    }
    finally
    {
      ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_END, str);
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_END, str);
      SystraceMessage.endSection(0L).flush();
    }
  }

  @DoNotStrip
  public List<MethodDescriptor> getMethodDescriptors()
  {
    if (this.mDescs.isEmpty())
      findMethods();
    return this.mDescs;
  }

  @DoNotStrip
  public BaseJavaModule getModule()
  {
    return (BaseJavaModule)this.mModuleHolder.getModule();
  }

  @DoNotStrip
  public String getName()
  {
    return this.mModuleHolder.getName();
  }

  @DoNotStrip
  public void invoke(int paramInt, ReadableNativeArray paramReadableNativeArray)
  {
    if ((this.mMethods == null) || (paramInt >= this.mMethods.size()))
      return;
    ((NativeModule.NativeMethod)this.mMethods.get(paramInt)).invoke(this.mJSInstance, paramReadableNativeArray);
  }

  @DoNotStrip
  public class MethodDescriptor
  {

    @DoNotStrip
    Method method;

    @DoNotStrip
    String name;

    @DoNotStrip
    String signature;

    @DoNotStrip
    String type;

    public MethodDescriptor()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaModuleWrapper
 * JD-Core Version:    0.6.2
 */
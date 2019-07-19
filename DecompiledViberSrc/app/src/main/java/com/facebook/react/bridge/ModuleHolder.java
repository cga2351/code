package com.facebook.react.bridge;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Provider;

@DoNotStrip
public class ModuleHolder
{
  private static final AtomicInteger sInstanceKeyCounter = new AtomicInteger(1);

  @GuardedBy("this")
  private boolean mInitializable;
  private final int mInstanceKey = sInstanceKeyCounter.getAndIncrement();

  @GuardedBy("this")
  private boolean mIsCreating;

  @GuardedBy("this")
  private boolean mIsInitializing;

  @Nullable
  @GuardedBy("this")
  private NativeModule mModule;
  private final String mName;

  @Nullable
  private Provider<? extends NativeModule> mProvider;
  private final ReactModuleInfo mReactModuleInfo;

  public ModuleHolder(NativeModule paramNativeModule)
  {
    this.mName = paramNativeModule.getName();
    this.mReactModuleInfo = new ReactModuleInfo(paramNativeModule.getName(), paramNativeModule.getClass().getSimpleName(), paramNativeModule.canOverrideExistingModule(), true, true, CxxModuleWrapper.class.isAssignableFrom(paramNativeModule.getClass()), TurboModule.class.isAssignableFrom(paramNativeModule.getClass()));
    this.mModule = paramNativeModule;
    Printer localPrinter = PrinterHolder.getPrinter();
    DebugOverlayTag localDebugOverlayTag = ReactDebugOverlayTags.NATIVE_MODULE;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mName;
    localPrinter.logMessage(localDebugOverlayTag, "NativeModule init: %s", arrayOfObject);
  }

  public ModuleHolder(ReactModuleInfo paramReactModuleInfo, Provider<? extends NativeModule> paramProvider)
  {
    this.mName = paramReactModuleInfo.name();
    this.mProvider = paramProvider;
    this.mReactModuleInfo = paramReactModuleInfo;
    if (paramReactModuleInfo.needsEagerInit())
      this.mModule = create();
  }

  private NativeModule create()
  {
    boolean bool1;
    if (this.mModule == null)
      bool1 = true;
    while (true)
    {
      SoftAssertions.assertCondition(bool1, "Creating an already created module.");
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, this.mName, this.mInstanceKey);
      SystraceMessage.beginSection(0L, "ModuleHolder.createModule").arg("name", this.mName).flush();
      Printer localPrinter = PrinterHolder.getPrinter();
      DebugOverlayTag localDebugOverlayTag = ReactDebugOverlayTags.NATIVE_MODULE;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.mName;
      localPrinter.logMessage(localDebugOverlayTag, "NativeModule init: %s", arrayOfObject);
      try
      {
        NativeModule localNativeModule = (NativeModule)((Provider)Assertions.assertNotNull(this.mProvider)).get();
        this.mProvider = null;
        try
        {
          this.mModule = localNativeModule;
          boolean bool2 = this.mInitializable;
          int i = 0;
          if (bool2)
          {
            boolean bool3 = this.mIsInitializing;
            i = 0;
            if (!bool3)
              i = 1;
          }
          if (i != 0)
            doInitialize(localNativeModule);
          return localNativeModule;
          bool1 = false;
        }
        finally
        {
        }
      }
      finally
      {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END, this.mName, this.mInstanceKey);
        SystraceMessage.endSection(0L).flush();
      }
    }
  }

  // ERROR //
  private void doInitialize(NativeModule paramNativeModule)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: lconst_0
    //   3: ldc 182
    //   5: invokestatic 144	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   8: ldc 145
    //   10: aload_0
    //   11: getfield 53	com/facebook/react/bridge/ModuleHolder:mName	Ljava/lang/String;
    //   14: invokevirtual 151	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;Ljava/lang/Object;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   17: invokevirtual 154	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   20: getstatic 185	com/facebook/react/bridge/ReactMarkerConstants:INITIALIZE_MODULE_START	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   23: aload_0
    //   24: getfield 53	com/facebook/react/bridge/ModuleHolder:mName	Ljava/lang/String;
    //   27: aload_0
    //   28: getfield 45	com/facebook/react/bridge/ModuleHolder:mInstanceKey	I
    //   31: invokestatic 136	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;Ljava/lang/String;I)V
    //   34: aload_0
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield 168	com/facebook/react/bridge/ModuleHolder:mInitializable	Z
    //   40: ifeq +96 -> 136
    //   43: aload_0
    //   44: getfield 170	com/facebook/react/bridge/ModuleHolder:mIsInitializing	Z
    //   47: ifne +89 -> 136
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 170	com/facebook/react/bridge/ModuleHolder:mIsInitializing	Z
    //   55: aload_0
    //   56: monitorexit
    //   57: iload_2
    //   58: ifeq +18 -> 76
    //   61: aload_1
    //   62: invokeinterface 188 1 0
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 170	com/facebook/react/bridge/ModuleHolder:mIsInitializing	Z
    //   74: aload_0
    //   75: monitorexit
    //   76: getstatic 191	com/facebook/react/bridge/ReactMarkerConstants:INITIALIZE_MODULE_END	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   79: aload_0
    //   80: getfield 53	com/facebook/react/bridge/ModuleHolder:mName	Ljava/lang/String;
    //   83: aload_0
    //   84: getfield 45	com/facebook/react/bridge/ModuleHolder:mInstanceKey	I
    //   87: invokestatic 136	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;Ljava/lang/String;I)V
    //   90: lconst_0
    //   91: invokestatic 180	com/facebook/systrace/SystraceMessage:endSection	(J)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   94: invokevirtual 154	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   97: return
    //   98: astore 4
    //   100: aload_0
    //   101: monitorexit
    //   102: aload 4
    //   104: athrow
    //   105: astore_3
    //   106: getstatic 191	com/facebook/react/bridge/ReactMarkerConstants:INITIALIZE_MODULE_END	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   109: aload_0
    //   110: getfield 53	com/facebook/react/bridge/ModuleHolder:mName	Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 45	com/facebook/react/bridge/ModuleHolder:mInstanceKey	I
    //   117: invokestatic 136	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;Ljava/lang/String;I)V
    //   120: lconst_0
    //   121: invokestatic 180	com/facebook/systrace/SystraceMessage:endSection	(J)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   124: invokevirtual 154	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   127: aload_3
    //   128: athrow
    //   129: astore 5
    //   131: aload_0
    //   132: monitorexit
    //   133: aload 5
    //   135: athrow
    //   136: iconst_0
    //   137: istore_2
    //   138: goto -83 -> 55
    //
    // Exception table:
    //   from	to	target	type
    //   36	55	98	finally
    //   55	57	98	finally
    //   100	102	98	finally
    //   34	36	105	finally
    //   61	69	105	finally
    //   102	105	105	finally
    //   133	136	105	finally
    //   69	76	129	finally
    //   131	133	129	finally
  }

  public void destroy()
  {
    try
    {
      if (this.mModule != null)
        this.mModule.onCatalystInstanceDestroy();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean getCanOverrideExistingModule()
  {
    return this.mReactModuleInfo.canOverrideExistingModule();
  }

  public String getClassName()
  {
    return this.mReactModuleInfo.className();
  }

  public boolean getHasConstants()
  {
    return this.mReactModuleInfo.hasConstants();
  }

  @DoNotStrip
  public NativeModule getModule()
  {
    int i = 1;
    while (true)
    {
      try
      {
        if (this.mModule != null)
        {
          NativeModule localNativeModule3 = this.mModule;
          return localNativeModule3;
        }
        if (this.mIsCreating)
          break label128;
        this.mIsCreating = true;
        if (i != 0)
        {
          NativeModule localNativeModule2 = create();
          try
          {
            this.mIsCreating = false;
            notifyAll();
            return localNativeModule2;
          }
          finally
          {
          }
        }
      }
      finally
      {
      }
      try
      {
        while (this.mModule == null)
        {
          boolean bool = this.mIsCreating;
          if (!bool)
            break;
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
          }
        }
        NativeModule localNativeModule1 = (NativeModule)Assertions.assertNotNull(this.mModule);
        return localNativeModule1;
      }
      finally
      {
      }
      label128: i = 0;
    }
  }

  @DoNotStrip
  public String getName()
  {
    return this.mName;
  }

  boolean hasInstance()
  {
    try
    {
      NativeModule localNativeModule = this.mModule;
      if (localNativeModule != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public boolean isCxxModule()
  {
    return this.mReactModuleInfo.isCxxModule();
  }

  public boolean isTurboModule()
  {
    return this.mReactModuleInfo.isTurboModule();
  }

  void markInitializable()
  {
    boolean bool1 = true;
    while (true)
    {
      try
      {
        this.mInitializable = true;
        if (this.mModule != null)
        {
          boolean bool2 = this.mIsInitializing;
          boolean bool3 = false;
          if (!bool2)
            bool3 = bool1;
          Assertions.assertCondition(bool3);
          localNativeModule = this.mModule;
          if (bool1)
            doInitialize(localNativeModule);
          return;
        }
      }
      finally
      {
      }
      NativeModule localNativeModule = null;
      bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ModuleHolder
 * JD-Core Version:    0.6.2
 */
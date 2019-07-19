package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.gesturehandler.h;
import com.swmansion.gesturehandler.j;
import com.swmansion.gesturehandler.k;
import com.swmansion.gesturehandler.n;
import com.swmansion.gesturehandler.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="RNGestureHandlerModule")
public class RNGestureHandlerModule extends ReactContextBaseJavaModule
{
  private static final String KEY_DIRECTION = "direction";
  private static final String KEY_ENABLED = "enabled";
  private static final String KEY_HIT_SLOP = "hitSlop";
  private static final String KEY_HIT_SLOP_BOTTOM = "bottom";
  private static final String KEY_HIT_SLOP_HEIGHT = "height";
  private static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";
  private static final String KEY_HIT_SLOP_LEFT = "left";
  private static final String KEY_HIT_SLOP_RIGHT = "right";
  private static final String KEY_HIT_SLOP_TOP = "top";
  private static final String KEY_HIT_SLOP_VERTICAL = "vertical";
  private static final String KEY_HIT_SLOP_WIDTH = "width";
  private static final String KEY_LONG_PRESS_MAX_DIST = "maxDist";
  private static final String KEY_LONG_PRESS_MIN_DURATION_MS = "minDurationMs";
  private static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION = "disallowInterruption";
  private static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
  private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
  private static final String KEY_PAN_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";
  private static final String KEY_PAN_ACTIVE_OFFSET_X_START = "activeOffsetXStart";
  private static final String KEY_PAN_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";
  private static final String KEY_PAN_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";
  private static final String KEY_PAN_AVG_TOUCHES = "avgTouches";
  private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";
  private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";
  private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";
  private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";
  private static final String KEY_PAN_MAX_POINTERS = "maxPointers";
  private static final String KEY_PAN_MIN_DIST = "minDist";
  private static final String KEY_PAN_MIN_POINTERS = "minPointers";
  private static final String KEY_PAN_MIN_VELOCITY = "minVelocity";
  private static final String KEY_PAN_MIN_VELOCITY_X = "minVelocityX";
  private static final String KEY_PAN_MIN_VELOCITY_Y = "minVelocityY";
  private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";
  private static final String KEY_TAP_MAX_DELAY_MS = "maxDelayMs";
  private static final String KEY_TAP_MAX_DELTA_X = "maxDeltaX";
  private static final String KEY_TAP_MAX_DELTA_Y = "maxDeltaY";
  private static final String KEY_TAP_MAX_DIST = "maxDist";
  private static final String KEY_TAP_MAX_DURATION_MS = "maxDurationMs";
  private static final String KEY_TAP_MIN_POINTERS = "minPointers";
  private static final String KEY_TAP_NUMBER_OF_TAPS = "numberOfTaps";
  public static final String MODULE_NAME = "RNGestureHandlerModule";
  private List<Integer> mEnqueuedRootViewInit;
  private com.swmansion.gesturehandler.i mEventListener = new com.swmansion.gesturehandler.i()
  {
    public void a(com.swmansion.gesturehandler.b paramAnonymousb, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      RNGestureHandlerModule.this.onStateChange(paramAnonymousb, paramAnonymousInt1, paramAnonymousInt2);
    }

    public void a(com.swmansion.gesturehandler.b paramAnonymousb, MotionEvent paramAnonymousMotionEvent)
    {
      RNGestureHandlerModule.this.onTouchEvent(paramAnonymousb, paramAnonymousMotionEvent);
    }
  };
  private b[] mHandlerFactories;
  private d mInteractionManager;
  private final f mRegistry;
  private List<g> mRoots;

  public RNGestureHandlerModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    b[] arrayOfb = new b[7];
    arrayOfb[0] = new d(null);
    arrayOfb[1] = new h(null);
    arrayOfb[2] = new c(null);
    arrayOfb[3] = new e(null);
    arrayOfb[4] = new f(null);
    arrayOfb[5] = new g(null);
    arrayOfb[6] = new a(null);
    this.mHandlerFactories = arrayOfb;
    this.mRegistry = new f();
    this.mInteractionManager = new d();
    this.mRoots = new ArrayList();
    this.mEnqueuedRootViewInit = new ArrayList();
  }

  @Nullable
  private b findFactoryForHandler(com.swmansion.gesturehandler.b paramb)
  {
    for (int i = 0; i < this.mHandlerFactories.length; i++)
    {
      b localb = this.mHandlerFactories[i];
      if (localb.a().equals(paramb.getClass()))
        return localb;
    }
    return null;
  }

  @Nullable
  private g findRootHelperForViewAncestor(int paramInt)
  {
    int i = ((UIManagerModule)getReactApplicationContext().getNativeModule(UIManagerModule.class)).resolveRootTagFromReactTag(paramInt);
    if (i < 1)
      return null;
    List localList = this.mRoots;
    for (int j = 0; ; j++)
      try
      {
        if (j >= this.mRoots.size())
          break;
        g localg = (g)this.mRoots.get(j);
        if (localg.b().getRootViewTag() == i)
          return localg;
      }
      finally
      {
      }
    return null;
  }

  private static void handleHitSlopProperty(com.swmansion.gesturehandler.b paramb, ReadableMap paramReadableMap)
  {
    if (paramReadableMap.getType("hitSlop") == ReadableType.Number)
    {
      float f8 = PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("hitSlop"));
      paramb.a(f8, f8, f8, f8, (0.0F / 0.0F), (0.0F / 0.0F));
      return;
    }
    ReadableMap localReadableMap = paramReadableMap.getMap("hitSlop");
    float f1;
    if (localReadableMap.hasKey("horizontal"))
      f1 = PixelUtil.toPixelFromDIP(localReadableMap.getDouble("horizontal"));
    for (float f2 = f1; ; f2 = (0.0F / 0.0F))
    {
      float f4;
      float f3;
      if (localReadableMap.hasKey("vertical"))
      {
        f4 = PixelUtil.toPixelFromDIP(localReadableMap.getDouble("vertical"));
        f3 = f4;
      }
      while (true)
      {
        if (localReadableMap.hasKey("left"))
          f2 = PixelUtil.toPixelFromDIP(localReadableMap.getDouble("left"));
        if (localReadableMap.hasKey("top"))
          f4 = PixelUtil.toPixelFromDIP(localReadableMap.getDouble("top"));
        if (localReadableMap.hasKey("right"));
        for (float f5 = PixelUtil.toPixelFromDIP(localReadableMap.getDouble("right")); ; f5 = f1)
        {
          if (localReadableMap.hasKey("bottom"))
            f3 = PixelUtil.toPixelFromDIP(localReadableMap.getDouble("bottom"));
          if (localReadableMap.hasKey("width"));
          for (float f6 = PixelUtil.toPixelFromDIP(localReadableMap.getDouble("width")); ; f6 = (0.0F / 0.0F))
          {
            if (localReadableMap.hasKey("height"));
            for (float f7 = PixelUtil.toPixelFromDIP(localReadableMap.getDouble("height")); ; f7 = (0.0F / 0.0F))
            {
              paramb.a(f2, f4, f5, f3, f6, f7);
              return;
            }
          }
        }
        f3 = (0.0F / 0.0F);
        f4 = (0.0F / 0.0F);
      }
      f1 = (0.0F / 0.0F);
    }
  }

  private void onStateChange(com.swmansion.gesturehandler.b paramb, int paramInt1, int paramInt2)
  {
    if (paramb.d() < 0)
      return;
    b localb = findFactoryForHandler(paramb);
    ((UIManagerModule)getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(i.a(paramb, paramInt1, paramInt2, localb));
  }

  private void onTouchEvent(com.swmansion.gesturehandler.b paramb, MotionEvent paramMotionEvent)
  {
    if (paramb.d() < 0);
    while (paramb.i() != 4)
      return;
    b localb = findFactoryForHandler(paramb);
    ((UIManagerModule)getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(b.a(paramb, localb));
  }

  private void tryInitializeHandlerForReactRootView(int paramInt)
  {
    UIManagerModule localUIManagerModule = (UIManagerModule)getReactApplicationContext().getNativeModule(UIManagerModule.class);
    final int i = localUIManagerModule.resolveRootTagFromReactTag(paramInt);
    if (i < 1)
      throw new JSApplicationIllegalArgumentException("Could find root view for a given ancestor with tag " + paramInt);
    List localList1 = this.mRoots;
    for (int j = 0; ; j++)
    {
      try
      {
        if (j < this.mRoots.size())
        {
          if (((g)this.mRoots.get(j)).b().getRootViewTag() != i)
            continue;
          return;
        }
        synchronized (this.mEnqueuedRootViewInit)
        {
          if (this.mEnqueuedRootViewInit.contains(Integer.valueOf(i)))
            return;
        }
      }
      finally
      {
      }
      this.mEnqueuedRootViewInit.add(Integer.valueOf(i));
      localUIManagerModule.addUIBlock(new UIBlock()
      {
        public void execute(NativeViewHierarchyManager paramAnonymousNativeViewHierarchyManager)
        {
          View localView = paramAnonymousNativeViewHierarchyManager.resolveView(i);
          if ((localView instanceof a))
            ((a)localView).a();
          synchronized (RNGestureHandlerModule.this.mEnqueuedRootViewInit)
          {
            RNGestureHandlerModule.this.mEnqueuedRootViewInit.remove(new Integer(i));
            return;
          }
        }
      });
      return;
    }
  }

  @ReactMethod
  public void attachGestureHandler(int paramInt1, int paramInt2)
  {
    tryInitializeHandlerForReactRootView(paramInt2);
    if (!this.mRegistry.a(paramInt1, paramInt2))
      throw new JSApplicationIllegalArgumentException("Handler with tag " + paramInt1 + " does not exists");
  }

  @ReactMethod
  public void createGestureHandler(String paramString, int paramInt, ReadableMap paramReadableMap)
  {
    for (int i = 0; i < this.mHandlerFactories.length; i++)
    {
      b localb = this.mHandlerFactories[i];
      if (localb.b().equals(paramString))
      {
        com.swmansion.gesturehandler.b localb1 = localb.b(getReactApplicationContext());
        localb1.c(paramInt);
        localb1.a(this.mEventListener);
        this.mRegistry.a(localb1);
        this.mInteractionManager.a(localb1, paramReadableMap);
        localb.a(localb1, paramReadableMap);
        return;
      }
    }
    throw new JSApplicationIllegalArgumentException("Invalid handler name " + paramString);
  }

  @ReactMethod
  public void dropGestureHandler(int paramInt)
  {
    this.mInteractionManager.a(paramInt);
    this.mRegistry.b(paramInt);
  }

  @Nullable
  public Map getConstants()
  {
    return MapBuilder.of("State", MapBuilder.of("UNDETERMINED", Integer.valueOf(0), "BEGAN", Integer.valueOf(2), "ACTIVE", Integer.valueOf(4), "CANCELLED", Integer.valueOf(3), "FAILED", Integer.valueOf(1), "END", Integer.valueOf(5)), "Direction", MapBuilder.of("RIGHT", Integer.valueOf(1), "LEFT", Integer.valueOf(2), "UP", Integer.valueOf(4), "DOWN", Integer.valueOf(8)));
  }

  public String getName()
  {
    return "RNGestureHandlerModule";
  }

  public f getRegistry()
  {
    return this.mRegistry;
  }

  @ReactMethod
  public void handleClearJSResponder()
  {
  }

  @ReactMethod
  public void handleSetJSResponder(int paramInt, boolean paramBoolean)
  {
    if (this.mRegistry != null)
    {
      g localg = findRootHelperForViewAncestor(paramInt);
      if (localg != null)
        localg.a(paramInt, paramBoolean);
    }
  }

  public void onCatalystInstanceDestroy()
  {
    this.mRegistry.a();
    this.mInteractionManager.a();
    while (true)
    {
      g localg;
      synchronized (this.mRoots)
      {
        if (this.mRoots.isEmpty())
          break;
        int i = this.mRoots.size();
        localg = (g)this.mRoots.get(0);
        ReactRootView localReactRootView = localg.b();
        if ((localReactRootView instanceof a))
        {
          ((a)localReactRootView).b();
          if (this.mRoots.size() < i)
            continue;
          throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
        }
      }
      localg.a();
    }
    super.onCatalystInstanceDestroy();
  }

  public void registerRootHelper(g paramg)
  {
    synchronized (this.mRoots)
    {
      if (this.mRoots.contains(paramg))
        throw new IllegalStateException("Root helper" + paramg + " already registered");
    }
    this.mRoots.add(paramg);
  }

  public void unregisterRootHelper(g paramg)
  {
    synchronized (this.mRoots)
    {
      this.mRoots.remove(paramg);
      return;
    }
  }

  @ReactMethod
  public void updateGestureHandler(int paramInt, ReadableMap paramReadableMap)
  {
    com.swmansion.gesturehandler.b localb = this.mRegistry.a(paramInt);
    if (localb != null)
    {
      b localb1 = findFactoryForHandler(localb);
      if (localb1 != null)
      {
        this.mInteractionManager.a(paramInt);
        this.mInteractionManager.a(localb, paramReadableMap);
        localb1.a(localb, paramReadableMap);
      }
    }
  }

  private static class a extends RNGestureHandlerModule.b<com.swmansion.gesturehandler.a>
  {
    private a()
    {
      super();
    }

    public com.swmansion.gesturehandler.a a(Context paramContext)
    {
      return new com.swmansion.gesturehandler.a();
    }

    public Class<com.swmansion.gesturehandler.a> a()
    {
      return com.swmansion.gesturehandler.a.class;
    }

    public void a(com.swmansion.gesturehandler.a parama, ReadableMap paramReadableMap)
    {
      super.a(parama, paramReadableMap);
      if (paramReadableMap.hasKey("numberOfPointers"))
        parama.a(paramReadableMap.getInt("numberOfPointers"));
      if (paramReadableMap.hasKey("direction"))
        parama.b(paramReadableMap.getInt("direction"));
    }

    public void a(com.swmansion.gesturehandler.a parama, WritableMap paramWritableMap)
    {
      super.a(parama, paramWritableMap);
      paramWritableMap.putDouble("x", PixelUtil.toDIPFromPixel(parama.r()));
      paramWritableMap.putDouble("y", PixelUtil.toDIPFromPixel(parama.s()));
      paramWritableMap.putDouble("absoluteX", PixelUtil.toDIPFromPixel(parama.p()));
      paramWritableMap.putDouble("absoluteY", PixelUtil.toDIPFromPixel(parama.q()));
    }

    public String b()
    {
      return "FlingGestureHandler";
    }
  }

  private static abstract class b<T extends com.swmansion.gesturehandler.b>
    implements c<T>
  {
    public abstract Class<T> a();

    public void a(T paramT, ReadableMap paramReadableMap)
    {
      if (paramReadableMap.hasKey("shouldCancelWhenOutside"))
        paramT.a(paramReadableMap.getBoolean("shouldCancelWhenOutside"));
      if (paramReadableMap.hasKey("enabled"))
        paramT.b(paramReadableMap.getBoolean("enabled"));
      if (paramReadableMap.hasKey("hitSlop"))
        RNGestureHandlerModule.handleHitSlopProperty(paramT, paramReadableMap);
    }

    public void a(T paramT, WritableMap paramWritableMap)
    {
      paramWritableMap.putDouble("numberOfPointers", paramT.f());
    }

    public abstract T b(Context paramContext);

    public abstract String b();
  }

  private static class c extends RNGestureHandlerModule.b<com.swmansion.gesturehandler.g>
  {
    private c()
    {
      super();
    }

    public com.swmansion.gesturehandler.g a(Context paramContext)
    {
      return new com.swmansion.gesturehandler.g(paramContext);
    }

    public Class<com.swmansion.gesturehandler.g> a()
    {
      return com.swmansion.gesturehandler.g.class;
    }

    public void a(com.swmansion.gesturehandler.g paramg, ReadableMap paramReadableMap)
    {
      super.a(paramg, paramReadableMap);
      if (paramReadableMap.hasKey("minDurationMs"))
        paramg.a(paramReadableMap.getInt("minDurationMs"));
      if (paramReadableMap.hasKey("maxDist"))
        paramg.a(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("maxDist")));
    }

    public void a(com.swmansion.gesturehandler.g paramg, WritableMap paramWritableMap)
    {
      super.a(paramg, paramWritableMap);
      paramWritableMap.putDouble("x", PixelUtil.toDIPFromPixel(paramg.r()));
      paramWritableMap.putDouble("y", PixelUtil.toDIPFromPixel(paramg.s()));
      paramWritableMap.putDouble("absoluteX", PixelUtil.toDIPFromPixel(paramg.p()));
      paramWritableMap.putDouble("absoluteY", PixelUtil.toDIPFromPixel(paramg.q()));
    }

    public String b()
    {
      return "LongPressGestureHandler";
    }
  }

  private static class d extends RNGestureHandlerModule.b<h>
  {
    private d()
    {
      super();
    }

    public h a(Context paramContext)
    {
      return new h();
    }

    public Class<h> a()
    {
      return h.class;
    }

    public void a(h paramh, ReadableMap paramReadableMap)
    {
      super.a(paramh, paramReadableMap);
      if (paramReadableMap.hasKey("shouldActivateOnStart"))
        paramh.c(paramReadableMap.getBoolean("shouldActivateOnStart"));
      if (paramReadableMap.hasKey("disallowInterruption"))
        paramh.d(paramReadableMap.getBoolean("disallowInterruption"));
    }

    public void a(h paramh, WritableMap paramWritableMap)
    {
      super.a(paramh, paramWritableMap);
      paramWritableMap.putBoolean("pointerInside", paramh.g());
    }

    public String b()
    {
      return "NativeViewGestureHandler";
    }
  }

  private static class e extends RNGestureHandlerModule.b<j>
  {
    private e()
    {
      super();
    }

    public j a(Context paramContext)
    {
      return new j(paramContext);
    }

    public Class<j> a()
    {
      return j.class;
    }

    public void a(j paramj, ReadableMap paramReadableMap)
    {
      int i = 1;
      super.a(paramj, paramReadableMap);
      boolean bool = paramReadableMap.hasKey("activeOffsetXStart");
      int j = 0;
      if (bool)
      {
        paramj.a(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("activeOffsetXStart")));
        j = i;
      }
      if (paramReadableMap.hasKey("activeOffsetXEnd"))
      {
        paramj.b(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("activeOffsetXEnd")));
        j = i;
      }
      if (paramReadableMap.hasKey("failOffsetXStart"))
      {
        paramj.c(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("failOffsetXStart")));
        j = i;
      }
      if (paramReadableMap.hasKey("failOffsetXEnd"))
      {
        paramj.d(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("failOffsetXEnd")));
        j = i;
      }
      if (paramReadableMap.hasKey("activeOffsetYStart"))
      {
        paramj.e(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("activeOffsetYStart")));
        j = i;
      }
      if (paramReadableMap.hasKey("activeOffsetYEnd"))
      {
        paramj.f(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("activeOffsetYEnd")));
        j = i;
      }
      if (paramReadableMap.hasKey("failOffsetYStart"))
      {
        paramj.g(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("failOffsetYStart")));
        j = i;
      }
      if (paramReadableMap.hasKey("failOffsetYEnd"))
      {
        paramj.h(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("failOffsetYEnd")));
        j = i;
      }
      if (paramReadableMap.hasKey("minVelocity"))
      {
        paramj.j(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("minVelocity")));
        j = i;
      }
      if (paramReadableMap.hasKey("minVelocityX"))
      {
        paramj.k(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("minVelocityX")));
        j = i;
      }
      if (paramReadableMap.hasKey("minVelocityY"))
        paramj.l(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("minVelocityY")));
      while (true)
      {
        if (paramReadableMap.hasKey("minDist"))
          paramj.i(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("minDist")));
        while (true)
        {
          if (paramReadableMap.hasKey("minPointers"))
            paramj.a(paramReadableMap.getInt("minPointers"));
          if (paramReadableMap.hasKey("maxPointers"))
            paramj.b(paramReadableMap.getInt("maxPointers"));
          if (paramReadableMap.hasKey("avgTouches"))
            paramj.c(paramReadableMap.getBoolean("avgTouches"));
          return;
          if (i != 0)
            paramj.i(3.4028235E+38F);
        }
        i = j;
      }
    }

    public void a(j paramj, WritableMap paramWritableMap)
    {
      super.a(paramj, paramWritableMap);
      paramWritableMap.putDouble("x", PixelUtil.toDIPFromPixel(paramj.r()));
      paramWritableMap.putDouble("y", PixelUtil.toDIPFromPixel(paramj.s()));
      paramWritableMap.putDouble("absoluteX", PixelUtil.toDIPFromPixel(paramj.p()));
      paramWritableMap.putDouble("absoluteY", PixelUtil.toDIPFromPixel(paramj.q()));
      paramWritableMap.putDouble("translationX", PixelUtil.toDIPFromPixel(paramj.t()));
      paramWritableMap.putDouble("translationY", PixelUtil.toDIPFromPixel(paramj.u()));
      paramWritableMap.putDouble("velocityX", PixelUtil.toDIPFromPixel(paramj.v()));
      paramWritableMap.putDouble("velocityY", PixelUtil.toDIPFromPixel(paramj.w()));
    }

    public String b()
    {
      return "PanGestureHandler";
    }
  }

  private static class f extends RNGestureHandlerModule.b<k>
  {
    private f()
    {
      super();
    }

    public k a(Context paramContext)
    {
      return new k();
    }

    public Class<k> a()
    {
      return k.class;
    }

    public void a(k paramk, WritableMap paramWritableMap)
    {
      super.a(paramk, paramWritableMap);
      paramWritableMap.putDouble("scale", paramk.t());
      paramWritableMap.putDouble("focalX", PixelUtil.toDIPFromPixel(paramk.v()));
      paramWritableMap.putDouble("focalY", PixelUtil.toDIPFromPixel(paramk.w()));
      paramWritableMap.putDouble("velocity", paramk.u());
    }

    public String b()
    {
      return "PinchGestureHandler";
    }
  }

  private static class g extends RNGestureHandlerModule.b<n>
  {
    private g()
    {
      super();
    }

    public n a(Context paramContext)
    {
      return new n();
    }

    public Class<n> a()
    {
      return n.class;
    }

    public void a(n paramn, WritableMap paramWritableMap)
    {
      super.a(paramn, paramWritableMap);
      paramWritableMap.putDouble("rotation", paramn.t());
      paramWritableMap.putDouble("anchorX", PixelUtil.toDIPFromPixel(paramn.v()));
      paramWritableMap.putDouble("anchorY", PixelUtil.toDIPFromPixel(paramn.w()));
      paramWritableMap.putDouble("velocity", paramn.u());
    }

    public String b()
    {
      return "RotationGestureHandler";
    }
  }

  private static class h extends RNGestureHandlerModule.b<o>
  {
    private h()
    {
      super();
    }

    public o a(Context paramContext)
    {
      return new o();
    }

    public Class<o> a()
    {
      return o.class;
    }

    public void a(o paramo, ReadableMap paramReadableMap)
    {
      super.a(paramo, paramReadableMap);
      if (paramReadableMap.hasKey("numberOfTaps"))
        paramo.a(paramReadableMap.getInt("numberOfTaps"));
      if (paramReadableMap.hasKey("maxDurationMs"))
        paramo.b(paramReadableMap.getInt("maxDurationMs"));
      if (paramReadableMap.hasKey("maxDelayMs"))
        paramo.a(paramReadableMap.getInt("maxDelayMs"));
      if (paramReadableMap.hasKey("maxDeltaX"))
        paramo.a(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("maxDeltaX")));
      if (paramReadableMap.hasKey("maxDeltaY"))
        paramo.b(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("maxDeltaY")));
      if (paramReadableMap.hasKey("maxDist"))
        paramo.c(PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("maxDist")));
      if (paramReadableMap.hasKey("minPointers"))
        paramo.b(paramReadableMap.getInt("minPointers"));
    }

    public void a(o paramo, WritableMap paramWritableMap)
    {
      super.a(paramo, paramWritableMap);
      paramWritableMap.putDouble("x", PixelUtil.toDIPFromPixel(paramo.r()));
      paramWritableMap.putDouble("y", PixelUtil.toDIPFromPixel(paramo.s()));
      paramWritableMap.putDouble("absoluteX", PixelUtil.toDIPFromPixel(paramo.p()));
      paramWritableMap.putDouble("absoluteY", PixelUtil.toDIPFromPixel(paramo.q()));
    }

    public String b()
    {
      return "TapGestureHandler";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.RNGestureHandlerModule
 * JD-Core Version:    0.6.2
 */
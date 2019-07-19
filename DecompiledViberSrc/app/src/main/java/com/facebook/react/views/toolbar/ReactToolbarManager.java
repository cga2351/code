package com.facebook.react.views.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.toolbar.events.ToolbarClickEvent;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactToolbarManager extends ViewGroupManager<ReactToolbar>
{
  private static final int COMMAND_DISMISS_POPUP_MENUS = 1;
  private static final String REACT_CLASS = "ToolbarAndroid";

  // ERROR //
  private static int[] getDefaultColors(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 24	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   6: astore_2
    //   7: iconst_1
    //   8: newarray int
    //   10: astore 7
    //   12: aload 7
    //   14: iconst_0
    //   15: aload_0
    //   16: ldc 26
    //   18: invokestatic 30	com/facebook/react/views/toolbar/ReactToolbarManager:getIdentifier	(Landroid/content/Context;Ljava/lang/String;)I
    //   21: iastore
    //   22: aload_2
    //   23: aload 7
    //   25: invokevirtual 36	android/content/res/Resources$Theme:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   28: astore 8
    //   30: aload 8
    //   32: astore 6
    //   34: aload 6
    //   36: iconst_0
    //   37: iconst_0
    //   38: invokevirtual 42	android/content/res/TypedArray:getResourceId	(II)I
    //   41: istore 9
    //   43: iconst_2
    //   44: newarray int
    //   46: astore 10
    //   48: aload 10
    //   50: iconst_0
    //   51: aload_0
    //   52: ldc 44
    //   54: invokestatic 30	com/facebook/react/views/toolbar/ReactToolbarManager:getIdentifier	(Landroid/content/Context;Ljava/lang/String;)I
    //   57: iastore
    //   58: aload 10
    //   60: iconst_1
    //   61: aload_0
    //   62: ldc 46
    //   64: invokestatic 30	com/facebook/react/views/toolbar/ReactToolbarManager:getIdentifier	(Landroid/content/Context;Ljava/lang/String;)I
    //   67: iastore
    //   68: aload_2
    //   69: iload 9
    //   71: aload 10
    //   73: invokevirtual 49	android/content/res/Resources$Theme:obtainStyledAttributes	(I[I)Landroid/content/res/TypedArray;
    //   76: astore 11
    //   78: aload 11
    //   80: astore 5
    //   82: aload 5
    //   84: iconst_0
    //   85: iconst_0
    //   86: invokevirtual 42	android/content/res/TypedArray:getResourceId	(II)I
    //   89: istore 12
    //   91: aload 5
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokevirtual 42	android/content/res/TypedArray:getResourceId	(II)I
    //   98: istore 13
    //   100: aload_2
    //   101: iload 12
    //   103: iconst_1
    //   104: newarray int
    //   106: dup
    //   107: iconst_0
    //   108: ldc 50
    //   110: iastore
    //   111: invokevirtual 49	android/content/res/Resources$Theme:obtainStyledAttributes	(I[I)Landroid/content/res/TypedArray;
    //   114: astore 14
    //   116: aload 14
    //   118: astore 4
    //   120: aload_2
    //   121: iload 13
    //   123: iconst_1
    //   124: newarray int
    //   126: dup
    //   127: iconst_0
    //   128: ldc 50
    //   130: iastore
    //   131: invokevirtual 49	android/content/res/Resources$Theme:obtainStyledAttributes	(I[I)Landroid/content/res/TypedArray;
    //   134: astore_1
    //   135: iconst_2
    //   136: newarray int
    //   138: dup
    //   139: iconst_0
    //   140: aload 4
    //   142: iconst_0
    //   143: ldc 51
    //   145: invokevirtual 54	android/content/res/TypedArray:getColor	(II)I
    //   148: iastore
    //   149: dup
    //   150: iconst_1
    //   151: aload_1
    //   152: iconst_0
    //   153: ldc 51
    //   155: invokevirtual 54	android/content/res/TypedArray:getColor	(II)I
    //   158: iastore
    //   159: astore 15
    //   161: aload 6
    //   163: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   166: aload 5
    //   168: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   171: aload 4
    //   173: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   176: aload_1
    //   177: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   180: aload 15
    //   182: areturn
    //   183: astore_3
    //   184: aconst_null
    //   185: astore 4
    //   187: aconst_null
    //   188: astore 5
    //   190: aconst_null
    //   191: astore 6
    //   193: aload 6
    //   195: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   198: aload 5
    //   200: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   203: aload 4
    //   205: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   208: aload_1
    //   209: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   212: aload_3
    //   213: athrow
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_1
    //   217: aconst_null
    //   218: astore 4
    //   220: aconst_null
    //   221: astore 5
    //   223: goto -30 -> 193
    //   226: astore_3
    //   227: aconst_null
    //   228: astore_1
    //   229: aconst_null
    //   230: astore 4
    //   232: goto -39 -> 193
    //   235: astore_3
    //   236: goto -43 -> 193
    //
    // Exception table:
    //   from	to	target	type
    //   7	30	183	finally
    //   34	78	214	finally
    //   82	116	226	finally
    //   120	161	235	finally
  }

  // ERROR //
  private int[] getDefaultContentInsets(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 24	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   6: astore_3
    //   7: iconst_1
    //   8: newarray int
    //   10: astore 6
    //   12: aload 6
    //   14: iconst_0
    //   15: aload_1
    //   16: ldc 26
    //   18: invokestatic 30	com/facebook/react/views/toolbar/ReactToolbarManager:getIdentifier	(Landroid/content/Context;Ljava/lang/String;)I
    //   21: iastore
    //   22: aload_3
    //   23: aload 6
    //   25: invokevirtual 36	android/content/res/Resources$Theme:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   28: astore 7
    //   30: aload 7
    //   32: astore 5
    //   34: aload 5
    //   36: iconst_0
    //   37: iconst_0
    //   38: invokevirtual 42	android/content/res/TypedArray:getResourceId	(II)I
    //   41: istore 8
    //   43: iconst_2
    //   44: newarray int
    //   46: astore 9
    //   48: aload 9
    //   50: iconst_0
    //   51: aload_1
    //   52: ldc 61
    //   54: invokestatic 30	com/facebook/react/views/toolbar/ReactToolbarManager:getIdentifier	(Landroid/content/Context;Ljava/lang/String;)I
    //   57: iastore
    //   58: aload 9
    //   60: iconst_1
    //   61: aload_1
    //   62: ldc 63
    //   64: invokestatic 30	com/facebook/react/views/toolbar/ReactToolbarManager:getIdentifier	(Landroid/content/Context;Ljava/lang/String;)I
    //   67: iastore
    //   68: aload_3
    //   69: iload 8
    //   71: aload 9
    //   73: invokevirtual 49	android/content/res/Resources$Theme:obtainStyledAttributes	(I[I)Landroid/content/res/TypedArray;
    //   76: astore_2
    //   77: iconst_2
    //   78: newarray int
    //   80: dup
    //   81: iconst_0
    //   82: aload_2
    //   83: iconst_0
    //   84: iconst_0
    //   85: invokevirtual 66	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   88: iastore
    //   89: dup
    //   90: iconst_1
    //   91: aload_2
    //   92: iconst_1
    //   93: iconst_0
    //   94: invokevirtual 66	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   97: iastore
    //   98: astore 10
    //   100: aload 5
    //   102: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   105: aload_2
    //   106: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   109: aload 10
    //   111: areturn
    //   112: astore 4
    //   114: aconst_null
    //   115: astore 5
    //   117: aload 5
    //   119: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   122: aload_2
    //   123: invokestatic 58	com/facebook/react/views/toolbar/ReactToolbarManager:recycleQuietly	(Landroid/content/res/TypedArray;)V
    //   126: aload 4
    //   128: athrow
    //   129: astore 4
    //   131: goto -14 -> 117
    //
    // Exception table:
    //   from	to	target	type
    //   7	30	112	finally
    //   34	100	129	finally
  }

  private static int getIdentifier(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "attr", paramContext.getPackageName());
  }

  private static void recycleQuietly(@Nullable TypedArray paramTypedArray)
  {
    if (paramTypedArray != null)
      paramTypedArray.recycle();
  }

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, final ReactToolbar paramReactToolbar)
  {
    final EventDispatcher localEventDispatcher = ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
    paramReactToolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localEventDispatcher.dispatchEvent(new ToolbarClickEvent(paramReactToolbar.getId(), -1));
      }
    });
    paramReactToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        localEventDispatcher.dispatchEvent(new ToolbarClickEvent(paramReactToolbar.getId(), paramAnonymousMenuItem.getOrder()));
        return true;
      }
    });
  }

  protected ReactToolbar createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactToolbar(paramThemedReactContext);
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("dismissPopupMenus", Integer.valueOf(1));
  }

  @Nullable
  public Map<String, Object> getExportedViewConstants()
  {
    return MapBuilder.of("ShowAsAction", MapBuilder.of("never", Integer.valueOf(0), "always", Integer.valueOf(2), "ifRoom", Integer.valueOf(1)));
  }

  public String getName()
  {
    return "ToolbarAndroid";
  }

  public boolean needsCustomLayoutForChildren()
  {
    return true;
  }

  public void receiveCommand(ReactToolbar paramReactToolbar, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default:
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = getClass().getSimpleName();
      throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", arrayOfObject));
    case 1:
    }
    paramReactToolbar.dismissPopupMenus();
  }

  @ReactProp(name="nativeActions")
  public void setActions(ReactToolbar paramReactToolbar, @Nullable ReadableArray paramReadableArray)
  {
    paramReactToolbar.setActions(paramReadableArray);
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="contentInsetEnd")
  public void setContentInsetEnd(ReactToolbar paramReactToolbar, float paramFloat)
  {
    if (Float.isNaN(paramFloat));
    for (int i = getDefaultContentInsets(paramReactToolbar.getContext())[1]; ; i = Math.round(PixelUtil.toPixelFromDIP(paramFloat)))
    {
      paramReactToolbar.setContentInsetsRelative(paramReactToolbar.getContentInsetStart(), i);
      return;
    }
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="contentInsetStart")
  public void setContentInsetStart(ReactToolbar paramReactToolbar, float paramFloat)
  {
    if (Float.isNaN(paramFloat));
    for (int i = getDefaultContentInsets(paramReactToolbar.getContext())[0]; ; i = Math.round(PixelUtil.toPixelFromDIP(paramFloat)))
    {
      paramReactToolbar.setContentInsetsRelative(i, paramReactToolbar.getContentInsetEnd());
      return;
    }
  }

  @ReactProp(name="logo")
  public void setLogo(ReactToolbar paramReactToolbar, @Nullable ReadableMap paramReadableMap)
  {
    paramReactToolbar.setLogoSource(paramReadableMap);
  }

  @ReactProp(name="navIcon")
  public void setNavIcon(ReactToolbar paramReactToolbar, @Nullable ReadableMap paramReadableMap)
  {
    paramReactToolbar.setNavIconSource(paramReadableMap);
  }

  @ReactProp(name="overflowIcon")
  public void setOverflowIcon(ReactToolbar paramReactToolbar, @Nullable ReadableMap paramReadableMap)
  {
    paramReactToolbar.setOverflowIconSource(paramReadableMap);
  }

  @ReactProp(name="rtl")
  public void setRtl(ReactToolbar paramReactToolbar, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      ViewCompat.setLayoutDirection(paramReactToolbar, i);
      return;
    }
  }

  @ReactProp(name="subtitle")
  public void setSubtitle(ReactToolbar paramReactToolbar, @Nullable String paramString)
  {
    paramReactToolbar.setSubtitle(paramString);
  }

  @ReactProp(customType="Color", name="subtitleColor")
  public void setSubtitleColor(ReactToolbar paramReactToolbar, @Nullable Integer paramInteger)
  {
    int[] arrayOfInt = getDefaultColors(paramReactToolbar.getContext());
    if (paramInteger != null)
    {
      paramReactToolbar.setSubtitleTextColor(paramInteger.intValue());
      return;
    }
    paramReactToolbar.setSubtitleTextColor(arrayOfInt[1]);
  }

  @ReactProp(name="title")
  public void setTitle(ReactToolbar paramReactToolbar, @Nullable String paramString)
  {
    paramReactToolbar.setTitle(paramString);
  }

  @ReactProp(customType="Color", name="titleColor")
  public void setTitleColor(ReactToolbar paramReactToolbar, @Nullable Integer paramInteger)
  {
    int[] arrayOfInt = getDefaultColors(paramReactToolbar.getContext());
    if (paramInteger != null)
    {
      paramReactToolbar.setTitleTextColor(paramInteger.intValue());
      return;
    }
    paramReactToolbar.setTitleTextColor(arrayOfInt[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.toolbar.ReactToolbarManager
 * JD-Core Version:    0.6.2
 */
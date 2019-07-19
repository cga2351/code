package com.facebook.react.views.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.MeasureSpec;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import javax.annotation.Nullable;

public class ReactToolbar extends Toolbar
{
  private static final String PROP_ACTION_ICON = "icon";
  private static final String PROP_ACTION_SHOW = "show";
  private static final String PROP_ACTION_SHOW_WITH_TEXT = "showWithText";
  private static final String PROP_ACTION_TITLE = "title";
  private static final String PROP_ICON_HEIGHT = "height";
  private static final String PROP_ICON_URI = "uri";
  private static final String PROP_ICON_WIDTH = "width";
  private final MultiDraweeHolder<GenericDraweeHierarchy> mActionsHolder = new MultiDraweeHolder();
  private final Runnable mLayoutRunnable = new Runnable()
  {
    public void run()
    {
      ReactToolbar.this.measure(View.MeasureSpec.makeMeasureSpec(ReactToolbar.this.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ReactToolbar.this.getHeight(), 1073741824));
      ReactToolbar.this.layout(ReactToolbar.this.getLeft(), ReactToolbar.this.getTop(), ReactToolbar.this.getRight(), ReactToolbar.this.getBottom());
    }
  };
  private IconControllerListener mLogoControllerListener;
  private final DraweeHolder mLogoHolder;
  private IconControllerListener mNavIconControllerListener;
  private final DraweeHolder mNavIconHolder;
  private IconControllerListener mOverflowIconControllerListener;
  private final DraweeHolder mOverflowIconHolder;

  public ReactToolbar(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 43	android/support/v7/widget/Toolbar:<init>	(Landroid/content/Context;)V
    //   5: aload_0
    //   6: new 45	com/facebook/drawee/view/MultiDraweeHolder
    //   9: dup
    //   10: invokespecial 48	com/facebook/drawee/view/MultiDraweeHolder:<init>	()V
    //   13: putfield 50	com/facebook/react/views/toolbar/ReactToolbar:mActionsHolder	Lcom/facebook/drawee/view/MultiDraweeHolder;
    //   16: aload_0
    //   17: new 52	com/facebook/react/views/toolbar/ReactToolbar$4
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 55	com/facebook/react/views/toolbar/ReactToolbar$4:<init>	(Lcom/facebook/react/views/toolbar/ReactToolbar;)V
    //   25: putfield 57	com/facebook/react/views/toolbar/ReactToolbar:mLayoutRunnable	Ljava/lang/Runnable;
    //   28: aload_0
    //   29: aload_0
    //   30: invokespecial 61	com/facebook/react/views/toolbar/ReactToolbar:createDraweeHierarchy	()Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    //   33: aload_1
    //   34: invokestatic 67	com/facebook/drawee/view/DraweeHolder:create	(Lcom/facebook/drawee/interfaces/DraweeHierarchy;Landroid/content/Context;)Lcom/facebook/drawee/view/DraweeHolder;
    //   37: putfield 69	com/facebook/react/views/toolbar/ReactToolbar:mLogoHolder	Lcom/facebook/drawee/view/DraweeHolder;
    //   40: aload_0
    //   41: aload_0
    //   42: invokespecial 61	com/facebook/react/views/toolbar/ReactToolbar:createDraweeHierarchy	()Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    //   45: aload_1
    //   46: invokestatic 67	com/facebook/drawee/view/DraweeHolder:create	(Lcom/facebook/drawee/interfaces/DraweeHierarchy;Landroid/content/Context;)Lcom/facebook/drawee/view/DraweeHolder;
    //   49: putfield 71	com/facebook/react/views/toolbar/ReactToolbar:mNavIconHolder	Lcom/facebook/drawee/view/DraweeHolder;
    //   52: aload_0
    //   53: aload_0
    //   54: invokespecial 61	com/facebook/react/views/toolbar/ReactToolbar:createDraweeHierarchy	()Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    //   57: aload_1
    //   58: invokestatic 67	com/facebook/drawee/view/DraweeHolder:create	(Lcom/facebook/drawee/interfaces/DraweeHierarchy;Landroid/content/Context;)Lcom/facebook/drawee/view/DraweeHolder;
    //   61: putfield 73	com/facebook/react/views/toolbar/ReactToolbar:mOverflowIconHolder	Lcom/facebook/drawee/view/DraweeHolder;
    //   64: aload_0
    //   65: new 75	com/facebook/react/views/toolbar/ReactToolbar$1
    //   68: dup
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 69	com/facebook/react/views/toolbar/ReactToolbar:mLogoHolder	Lcom/facebook/drawee/view/DraweeHolder;
    //   74: invokespecial 78	com/facebook/react/views/toolbar/ReactToolbar$1:<init>	(Lcom/facebook/react/views/toolbar/ReactToolbar;Lcom/facebook/drawee/view/DraweeHolder;)V
    //   77: putfield 80	com/facebook/react/views/toolbar/ReactToolbar:mLogoControllerListener	Lcom/facebook/react/views/toolbar/ReactToolbar$IconControllerListener;
    //   80: aload_0
    //   81: new 82	com/facebook/react/views/toolbar/ReactToolbar$2
    //   84: dup
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 71	com/facebook/react/views/toolbar/ReactToolbar:mNavIconHolder	Lcom/facebook/drawee/view/DraweeHolder;
    //   90: invokespecial 83	com/facebook/react/views/toolbar/ReactToolbar$2:<init>	(Lcom/facebook/react/views/toolbar/ReactToolbar;Lcom/facebook/drawee/view/DraweeHolder;)V
    //   93: putfield 85	com/facebook/react/views/toolbar/ReactToolbar:mNavIconControllerListener	Lcom/facebook/react/views/toolbar/ReactToolbar$IconControllerListener;
    //   96: aload_0
    //   97: new 87	com/facebook/react/views/toolbar/ReactToolbar$3
    //   100: dup
    //   101: aload_0
    //   102: aload_0
    //   103: getfield 73	com/facebook/react/views/toolbar/ReactToolbar:mOverflowIconHolder	Lcom/facebook/drawee/view/DraweeHolder;
    //   106: invokespecial 88	com/facebook/react/views/toolbar/ReactToolbar$3:<init>	(Lcom/facebook/react/views/toolbar/ReactToolbar;Lcom/facebook/drawee/view/DraweeHolder;)V
    //   109: putfield 90	com/facebook/react/views/toolbar/ReactToolbar:mOverflowIconControllerListener	Lcom/facebook/react/views/toolbar/ReactToolbar$IconControllerListener;
    //   112: return
  }

  private void attachDraweeHolders()
  {
    this.mLogoHolder.onAttach();
    this.mNavIconHolder.onAttach();
    this.mOverflowIconHolder.onAttach();
    this.mActionsHolder.onAttach();
  }

  private GenericDraweeHierarchy createDraweeHierarchy()
  {
    return new GenericDraweeHierarchyBuilder(getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0).build();
  }

  private void detachDraweeHolders()
  {
    this.mLogoHolder.onDetach();
    this.mNavIconHolder.onDetach();
    this.mOverflowIconHolder.onDetach();
    this.mActionsHolder.onDetach();
  }

  private Drawable getDrawableByName(String paramString)
  {
    if (getDrawableResourceByName(paramString) != 0)
      return getResources().getDrawable(getDrawableResourceByName(paramString));
    return null;
  }

  private int getDrawableResourceByName(String paramString)
  {
    return getResources().getIdentifier(paramString, "drawable", getContext().getPackageName());
  }

  private IconImageInfo getIconImageInfo(ReadableMap paramReadableMap)
  {
    if ((paramReadableMap.hasKey("width")) && (paramReadableMap.hasKey("height")))
      return new IconImageInfo(Math.round(PixelUtil.toPixelFromDIP(paramReadableMap.getInt("width"))), Math.round(PixelUtil.toPixelFromDIP(paramReadableMap.getInt("height"))));
    return null;
  }

  private void setIconSource(ReadableMap paramReadableMap, IconControllerListener paramIconControllerListener, DraweeHolder paramDraweeHolder)
  {
    if (paramReadableMap != null);
    for (String str = paramReadableMap.getString("uri"); str == null; str = null)
    {
      paramIconControllerListener.setIconImageInfo(null);
      paramIconControllerListener.setDrawable(null);
      return;
    }
    if ((str.startsWith("http://")) || (str.startsWith("https://")) || (str.startsWith("file://")))
    {
      paramIconControllerListener.setIconImageInfo(getIconImageInfo(paramReadableMap));
      paramDraweeHolder.setController(((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setUri(Uri.parse(str)).setControllerListener(paramIconControllerListener)).setOldController(paramDraweeHolder.getController())).build());
      paramDraweeHolder.getTopLevelDrawable().setVisible(true, true);
      return;
    }
    paramIconControllerListener.setDrawable(getDrawableByName(str));
  }

  private void setMenuItemIcon(MenuItem paramMenuItem, ReadableMap paramReadableMap)
  {
    DraweeHolder localDraweeHolder = DraweeHolder.create(createDraweeHierarchy(), getContext());
    ActionIconControllerListener localActionIconControllerListener = new ActionIconControllerListener(paramMenuItem, localDraweeHolder);
    localActionIconControllerListener.setIconImageInfo(getIconImageInfo(paramReadableMap));
    setIconSource(paramReadableMap, localActionIconControllerListener, localDraweeHolder);
    this.mActionsHolder.add(localDraweeHolder);
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    attachDraweeHolders();
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    detachDraweeHolders();
  }

  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    attachDraweeHolders();
  }

  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    detachDraweeHolders();
  }

  public void requestLayout()
  {
    super.requestLayout();
    post(this.mLayoutRunnable);
  }

  void setActions(@Nullable ReadableArray paramReadableArray)
  {
    Menu localMenu = getMenu();
    localMenu.clear();
    this.mActionsHolder.clear();
    if (paramReadableArray != null)
    {
      int i = 0;
      if (i < paramReadableArray.size())
      {
        ReadableMap localReadableMap = paramReadableArray.getMap(i);
        MenuItem localMenuItem = localMenu.add(0, 0, i, localReadableMap.getString("title"));
        if (localReadableMap.hasKey("icon"))
          setMenuItemIcon(localMenuItem, localReadableMap.getMap("icon"));
        if (localReadableMap.hasKey("show"));
        for (int j = localReadableMap.getInt("show"); ; j = 0)
        {
          if ((localReadableMap.hasKey("showWithText")) && (localReadableMap.getBoolean("showWithText")))
            j |= 4;
          localMenuItem.setShowAsAction(j);
          i++;
          break;
        }
      }
    }
  }

  void setLogoSource(@Nullable ReadableMap paramReadableMap)
  {
    setIconSource(paramReadableMap, this.mLogoControllerListener, this.mLogoHolder);
  }

  void setNavIconSource(@Nullable ReadableMap paramReadableMap)
  {
    setIconSource(paramReadableMap, this.mNavIconControllerListener, this.mNavIconHolder);
  }

  void setOverflowIconSource(@Nullable ReadableMap paramReadableMap)
  {
    setIconSource(paramReadableMap, this.mOverflowIconControllerListener, this.mOverflowIconHolder);
  }

  private class ActionIconControllerListener extends ReactToolbar.IconControllerListener
  {
    private final MenuItem mItem;

    ActionIconControllerListener(MenuItem paramDraweeHolder, DraweeHolder arg3)
    {
      super(localDraweeHolder);
      this.mItem = paramDraweeHolder;
    }

    protected void setDrawable(Drawable paramDrawable)
    {
      this.mItem.setIcon(paramDrawable);
      ReactToolbar.this.requestLayout();
    }
  }

  private abstract class IconControllerListener extends BaseControllerListener<ImageInfo>
  {
    private final DraweeHolder mHolder;
    private ReactToolbar.IconImageInfo mIconImageInfo;

    public IconControllerListener(DraweeHolder arg2)
    {
      Object localObject;
      this.mHolder = localObject;
    }

    public void onFinalImageSet(String paramString, @Nullable ImageInfo paramImageInfo, @Nullable Animatable paramAnimatable)
    {
      super.onFinalImageSet(paramString, paramImageInfo, paramAnimatable);
      if (this.mIconImageInfo != null)
        paramImageInfo = this.mIconImageInfo;
      setDrawable(new DrawableWithIntrinsicSize(this.mHolder.getTopLevelDrawable(), paramImageInfo));
    }

    protected abstract void setDrawable(Drawable paramDrawable);

    public void setIconImageInfo(ReactToolbar.IconImageInfo paramIconImageInfo)
    {
      this.mIconImageInfo = paramIconImageInfo;
    }
  }

  private static class IconImageInfo
    implements ImageInfo
  {
    private int mHeight;
    private int mWidth;

    public IconImageInfo(int paramInt1, int paramInt2)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }

    public int getHeight()
    {
      return this.mHeight;
    }

    public QualityInfo getQualityInfo()
    {
      return null;
    }

    public int getWidth()
    {
      return this.mWidth;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.toolbar.ReactToolbar
 * JD-Core Version:    0.6.2
 */
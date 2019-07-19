package com.facebook.react.views.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.picker.events.PickerItemSelectEvent;
import javax.annotation.Nullable;

public abstract class ReactPickerManager extends SimpleViewManager<ReactPicker>
{
  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactPicker paramReactPicker)
  {
    paramReactPicker.setOnSelectListener(new PickerEventEmitter(paramReactPicker, ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
  }

  protected void onAfterUpdateTransaction(ReactPicker paramReactPicker)
  {
    super.onAfterUpdateTransaction(paramReactPicker);
    paramReactPicker.updateStagedSelection();
  }

  @ReactProp(customType="Color", name="color")
  public void setColor(ReactPicker paramReactPicker, @Nullable Integer paramInteger)
  {
    paramReactPicker.setPrimaryColor(paramInteger);
    ReactPickerAdapter localReactPickerAdapter = (ReactPickerAdapter)paramReactPicker.getAdapter();
    if (localReactPickerAdapter != null)
      localReactPickerAdapter.setPrimaryTextColor(paramInteger);
  }

  @ReactProp(defaultBoolean=true, name="enabled")
  public void setEnabled(ReactPicker paramReactPicker, boolean paramBoolean)
  {
    paramReactPicker.setEnabled(paramBoolean);
  }

  @ReactProp(name="items")
  public void setItems(ReactPicker paramReactPicker, @Nullable ReadableArray paramReadableArray)
  {
    if (paramReadableArray != null)
    {
      ReadableMap[] arrayOfReadableMap = new ReadableMap[paramReadableArray.size()];
      for (int i = 0; i < paramReadableArray.size(); i++)
        arrayOfReadableMap[i] = paramReadableArray.getMap(i);
      ReactPickerAdapter localReactPickerAdapter = new ReactPickerAdapter(paramReactPicker.getContext(), arrayOfReadableMap);
      localReactPickerAdapter.setPrimaryTextColor(paramReactPicker.getPrimaryColor());
      paramReactPicker.setAdapter(localReactPickerAdapter);
      return;
    }
    paramReactPicker.setAdapter(null);
  }

  @ReactProp(name="prompt")
  public void setPrompt(ReactPicker paramReactPicker, @Nullable String paramString)
  {
    paramReactPicker.setPrompt(paramString);
  }

  @ReactProp(name="selected")
  public void setSelected(ReactPicker paramReactPicker, int paramInt)
  {
    paramReactPicker.setStagedSelection(paramInt);
  }

  private static class PickerEventEmitter
    implements ReactPicker.OnSelectListener
  {
    private final EventDispatcher mEventDispatcher;
    private final ReactPicker mReactPicker;

    public PickerEventEmitter(ReactPicker paramReactPicker, EventDispatcher paramEventDispatcher)
    {
      this.mReactPicker = paramReactPicker;
      this.mEventDispatcher = paramEventDispatcher;
    }

    public void onItemSelected(int paramInt)
    {
      this.mEventDispatcher.dispatchEvent(new PickerItemSelectEvent(this.mReactPicker.getId(), paramInt));
    }
  }

  private static class ReactPickerAdapter extends ArrayAdapter<ReadableMap>
  {
    private final LayoutInflater mInflater;

    @Nullable
    private Integer mPrimaryTextColor;

    public ReactPickerAdapter(Context paramContext, ReadableMap[] paramArrayOfReadableMap)
    {
      super(0, paramArrayOfReadableMap);
      this.mInflater = ((LayoutInflater)Assertions.assertNotNull(paramContext.getSystemService("layout_inflater")));
    }

    private View getView(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
    {
      ReadableMap localReadableMap = (ReadableMap)getItem(paramInt);
      int i;
      if (paramView == null)
        if (paramBoolean)
          i = 17367049;
      for (View localView = this.mInflater.inflate(i, paramViewGroup, false); ; localView = paramView)
      {
        TextView localTextView = (TextView)localView;
        localTextView.setText(localReadableMap.getString("label"));
        if ((!paramBoolean) && (this.mPrimaryTextColor != null))
          localTextView.setTextColor(this.mPrimaryTextColor.intValue());
        while ((!localReadableMap.hasKey("color")) || (localReadableMap.isNull("color")))
        {
          return localView;
          i = 17367048;
          break;
        }
        localTextView.setTextColor(localReadableMap.getInt("color"));
        return localView;
      }
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getView(paramInt, paramView, paramViewGroup, true);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getView(paramInt, paramView, paramViewGroup, false);
    }

    public void setPrimaryTextColor(@Nullable Integer paramInteger)
    {
      this.mPrimaryTextColor = paramInteger;
      notifyDataSetChanged();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.picker.ReactPickerManager
 * JD-Core Version:    0.6.2
 */
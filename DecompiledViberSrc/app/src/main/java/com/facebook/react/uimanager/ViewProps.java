package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import java.util.Arrays;
import java.util.HashSet;

public class ViewProps
{
  public static final String ALIGN_CONTENT = "alignContent";
  public static final String ALIGN_ITEMS = "alignItems";
  public static final String ALIGN_SELF = "alignSelf";
  public static final String ALLOW_FONT_SCALING = "allowFontScaling";
  public static final String ASPECT_RATIO = "aspectRatio";
  public static final String AUTO = "auto";
  public static final String BACKGROUND_COLOR = "backgroundColor";
  public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";
  public static final String BORDER_BOTTOM_END_RADIUS = "borderBottomEndRadius";
  public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
  public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
  public static final String BORDER_BOTTOM_START_RADIUS = "borderBottomStartRadius";
  public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
  public static final String BORDER_COLOR = "borderColor";
  public static final String BORDER_END_COLOR = "borderEndColor";
  public static final String BORDER_END_WIDTH = "borderEndWidth";
  public static final String BORDER_LEFT_COLOR = "borderLeftColor";
  public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
  public static final String BORDER_RADIUS = "borderRadius";
  public static final String BORDER_RIGHT_COLOR = "borderRightColor";
  public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
  public static final int[] BORDER_SPACING_TYPES = { 8, 4, 5, 1, 3, 0, 2 };
  public static final String BORDER_START_COLOR = "borderStartColor";
  public static final String BORDER_START_WIDTH = "borderStartWidth";
  public static final String BORDER_TOP_COLOR = "borderTopColor";
  public static final String BORDER_TOP_END_RADIUS = "borderTopEndRadius";
  public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
  public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
  public static final String BORDER_TOP_START_RADIUS = "borderTopStartRadius";
  public static final String BORDER_TOP_WIDTH = "borderTopWidth";
  public static final String BORDER_WIDTH = "borderWidth";
  public static final String BOTTOM = "bottom";
  public static final String BOX_NONE = "box-none";
  public static final String COLLAPSABLE = "collapsable";
  public static final String COLOR = "color";
  public static final String DISPLAY = "display";
  public static final String ELLIPSIZE_MODE = "ellipsizeMode";
  public static final String ENABLED = "enabled";
  public static final String END = "end";
  public static final String FLEX = "flex";
  public static final String FLEX_BASIS = "flexBasis";
  public static final String FLEX_DIRECTION = "flexDirection";
  public static final String FLEX_GROW = "flexGrow";
  public static final String FLEX_SHRINK = "flexShrink";
  public static final String FLEX_WRAP = "flexWrap";
  public static final String FONT_FAMILY = "fontFamily";
  public static final String FONT_SIZE = "fontSize";
  public static final String FONT_STYLE = "fontStyle";
  public static final String FONT_WEIGHT = "fontWeight";
  public static final String HEIGHT = "height";
  public static final String HIDDEN = "hidden";
  public static final String INCLUDE_FONT_PADDING = "includeFontPadding";
  public static final String JUSTIFY_CONTENT = "justifyContent";
  private static final HashSet<String> LAYOUT_ONLY_PROPS = new HashSet(Arrays.asList(new String[] { "alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd" }));
  public static final String LEFT = "left";
  public static final String LETTER_SPACING = "letterSpacing";
  public static final String LINE_HEIGHT = "lineHeight";
  public static final String MARGIN = "margin";
  public static final String MARGIN_BOTTOM = "marginBottom";
  public static final String MARGIN_END = "marginEnd";
  public static final String MARGIN_HORIZONTAL = "marginHorizontal";
  public static final String MARGIN_LEFT = "marginLeft";
  public static final String MARGIN_RIGHT = "marginRight";
  public static final String MARGIN_START = "marginStart";
  public static final String MARGIN_TOP = "marginTop";
  public static final String MARGIN_VERTICAL = "marginVertical";
  public static final String MAX_FONT_SIZE_MULTIPLIER = "maxFontSizeMultiplier";
  public static final String MAX_HEIGHT = "maxHeight";
  public static final String MAX_WIDTH = "maxWidth";
  public static final String MIN_HEIGHT = "minHeight";
  public static final String MIN_WIDTH = "minWidth";
  public static final String NEEDS_OFFSCREEN_ALPHA_COMPOSITING = "needsOffscreenAlphaCompositing";
  public static final String NONE = "none";
  public static final String NUMBER_OF_LINES = "numberOfLines";
  public static final String ON = "on";
  public static final String ON_LAYOUT = "onLayout";
  public static final String OPACITY = "opacity";
  public static final String OVERFLOW = "overflow";
  public static final String PADDING = "padding";
  public static final String PADDING_BOTTOM = "paddingBottom";
  public static final String PADDING_END = "paddingEnd";
  public static final String PADDING_HORIZONTAL = "paddingHorizontal";
  public static final String PADDING_LEFT = "paddingLeft";
  public static final int[] PADDING_MARGIN_SPACING_TYPES = { 8, 7, 6, 4, 5, 1, 3, 0, 2 };
  public static final String PADDING_RIGHT = "paddingRight";
  public static final String PADDING_START = "paddingStart";
  public static final String PADDING_TOP = "paddingTop";
  public static final String PADDING_VERTICAL = "paddingVertical";
  public static final String POINTER_EVENTS = "pointerEvents";
  public static final String POSITION = "position";
  public static final int[] POSITION_SPACING_TYPES = { 4, 5, 1, 3 };
  public static final String RESIZE_METHOD = "resizeMethod";
  public static final String RESIZE_MODE = "resizeMode";
  public static final String RIGHT = "right";
  public static final String SCROLL = "scroll";
  public static final String START = "start";
  public static final String TEXT_ALIGN = "textAlign";
  public static final String TEXT_ALIGN_VERTICAL = "textAlignVertical";
  public static final String TEXT_BREAK_STRATEGY = "textBreakStrategy";
  public static final String TEXT_DECORATION_LINE = "textDecorationLine";
  public static final String TOP = "top";
  public static final String VIEW_CLASS_NAME = "RCTView";
  public static final String VISIBLE = "visible";
  public static final String WIDTH = "width";

  public static boolean isLayoutOnly(ReadableMap paramReadableMap, String paramString)
  {
    int i = 1;
    boolean bool2;
    if (LAYOUT_ONLY_PROPS.contains(paramString))
      bool2 = i;
    label15: label66: boolean bool1;
    do
    {
      boolean bool3;
      do
      {
        boolean bool4;
        do
        {
          boolean bool5;
          do
          {
            boolean bool6;
            do
            {
              boolean bool7;
              do
              {
                boolean bool8;
                do
                {
                  int k;
                  do
                  {
                    boolean bool10;
                    do
                    {
                      return bool2;
                      if (!"pointerEvents".equals(paramString))
                        break label66;
                      String str = paramReadableMap.getString(paramString);
                      if ("auto".equals(str))
                        break;
                      bool10 = "box-none".equals(str);
                      bool2 = false;
                    }
                    while (!bool10);
                    return i;
                    int j = -1;
                    switch (paramString.hashCode())
                    {
                    default:
                    case -1267206133:
                    case 1349188574:
                    case -242276144:
                    case -1989576717:
                    case -1470826662:
                    case -1308858324:
                    case 741115130:
                    case -223992013:
                    case -1452542531:
                    case -1971292586:
                    case -1290574193:
                    case 529642498:
                    }
                    while (true)
                      switch (j)
                      {
                      default:
                        return false;
                      case 0:
                        if (!paramReadableMap.isNull("opacity"))
                        {
                          boolean bool9 = paramReadableMap.getDouble("opacity") < 1.0D;
                          bool2 = false;
                          if (bool9)
                            break label15;
                        }
                        return i;
                        if (paramString.equals("opacity"))
                        {
                          j = 0;
                          continue;
                          if (paramString.equals("borderRadius"))
                          {
                            j = i;
                            continue;
                            if (paramString.equals("borderLeftColor"))
                            {
                              j = 2;
                              continue;
                              if (paramString.equals("borderRightColor"))
                              {
                                j = 3;
                                continue;
                                if (paramString.equals("borderTopColor"))
                                {
                                  j = 4;
                                  continue;
                                  if (paramString.equals("borderBottomColor"))
                                  {
                                    j = 5;
                                    continue;
                                    if (paramString.equals("borderWidth"))
                                    {
                                      j = 6;
                                      continue;
                                      if (paramString.equals("borderLeftWidth"))
                                      {
                                        j = 7;
                                        continue;
                                        if (paramString.equals("borderTopWidth"))
                                        {
                                          j = 8;
                                          continue;
                                          if (paramString.equals("borderRightWidth"))
                                          {
                                            j = 9;
                                            continue;
                                            if (paramString.equals("borderBottomWidth"))
                                            {
                                              j = 10;
                                              continue;
                                              if (paramString.equals("overflow"))
                                                j = 11;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                        break;
                      case 1:
                      case 2:
                      case 3:
                      case 4:
                      case 5:
                      case 6:
                      case 7:
                      case 8:
                      case 9:
                      case 10:
                      case 11:
                      }
                    if (!paramReadableMap.hasKey("backgroundColor"))
                      break;
                    k = paramReadableMap.getInt("backgroundColor");
                    bool2 = false;
                  }
                  while (k != 0);
                  if ((!paramReadableMap.hasKey("borderWidth")) || (paramReadableMap.isNull("borderWidth")))
                    break;
                  bool8 = paramReadableMap.getDouble("borderWidth") < 0.0D;
                  bool2 = false;
                }
                while (bool8);
                return i;
                if (paramReadableMap.getInt("borderLeftColor") == 0);
                while (true)
                {
                  return i;
                  i = 0;
                }
                if (paramReadableMap.getInt("borderRightColor") == 0);
                while (true)
                {
                  return i;
                  i = 0;
                }
                if (paramReadableMap.getInt("borderTopColor") == 0);
                while (true)
                {
                  return i;
                  i = 0;
                }
                if (paramReadableMap.getInt("borderBottomColor") == 0);
                while (true)
                {
                  return i;
                  i = 0;
                }
                if (paramReadableMap.isNull("borderWidth"))
                  break;
                bool7 = paramReadableMap.getDouble("borderWidth") < 0.0D;
                bool2 = false;
              }
              while (bool7);
              return i;
              if (paramReadableMap.isNull("borderLeftWidth"))
                break;
              bool6 = paramReadableMap.getDouble("borderLeftWidth") < 0.0D;
              bool2 = false;
            }
            while (bool6);
            return i;
            if (paramReadableMap.isNull("borderTopWidth"))
              break;
            bool5 = paramReadableMap.getDouble("borderTopWidth") < 0.0D;
            bool2 = false;
          }
          while (bool5);
          return i;
          if (paramReadableMap.isNull("borderRightWidth"))
            break;
          bool4 = paramReadableMap.getDouble("borderRightWidth") < 0.0D;
          bool2 = false;
        }
        while (bool4);
        return i;
        if (paramReadableMap.isNull("borderBottomWidth"))
          break;
        bool3 = paramReadableMap.getDouble("borderBottomWidth") < 0.0D;
        bool2 = false;
      }
      while (bool3);
      return i;
      if (paramReadableMap.isNull("overflow"))
        break;
      bool1 = "visible".equals(paramReadableMap.getString("overflow"));
      bool2 = false;
    }
    while (!bool1);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewProps
 * JD-Core Version:    0.6.2
 */
package com.viber.svg.jni;

import java.io.PrintStream;

public class SvgRenderer
{
  protected static final int BYTES_BUFFER_SIZE = 1024;
  protected static final int DOUBLES_BUFFER_SIZE = 1024;
  protected static final int FLOATS_BUFFER_SIZE = 1024;
  protected static final int INTS_BUFFER_SIZE = 1024;
  protected static final byte OP_ARC_TO = 18;
  protected static final byte OP_BATCH_END = 45;
  protected static final byte OP_BEGIN_ELEMENT = 8;
  protected static final byte OP_BEGIN_LAYER = 10;
  protected static final byte OP_BEGIN_MASK = 12;
  protected static final byte OP_BEGIN_PICTURE = 42;
  protected static final byte OP_BEGIN_PICTURES = 40;
  protected static final byte OP_BEGIN_PREPARE = 1;
  protected static final byte OP_BEGIN_PREPARED_PATH = 5;
  protected static final byte OP_BEGIN_RENDER = 3;
  protected static final byte OP_CLOSE_PATH = 19;
  protected static final byte OP_CONCAT_MATRIX = 35;
  protected static final byte OP_CURVE_TO = 16;
  protected static final byte OP_END_ELEMENT = 9;
  protected static final byte OP_END_LAYER = 11;
  protected static final byte OP_END_MASK = 13;
  protected static final byte OP_END_PICTURE = 43;
  protected static final byte OP_END_PICTURES = 41;
  protected static final byte OP_END_PREPARE = 2;
  protected static final byte OP_END_PREPARED_PATH = 6;
  protected static final byte OP_END_RENDER = 4;
  protected static final byte OP_LINE_TO = 15;
  protected static final byte OP_MOVE_TO = 14;
  protected static final String[] OP_NAMES = { "OP_BEGIN_PREPARE", "OP_END_PREPARE", "OP_BEGIN_RENDER", "OP_END_RENDER", "OP_BEGIN_PREPARED_PATH", "OP_END_PREPARED_PATH", "OP_RENDER_PREPARED_PATH", "OP_BEGIN_ELEMENT", "OP_END_ELEMENT", "OP_BEGIN_LAYER", "OP_END_LAYER", "OP_BEGIN_MASK", "OP_END_MASK", "OP_MOVE_TO", "OP_LINE_TO", "OP_CURVE_TO", "OP_QUADRATIC_CURVE_TO", "OP_ARC_TO", "OP_CLOSE_PATH", "OP_SET_CURRENT_COLOR", "OP_SET_NONE_PAINT", "OP_SET_CURRENT_COLOR_PAINT", "OP_SET_COLOR_PAINT", "OP_SET_OR_PREPARE_GRADIENT_PAINT", "OP_SET_PREPARED_GRADIENT_PAINT", "OP_SET_FILL_OPACITY", "OP_SET_FILL_RULE", "OP_SET_STROKE_OPACITY", "OP_SET_STROKE_WIDTH", "OP_SET_STROKE_LINE_CAP", "OP_SET_STROKE_LINE_JOIN", "OP_SET_STROKE_MITER_LIMIT", "OP_SET_STROKE_DASH_ARRAY", "OP_SET_STROKE_DASH_OFFSET", "OP_CONCAT_MATRIX", "OP_RENDER_LINE", "OP_RENDER_PATH", "OP_RENDER_ELLIPSE", "OP_RENDER_RECT", "OP_BEGIN_PICTURES", "OP_END_PICTURES", "OP_BEGIN_PICTURE", "OP_END_PICTURE", "OP_RENDER_PICTURE", "OP_BATCH_END" };
  protected static final byte OP_QUADRATIC_CURVE_TO = 17;
  protected static final byte OP_RENDER_ELLIPSE = 38;
  protected static final byte OP_RENDER_LINE = 36;
  protected static final byte OP_RENDER_PATH = 37;
  protected static final byte OP_RENDER_PICTURE = 44;
  protected static final byte OP_RENDER_PREPARED_PATH = 7;
  protected static final byte OP_RENDER_RECT = 39;
  protected static final byte OP_SET_COLOR_PAINT = 23;
  protected static final byte OP_SET_CURRENT_COLOR = 20;
  protected static final byte OP_SET_CURRENT_COLOR_PAINT = 22;
  protected static final byte OP_SET_FILL_OPACITY = 26;
  protected static final byte OP_SET_FILL_RULE = 27;
  protected static final byte OP_SET_NONE_PAINT = 21;
  protected static final byte OP_SET_OR_PREPARE_GRADIENT_PAINT = 24;
  protected static final byte OP_SET_PREPARED_GRADIENT_PAINT = 25;
  protected static final byte OP_SET_STROKE_DASH_ARRAY = 33;
  protected static final byte OP_SET_STROKE_DASH_OFFSET = 34;
  protected static final byte OP_SET_STROKE_LINE_CAP = 30;
  protected static final byte OP_SET_STROKE_LINE_JOIN = 31;
  protected static final byte OP_SET_STROKE_MITER_LIMIT = 32;
  protected static final byte OP_SET_STROKE_OPACITY = 28;
  protected static final byte OP_SET_STROKE_WIDTH = 29;
  protected byte[] bytes;
  protected double[] doubles;
  protected int flags;
  protected float[] floats;
  protected int[] ints;
  protected int prepareViewportHeight;
  protected int prepareViewportWidth;
  protected String svgId;

  SvgRenderer(int paramInt)
  {
    this.flags = paramInt;
    initBatchArrays();
  }

  int getPrepareFlags(String paramString)
  {
    this.svgId = paramString;
    return 0;
  }

  protected void initBatchArrays()
  {
    this.bytes = new byte[1024];
    this.ints = new int[1024];
    this.doubles = new double[1024];
    this.floats = new float[1024];
  }

  protected void processBatch()
  {
    System.err.println("processBatch() dummy implementation called");
  }

  void setPrepareViewportSize(int paramInt1, int paramInt2)
  {
    this.prepareViewportWidth = paramInt1;
    this.prepareViewportHeight = paramInt2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SvgRenderer
 * JD-Core Version:    0.6.2
 */
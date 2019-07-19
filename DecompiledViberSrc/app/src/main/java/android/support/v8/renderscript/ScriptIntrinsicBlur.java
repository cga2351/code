package android.support.v8.renderscript;

import android.os.Build.VERSION;

public class ScriptIntrinsicBlur extends ScriptIntrinsic
{
  private static final int INTRINSIC_API_LEVEL = 19;
  private Allocation mInput;
  private final float[] mValues = new float[9];

  protected ScriptIntrinsicBlur(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public static ScriptIntrinsicBlur create(RenderScript paramRenderScript, Element paramElement)
  {
    if ((!paramElement.isCompatible(Element.U8_4(paramRenderScript))) && (!paramElement.isCompatible(Element.U8(paramRenderScript))))
      throw new RSIllegalArgumentException("Unsupported element type.");
    if ((paramRenderScript.isUseNative()) && (Build.VERSION.SDK_INT < 19));
    for (boolean bool = true; ; bool = false)
    {
      ScriptIntrinsicBlur localScriptIntrinsicBlur = new ScriptIntrinsicBlur(paramRenderScript.nScriptIntrinsicCreate(5, paramElement.getID(paramRenderScript), bool), paramRenderScript);
      localScriptIntrinsicBlur.setIncSupp(bool);
      localScriptIntrinsicBlur.setRadius(5.0F);
      return localScriptIntrinsicBlur;
    }
  }

  public void forEach(Allocation paramAllocation)
  {
    if (paramAllocation.getType().getY() == 0)
      throw new RSIllegalArgumentException("Output is a 1D Allocation");
    forEach(0, (Allocation)null, paramAllocation, null);
  }

  public Script.FieldID getFieldID_Input()
  {
    return createFieldID(1, null);
  }

  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 2, null, null);
  }

  public void setInput(Allocation paramAllocation)
  {
    if (paramAllocation.getType().getY() == 0)
      throw new RSIllegalArgumentException("Input set to a 1D Allocation");
    this.mInput = paramAllocation;
    setVar(1, paramAllocation);
  }

  public void setRadius(float paramFloat)
  {
    if ((paramFloat <= 0.0F) || (paramFloat > 25.0F))
      throw new RSIllegalArgumentException("Radius out of range (0 < r <= 25).");
    setVar(0, paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicBlur
 * JD-Core Version:    0.6.2
 */
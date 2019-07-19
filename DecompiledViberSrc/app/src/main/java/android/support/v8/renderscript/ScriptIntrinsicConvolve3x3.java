package android.support.v8.renderscript;

import android.os.Build.VERSION;

public class ScriptIntrinsicConvolve3x3 extends ScriptIntrinsic
{
  private static final int INTRINSIC_API_LEVEL = 19;
  private Allocation mInput;
  private final float[] mValues = new float[9];

  ScriptIntrinsicConvolve3x3(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public static ScriptIntrinsicConvolve3x3 create(RenderScript paramRenderScript, Element paramElement)
  {
    float[] arrayOfFloat = { 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    if ((!paramElement.isCompatible(Element.U8(paramRenderScript))) && (!paramElement.isCompatible(Element.U8_2(paramRenderScript))) && (!paramElement.isCompatible(Element.U8_3(paramRenderScript))) && (!paramElement.isCompatible(Element.U8_4(paramRenderScript))) && (!paramElement.isCompatible(Element.F32(paramRenderScript))) && (!paramElement.isCompatible(Element.F32_2(paramRenderScript))) && (!paramElement.isCompatible(Element.F32_3(paramRenderScript))) && (!paramElement.isCompatible(Element.F32_4(paramRenderScript))))
      throw new RSIllegalArgumentException("Unsupported element type.");
    if ((paramRenderScript.isUseNative()) && (Build.VERSION.SDK_INT < 19));
    for (boolean bool = true; ; bool = false)
    {
      ScriptIntrinsicConvolve3x3 localScriptIntrinsicConvolve3x3 = new ScriptIntrinsicConvolve3x3(paramRenderScript.nScriptIntrinsicCreate(1, paramElement.getID(paramRenderScript), bool), paramRenderScript);
      localScriptIntrinsicConvolve3x3.setIncSupp(bool);
      localScriptIntrinsicConvolve3x3.setCoefficients(arrayOfFloat);
      return localScriptIntrinsicConvolve3x3;
    }
  }

  public void forEach(Allocation paramAllocation)
  {
    forEach(0, (Allocation)null, paramAllocation, null);
  }

  public void forEach(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions)
  {
    forEach(0, (Allocation)null, paramAllocation, null, paramLaunchOptions);
  }

  public Script.FieldID getFieldID_Input()
  {
    return createFieldID(1, null);
  }

  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 2, null, null);
  }

  public void setCoefficients(float[] paramArrayOfFloat)
  {
    FieldPacker localFieldPacker = new FieldPacker(36);
    for (int i = 0; i < this.mValues.length; i++)
    {
      this.mValues[i] = paramArrayOfFloat[i];
      localFieldPacker.addF32(this.mValues[i]);
    }
    setVar(0, localFieldPacker);
  }

  public void setInput(Allocation paramAllocation)
  {
    this.mInput = paramAllocation;
    setVar(1, paramAllocation);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicConvolve3x3
 * JD-Core Version:    0.6.2
 */
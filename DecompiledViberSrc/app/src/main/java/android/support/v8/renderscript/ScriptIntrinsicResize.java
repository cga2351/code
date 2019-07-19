package android.support.v8.renderscript;

import android.os.Build.VERSION;

public class ScriptIntrinsicResize extends ScriptIntrinsic
{
  private static final int INTRINSIC_API_LEVEL = 21;
  private Allocation mInput;

  protected ScriptIntrinsicResize(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public static ScriptIntrinsicResize create(RenderScript paramRenderScript)
  {
    if ((paramRenderScript.isUseNative()) && (Build.VERSION.SDK_INT < 21));
    for (boolean bool = true; ; bool = false)
    {
      ScriptIntrinsicResize localScriptIntrinsicResize = new ScriptIntrinsicResize(paramRenderScript.nScriptIntrinsicCreate(12, 0L, bool), paramRenderScript);
      localScriptIntrinsicResize.setIncSupp(bool);
      return localScriptIntrinsicResize;
    }
  }

  public void forEach_bicubic(Allocation paramAllocation)
  {
    if (paramAllocation == this.mInput)
      throw new RSIllegalArgumentException("Output cannot be same as Input.");
    forEach_bicubic(paramAllocation, null);
  }

  public void forEach_bicubic(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions)
  {
    forEach(0, (Allocation)null, paramAllocation, null, paramLaunchOptions);
  }

  public Script.FieldID getFieldID_Input()
  {
    return createFieldID(0, null);
  }

  public Script.KernelID getKernelID_bicubic()
  {
    return createKernelID(0, 2, null, null);
  }

  public void setInput(Allocation paramAllocation)
  {
    Element localElement = paramAllocation.getElement();
    if ((!localElement.isCompatible(Element.U8(this.mRS))) && (!localElement.isCompatible(Element.U8_2(this.mRS))) && (!localElement.isCompatible(Element.U8_3(this.mRS))) && (!localElement.isCompatible(Element.U8_4(this.mRS))) && (!localElement.isCompatible(Element.F32(this.mRS))) && (!localElement.isCompatible(Element.F32_2(this.mRS))) && (!localElement.isCompatible(Element.F32_3(this.mRS))) && (!localElement.isCompatible(Element.F32_4(this.mRS))))
      throw new RSIllegalArgumentException("Unsupported element type.");
    this.mInput = paramAllocation;
    setVar(0, paramAllocation);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicResize
 * JD-Core Version:    0.6.2
 */
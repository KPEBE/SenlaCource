package AssemblyGlasses;

import AssemblyInterfaces.*;

public class AssemblyGlasses implements IAssemblyLine {
  
  ILineStep buildFrameStep;
  ILineStep buildLensStep;
  ILineStep buildTemplesStep;

  public AssemblyGlasses(ILineStep buildFrameStep, ILineStep buildLensStep, ILineStep buildTemplesStep) {
    this.buildFrameStep = buildFrameStep;
    this.buildLensStep = buildLensStep;
    this.buildTemplesStep = buildTemplesStep;
  }
  
  public IProduct assemblyProduct(IProduct product) {
    System.out.println("Start assembly Glasses");

    System.out.println("Building Frame to Glasses");
    IProductPart frame = this.buildFrameStep.buildProductPart();
    System.out.println("Building Lens to Glasses");
    IProductPart lens = this.buildLensStep.buildProductPart();
    System.out.println("Building Temples to Glasses");
    IProductPart temples = this.buildTemplesStep.buildProductPart();

    System.out.println("Installing Frame to Glasses");
    product.installFirstPart(frame);
    System.out.println("Installing Lens to Glasses");
    product.installSecondPart(lens);
    System.out.println("Installing Temples to Glasses");
    product.installThirdPart(temples);

    System.out.println("Finish assembly Glasses");

    return product;
  };
};
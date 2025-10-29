package AssemblyGlasses;

import AssemblyInterfaces.IProduct;
import AssemblyInterfaces.IProductPart;

public class Glasses implements IProduct {

  IProductPart frame;
  IProductPart lens;
  IProductPart temples;

  public void installFirstPart(IProductPart part) {
    this.frame = part;
    System.out.println("Frame Installed");
  };

  public void installSecondPart(IProductPart part) {
    this.lens = part;
    System.out.println("Lens Installed");
  };

  public void installThirdPart(IProductPart part) {
    this.temples = part;
    System.out.println("Temples Installed");
  };
};
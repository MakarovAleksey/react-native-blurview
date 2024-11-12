@objc(BlurViewManager)
class BlurViewManager: RCTViewManager {
    override static func requiresMainQueueSetup() -> Bool {
      return true
    }
    private var blurEffectView: UIVisualEffectView?
  
    @objc var blurType: String = "light" {
      didSet {
        applyBlurEffect()
      }
    }
    
    override init(frame: CGRect) {
      super.init(frame: frame)
      applyBlurEffect()
    }
    
    required init?(coder: NSCoder) {
      super.init(coder: coder)
      applyBlurEffect()
    }
    
    private func applyBlurEffect() {
      blurEffectView?.removeFromSuperview()
      
      let effect: UIBlurEffect.Style
      switch blurType {
      case "dark":
        effect = .dark
      case "extraLight":
        effect = .extraLight
      default:
        effect = .light
      }
    override func view() -> (BlurView) {
      let blurView = BlurView()
        let blurEffect = UIBlurEffect(style: UIBlurEffect.Style.dark)
        let blurEffectView = UIVisualEffectView(effect: blurEffect)
        blurEffectView.frame = blurView.bounds
        blurEffectView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        if let blurEffectView = blurEffectView {
          addSubview(blurEffectView)
        }
    return blurView
  }
}

class BlurView : UIView {
//  @objc var color: String = "" {
//    didSet {
//      self.backgroundColor = hexStringToUIColor(hexColor: color)
//    }
//  }
//
//  func hexStringToUIColor(hexColor: String) -> UIColor {
//    let stringScanner = Scanner(string: hexColor)
//
//    if(hexColor.hasPrefix("#")) {
//      stringScanner.scanLocation = 1
//    }
//    var color: UInt32 = 0
//    stringScanner.scanHexInt32(&color)
//
//    let r = CGFloat(Int(color >> 16) & 0x000000FF)
//    let g = CGFloat(Int(color >> 8) & 0x000000FF)
//    let b = CGFloat(Int(color) & 0x000000FF)
//
//    return UIColor(red: r / 255.0, green: g / 255.0, blue: b / 255.0, alpha: 1)
//  }
}

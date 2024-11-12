import UIKit
import React

@objc(BlurView)
class BlurView: UIView {
  
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
    
    let blurEffect = UIBlurEffect(style: effect)
    blurEffectView = UIVisualEffectView(effect: blurEffect)
    blurEffectView?.frame = bounds
    blurEffectView?.autoresizingMask = [.flexibleWidth, .flexibleHeight]
    if let blurEffectView = blurEffectView {
      addSubview(blurEffectView)
    }
  }
}

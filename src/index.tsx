import {
  requireNativeComponent,
  UIManager,
  Platform,
  ViewStyle,
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-blurview' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

type BlurviewProps = {
  color: string;
  blurType: 'light' | 'dark' | 'extraLight';
  style: ViewStyle;
};

const ComponentName = 'BlurView';

export const BlurView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<BlurviewProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };

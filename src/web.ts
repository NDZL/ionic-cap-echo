import { WebPlugin } from '@capacitor/core';

import type { 
  EchoPluginPlugin,
  OpenMapOptions,
} from './definitions';

export class EchoPluginWeb extends WebPlugin implements EchoPluginPlugin {

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  
  async mirror(options: { value: string }): Promise<{ value: string }> {
    
    const reverseString = (str: string): string => [...str].reverse().join("");
    console.log('MIRROR', reverseString(options.value));
    options.value = reverseString(options.value);
    return options;
  }

  async openMap(location: OpenMapOptions): Promise<void> {
       var Y = location.latitude;
       var X = location.longitude; 
  }
}

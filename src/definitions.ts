import { Plugin } from '@capacitor/core'

export interface EchoPluginPlugin extends Plugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  mirror(options: { value: string }): Promise<{ value: string }>;
  openMap(options: OpenMapOptions): Promise<void>;
}

export interface OpenMapOptions {
    latitude: number;
    longitude: number;
}
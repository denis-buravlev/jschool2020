import { Component, OnInit } from '@angular/core';
import {Device} from '../model/device';
import {DeviceService} from '../service/device/device.service';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})
export class DevicesComponent implements OnInit {

  currentDevice: Device | null = null;
  devices: Device[] = [];

  constructor(
    private deviceService: DeviceService
  ) { }

  ngOnInit(): void {
    this.onClear();
    this.getDevices();
  }

  getDevices(): void {
    this.deviceService.getDevices().subscribe(devices => this.devices = devices);
  }

  onClear(): void {
    this.currentDevice = {
      id: null,
      name: '',
      description: ''
    };
  }

  onSetDevice(device: Device): void {
    this.currentDevice = { ...device };
  }

  onSave(device: Device): void {
    if (this.currentDevice.id) {
      this.deviceService.updateDevice(device).subscribe(() => {
        this.onClear();
        this.getDevices();
      });
    } else {
      this.deviceService.createDevice(device).subscribe(() => {
        this.onClear();
        this.getDevices();
      });
    }
  }

  onDelete(deviceId: number): void {
    this.deviceService.deleteDevice(deviceId).subscribe(() => this.getDevices());
  }

}
